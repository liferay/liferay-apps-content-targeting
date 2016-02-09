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

import com.liferay.content.targeting.model.TrackingActionInstance;

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
 * The cache model class for representing TrackingActionInstance in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TrackingActionInstance
 * @generated
 */
@ProviderType
public class TrackingActionInstanceCacheModel implements CacheModel<TrackingActionInstance>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TrackingActionInstanceCacheModel)) {
			return false;
		}

		TrackingActionInstanceCacheModel trackingActionInstanceCacheModel = (TrackingActionInstanceCacheModel)obj;

		if (trackingActionInstanceId == trackingActionInstanceCacheModel.trackingActionInstanceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, trackingActionInstanceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", trackingActionInstanceId=");
		sb.append(trackingActionInstanceId);
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
		sb.append(", trackingActionKey=");
		sb.append(trackingActionKey);
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
		sb.append(", typeSettings=");
		sb.append(typeSettings);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TrackingActionInstance toEntityModel() {
		TrackingActionInstanceImpl trackingActionInstanceImpl = new TrackingActionInstanceImpl();

		if (uuid == null) {
			trackingActionInstanceImpl.setUuid(StringPool.BLANK);
		}
		else {
			trackingActionInstanceImpl.setUuid(uuid);
		}

		trackingActionInstanceImpl.setTrackingActionInstanceId(trackingActionInstanceId);
		trackingActionInstanceImpl.setGroupId(groupId);
		trackingActionInstanceImpl.setCompanyId(companyId);
		trackingActionInstanceImpl.setUserId(userId);

		if (userName == null) {
			trackingActionInstanceImpl.setUserName(StringPool.BLANK);
		}
		else {
			trackingActionInstanceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			trackingActionInstanceImpl.setCreateDate(null);
		}
		else {
			trackingActionInstanceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			trackingActionInstanceImpl.setModifiedDate(null);
		}
		else {
			trackingActionInstanceImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (trackingActionKey == null) {
			trackingActionInstanceImpl.setTrackingActionKey(StringPool.BLANK);
		}
		else {
			trackingActionInstanceImpl.setTrackingActionKey(trackingActionKey);
		}

		trackingActionInstanceImpl.setCampaignId(campaignId);
		trackingActionInstanceImpl.setReportInstanceId(reportInstanceId);

		if (alias == null) {
			trackingActionInstanceImpl.setAlias(StringPool.BLANK);
		}
		else {
			trackingActionInstanceImpl.setAlias(alias);
		}

		if (referrerClassName == null) {
			trackingActionInstanceImpl.setReferrerClassName(StringPool.BLANK);
		}
		else {
			trackingActionInstanceImpl.setReferrerClassName(referrerClassName);
		}

		trackingActionInstanceImpl.setReferrerClassPK(referrerClassPK);

		if (elementId == null) {
			trackingActionInstanceImpl.setElementId(StringPool.BLANK);
		}
		else {
			trackingActionInstanceImpl.setElementId(elementId);
		}

		if (eventType == null) {
			trackingActionInstanceImpl.setEventType(StringPool.BLANK);
		}
		else {
			trackingActionInstanceImpl.setEventType(eventType);
		}

		if (typeSettings == null) {
			trackingActionInstanceImpl.setTypeSettings(StringPool.BLANK);
		}
		else {
			trackingActionInstanceImpl.setTypeSettings(typeSettings);
		}

		trackingActionInstanceImpl.resetOriginalValues();

		return trackingActionInstanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		trackingActionInstanceId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		trackingActionKey = objectInput.readUTF();

		campaignId = objectInput.readLong();

		reportInstanceId = objectInput.readLong();
		alias = objectInput.readUTF();
		referrerClassName = objectInput.readUTF();

		referrerClassPK = objectInput.readLong();
		elementId = objectInput.readUTF();
		eventType = objectInput.readUTF();
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

		objectOutput.writeLong(trackingActionInstanceId);

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

		if (trackingActionKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(trackingActionKey);
		}

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

		if (typeSettings == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typeSettings);
		}
	}

	public String uuid;
	public long trackingActionInstanceId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String trackingActionKey;
	public long campaignId;
	public long reportInstanceId;
	public String alias;
	public String referrerClassName;
	public long referrerClassPK;
	public String elementId;
	public String eventType;
	public String typeSettings;
}