;(function() {
	var events = [],
		ioRequest,
		pendingFlush,
		requestId,
		requestInterval,
		requestUri,
		themeDisplayData = {},

		LiferayAnalyticsProcessor = Liferay.Analytics.integration('LiferayAnalyticsProcessor').readyOnInitialize();

	LiferayAnalyticsProcessor.prototype._ready = true;

	LiferayAnalyticsProcessor.prototype.flush = function() {
		var instance = this;

		pendingFlush = false;

		if (events.length) {
			if (ioRequest) {
				ioRequest(
					requestUri,
					{
						data: {
							themeDisplayData: JSON.stringify(themeDisplayData),
							events: JSON.stringify(events)
						}
					}
				);

				events.length = 0;

				requestId = clearInterval(requestId);
			}
			else {
				pendingFlush = true;
			}
		}
	};

	LiferayAnalyticsProcessor.prototype.initialize = function() {
		var instance = this;

		requestInterval = instance.options.interval;
		requestUri = instance.options.uri;

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

				if (pendingFlush) {
					instance.flush();
				}
			}
		);
	}

	LiferayAnalyticsProcessor.prototype.track = function(event, properties) {
		var instance = this;

		events.push(event.obj);

		if (!requestId) {
			requestId = setTimeout(instance.flush, requestInterval);
		}
	};

	Liferay.Analytics.addIntegration(LiferayAnalyticsProcessor);
})();