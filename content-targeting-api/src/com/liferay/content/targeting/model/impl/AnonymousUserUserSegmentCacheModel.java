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

import com.liferay.content.targeting.model.AnonymousUserUserSegment;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AnonymousUserUserSegment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AnonymousUserUserSegment
 * @generated
 */
@ProviderType
public class AnonymousUserUserSegmentCacheModel implements CacheModel<AnonymousUserUserSegment>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnonymousUserUserSegmentCacheModel)) {
			return false;
		}

		AnonymousUserUserSegmentCacheModel anonymousUserUserSegmentCacheModel = (AnonymousUserUserSegmentCacheModel)obj;

		if (anonymousUserUserSegmentId == anonymousUserUserSegmentCacheModel.anonymousUserUserSegmentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, anonymousUserUserSegmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{anonymousUserUserSegmentId=");
		sb.append(anonymousUserUserSegmentId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", anonymousUserId=");
		sb.append(anonymousUserId);
		sb.append(", userSegmentId=");
		sb.append(userSegmentId);
		sb.append(", manual=");
		sb.append(manual);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AnonymousUserUserSegment toEntityModel() {
		AnonymousUserUserSegmentImpl anonymousUserUserSegmentImpl = new AnonymousUserUserSegmentImpl();

		anonymousUserUserSegmentImpl.setAnonymousUserUserSegmentId(anonymousUserUserSegmentId);
		anonymousUserUserSegmentImpl.setCompanyId(companyId);

		if (modifiedDate == Long.MIN_VALUE) {
			anonymousUserUserSegmentImpl.setModifiedDate(null);
		}
		else {
			anonymousUserUserSegmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		anonymousUserUserSegmentImpl.setAnonymousUserId(anonymousUserId);
		anonymousUserUserSegmentImpl.setUserSegmentId(userSegmentId);
		anonymousUserUserSegmentImpl.setManual(manual);
		anonymousUserUserSegmentImpl.setActive(active);

		anonymousUserUserSegmentImpl.resetOriginalValues();

		return anonymousUserUserSegmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		anonymousUserUserSegmentId = objectInput.readLong();

		companyId = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		anonymousUserId = objectInput.readLong();

		userSegmentId = objectInput.readLong();

		manual = objectInput.readBoolean();

		active = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(anonymousUserUserSegmentId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(anonymousUserId);

		objectOutput.writeLong(userSegmentId);

		objectOutput.writeBoolean(manual);

		objectOutput.writeBoolean(active);
	}

	public long anonymousUserUserSegmentId;
	public long companyId;
	public long modifiedDate;
	public long anonymousUserId;
	public long userSegmentId;
	public boolean manual;
	public boolean active;
}