AUI.add(
	'liferay-thumbnails-preview',
	function(A) {
		var SELECTED_CLASSNAME = 'selected';

		var ThumbnailsPreview = A.Component.create(
			{
				ATTRS: {
					selectedIndex: {
					}
				},

				AUGMENTS: [Liferay.PortletBase],

				NAME: 'thumbnailsPreview',

				prototype: {
					initializer: function(config) {
						var instance = this;

						instance.one('#contentPreviewContainer').delegate(
							'hover',
							A.bind(instance._onContentPreviewHover, instance),
							'.content-preview'
						);
					},

					_onContentPreviewHover: function(event) {
						var instance = this;

						var index = event.currentTarget.attr('data-index');
						var selectedIndex = instance.get('selectedIndex');

						if (index == selectedIndex) {
							return;
						}

						instance.one('#FullContent' + selectedIndex).hide();
						instance.one('#PreviewContent' + selectedIndex).removeClass(SELECTED_CLASSNAME);

						var editLink = instance.one('#editLink' + selectedIndex);

						if (editLink) {
							editLink.hide();
						}

						instance.one('#FullContent' + index).show();
						instance.one('#PreviewContent' + index).addClass(SELECTED_CLASSNAME);

						editLink = instance.one('#editLink' + index);

						if (editLink) {
							editLink.show();
						}

						instance.set('selectedIndex', index);
					}
				}
			}
		);

		Liferay.ThumbnailsPreview = ThumbnailsPreview;
	},
	'',
	{
		requires: ['aui-base', 'liferay-portlet-base']
	}
);