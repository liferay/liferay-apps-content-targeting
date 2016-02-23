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

import com.liferay.content.targeting.model.ChannelInstance;

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
 * The cache model class for representing ChannelInstance in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ChannelInstance
 * @generated
 */
@ProviderType
public class ChannelInstanceCacheModel implements CacheModel<ChannelInstance>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ChannelInstanceCacheModel)) {
			return false;
		}

		ChannelInstanceCacheModel channelInstanceCacheModel = (ChannelInstanceCacheModel)obj;

		if (channelInstanceId == channelInstanceCacheModel.channelInstanceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, channelInstanceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", channelInstanceId=");
		sb.append(channelInstanceId);
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
		sb.append(", channelKey=");
		sb.append(channelKey);
		sb.append(", campaignId=");
		sb.append(campaignId);
		sb.append(", tacticId=");
		sb.append(tacticId);
		sb.append(", alias=");
		sb.append(alias);
		sb.append(", typeSettings=");
		sb.append(typeSettings);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ChannelInstance toEntityModel() {
		ChannelInstanceImpl channelInstanceImpl = new ChannelInstanceImpl();

		if (uuid == null) {
			channelInstanceImpl.setUuid(StringPool.BLANK);
		}
		else {
			channelInstanceImpl.setUuid(uuid);
		}

		channelInstanceImpl.setChannelInstanceId(channelInstanceId);
		channelInstanceImpl.setGroupId(groupId);
		channelInstanceImpl.setCompanyId(companyId);
		channelInstanceImpl.setUserId(userId);

		if (userName == null) {
			channelInstanceImpl.setUserName(StringPool.BLANK);
		}
		else {
			channelInstanceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			channelInstanceImpl.setCreateDate(null);
		}
		else {
			channelInstanceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			channelInstanceImpl.setModifiedDate(null);
		}
		else {
			channelInstanceImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (channelKey == null) {
			channelInstanceImpl.setChannelKey(StringPool.BLANK);
		}
		else {
			channelInstanceImpl.setChannelKey(channelKey);
		}

		channelInstanceImpl.setCampaignId(campaignId);
		channelInstanceImpl.setTacticId(tacticId);

		if (alias == null) {
			channelInstanceImpl.setAlias(StringPool.BLANK);
		}
		else {
			channelInstanceImpl.setAlias(alias);
		}

		if (typeSettings == null) {
			channelInstanceImpl.setTypeSettings(StringPool.BLANK);
		}
		else {
			channelInstanceImpl.setTypeSettings(typeSettings);
		}

		channelInstanceImpl.resetOriginalValues();

		return channelInstanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		channelInstanceId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		channelKey = objectInput.readUTF();

		campaignId = objectInput.readLong();

		tacticId = objectInput.readLong();
		alias = objectInput.readUTF();
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

		objectOutput.writeLong(channelInstanceId);

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

		if (channelKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(channelKey);
		}

		objectOutput.writeLong(campaignId);

		objectOutput.writeLong(tacticId);

		if (alias == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(alias);
		}

		if (typeSettings == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typeSettings);
		}
	}

	public String uuid;
	public long channelInstanceId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String channelKey;
	public long campaignId;
	public long tacticId;
	public String alias;
	public String typeSettings;
}