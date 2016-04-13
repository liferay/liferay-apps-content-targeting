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

package com.liferay.content.targeting.web.display.context;

import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.content.targeting.util.UserSegmentUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletURL;

/**
 * @author Jürgen Kappler
 */
public class ContentTargetingEditCampaignDisplayContext
	extends BaseContentTargetingCampaignDisplayContext {

	public ContentTargetingEditCampaignDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		UserSegmentLocalService userSegmentLocalService) {

		super(
			liferayPortletRequest, liferayPortletResponse,
			userSegmentLocalService);
	}

	public String getRedirect() {
		if (Validator.isNotNull(_redirect)) {
			return _redirect;
		}

		String redirect = ParamUtil.getString(request, "redirect");

		if (Validator.isNull(redirect)) {
			PortletURL redirectURLObject =
				liferayPortletResponse.createRenderURL();

			redirectURLObject.setParameter("mvcPath", "/view.jsp");
			redirectURLObject.setParameter("tabs1", "campaigns");

			redirect = redirectURLObject.toString();
		}

		_redirect = redirect;

		return _redirect;
	}

	public String getVocabularyGroupIds() throws PortalException {
		if (Validator.isNotNull(_vocabularyGroupIds)) {
			return _vocabularyGroupIds;
		}

		long[] vocabularyGroupIds = new long[1];

		if (themeDisplay.getScopeGroupId() ==
				themeDisplay.getCompanyGroupId()) {

			vocabularyGroupIds[0] = themeDisplay.getCompanyGroupId();
		}
		else {
			vocabularyGroupIds =
				ContentTargetingUtil.getAncestorsAndCurrentGroupIds(
					themeDisplay.getSiteGroupId());
		}

		_vocabularyGroupIds = StringUtil.merge(vocabularyGroupIds);

		return _vocabularyGroupIds;
	}

	public String getVocabularyIds() throws PortalException {
		if (Validator.isNotNull(_vocabularyIds)) {
			return _vocabularyIds;
		}

		long[] vocabularyIds = new long[1];

		if (themeDisplay.getScopeGroupId() ==
				themeDisplay.getCompanyGroupId()) {

			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());

			vocabularyIds[0] = UserSegmentUtil.getAssetVocabularyId(
				themeDisplay.getUserId(), serviceContext);
		}
		else {
			long[] vocabularyGroupsIds = StringUtil.split(
				getVocabularyGroupIds(), 0L);

			vocabularyIds = UserSegmentUtil.getAssetVocabularyIds(
				vocabularyGroupsIds);
		}

		_vocabularyIds = StringUtil.merge(vocabularyIds);

		return _vocabularyIds;
	}

	public boolean isActiveCampaign() {
		Campaign campaign = getCampaign();

		if (campaign != null) {
			return campaign.isActive();
		}

		return true;
	}

	private String _redirect;
	private String _vocabularyGroupIds;
	private String _vocabularyIds;

}