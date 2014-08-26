<#assign counterModels = dataFactory.newCounterModels()>

<#list counterModels as counterModel>
	update Counter set currentId = ${counterModel.currentId} where name = '${counterModel.name}';
</#list>