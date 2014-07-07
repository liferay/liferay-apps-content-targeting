<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />

<@aui["input"] helpMessage="enter-the-id-of-the-form-to-be-tracked" label="form-id" name="elementId" type="text" value=elementId />

<@aui["select"] label="tracking-action" name="eventType">
	<#list eventTypes as curEventType>
		<@aui["option"] label="${curEventType}" selected=(eventType == curEventType) value=curEventType />
	</#list>
</@>