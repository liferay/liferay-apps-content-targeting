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

import com.liferay.content.targeting.model.Tactic;

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
 * The cache model class for representing Tactic in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Tactic
 * @generated
 */
@ProviderType
public class TacticCacheModel implements CacheModel<Tactic>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TacticCacheModel)) {
			return false;
		}

		TacticCacheModel tacticCacheModel = (TacticCacheModel)obj;

		if (tacticId == tacticCacheModel.tacticId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tacticId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", tacticId=");
		sb.append(tacticId);
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
		sb.append(", campaignId=");
		sb.append(campaignId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Tactic toEntityModel() {
		TacticImpl tacticImpl = new TacticImpl();

		if (uuid == null) {
			tacticImpl.setUuid(StringPool.BLANK);
		}
		else {
			tacticImpl.setUuid(uuid);
		}

		tacticImpl.setTacticId(tacticId);
		tacticImpl.setGroupId(groupId);
		tacticImpl.setCompanyId(companyId);
		tacticImpl.setUserId(userId);

		if (userName == null) {
			tacticImpl.setUserName(StringPool.BLANK);
		}
		else {
			tacticImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tacticImpl.setCreateDate(null);
		}
		else {
			tacticImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tacticImpl.setModifiedDate(null);
		}
		else {
			tacticImpl.setModifiedDate(new Date(modifiedDate));
		}

		tacticImpl.setCampaignId(campaignId);

		if (name == null) {
			tacticImpl.setName(StringPool.BLANK);
		}
		else {
			tacticImpl.setName(name);
		}

		if (description == null) {
			tacticImpl.setDescription(StringPool.BLANK);
		}
		else {
			tacticImpl.setDescription(description);
		}

		tacticImpl.resetOriginalValues();

		return tacticImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		tacticId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		campaignId = objectInput.readLong();
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

		objectOutput.writeLong(tacticId);

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

		objectOutput.writeLong(campaignId);

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
	public long tacticId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long campaignId;
	public String name;
	public String description;
}