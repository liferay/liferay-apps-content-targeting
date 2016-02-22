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

package com.liferay.content.targeting.portlet.util;

import com.liferay.asset.kernel.model.AssetEntry;

import java.util.Locale;

import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;

/**
 * @author Julio Camarero
 */
public interface QueryRule extends Comparable<QueryRule> {

	public boolean evaluate(long[] ids);

	public String getAssetClassName();

	public long getAssetClassPK();

	public AssetEntry getAssetEntry();

	public long getAssetEntryId();

	public String getAssetImage(PortletRequest portletRequest) throws Exception;

	public String getAssetTitle();

	public String getAssetType();

	public String getCssClass(int position);

	public long getGroupId(long scopeGroupId);

	public int getIndex();

	public String getSummary(PortletConfig portletConfig, Locale locale);

	public String getTemplate();

	public boolean hasAssetEntry();

	public boolean isDefaultRule();

	public boolean isValid();

	public void setAssetAttributes(PortletRequest portletRequest);

	public void setAssetClassName(String assetClassName);

	public void setAssetClassPK(long assetClassPK);

	public void setAssetEntryId(long assetEntryId);

	public void setAssetTitle(String assetTitle);

	public void setAssetType(String assetType);

	public void setIndex(int index);

	public void setTemplate(String template);

}