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
			<#assign userSegmentNames="">
			<#list ctActionTotal.getViewsByUserSegment() as ctAction>
				<#if (userSegmentNames?length == 0)>
					<#assign userSegmentNames = ctAction.getUserSegmentName(locale) + " - " + ctAction.getCount()>
				<#else>
					<#assign userSegmentNames = userSegmentNames + "," + ctAction.getUserSegmentName(locale) + " - " + ctAction.getCount()>
				</#if>
			</#list>

			{content:'${ctActionTotal.getAlias()}', count:${ctActionTotal.getCount()}, user_segments: '${userSegmentNames}'}<#if ctActionTotal_has_next>,</#if>
		</#list>
	];

	var ctActionChartTooltip = {
		styles: {
			backgroundColor: "#333",
			color: "#eee",
			borderColor: "#fff",
		},
		markerLabelFunction: function(categoryItem, valueItem, itemIndex, series, seriesIndex) {
			var msg = document.createElement("div");

			var data = ctActionChartDataValues[seriesIndex];

			var countSpan = document.createElement("span");
			var metricSpan = document.createElement("span");
			var segmentSpan = document.createElement("span");

			var countValueSpan = document.createElement("span");
			countValueSpan.style.fontWeight = "bold";
			var metricValueSpan = document.createElement("span");
			metricValueSpan.style.fontWeight = "bold";
			var segmentValueDiv = document.createElement("div");
			segmentValueDiv.style.fontWeight = "bold";
			segmentValueDiv.style.paddingLeft = "10px";

			countValueSpan.appendChild(document.createTextNode(data.count));
			metricValueSpan.appendChild(document.createTextNode(data.content));
			var segments = data.user_segments.split(",");

			for (var idx in segments) {
				var segment = segments[idx].trim();

				if (idx > 0) {
					segmentValueDiv.appendChild(document.createElement("br"));
				}

				segmentValueDiv.appendChild(document.createTextNode(segment));
			}


			countSpan.appendChild(document.createTextNode('${languageUtil.get(locale, "total-count")}: '));
			metricSpan.appendChild(document.createTextNode('${languageUtil.get(locale, "metric")}: '));
			segmentSpan.appendChild(document.createTextNode('${languageUtil.get(locale, "user-segments")}: '));

			msg.appendChild(metricSpan);
			msg.appendChild(metricValueSpan);
			msg.appendChild(msg.appendChild(document.createElement("br")));
			msg.appendChild(countSpan);
			msg.appendChild(countValueSpan);
			msg.appendChild(msg.appendChild(document.createElement("br")));
			msg.appendChild(segmentSpan);
			msg.appendChild(segmentValueDiv);

			return msg;
		}
	};

	var ctActionCharAxes = {
		count:{
			keys:['count'],
			position:'left',
			title:'<@liferay_ui["message"] key="count" />',
			type:'numeric'
		},
		content:{
			keys:['content'],
			position:'bottom',
			title:'<@liferay_ui["message"] key="content" />',
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
		tooltip: ctActionChartTooltip,
		type: 'column',
		verticalGridlines: true
	});
</@>

<div id="ctActionChart"></div>