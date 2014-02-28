<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<@aui["select"] label="country" name="countryId" />

<@aui["select"] label="region" name="regionId" />

<@aui["script"] use="liferay-dynamic-select">
	new Liferay.DynamicSelect(
		[
			{
				select: '<@portlet["namespace"] />countryId',
				selectData: Liferay.Address.getCountries,
				selectDesc: 'nameCurrentValue',
				selectId: 'countryId',
				selectSort: true,
				selectVal: '${countryId}'
			},
			{
				select: '<@portlet["namespace"] />regionId',
				selectData: Liferay.Address.getRegions,
				selectDesc: 'name',
				selectId: 'regionId',
				selectVal: '${regionId}'
			}
		]
	);
</@>