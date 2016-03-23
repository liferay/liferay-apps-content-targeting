AUI.add(
	'liferay-thumbnails-preview',
	function(A) {
		var ACTIVE_CLASSNAME = 'active';

		var ThumbnailsPreview = A.Component.create(
			{
				ATTRS: {
					popover: {
					},
					previewIndex: {
					},
					resourceURL: {
					},
					selectedIndex: {
					}
				},

				AUGMENTS: [Liferay.PortletBase],

				NAME: 'thumbnailsPreview',

				prototype: {
					initializer: function(config) {
						var instance = this;

						var contentPreviewContainer = instance.one('#contentPreviewContainer');

						instance.set('previewIndex', instance.get('selectedIndex'));

						if (contentPreviewContainer) {
							contentPreviewContainer.delegate(
								'tap',
								A.bind(instance._onContentPreviewTap, instance),
								'.content-preview-link'
							);
						}
					},

					_onContentPreviewTap: function(event) {
						var instance = this;

						var index = event.currentTarget.ancestor('li').attr('data-index');
						var previewIndex = instance.get('previewIndex');
						var selectedIndex = instance.get('selectedIndex');

						var selectedFullContent = instance.one('#FullContent' + selectedIndex);
						var previewContent = instance.one('#FullContentHidden' + index);

						instance.one('#PreviewContent' + previewIndex).removeClass(ACTIVE_CLASSNAME);
						instance.one('#PreviewContent' + index).addClass(ACTIVE_CLASSNAME);

						selectedFullContent.html(previewContent.html());

						instance.set('previewIndex', index);
					}
				}
			}
		);

		Liferay.ThumbnailsPreview = ThumbnailsPreview;
	},
	'',
	{
		requires: ['aui-base', 'aui-popover', 'event-hover', 'liferay-portlet-base', 'widget-anim']
	}
);