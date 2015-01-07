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

package com.liferay.content.targeting.lar;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.StagedModel;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * @author Eduardo Garcia
 */
public class AssetEntryReferencedStagedModel implements StagedModel {

	public AssetEntryReferencedStagedModel(AssetEntry assetEntry) {
		_assetEntry = assetEntry;
	}

	@Override
	public Object clone() {
		throw new UnsupportedOperationException();
	}

	public String getClassName() {
		return _assetEntry.getClassName();
	}

	@Override
	public long getCompanyId() {
		return _assetEntry.getCompanyId();
	}

	@Override
	public Date getCreateDate() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Class<?> getModelClass() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getModelClassName() {
		return AssetEntryReferencedStagedModel.class.getName();
	}

	@Override
	public Date getModifiedDate() {
		throw new UnsupportedOperationException();
	}

	public Serializable getPrimaryKeyObj() {
		return _assetEntry.getClassPK();
	}

	@Override
	public StagedModelType getStagedModelType() {
		throw new UnsupportedOperationException();
	}

	public String getTitle() {
		return _assetEntry.getTitle(LocaleUtil.getDefault());
	}

	@Override
	public String getUuid() {
		return _assetEntry.getClassUuid();
	}

	@Override
	public void setCompanyId(long companyId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setCreateDate(Date date) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setModifiedDate(Date date) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setUuid(String uuid) {
		throw new UnsupportedOperationException();
	}

	private AssetEntry _assetEntry;

}