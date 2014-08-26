AUI.add(
	'youtube-iframe',
	function(A) {
		var WIN = A.config.win;

		var IFRAME_API_SRC = 'https://www.youtube.com/iframe_api';

		var YoutubeIframe = A.Component.create(
			{
				ATTRS: {
				},

				EXTENDS: A.Base,

				NAME: 'youtubeiframe',

				prototype: {
					initializer: function(config) {
						var instance = this;

						WIN.onYouTubeIframeAPIReady = function() {
							instance._initializePlayers();
						};

						A.Get.js(IFRAME_API_SRC);
					},

					destructor: function() {
						var instance = this;

					},

					_initializePlayers: function() {
						var instance = this;
						var players = {};

						A.all('iframe[src*="youtube.com"]').each(
							function(ytIframe) {
								var url = ytIframe.attr('src');

								var id = ytIframe.attr('id');

								players[id] = new YT.Player(
									id,
									{
										events: {
											'onError': A.rbind(instance._onPlayerError, instance, id),
											'onReady': A.rbind(instance._onPlayerReady, instance, id),
											'onStateChange': A.rbind(instance._onPlayerStateChange, instance, id)
										}
									}
								);
							}
						);

						var states = {};

						states[YT.PlayerState.UNSTARTED] = 'unstarted';
						states[YT.PlayerState.ENDED] = 'ended';
						states[YT.PlayerState.PLAYING] = 'playing';
						states[YT.PlayerState.PAUSED] = 'paused';
						states[YT.PlayerState.BUFFERING] = 'buffering';
						states[YT.PlayerState.VIDEO_CUED] = 'video-cued';

						instance._states = states;
					},

					_onPlayerError: function(event, playerId) {
						var instance = this;

					},

					_onPlayerReady: function(event, playerId) {
						var instance = this;

					},

					_onPlayerStateChange: function(event, playerId) {
						var instance = this;

						this.fire(
							'stateChange',
							{
								playerId: playerId,
								state: instance._states[event.target.getPlayerState()]
							}
						);
					}
				}
			}
		);

		Liferay.YoutubeIframe = YoutubeIframe;
	},
	'',
	{
		requires: ['aui-base']
	}
);