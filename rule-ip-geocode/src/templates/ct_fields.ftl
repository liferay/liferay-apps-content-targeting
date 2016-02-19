<#--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
-->

<#setting number_format="computer">

<@liferay_aui["select"]
	label="country"
	name="countryId"
/>

<@liferay_aui["select"]
	label="region"
	name="regionId"
/>

<@liferay_aui["script"] use="liferay-dynamic-select">
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