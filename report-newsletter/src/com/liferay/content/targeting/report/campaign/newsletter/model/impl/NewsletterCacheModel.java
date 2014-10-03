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

package com.liferay.content.targeting.report.campaign.newsletter.model.impl;

import com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Newsletter in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Newsletter
 * @generated
 */
public class NewsletterCacheModel implements CacheModel<Newsletter>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{newsletterId=");
		sb.append(newsletterId);
		sb.append(", campaignId=");
		sb.append(campaignId);
		sb.append(", alias=");
		sb.append(alias);
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
	public Newsletter toEntityModel() {
		NewsletterImpl newsletterImpl = new NewsletterImpl();

		newsletterImpl.setNewsletterId(newsletterId);
		newsletterImpl.setCampaignId(campaignId);

		if (alias == null) {
			newsletterImpl.setAlias(StringPool.BLANK);
		}
		else {
			newsletterImpl.setAlias(alias);
		}

		if (elementId == null) {
			newsletterImpl.setElementId(StringPool.BLANK);
		}
		else {
			newsletterImpl.setElementId(elementId);
		}

		if (eventType == null) {
			newsletterImpl.setEventType(StringPool.BLANK);
		}
		else {
			newsletterImpl.setEventType(eventType);
		}

		newsletterImpl.setCount(count);

		if (modifiedDate == Long.MIN_VALUE) {
			newsletterImpl.setModifiedDate(null);
		}
		else {
			newsletterImpl.setModifiedDate(new Date(modifiedDate));
		}

		newsletterImpl.resetOriginalValues();

		return newsletterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		newsletterId = objectInput.readLong();
		campaignId = objectInput.readLong();
		alias = objectInput.readUTF();
		elementId = objectInput.readUTF();
		eventType = objectInput.readUTF();
		count = objectInput.readInt();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(newsletterId);
		objectOutput.writeLong(campaignId);

		if (alias == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(alias);
		}

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

	public long newsletterId;
	public long campaignId;
	public String alias;
	public String elementId;
	public String eventType;
	public int count;
	public long modifiedDate;
}