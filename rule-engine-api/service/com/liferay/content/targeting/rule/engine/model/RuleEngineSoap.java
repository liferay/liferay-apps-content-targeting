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

package com.liferay.content.targeting.rule.engine.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.content.targeting.rule.engine.service.http.RuleEngineServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.rule.engine.service.http.RuleEngineServiceSoap
 * @generated
 */
public class RuleEngineSoap implements Serializable {
	public static RuleEngineSoap toSoapModel(RuleEngine model) {
		RuleEngineSoap soapModel = new RuleEngineSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setDummyId(model.getDummyId());

		return soapModel;
	}

	public static RuleEngineSoap[] toSoapModels(RuleEngine[] models) {
		RuleEngineSoap[] soapModels = new RuleEngineSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RuleEngineSoap[][] toSoapModels(RuleEngine[][] models) {
		RuleEngineSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RuleEngineSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RuleEngineSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RuleEngineSoap[] toSoapModels(List<RuleEngine> models) {
		List<RuleEngineSoap> soapModels = new ArrayList<RuleEngineSoap>(models.size());

		for (RuleEngine model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RuleEngineSoap[soapModels.size()]);
	}

	public RuleEngineSoap() {
	}

	public long getPrimaryKey() {
		return _dummyId;
	}

	public void setPrimaryKey(long pk) {
		setDummyId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getDummyId() {
		return _dummyId;
	}

	public void setDummyId(long dummyId) {
		_dummyId = dummyId;
	}

	private String _uuid;
	private long _dummyId;
}