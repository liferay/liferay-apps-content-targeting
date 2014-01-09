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

import com.liferay.contenttargeting.model.UserSegment;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserSegment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see UserSegment
 * @generated
 */
public class UserSegmentCacheModel implements CacheModel<UserSegment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", segmentId=");
		sb.append(segmentId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserSegment toEntityModel() {
		UserSegmentImpl userSegmentImpl = new UserSegmentImpl();

		if (uuid == null) {
			userSegmentImpl.setUuid(StringPool.BLANK);
		}
		else {
			userSegmentImpl.setUuid(uuid);
		}

		userSegmentImpl.setSegmentId(segmentId);
		userSegmentImpl.setGroupId(groupId);
		userSegmentImpl.setCompanyId(companyId);
		userSegmentImpl.setUserId(userId);

		if (userName == null) {
			userSegmentImpl.setUserName(StringPool.BLANK);
		}
		else {
			userSegmentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			userSegmentImpl.setCreateDate(null);
		}
		else {
			userSegmentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userSegmentImpl.setModifiedDate(null);
		}
		else {
			userSegmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			userSegmentImpl.setName(StringPool.BLANK);
		}
		else {
			userSegmentImpl.setName(name);
		}

		if (description == null) {
			userSegmentImpl.setDescription(StringPool.BLANK);
		}
		else {
			userSegmentImpl.setDescription(description);
		}

		userSegmentImpl.resetOriginalValues();

		return userSegmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		segmentId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
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

		objectOutput.writeLong(segmentId);
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

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long segmentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
}