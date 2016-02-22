<#--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
-->

<style>
	#ctActionChart {
		height: 400px;
		min-width: 600px;
		width: 100%;
	}
</style>

<@liferay_aui["script"] use="charts">
	var ctActionTotalArray = [
		<#list searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd()) as ctActionTotal>
			<#assign userSegmentNames ="">

			<#list ctActionTotal.getViewsByUserSegment() as ctAction>
				<#if (userSegmentNames?length == 0)>
					<#assign userSegmentNames = ctAction.getUserSegmentName(locale) + " - " + ctAction.getCount()>
				<#else>
					<#assign userSegmentNames = userSegmentNames + "," + ctAction.getUserSegmentName(locale) + " - " + ctAction.getCount()>
				</#if>
			</#list>

			<#assign eventType = ctActionTotal.getEventType()>

			<#if ctActionTotal.getEventType() == "sending">
			    <#assign eventType ="sent">
			<#elseif ctActionTotal.getEventType() == "click">
				<#assign eventType ="link-clicks">
			</#if>

			{content:'${ctActionTotal.getAlias()}', event:'${eventType}', eventName:'${languageUtil.get(locale,eventType)}', count:${ctActionTotal.getCount()}, user_segments: '${userSegmentNames}'}<#if ctActionTotal_has_next>,</#if>
		</#list>
	];

	var ctActionCharAxes = {
		count:{
			keys:[],
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

	var ctActionChartDataValues = [];

	for (var idx in ctActionTotalArray) {
		var actionTotal = ctActionTotalArray[idx];
		var event = actionTotal.event;
		var eventName = actionTotal.eventName;
		var actionName = actionTotal.content;
		var eventCount = actionTotal.count;
		var userSegments = actionTotal.user_segments;

		if (A.Array.indexOf(ctActionCharAxes.count.keys, event) == -1) {
			ctActionCharAxes.count.keys.push(event);
		}

		var currentActionIndex = -1;

		for (var dataIdx in ctActionChartDataValues) {
			var checkValue = ctActionChartDataValues[dataIdx];

			if (checkValue.content === actionName) {
				currentActionIndex = dataIdx;

				break;
			}
		}

		var dataValue = {
			content: actionName
		};

		if (currentActionIndex != -1) {
			dataValue = ctActionChartDataValues[currentActionIndex];
		}

		dataValue[event] = eventCount;

		if (!dataValue.eventNames) {
			dataValue.eventNames = {};
		}

		dataValue.eventNames[event] = eventName;

		if (!dataValue.userSegments) {
			dataValue.userSegments = {};
		}

		dataValue.userSegments[event] = userSegments;

		if (currentActionIndex == -1) {
			ctActionChartDataValues.push(dataValue);
		}
		else {
			ctActionChartDataValues[currentActionIndex] = dataValue;
		}
	}

	var ctActionChartTooltip = {
		styles: {
			backgroundColor: "#333",
			color: "#eee",
			borderColor: "#fff",
		},
		markerLabelFunction: function(categoryItem, valueItem, itemIndex, series, seriesIndex) {
			var msg = document.createElement("div");

			var data = ctActionChartDataValues[itemIndex];

			var countSpan = document.createElement("span");
			var eventSpan = document.createElement("span");
			var metricSpan = document.createElement("span");
			var segmentSpan = document.createElement("span");

			var countValueSpan = document.createElement("span");
			countValueSpan.style.fontWeight = "bold";

			var eventValueSpan = document.createElement("span");
			eventValueSpan.style.fontWeight = "bold";

			var metricValueSpan = document.createElement("span");
			metricValueSpan.style.fontWeight = "bold";

			var segmentValueDiv = document.createElement("div");
			segmentValueDiv.style.fontWeight = "bold";
			segmentValueDiv.style.paddingLeft = "10px";

			countValueSpan.appendChild(document.createTextNode(data[valueItem.key]));
			eventValueSpan.appendChild(document.createTextNode(data.eventNames[valueItem.key]));
			metricValueSpan.appendChild(document.createTextNode(data.content));

			var segments = data.userSegments[valueItem.key].split(",");

			countSpan.appendChild(document.createTextNode('${languageUtil.get(locale, "total-count")}: '));
			metricSpan.appendChild(document.createTextNode('${languageUtil.get(locale, "metric")}: '));
			eventSpan.appendChild(document.createTextNode('${languageUtil.get(locale, "event")}: '));

			msg.appendChild(metricSpan);
			msg.appendChild(metricValueSpan);
			msg.appendChild(msg.appendChild(document.createElement("br")));
			msg.appendChild(eventSpan);
			msg.appendChild(eventValueSpan);
			msg.appendChild(msg.appendChild(document.createElement("br")));
			msg.appendChild(countSpan);
			msg.appendChild(countValueSpan);

			if (data.userSegments[valueItem.key] !== '' && segments.length > 0) {
				for (var idx in segments) {
					var segment = segments[idx].trim();

					if (idx > 0) {
						segmentValueDiv.appendChild(document.createElement("br"));
					}

					segmentValueDiv.appendChild(document.createTextNode(segment));
				}

				segmentSpan.appendChild(document.createTextNode('${languageUtil.get(locale, "user-segments")}: '));

				msg.appendChild(msg.appendChild(document.createElement("br")));
				msg.appendChild(segmentSpan);
				msg.appendChild(segmentValueDiv);
			}

			return msg;
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

	for (var idx in ctActionChartDataValues) {
		var dataValue = ctActionChartDataValues[idx];

		for (var checkIdx in ctActionChartDataValues) {
			var checkValue = ctActionChartDataValues[checkIdx];

			if (checkIdx != idx) {
				for (var evt in checkValue) {
					if (!dataValue[evt] && evt !== 'userSegments') {
						dataValue[evt] = 0.05;
					}
				}
			}
		}

		ctActionChartDataValues[idx] = dataValue;
	}

	ctActionChartDataValues.sort(
		function(a, b) {
			if (a.content === b.content) {
				return 0;
			}
			else if (a.content > b.content) {
				return 1;
			}

			return -1;
		}
	);

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