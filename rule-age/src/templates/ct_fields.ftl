<#--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
-->

<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<#setting number_format="computer">

<#if !birthdayEnabled >
	<div class="alert alert-error">
		<strong><@liferay_ui["message"] key="this-rule-will-not-work-properly-because-the-age-field-has-been-removed" /></strong>

		<#assign enableLocationLabel = languageUtil.get(locale, "portal-settings-users") />

		<#if portalSettingsURL??>
			<#assign enableLocationLabel = "<a href=\"" + portalSettingsURL + "\">" + enableLocationLabel + "</a>" />
		</#if>

		<@liferay_ui["message"] arguments=enableLocationLabel key="it-can-be-enabled-in-x" />
	</div>
</#if>

<@aui["input"] cssClass="slider-input" inlineField=true name="olderThan" size="2" maxlength="3" value=olderThan />

<span class="slider-holder older"></span>

<@aui["input"] cssClass="slider-input" inlineField=true name="youngerThan" size="2" maxlength="3" value=youngerThan>
	<@aui["validator"] errorMessage="the-age-range-is-invalid" name="custom">
		function(val, fieldNode, ruleValue) {
			if (!val) {
				return false;
			}

			var olderThan = A.one('#<@portlet["namespace"] />olderThan');

			if (!olderThan.val()) {
				return false;
			}

			var youngerThanValue = parseInt(val);
			var olderThanValue = parseInt(olderThan.val());

			return (olderThanValue < youngerThanValue);
		}
	</@>
</@>

<span class="slider-holder younger"></span>

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