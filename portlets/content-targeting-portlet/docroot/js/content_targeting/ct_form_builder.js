AUI.add(
	'liferay-ct-form-builder',
	function(A) {
		var AVAILABLE_FIELD_LABEL_TPL = '<div class="row"><div class="rule-title">{name}</div><div class="rule-description">{description}</div></div>',

			FIELD_LABEL_TPL = '{name}',

			RULE_FIELD_TPL = '<div>' +
				'<div class="rule-header">' +
					'<div class="rule-icon">' +
						'<i class="{icon}"></i>' +
					'</div>' +
					'<div class="row rule-info">' +
						'<div class="rule-title">{name}</div>' +
						'<div class="rule-description">{description}</div>' +
					'</div>' +
				'</div>' +
				'<div class="rule-editor">{editor}</div>' +
			'</div>',

			LiferayCTFormRuleSearch = A.Base.create('ruleSearch', A.Base, [A.AutoCompleteBase],
				{
					initializer: function () {
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
								rulesFilter;

							instance._parseFields();

							if (instance.get('searchBox')) {
								rulesFilter = instance._createRuleFilter();

								eventHandles.push(
									rulesFilter.on('results', instance._onRuleFilterResults, instance)
								);
							}

							instance.after(instance._afterUiSetAvailableFields, instance, '_uiSetAvailableFields');

							instance._eventHandles = eventHandles;
						},

						destructor: function() {
							var instance = this;

							(new A.EventHandle(instance._eventHandles)).detach();
						},

						_afterUiSetAvailableFields: function(event) {
							var instance = this,
								searchBox = instance.get('searchBox');

							if (searchBox) {
								A.one('.tab-pane.active').insertBefore(
									searchBox,
									A.one('.diagram-builder-fields-container')
								).removeClass('hide');
							}
						},

						_createRuleFilter: function() {
							var instance = this,
								ruleSearch = new LiferayCTFormRuleSearch
								(
									{
										inputNode: instance.get('searchBox').one('input'),
										minQueryLength: 0,
										queryDelay: 0,

										source: (function () {
											return A.Array.map(
												instance.get('availableFields'),
												function(field) {
													return {
														node: field.labelNode,
														searchData: field.labelNode.one('.rule-title').text()
													}
												}
											);
										}()),

										resultTextLocator: 'searchData',

										resultFilters: 'phraseMatch'
									}
								);

							return ruleSearch;
						},

						_onClickField: function(event) {
							var instance = this,
								field = A.Widget.getByNode(event.target);

							instance.simulateFocusField(field, event.target);

							event.stopPropagation();
						},

						_onRuleFilterResults: function(event) {
							var instance = this;

							A.all('.diagram-builder-field').addClass('hide');

							A.Array.each(
								event.results,
								function (result) {
									result.raw.node.ancestor('.diagram-builder-field').removeClass('hide');
								}
							);
						},

						_parseFields: function() {
							var instance = this,
								contentBox = instance.get('contentBox'),
								availableFieldsContainer = contentBox.one('.diagram-builder-fields-container'),
								availableFields = [],
								fieldsContainer = contentBox.one('.form-builder-drop-container'),
								fields = [];

							if (availableFieldsContainer) {
								availableFields = instance._parseFieldContainer(availableFieldsContainer, AVAILABLE_FIELD_LABEL_TPL);
							}

							if (fieldsContainer) {
								fields = instance._parseFieldContainer(fieldsContainer, FIELD_LABEL_TPL);
							}

							instance.set('availableFields', availableFields);
							instance.set('fields', fields);
						},

						_parseFieldContainer: function(fieldsContainer, labelTpl) {
							var instance = this,
								fields = [];

							fieldsContainer.all('.form-builder-field').each(
								function(field) {
									var description = field.one('.rule-description').text(),
										editor = field.attr('data-template'),
										icon = field.attr('data-icon'),
										key = field.attr('data-key'),
										name = field.one('.rule-title').text(),
										unique = field.attr('data-unique') === 'true';

									A.LiferayCTFormBuilder.registerField(
										{
											description: description,
											editor: editor,
											icon: icon,
											key: key,
											name: name
										}
									);

									fields.push(
										{
											iconClass: icon,
											id: /^([^_]*)(_.*)?$/.exec(key)[1],
											label: A.Lang.sub(
												labelTpl,
												{
													name: name,
													description: description
												}
											),
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
								userSegment = {
									rules: []
								};

							instance.get('fields').each(
								function(item) {
									var rule = {
										id: item.get('id'),
										data: [],
										type: item.get('type')
									};

									var contentBox = item.get('contentBox');

									contentBox.all('input, select, textarea').each(
										function(input) {
											rule.data.push(
												{
													name: input.attr('name'),
													value: input.val()
												}
											);
										}
									);

									userSegment.rules.push(rule);
								}
							);

							return JSON.stringify(userSegment);
						},

						simulateFocusField: function(field, target) {
							var instance = this,
								lastFocusedField = instance.lastFocusedField;

							if (lastFocusedField) {
								lastFocusedField.blur();
							}

							instance.lastFocusedField = field.focus();

							if (target) {
								target.focus();
							}
						}
					}
				}
			);

		LiferayCTFormBuilder.registerField = function(field) {
			var fieldName = 'ct-' + field.key + '-rule-field';

			var ctFormField = A.Component.create(
				{
					NAME: fieldName,

					EXTENDS: A.FormBuilderField,

					ATTRS: {
						acceptChildren: {
							readOnly: true,
							value: false
						}
					},

					prototype: {
						getHTML: function() {
							var instance = this;

							return A.Lang.sub(
								RULE_FIELD_TPL,
								{
									description: field.description,
									editor: field.editor,
									icon: field.icon,
									name: field.name
								}
							);
						},

						getNode: function(){
							var instance = this,
								templateContainer = A.Node.create('<div></div>');

							templateContainer.plug(A.Plugin.ParseContent);
							templateContainer.setContent(instance.getHTML());

							return templateContainer;
						}
					}
				}
			);

			A['CT'+ field.key + 'RuleField'] = ctFormField;

			if (!A.FormBuilder.types[field.key]) {
				A.FormBuilder.types[field.key] = ctFormField;
			}
		};

		A.LiferayCTFormBuilder = LiferayCTFormBuilder;
	},
	'',
	{
		requires: ['aui-form-builder', 'autocomplete-base', 'autocomplete-filters']
	}
);