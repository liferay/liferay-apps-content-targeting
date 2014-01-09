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

package com.liferay.contenttargeting.model.impl;

import com.liferay.contenttargeting.model.Rule;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Rule in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Rule
 * @generated
 */
public class RuleCacheModel implements CacheModel<Rule>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ruleId=");
		sb.append(ruleId);
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
		sb.append(", segmentId=");
		sb.append(segmentId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", typeSettings=");
		sb.append(typeSettings);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Rule toEntityModel() {
		RuleImpl ruleImpl = new RuleImpl();

		if (uuid == null) {
			ruleImpl.setUuid(StringPool.BLANK);
		}
		else {
			ruleImpl.setUuid(uuid);
		}

		ruleImpl.setRuleId(ruleId);
		ruleImpl.setGroupId(groupId);
		ruleImpl.setCompanyId(companyId);
		ruleImpl.setUserId(userId);

		if (userName == null) {
			ruleImpl.setUserName(StringPool.BLANK);
		}
		else {
			ruleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ruleImpl.setCreateDate(null);
		}
		else {
			ruleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ruleImpl.setModifiedDate(null);
		}
		else {
			ruleImpl.setModifiedDate(new Date(modifiedDate));
		}

		ruleImpl.setSegmentId(segmentId);

		if (type == null) {
			ruleImpl.setType(StringPool.BLANK);
		}
		else {
			ruleImpl.setType(type);
		}

		if (typeSettings == null) {
			ruleImpl.setTypeSettings(StringPool.BLANK);
		}
		else {
			ruleImpl.setTypeSettings(typeSettings);
		}

		ruleImpl.resetOriginalValues();

		return ruleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		ruleId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		segmentId = objectInput.readLong();
		type = objectInput.readUTF();
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

		objectOutput.writeLong(ruleId);
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
		objectOutput.writeLong(segmentId);

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (typeSettings == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typeSettings);
		}
	}

	public String uuid;
	public long ruleId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long segmentId;
	public String type;
	public String typeSettings;
}