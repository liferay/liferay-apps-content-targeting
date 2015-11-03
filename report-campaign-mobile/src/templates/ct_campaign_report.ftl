<h2>Asset views</h2>

<#import "ct_campaign_table.ftl" as assetViews />
<@assetViews.campaignTable chartId = "assetViewsId" iterator = contentViewsIterator/>

<h2>Link and button clicks</h2>

<#import "ct_campaign_table.ftl" as linkAndButtonClicks />
<@linkAndButtonClicks.campaignTable chartId = "linkAndButtonClicksId" iterator = linkAndButtonClicksIterator/>

<h2>Time the AT content is on screen</h2>

<#import "ct_campaign_table.ftl" as atOnScreen />
<@atOnScreen.campaignTable chartId = "atOnScreenId" iterator = atOnScreenIterator/>