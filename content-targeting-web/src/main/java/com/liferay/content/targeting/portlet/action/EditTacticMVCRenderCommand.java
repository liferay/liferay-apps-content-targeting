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

package com.liferay.content.targeting.portlet.action;

import com.liferay.content.targeting.api.model.Channel;
import com.liferay.content.targeting.api.model.ChannelsRegistry;
import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.content.targeting.exception.InvalidChannelException;
import com.liferay.content.targeting.exception.InvalidChannelsException;
import com.liferay.content.targeting.model.ChannelInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.portlet.ContentTargetingMVCCommand;
import com.liferay.content.targeting.portlet.ContentTargetingPath;
import com.liferay.content.targeting.portlet.util.ChannelTemplate;
import com.liferay.content.targeting.service.ChannelInstanceLocalService;
import com.liferay.content.targeting.service.ChannelInstanceService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.util.ContentTargetingContextUtil;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.content.targeting.util.UserSegmentUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.taglib.aui.ValidatorTag;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PortletKeys.CT_ADMIN,
		"mvc.command.name=" + ContentTargetingMVCCommand.EDIT_TACTIC
	},
	service = MVCRenderCommand.class
)
public class EditTacticMVCRenderCommand extends BaseMVCRenderCommand {

	@Override
	public String doRender(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		long campaignId = ParamUtil.getLong(renderRequest, "campaignId");
		long tacticId = ParamUtil.getLong(renderRequest, "tacticId");

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		boolean isolated = themeDisplay.isIsolated();

		try {
			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());

			long[] vocabularyGroupIds = new long[1];
			long[] vocabularyIds = new long[1];

			if (themeDisplay.getScopeGroupId() ==
					themeDisplay.getCompanyGroupId()) {

				vocabularyGroupIds[0] = themeDisplay.getCompanyGroupId();

				vocabularyIds[0] = UserSegmentUtil.getAssetVocabularyId(
					themeDisplay.getUserId(), serviceContext);
			}
			else {
				vocabularyGroupIds =
					ContentTargetingUtil.getAncestorsAndCurrentGroupIds(
						themeDisplay.getSiteGroupId());
				vocabularyIds = UserSegmentUtil.getAssetVocabularyIds(
					vocabularyGroupIds);
			}

			renderRequest.setAttribute(
				"vocabularyGroupIds", StringUtil.merge(vocabularyGroupIds));
			renderRequest.setAttribute(
				"vocabularyIds", StringUtil.merge(vocabularyIds));

			String userSegmentAssetCategoryIdsAsString = StringPool.BLANK;
			String userSegmentAssetCategoryNames = StringPool.BLANK;

			List<UserSegment> campaignUserSegments = null;

			campaignUserSegments =
				_userSegmentLocalService.getCampaignUserSegments(campaignId);

			long[] userSegmentAssetCategoryIds =
				ContentTargetingUtil.getAssetCategoryIds(campaignUserSegments);

			userSegmentAssetCategoryIdsAsString = StringUtil.merge(
				userSegmentAssetCategoryIds);

			userSegmentAssetCategoryNames =
				ContentTargetingUtil.getAssetCategoryNames(
					userSegmentAssetCategoryIds, themeDisplay.getLocale());

			renderRequest.setAttribute(
				"userSegmentAssetCategoryIdsAsString",
				userSegmentAssetCategoryIdsAsString);
			renderRequest.setAttribute(
				"userSegmentAssetCategoryNames", userSegmentAssetCategoryNames);

			Map<String, Report> reports = _reportsRegistry.getReports(
				UserSegment.class.getName());

			renderRequest.setAttribute("reports", reports.values());

			Map<String, Channel> channels = _channelsRegistry.getChannels();

			renderRequest.setAttribute("channels", channels.values());

			List<ChannelInstance> channelInstances = getChannelsFromRequest(
				renderRequest, renderResponse);

			if (channelInstances.isEmpty() && (tacticId > 0)) {
				channelInstances =
					_channelInstanceLocalService.getChannelInstances(tacticId);
			}

			List<ChannelTemplate> addedChannelTemplates = new ArrayList<>();

			if (!channelInstances.isEmpty()) {
				renderRequest.setAttribute(
					"channelInstances", channelInstances);

				InvalidChannelsException ice = getInvalidChannelsException(
					renderRequest);

				for (ChannelInstance channelInstance : channelInstances) {
					Channel channel = _channelsRegistry.getChannel(
						channelInstance.getChannelKey());

					if (channel == null) {
						continue;
					}

					ChannelTemplate channelTemplate = new ChannelTemplate();

					if (channelInstance.getChannelInstanceId() > 0) {
						channelTemplate.setInstanceId(
							String.valueOf(
								channelInstance.getChannelInstanceId()));
					}
					else {
						channelTemplate.setInstanceId(
							channelInstance.getChannelGuid());
					}

					channelTemplate.setChannel(channel);

					String html = getChannelHtml(
						channel, channelInstance, renderRequest, renderResponse,
						channelInstance.getValues(),
						ice.getExceptions(channelInstance.getChannelGuid()));

					channelTemplate.setTemplate(HtmlUtil.escapeAttribute(html));

					addedChannelTemplates.add(channelTemplate);
				}
			}

			renderRequest.setAttribute(
				"addedChannelTemplates", addedChannelTemplates);

			List<ChannelTemplate> channelTemplates = new ArrayList<>();

			for (Channel channel : channels.values()) {
				if (!channel.isVisible()) {
					continue;
				}

				ChannelTemplate channelTemplate = new ChannelTemplate();

				channelTemplate.setChannel(channel);

				String html = getChannelHtml(
					channel, null, renderRequest, renderResponse, null, null);

				channelTemplate.setTemplate(HtmlUtil.escapeAttribute(html));

				channelTemplates.add(channelTemplate);
			}

			renderRequest.setAttribute("channelTemplates", channelTemplates);
		}
		finally {
			themeDisplay.setIsolated(isolated);
		}

		return ContentTargetingPath.EDIT_TACTIC;
	}

	protected String getChannelHtml(
		Channel channel, ChannelInstance channelInstance,
		RenderRequest renderRequest, RenderResponse renderResponse,
		Map<String, String> values, List<InvalidChannelException> exceptions) {

		Map<String, Object> context = cloneRequestContext(
			renderRequest, renderResponse);

		String html = StringPool.BLANK;

		if ((exceptions != null) && !exceptions.isEmpty()) {
			try {
				context.put("exceptions", exceptions);

				html += ContentTargetingContextUtil.parseTemplate(
					getClass(), "templates/ct_exceptions.ftl", context);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			renderRequest);

		Map<String, List<ValidatorTag>> validatorTagsMap = new HashMap<>();

		request.setAttribute("aui:form:validatorTagsMap", validatorTagsMap);

		if (values == null) {
			values = Collections.emptyMap();
		}

		html += channel.getFormHTML(channelInstance, context, values);

		if (!validatorTagsMap.isEmpty()) {
			try {
				context.put("validatorTagsMap", validatorTagsMap);

				html += ContentTargetingContextUtil.parseTemplate(
					getClass(), "templates/ct_validators.ftl", context);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		return html;
	}

	protected List<ChannelInstance> getChannelsFromRequest(
			PortletRequest request, PortletResponse response)
		throws Exception {

		List<ChannelInstance> channelInstances = new ArrayList<>();

		String tacticChannels = ParamUtil.getString(request, "tacticChannels");

		if (Validator.isNull(tacticChannels)) {
			return channelInstances;
		}

		JSONObject jSONObject = JSONFactoryUtil.createJSONObject(
			tacticChannels);

		String channels = jSONObject.getString("fields");

		JSONArray jSONArray = JSONFactoryUtil.createJSONArray(channels);

		for (int i = 0; i < jSONArray.length(); i++) {
			JSONObject jSONObjectChannel = jSONArray.getJSONObject(i);

			long channelInstanceId = 0;

			String type = jSONObjectChannel.getString("type");

			if (type.contains(StringPool.UNDERLINE)) {
				String[] ids = type.split(StringPool.UNDERLINE);

				channelInstanceId = GetterUtil.getLong(ids[1]);
				type = ids[0];
			}

			String id = jSONObjectChannel.getString("id");

			Map<String, String> channelValues = getJSONValues(
				jSONObjectChannel.getJSONArray("data"), response.getNamespace(),
				id);

			ChannelInstance channelInstance =
				_channelInstanceLocalService.createChannelInstance(
					channelInstanceId);

			channelInstance.setChannelGuid(id);
			channelInstance.setChannelKey(type);
			channelInstance.setValues(channelValues);

			channelInstances.add(channelInstance);
		}

		return channelInstances;
	}

	protected InvalidChannelsException getInvalidChannelsException(
		PortletRequest portletRequest) {

		if (SessionErrors.contains(
				portletRequest, InvalidChannelsException.class.getName())) {

			return (InvalidChannelsException)SessionErrors.get(
				portletRequest, InvalidChannelsException.class.getName());
		}
		else {
			return new InvalidChannelsException();
		}
	}

	@Reference(unbind = "unsetChannelInstanceLocalService")
	protected void setChannelInstanceLocalService(
		ChannelInstanceLocalService channelInstanceLocalService) {

		_channelInstanceLocalService = channelInstanceLocalService;
	}

	@Reference(unbind = "unsetChannelInstanceService")
	protected void setChannelInstanceService(
		ChannelInstanceService channelInstanceService) {

		_channelInstanceService = channelInstanceService;
	}

	@Reference(unbind = "unsetChannelsRegistry")
	protected void setChannelsRegistry(ChannelsRegistry channelsRegistry) {
		_channelsRegistry = channelsRegistry;
	}

	@Reference(unbind = "unsetReportsRegistry")
	protected void setReportsRegistry(ReportsRegistry reportsRegistry) {
		_reportsRegistry = reportsRegistry;
	}

	@Reference(unbind = "unsetUserSegmentLocalService")
	protected void setUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {

		_userSegmentLocalService = userSegmentLocalService;
	}

	protected void unsetChannelInstanceLocalService() {
		_channelInstanceLocalService = null;
	}

	protected void unsetChannelInstanceService() {
		_channelInstanceService = null;
	}

	protected void unsetChannelsRegistry() {
		_channelsRegistry = null;
	}

	protected void unsetReportsRegistry() {
		_reportsRegistry = null;
	}

	protected void unsetUserSegmentLocalService() {
		_userSegmentLocalService = null;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		com.liferay.content.targeting.portlet.action.EditTacticMVCRenderCommand.class);

	private ChannelInstanceLocalService _channelInstanceLocalService;
	private ChannelInstanceService _channelInstanceService;
	private ChannelsRegistry _channelsRegistry;
	private ReportsRegistry _reportsRegistry;
	private UserSegmentLocalService _userSegmentLocalService;

}