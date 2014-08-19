<style>
	#userSegmentContentChart {
		height: 400px;
		min-width: 600px;
		width: 100%;
	}
</style>

<@aui["script"] use="charts">
	var userSegmentContentChartDataValues = [
		<#list searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd()) as userSegmentContent>
			{content:"${userSegmentContent.getTitle(locale)}", count:${userSegmentContent.getCount()}}<#if userSegmentContent_has_next>,</#if>
		</#list>
	];

	var userSegmentContentCharAxes = {
		count:{
			keys:["count"],
			position:"left",
			type:"numeric"
		},
		content:{
			keys:["content"],
			position:"bottom",
			type:"category"
		}
	};

	var userSegmentContentCharStyles = {
		axes:{
			content:{
				label:{
					margin:{top:5},
					rotation:-45
				}
			}
		}
	};

	var userSegmentContentChart = new A.Chart({
		axes: userSegmentContentCharAxes,
		dataProvider: userSegmentContentChartDataValues,
		horizontalGridlines: true,
		render: "#userSegmentContentChart",
		styles: userSegmentContentCharStyles,
		type: "column",
		verticalGridlines: true
	});
</@>

<div id="userSegmentContentChart"></div>