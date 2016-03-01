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

package com.liferay.content.targeting.report.campaign.tracking.action;

import com.liferay.content.targeting.api.model.BaseReport;
import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.TrackingAction;
import com.liferay.content.targeting.api.model.TrackingActionsRegistry;
import com.liferay.content.targeting.exception.DuplicateTrackingActionInstanceException;
import com.liferay.content.targeting.exception.InvalidReportException;
import com.liferay.content.targeting.exception.InvalidTrackingActionException;
import com.liferay.content.targeting.exception.InvalidTrackingActionsException;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal;
import com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionLocalService;
import com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalLocalService;
import com.liferay.content.targeting.report.campaign.tracking.action.util.TrackingActionTemplate;
import com.liferay.content.targeting.report.campaign.tracking.action.util.comparator.CTActionTotalCountComparator;
import com.liferay.content.targeting.service.ReportInstanceLocalService;
import com.liferay.content.targeting.service.TrackingActionInstanceLocalService;
import com.liferay.content.targeting.service.TrackingActionInstanceService;
import com.liferay.content.targeting.util.ContentTargetingContextUtil;
import com.liferay.content.targeting.util.SearchContainerIterator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.taglib.aui.ValidatorTag;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 */
@Component(immediate = true, service = Report.class)
public class CTActionReport extends BaseReport {

	@Activate
	@Override
	public void activate() {
		super.activate();
	}

	@Deactivate
	@Override
	public void deActivate() {
		super.deActivate();
	}

	@Override
	public String getIcon() {
		return "icon-list-alt";
	}

	@Override
	public String getReportType() {
		return Campaign.class.getName();
	}

	@Override
	public boolean isInstantiable() {
		return true;
	}

	@Override
	public boolean isVisible(long classPK) {
		try {
			if (_trackingActionInstanceLocalService.
					getTrackingActionInstancesCount(classPK) > 0) {

				return true;
			}
		}
		catch (SystemException se) {
			_log.error(se);
		}

		return false;
	}

	@Override
	public String processEditReport(
			PortletRequest request, PortletResponse response,
			ReportInstance reportInstance)
		throws Exception {

		String className = reportInstance.getClassName();

		if (className.equals(Campaign.class.getName())) {
			List<InvalidTrackingActionException> itaeList =
				updateTrackingActions(
					reportInstance.getReportInstanceId(),
					reportInstance.getClassPK(), request, response);

			if (!itaeList.isEmpty()) {
				throw new InvalidTrackingActionsException(itaeList);
			}
		}

		return StringPool.BLANK;
	}

	@Reference(unbind = "-")
	public void setCTActionLocalService(
		CTActionLocalService ctActionLocalService) {

		_ctActionLocalService = ctActionLocalService;
	}

	@Reference(unbind = "-")
	public void setCTActionTotalLocalService(
		CTActionTotalLocalService ctActionTotalLocalService) {

		_ctActionTotalLocalService = ctActionTotalLocalService;
	}

	@Reference(unbind = "-")
	public void setReportInstanceLocalService(
		ReportInstanceLocalService reportInstanceLocalService) {

		_reportInstanceLocalService = reportInstanceLocalService;
	}

	@Reference(unbind = "-")
	public void setTrackingActionInstanceLocalService(
		TrackingActionInstanceLocalService trackingActionInstanceLocalService) {

		_trackingActionInstanceLocalService =
			trackingActionInstanceLocalService;
	}

	@Reference(unbind = "-")
	public void setTrackingActionInstanceService(
		TrackingActionInstanceService trackingActionInstanceService) {

		_trackingActionInstanceService = trackingActionInstanceService;
	}

	@Reference(unbind = "-")
	public void setTrackingActionsRegistry(
		TrackingActionsRegistry trackingActionsRegistry) {

		_trackingActionsRegistry = trackingActionsRegistry;
	}

	@Override
	public void updateReport(ReportInstance reportInstance) {
		try {
			_ctActionLocalService.checkCTActionEvents(
				reportInstance.getReportInstanceId());

			_ctActionTotalLocalService.checkCTActionTotalEvents(
				reportInstance.getReportInstanceId());

			if (reportInstance != null) {
				reportInstance.setModifiedDate(new Date());

				_reportInstanceLocalService.updateReportInstance(
					reportInstance);
			}
		}
		catch (Exception e) {
			_log.error("Cannot update report", e);
		}
	}

	protected void deleteTrackingActionInstances(
			List<TrackingActionInstance> trackingActionInstances)
		throws Exception {

		for (TrackingActionInstance trackingActionInstance
				: trackingActionInstances) {

			_trackingActionInstanceService.deleteTrackingActionInstance(
				trackingActionInstance.getTrackingActionInstanceId());
		}
	}

	protected InvalidTrackingActionsException
		getInvalidTrackingActionsException(PortletRequest portletRequest) {

		if (SessionErrors.contains(
				portletRequest,
				InvalidTrackingActionsException.class.getName())) {

			return (InvalidTrackingActionsException)SessionErrors.get(
				portletRequest,
				InvalidTrackingActionsException.class.getName());
		}
		else if (SessionErrors.contains(
					portletRequest, InvalidReportException.class.getName())) {

			InvalidReportException invalidReportException =
				(InvalidReportException)SessionErrors.get(
					portletRequest, InvalidReportException.class.getName());

			Throwable throwable = invalidReportException.getCause();

			if (throwable instanceof InvalidTrackingActionsException) {
				return (InvalidTrackingActionsException)throwable;
			}
		}

		return new InvalidTrackingActionsException();
	}

	protected Map<String, String> getJSONValues(
		JSONArray data, String namespace, String id) {

		Map<String, String> values = new HashMap<>(data.length());

		for (int i = 0; i < data.length(); i++) {
			JSONObject jsonObject = data.getJSONObject(i);

			String name = jsonObject.getString("name");

			name = StringUtil.replace(
				name, new String[] {namespace, id},
				new String[] {StringPool.BLANK, StringPool.BLANK});

			values.put(name, jsonObject.getString("value"));
		}

		return values;
	}

	protected String getTrackingActionHtml(
		TrackingAction trackingAction,
		TrackingActionInstance trackingActionInstance,
		Map<String, Object> context,
		List<InvalidTrackingActionException> exceptions) {

		Class portletClass = (Class)context.get("portletClass");

		String html = StringPool.BLANK;

		if ((exceptions != null) && !exceptions.isEmpty()) {
			try {
				context.put("exceptions", exceptions);

				html += ContentTargetingContextUtil.parseTemplate(
					portletClass, "templates/ct_exceptions.ftl", context);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		HttpServletRequest request = (HttpServletRequest)context.get("request");

		Map<String, List<ValidatorTag>> validatorTagsMap = new HashMap<>();

		request.setAttribute("aui:form:validatorTagsMap", validatorTagsMap);

		Map<String, String> values = Collections.emptyMap();

		if ((trackingActionInstance != null) &&
			(trackingActionInstance.getValues() != null)) {

			values = trackingActionInstance.getValues();
		}

		html += trackingAction.getFormHTML(
			trackingActionInstance, context, values);

		if (!validatorTagsMap.isEmpty()) {
			try {
				context.put("validatorTagsMap", validatorTagsMap);

				html += ContentTargetingContextUtil.parseTemplate(
					portletClass, "templates/ct_validators.ftl", context);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		return html;
	}

	protected List<TrackingActionInstance> getTrackingActionsFromRequest(
			PortletRequest request, PortletResponse response)
		throws Exception {

		List<TrackingActionInstance> trackingActionsInstances =
			new ArrayList<>();

		String campaignTrackingActions = ParamUtil.getString(
			request, "reportTrackingActions");

		if (Validator.isNull(campaignTrackingActions)) {
			return trackingActionsInstances;
		}

		JSONObject jSONObject = JSONFactoryUtil.createJSONObject(
			campaignTrackingActions);

		String trackingActions = jSONObject.getString("fields");

		JSONArray jSONArray = JSONFactoryUtil.createJSONArray(trackingActions);

		for (int i = 0; i < jSONArray.length(); i++) {
			JSONObject jSONObjectTrackingAction = jSONArray.getJSONObject(i);

			long trackingActionInstanceId = 0;

			String type = jSONObjectTrackingAction.getString("type");

			if (type.contains(StringPool.UNDERLINE)) {
				String[] ids = type.split(StringPool.UNDERLINE);

				trackingActionInstanceId = GetterUtil.getLong(ids[1]);
				type = ids[0];
			}

			String id = jSONObjectTrackingAction.getString("id");

			Map<String, String> trackingActionValues = getJSONValues(
				jSONObjectTrackingAction.getJSONArray("data"),
				response.getNamespace(), id);

			TrackingActionInstance trackingActionInstance =
				_trackingActionInstanceLocalService.
					createTrackingActionInstance(trackingActionInstanceId);

			trackingActionInstance.setTrackingActionGuid(id);
			trackingActionInstance.setTrackingActionKey(type);
			trackingActionInstance.setValues(trackingActionValues);

			trackingActionsInstances.add(trackingActionInstance);
		}

		return trackingActionsInstances;
	}

	@Override
	protected void populateContext(
		ReportInstance reportInstance, Map<String, Object> context) {

		final long reportInstanceId = MapUtil.getLong(
			context, "reportInstanceId", 0);

		context.put(
			"searchContainerIterator",
			new SearchContainerIterator<CTActionTotal>() {

				@Override
				public List<CTActionTotal> getResults(int start, int end)
					throws PortalException {

					return _ctActionTotalLocalService.getCTActionsTotal(
						reportInstanceId, start, end,
						new CTActionTotalCountComparator());
				}

				@Override
				public int getTotal() throws PortalException {
					return _ctActionTotalLocalService.getCTActionsTotalCount(
						reportInstanceId);
				}

			}
		);
	}

	@Override
	protected void populateEditContext(
		ReportInstance reportInstance, Map<String, Object> context) {

		Map<String, TrackingAction> trackingActions =
			_trackingActionsRegistry.getTrackingActions();

		context.put("trackingActions", trackingActions.values());
		context.put("trackingActionsRegistry", _trackingActionsRegistry);

		PortletRequest portletRequest = (PortletRequest)context.get(
			JavaConstants.JAVAX_PORTLET_REQUEST);
		PortletResponse portletResponse = (PortletResponse)context.get(
			JavaConstants.JAVAX_PORTLET_RESPONSE);

		ThemeDisplay themeDisplay = (ThemeDisplay)context.get(
			WebKeys.THEME_DISPLAY);

		boolean isolated = themeDisplay.isIsolated();

		try {
			themeDisplay.setIsolated(true);

			List<TrackingActionInstance> trackingActionInstances =
				getTrackingActionsFromRequest(portletRequest, portletResponse);

			if (trackingActionInstances.isEmpty()) {
				final long reportInstanceId = MapUtil.getLong(
					context, "reportInstanceId", 0);

				trackingActionInstances =
					_trackingActionInstanceService.
						getTrackingActionInstancesByReportInstanceId(
							reportInstanceId);
			}

			List<TrackingActionTemplate> addedTrackingActionTemplates =
				new ArrayList<>();

			if (!trackingActionInstances.isEmpty()) {
				context.put("trackingActionInstances", trackingActionInstances);

				InvalidTrackingActionsException itae =
					getInvalidTrackingActionsException(portletRequest);

				for (TrackingActionInstance instance
						: trackingActionInstances) {

					TrackingAction trackingAction =
						_trackingActionsRegistry.getTrackingAction(
							instance.getTrackingActionKey());

					if (trackingAction == null) {
						continue;
					}

					TrackingActionTemplate trackingActionTemplate =
						new TrackingActionTemplate();

					if (instance.getTrackingActionInstanceId() > 0) {
						trackingActionTemplate.setInstanceId(
							String.valueOf(
								instance.getTrackingActionInstanceId()));
					}
					else {
						trackingActionTemplate.setInstanceId(
							instance.getTrackingActionGuid());
					}

					trackingActionTemplate.setTrackingAction(trackingAction);

					List<InvalidTrackingActionException> exceptions =
						itae.getExceptions(instance.getTrackingActionGuid());

					String html = getTrackingActionHtml(
						trackingAction, instance, context, exceptions);

					trackingActionTemplate.setTemplate(
						HtmlUtil.escapeAttribute(html));

					addedTrackingActionTemplates.add(trackingActionTemplate);
				}
			}

			context.put(
				"addedTrackingActionTemplates", addedTrackingActionTemplates);

			List<TrackingActionTemplate> trackingActionTemplates =
				new ArrayList<>();

			for (TrackingAction trackingAction
					: trackingActions.values()) {

				if (!trackingAction.isVisible()) {
					continue;
				}

				TrackingActionTemplate trackingActionTemplate =
					new TrackingActionTemplate();

				trackingActionTemplate.setTrackingAction(trackingAction);

				String html = getTrackingActionHtml(
					trackingAction, null, context, null);

				trackingActionTemplate.setTemplate(
					HtmlUtil.escapeAttribute(html));

				trackingActionTemplates.add(trackingActionTemplate);
			}

			context.put("trackingActionTemplates", trackingActionTemplates);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
		finally {
			themeDisplay.setIsolated(isolated);
		}
	}

	protected List<InvalidTrackingActionException> updateTrackingActions(
			long reportInstanceId, long campaignId, PortletRequest request,
			PortletResponse response)
		throws Exception {

		List<TrackingActionInstance> requestTrackingActionInstances =
			getTrackingActionsFromRequest(request, response);

		List<TrackingActionInstance> trackingActionInstances = ListUtil.copy(
			_trackingActionInstanceService.
				getTrackingActionInstancesByReportInstanceId(reportInstanceId));

		List<InvalidTrackingActionException> trackingActionExceptions =
			new ArrayList<>();

		if (requestTrackingActionInstances.isEmpty()) {
			deleteTrackingActionInstances(trackingActionInstances);

			return trackingActionExceptions;
		}

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			TrackingActionInstance.class.getName(), request);

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		for (TrackingActionInstance requestTrackingActionInstance
				: requestTrackingActionInstances) {

			TrackingAction trackingAction =
				_trackingActionsRegistry.getTrackingAction(
					requestTrackingActionInstance.getTrackingActionKey());

			if (trackingAction == null) {
				continue;
			}

			String typeSettings = null;

			Map<String, String> trackingActionValues =
				requestTrackingActionInstance.getValues();

			try {
				typeSettings = trackingAction.processTrackingAction(
					request, response,
					requestTrackingActionInstance.getTrackingActionGuid(),
					trackingActionValues);
			}
			catch (InvalidTrackingActionException itae) {
				itae.setTrackingActionGuid(
					requestTrackingActionInstance.getTrackingActionGuid());

				trackingActionExceptions.add(itae);
			}
			catch (Exception e) {
				trackingActionExceptions.add(
					new InvalidTrackingActionException(e.getMessage()));
			}

			String alias = trackingActionValues.get("alias");
			String referrerClassName = trackingActionValues.get(
				"referrerClassName");
			long referrerClassPK = GetterUtil.getLong(
				trackingActionValues.get("referrerClassPK"));
			String elementId = trackingActionValues.get("elementId");
			String eventType = trackingActionValues.get("eventType");

			long trackingActionInstanceId =
				requestTrackingActionInstance.getTrackingActionInstanceId();

			try {
				if (trackingActionInstanceId > 0) {
					TrackingActionInstance trackingActionInstance =
						_trackingActionInstanceService.
							updateTrackingActionInstance(
								trackingActionInstanceId, reportInstanceId,
								alias, referrerClassName, referrerClassPK,
								elementId, eventType, typeSettings,
								serviceContext);

					trackingActionInstances.remove(trackingActionInstance);
				}
				else {
					_trackingActionInstanceService.addTrackingActionInstance(
						themeDisplay.getUserId(), reportInstanceId,
						requestTrackingActionInstance.getTrackingActionKey(),
						campaignId, alias, referrerClassName, referrerClassPK,
						elementId, eventType, typeSettings, serviceContext);
				}
			}
			catch (DuplicateTrackingActionInstanceException dtaie) {
				InvalidTrackingActionException itae =
					new InvalidTrackingActionException(
						"please-use-a-unique-alias");

				itae.setTrackingActionGuid(
					requestTrackingActionInstance.getTrackingActionGuid());

				trackingActionExceptions.add(itae);
			}
			catch (PortalException pe) {
				_log.error("Cannot update tracking action", pe);
			}
		}

		// Delete removed Tracking Actions

		deleteTrackingActionInstances(trackingActionInstances);

		return trackingActionExceptions;
	}

	private static final Log _log = LogFactoryUtil.getLog(CTActionReport.class);

	private CTActionLocalService _ctActionLocalService;
	private CTActionTotalLocalService _ctActionTotalLocalService;
	private ReportInstanceLocalService _reportInstanceLocalService;
	private TrackingActionInstanceLocalService
		_trackingActionInstanceLocalService;
	private TrackingActionInstanceService _trackingActionInstanceService;
	private TrackingActionsRegistry _trackingActionsRegistry;

}