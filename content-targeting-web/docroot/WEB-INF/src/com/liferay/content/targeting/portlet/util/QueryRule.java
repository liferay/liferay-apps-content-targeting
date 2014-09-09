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

import com.liferay.portlet.asset.model.AssetEntry;

import javax.portlet.PortletRequest;

/**
 * @author Julio Camarero
 */
public interface QueryRule extends Comparable<QueryRule> {

	boolean evaluate(long[] ids);

	String getAssetClassName();

	long getAssetClassPK();

	AssetEntry getAssetEntry();

	long getAssetEntryId();

	String getAssetImage(PortletRequest portletRequest)
		throws Exception;

	String getAssetTitle();

	String getAssetType();

	long getGroupId(long scopeGroupId);

	int getIndex();

	String getTemplate();

	boolean isDefaultRule();

	boolean isValid();

	void setAssetAttributes(PortletRequest portletRequest);

	void setAssetClassName(String assetClassName);

	void setAssetClassPK(long assetClassPK);

	void setAssetEntryId(long assetEntryId);

	void setAssetTitle(String assetTitle);

	void setAssetType(String assetType);

	void setIndex(int index);

	void setTemplate(String template);

}