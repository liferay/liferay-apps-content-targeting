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

package com.liferay.contenttargeting.reports.campaigncontent.model.impl;

import com.liferay.contenttargeting.reports.campaigncontent.model.CampaignContent;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CampaignContent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignContent
 * @generated
 */
public class CampaignContentCacheModel implements CacheModel<CampaignContent>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{campaignContentId=");
		sb.append(campaignContentId);
		sb.append(", campaignId=");
		sb.append(campaignId);
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
	public CampaignContent toEntityModel() {
		CampaignContentImpl campaignContentImpl = new CampaignContentImpl();

		campaignContentImpl.setCampaignContentId(campaignContentId);
		campaignContentImpl.setCampaignId(campaignId);

		if (className == null) {
			campaignContentImpl.setClassName(StringPool.BLANK);
		}
		else {
			campaignContentImpl.setClassName(className);
		}

		campaignContentImpl.setClassPK(classPK);

		if (eventType == null) {
			campaignContentImpl.setEventType(StringPool.BLANK);
		}
		else {
			campaignContentImpl.setEventType(eventType);
		}

		campaignContentImpl.setCount(count);

		if (modifiedDate == Long.MIN_VALUE) {
			campaignContentImpl.setModifiedDate(null);
		}
		else {
			campaignContentImpl.setModifiedDate(new Date(modifiedDate));
		}

		campaignContentImpl.resetOriginalValues();

		return campaignContentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		campaignContentId = objectInput.readLong();
		campaignId = objectInput.readLong();
		className = objectInput.readUTF();
		classPK = objectInput.readLong();
		eventType = objectInput.readUTF();
		count = objectInput.readInt();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(campaignContentId);
		objectOutput.writeLong(campaignId);

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

	public long campaignContentId;
	public long campaignId;
	public String className;
	public long classPK;
	public String eventType;
	public int count;
	public long modifiedDate;
}