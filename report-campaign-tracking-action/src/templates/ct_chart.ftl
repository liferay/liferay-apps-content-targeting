<style>
	#campaignTrackingActionChart {
		height: 400px;
		min-width: 600px;
		width: 100%;
	}
</style>

<@aui["script"] use="charts">
	var campaignTrackingActionChartDataValues = [
		<#list searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd()) as campaignTrackingAction>
			{content:"${campaignTrackingAction.getUserSegmentName(locale)}", count:${campaignTrackingAction.getCount()}}<#if campaignTrackingAction_has_next>,</#if>
		</#list>
	];

	var campaignTrackingActionCharAxes = {
		count:{
			keys:["count"],
			type:"numeric"
		},
		dateRange:{
			keys:["content"],
			type:"category"
		}
	};

	var campaignTrackingActionChart = new A.Chart({
		axes: campaignTrackingActionCharAxes,
		dataProvider: campaignTrackingActionChartDataValues,
		horizontalGridlines: true,
		render: "#campaignTrackingActionChart",
		type: "bar",
		verticalGridlines: true
	});
</@>


<div id="campaignTrackingActionChart"></div>