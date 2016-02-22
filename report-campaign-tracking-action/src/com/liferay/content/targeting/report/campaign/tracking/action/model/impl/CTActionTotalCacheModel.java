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

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal;

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
 * The cache model class for representing CTActionTotal in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CTActionTotal
 * @generated
 */
@ProviderType
public class CTActionTotalCacheModel implements CacheModel<CTActionTotal>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CTActionTotalCacheModel)) {
			return false;
		}

		CTActionTotalCacheModel ctActionTotalCacheModel = (CTActionTotalCacheModel)obj;

		if (CTActionTotalId == ctActionTotalCacheModel.CTActionTotalId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, CTActionTotalId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{CTActionTotalId=");
		sb.append(CTActionTotalId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", campaignId=");
		sb.append(campaignId);
		sb.append(", reportInstanceId=");
		sb.append(reportInstanceId);
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
	public CTActionTotal toEntityModel() {
		CTActionTotalImpl ctActionTotalImpl = new CTActionTotalImpl();

		ctActionTotalImpl.setCTActionTotalId(CTActionTotalId);
		ctActionTotalImpl.setCompanyId(companyId);
		ctActionTotalImpl.setCampaignId(campaignId);
		ctActionTotalImpl.setReportInstanceId(reportInstanceId);

		if (alias == null) {
			ctActionTotalImpl.setAlias(StringPool.BLANK);
		}
		else {
			ctActionTotalImpl.setAlias(alias);
		}

		if (referrerClassName == null) {
			ctActionTotalImpl.setReferrerClassName(StringPool.BLANK);
		}
		else {
			ctActionTotalImpl.setReferrerClassName(referrerClassName);
		}

		ctActionTotalImpl.setReferrerClassPK(referrerClassPK);

		if (elementId == null) {
			ctActionTotalImpl.setElementId(StringPool.BLANK);
		}
		else {
			ctActionTotalImpl.setElementId(elementId);
		}

		if (eventType == null) {
			ctActionTotalImpl.setEventType(StringPool.BLANK);
		}
		else {
			ctActionTotalImpl.setEventType(eventType);
		}

		ctActionTotalImpl.setCount(count);

		if (modifiedDate == Long.MIN_VALUE) {
			ctActionTotalImpl.setModifiedDate(null);
		}
		else {
			ctActionTotalImpl.setModifiedDate(new Date(modifiedDate));
		}

		ctActionTotalImpl.resetOriginalValues();

		return ctActionTotalImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		CTActionTotalId = objectInput.readLong();

		companyId = objectInput.readLong();

		campaignId = objectInput.readLong();

		reportInstanceId = objectInput.readLong();
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
		objectOutput.writeLong(CTActionTotalId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(campaignId);

		objectOutput.writeLong(reportInstanceId);

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

	public long CTActionTotalId;
	public long companyId;
	public long campaignId;
	public long reportInstanceId;
	public String alias;
	public String referrerClassName;
	public long referrerClassPK;
	public String elementId;
	public String eventType;
	public int count;
	public long modifiedDate;
}