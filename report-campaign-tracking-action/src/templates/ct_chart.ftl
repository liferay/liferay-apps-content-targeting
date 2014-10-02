<style>
	#ctActionChart {
		height: 400px;
		min-width: 600px;
		width: 100%;
	}
</style>

<@aui["script"] use="charts">
	var ctActionChartDataValues = [
		<#list searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd()) as ctActionTotal>
			{content:'${ctActionTotal.getAlias()}', count:${ctActionTotal.getCount()}}<#if ctActionTotal_has_next>,</#if>
		</#list>
	];

	var ctActionCharAxes = {
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

	var ctActionCharStyles = {
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

	var ctActionChart = new A.Chart({
		axes: ctActionCharAxes,
		dataProvider: ctActionChartDataValues,
		horizontalGridlines: true,
		render: '#ctActionChart',
		styles: ctActionCharStyles,
		type: 'column',
		verticalGridlines: true
	});
</@>

<div id="ctActionChart"></div>