;(function() {
	var events = [],
		ioRequest,
		requestId,
		requestInterval,
		requestUri,
		themeDisplayData = {},

		LiferayAnalyticsProcessor = Liferay.Analytics.integration('LiferayAnalyticsProcessor').readyOnInitialize();

	LiferayAnalyticsProcessor.prototype._ready = true;

	LiferayAnalyticsProcessor.prototype.flush = function() {
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

	LiferayAnalyticsProcessor.prototype.initialize = function() {
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

	LiferayAnalyticsProcessor.prototype.track = function(event, properties) {
		console.log('tracking');
		console.log(event.obj);
		events.push(event.obj);

		if (!requestId) {
			requestId = setTimeout(this.flush, requestInterval);
		}
	};

	Liferay.Analytics.addIntegration(LiferayAnalyticsProcessor);
})();