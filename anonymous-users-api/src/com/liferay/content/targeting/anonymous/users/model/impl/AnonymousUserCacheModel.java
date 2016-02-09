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

package com.liferay.content.targeting.anonymous.users.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;

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
 * The cache model class for representing AnonymousUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AnonymousUser
 * @generated
 */
@ProviderType
public class AnonymousUserCacheModel implements CacheModel<AnonymousUser>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnonymousUserCacheModel)) {
			return false;
		}

		AnonymousUserCacheModel anonymousUserCacheModel = (AnonymousUserCacheModel)obj;

		if (anonymousUserId == anonymousUserCacheModel.anonymousUserId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, anonymousUserId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", anonymousUserId=");
		sb.append(anonymousUserId);
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
		sb.append(", lastIp=");
		sb.append(lastIp);
		sb.append(", typeSettings=");
		sb.append(typeSettings);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AnonymousUser toEntityModel() {
		AnonymousUserImpl anonymousUserImpl = new AnonymousUserImpl();

		if (uuid == null) {
			anonymousUserImpl.setUuid(StringPool.BLANK);
		}
		else {
			anonymousUserImpl.setUuid(uuid);
		}

		anonymousUserImpl.setAnonymousUserId(anonymousUserId);
		anonymousUserImpl.setCompanyId(companyId);
		anonymousUserImpl.setUserId(userId);

		if (userName == null) {
			anonymousUserImpl.setUserName(StringPool.BLANK);
		}
		else {
			anonymousUserImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			anonymousUserImpl.setCreateDate(null);
		}
		else {
			anonymousUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			anonymousUserImpl.setModifiedDate(null);
		}
		else {
			anonymousUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (lastIp == null) {
			anonymousUserImpl.setLastIp(StringPool.BLANK);
		}
		else {
			anonymousUserImpl.setLastIp(lastIp);
		}

		if (typeSettings == null) {
			anonymousUserImpl.setTypeSettings(StringPool.BLANK);
		}
		else {
			anonymousUserImpl.setTypeSettings(typeSettings);
		}

		anonymousUserImpl.resetOriginalValues();

		return anonymousUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		anonymousUserId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		lastIp = objectInput.readUTF();
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

		objectOutput.writeLong(anonymousUserId);

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

		if (lastIp == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastIp);
		}

		if (typeSettings == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typeSettings);
		}
	}

	public String uuid;
	public long anonymousUserId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String lastIp;
	public String typeSettings;
}