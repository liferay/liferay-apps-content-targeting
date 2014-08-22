AUI.add(
	'liferay-thumbnails-preview',
	function(A) {
		var SELECTED_CLASSNAME = 'selected',

			ThumbnailsPreview = A.Component.create(
				{
					AUGMENTS: [Liferay.PortletBase],

					ATTRS: {
						selectedIndex: {
						}
					},

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
							var instance = this,
								selectedIndex = instance.get('selectedIndex'),
								index = event.currentTarget.attr('data-index'),
								editLink;

							if (index == selectedIndex) {
								return;
							}

							instance.one('#FullContent' + selectedIndex).hide();
							instance.one('#PreviewContent' + selectedIndex).removeClass(SELECTED_CLASSNAME);

							editLink = instance.one('#editLink' + selectedIndex)

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