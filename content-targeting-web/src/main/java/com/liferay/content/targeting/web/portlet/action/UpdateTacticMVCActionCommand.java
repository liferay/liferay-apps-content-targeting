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

package com.liferay.content.targeting.web.portlet.action;

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
import com.liferay.content.targeting.service.ChannelInstanceLocalService;
import com.liferay.content.targeting.service.ChannelInstanceService;
import com.liferay.content.targeting.service.TacticService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.content.targeting.web.display.context.ContentTargetingEditTacticsDisplayContext;
import com.liferay.content.targeting.web.portlet.ContentTargetingMVCCommand;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
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
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long campaignId = ParamUtil.getLong(actionRequest, "campaignId");

		long tacticId = ParamUtil.getLong(actionRequest, "tacticId");

		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
			actionRequest, "name");
		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "description");

		long[] userSegmentIds = null;
		long[] userSegmentAssetCategoryIds = ParamUtil.getLongValues(
			actionRequest, "userSegmentAssetCategoryIds");

		if (!ArrayUtil.isEmpty(userSegmentAssetCategoryIds)) {
			userSegmentIds = new long[userSegmentAssetCategoryIds.length];
			int userSegmentCount = 0;

			for (long userSegmentAssetCategoryId
					: userSegmentAssetCategoryIds) {

				UserSegment userSegment =
					_userSegmentLocalService.fetchUserSegmentByAssetCategoryId(
						userSegmentAssetCategoryId);

				userSegmentIds[userSegmentCount++] =
					userSegment.getUserSegmentId();
			}
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Campaign.class.getName(), actionRequest);

		try {
			Callable<Tactic> tacticCallable = new TacticCallable(
				actionRequest, actionResponse, themeDisplay.getUserId(),
				campaignId, tacticId, nameMap, descriptionMap, userSegmentIds,
				_tacticService, serviceContext);

			Tactic tactic = TransactionInvokerUtil.invoke(
				transactionConfig, tacticCallable);

			boolean saveAndContinue = ParamUtil.get(
				actionRequest, "saveAndContinue", false);

			if (saveAndContinue) {
				String redirect = ParamUtil.get(actionRequest, "redirect", "");

				actionResponse.setRenderParameter(
					"mvcRenderCommandName",
					ContentTargetingMVCCommand.EDIT_TACTIC);
				actionResponse.setRenderParameter(
					"campaignId", String.valueOf(campaignId));
				actionResponse.setRenderParameter("redirect", redirect);
				actionResponse.setRenderParameter(
					"p_p_mode", PortletMode.VIEW.toString());
				actionResponse.setRenderParameter(
					"tacticId", String.valueOf(tactic.getTacticId()));

				addSuccessMessage(actionRequest, actionResponse);
			}
			else {
				sendRedirect(actionRequest, actionResponse);
			}
		}
		catch (Exception e) {
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);

			LiferayPortletRequest liferayPortletRequest =
				PortalUtil.getLiferayPortletRequest(actionRequest);
			LiferayPortletResponse liferayPortletResponse =
				PortalUtil.getLiferayPortletResponse(actionResponse);

			ContentTargetingEditTacticsDisplayContext
				contentTargetingEditTacticsDisplayContext =
					new ContentTargetingEditTacticsDisplayContext(
						liferayPortletRequest, liferayPortletResponse,
						_userSegmentLocalService);

			actionRequest.setAttribute(
				"contentTargetingEditTacticsDisplayContext",
				contentTargetingEditTacticsDisplayContext);

			SessionErrors.add(actionRequest, e.getClass(), e);

			if (e instanceof InvalidDateRangeException ||
				e instanceof InvalidNameException ||
				e instanceof InvalidChannelsException ||
				e instanceof PrincipalException) {

				SessionMessages.add(
					actionRequest,
					PortalUtil.getPortletId(actionRequest) +
						SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

				actionResponse.setRenderParameter(
					"mvcRenderCommandName",
					ContentTargetingMVCCommand.EDIT_TACTIC);
			}
			else {
				actionResponse.setRenderParameter("mvcPath", "/error.jsp");
			}
		}
		catch (Throwable t) {
			_log.error(t);

			actionResponse.setRenderParameter("mvcPath", "/error.jsp");
		}
	}

	@Reference(unbind = "-")
	protected void setChannelInstanceLocalService(
		ChannelInstanceLocalService channelInstanceLocalService) {

		_channelInstanceLocalService = channelInstanceLocalService;
	}

	@Reference(unbind = "-")
	protected void setChannelInstanceService(
		ChannelInstanceService channelInstanceService) {

		_channelInstanceService = channelInstanceService;
	}

	@Reference
	protected void setChannelsRegistry(ChannelsRegistry channelsRegistry) {
		_channelsRegistry = channelsRegistry;
	}

	@Reference(
		target = "(mvc.command.name=" + ContentTargetingMVCCommand.EDIT_TACTIC + ")"
	)
	protected void setMVCRenderCommand(MVCRenderCommand mvcRenderCommand) {
		_mvcRenderCommand = mvcRenderCommand;
	}

	@Reference(unbind = "-")
	protected void setTacticService(TacticService tacticService) {
		_tacticService = tacticService;
	}

	@Reference(unbind = "-")
	protected void setUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {

		_userSegmentLocalService = userSegmentLocalService;
	}

	protected void unsetChannelsRegistry(ChannelsRegistry channelsRegistry) {
		_channelsRegistry = null;
	}

	protected void unsetMVCRenderCommand(MVCRenderCommand mvcRenderCommand) {
		_mvcRenderCommand = null;
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
	private TacticService _tacticService;
	private UserSegmentLocalService _userSegmentLocalService;

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
			long[] userSegmentIds, TacticService tacticService,
			ServiceContext serviceContext) {

			_portletRequest = portletRequest;
			_portletResponse = portletResponse;
			_userId = userId;
			_campaignId = campaignId;
			_tacticId = tacticId;
			_nameMap = nameMap;
			_descriptionMap = descriptionMap;
			_userSegmentIds = userSegmentIds;
			_tacticService = tacticService;
			_serviceContext = serviceContext;
		}

		private final long _campaignId;
		private final Map<Locale, String> _descriptionMap;
		private final Map<Locale, String> _nameMap;
		private final PortletRequest _portletRequest;
		private final PortletResponse _portletResponse;
		private final ServiceContext _serviceContext;
		private final long _tacticId;
		private final TacticService _tacticService;
		private final long _userId;
		private final long[] _userSegmentIds;

	}

}