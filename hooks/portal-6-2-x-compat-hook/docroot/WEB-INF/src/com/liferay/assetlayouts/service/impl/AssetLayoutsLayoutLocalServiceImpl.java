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

package com.liferay.assetlayouts.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.systemevent.SystemEventHierarchyEntryThreadLocal;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalService;
import com.liferay.portal.service.LayoutLocalServiceWrapper;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;

import java.util.Locale;
import java.util.Map;

/**
 * @author Eduardo Garcia
 */
public class AssetLayoutsLayoutLocalServiceImpl
		extends LayoutLocalServiceWrapper {

	public AssetLayoutsLayoutLocalServiceImpl(
			LayoutLocalService layoutLocalService) {

		super(layoutLocalService);
	}

	@Override
	public Layout addLayout(
			long userId, long groupId, boolean privateLayout,
			long parentLayoutId, Map<Locale, String> nameMap,
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			Map<Locale, String> keywordsMap, Map<Locale, String> robotsMap,
			String type, String typeSettings, boolean hidden,
			Map<Locale, String> friendlyURLMap, ServiceContext serviceContext)
		throws PortalException, SystemException {

		Layout layout = super.addLayout(
			userId, groupId, privateLayout, parentLayoutId, nameMap, titleMap,
			descriptionMap, keywordsMap, robotsMap, type, typeSettings, hidden,
			friendlyURLMap, serviceContext);

		// Asset

		updateAsset(
			userId, layout, serviceContext.getAssetCategoryIds(),
			serviceContext.getAssetTagNames());

		return layout;
	}

	@Override
	public void deleteLayout(
			Layout layout, boolean updateLayoutSet,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		super.deleteLayout(layout, updateLayoutSet, serviceContext);

		// Asset

		SystemEventHierarchyEntryThreadLocal.pop(
			Layout.class, layout.getPrimaryKey());

		try {
			AssetEntryLocalServiceUtil.deleteEntry(
				Layout.class.getName(), layout.getPrimaryKey());
		}
		finally {
			SystemEventHierarchyEntryThreadLocal.push(
				Layout.class, layout.getPrimaryKey());
		}
	}

	public void updateAsset(
			long userId, Layout layout, long[] assetCategoryIds,
			String[] assetTagNames)
		throws PortalException, SystemException {

		AssetEntryLocalServiceUtil.updateEntry(
			userId, layout.getGroupId(), layout.getCreateDate(),
			layout.getModifiedDate(), Layout.class.getName(),
			layout.getPrimaryKey(), layout.getUuid(), 0, assetCategoryIds,
			assetTagNames, false, null, null, null, ContentTypes.TEXT_HTML,
			layout.getName(LocaleUtil.getDefault()), null, null, null, null, 0,
			0, null, false);
	}

	@Override
	public Layout updateLayout(
			long groupId, boolean privateLayout, long layoutId,
			long parentLayoutId, Map<Locale, String> nameMap,
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			Map<Locale, String> keywordsMap, Map<Locale, String> robotsMap,
			String type, boolean hidden, Map<Locale, String> friendlyURLMap,
			Boolean iconImage, byte[] iconBytes, ServiceContext serviceContext)
		throws PortalException, SystemException {

		Layout layout = super.updateLayout(
			groupId, privateLayout, layoutId, parentLayoutId, nameMap, titleMap,
			descriptionMap, keywordsMap, robotsMap, type, hidden,
			friendlyURLMap, iconImage, iconBytes, serviceContext);

		// Asset

		updateAsset(
			serviceContext.getUserId(), layout,
			serviceContext.getAssetCategoryIds(),
			serviceContext.getAssetTagNames());

		return layout;
	}

}