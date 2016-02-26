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

package com.liferay.content.targeting.rule.score.points.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.rule.score.points.model.ScorePoint;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ScorePoint in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ScorePoint
 * @generated
 */
@ProviderType
public class ScorePointCacheModel implements CacheModel<ScorePoint>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScorePointCacheModel)) {
			return false;
		}

		ScorePointCacheModel scorePointCacheModel = (ScorePointCacheModel)obj;

		if (scorePointId == scorePointCacheModel.scorePointId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, scorePointId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", scorePointId=");
		sb.append(scorePointId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", anonymousUserId=");
		sb.append(anonymousUserId);
		sb.append(", userSegmentId=");
		sb.append(userSegmentId);
		sb.append(", points=");
		sb.append(points);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ScorePoint toEntityModel() {
		ScorePointImpl scorePointImpl = new ScorePointImpl();

		if (uuid == null) {
			scorePointImpl.setUuid(StringPool.BLANK);
		}
		else {
			scorePointImpl.setUuid(uuid);
		}

		scorePointImpl.setScorePointId(scorePointId);
		scorePointImpl.setCompanyId(companyId);
		scorePointImpl.setAnonymousUserId(anonymousUserId);
		scorePointImpl.setUserSegmentId(userSegmentId);
		scorePointImpl.setPoints(points);

		scorePointImpl.resetOriginalValues();

		return scorePointImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		scorePointId = objectInput.readLong();

		companyId = objectInput.readLong();

		anonymousUserId = objectInput.readLong();

		userSegmentId = objectInput.readLong();

		points = objectInput.readLong();
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

		objectOutput.writeLong(scorePointId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(anonymousUserId);

		objectOutput.writeLong(userSegmentId);

		objectOutput.writeLong(points);
	}

	public String uuid;
	public long scorePointId;
	public long companyId;
	public long anonymousUserId;
	public long userSegmentId;
	public long points;
}