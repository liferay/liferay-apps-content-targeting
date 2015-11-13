AUI.add(
	'liferay-ajax-search',
	function(A) {
		var Lang = A.Lang;

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

		var AjaxSearch = A.Component.create(
			{
				ATTRS: {
					minQueryLength: {
						validator: Lang.isNumber,
						value: 0
					},

					queryDelay: {
						validator: Lang.isNumber,
						value: 300
					},

					resultFilters: {
						setter: '_setResultFilters',
						value: 'phraseMatch'
					},

					resultTextLocator: {
						setter: '_setLocator',
						value: 'search'
					}
				},

				EXTENDS: SearchImpl,

				NAME: 'ajaxsearch'
			}
		);

		var AjaxContentSearch = A.Component.create(
			{
				ATTRS: {
					contentPanel: {
						setter: A.one
					},
					inputNode: {
						setter: A.one
					},
					resourceURL: {
						validator: Lang.isString
					}
				},

				AUGMENTS: [Liferay.PortletBase],

				EXTENDS: A.Base,

				NAME: 'ajaxcontentsearch',

				prototype: {
					initializer: function(config) {
						var instance = this;

						var contentSearch = new AjaxSearch(
							{
								inputNode: instance.get('inputNode')
							}
						);

						instance._contentPanel = instance.get('contentPanel');
						instance._resourceURL = instance.get('resourceURL');

						instance._search = contentSearch;

						instance._bindUISearch();
					},

					_afterSuccess: function(event) {
						var instance = this;

						instance._contentPanel.plug(A.Plugin.ParseContent);

						instance._contentPanel.setContent(event.currentTarget.get('responseData'));
					},

					_bindUISearch: function() {
						var instance = this;

						instance._search.after('query', instance._refreshContentList, instance);
					},

					_refreshContentList: function(event) {
						var instance = this;

						var ajaxData = {};

						ajaxData[instance.get('inputNode').get('name')] = instance.get('inputNode').val();

						A.io.request(
							instance._resourceURL,
							{
								after: {
									success: A.bind('_afterSuccess', instance)
								},
								data: ajaxData
							}
						);
					}
				}
			}
		);

		Liferay.AjaxContentSearch = AjaxContentSearch;
		Liferay.AjaxSearch = AjaxSearch;
	},
	'',
	{
		requires: ['aui-base', 'aui-io-request', 'aui-parse-content', 'autocomplete-base', 'autocomplete-filters', 'liferay-portlet-base']
	}
);