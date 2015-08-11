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

import com.liferay.consumer.manager.model.ConsumerExtensionInstance;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ConsumerExtensionInstance in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerExtensionInstance
 * @generated
 */
public class ConsumerExtensionInstanceCacheModel implements CacheModel<ConsumerExtensionInstance>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", consumerExtensionInstanceId=");
		sb.append(consumerExtensionInstanceId);
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
		sb.append(", consumerExtensionKey=");
		sb.append(consumerExtensionKey);
		sb.append(", consumerId=");
		sb.append(consumerId);
		sb.append(", typeSettings=");
		sb.append(typeSettings);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ConsumerExtensionInstance toEntityModel() {
		ConsumerExtensionInstanceImpl consumerExtensionInstanceImpl = new ConsumerExtensionInstanceImpl();

		if (uuid == null) {
			consumerExtensionInstanceImpl.setUuid(StringPool.BLANK);
		}
		else {
			consumerExtensionInstanceImpl.setUuid(uuid);
		}

		consumerExtensionInstanceImpl.setConsumerExtensionInstanceId(consumerExtensionInstanceId);
		consumerExtensionInstanceImpl.setCompanyId(companyId);
		consumerExtensionInstanceImpl.setUserId(userId);

		if (userName == null) {
			consumerExtensionInstanceImpl.setUserName(StringPool.BLANK);
		}
		else {
			consumerExtensionInstanceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			consumerExtensionInstanceImpl.setCreateDate(null);
		}
		else {
			consumerExtensionInstanceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			consumerExtensionInstanceImpl.setModifiedDate(null);
		}
		else {
			consumerExtensionInstanceImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (consumerExtensionKey == null) {
			consumerExtensionInstanceImpl.setConsumerExtensionKey(StringPool.BLANK);
		}
		else {
			consumerExtensionInstanceImpl.setConsumerExtensionKey(consumerExtensionKey);
		}

		consumerExtensionInstanceImpl.setConsumerId(consumerId);

		if (typeSettings == null) {
			consumerExtensionInstanceImpl.setTypeSettings(StringPool.BLANK);
		}
		else {
			consumerExtensionInstanceImpl.setTypeSettings(typeSettings);
		}

		consumerExtensionInstanceImpl.resetOriginalValues();

		return consumerExtensionInstanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		consumerExtensionInstanceId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		consumerExtensionKey = objectInput.readUTF();
		consumerId = objectInput.readLong();
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

		objectOutput.writeLong(consumerExtensionInstanceId);
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

		if (consumerExtensionKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(consumerExtensionKey);
		}

		objectOutput.writeLong(consumerId);

		if (typeSettings == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typeSettings);
		}
	}

	public String uuid;
	public long consumerExtensionInstanceId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String consumerExtensionKey;
	public long consumerId;
	public String typeSettings;
}