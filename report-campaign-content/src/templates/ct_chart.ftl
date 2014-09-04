<style>
	#campaignContentChart {
		height: 400px;
		min-width: 600px;
		width: 100%;
	}
</style>

<@aui["script"] use="charts">
	var campaignContentChartDataValues = [
		<#list searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd()) as campaignContent>
			{content:'${campaignContent.getTitle(locale)}', count:${campaignContent.getCount()}}<#if campaignContent_has_next>,</#if>
		</#list>
	];

	var campaignContentCharAxes = {
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