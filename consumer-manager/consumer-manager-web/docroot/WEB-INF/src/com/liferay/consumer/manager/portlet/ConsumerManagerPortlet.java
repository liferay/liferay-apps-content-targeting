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

package com.liferay.consumer.manager.portlet;

import com.liferay.consumer.manager.DuplicateConsumerExtensionInstanceException;
import com.liferay.consumer.manager.InvalidConsumerExtensionException;
import com.liferay.consumer.manager.InvalidConsumerExtensionsException;
import com.liferay.consumer.manager.InvalidNameException;
import com.liferay.consumer.manager.api.model.ConsumerExtension;
import com.liferay.consumer.manager.api.model.ConsumerExtensionsRegistry;
import com.liferay.consumer.manager.model.Consumer;
import com.liferay.consumer.manager.model.ConsumerExtensionInstance;
import com.liferay.consumer.manager.portlet.util.ConsumerExtensionTemplate;
import com.liferay.consumer.manager.service.ConsumerExtensionInstanceLocalService;
import com.liferay.consumer.manager.service.ConsumerExtensionInstanceService;
import com.liferay.consumer.manager.service.ConsumerLocalService;
import com.liferay.consumer.manager.service.ConsumerLocalServiceUtil;
import com.liferay.consumer.manager.service.ConsumerService;
import com.liferay.consumer.manager.service.permission.ConsumerManagerPermission;
import com.liferay.consumer.manager.service.permission.ConsumerPermission;
import com.liferay.consumer.manager.util.ActionKeys;
import com.liferay.consumer.manager.util.ConsumerManagerContextUtil;
import com.liferay.consumer.manager.util.ConsumerSearchContainerIterator;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.servlet.taglib.aui.ValidatorTag;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnicodeFormatter;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import freemarker.ext.beans.BeansWrapper;

import freemarker.template.TemplateHashModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.UnavailableException;

import javax.servlet.http.HttpServletRequest;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Eduardo Garcia
 * @author Carlos Sierra Andrés
 */
public class ConsumerManagerPortlet extends FreeMarkerPortlet {

	public void deleteConsumer(ActionRequest request, ActionResponse response)
		throws Exception {

		try {
			long[] deleteConsumersIds = null;

			long consumerId = ParamUtil.getLong(request, "consumerId");

			if (consumerId > 0) {
				deleteConsumersIds = new long[] {consumerId};
			}
			else {
				deleteConsumersIds = StringUtil.split(
					ParamUtil.getString(request, "consumersIds"), 0L);
			}

			for (long deleteConsumerId : deleteConsumersIds) {
				_consumerService.deleteConsumer(deleteConsumerId);
			}

			sendRedirect(request, response);
		}
		catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName(), e);

			response.setRenderParameter("mvcPath", ConsumerManagerPath.ERROR);
		}
	}

	@Override
	public void init() throws PortletException {
		super.init();

		Bundle bundle = FrameworkUtil.getBundle(getClass());

		if (bundle == null) {
			throw new UnavailableException(
				"Can't find a reference to the OSGi bundle") {

				@Override
				public boolean isPermanent() {
					return true;
				}
			};
		}

		_consumerExtensionInstanceService = ServiceTrackerUtil.getService(
			ConsumerExtensionInstanceService.class, bundle.getBundleContext());
		_consumerExtensionInstanceLocalService = ServiceTrackerUtil.getService(
			ConsumerExtensionInstanceLocalService.class,
			bundle.getBundleContext());
		_consumerExtensionsRegistry = ServiceTrackerUtil.getService(
			ConsumerExtensionsRegistry.class, bundle.getBundleContext());
		_consumerLocalService = ServiceTrackerUtil.getService(
			ConsumerLocalService.class, bundle.getBundleContext());
		_consumerService = ServiceTrackerUtil.getService(
			ConsumerService.class, bundle.getBundleContext());
	}

	public void updateConsumer(ActionRequest request, ActionResponse response)
		throws Exception {

		long consumerId = ParamUtil.getLong(request, "consumerId");

		String consumerKey = ParamUtil.getString(request, "consumerKey");

		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
			request, "name");

		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(request, "description");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Consumer.class.getName(), request);

		try {
			Consumer consumer = null;

			if (consumerId == 0) {
				consumer = _consumerService.addConsumer(
					consumerKey, descriptionMap, nameMap, serviceContext);
			}
			else {
				consumer = _consumerService.updateConsumer(
					consumerId, consumerKey, descriptionMap, nameMap,
					serviceContext);
			}

			List<InvalidConsumerExtensionException>
				consumerExtensionExceptions = updateConsumerExtensions(
					consumer.getConsumerId(), request, response);

			if (!consumerExtensionExceptions.isEmpty()) {
				throw new InvalidConsumerExtensionsException(
					consumerExtensionExceptions);
			}

			sendRedirect(request, response);
		}
		catch (Exception e) {
			PortalUtil.copyRequestParameters(request, response);

			SessionErrors.add(request, e.getClass().getName(), e);

			if (e instanceof InvalidNameException ||
				e instanceof PrincipalException) {

				SessionMessages.add(
					request,
					PortalUtil.getPortletId(request) +
						SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

				response.setRenderParameter(
					"mvcPath", ConsumerManagerPath.EDIT_CONSUMER);
			}
			else {
				response.setRenderParameter(
					"mvcPath", ConsumerManagerPath.ERROR);
			}
		}
		catch (Throwable t) {
			_log.error(t);

			response.setRenderParameter("mvcPath", ConsumerManagerPath.ERROR);
		}
	}

	protected void deleteConsumerExtensionInstances(
			List<ConsumerExtensionInstance> consumerExtensionInstances)
		throws Exception {

		for (ConsumerExtensionInstance
			consumerExtensionInstance : consumerExtensionInstances) {

			_consumerExtensionInstanceService.deleteConsumerExtensionInstance(
				consumerExtensionInstance.getConsumerExtensionInstanceId());
		}
	}

	protected String getConsumerExtensionHtml(
		ConsumerExtension consumerExtension,
		ConsumerExtensionInstance consumerExtensionInstance, Template template,
		Map<String, String> values,
		List<InvalidConsumerExtensionException> exceptions) {

		Map<String, Object> context = cloneTemplateContext(template);

		String html = StringPool.BLANK;

		if ((exceptions != null) && !exceptions.isEmpty()) {
			try {
				context.put("exceptions", exceptions);
				context.put("portletClass", getClass());

				html += ConsumerManagerContextUtil.parseTemplate(
					getClass(), "templates/ct_exceptions.ftl", context);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		HttpServletRequest request = (HttpServletRequest)context.get("request");

		Map<String, List<ValidatorTag>> validatorTagsMap =
			new HashMap<String, List<ValidatorTag>>();

		request.setAttribute("aui:form:validatorTagsMap", validatorTagsMap);

		if (values == null) {
			values = Collections.emptyMap();
		}

		html += consumerExtension.getFormHTML(
			consumerExtensionInstance, context, values);

		if (!validatorTagsMap.isEmpty()) {
			try {
				context.put("validatorTagsMap", validatorTagsMap);

				html += ConsumerManagerContextUtil.parseTemplate(
					getClass(), "templates/ct_validators.ftl", context);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		return html;
	}

	protected List<ConsumerExtensionInstance> getConsumerExtensionsFromRequest(
			PortletRequest request, PortletResponse response)
		throws Exception {

		List<ConsumerExtensionInstance> consumerExtensionsInstances =
			new ArrayList<ConsumerExtensionInstance>();

		String campaignConsumerExtensions = ParamUtil.getString(
			request, "consumerExtensions");

		if (Validator.isNull(campaignConsumerExtensions)) {
			return consumerExtensionsInstances;
		}

		JSONObject jSONObject = JSONFactoryUtil.createJSONObject(
			campaignConsumerExtensions);

		String consumerExtensions = jSONObject.getString("fields");

		JSONArray jSONArray = JSONFactoryUtil.createJSONArray(
			consumerExtensions);

		for (int i = 0; i < jSONArray.length(); i++) {
			JSONObject jSONObjectConsumerExtension = jSONArray.getJSONObject(i);

			long consumerExtensionInstanceId = 0;

			String type = jSONObjectConsumerExtension.getString("type");

			if (type.contains(StringPool.UNDERLINE)) {
				String[] ids = type.split(StringPool.UNDERLINE);

				consumerExtensionInstanceId = GetterUtil.getLong(ids[1]);
				type = ids[0];
			}

			String id = jSONObjectConsumerExtension.getString("id");

			Map<String, String> consumerExtensionValues = getJSONValues(
				jSONObjectConsumerExtension.getJSONArray("data"),
				response.getNamespace(), id);

			ConsumerExtensionInstance consumerExtensionInstance =
				_consumerExtensionInstanceLocalService.
					createConsumerExtensionInstance(
						consumerExtensionInstanceId);

			consumerExtensionInstance.setConsumerExtensionKey(type);
			consumerExtensionInstance.setValues(consumerExtensionValues);
			consumerExtensionInstance.setConsumerExtensionGuid(id);

			consumerExtensionsInstances.add(consumerExtensionInstance);
		}

		return consumerExtensionsInstances;
	}

	protected Map<String, String> getJSONValues(
		JSONArray data, String namespace, String id) {

		Map<String, String> values = new HashMap<String, String>(data.length());

		for (int i = 0; i < data.length(); i++) {
			JSONObject jsonObject = data.getJSONObject(i);

			String name = jsonObject.getString("name");

			name = StringUtil.replace(
				name, new String[]{namespace, id},
				new String[]{StringPool.BLANK, StringPool.BLANK});

			values.put(name, jsonObject.getString("value"));
		}

		return values;
	}

	protected InvalidConsumerExtensionsException
		getInvalidConsumerExtensionsException(
			PortletRequest portletRequest) {

		if (SessionErrors.contains(
				portletRequest,
			InvalidConsumerExtensionsException.class.getName())) {

			return (InvalidConsumerExtensionsException)SessionErrors.get(
				portletRequest,
				InvalidConsumerExtensionsException.class.getName());
		}
		else {
			return new InvalidConsumerExtensionsException();
		}
	}

	@Override
	protected void populateContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template)
		throws Exception {

		BeansWrapper wrapper = BeansWrapper.getDefaultInstance();

		TemplateHashModel staticModels = wrapper.getStaticModels();

		template.put(
			"actionKeys", staticModels.get(ActionKeys.class.getName()));
		template.put("consumerClass", Consumer.class);
		template.put(
			"consumerManagerPath",
			staticModels.get(ConsumerManagerPath.class.getName()));
		template.put(
			"consumerManagerPermission",
			staticModels.get(ConsumerManagerPermission.class.getName()));
		template.put(
			"consumerPermission",
			staticModels.get(ConsumerPermission.class.getName()));
		template.put("consumersRowChecker", new RowChecker(portletResponse));
		template.put(
			"portalUtil", staticModels.get(PortalUtil.class.getName()));
		template.put(
			"resourceActionsUtil",
			staticModels.get(ResourceActionsUtil.class.getName()));
		template.put(
			"unicodeFormatter",
			staticModels.get(UnicodeFormatter.class.getName()));

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String keywords = ParamUtil.getString(portletRequest, "keywords");

		template.put(
			"consumerSearchContainerIterator",
			new ConsumerSearchContainerIterator(
				themeDisplay.getCompanyId(), keywords, _consumerLocalService));

		template.put("currentURL", PortalUtil.getCurrentURL(portletRequest));

		template.put(
			"redirect", ParamUtil.getString(portletRequest, "redirect"));

		populateViewContext(
			path, portletRequest, portletResponse, template, staticModels);
	}

	protected void populateViewContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template,
			TemplateHashModel staticModels)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long consumerId = -1;

		if (ConsumerManagerPath.EDIT_CONSUMER.equals(path)) {
			consumerId = ParamUtil.getLong(portletRequest, "consumerId");

			Map<String, ConsumerExtension> consumerExtensions =
				_consumerExtensionsRegistry.getConsumerExtensions();

			boolean isolated = themeDisplay.isIsolated();

			try {
				themeDisplay.setIsolated(true);

				List<ConsumerExtensionInstance> consumerExtensionInstances =
					getConsumerExtensionsFromRequest(
						portletRequest, portletResponse);

				if (consumerExtensionInstances.isEmpty() && (consumerId > 0)) {
					consumerExtensionInstances =
						_consumerExtensionInstanceService.
							getConsumerExtensionInstances(consumerId);
				}

				List<ConsumerExtensionTemplate>
					addedConsumerExtensionTemplates =
					new ArrayList<ConsumerExtensionTemplate>();

				if (!consumerExtensionInstances.isEmpty()) {
					template.put(
						"consumerExtensionInstances",
						consumerExtensionInstances);

					InvalidConsumerExtensionsException itae =
						getInvalidConsumerExtensionsException(portletRequest);

					for (ConsumerExtensionInstance instance
						: consumerExtensionInstances) {

						ConsumerExtension consumerExtension =
							_consumerExtensionsRegistry.getConsumerExtension(
								instance.getConsumerExtensionKey());

						if (consumerExtension == null) {
							continue;
						}

						ConsumerExtensionTemplate consumerExtensionTemplate =
							new ConsumerExtensionTemplate();

						if (instance.getConsumerExtensionInstanceId() > 0) {
							consumerExtensionTemplate.setInstanceId(
								String.valueOf(
									instance.getConsumerExtensionInstanceId()));
						}
						else {
							consumerExtensionTemplate.setInstanceId(
								instance.getConsumerExtensionGuid());
						}

						consumerExtensionTemplate.setConsumerExtension(
							consumerExtension);

						String html = getConsumerExtensionHtml(
							consumerExtension, instance, template,
							instance.getValues(),
							itae.getExceptions(
								instance.getConsumerExtensionGuid()));

						consumerExtensionTemplate.setTemplate(
							HtmlUtil.escapeAttribute(html));

						addedConsumerExtensionTemplates.add(
							consumerExtensionTemplate);
					}
				}

				template.put(
					"addedConsumerExtensionTemplates",
					addedConsumerExtensionTemplates);

				List<ConsumerExtensionTemplate> consumerExtensionTemplates =
					new ArrayList<ConsumerExtensionTemplate>();

				for (ConsumerExtension consumerExtension
					: consumerExtensions.values()) {

					ConsumerExtensionTemplate consumerExtensionTemplate =
						new ConsumerExtensionTemplate();

					consumerExtensionTemplate.setConsumerExtension(
						consumerExtension);

					String html = getConsumerExtensionHtml(
						consumerExtension, null, template, null, null);

					consumerExtensionTemplate.setTemplate(
						HtmlUtil.escapeAttribute(html));

					consumerExtensionTemplates.add(consumerExtensionTemplate);
				}

				template.put(
					"consumerExtensionTemplates", consumerExtensionTemplates);
			}
			finally {
				themeDisplay.setIsolated(isolated);
			}
		}

		if (consumerId > 0) {
			Consumer consumer = ConsumerLocalServiceUtil.getConsumer(
				consumerId);

			template.put("consumer", consumer);
			template.put("consumerId", consumerId);
		}
	}

	protected List<InvalidConsumerExtensionException> updateConsumerExtensions(
			long consumerId, PortletRequest request, PortletResponse response)
		throws Exception {

		List<ConsumerExtensionInstance> requestConsumerExtensionInstances =
			getConsumerExtensionsFromRequest(request, response);

		List<ConsumerExtensionInstance> consumerExtensionInstances =
			ListUtil.copy(
				_consumerExtensionInstanceService.getConsumerExtensionInstances(
					consumerId));

		List<InvalidConsumerExtensionException> consumerExtensionExceptions =
			new ArrayList<InvalidConsumerExtensionException>();

		if (requestConsumerExtensionInstances.isEmpty()) {
			deleteConsumerExtensionInstances(consumerExtensionInstances);

			return consumerExtensionExceptions;
		}

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			ConsumerExtensionInstance.class.getName(), request);

		for (ConsumerExtensionInstance requestConsumerExtensionInstance
			: requestConsumerExtensionInstances) {

			ConsumerExtension consumerExtension =
				_consumerExtensionsRegistry.getConsumerExtension(
					requestConsumerExtensionInstance.getConsumerExtensionKey());

			if (consumerExtension == null) {
				continue;
			}

			String typeSettings = null;

			Map<String, String> consumerExtensionValues =
				requestConsumerExtensionInstance.getValues();

			consumerExtensionValues.put(
				"consumerId", String.valueOf(consumerId));

			try {
				typeSettings = consumerExtension.processConsumerExtension(
					request, response,
					requestConsumerExtensionInstance.getConsumerExtensionGuid(),
					consumerExtensionValues);
			}
			catch (InvalidConsumerExtensionException icee) {
				icee.setConsumerExtensionGuid(
					requestConsumerExtensionInstance.
						getConsumerExtensionGuid());

				consumerExtensionExceptions.add(icee);
			}
			catch (Exception e) {
				consumerExtensionExceptions.add(
					new InvalidConsumerExtensionException(e.getMessage()));
			}

			long consumerExtensionInstanceId =
				requestConsumerExtensionInstance.
					getConsumerExtensionInstanceId();

			String key =
				requestConsumerExtensionInstance.getConsumerExtensionKey();

			try {
				if (consumerExtensionInstanceId > 0) {
					ConsumerExtensionInstance consumerExtensionInstance =
						_consumerExtensionInstanceService.
							updateConsumerExtensionInstance(
								consumerExtensionInstanceId, key, consumerId,
								typeSettings, serviceContext);

					consumerExtensionInstances.remove(
						consumerExtensionInstance);
				}
				else {
					_consumerExtensionInstanceService.
						addConsumerExtensionInstance(
							key, consumerId, typeSettings, serviceContext);
				}
			}
			catch (DuplicateConsumerExtensionInstanceException dceie) {
				InvalidConsumerExtensionException icee =
					new InvalidConsumerExtensionException(
						"please-use-a-unique-key");

				icee.setConsumerExtensionGuid(
					requestConsumerExtensionInstance.
						getConsumerExtensionGuid());

				consumerExtensionExceptions.add(icee);
			}
			catch (PortalException pe) {
				_log.error("Cannot update consumer extension", pe);
			}
		}

		deleteConsumerExtensionInstances(consumerExtensionInstances);

		return consumerExtensionExceptions;
	}

	private static Log _log = LogFactoryUtil.getLog(
		ConsumerManagerPortlet.class);

	private ConsumerExtensionInstanceLocalService
		_consumerExtensionInstanceLocalService;
	private ConsumerExtensionInstanceService
		_consumerExtensionInstanceService;
	private ConsumerExtensionsRegistry _consumerExtensionsRegistry;
	private ConsumerLocalService _consumerLocalService;
	private ConsumerService _consumerService;

}