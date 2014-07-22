<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#if !trackingLinkEnabled >
	<div class="alert alert-error">
		<strong><@liferay_ui["message"] key="this-tracking-action-will-not-work-properly-because-link-tracking-is-not-enabled" /></strong>

		<@liferay_ui["message"] key="it-can-be-enabled-in-portal-settings-content-targeting-analytics" />
	</div>
</#if>

<@aui["input"] label="alias" name="{ct_field_guid}alias" type="text" value=alias />

<@aui["input"] helpMessage="enter-the-id-of-the-link-to-be-tracked" label="link-id" name="{ct_field_guid}elementId" type="text" value=elementId />

<@aui["select"] label="tracking-action" name="{ct_field_guid}eventType">
	<#list eventTypes as curEventType>
		<@aui["option"] label="${curEventType}" selected=(eventType == curEventType) value=curEventType />
	</#list>
</@>