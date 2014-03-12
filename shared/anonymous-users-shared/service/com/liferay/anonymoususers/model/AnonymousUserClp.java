/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.anonymoususers.model;

import com.liferay.anonymoususers.service.AnonymousUserLocalServiceUtil;
import com.liferay.anonymoususers.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
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
public class AnonymousUserClp extends BaseModelImpl<AnonymousUser>
	implements AnonymousUser {
	public AnonymousUserClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AnonymousUser.class;
	}

	@Override
	public String getModelClassName() {
		return AnonymousUser.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _AnonymousUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAnonymousUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _AnonymousUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("AnonymousUserId", getAnonymousUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("lastIp", getLastIp());
		attributes.put("typeSettings", getTypeSettings());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long AnonymousUserId = (Long)attributes.get("AnonymousUserId");

		if (AnonymousUserId != null) {
			setAnonymousUserId(AnonymousUserId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String lastIp = (String)attributes.get("lastIp");

		if (lastIp != null) {
			setLastIp(lastIp);
		}

		String typeSettings = (String)attributes.get("typeSettings");

		if (typeSettings != null) {
			setTypeSettings(typeSettings);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_anonymousUserRemoteModel != null) {
			try {
				Class<?> clazz = _anonymousUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_anonymousUserRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAnonymousUserId() {
		return _AnonymousUserId;
	}

	@Override
	public void setAnonymousUserId(long AnonymousUserId) {
		_AnonymousUserId = AnonymousUserId;

		if (_anonymousUserRemoteModel != null) {
			try {
				Class<?> clazz = _anonymousUserRemoteModel.getClass();

				Method method = clazz.getMethod("setAnonymousUserId", long.class);

				method.invoke(_anonymousUserRemoteModel, AnonymousUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnonymousUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getAnonymousUserId(), "uuid",
			_AnonymousUserUuid);
	}

	@Override
	public void setAnonymousUserUuid(String AnonymousUserUuid) {
		_AnonymousUserUuid = AnonymousUserUuid;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_anonymousUserRemoteModel != null) {
			try {
				Class<?> clazz = _anonymousUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_anonymousUserRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_anonymousUserRemoteModel != null) {
			try {
				Class<?> clazz = _anonymousUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_anonymousUserRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_anonymousUserRemoteModel != null) {
			try {
				Class<?> clazz = _anonymousUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_anonymousUserRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_anonymousUserRemoteModel != null) {
			try {
				Class<?> clazz = _anonymousUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_anonymousUserRemoteModel, createDate);
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

		if (_anonymousUserRemoteModel != null) {
			try {
				Class<?> clazz = _anonymousUserRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_anonymousUserRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastIp() {
		return _lastIp;
	}

	@Override
	public void setLastIp(String lastIp) {
		_lastIp = lastIp;

		if (_anonymousUserRemoteModel != null) {
			try {
				Class<?> clazz = _anonymousUserRemoteModel.getClass();

				Method method = clazz.getMethod("setLastIp", String.class);

				method.invoke(_anonymousUserRemoteModel, lastIp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTypeSettings() {
		return _typeSettings;
	}

	@Override
	public void setTypeSettings(String typeSettings) {
		_typeSettings = typeSettings;

		if (_anonymousUserRemoteModel != null) {
			try {
				Class<?> clazz = _anonymousUserRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeSettings", String.class);

				method.invoke(_anonymousUserRemoteModel, typeSettings);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public com.liferay.portal.model.User getUser() {
		try {
			String methodName = "getUser";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.liferay.portal.model.User returnObj = (com.liferay.portal.model.User)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				AnonymousUser.class.getName()));
	}

	public BaseModel<?> getAnonymousUserRemoteModel() {
		return _anonymousUserRemoteModel;
	}

	public void setAnonymousUserRemoteModel(
		BaseModel<?> anonymousUserRemoteModel) {
		_anonymousUserRemoteModel = anonymousUserRemoteModel;
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

		Class<?> remoteModelClass = _anonymousUserRemoteModel.getClass();

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

		Object returnValue = method.invoke(_anonymousUserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AnonymousUserLocalServiceUtil.addAnonymousUser(this);
		}
		else {
			AnonymousUserLocalServiceUtil.updateAnonymousUser(this);
		}
	}

	@Override
	public AnonymousUser toEscapedModel() {
		return (AnonymousUser)ProxyUtil.newProxyInstance(AnonymousUser.class.getClassLoader(),
			new Class[] { AnonymousUser.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AnonymousUserClp clone = new AnonymousUserClp();

		clone.setUuid(getUuid());
		clone.setAnonymousUserId(getAnonymousUserId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setLastIp(getLastIp());
		clone.setTypeSettings(getTypeSettings());

		return clone;
	}

	@Override
	public int compareTo(AnonymousUser anonymousUser) {
		int value = 0;

		if (getAnonymousUserId() < anonymousUser.getAnonymousUserId()) {
			value = -1;
		}
		else if (getAnonymousUserId() > anonymousUser.getAnonymousUserId()) {
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

		if (!(obj instanceof AnonymousUserClp)) {
			return false;
		}

		AnonymousUserClp anonymousUser = (AnonymousUserClp)obj;

		long primaryKey = anonymousUser.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", AnonymousUserId=");
		sb.append(getAnonymousUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", lastIp=");
		sb.append(getLastIp());
		sb.append(", typeSettings=");
		sb.append(getTypeSettings());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.liferay.anonymoususers.model.AnonymousUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>AnonymousUserId</column-name><column-value><![CDATA[");
		sb.append(getAnonymousUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastIp</column-name><column-value><![CDATA[");
		sb.append(getLastIp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeSettings</column-name><column-value><![CDATA[");
		sb.append(getTypeSettings());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _AnonymousUserId;
	private String _AnonymousUserUuid;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _lastIp;
	private String _typeSettings;
	private BaseModel<?> _anonymousUserRemoteModel;
}