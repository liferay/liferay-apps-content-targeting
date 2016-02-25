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

import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.portlet.ContentTargetingMVCCommand;
import com.liferay.content.targeting.portlet.ContentTargetingPath;
import com.liferay.content.targeting.service.ReportInstanceLocalService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.content.targeting.util.UserSegmentUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PortletKeys.CT_ADMIN,
		"mvc.command.name=" + ContentTargetingMVCCommand.EDIT_CAMPAIGN
	},
	service = MVCRenderCommand.class
)
public class EditCampaignMVCActionCommand extends BaseMVCRenderCommand {

	@Override
	public String doRender(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		long campaignId = ParamUtil.getLong(renderRequest, "campaignId");

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

			Map<String, Report> reports = _reportsRegistry.getReports(
				Campaign.class.getName());

			renderRequest.setAttribute("reports", reports.values());

			if (campaignId > 0) {
				List<UserSegment> campaignUserSegments = null;

				campaignUserSegments =
					_userSegmentLocalService.getCampaignUserSegments(
						campaignId);

				long[] userSegmentAssetCategoryIds =
					ContentTargetingUtil.getAssetCategoryIds(
						campaignUserSegments);

				userSegmentAssetCategoryIdsAsString = StringUtil.merge(
					userSegmentAssetCategoryIds);

				userSegmentAssetCategoryNames =
					ContentTargetingUtil.getAssetCategoryNames(
						userSegmentAssetCategoryIds, themeDisplay.getLocale());

				for (Report report : reports.values()) {
					if (report.isInstantiable()) {
						continue;
					}

					if (_reportInstanceLocalService.getReportInstanceCount(
							report.getReportKey(), Campaign.class.getName(),
							campaignId)
								> 0) {

						continue;
					}

					_reportInstanceLocalService.addReportInstance(
						themeDisplay.getUserId(), report.getReportKey(),
						Campaign.class.getName(), campaignId, StringPool.BLANK,
						serviceContext);
				}
			}

			renderRequest.setAttribute(
				"userSegmentAssetCategoryIdsAsString",
				userSegmentAssetCategoryIdsAsString);
			renderRequest.setAttribute(
				"userSegmentAssetCategoryNames", userSegmentAssetCategoryNames);
		}
		finally {
			themeDisplay.setIsolated(isolated);
		}

		return ContentTargetingPath.EDIT_CAMPAIGN;
	}

	@Reference(unbind = "unsetReportInstanceLocalService")
	protected void setReportInstanceLocalService(
		ReportInstanceLocalService reportInstanceLocalService) {

		_reportInstanceLocalService = reportInstanceLocalService;
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

	protected void unsetReportInstanceLocalService() {
		_reportInstanceLocalService = null;
	}

	protected void unsetReportsRegistry() {
		_reportsRegistry = null;
	}

	protected void unsetUserSegmentLocalService() {
		_userSegmentLocalService = null;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		EditCampaignMVCActionCommand.class);

	private ReportInstanceLocalService _reportInstanceLocalService;
	private ReportsRegistry _reportsRegistry;
	private UserSegmentLocalService _userSegmentLocalService;

}