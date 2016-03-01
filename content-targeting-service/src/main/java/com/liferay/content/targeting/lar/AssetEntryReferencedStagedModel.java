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

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ResourcedModel;
import com.liferay.portal.kernel.model.StagedGroupedModel;
import com.liferay.portal.kernel.util.LocaleUtil;

import java.io.Serializable;

import java.util.Date;

/**
 * @author Eduardo Garcia
 */
public class AssetEntryReferencedStagedModel
	implements StagedGroupedModel, ResourcedModel {

	public AssetEntryReferencedStagedModel(AssetEntry assetEntry) {
		_assetEntry = assetEntry;
	}

	@Override
	public Object clone() {
		return new AssetEntryReferencedStagedModel(_assetEntry);
	}

	public String getClassName() {
		return _assetEntry.getClassName();
	}

	public long getClassPK() {
		return _assetEntry.getClassPK();
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
	public long getGroupId() {
		return _assetEntry.getGroupId();
	}

	@Override
	public Date getLastPublishDate() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Class<?> getModelClass() {
		return AssetEntryReferencedStagedModel.class;
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
	public long getResourcePrimKey() {
		return _assetEntry.getPrimaryKey();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			AssetEntryReferencedStagedModel.class.getName());
	}

	public String getTitle() {
		return _assetEntry.getTitle(LocaleUtil.getDefault());
	}

	@Override
	public long getUserId() {
		return _assetEntry.getUserId();
	}

	@Override
	public String getUserName() {
		return _assetEntry.getUserName();
	}

	@Override
	public String getUserUuid() {
		return _assetEntry.getUserUuid();
	}

	@Override
	public String getUuid() {
		return _assetEntry.getClassUuid();
	}

	@Override
	public boolean isResourceMain() {
		return false;
	}

	public void setClassName(String className) {
		_assetEntry.setClassName(className);
	}

	public void setClassPK(long classPK) {
		_assetEntry.setClassPK(classPK);
	}

	@Override
	public void setCompanyId(long companyId) {
		_assetEntry.setCompanyId(companyId);
	}

	@Override
	public void setCreateDate(Date date) {
		_assetEntry.setCreateDate(date);
	}

	@Override
	public void setGroupId(long groupId) {
		_assetEntry.setGroupId(groupId);
	}

	@Override
	public void setLastPublishDate(Date date) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setModifiedDate(Date date) {
		_assetEntry.setModifiedDate(date);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_assetEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public void setResourcePrimKey(long resourcePrimKey) {
		_assetEntry.setPrimaryKey(resourcePrimKey);
	}

	@Override
	public void setUserId(long userId) {
		_assetEntry.setUserId(userId);
	}

	public void setUserName(String userName) {
		_assetEntry.setUserName(userName);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_assetEntry.setUserUuid(userUuid);
	}

	@Override
	public void setUuid(String uuid) {
		throw new UnsupportedOperationException();
	}

	private final AssetEntry _assetEntry;

}