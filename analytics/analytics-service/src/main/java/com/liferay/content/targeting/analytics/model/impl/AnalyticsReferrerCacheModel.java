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

import com.liferay.content.targeting.analytics.model.AnalyticsReferrer;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AnalyticsReferrer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsReferrer
 * @generated
 */
@ProviderType
public class AnalyticsReferrerCacheModel implements CacheModel<AnalyticsReferrer>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnalyticsReferrerCacheModel)) {
			return false;
		}

		AnalyticsReferrerCacheModel analyticsReferrerCacheModel = (AnalyticsReferrerCacheModel)obj;

		if (analyticsReferrerId == analyticsReferrerCacheModel.analyticsReferrerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, analyticsReferrerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{analyticsReferrerId=");
		sb.append(analyticsReferrerId);
		sb.append(", analyticsEventId=");
		sb.append(analyticsEventId);
		sb.append(", referrerClassNameId=");
		sb.append(referrerClassNameId);
		sb.append(", referrerClassPK=");
		sb.append(referrerClassPK);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AnalyticsReferrer toEntityModel() {
		AnalyticsReferrerImpl analyticsReferrerImpl = new AnalyticsReferrerImpl();

		analyticsReferrerImpl.setAnalyticsReferrerId(analyticsReferrerId);
		analyticsReferrerImpl.setAnalyticsEventId(analyticsEventId);
		analyticsReferrerImpl.setReferrerClassNameId(referrerClassNameId);
		analyticsReferrerImpl.setReferrerClassPK(referrerClassPK);

		analyticsReferrerImpl.resetOriginalValues();

		return analyticsReferrerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		analyticsReferrerId = objectInput.readLong();

		analyticsEventId = objectInput.readLong();

		referrerClassNameId = objectInput.readLong();

		referrerClassPK = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(analyticsReferrerId);

		objectOutput.writeLong(analyticsEventId);

		objectOutput.writeLong(referrerClassNameId);

		objectOutput.writeLong(referrerClassPK);
	}

	public long analyticsReferrerId;
	public long analyticsEventId;
	public long referrerClassNameId;
	public long referrerClassPK;
}