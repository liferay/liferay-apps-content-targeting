<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#setting number_format="computer">

<@aui["input"] inlineField=true label="from" name="ipFrom" placeholder="192.0.0.1" value=ipFrom>
	<@aui["validator"] errorMessage="invalid-ip-format" name="custom">
		function(val, fieldNode, ruleValue) {
			return validateIpAddress(val);
		}
	</@>
</@>

<@aui["input"] inlineField=true label="to" name="ipTo" placeholder="192.0.0.255" value=ipTo>
	<@aui["validator"] errorMessage="invalid-ip-format" name="custom">
		function(val, fieldNode, ruleValue) {
			return validateIpAddress(val);
		}
	</@>
</@>

<@aui["script"]>
	function validateIpAddress(ipAddress) {
		var IPV4 = /^(?:[0-9]{1,3}\.){3}[0-9]{1,3}$/;
		var IPV6 = /^(?:[A-F0-9]{1,4}:){7}[A-F0-9]{1,4}$/;

		if (ipAddress.match(IPV4) || ipAddress.match(IPV6)) {
			return true;
		}
		else {
			return false;
		}
	}
</@>