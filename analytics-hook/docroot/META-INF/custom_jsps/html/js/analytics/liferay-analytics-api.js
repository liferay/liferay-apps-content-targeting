;(function() {
	var LiferayAnalytics = function(analyticsImpl) {
		var _libs = {},
			_impl = analyticsImpl;

		this.addIntegration = _impl.addIntegration;
		this.getIntegrations = function() { return _impl._integrations; };

		this.initialize = _impl.initialize;
		this.integration = _impl.integration;
		this.track = _impl.track;

		this.flush = function() {
			var integrations = this.getIntegrations(),
				integration;

			for (prop in integrations) {
				integration = integrations[prop];

				if (integration.flush) {
					integration.flush();
				}
			}
		};
	};

	Liferay.Analytics = new LiferayAnalytics(Liferay._analytics);
})();