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

package com.liferay.content.targeting.report.campaign.tracking.action.model.impl;

import com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CampaignTrackingActionTotal in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignTrackingActionTotal
 * @generated
 */
public class CampaignTrackingActionTotalCacheModel implements CacheModel<CampaignTrackingActionTotal>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{campaignTrackingActionTotalId=");
		sb.append(campaignTrackingActionTotalId);
		sb.append(", campaignId=");
		sb.append(campaignId);
		sb.append(", alias=");
		sb.append(alias);
		sb.append(", referrerClassName=");
		sb.append(referrerClassName);
		sb.append(", referrerClassPK=");
		sb.append(referrerClassPK);
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
	public CampaignTrackingActionTotal toEntityModel() {
		CampaignTrackingActionTotalImpl campaignTrackingActionTotalImpl = new CampaignTrackingActionTotalImpl();

		campaignTrackingActionTotalImpl.setCampaignTrackingActionTotalId(campaignTrackingActionTotalId);
		campaignTrackingActionTotalImpl.setCampaignId(campaignId);

		if (alias == null) {
			campaignTrackingActionTotalImpl.setAlias(StringPool.BLANK);
		}
		else {
			campaignTrackingActionTotalImpl.setAlias(alias);
		}

		if (referrerClassName == null) {
			campaignTrackingActionTotalImpl.setReferrerClassName(StringPool.BLANK);
		}
		else {
			campaignTrackingActionTotalImpl.setReferrerClassName(referrerClassName);
		}

		campaignTrackingActionTotalImpl.setReferrerClassPK(referrerClassPK);

		if (elementId == null) {
			campaignTrackingActionTotalImpl.setElementId(StringPool.BLANK);
		}
		else {
			campaignTrackingActionTotalImpl.setElementId(elementId);
		}

		if (eventType == null) {
			campaignTrackingActionTotalImpl.setEventType(StringPool.BLANK);
		}
		else {
			campaignTrackingActionTotalImpl.setEventType(eventType);
		}

		campaignTrackingActionTotalImpl.setCount(count);

		if (modifiedDate == Long.MIN_VALUE) {
			campaignTrackingActionTotalImpl.setModifiedDate(null);
		}
		else {
			campaignTrackingActionTotalImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		campaignTrackingActionTotalImpl.resetOriginalValues();

		return campaignTrackingActionTotalImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		campaignTrackingActionTotalId = objectInput.readLong();
		campaignId = objectInput.readLong();
		alias = objectInput.readUTF();
		referrerClassName = objectInput.readUTF();
		referrerClassPK = objectInput.readLong();
		elementId = objectInput.readUTF();
		eventType = objectInput.readUTF();
		count = objectInput.readInt();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(campaignTrackingActionTotalId);
		objectOutput.writeLong(campaignId);

		if (alias == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(alias);
		}

		if (referrerClassName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(referrerClassName);
		}

		objectOutput.writeLong(referrerClassPK);

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

	public long campaignTrackingActionTotalId;
	public long campaignId;
	public String alias;
	public String referrerClassName;
	public long referrerClassPK;
	public String elementId;
	public String eventType;
	public int count;
	public long modifiedDate;
}