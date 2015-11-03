<#macro mobileChart id data>

	<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
	<#assign liferay_theme = PortletJspTagLibs["/META-INF/liferay-theme.tld"] />
	<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
	<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<@aui["script"] use="charts">

	var mobileChartDataValues = [
		<#list data.getResults(searchContainer.getStart(), searchContainer.getEnd()) as mobileChartData>
        {
			content: '${mobileChartData.getConsumerName(locale)}',
			count: ${mobileChartData.getCount()},
        	event: '${mobileChartData.getEventType()}'} <#if mobileChartData_has_next>,</#if>
		</#list>
	];

	var maxDivisions = 13;

	var maxInDataValues = function (data) {
		var count = 0;
		for (var i = 0; i < data.length; i++) {
			if (data[i].count > count) {
				count = data[i].count;
			}
		}
		return count > maxDivisions ? maxDivisions : count + 1;
	};

	var max = maxInDataValues(mobileChartDataValues);

	var mobileChartAxes = {
		count: {
			keys: ['count'],
			position: 'left',
			title: '<@liferay_ui["message"] key="count" />',
			type: 'numeric',
			labelFormat: {
				decimalPlaces: 0
			},
			styles: {
				majorUnit: {
					count: max
				}
			}
		},
		content: {
			keys: ['content'],
			position: 'bottom',
			title: '<@liferay_ui["message"] key="content" />',
			type: 'category'
		}
	};

	var mobileChartStyles = {
		axes: {
			content: {
				label: {
					margin: {top: 5},
					rotation: -45
				}
			}
		},
		series: {
			count: {
				marker: {
					fill: {
						color: '#45cbf5'
					},
					over: {
						fill: {
							color: '#5bbae8'
						}
					}
				}
			}
		}
	};

	var mobileChart = new A.Chart({
		axes: mobileChartAxes,
		dataProvider: mobileChartDataValues,
		horizontalGridlines: true,
		render: '#${id}',
		styles: mobileChartStyles,
		type: 'column',
		verticalGridlines: true
	});
</@>

<div id="${id}" class="charts"></div>
</#macro>