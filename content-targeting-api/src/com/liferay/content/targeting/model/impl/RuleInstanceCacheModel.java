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

package com.liferay.content.targeting.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.model.RuleInstance;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RuleInstance in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RuleInstance
 * @generated
 */
@ProviderType
public class RuleInstanceCacheModel implements CacheModel<RuleInstance>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RuleInstanceCacheModel)) {
			return false;
		}

		RuleInstanceCacheModel ruleInstanceCacheModel = (RuleInstanceCacheModel)obj;

		if (ruleInstanceId == ruleInstanceCacheModel.ruleInstanceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ruleInstanceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ruleInstanceId=");
		sb.append(ruleInstanceId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", ruleKey=");
		sb.append(ruleKey);
		sb.append(", userSegmentId=");
		sb.append(userSegmentId);
		sb.append(", typeSettings=");
		sb.append(typeSettings);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RuleInstance toEntityModel() {
		RuleInstanceImpl ruleInstanceImpl = new RuleInstanceImpl();

		if (uuid == null) {
			ruleInstanceImpl.setUuid(StringPool.BLANK);
		}
		else {
			ruleInstanceImpl.setUuid(uuid);
		}

		ruleInstanceImpl.setRuleInstanceId(ruleInstanceId);
		ruleInstanceImpl.setGroupId(groupId);
		ruleInstanceImpl.setCompanyId(companyId);
		ruleInstanceImpl.setUserId(userId);

		if (userName == null) {
			ruleInstanceImpl.setUserName(StringPool.BLANK);
		}
		else {
			ruleInstanceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ruleInstanceImpl.setCreateDate(null);
		}
		else {
			ruleInstanceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ruleInstanceImpl.setModifiedDate(null);
		}
		else {
			ruleInstanceImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (ruleKey == null) {
			ruleInstanceImpl.setRuleKey(StringPool.BLANK);
		}
		else {
			ruleInstanceImpl.setRuleKey(ruleKey);
		}

		ruleInstanceImpl.setUserSegmentId(userSegmentId);

		if (typeSettings == null) {
			ruleInstanceImpl.setTypeSettings(StringPool.BLANK);
		}
		else {
			ruleInstanceImpl.setTypeSettings(typeSettings);
		}

		ruleInstanceImpl.resetOriginalValues();

		return ruleInstanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ruleInstanceId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		ruleKey = objectInput.readUTF();

		userSegmentId = objectInput.readLong();
		typeSettings = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(ruleInstanceId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (ruleKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ruleKey);
		}

		objectOutput.writeLong(userSegmentId);

		if (typeSettings == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typeSettings);
		}
	}

	public String uuid;
	public long ruleInstanceId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String ruleKey;
	public long userSegmentId;
	public String typeSettings;
}