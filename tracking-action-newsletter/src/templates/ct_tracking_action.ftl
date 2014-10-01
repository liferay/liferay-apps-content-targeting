<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<#setting number_format="computer">

<@aui["input"] helpMessage="alias-help" label="alias" name="{ct_field_guid}alias" type="text" value=alias>
	<@aui["validator"] name="required" />
</@>

<@aui["input"] helpMessage="enter-the-id-of-the-newsletter-to-be-tracked" label="newsletter-id" name="{ct_field_guid}elementId" type="text" value=elementId>
	<@aui["validator"] name="required" />
</@>

<#if eventTypes?has_content && (eventTypes?size > 1)>
	<@aui["select"] label="tracking-action" name="{ct_field_guid}eventType">
		<#list eventTypes as curEventType>
			<@aui["option"] label="${curEventType}" selected=(eventType == curEventType) value=curEventType />
		</#list>
	</@>
<#else>
	<#list eventTypes as curEventType>
		<@aui["input"] disabled=true label="tracking-action" name="{ct_field_guid}eventType" type="text" value=curEventType />
	</#list>
</#if>

<div class="code-info" id="<@portlet["namespace"] />{ct_field_guid}imageOptions">
	<label for="<@portlet["namespace"] />{ct_field_guid}imageInfo"><@liferay_ui["message"] key="paste-this-code-at-the-beginning-of-your-newsletter" /></label>

	<@liferay_ui["input-resource"] id="{ct_field_guid}imageInfo" url="" />
</div>

<@aui["script"] use="aui-base">
	var infoTextArea = A.one('#<@portlet["namespace"] />{ct_field_guid}imageInfo');
	var newsletterInput = A.one('#<@portlet["namespace"] />{ct_field_guid}elementId');

	var trackImageURL = '${trackImageURL}';

	var showInfo = function() {
		if (newsletterInput.val()) {
			var newText = '<img alt=\"\" src=\"' + trackImageURL.replace('elementIdToken', newsletterInput.val()) + '\" />';

			infoTextArea.val(newText);
		}
	}

	newsletterInput.on('change', function(event) {showInfo();});

	showInfo();
</@>

<style>
.code-info input {
	width: 100%;
}
</style>


