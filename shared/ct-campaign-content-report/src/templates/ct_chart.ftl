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
			{content:"${campaignContent.getTitle(locale)}", count:${campaignContent.getCount()}}<#if campaignContent_has_next>,</#if>
		</#list>
	];

	var campaignContentCharAxes = {
		count:{
			keys:["count"],
			type:"numeric"
		},
		dateRange:{
			keys:["content"],
			type:"category"
		}
	};

	var campaignContentChart = new A.Chart({
		axes: campaignContentCharAxes,
		dataProvider: campaignContentChartDataValues,
		horizontalGridlines: true,
		render: "#campaignContentChart",
		type: "bar",
		verticalGridlines: true
	});
</@>

<div id="campaignContentChart"></div>