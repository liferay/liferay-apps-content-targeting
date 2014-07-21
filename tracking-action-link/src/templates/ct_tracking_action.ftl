<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />

<@aui["input"] label="alias" name="{ct_field_guid}alias" type="text" value=alias />

<@aui["input"] helpMessage="enter-the-id-of-the-link-to-be-tracked" label="link-id" name="{ct_field_guid}elementId" type="text" value=elementId />

<@aui["select"] label="tracking-action" name="{ct_field_guid}eventType">
	<#list eventTypes as curEventType>
		<@aui["option"] label="${curEventType}" selected=(eventType == curEventType) value=curEventType />
	</#list>
</@>