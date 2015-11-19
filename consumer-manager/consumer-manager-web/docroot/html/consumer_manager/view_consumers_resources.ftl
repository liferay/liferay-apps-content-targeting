<#--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

<@portlet["renderURL"] varImpl="viewConsumersURL">
	<@portlet["param"] name="mvcPath" value="${consumerManagerPath.VIEW_CONSUMERS}" />
</@>

<@liferay_ui["search-container"]
	emptyResultsMessage="no-consumers-were-found"
	iteratorURL=viewConsumersURL
	rowChecker=consumersRowChecker
	total=consumerSearchContainerIterator.getTotal()
>
	<@liferay_ui["search-container-results"]
		results=consumerSearchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd())
	/>

	<@liferay_ui["search-container-row"]
		className="com.liferay.consumer.manager.model.Consumer"
		keyProperty="consumerId"
		modelVar="consumer"
	>

		<#if consumerPermission.contains(permissionChecker, consumer, actionKeys.UPDATE)>
			<@portlet["renderURL"] var="editConsumerURL">
				<@portlet["param"] name="mvcPath" value="${consumerManagerPath.EDIT_CONSUMER}" />
				<@portlet["param"] name="redirect" value="${viewConsumersURL}" />
				<@portlet["param"] name="consumerId" value="${consumer.getConsumerId()?string}" />
			</@>
		</#if>

		<@liferay_ui["search-container-column-text"]
			href=editConsumerURL
			name="consumer-key"
			value=consumer.getConsumerKey()
		/>

		<@liferay_ui["search-container-column-text"]
			href=editConsumerURL
			name="name"
			value=consumer.getName()
		/>

		<@liferay_ui["search-container-column-text"]
			href=editConsumerURL
			name="description"
			value=consumer.getDescription(locale)
		/>

		<@liferay_ui["search-container-column-text"]
			align="right"
			name=""
		>
			<@liferay_ui["icon-menu"]>
				<#if editConsumerURL??>
					<@liferay_ui["icon"]
						image="edit"
						method="get"
						url="${editConsumerURL}"
					/>
				</#if>

				<#if consumerPermission.contains(permissionChecker, consumer, actionKeys.DELETE)>
					<@portlet["actionURL"] name="deleteConsumer" var="deleteConsumerURL">
						<@portlet["param"] name="redirect" value="${viewConsumersURL}" />
						<@portlet["param"] name="consumerId" value="${consumer.getConsumerId()?string}" />
					</@>

					<@liferay_ui["icon-delete"]
						url="${deleteConsumerURL}"
					/>
				</#if>
			</@>
		</@>
	</@>

	<@liferay_ui["search-iterator"] />
</@>

<@aui["script"] use="liferay-util-list-fields">
	var deleteConsumers = A.one('#<@portlet["namespace"] />deleteConsumers');

	A.one('#<@portlet["namespace"] />${searchContainerReference.getId()}SearchContainer').on(
		'click',
		function() {
			var hide = (Liferay.Util.listCheckedExcept(document.<@portlet["namespace"] />fmConsumers, '<@portlet["namespace"] />allRowIds').length == 0);

			deleteConsumers.toggle(!hide);
		},
		'input[type=checkbox]'
	);

	deleteConsumers.on(
		'click',
		function(event) {
			if (confirm('${languageUtil.get(portletConfig, locale, "are-you-sure-you-want-to-delete-this")}')) {
				document.<@portlet["namespace"] />fmConsumers.<@portlet["namespace"] />consumersIds.value = Liferay.Util.listCheckedExcept(document.<@portlet["namespace"] />fmConsumers, '<@portlet["namespace"] />allRowIds');

				<@portlet["renderURL"] var="redirectURL">
					<@portlet["param"] name="mvcPath" value="${consumerManagerPath.VIEW_CONSUMERS}" />
				</@>

				<@portlet["actionURL"] name="deleteConsumer" var="deleteConsumersURL">
					<@portlet["param"] name="redirect" value="${redirectURL}" />
				</@>

				submitForm(document.<@portlet["namespace"] />fmConsumers, '${deleteConsumersURL}');
			}
		}
	);
</@>