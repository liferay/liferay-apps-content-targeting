AUI.add(
	'liferay-simulator',
	function(A) {
		var Lang = A.Lang;

		var Node = A.Node;

		var SELECTOR_ELEMENT = '.element';

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
						value: 6
					},
					name: {
						validator: Lang.isString
					},
					portletNamespace: {
						validator: Lang.isString
					},
					portletURL: {
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

						instance._elementsContainer = elementContainer;

						instance._createSimulatorSearch();

						instance._bindUI();
					},

					destructor: function() {
						var instance = this;

						(new A.EventHandle(instance._eventHandles)).detach();
					},

					_bindUI: function() {
						var instance = this;

						instance._eventHandles = [];

						if (instance._simulatorSearch) {
							instance._eventHandles.push(
								instance._simulatorSearch.on('results', instance._onSimulatorSearchResults, instance)
							);
						}

						var name = instance.get('name');

						if (name == 'user-segment') {
							instance._eventHandles.push(
								instance._elementsContainer.delegate('click', instance._onElementClick, '.element', instance)
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
										title: item.one('div').text()
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
								item.hide();
							}
						);
					},

					_onElementClick: function(event) {
						var instance = this;

						var element = event.target.hasClass('element') ?
							event.target : event.target.ancestor('div.element');

						var matched = element.hasClass('matched');

						if (matched) {
							element.addClass('not-matched');
							element.removeClass('matched');
						}
						else {
							element.addClass('matched');
							element.removeClass('not-matched');
						}

						var portletURL = instance.get('portletURL');

						var selectedUserSegmentIds = [];

						A.all('div.element.matched').each(
							function(elementDiv) {
								var userSegmentId = elementDiv.getData().elementid;

								selectedUserSegmentIds.push(userSegmentId);
							}
						);

						var namespacedUserSegments = instance.get('portletNamespace') + 'selectedUserSegmentIds';

						var data = {};
						data[namespacedUserSegments] = selectedUserSegmentIds;

						A.io.request(
							portletURL,
							{
								data: data,
								method: 'post',
								on: {
									success: function(event, id, obj) {
										var deviceDialog = A.one('.lfr-simulation-device > .lfr-device');

										if (deviceDialog) {
											var dialogId = deviceDialog.get('id');

											var deviceDialogWindow = Liferay.Util.getWindow(dialogId);

											deviceDialogWindow.iframe.set('uri', deviceDialogWindow.iframeConfig.uri + "&t=" + Math.random());

											deviceDialogWindow.iframe.on(
												'load',
												function() {
													instance._resetSimulator();
												}
											);
										}
									}
								}
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

								node.show();

								if (node.hasClass('matched')) {
									matchedElements.push(node);
								}
								else {
									notMatchedElements.push(node);
								}
							}
						);

						if (instance._togglerDelegate) {
							instance._togglerDelegate.expandAll(
								{
									silent: true
								}
							);
						}
					},

					_resetSimulator: function() {
						var instance = this;

						var portletURL = instance.get('portletURL');

						var stopSimulation = instance.get('portletNamespace') + 'stopSimulation';

						var data = {};
						data[stopSimulation] = true;

						A.io.request(
							portletURL,
							{
								data: data,
								method: 'post'
							}
						);
					}
				}
			}
		);

		Liferay.Simulator = Simulator;
	},
	'',
	{
		requires: ['aui-base', 'aui-io-request', 'aui-toggler', 'autocomplete-base', 'autocomplete-filters', 'liferay-portlet-base']
	}
);