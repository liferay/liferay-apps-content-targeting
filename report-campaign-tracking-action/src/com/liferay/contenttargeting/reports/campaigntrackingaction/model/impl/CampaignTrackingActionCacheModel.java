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

package com.liferay.contenttargeting.reports.campaigntrackingaction.model.impl;

import com.liferay.contenttargeting.reports.campaigntrackingaction.model.CampaignTrackingAction;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CampaignTrackingAction in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignTrackingAction
 * @generated
 */
public class CampaignTrackingActionCacheModel implements CacheModel<CampaignTrackingAction>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{campaignTrackingActionId=");
		sb.append(campaignTrackingActionId);
		sb.append(", campaignId=");
		sb.append(campaignId);
		sb.append(", userSegmentId=");
		sb.append(userSegmentId);
		sb.append(", alias=");
		sb.append(alias);
		sb.append(", plid=");
		sb.append(plid);
		sb.append(", elementId=");
		sb.append(elementId);
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
	public CampaignTrackingAction toEntityModel() {
		CampaignTrackingActionImpl campaignTrackingActionImpl = new CampaignTrackingActionImpl();

		campaignTrackingActionImpl.setCampaignTrackingActionId(campaignTrackingActionId);
		campaignTrackingActionImpl.setCampaignId(campaignId);
		campaignTrackingActionImpl.setUserSegmentId(userSegmentId);

		if (alias == null) {
			campaignTrackingActionImpl.setAlias(StringPool.BLANK);
		}
		else {
			campaignTrackingActionImpl.setAlias(alias);
		}

		campaignTrackingActionImpl.setPlid(plid);

		if (elementId == null) {
			campaignTrackingActionImpl.setElementId(StringPool.BLANK);
		}
		else {
			campaignTrackingActionImpl.setElementId(elementId);
		}

		if (eventType == null) {
			campaignTrackingActionImpl.setEventType(StringPool.BLANK);
		}
		else {
			campaignTrackingActionImpl.setEventType(eventType);
		}

		campaignTrackingActionImpl.setCount(count);

		if (modifiedDate == Long.MIN_VALUE) {
			campaignTrackingActionImpl.setModifiedDate(null);
		}
		else {
			campaignTrackingActionImpl.setModifiedDate(new Date(modifiedDate));
		}

		campaignTrackingActionImpl.resetOriginalValues();

		return campaignTrackingActionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		campaignTrackingActionId = objectInput.readLong();
		campaignId = objectInput.readLong();
		userSegmentId = objectInput.readLong();
		alias = objectInput.readUTF();
		plid = objectInput.readLong();
		elementId = objectInput.readUTF();
		eventType = objectInput.readUTF();
		count = objectInput.readInt();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(campaignTrackingActionId);
		objectOutput.writeLong(campaignId);
		objectOutput.writeLong(userSegmentId);

		if (alias == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(alias);
		}

		objectOutput.writeLong(plid);

		if (elementId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(elementId);
		}

		if (eventType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventType);
		}

		objectOutput.writeInt(count);
		objectOutput.writeLong(modifiedDate);
	}

	public long campaignTrackingActionId;
	public long campaignId;
	public long userSegmentId;
	public String alias;
	public long plid;
	public String elementId;
	public String eventType;
	public int count;
	public long modifiedDate;
}