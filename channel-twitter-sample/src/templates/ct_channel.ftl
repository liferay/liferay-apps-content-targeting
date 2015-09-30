<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#setting number_format="computer">

<#if !consumers?has_content >
	<div class="alert alert-warning">
		<strong><@liferay_ui["message"] key="there-are-no-twitter-applications-available" /></strong>
	</div>
<#else>
	<@aui["select"] label="twitter-application" name="{ct_field_guid}consumerId">
		<#list consumers as curConsumer>
			<@aui["option"] label="${curConsumer.getName()}" selected=(curConsumer.getConsumerId() == consumerId) value=curConsumer.getConsumerId() />
		</#list>
	</@>

	<@aui["input"] label="message" name="{ct_field_guid}message" type="textarea" value=message>
		<@aui["validator"] name="required" />
	</@>
</#if>