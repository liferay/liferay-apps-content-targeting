<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<@aui["fieldset"] label="start-time">
	<@liferay_ui["input-time"]
		amPmParam="startTimeAmPm"
		amPmValue=startTimeAmPm
		hourParam="startTimeHour"
		hourValue=startTimeHour
		minuteParam="startTimeMinute"
		minuteValue=startTimeMinute
		name="startTime"
	/>
</@>

<@aui["fieldset"] label="end-time">
	<@liferay_ui["input-time"]
		amPmParam="endTimeAmPm"
		amPmValue=endTimeAmPm
		hourParam="endTimeHour"
		hourValue=endTimeHour
		minuteParam="endTimeMinute"
		minuteValue=endTimeMinute
		name="endTime"
	/>
</@>