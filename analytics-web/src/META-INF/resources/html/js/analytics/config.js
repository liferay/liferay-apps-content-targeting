;(function() {
	var PATH_ANALYTICS_WEB = Liferay.ThemeDisplay.getPathContext() + '/o/analytics-web';

	AUI().applyConfig(
		{
			groups: {
				analytics: {
					base: PATH_ANALYTICS_WEB + '/html/js/analytics/',
					modules: {
						'analytics': {
							path: 'analytics.min.js',
							requires: []
						},
						'liferay-analytics': {
							path: 'liferay-analytics-api.js',
							requires: []
						},
						'liferay-analytics-processor': {
							path: 'integrations/liferay-analytics-processor.js',
							requires: []
						},
						'youtube_iframe': {
							path: 'integrations/youtube_iframe.js',
							requires: []
						}
					},
					root: PATH_ANALYTICS_WEB + '/html/js/analytics/'
				}
			}
		}
	);
})();