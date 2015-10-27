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

package com.liferay.content.targeting.report.campaign.mobile.model.impl;

import com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ConsumerData in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerData
 * @generated
 */
public class ConsumerDataCacheModel implements CacheModel<ConsumerData>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{consumerDataId=");
		sb.append(consumerDataId);
		sb.append(", campaignId=");
		sb.append(campaignId);
		sb.append(", count=");
		sb.append(count);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append(", elementId=");
		sb.append(elementId);
		sb.append(", consumerId=");
		sb.append(consumerId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ConsumerData toEntityModel() {
		ConsumerDataImpl consumerDataImpl = new ConsumerDataImpl();

		consumerDataImpl.setConsumerDataId(consumerDataId);
		consumerDataImpl.setCampaignId(campaignId);
		consumerDataImpl.setCount(count);

		if (modifiedDate == Long.MIN_VALUE) {
			consumerDataImpl.setModifiedDate(null);
		}
		else {
			consumerDataImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (eventType == null) {
			consumerDataImpl.setEventType(StringPool.BLANK);
		}
		else {
			consumerDataImpl.setEventType(eventType);
		}

		if (elementId == null) {
			consumerDataImpl.setElementId(StringPool.BLANK);
		}
		else {
			consumerDataImpl.setElementId(elementId);
		}

		consumerDataImpl.setConsumerId(consumerId);

		consumerDataImpl.resetOriginalValues();

		return consumerDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		consumerDataId = objectInput.readLong();
		campaignId = objectInput.readLong();
		count = objectInput.readInt();
		modifiedDate = objectInput.readLong();
		eventType = objectInput.readUTF();
		elementId = objectInput.readUTF();
		consumerId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(consumerDataId);
		objectOutput.writeLong(campaignId);
		objectOutput.writeInt(count);
		objectOutput.writeLong(modifiedDate);

		if (eventType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventType);
		}

		if (elementId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(elementId);
		}

		objectOutput.writeLong(consumerId);
	}

	public long consumerDataId;
	public long campaignId;
	public int count;
	public long modifiedDate;
	public String eventType;
	public String elementId;
	public long consumerId;
}