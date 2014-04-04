<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<#if !birthdayEnabled >
	<div class="alert alert-error">
		<strong><@liferay_ui["message"] key="this-rule-will-not-work-properly-because-the-age-field-has-been-removed" /></strong>

		<@liferay_ui["message"] key="it-can-be-enabled-in-portal-settings-users" />
	</div>
</#if>

<@aui["input"] cssClass="slider-input" inlineField=true name="olderThan" size="2" maxlength="3" value=olderThan /> <span class="slider-holder older"></span>

<@aui["input"] cssClass="slider-input" inlineField=true name="youngerThan" size="2" maxlength="3" value=youngerThan /> <span class="slider-holder younger"></span>

<@aui["script"] use="liferay-input-slider">
	new Liferay.InputSlider(
    	{
			inputNode: '#<@portlet["namespace"] />olderThan'
		}
	);

	new Liferay.InputSlider(
    	{
			inputNode: '#<@portlet["namespace"] />youngerThan'
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