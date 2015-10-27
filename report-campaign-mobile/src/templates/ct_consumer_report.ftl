<h2>Form interactions</h2>

<#import "ct_consumer_table.ftl" as form />
<@form.consumerTable chartId = "formId"
iterator = formIterator
chartTemplate = "ct_consumer_forms_chart.ftl"/>

<h2>App installations</h2>

<#import "ct_consumer_table.ftl" as appInstallations />
<@appInstallations.consumerTable chartId = "appInstallationsId"
iterator = appInstallationsIterator
chartTemplate = "ct_chart_with_consumer_data.ftl"/>

<h2>App sessions</h2>

<#import "ct_consumer_table.ftl" as appSessions />
<@appSessions.consumerTable chartId = "appSessionsId"
iterator = appSessionsIterator
chartTemplate = "ct_chart_with_consumer_data.ftl"/>

<h2>Session time</h2>

<#import "ct_consumer_table.ftl" as sessionScreen />
<@sessionScreen.consumerTable chartId = "sessionScreenId"
iterator = sessionScreenIterator
chartTemplate = "ct_chart_with_consumer_data.ftl"/>