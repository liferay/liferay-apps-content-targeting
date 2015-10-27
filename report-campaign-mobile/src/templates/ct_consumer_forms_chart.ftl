<#macro mobileChart id data>

	<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
	<#assign liferay_theme = PortletJspTagLibs["/META-INF/liferay-theme.tld"] />
	<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
	<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<@aui["script"] use="charts">
	var initialData = [
		<#list data.getResults(searchContainer.getStart(), searchContainer.getEnd()) as mobileChartData>
		{
			content: '${mobileChartData.getConsumerName(locale)}',
			count: ${mobileChartData.getCount()},
			event: '${mobileChartData.getEventType()}'
		}<#if mobileChartData_has_next>,</#if>
		</#list>
	];

	var data = {};
	var series = [];
	var maximums = {};
	var maxValue = 0;
	var maxDivisions = 13;

	var formKeys = ['formView', 'formSubmit', 'formInteraction'];

	groupDataByEventType(initialData);

	groupBySeries(data);

	var divisions = maxValue > maxDivisions ? maxDivisions : maxValue + 1;

	var mobileChartAxes = {
		content: {
			keys: ['content'],
			position: 'bottom',
			title: '<@liferay_ui["message"] key="content" />',
			type: 'category'
		},
		count: {
			keys: formKeys,
			position: 'left',
			title: '<@liferay_ui["message"] key="count" />',
			type: 'numeric',
			labelFormat: {
				decimalPlaces: 0
			},
			styles: {
				majorUnit: {
					count: divisions
				}
			},
			maximum: maxValue
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
		dataProvider: series,
		horizontalGridlines: true,
		render: '#${id}',
		styles: mobileChartStyles,
		type: 'column',
		verticalGridlines: true,
		stacked: true
	});

	function groupDataByEventType(initialData) {
		for (var i = 0; i < initialData.length; i++) {
			var index = initialData[i].content;
			if (!data[index]) {
				data[index] = {
					content: index
				};
			}

			data[index][initialData[i].event] = initialData[i].count;

			maximums[index] = maximums[index] ? maximums[index] + initialData[i].count : initialData[i].count;
		}
	}

	function groupBySeries(data) {
		var keys = Object.keys(data);
		for (var i = 0; i < keys.length; i++) {
			series.push(data[keys[i]]);

			if (maxValue < maximums[keys[i]]) {
				maxValue = maximums[keys[i]];
			}
		}
	}
</@>

<div id="${id}" class="charts"></div>
</#macro>