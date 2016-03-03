AUI.add(
	'liferay-input-slider',
	function(A) {
		var TPL_SLIDER = '<span class="slider-holder"></span>';

		var InputSlider = A.Component.create(
			{
				ATTRS: {
					inputNode: {
						setter: A.one
					},

					sliderNode: {
						setter: A.one
					}
				},

				EXTENDS: A.Slider,

				NAME: 'inputslider',

				prototype: {
					initializer: function(config) {
						var instance = this;

						var inputNode = instance.get('inputNode');

						var sliderNode = instance.get('sliderNode');

						if (!sliderNode) {
							sliderNode = A.Node.create(TPL_SLIDER);

							inputNode.insert(sliderNode, 'after');
						}

						instance._slider = new A.Slider(
							{
								render: sliderNode,
								value: inputNode.val()
							}
						);

						instance._bindUISlider();
					},

					destructor: function() {
						var instance = this;

						(new A.EventHandle(instance._eventHandles)).detach();
					},

					_bindUISlider: function() {
						var instance = this;

						var inputNode = instance.get('inputNode');

						instance._eventHandles = [
							inputNode.on('input', A.debounce(instance._updateSlider, 200, instance)),
							instance._slider.after('valueChange', instance._updateInput, instance)
						];
					},

					_updateInput: function(event) {
						var instance = this;

						var inputNode = instance.get('inputNode');

						inputNode.val(event.newVal);
					},

					_updateSlider: function() {
						var instance = this;

						var inputNode = instance.get('inputNode');

						var value = parseInt(inputNode.val(), 10) || 0;

						instance._slider.set('value', value);
					}
				}
			}
		);

		Liferay.InputSlider = InputSlider;
	},
	'',
	{
		requires: ['aui-base', 'aui-event-input', 'slider']
	}
);