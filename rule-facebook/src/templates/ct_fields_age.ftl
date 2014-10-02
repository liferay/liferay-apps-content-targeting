<#include "init.ftl" />

<@aui["input"] cssClass="slider-input" inlineField=true label="older-than" maxlength="3" name="fbOlderThan" size="2" value=fbOlderThan /> <span class="older slider-holder"></span>

<@aui["input"] cssClass="slider-input" inlineField=true label="younger-than" maxlength="3" name="fbYoungerThan" size="2" value=fbYoungerThan /> <span class="slider-holder younger"></span>

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