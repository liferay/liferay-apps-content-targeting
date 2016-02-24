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

package com.liferay.content.targeting.analytics.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.analytics.model.AnalyticsEvent;

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
 * The cache model class for representing AnalyticsEvent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsEvent
 * @generated
 */
@ProviderType
public class AnalyticsEventCacheModel implements CacheModel<AnalyticsEvent>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnalyticsEventCacheModel)) {
			return false;
		}

		AnalyticsEventCacheModel analyticsEventCacheModel = (AnalyticsEventCacheModel)obj;

		if (analyticsEventId == analyticsEventCacheModel.analyticsEventId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, analyticsEventId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{analyticsEventId=");
		sb.append(analyticsEventId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", anonymousUserId=");
		sb.append(anonymousUserId);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", elementId=");
		sb.append(elementId);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append(", clientIP=");
		sb.append(clientIP);
		sb.append(", userAgent=");
		sb.append(userAgent);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", URL=");
		sb.append(URL);
		sb.append(", additionalInfo=");
		sb.append(additionalInfo);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AnalyticsEvent toEntityModel() {
		AnalyticsEventImpl analyticsEventImpl = new AnalyticsEventImpl();

		analyticsEventImpl.setAnalyticsEventId(analyticsEventId);
		analyticsEventImpl.setCompanyId(companyId);
		analyticsEventImpl.setUserId(userId);
		analyticsEventImpl.setAnonymousUserId(anonymousUserId);

		if (className == null) {
			analyticsEventImpl.setClassName(StringPool.BLANK);
		}
		else {
			analyticsEventImpl.setClassName(className);
		}

		analyticsEventImpl.setClassPK(classPK);

		if (elementId == null) {
			analyticsEventImpl.setElementId(StringPool.BLANK);
		}
		else {
			analyticsEventImpl.setElementId(elementId);
		}

		if (eventType == null) {
			analyticsEventImpl.setEventType(StringPool.BLANK);
		}
		else {
			analyticsEventImpl.setEventType(eventType);
		}

		if (clientIP == null) {
			analyticsEventImpl.setClientIP(StringPool.BLANK);
		}
		else {
			analyticsEventImpl.setClientIP(clientIP);
		}

		if (userAgent == null) {
			analyticsEventImpl.setUserAgent(StringPool.BLANK);
		}
		else {
			analyticsEventImpl.setUserAgent(userAgent);
		}

		if (languageId == null) {
			analyticsEventImpl.setLanguageId(StringPool.BLANK);
		}
		else {
			analyticsEventImpl.setLanguageId(languageId);
		}

		if (URL == null) {
			analyticsEventImpl.setURL(StringPool.BLANK);
		}
		else {
			analyticsEventImpl.setURL(URL);
		}

		if (additionalInfo == null) {
			analyticsEventImpl.setAdditionalInfo(StringPool.BLANK);
		}
		else {
			analyticsEventImpl.setAdditionalInfo(additionalInfo);
		}

		if (createDate == Long.MIN_VALUE) {
			analyticsEventImpl.setCreateDate(null);
		}
		else {
			analyticsEventImpl.setCreateDate(new Date(createDate));
		}

		analyticsEventImpl.resetOriginalValues();

		return analyticsEventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		analyticsEventId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();

		anonymousUserId = objectInput.readLong();
		className = objectInput.readUTF();

		classPK = objectInput.readLong();
		elementId = objectInput.readUTF();
		eventType = objectInput.readUTF();
		clientIP = objectInput.readUTF();
		userAgent = objectInput.readUTF();
		languageId = objectInput.readUTF();
		URL = objectInput.readUTF();
		additionalInfo = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(analyticsEventId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(anonymousUserId);

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPK);

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

		if (clientIP == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(clientIP);
		}

		if (userAgent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userAgent);
		}

		if (languageId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(languageId);
		}

		if (URL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(URL);
		}

		if (additionalInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(additionalInfo);
		}

		objectOutput.writeLong(createDate);
	}

	public long analyticsEventId;
	public long companyId;
	public long userId;
	public long anonymousUserId;
	public String className;
	public long classPK;
	public String elementId;
	public String eventType;
	public String clientIP;
	public String userAgent;
	public String languageId;
	public String URL;
	public String additionalInfo;
	public long createDate;
}