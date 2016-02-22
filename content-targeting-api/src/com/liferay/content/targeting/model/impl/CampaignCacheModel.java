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

import com.liferay.content.targeting.model.Campaign;

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
 * The cache model class for representing Campaign in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Campaign
 * @generated
 */
@ProviderType
public class CampaignCacheModel implements CacheModel<Campaign>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CampaignCacheModel)) {
			return false;
		}

		CampaignCacheModel campaignCacheModel = (CampaignCacheModel)obj;

		if (campaignId == campaignCacheModel.campaignId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, campaignId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", campaignId=");
		sb.append(campaignId);
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
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", timeZoneId=");
		sb.append(timeZoneId);
		sb.append(", priority=");
		sb.append(priority);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Campaign toEntityModel() {
		CampaignImpl campaignImpl = new CampaignImpl();

		if (uuid == null) {
			campaignImpl.setUuid(StringPool.BLANK);
		}
		else {
			campaignImpl.setUuid(uuid);
		}

		campaignImpl.setCampaignId(campaignId);
		campaignImpl.setGroupId(groupId);
		campaignImpl.setCompanyId(companyId);
		campaignImpl.setUserId(userId);

		if (userName == null) {
			campaignImpl.setUserName(StringPool.BLANK);
		}
		else {
			campaignImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			campaignImpl.setCreateDate(null);
		}
		else {
			campaignImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			campaignImpl.setModifiedDate(null);
		}
		else {
			campaignImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			campaignImpl.setName(StringPool.BLANK);
		}
		else {
			campaignImpl.setName(name);
		}

		if (description == null) {
			campaignImpl.setDescription(StringPool.BLANK);
		}
		else {
			campaignImpl.setDescription(description);
		}

		if (startDate == Long.MIN_VALUE) {
			campaignImpl.setStartDate(null);
		}
		else {
			campaignImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			campaignImpl.setEndDate(null);
		}
		else {
			campaignImpl.setEndDate(new Date(endDate));
		}

		if (timeZoneId == null) {
			campaignImpl.setTimeZoneId(StringPool.BLANK);
		}
		else {
			campaignImpl.setTimeZoneId(timeZoneId);
		}

		campaignImpl.setPriority(priority);
		campaignImpl.setActive(active);

		campaignImpl.resetOriginalValues();

		return campaignImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		campaignId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		timeZoneId = objectInput.readUTF();

		priority = objectInput.readInt();

		active = objectInput.readBoolean();
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

		objectOutput.writeLong(campaignId);

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

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (timeZoneId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(timeZoneId);
		}

		objectOutput.writeInt(priority);

		objectOutput.writeBoolean(active);
	}

	public String uuid;
	public long campaignId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public long startDate;
	public long endDate;
	public String timeZoneId;
	public int priority;
	public boolean active;
}