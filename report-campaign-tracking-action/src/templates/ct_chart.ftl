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
			position:"left",
			type:"numeric"
		},
		content:{
			keys:["content"],
			position:"bottom",
			type:"category"
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
		}
	};

	var campaignTrackingActionChart = new A.Chart({
		axes: campaignTrackingActionCharAxes,
		dataProvider: campaignTrackingActionChartDataValues,
		horizontalGridlines: true,
		render: "#campaignTrackingActionChart",
		styles: campaignTrackingActionCharStyles,
		type: "column",
		verticalGridlines: true
	});
</@>


<div id="campaignTrackingActionChart"></div>