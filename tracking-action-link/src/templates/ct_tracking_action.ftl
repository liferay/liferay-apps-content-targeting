<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />

<@aui["input"] name="alias" type="text" value=alias />

<@aui["input"] helpMessage="enter-the-id-of-the-link-to-be-tracked" label="link-id" name="elementId" type="text" value=elementId />

<@aui["select"] label="tracking-action" name="eventType">
	<#list eventTypes as curEventType>
		<@aui["option"] label="${curEventType}" selected=(eventType == curEventType) value=curEventType />
	</#list>
</@>