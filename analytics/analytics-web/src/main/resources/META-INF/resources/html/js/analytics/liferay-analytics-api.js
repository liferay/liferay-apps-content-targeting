;(function() {
	var LiferayAnalytics = function(analyticsImpl, integrationImpl) {
		var _libs = {};

		var _impl = analyticsImpl;

		var _integration = integrationImpl;

		this.addIntegration = _impl.addIntegration;
		this.getIntegrations = function() {
			return _impl._integrations;
		};

		this.initialize = _impl.initialize;
		this.integration = _integration;
		this.track = _impl.track;
		this._impl = _impl;

		this.flush = function(callback) {
			var integrations = this.getIntegrations();

			var prop;

			for (prop in integrations) {
				var integration = integrations[prop];

				if (integration.flush) {
					integration.flush(callback);
				}
			}
		};
	};

	Liferay.Analytics = new LiferayAnalytics(Liferay._analytics, Liferay._integration);
})();