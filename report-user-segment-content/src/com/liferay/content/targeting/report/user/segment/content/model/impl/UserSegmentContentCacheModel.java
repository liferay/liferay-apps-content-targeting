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

package com.liferay.content.targeting.report.user.segment.content.model.impl;

import com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserSegmentContent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see UserSegmentContent
 * @generated
 */
public class UserSegmentContentCacheModel implements CacheModel<UserSegmentContent>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{userSegmentContentId=");
		sb.append(userSegmentContentId);
		sb.append(", userSegmentId=");
		sb.append(userSegmentId);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append(", count=");
		sb.append(count);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserSegmentContent toEntityModel() {
		UserSegmentContentImpl userSegmentContentImpl = new UserSegmentContentImpl();

		userSegmentContentImpl.setUserSegmentContentId(userSegmentContentId);
		userSegmentContentImpl.setUserSegmentId(userSegmentId);

		if (className == null) {
			userSegmentContentImpl.setClassName(StringPool.BLANK);
		}
		else {
			userSegmentContentImpl.setClassName(className);
		}

		userSegmentContentImpl.setClassPK(classPK);

		if (eventType == null) {
			userSegmentContentImpl.setEventType(StringPool.BLANK);
		}
		else {
			userSegmentContentImpl.setEventType(eventType);
		}

		userSegmentContentImpl.setCount(count);

		if (modifiedDate == Long.MIN_VALUE) {
			userSegmentContentImpl.setModifiedDate(null);
		}
		else {
			userSegmentContentImpl.setModifiedDate(new Date(modifiedDate));
		}

		userSegmentContentImpl.resetOriginalValues();

		return userSegmentContentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userSegmentContentId = objectInput.readLong();
		userSegmentId = objectInput.readLong();
		className = objectInput.readUTF();
		classPK = objectInput.readLong();
		eventType = objectInput.readUTF();
		count = objectInput.readInt();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userSegmentContentId);
		objectOutput.writeLong(userSegmentId);

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPK);

		if (eventType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventType);
		}

		objectOutput.writeInt(count);
		objectOutput.writeLong(modifiedDate);
	}

	public long userSegmentContentId;
	public long userSegmentId;
	public String className;
	public long classPK;
	public String eventType;
	public int count;
	public long modifiedDate;
}