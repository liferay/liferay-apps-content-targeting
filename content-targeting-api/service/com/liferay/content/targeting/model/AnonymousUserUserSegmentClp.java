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

package com.liferay.content.targeting.model;

import com.liferay.content.targeting.service.AnonymousUserUserSegmentLocalServiceUtil;
import com.liferay.content.targeting.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class AnonymousUserUserSegmentClp extends BaseModelImpl<AnonymousUserUserSegment>
	implements AnonymousUserUserSegment {
	public AnonymousUserUserSegmentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AnonymousUserUserSegment.class;
	}

	@Override
	public String getModelClassName() {
		return AnonymousUserUserSegment.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _anonymousUserUserSegmentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAnonymousUserUserSegmentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _anonymousUserUserSegmentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("anonymousUserUserSegmentId",
			getAnonymousUserUserSegmentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("anonymousUserId", getAnonymousUserId());
		attributes.put("userSegmentId", getUserSegmentId());
		attributes.put("manual", getManual());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long anonymousUserUserSegmentId = (Long)attributes.get(
				"anonymousUserUserSegmentId");

		if (anonymousUserUserSegmentId != null) {
			setAnonymousUserUserSegmentId(anonymousUserUserSegmentId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long anonymousUserId = (Long)attributes.get("anonymousUserId");

		if (anonymousUserId != null) {
			setAnonymousUserId(anonymousUserId);
		}

		Long userSegmentId = (Long)attributes.get("userSegmentId");

		if (userSegmentId != null) {
			setUserSegmentId(userSegmentId);
		}

		Boolean manual = (Boolean)attributes.get("manual");

		if (manual != null) {
			setManual(manual);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	@Override
	public long getAnonymousUserUserSegmentId() {
		return _anonymousUserUserSegmentId;
	}

	@Override
	public void setAnonymousUserUserSegmentId(long anonymousUserUserSegmentId) {
		_anonymousUserUserSegmentId = anonymousUserUserSegmentId;

		if (_anonymousUserUserSegmentRemoteModel != null) {
			try {
				Class<?> clazz = _anonymousUserUserSegmentRemoteModel.getClass();

				Method method = clazz.getMethod("setAnonymousUserUserSegmentId",
						long.class);

				method.invoke(_anonymousUserUserSegmentRemoteModel,
					anonymousUserUserSegmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_anonymousUserUserSegmentRemoteModel != null) {
			try {
				Class<?> clazz = _anonymousUserUserSegmentRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_anonymousUserUserSegmentRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_anonymousUserUserSegmentRemoteModel != null) {
			try {
				Class<?> clazz = _anonymousUserUserSegmentRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_anonymousUserUserSegmentRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAnonymousUserId() {
		return _anonymousUserId;
	}

	@Override
	public void setAnonymousUserId(long anonymousUserId) {
		_anonymousUserId = anonymousUserId;

		if (_anonymousUserUserSegmentRemoteModel != null) {
			try {
				Class<?> clazz = _anonymousUserUserSegmentRemoteModel.getClass();

				Method method = clazz.getMethod("setAnonymousUserId", long.class);

				method.invoke(_anonymousUserUserSegmentRemoteModel,
					anonymousUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnonymousUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getAnonymousUserId(), "uuid",
			_anonymousUserUuid);
	}

	@Override
	public void setAnonymousUserUuid(String anonymousUserUuid) {
		_anonymousUserUuid = anonymousUserUuid;
	}

	@Override
	public long getUserSegmentId() {
		return _userSegmentId;
	}

	@Override
	public void setUserSegmentId(long userSegmentId) {
		_userSegmentId = userSegmentId;

		if (_anonymousUserUserSegmentRemoteModel != null) {
			try {
				Class<?> clazz = _anonymousUserUserSegmentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserSegmentId", long.class);

				method.invoke(_anonymousUserUserSegmentRemoteModel,
					userSegmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getManual() {
		return _manual;
	}

	@Override
	public boolean isManual() {
		return _manual;
	}

	@Override
	public void setManual(boolean manual) {
		_manual = manual;

		if (_anonymousUserUserSegmentRemoteModel != null) {
			try {
				Class<?> clazz = _anonymousUserUserSegmentRemoteModel.getClass();

				Method method = clazz.getMethod("setManual", boolean.class);

				method.invoke(_anonymousUserUserSegmentRemoteModel, manual);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_anonymousUserUserSegmentRemoteModel != null) {
			try {
				Class<?> clazz = _anonymousUserUserSegmentRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_anonymousUserUserSegmentRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAnonymousUserUserSegmentRemoteModel() {
		return _anonymousUserUserSegmentRemoteModel;
	}

	public void setAnonymousUserUserSegmentRemoteModel(
		BaseModel<?> anonymousUserUserSegmentRemoteModel) {
		_anonymousUserUserSegmentRemoteModel = anonymousUserUserSegmentRemoteModel;
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

		Class<?> remoteModelClass = _anonymousUserUserSegmentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_anonymousUserUserSegmentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AnonymousUserUserSegmentLocalServiceUtil.addAnonymousUserUserSegment(this);
		}
		else {
			AnonymousUserUserSegmentLocalServiceUtil.updateAnonymousUserUserSegment(this);
		}
	}

	@Override
	public AnonymousUserUserSegment toEscapedModel() {
		return (AnonymousUserUserSegment)ProxyUtil.newProxyInstance(AnonymousUserUserSegment.class.getClassLoader(),
			new Class[] { AnonymousUserUserSegment.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AnonymousUserUserSegmentClp clone = new AnonymousUserUserSegmentClp();

		clone.setAnonymousUserUserSegmentId(getAnonymousUserUserSegmentId());
		clone.setCompanyId(getCompanyId());
		clone.setModifiedDate(getModifiedDate());
		clone.setAnonymousUserId(getAnonymousUserId());
		clone.setUserSegmentId(getUserSegmentId());
		clone.setManual(getManual());
		clone.setActive(getActive());

		return clone;
	}

	@Override
	public int compareTo(AnonymousUserUserSegment anonymousUserUserSegment) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				anonymousUserUserSegment.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getActive() == anonymousUserUserSegment.getActive()) {
			value = -1;
		}
		else if (getActive() != anonymousUserUserSegment.getActive()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnonymousUserUserSegmentClp)) {
			return false;
		}

		AnonymousUserUserSegmentClp anonymousUserUserSegment = (AnonymousUserUserSegmentClp)obj;

		long primaryKey = anonymousUserUserSegment.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
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
		StringBundler sb = new StringBundler(15);

		sb.append("{anonymousUserUserSegmentId=");
		sb.append(getAnonymousUserUserSegmentId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", anonymousUserId=");
		sb.append(getAnonymousUserId());
		sb.append(", userSegmentId=");
		sb.append(getUserSegmentId());
		sb.append(", manual=");
		sb.append(getManual());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.content.targeting.model.AnonymousUserUserSegment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>anonymousUserUserSegmentId</column-name><column-value><![CDATA[");
		sb.append(getAnonymousUserUserSegmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>anonymousUserId</column-name><column-value><![CDATA[");
		sb.append(getAnonymousUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userSegmentId</column-name><column-value><![CDATA[");
		sb.append(getUserSegmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>manual</column-name><column-value><![CDATA[");
		sb.append(getManual());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _anonymousUserUserSegmentId;
	private long _companyId;
	private Date _modifiedDate;
	private long _anonymousUserId;
	private String _anonymousUserUuid;
	private long _userSegmentId;
	private boolean _manual;
	private boolean _active;
	private BaseModel<?> _anonymousUserUserSegmentRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.content.targeting.service.ClpSerializer.class;
}