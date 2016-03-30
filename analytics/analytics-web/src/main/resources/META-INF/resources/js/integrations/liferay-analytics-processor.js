;(function() {
	var ioRequest;
	var isFunction;
	var pendingFlush;
	var requestId;
	var requestInterval;
	var requestUri;
	var themeDisplayData = {};

	var LiferayAnalyticsProcessor = Liferay.Analytics.integration('LiferayAnalyticsProcessor').readyOnInitialize();

	LiferayAnalyticsProcessor.prototype._ready = true;

	LiferayAnalyticsProcessor.prototype.flush = function(callback) {
		var instance = this;

		var events = instance.getPendingEvents();

		pendingFlush = false;

		if (events.length) {
			if (ioRequest) {
				ioRequest(
					requestUri,
					{
						data: {
							context: JSON.stringify(themeDisplayData),
							events: JSON.stringify(events)
						},
						on: {
							failure: function(err) {
								console.error(err.type);
							},
							success: function() {
								if (isFunction(callback)) {
									callback();
								}
							}
						}
					}
				);

				instance.store([]);

				requestId = clearInterval(requestId);
			}
			else {
				pendingFlush = true;
			}
		}
	};

	LiferayAnalyticsProcessor.prototype.getPendingEvents = function() {
		var instance = this;

		var storedEvents = localStorage.getItem('ct-analytics-events') || '[]';

		return JSON.parse(storedEvents);
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

				isFunction = A.Lang.isFunction;
				ioRequest = A.io.request;
			}
		);
	};

	LiferayAnalyticsProcessor.prototype.store = function(events) {
		var instance = this;

		events = events || [];

		localStorage.setItem('ct-analytics-events', JSON.stringify(events));
	};

	LiferayAnalyticsProcessor.prototype.track = function(event, properties) {
		var instance = this;

		var events = instance.getPendingEvents();

		events.push(event.obj);

		instance.store(events);

		if (!requestId) {
			requestId = setTimeout(instance.flush.bind(instance), requestInterval);
		}
	};

	Liferay.Analytics.addIntegration(LiferayAnalyticsProcessor);
})();