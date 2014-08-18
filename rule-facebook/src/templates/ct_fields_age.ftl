<#include "init.ftl" />

<@aui["input"] cssClass="slider-input" inlineField=true label="older-than" name="fbOlderThan" size="2" maxlength="3" value=olderThan /> <span class="slider-holder older"></span>

<@aui["input"] cssClass="slider-input" inlineField=true label="younger-than" name="fbYoungerThan" size="2" maxlength="3" value=youngerThan /> <span class="slider-holder younger"></span>

<@aui["script"] use="liferay-input-slider">
	new Liferay.InputSlider(
		{
			inputNode: '#<@portlet["namespace"] />fbOlderThan'
		}
	);

	new Liferay.InputSlider(
		{
			inputNode: '#<@portlet["namespace"] />fbYoungerThan'
		}
	);
</@>

<style>
	.aui input.slider-input {
		width: auto;
	}

	.slider-holder  {
		display: inline-block;
		margin: 0 2em 0 .5em;
	}
</style>