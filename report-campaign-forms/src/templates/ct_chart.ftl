<style>
	#campaignFormChart {
		height: 400px;
		min-width: 600px;
		width: 100%;
	}
</style>

<@aui["script"] use="charts">
	var campaignFormChartDataValues = [
		<#list searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd()) as campaignForm>
			{content:"${campaignForm.getUserSegmentName(locale)}", count:${campaignForm.getCount()}}<#if campaignForm_has_next>,</#if>
		</#list>
	];

	var campaignFormCharAxes = {
		count:{
			keys:["count"],
			type:"numeric"
		},
		dateRange:{
			keys:["content"],
			type:"category"
		}
	};

	var campaignFormChart = new A.Chart({
		axes: campaignFormCharAxes,
		dataProvider: campaignFormChartDataValues,
		horizontalGridlines: true,
		render: "#campaignFormChart",
		type: "bar",
		verticalGridlines: true
	});
</@>


<div id="campaignFormChart"></div>