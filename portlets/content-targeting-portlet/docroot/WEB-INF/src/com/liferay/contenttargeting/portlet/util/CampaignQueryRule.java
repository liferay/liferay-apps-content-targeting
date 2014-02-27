/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.portlet.util;

import com.liferay.contenttargeting.model.Campaign;
import com.liferay.contenttargeting.service.CampaignLocalService;
import com.liferay.osgi.util.ServiceTrackerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;

import java.util.Locale;

import javax.portlet.PortletRequest;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Eudaldo Alonso
 */
public class CampaignQueryRule {

	public CampaignQueryRule(
			long assetEntryId, long campaignId, int index, Locale locale)
		throws PortalException, SystemException {

		_assetEntryId = assetEntryId;
		_campaignId = campaignId;
		_index = index;

		AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchAssetEntry(
			_assetEntryId);

		if (assetEntry == null) {
			return;
		}

		AssetRendererFactory assetRendererFactory =
			AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(
				assetEntry.getClassName());

		_assetClassName = assetEntry.getClassName();
		_assetClassPK = assetEntry.getClassPK();
		_assetTitle = assetEntry.getTitle(locale);
		_assetType = assetRendererFactory.getTypeName(locale, true);

		try {
			Bundle bundle = FrameworkUtil.getBundle(getClass());

			CampaignLocalService campaignLocalService =
				ServiceTrackerUtil.getService(
					CampaignLocalService.class, bundle.getBundleContext());

			_campaign = campaignLocalService.getCampaign(_campaignId);
		}
		catch (Exception e) {
		}
	}

	public String getAssetClassName() {
		return _assetClassName;
	}

	public long getAssetClassPK() {
		return _assetClassPK;
	}

	public long getAssetEntryId() {
		return _assetEntryId;
	}

	public String getAssetImage(PortletRequest portletRequest)
		throws Exception {

		if (!isValid()) {
			return StringPool.BLANK;
		}

		AssetRendererFactory assetRendererFactory =
			AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(
				_assetClassName);

		AssetRenderer assetRenderer = assetRendererFactory.getAssetRenderer(
			_assetClassPK);

		return assetRenderer.getThumbnailPath(portletRequest);
	}

	public String getAssetTitle() {
		return _assetTitle;
	}

	public String getAssetType() {
		return _assetType;
	}

	public long getCampaignId() {
		return _campaignId;
	}

	public String getCampaignName(Locale locale) {
		if (_campaign != null) {
			return _campaign.getName(locale);
		}

		return StringPool.BLANK;
	}

	public int getCampaignPriority() {
		if (_campaign != null) {
			return _campaign.getPriority();
		}

		return -1;
	}

	public int getIndex() {
		return _index;
	}

	public boolean isValid() {
		if (Validator.isNull(_assetClassName) || (_assetClassPK <= 0) ||
			(_campaignId <= 0)) {

			return false;
		}

		return true;
	}

	public void setAssetClassName(String assetClassName) {
		_assetClassName = assetClassName;
	}

	public void setAssetClassPK(long assetClassPK) {
		_assetClassPK = assetClassPK;
	}

	public void setAssetEntryId(long assetEntryId) {
		_assetEntryId = assetEntryId;
	}

	public void setAssetTitle(String assetTitle) {
		_assetTitle = assetTitle;
	}

	public void setAssetType(String assetType) {
		_assetType = assetType;
	}

	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;
	}

	public void setIndex(int index) {
		_index = index;
	}

	private String _assetClassName = StringPool.BLANK;
	private long _assetClassPK;
	private long _assetEntryId;
	private String _assetTitle = StringPool.BLANK;
	private String _assetType = StringPool.BLANK;
	private Campaign _campaign;
	private long _campaignId;
	private int _index;

}