;(function() {
	var LiferayAnalytics = function(analyticsImpl, integrationImpl) {
		var _libs = {},
			_impl = analyticsImpl,
			_integration = integrationImpl;

		this.addIntegration = _impl.addIntegration;
		this.getIntegrations = function() { return _impl._integrations; };

		this.initialize = _impl.initialize;
		this.integration = _integration;
		this.track = _impl.track;
		this._impl = _impl;

		this.flush = function(callback) {
			var integrations = this.getIntegrations(),
				integration;

			for (prop in integrations) {
				integration = integrations[prop];

				if (integration.flush) {
					integration.flush(callback);
				}
			}
		};
	};

	Liferay.Analytics = new LiferayAnalytics(Liferay._analytics, Liferay._integration);
})();