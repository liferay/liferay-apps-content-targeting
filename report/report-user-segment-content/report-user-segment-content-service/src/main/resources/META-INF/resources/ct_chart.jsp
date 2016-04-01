<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
int start = ParamUtil.getInteger(request, "start");
int end = ParamUtil.getInteger(request, "end");

SearchContainerIterator<UserSegmentContent> searchContainerIterator = userSegmentContentReportDisplayContext.getSearchContainerIterator();

List<UserSegmentContent> userSegmentContents = searchContainerIterator.getResults(start, end);
%>

<style>
	#userSegmentContentChart {
		height: 400px;
		min-width: 600px;
		width: 100%;
	}
</style>

<aui:script use="charts">
	var userSegmentContentChartDataValues = [

		<%
		for (int k = 0; k < userSegmentContents.size(); k++) {
			UserSegmentContent userSegmentContent = userSegmentContents.get(k);
		%>

			<c:if test="<%= k > 0 %>">,</c:if>

			{content:'<%= userSegmentContent.getTitle(locale) %>', count:<%= userSegmentContent.getCount() %>}

		<%
		}
		%>

	];

	var userSegmentContentCharAxes = {
		count:{
			keys:['count'],
			position:'left',
			title:'<liferay-ui:message key="count" />',
			type:'numeric'
		},
		content:{
			keys:['content'],
			position:'bottom',
			title:'<liferay-ui:message key="content" />',
			type:'category'
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

	var userSegmentContentChart = new A.Chart({
		axes: userSegmentContentCharAxes,
		dataProvider: userSegmentContentChartDataValues,
		horizontalGridlines: true,
		render: '#userSegmentContentChart',
		styles: userSegmentContentCharStyles,
		type: 'column',
		verticalGridlines: true
	});
</aui:script>

<div id="userSegmentContentChart"></div>