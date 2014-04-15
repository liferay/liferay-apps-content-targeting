var events = [],
	ioRequest,
	requestId,
	requestInterval,
	requestUri,
	themeDisplayData = {},

	LiferayAnalytics = analytics.integration('LiferayAnalytics').readyOnInitialize(),

	flush = function() {
		if (events.length) {
			if (ioRequest) {
				ioRequest(
					requestUri,
					{
						data: {
							themeDisplayData: themeDisplayData,
							events: JSON.stringify(events)
						}
					}
				);

				events.length = 0;

				requestId = clearInterval(requestId);
			}
		}
	};

LiferayAnalytics.prototype.initialize = function() {
	requestInterval = this.options.interval;
	requestUri = this.options.uri;

	AUI().use(
		'aui-io-request',
		function(A) {
			A.Object.each(
				themeDisplay,
				function(item, index) {
					if (A.Lang.isFunction(item)) {
						var indexName = /^(get|is)(.*)$/.exec(index)[2];

						indexName = indexName[0].toLowerCase() + indexName.slice(1);

						themeDisplayData[indexName] = themeDisplay[index]();
					}
				}
			);

			ioRequest = A.io.request;
		}
	);
}

LiferayAnalytics.prototype.track = function(event, properties) {
	events.push(event.obj);

	if (!requestId) {
		requestId = setTimeout(flush, requestInterval);
	}
};

Liferay.Analytics = LiferayAnalytics;