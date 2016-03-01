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

<style>
	#campaignContentChart {
		height: 400px;
		min-width: 600px;
		width: 100%;
	}
</style>

<@liferay_aui["script"] use="charts">
	var campaignContentChartDataValues = [
		<#list searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd()) as campaignContent>
			{content:'${campaignContent.getTitle(locale)}', count:${campaignContent.getCount()}}<#if campaignContent_has_next>,</#if>
		</#list>
	];

	var campaignContentCharAxes = {
		count:{
			keys:['count'],
			position:'left',
			title:'<@liferay_ui["message"] key="count" />',
			type:'numeric'
		},
		content:{
			keys:['content'],
			position:'bottom',
			title:'<@liferay_ui["message"] key="content" />',
			type:'category'
		}
	};

	var campaignContentCharStyles = {
		axes:{
			content:{
				label:{
					margin:{top:5},
					rotation:-45
				}
			}
		},
		series:{
			count:{
				marker:{
					fill:{
						color:'#45cbf5'
					},
					over:{
						fill:{
							color:'#5bbae8'
						}
					}
				}
			}
		}
	};

	var campaignContentChart = new A.Chart({
		axes: campaignContentCharAxes,
		dataProvider: campaignContentChartDataValues,
		horizontalGridlines: true,
		render: '#campaignContentChart',
		styles: campaignContentCharStyles,
		type: 'column',
		verticalGridlines: true
	});
</@>

<div id="campaignContentChart"></div>