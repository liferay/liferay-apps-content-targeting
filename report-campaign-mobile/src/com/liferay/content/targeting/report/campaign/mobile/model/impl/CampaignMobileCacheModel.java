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

package com.liferay.content.targeting.report.campaign.mobile.model.impl;

import com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CampaignMobile in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignMobile
 * @generated
 */
public class CampaignMobileCacheModel implements CacheModel<CampaignMobile>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{campaignMobileId=");
		sb.append(campaignMobileId);
		sb.append(", campaignId=");
		sb.append(campaignId);
		sb.append(", count=");
		sb.append(count);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", elementId=");
		sb.append(elementId);
		sb.append(", consumerId=");
		sb.append(consumerId);
		sb.append(", placeholderId=");
		sb.append(placeholderId);
		sb.append(", userSegmentId=");
		sb.append(userSegmentId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CampaignMobile toEntityModel() {
		CampaignMobileImpl campaignMobileImpl = new CampaignMobileImpl();

		campaignMobileImpl.setCampaignMobileId(campaignMobileId);
		campaignMobileImpl.setCampaignId(campaignId);
		campaignMobileImpl.setCount(count);

		if (modifiedDate == Long.MIN_VALUE) {
			campaignMobileImpl.setModifiedDate(null);
		}
		else {
			campaignMobileImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (eventType == null) {
			campaignMobileImpl.setEventType(StringPool.BLANK);
		}
		else {
			campaignMobileImpl.setEventType(eventType);
		}

		if (className == null) {
			campaignMobileImpl.setClassName(StringPool.BLANK);
		}
		else {
			campaignMobileImpl.setClassName(className);
		}

		campaignMobileImpl.setClassPK(classPK);

		if (elementId == null) {
			campaignMobileImpl.setElementId(StringPool.BLANK);
		}
		else {
			campaignMobileImpl.setElementId(elementId);
		}

		campaignMobileImpl.setConsumerId(consumerId);
		campaignMobileImpl.setPlaceholderId(placeholderId);
		campaignMobileImpl.setUserSegmentId(userSegmentId);

		campaignMobileImpl.resetOriginalValues();

		return campaignMobileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		campaignMobileId = objectInput.readLong();
		campaignId = objectInput.readLong();
		count = objectInput.readInt();
		modifiedDate = objectInput.readLong();
		eventType = objectInput.readUTF();
		className = objectInput.readUTF();
		classPK = objectInput.readLong();
		elementId = objectInput.readUTF();
		consumerId = objectInput.readLong();
		placeholderId = objectInput.readLong();
		userSegmentId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(campaignMobileId);
		objectOutput.writeLong(campaignId);
		objectOutput.writeInt(count);
		objectOutput.writeLong(modifiedDate);

		if (eventType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventType);
		}

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPK);

		if (elementId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(elementId);
		}

		objectOutput.writeLong(consumerId);
		objectOutput.writeLong(placeholderId);
		objectOutput.writeLong(userSegmentId);
	}

	public long campaignMobileId;
	public long campaignId;
	public int count;
	public long modifiedDate;
	public String eventType;
	public String className;
	public long classPK;
	public String elementId;
	public long consumerId;
	public long placeholderId;
	public long userSegmentId;
}