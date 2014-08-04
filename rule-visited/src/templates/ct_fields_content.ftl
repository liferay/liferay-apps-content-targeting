<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<#if !trackingContentEnabled>
	<div class="alert alert-warning">
		<@liferay_ui["message"] key="analytics-are-disabled-for-content" />
	</div>
<#else>
	<div class="select-asset-selector">
		<#assign cssClass = "">

		<#if (assetEntryId <= 0)>
			<#assign cssClass = "hide">
		</#if>

		<@aui["input"] name="assetEntryId" type="hidden" value=assetEntryId />

		<div class="asset-preview ${cssClass}" id="<@portlet["namespace"] />assetPreview">
			<@aui["column"]>
				<img class="asset-image" id="<@portlet["namespace"] />assetImage" src="${assetImage}" />
			</@>
			<@aui["column"]>
				<div class="asset-title" id="<@portlet["namespace"] />assetTitleInfo">${assetTitle}</div>
				<div class="asset-type" id="<@portlet["namespace"] />assetTypeInfo"><@liferay_ui["message"] key="type" />: ${assetType}</div>
			</@>
		</div>

		<div class="lfr-meta-actions edit-controls">
			<@liferay_ui["icon-menu"] cssClass="select-existing-selector" direction="right" icon="${themeDisplay.getPathThemeImages()}/common/add.png" message=languageUtil.get(locale, "select-content") showWhenSingleIcon=true>
				<#list assetRendererFactories as assetRendererFactory>
					<@liferay_ui["icon"]
						cssClass="asset-selector"
						data=visitedRuleUtilClass.getAssetSelectorIconData(request, assetRendererFactory)
						id="groupId_${assetRendererFactory.getTypeName(locale, false)}"
						message=assetRendererFactory.getTypeName(locale, false)
						src=assetRendererFactory.getIconPath(renderRequest)
						url="javascript:;"
					/>
				</#list>
			</@>
		</div>
	</div>

	<@aui["script"] use="aui-base">
		A.getBody().delegate(
			'click',
			function(event) {
				event.preventDefault();

				var currentTarget = event.currentTarget;

				Liferay.Util.selectEntity(
					{
						dialog: {
							constrain: true,
							modal: true
						},
						eventName: 'selectContent',
						id: 'selectContent' + currentTarget.attr('id'),
						title: currentTarget.attr('data-title'),
						uri: currentTarget.attr('data-href')
					},
					function(event) {
						A.one('#<@portlet["namespace"] />assetEntryId').attr('value', event.assetentryid);
						A.one('#<@portlet["namespace"] />assetImage').attr('src', '');

						A.one('#<@portlet["namespace"] />assetTitleInfo').html(event.assettitle);
						A.one('#<@portlet["namespace"] />assetTypeInfo').html('<@liferay_ui["message"] key="type" />: ' + event.assettype);

						A.one('#<@portlet["namespace"] />assetPreview').show();
					}
				);
			},
			'.asset-selector a'
		);
	</@>

	<style>
		.asset-preview {
			overflow: hidden;
	    }

		.asset-title {
			font-weight: 400;
			margin-top: 6px;
		}

		.asset-type {
			color: #8D8D8D;
			font-weight: 400;
		}
	</style>
</#if>