AUI.add(
	'liferay-simulator',
	function(A) {
		var Lang = A.Lang;

		var Node = A.Node;

		var SELECTOR_CHECKBOX = '.input-checkbox-wrapper';

		var SELECTOR_ELEMENT = '.element';

		var TPL_PAGINATION = '<div class="pagination"></div>';

		var SearchImpl = A.Component.create(
			{
				AUGMENTS: [A.AutoCompleteBase],

				EXTENDS: A.Base,

				NAME: 'searchimpl',

				prototype: {
					initializer: function() {
						var instance = this;

						this._bindUIACBase();
						this._syncUIACBase();
					}
				}
			}
		);

		var Simulator = A.Component.create(
			{
				ATTRS: {
					containerId: {
						validator: Lang.isString
					},
					itemsPerPage: {
						value: 10
					},
					name: {
						validator: Lang.isString
					}
				},

				AUGMENTS: [Liferay.PortletBase],

				EXTENDS: A.Base,

				NAME: 'simulator',

				prototype: {
					initializer: function(config) {
						var instance = this;

						var elementContainer = instance.byId(instance.get('containerId'));

						instance._togglerDelegate = new A.TogglerDelegate(
							{
								animated: true,
								closeAllOnExpand: false,
								container: elementContainer,
								content: '.category-content',
								expanded: true,
								header: '.category-header'
							}
						);

						instance._updatePagination(elementContainer.all('.matched'), elementContainer.all('.not-matched'));

						instance._createSimulatorSearch();

						instance._bindUI();
					},

					destructor: function() {
						var instance = this;

						(new A.EventHandle(instance._eventHandles)).detach();
					},

					_afterPaginationChangeRequest: function(event, elements) {
						var instance = this;

						var itemsPerPage = instance.get('itemsPerPage');

						var page = event.state.page - 1;

						instance._hideElements(elements);

						var start = page * itemsPerPage;

						elements.slice(start, start + itemsPerPage).each(
							function(item, index, collection) {
								item.ancestor(SELECTOR_CHECKBOX).show();
							}
						);
					},

					_bindUI: function() {
						var instance = this;

						instance._eventHandles = [];

						if (instance._simulatorSearch) {
							instance._eventHandles.push(
								instance._simulatorSearch.on('results', instance._onSimulatorSearchResults, instance)
							);
						}
					},

					_createSimulatorSearch: function() {
						var instance = this;

						var results = [];

						var elementContainer = instance.byId(instance.get('containerId'));

						elementContainer.all(SELECTOR_ELEMENT).each(
							function(item, index, collection) {
								results.push(
									{
										node: item,
										title: item.ancestor(SELECTOR_CHECKBOX).text()
									}
								);
							}
						);

						var searchBox = instance.byId('search' + instance.get('name') + 'Panel');

						if (searchBox) {
							instance._simulatorSearch = new SearchImpl(
								{
									inputNode: searchBox,
									minQueryLength: 0,
									queryDelay: 0,
									resultFilters: function(query, results) {
										query = query.toLowerCase();

										return results.filter(
											function(item) {
												var result = item.raw;

												var title = result.title.toLowerCase();

												return (title.indexOf(query) !== -1);
											}
										);
									},
									source: results
								}
							);
						}
					},

					_getTotalPages: function(totalRows, rowsPerPage) {
						var instance = this;

						return Math.ceil(totalRows / rowsPerPage);
					},

					_hideElements: function(elements) {
						elements.each(
							function(item, index, collection) {
								item.ancestor(SELECTOR_CHECKBOX).hide();
							}
						);
					},

					_onSimulatorSearchResults: function(event) {
						var instance = this;

						var elementContainer = instance.byId(instance.get('containerId'));

						instance._hideElements(elementContainer.all(SELECTOR_ELEMENT));

						var matchedElements = [];

						var notMatchedElements = [];

						A.Array.each(
							event.results,
							function(item, index, collection) {
								var node = item.raw.node;

								node.ancestor(SELECTOR_CHECKBOX).show();

								if (node.hasClass('matched')) {
									matchedElements.push(node);
								}
								else {
									notMatchedElements.push(node);
								}
							}
						);

						instance._updatePagination(new A.NodeList(matchedElements), new A.NodeList(notMatchedElements));

						if (instance._togglerDelegate) {
							instance._togglerDelegate.expandAll(
								{
									silent: true
								}
							);
						}
					},

					_refreshPagination: function(boundingBox, elements) {
						var instance = this;

						var itemsPerPage = instance.get('itemsPerPage');

						var totalPages = instance._getTotalPages(elements.size(), itemsPerPage);

						instance._hideElements(elements.slice(itemsPerPage));

						var pagination = new Liferay.Pagination(
							{
								boundingBox: boundingBox,
								circular: false,
								itemsPerPage: itemsPerPage,
								namespace: instance.NS,
								page: 1,
								results: elements.size(),
								total: totalPages,
								visible: totalPages > 1
							}
						).render();

						var paginationChangeRequestHandle = pagination.after('changeRequest', A.rbind('_afterPaginationChangeRequest', instance, elements));

						return {
							handle: paginationChangeRequestHandle,
							pagination: pagination
						};
					},

					_updatePagination: function(matchedElements, notMatchedElements) {
						var instance = this;

						if (instance._paginations) {
							A.Array.each(
								instance._paginations,
								function(item) {
									item.pagination.destroy();
									item.handle.detach();
								}
							);
						}

						instance._paginations = [];

						var paginatorMatchedContainer = instance.byId('paginator' + instance.get('name') + 'MatchedContainer');

						var matchedBoundingBox = Node.create(
							Lang.sub(
								TPL_PAGINATION
							)
						);

						paginatorMatchedContainer.append(matchedBoundingBox);

						var paginatorNotMatchedContainer = instance.byId('paginator' + instance.get('name') + 'NotMatchedContainer');

						var notMatchedBoundingBox = Node.create(
							Lang.sub(
								TPL_PAGINATION
							)
						);

						paginatorNotMatchedContainer.append(notMatchedBoundingBox);

						instance._paginations.push(instance._refreshPagination(matchedBoundingBox, matchedElements));
						instance._paginations.push(instance._refreshPagination(notMatchedBoundingBox, notMatchedElements));
					}
				}
			}
		);

		Liferay.Simulator = Simulator;
	},
	'',
	{
		requires: ['aui-base', 'aui-toggler', 'autocomplete-base', 'autocomplete-filters', 'liferay-pagination', 'liferay-portlet-base']
	}
);