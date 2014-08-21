AUI.add(
	'liferay-simulator-search',
	function(A) {
		var Lang = A.Lang;

		var SearchImpl = A.Component.create (
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

		var SimulatorSearch = A.Component.create(
			{
				AUGMENTS: [Liferay.PortletBase],

				EXTENDS: A.Base,

				NAME: 'simulatorsearch',

				ATTRS: {
					contentPanel: {
						setter: A.one
					},
					inputNode: {
						setter: A.one
					},
					togglerDelegate: {
					}
				},

				prototype: {
					initializer: function(config) {
						var instance = this;

						instance._togglerDelegate = instance.get('togglerDelegate');

						instance._createSimulatorSearch();

						instance._bindUISearch();
					},

					_bindUISearch: function() {
						var instance = this;

						if (instance._simulatorSearch) {
							instance._simulatorSearch.on('results', instance._onSimulatorSearchResults, instance)
						}
					},


					_createSimulatorSearch: function() {
						var instance = this;

						var results = [];

						instance.get('contentPanel').all('.user-segment').each(
							function(item, index, collection) {
								results.push(
									{
										node: item,
										title: item.ancestor('.checkbox').text()
									}
								);
							}
						);

						var searchBox = instance.get('inputNode');

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

					_onSimulatorSearchResults: function(event) {
						var instance = this;

						instance.get('contentPanel').all('.user-segment').each(
							function(item, index, collection) {
								item.ancestor('.checkbox').hide();
							}
						);

						A.Array.each(
							event.results,
							function(item, index, collection) {
								item.raw.node.ancestor('.checkbox').show();
							}
						);

						if (instance._togglerDelegate) {
							instance._togglerDelegate.expandAll(
								{
									silent: true
								}
							);
						}
					}
				}
			}
		);

		Liferay.SimulatorSearch = SimulatorSearch;
	},
	'',
	{
		requires: ['aui-base', 'aui-parse-content', 'autocomplete-base', 'autocomplete-filters', 'liferay-portlet-base']
	}
);