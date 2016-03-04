AUI.add(
	'liferay-ct-form-builder',
	function(A) {
		var AVAILABLE_FIELD_LABEL_TPL = '<div class="row"><div class="field-title">{name}</div><div class="field-description">{shortDescription}</div></div>',

			FIELD_LABEL_TPL = '{name}',

			ITEM_FIELD_TPL = '<div>' +
				'<div class="field-header toggler-header-collapsed">' +
					'<div class="field-icon">' +
						'<i class="{icon}"></i>' +
					'</div>' +
					'<div class="row field-info">' +
						'<div class="field-title">{name}</div>' +
						'<div class="field-description">' +
							'<span class="field-description-alias">{description}</span>' +
							'<span class="field-description-info"></span>' +
						'</div>' +
					'</div>' +
				'</div>' +
				'<div class="field-editor toggler-content-collapsed">{editor}</div>' +
			'</div>',

			ITEM_CATEGORY_HEADER_TPL = '<div class="category-header toggler-header toggler-header-collapsed">' +
				'<span class="category-icon icon {icon}"></span>' +
				'<div class="category-info"> ' +
					'<div class="category-title">{name}</div>' +
					'<div class="category-description">{description}</div>' +
				'</div>' +
			'</div>',

			ITEM_CATEGORY_CONTENT_TPL = '<div class="category-content toggler-content toggler-content-collapsed"></div>',

			LiferayCTFormItemSearch = A.Base.create('Search', A.Base, [A.AutoCompleteBase],
				{
					initializer: function() {
						this._bindUIACBase();
						this._syncUIACBase();
					}
				}
			),

			LiferayCTFormBuilder = A.Component.create(
				{
					EXTENDS: A.FormBuilder,

					NAME: 'liferay-ct-form-builder',

					ATTRS: {
						searchBox: {
							setter: A.one
						}
					},

					prototype: {
						initializer: function() {
							var instance = this,
								eventHandles = [],
								fieldsFilter;

							instance._parseFields();

							if (instance.get('searchBox')) {
								//fieldsFilter = instance._createItemFilter();

								eventHandles.push(
									//fieldsFilter.on('results', instance._onItemFilterResults, instance),
									instance.on('fieldsChange', instance._onFieldsChange, instance),
									instance.on({
										'drag:mouseDown': instance._onDragMouseDown,
										'drag:start': function() {
											Liferay.fire('fieldDragStart');
										},
										'drag:end': function() {
											Liferay.fire('fieldDragEnd');
										}
									}),
									A.Do.before('_beforeInsertField', instance, 'addField', instance),
									A.Do.after('_onInsertField', instance, 'addField', instance),
									A.Do.after('_onRemoveField', instance, 'removeField', instance)
								);
							}

							instance.onceAfter(instance._afterUiSetAvailableFields, instance, '_uiSetAvailableFields');

							instance._eventHandles = eventHandles;
						},

						destructor: function() {
							var instance = this;

							(new A.EventHandle(instance._eventHandles)).detach();
						},

						_afterUiSetAvailableFields: function(event) {
							var instance = this,
								fieldsContainer = A.one('.property-builder-fields-container'),
								searchBox = instance.get('searchBox');

							if (searchBox) {
								A.one('.tab-pane.active').insertBefore(
									searchBox,
									fieldsContainer
								).removeClass('hide');
							}

							var categories = {};

							A.Array.each(
								instance.get('availableFields'),
								function(item) {
									item.labelNode.setContent(item.get('label'));

									var title = item.labelNode.one('.field-title').text();

									var itemNode = item.get('node');

									itemNode.attr('title', title);

									var category = item.get('options').category;

									var categoryKey = category.key;

									if (category && categoryKey) {
										if (!categories[categoryKey]) {
											categories[categoryKey] = {
												category: category,
												fields: []
											};
										}

										categories[categoryKey].fields.push(itemNode);
									}

									itemNode.detach('dblclick');
									itemNode.on(
										'dblclick',
										function() {
											var config = {
												hiddenAttributes: item.get('hiddenAttributes'),
												label: item.get('label'),
												localizationMap: item.get('localizationMap'),
												options: item.get('options'),
												predefinedValue: item.get('predefinedValue'),
												readOnlyAttributes: item.get('readOnlyAttributes'),
												required: item.get('required'),
												showLabel: item.get('showLabel'),
												tip: item.get('tip'),
												type: item.get('type'),
												unique: item.get('unique'),
												width: item.get('width')
											};

											if (config.unique) {
												config.id = instance._getFieldId(item);
												config.name = item.get('name');
											}

											if ((item instanceof A.PropertyBuilderAvailableField) && !item.get('draggable')) {
												return;
											}

											var newField = instance.createField(config);

											instance.addField(newField, 0);
										}
									);
								}
							);

							instance._groupFields(categories, fieldsContainer);

							if (!instance._doNothing) {

								var togglerDelegate = new A.TogglerDelegate(
									{
										animated: true,
										closeAllOnExpand: true,
										container: A.one('.property-builder-drop-container'),
										content: '.field-editor',
										expanded: false,
										header: '.field-header',
										toggleEvent: 'click',
										transition: {
											duration: 0.2,
											easing: 'cubic-bezier(0, 0.1, 0, 1)'
										}
									}
								);

								A.Do.before(
									function (header) {
										Liferay.fire(
											'beforeTogglerCreate',
											{
												header: header
											}
										)
									},
									togglerDelegate,
									'_create'
								);

								A.Do.after(
									function (header) {
										Liferay.fire(
											'afterTogglerCreate',
											{
												toggler: A.Do.originalRetVal,
												header: header
											}
										)
									},
									togglerDelegate,
									'_create'
								);

								instance.set('fieldsTogglerDelegate', togglerDelegate);

								Liferay.after(
									'form:registered',
									function (data) {
										togglerDelegate.createAll();

										var formValidator = data.form.formValidator;

										if (formValidator) {
											A.Do.after(
												function () {
													for (var errorFieldName in formValidator.errors) {
														var fieldToggler = A.one('#' + errorFieldName).ancestor('.form-builder-field-content').one('.field-header').getData().toggler;

														if (fieldToggler) {
															fieldToggler.expand();
														}
													}
												},
												formValidator,
												'validate'
											);
										}

										A.on(
											'domready',
											function () {
												var fieldHeader = A.one('.field-header');

												if (fieldHeader) {
													fieldHeader.getData().toggler.expand();
												}
											}
										);
									}
								);

								instance._doNothing = true;
							}

						},

						_beforeInsertField: function(field) {
							Liferay.fire('beforeInsertField');
						},

						_createItemFilter: function() {
							var instance = this,
								fieldSearch = new LiferayCTFormItemSearch
								(
									{
										inputNode: instance.get('searchBox').one('input'),
										minQueryLength: 0,
										queryDelay: 0,

										source: (function() {
											return A.Array.map(
												instance.get('availableFields'),
												function(field) {
													return {
														node: field.labelNode,
														searchData: field.labelNode.one('.field-title').text()
													};
												}
											);
										}()),

										resultTextLocator: 'searchData',

										resultFilters: 'phraseMatch'
									}
								);

							return fieldSearch;
						},

						_groupFields: function(categories, fieldsContainer) {
							var instance = this,
								categoryContent,
								categoryHeader,
								categoryWrapper;

							A.Object.each(
								categories,
								function(item) {
									categoryHeader = A.Node.create(
										A.Lang.sub(
											ITEM_CATEGORY_HEADER_TPL,
											{
												description: item.category.description,
												icon: item.category.icon,
												name: item.category.name
											}
										)
									);

									categoryContent = A.Node.create(
										A.Lang.sub(
											ITEM_CATEGORY_CONTENT_TPL
										)
									);

									A.Array.each(
										item.fields,
										function(field) {
											categoryContent.append(field);
										}
									);

									categoryWrapper = A.Node.create('<div class="category-wrapper"></div>');
									categoryWrapper.append(categoryHeader);
									categoryWrapper.append(categoryContent);

									fieldsContainer.append(categoryWrapper);
								}
							);

							if (!instance._togglerDelegate) {
								instance._togglerDelegate = new A.TogglerDelegate(
									{
										animated: true,
										closeAllOnExpand: true,
										container: fieldsContainer,
										content: '.category-content',
										expanded: true,
										header: '.category-header'
									}
								);
							}
						},

						_onClickField: function(event) {
							var instance = this,
								field = A.Widget.getByNode(event.target);

							instance.simulateFocusField(field, event.target, true);

							event.stopPropagation();
						},

						_onDragMouseDown: function(event) {
							var dragNode = event.target.get('node'),
								availableField = A.PropertyBuilderAvailableField.getAvailableFieldByNode(dragNode);

							if ((availableField instanceof A.PropertyBuilderAvailableField) && !availableField.get('draggable')) {
								event.halt();

								return;
							}

							var mouseDownNode = event.ev.target;

							if (mouseDownNode.hasClass('toggler-content-wrapper') || mouseDownNode.hasClass('field-editor')) {
								event.halt();

								return;
							}

							var fieldEditor = mouseDownNode.ancestor('.field-editor');

							if (fieldEditor) {
								event.halt();

								return;
							}
						},

						_onFieldsChange: function(event) {
							var instance = this;

							instance.get('canvas').toggleClass('has-items', instance.get('fields').size());
							instance.get('canvas').one('.alert-no-items').toggleClass('hide', instance.get('fields').size());
						},

						_onInsertField: function(field) {
							var instance = this;

							field.get('labelNode').setContent('');

							var togglerDelegate = instance.get('fieldsTogglerDelegate');

							var fieldBox = field.get('contentBox');
							var fieldEditor = fieldBox.one('.field-editor');
							var fieldHeader = fieldBox.one('.field-header');

							if (!fieldEditor || !fieldHeader) {
								return;
							}

							togglerDelegate.collapseAll();

							var toggler = fieldHeader.getData().toggler;

							if (toggler) {
								toggler.expand();
							}

							instance.simulateFocusField(field, field.get('boundingBox'));
						},

						_onItemFilterResults: function(event) {
							var instance = this,
								contentBox = instance.get('contentBox'),
								availableFieldsContainer = contentBox.one('.property-builder-fields-container'),
								categories = availableFieldsContainer.all('.category-wrapper'),
								query = event.query;

							if (!instance._collapsedCategories) {
								instance._collapsedCategories = [];

								categories.each(
									function(item, index) {
										var header = item.one('.toggler-header');

										if (header && header.hasClass('toggler-header-collapsed')) {
											instance._collapsedCategories.push(item);
										}
									}
								);
							}

							if (!query) {
								availableFieldsContainer.all('.category-wrapper, .property-builder-field').removeClass('hide');

								if (instance._collapsedCategories) {
									A.each(
										instance._collapsedCategories,
										function(item, index) {
											var categoryIndex = categories.indexOf(item);

											var togglerItems = instance._togglerDelegate.items;

											togglerItems[categoryIndex].collapse(
												{
													silent: true
												}
											);
										}
									);

									instance._collapsedCategories = null;
								}
							}
							else {
								availableFieldsContainer.all('.category-wrapper, .property-builder-field').addClass('hide');

								A.Array.each(
									event.results,
									function(result) {
										result.raw.node.ancestor('.property-builder-field').removeClass('hide');

										var category = result.raw.node.ancestor('.category-wrapper');

										if (category) {
											category.removeClass('hide');
										}
									}
								);

								instance._togglerDelegate.expandAll(
									{
										silent: true
									}
								);
							}
						},

						_parseFields: function() {
							var instance = this,
								contentBox = instance.get('contentBox'),
								availableFieldsContainer = contentBox.one('.property-builder-fields-container'),
								availableFields = [],
								fieldsContainer = contentBox.one('.form-builder-drop-container'),
								fields = [];

							if (availableFieldsContainer) {
								availableFields = instance._parseFieldContainer(availableFieldsContainer, AVAILABLE_FIELD_LABEL_TPL, false);
							}

							if (fieldsContainer) {
								fields = instance._parseFieldContainer(fieldsContainer, FIELD_LABEL_TPL, true);
							}

							instance.set('availableFields', availableFields);
							instance.set('fields', fields);
						},

						_parseFieldContainer: function(fieldsContainer, labelTpl, checkCollapsed) {
							var instance = this,
								fields = [];

							fieldsContainer.all('.form-builder-field').each(
								function(field) {
									var categoryDescription = field.attr('data-categorydescription'),
										categoryIcon = field.attr('data-categoryicon'),
										categoryKey = field.attr('data-categorykey'),
										categoryName = field.attr('data-categoryname'),
										description = field.one('.field-description').text(),
										editor = field.attr('data-template'),
										icon = field.attr('data-icon'),
										key = field.attr('data-key'),
										fieldData = /^([^_]*)(?:_(.*))?$/.exec(key),
										name = field.one('.field-title').text(),
										shortDescription = field.one('.field-short-description').text(),
										unique = field.attr('data-unique') === 'true',
										cssCollapseClass = 'collapsed';

									if (checkCollapsed && fields.length == 0) {
										cssCollapseClass = 'expanded';
									}

									A.LiferayCTFormBuilder.registerField(
										{
											cssCollapseClass: cssCollapseClass,
											description: description,
											editor: editor,
											icon: icon,
											id: fieldData[2] ? key : '',
											key: key,
											name: name,
											shortDescription: shortDescription,
											unique: unique
										}
									);

									fields.push(
										{
											iconClass: icon,
											id: fieldData[1],
											label: A.Lang.sub(
												labelTpl,
												{
													name: name,
													description: description,
													shortDescription: shortDescription
												}
											),
											options: {
												category: {
													description: categoryDescription,
													icon: categoryIcon,
													key: categoryKey,
													name: categoryName
												}
											},
											type: key,
											unique: unique
										}
									);
								}
							);

							return fields;
						},

						exportAsJSON: function() {
							var instance = this,
								fields = {
									fields: []
								};

							instance.get('fields').each(
								function(item) {
									var field = {
										id: item.get('fieldId'),
										data: [],
										type: item.get('type')
									};

									var contentBox = item.get('contentBox');

									contentBox.all('input, select, textarea').each(
										function(input) {
											if (input.attr('type') !== 'radio' || input.attr('checked')) {
												field.data.push(
													{
														name: input.attr('name'),
														value: input.val()
													}
												);
											}
										}
									);

									fields.fields.push(field);
								}
							);

							return JSON.stringify(fields);
						},

						_onRemoveField: function(field) {
							var instance = this;

							var fields = instance.get('fields');

							if (fields.size() > 0) {
								var firstField = fields.item(0);
								instance.simulateFocusField(firstField, firstField.get('boundingBox'));
							}
						},

						simulateFocusField: function(field, target, onClick) {
							var instance = this,
								lastFocusedField = instance.lastFocusedField;

							var togglerDelegate = instance.get('fieldsTogglerDelegate');

							var fieldId = field.get('fieldId');

							if (!fieldId) {
								field = A.Widget.getByNode(A.one(field.get('boundingBox').ancestor()));
							}

							var fieldBox = field.get('contentBox');
							var fieldEditor = fieldBox.one('.field-editor');
							var fieldHeader = fieldBox.one('.field-header');

							var assignLastFocus = true;

							if (!fieldEditor || !fieldHeader) {
								assignLastFocus = false;
							}

							if (assignLastFocus && onClick && field !== lastFocusedField) {
								if (lastFocusedField) lastFocusedField.blur();

								instance.lastFocusedField = field.focus();
							}
							else if (assignLastFocus && !onClick) {
								var element = fieldEditor.one('input, select, textarea, button');

								if (element !== lastFocusedField) {
									if (element) {
										element.blur();

										instance.lastFocusedField = element.focus();
									}
								}
							}

							if (target.getDOMNode() !== document.activeElement) {
								target.focus();
							}

							var lastClickTarget = field.get('lastClickTarget');

							if (lastClickTarget && lastClickTarget !== target) {
								var id = lastClickTarget.get('id');

								var picker = Liferay.component(id + 'TimePicker') || Liferay.component(id + 'DatePicker');

								if (picker) {
									picker.getPopover().hide();
								}
							}

							if (field && target) {
								field.set('lastClickTarget', target);
							}
						}
					}
				}
			);

		LiferayCTFormBuilder.registerField = function(field) {
			var fieldName = 'ct-' + field.key + '-field-field';

			var ctFormField = A.Component.create(
				{
					NAME: fieldName,

					EXTENDS: A.FormBuilderField,

					ATTRS: {
						acceptChildren: {
							readOnly: true,
							value: false
						},

						fieldId: {
							value: field.id
						},

						unique: {
							value: field.unique
						}
					},

					prototype: {
						getHTML: function() {
							var instance = this;

							var fieldId = instance.get('fieldId') || A.guid();

							instance.set('fieldId', fieldId);

							return A.Lang.sub(
								ITEM_FIELD_TPL,
								{
									cssCollapseClass: field.cssCollapseClass,
									description: field.description,
									editor: field.editor.replace(/(\-|_7b_|[\{%7B&#x25;]+)ct_+field_+guid(\-|_7d_|[\}%7D&#x25;]+)/ig, fieldId),
									icon: field.icon,
									name: field.name,
									shortDescription: field.shortDescription
								}
							);
						},

						getNode: function() {
							var instance = this,
								templateContainer = A.Node.create('<div></div>');

							templateContainer.plug(A.Plugin.ParseContent);
							templateContainer.setContent(instance.getHTML());

							return templateContainer;
						}
					}
				}
			);

			A['CT'+ field.key + 'ItemField'] = ctFormField;

			if (!A.FormBuilderField[field.key]) {
				A.FormBuilderField.types[field.key] = ctFormField;
			}
		};

		A.LiferayCTFormBuilder = LiferayCTFormBuilder;
	},
	'',
	{
		requires: ['aui-form-builder-deprecated', 'aui-parse-content', 'aui-toggler', 'autocomplete-base', 'autocomplete-filters']
	}
);