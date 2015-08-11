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

package com.liferay.consumer.manager.model.impl;

import com.liferay.consumer.manager.model.Consumer;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Consumer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Consumer
 * @generated
 */
public class ConsumerCacheModel implements CacheModel<Consumer>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", consumerId=");
		sb.append(consumerId);
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
		sb.append(", consumerKey=");
		sb.append(consumerKey);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Consumer toEntityModel() {
		ConsumerImpl consumerImpl = new ConsumerImpl();

		if (uuid == null) {
			consumerImpl.setUuid(StringPool.BLANK);
		}
		else {
			consumerImpl.setUuid(uuid);
		}

		consumerImpl.setConsumerId(consumerId);
		consumerImpl.setCompanyId(companyId);
		consumerImpl.setUserId(userId);

		if (userName == null) {
			consumerImpl.setUserName(StringPool.BLANK);
		}
		else {
			consumerImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			consumerImpl.setCreateDate(null);
		}
		else {
			consumerImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			consumerImpl.setModifiedDate(null);
		}
		else {
			consumerImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (consumerKey == null) {
			consumerImpl.setConsumerKey(StringPool.BLANK);
		}
		else {
			consumerImpl.setConsumerKey(consumerKey);
		}

		if (name == null) {
			consumerImpl.setName(StringPool.BLANK);
		}
		else {
			consumerImpl.setName(name);
		}

		if (description == null) {
			consumerImpl.setDescription(StringPool.BLANK);
		}
		else {
			consumerImpl.setDescription(description);
		}

		consumerImpl.resetOriginalValues();

		return consumerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		consumerId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		consumerKey = objectInput.readUTF();
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

		objectOutput.writeLong(consumerId);
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

		if (consumerKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(consumerKey);
		}

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
	public long consumerId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String consumerKey;
	public String name;
	public String description;
}