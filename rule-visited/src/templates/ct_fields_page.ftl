<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<@portlet["defineObjects"] />

<#setting number_format="computer">

<#if !trackingPageEnabled >
	<div class="alert alert-error">
		<strong><@liferay_ui["message"] key="this-rule-will-not-work-properly-because-page-tracking-is-not-enabled" /></strong>

		<#assign enableLocationPortalLabel = languageUtil.get(locale, "portal-settings-content-targeting-analytics") />

		<#if portalSettingsURL??>
			<#assign enableLocationPortalLabel = "<a href=\"" + portalSettingsURL + "\">" + enableLocationPortalLabel + "</a>" />
		</#if>

		<#assign enableLocationSiteLabel = languageUtil.get(locale, "site-settings-content-targeting-analytics") />

		<#if siteSettingsURL??>
			<#assign enableLocationSiteLabel = "<a href=\"" + siteSettingsURL + "\">" + enableLocationSiteLabel + "</a>" />
		</#if>

		<#assign enableLocationLabels = [enableLocationPortalLabel, enableLocationSiteLabel] />

		${languageUtil.format(locale, "it-can-be-enabled-in-x-or-in-x", enableLocationLabels)}
	</div>
</#if>

<@aui["script"]>

function changeFriendlyURL(elementId) {

	var A = AUI();

	switch (elementId) {
		case '<@portlet["namespace"] />privatePagesSelected':
			A.one('#<@portlet["namespace"] />friendlyURL').previous().setHTML('${htmlUtil.escape(friendlyURLPrivateBase)}');
			break;

		case '<@portlet["namespace"] />publicPagesSelected':
			A.one('#<@portlet["namespace"] />friendlyURL').previous().setHTML('${htmlUtil.escape(friendlyURLPublicBase)}');
			break;
	}

}

</@>

<#if isPrivate>
	<#assign friendlyURLBase = friendlyURLPrivateBase />
<#else>
	<#assign friendlyURLBase = friendlyURLPublicBase />
</#if>

<@aui["input"] inlineField=true checked=!isPrivate id="publicPagesSelected" label="public-pages" name="isPrivate" type="radio" value=false onClick='changeFriendlyURL(this.id);'/>
<@aui["input"] inlineField=true checked=isPrivate id="privatePagesSelected" label="private-pages" name="isPrivate" type="radio" value=true onClick='changeFriendlyURL(this.id);'/>

<@aui["input"] helpMessage="enter-the-friendly-url-of-the-page-to-be-tracked" label="friendly-url" name="friendlyURL" prefix=friendlyURLBase style="width: auto;" type="text" value=friendlyURL>
	<@aui["validator"] name="required" />
</@>