<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#setting number_format="computer">

<@aui["select"] label="language" name="languageId">
	<#list locales as curLocale>
		<@aui["option"] label="${curLocale.getDisplayName(locale)}" selected=(languageId?? && (languageId == localeUtil.toLanguageId(curLocale))) value="${localeUtil.toLanguageId(curLocale)}" />
	</#list>
</@>