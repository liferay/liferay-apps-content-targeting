<style>
	#campaignTrackingActionChart {
		height: 400px;
		min-width: 600px;
		width: 100%;
	}
</style>

<@aui["script"] use="charts">
	var campaignTrackingActionChartDataValues = [
		<#list searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd()) as campaignTrackingActionTotal>
			{content:'${campaignTrackingActionTotal.getAlias()}', count:${campaignTrackingActionTotal.getCount()}}<#if campaignTrackingActionTotal_has_next>,</#if>
		</#list>
	];

	var campaignTrackingActionCharAxes = {
		count:{
			keys:['count'],
			position:'left',
			title:'${languageUtil.get(locale, "count")}',
			type:'numeric'
		},
		content:{
			keys:['content'],
			position:'bottom',
			title:'${languageUtil.get(locale, "content")}',
			type:'category'
		}
	};

	var campaignTrackingActionCharStyles = {
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

	var campaignTrackingActionChart = new A.Chart({
		axes: campaignTrackingActionCharAxes,
		dataProvider: campaignTrackingActionChartDataValues,
		horizontalGridlines: true,
		render: '#campaignTrackingActionChart',
		styles: campaignTrackingActionCharStyles,
		type: 'column',
		verticalGridlines: true
	});
</@>

<div id="campaignTrackingActionChart"></div>