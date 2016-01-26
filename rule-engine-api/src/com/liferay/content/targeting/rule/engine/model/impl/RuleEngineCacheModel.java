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

package com.liferay.content.targeting.rule.engine.model.impl;

import com.liferay.content.targeting.rule.engine.model.RuleEngine;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RuleEngine in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RuleEngine
 * @generated
 */
public class RuleEngineCacheModel implements CacheModel<RuleEngine>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dummyId=");
		sb.append(dummyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RuleEngine toEntityModel() {
		RuleEngineImpl ruleEngineImpl = new RuleEngineImpl();

		if (uuid == null) {
			ruleEngineImpl.setUuid(StringPool.BLANK);
		}
		else {
			ruleEngineImpl.setUuid(uuid);
		}

		ruleEngineImpl.setDummyId(dummyId);

		ruleEngineImpl.resetOriginalValues();

		return ruleEngineImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		dummyId = objectInput.readLong();
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

		objectOutput.writeLong(dummyId);
	}

	public String uuid;
	public long dummyId;
}