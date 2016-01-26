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

import com.liferay.content.targeting.rule.engine.service.ClpSerializer;
import com.liferay.content.targeting.rule.engine.service.RuleEngineLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class RuleEngineClp extends BaseModelImpl<RuleEngine>
	implements RuleEngine {
	public RuleEngineClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RuleEngine.class;
	}

	@Override
	public String getModelClassName() {
		return RuleEngine.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _dummyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDummyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dummyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("dummyId", getDummyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dummyId = (Long)attributes.get("dummyId");

		if (dummyId != null) {
			setDummyId(dummyId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_ruleEngineRemoteModel != null) {
			try {
				Class<?> clazz = _ruleEngineRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_ruleEngineRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDummyId() {
		return _dummyId;
	}

	@Override
	public void setDummyId(long dummyId) {
		_dummyId = dummyId;

		if (_ruleEngineRemoteModel != null) {
			try {
				Class<?> clazz = _ruleEngineRemoteModel.getClass();

				Method method = clazz.getMethod("setDummyId", long.class);

				method.invoke(_ruleEngineRemoteModel, dummyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getRuleEngineRemoteModel() {
		return _ruleEngineRemoteModel;
	}

	public void setRuleEngineRemoteModel(BaseModel<?> ruleEngineRemoteModel) {
		_ruleEngineRemoteModel = ruleEngineRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _ruleEngineRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_ruleEngineRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RuleEngineLocalServiceUtil.addRuleEngine(this);
		}
		else {
			RuleEngineLocalServiceUtil.updateRuleEngine(this);
		}
	}

	@Override
	public RuleEngine toEscapedModel() {
		return (RuleEngine)ProxyUtil.newProxyInstance(RuleEngine.class.getClassLoader(),
			new Class[] { RuleEngine.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RuleEngineClp clone = new RuleEngineClp();

		clone.setUuid(getUuid());
		clone.setDummyId(getDummyId());

		return clone;
	}

	@Override
	public int compareTo(RuleEngine ruleEngine) {
		long primaryKey = ruleEngine.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RuleEngineClp)) {
			return false;
		}

		RuleEngineClp ruleEngine = (RuleEngineClp)obj;

		long primaryKey = ruleEngine.getPrimaryKey();

		return getPrimaryKey() == primaryKey;
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", dummyId=");
		sb.append(getDummyId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.liferay.content.targeting.rule.engine.model.RuleEngine");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dummyId</column-name><column-value><![CDATA[");
		sb.append(getDummyId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _dummyId;
	private BaseModel<?> _ruleEngineRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.content.targeting.rule.engine.service.ClpSerializer.class;
}