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
import com.liferay.content.targeting.exception.DuplicateChannelInstanceException;
import com.liferay.content.targeting.exception.InvalidChannelException;
import com.liferay.content.targeting.exception.InvalidChannelsException;
import com.liferay.content.targeting.exception.InvalidDateRangeException;
import com.liferay.content.targeting.exception.InvalidNameException;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ChannelInstance;
import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.portlet.ContentTargetingMVCCommand;
import com.liferay.content.targeting.portlet.ContentTargetingPath;
import com.liferay.content.targeting.service.ChannelInstanceLocalService;
import com.liferay.content.targeting.service.ChannelInstanceService;
import com.liferay.content.targeting.service.TacticService;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.transaction.TransactionInvokerUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PortletKeys.CT_ADMIN,
		"mvc.command.name=" + ContentTargetingMVCCommand.UPDATE_TACTIC
	},
	service = MVCActionCommand.class
)
public class UpdateTacticMVCActionCommand extends BaseMVCActionCommand {

	protected void deleteChannelInstances(
			List<ChannelInstance> channelInstances)
		throws Exception {

		for (ChannelInstance channelInstance : channelInstances) {
			_channelInstanceService.deleteChannelInstance(
				channelInstance.getChannelInstanceId());
		}
	}

	@Override
	protected void doProcessAction(
			ActionRequest request, ActionResponse response)
		throws Exception {

		long campaignId = ParamUtil.getLong(request, "campaignId");

		long tacticId = ParamUtil.getLong(request, "tacticId");

		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
			request, "name");
		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(request, "description");

		long[] userSegmentIds = null;
		long[] userSegmentAssetCategoryIds = ParamUtil.getLongValues(
			request, "userSegmentAssetCategoryIds");

		if (!ArrayUtil.isEmpty(userSegmentAssetCategoryIds)) {
			userSegmentIds = new long[userSegmentAssetCategoryIds.length];
			int userSegmentCount = 0;

			for (long userSegmentAssetCategoryId
					: userSegmentAssetCategoryIds) {

				UserSegment userSegment =
					UserSegmentLocalServiceUtil.
						fetchUserSegmentByAssetCategoryId(
							userSegmentAssetCategoryId);

				userSegmentIds[userSegmentCount++] =
					userSegment.getUserSegmentId();
			}
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Campaign.class.getName(), request);

		try {
			Callable<Tactic> tacticCallable = new TacticCallable(
				request, response, themeDisplay.getUserId(), campaignId,
				tacticId, nameMap, descriptionMap, userSegmentIds,
				serviceContext);

			Tactic tactic = TransactionInvokerUtil.invoke(
				_transactionConfig, tacticCallable);

			boolean saveAndContinue = ParamUtil.get(
				request, "saveAndContinue", false);

			if (saveAndContinue) {
				String redirect = ParamUtil.get(request, "redirect", "");

				response.setRenderParameter(
					"campaignId", String.valueOf(campaignId));
				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.EDIT_TACTIC);
				response.setRenderParameter("redirect", redirect);
				response.setRenderParameter(
					"p_p_mode", PortletMode.VIEW.toString());
				response.setRenderParameter(
					"tacticId", String.valueOf(tactic.getTacticId()));

				addSuccessMessage(request, response);
			}
			else {
				sendRedirect(request, response);
			}
		}
		catch (Exception e) {
			PortalUtil.copyRequestParameters(request, response);

			SessionErrors.add(request, e.getClass(), e);

			if (e instanceof InvalidDateRangeException ||
				e instanceof InvalidNameException ||
				e instanceof InvalidChannelsException ||
				e instanceof PrincipalException) {

				SessionMessages.add(
					request,
					PortalUtil.getPortletId(request) +
						SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.EDIT_TACTIC);
			}
			else {
				response.setRenderParameter(
					"mvcPath", ContentTargetingPath.ERROR);
			}
		}
		catch (Throwable t) {
			_log.error(t);

			response.setRenderParameter("mvcPath", ContentTargetingPath.ERROR);
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

	@Reference(
		target = "(mvc.command.name=" + ContentTargetingMVCCommand.EDIT_TACTIC + ")",
		unbind = "unsetMVCRenderCommand"
	)
	protected void setMVCRenderCommand(MVCRenderCommand mvcRenderCommand) {
		_mvcRenderCommand = mvcRenderCommand;
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

	protected void unsetMVCRenderCommand() {
		_mvcRenderCommand = null;
	}

	protected void unsetTacticService() {
		_tacticService = null;
	}

	protected List<InvalidChannelException> updateChannels(
			long tacticId, long campaignId, PortletRequest request,
			PortletResponse response)
		throws Exception {

		EditTacticMVCRenderCommand editTacticMVCActionCommand =
			(EditTacticMVCRenderCommand)_mvcRenderCommand;

		List<ChannelInstance> requestChannelInstances =
			editTacticMVCActionCommand.getChannelsFromRequest(
				request, response);

		List<ChannelInstance> channelInstances = ListUtil.copy(
			_channelInstanceService.getChannelInstances(campaignId, tacticId));

		List<InvalidChannelException> channelExceptions = new ArrayList<>();

		if (requestChannelInstances.isEmpty()) {
			deleteChannelInstances(channelInstances);

			return channelExceptions;
		}

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			ChannelInstance.class.getName(), request);

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		for (ChannelInstance requestChannelInstance : requestChannelInstances) {
			Channel channel = _channelsRegistry.getChannel(
				requestChannelInstance.getChannelKey());

			if (channel == null) {
				continue;
			}

			String typeSettings = null;

			Map<String, String> channelValues =
				requestChannelInstance.getValues();
			channelValues.put("tacticId", String.valueOf(tacticId));

			try {
				typeSettings = channel.processChannel(
					request, response, requestChannelInstance.getChannelGuid(),
					channelValues);
			}
			catch (InvalidChannelException ice) {
				channelExceptions.add(ice);
			}
			catch (Exception e) {
				channelExceptions.add(
					new InvalidChannelException(e.getMessage()));
			}

			String alias = channelValues.get("alias");

			long channelInstanceId =
				requestChannelInstance.getChannelInstanceId();

			try {
				if (channelInstanceId > 0) {
					ChannelInstance channelInstance =
						_channelInstanceService.updateChannelInstance(
							channelInstanceId, alias, typeSettings,
							serviceContext);

					channelInstances.remove(channelInstance);
				}
				else {
					_channelInstanceService.addChannelInstance(
						themeDisplay.getUserId(), tacticId,
						requestChannelInstance.getChannelKey(), campaignId,
						alias, typeSettings, serviceContext);
				}
			}
			catch (DuplicateChannelInstanceException dcie) {
				InvalidChannelException ice = new InvalidChannelException(
					"please-use-a-unique-alias");

				ice.setChannelGuid(requestChannelInstance.getChannelGuid());

				channelExceptions.add(ice);
			}
			catch (PortalException pe) {
				_log.error("Cannot update channel", pe);
			}
		}

		deleteChannelInstances(channelInstances);

		return channelExceptions;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UpdateTacticMVCActionCommand.class);

	private ChannelInstanceLocalService _channelInstanceLocalService;
	private ChannelInstanceService _channelInstanceService;
	private ChannelsRegistry _channelsRegistry;
	private MVCRenderCommand _mvcRenderCommand;
	private volatile TacticService _tacticService;

	private class TacticCallable implements Callable<Tactic> {

		@Override
		public Tactic call() throws Exception {
			Tactic tactic = null;

			if (_tacticId > 0) {
				tactic = _tacticService.updateTactic(
					_tacticId, _campaignId, _nameMap, _descriptionMap,
					_userSegmentIds, _serviceContext);
			}
			else {
				tactic = _tacticService.addTactic(
					_userId, _campaignId, _nameMap, _descriptionMap,
					_userSegmentIds, _serviceContext);
			}

			List<InvalidChannelException> channelExceptions = updateChannels(
				tactic.getTacticId(), _campaignId, _portletRequest,
				_portletResponse);

			if (!channelExceptions.isEmpty()) {
				throw new InvalidChannelsException(channelExceptions);
			}

			return tactic;
		}

		private TacticCallable(
			PortletRequest portletRequest, PortletResponse portletResponse,
			long userId, long campaignId, long tacticId,
			Map<Locale, String> nameMap, Map<Locale, String> descriptionMap,
			long[] userSegmentIds, ServiceContext serviceContext) {

			_portletRequest = portletRequest;
			_portletResponse = portletResponse;
			_userId = userId;
			_campaignId = campaignId;
			_tacticId = tacticId;
			_nameMap = nameMap;
			_descriptionMap = descriptionMap;
			_userSegmentIds = userSegmentIds;
			_serviceContext = serviceContext;
		}

		private final long _campaignId;
		private final Map<Locale, String> _descriptionMap;
		private final Map<Locale, String> _nameMap;
		private final PortletRequest _portletRequest;
		private final PortletResponse _portletResponse;
		private final ServiceContext _serviceContext;
		private final long _tacticId;
		private final long _userId;
		private final long[] _userSegmentIds;

	}

}