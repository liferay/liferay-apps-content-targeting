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

package com.liferay.consumer.manager.model;

import com.liferay.consumer.manager.service.ClpSerializer;
import com.liferay.consumer.manager.service.ConsumerExtensionInstanceLocalServiceUtil;

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
public class ConsumerExtensionInstanceClp extends BaseModelImpl<ConsumerExtensionInstance>
	implements ConsumerExtensionInstance {
	public ConsumerExtensionInstanceClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ConsumerExtensionInstance.class;
	}

	@Override
	public String getModelClassName() {
		return ConsumerExtensionInstance.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _consumerExtensionInstanceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setConsumerExtensionInstanceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _consumerExtensionInstanceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("consumerExtensionInstanceId",
			getConsumerExtensionInstanceId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("consumerExtensionKey", getConsumerExtensionKey());
		attributes.put("consumerId", getConsumerId());
		attributes.put("typeSettings", getTypeSettings());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long consumerExtensionInstanceId = (Long)attributes.get(
				"consumerExtensionInstanceId");

		if (consumerExtensionInstanceId != null) {
			setConsumerExtensionInstanceId(consumerExtensionInstanceId);
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

		String consumerExtensionKey = (String)attributes.get(
				"consumerExtensionKey");

		if (consumerExtensionKey != null) {
			setConsumerExtensionKey(consumerExtensionKey);
		}

		Long consumerId = (Long)attributes.get("consumerId");

		if (consumerId != null) {
			setConsumerId(consumerId);
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

		if (_consumerExtensionInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _consumerExtensionInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_consumerExtensionInstanceRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getConsumerExtensionInstanceId() {
		return _consumerExtensionInstanceId;
	}

	@Override
	public void setConsumerExtensionInstanceId(long consumerExtensionInstanceId) {
		_consumerExtensionInstanceId = consumerExtensionInstanceId;

		if (_consumerExtensionInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _consumerExtensionInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setConsumerExtensionInstanceId",
						long.class);

				method.invoke(_consumerExtensionInstanceRemoteModel,
					consumerExtensionInstanceId);
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

		if (_consumerExtensionInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _consumerExtensionInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_consumerExtensionInstanceRemoteModel, companyId);
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

		if (_consumerExtensionInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _consumerExtensionInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_consumerExtensionInstanceRemoteModel, userId);
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

		if (_consumerExtensionInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _consumerExtensionInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_consumerExtensionInstanceRemoteModel, userName);
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

		if (_consumerExtensionInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _consumerExtensionInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_consumerExtensionInstanceRemoteModel, createDate);
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

		if (_consumerExtensionInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _consumerExtensionInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_consumerExtensionInstanceRemoteModel,
					modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getConsumerExtensionKey() {
		return _consumerExtensionKey;
	}

	@Override
	public void setConsumerExtensionKey(String consumerExtensionKey) {
		_consumerExtensionKey = consumerExtensionKey;

		if (_consumerExtensionInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _consumerExtensionInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setConsumerExtensionKey",
						String.class);

				method.invoke(_consumerExtensionInstanceRemoteModel,
					consumerExtensionKey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getConsumerId() {
		return _consumerId;
	}

	@Override
	public void setConsumerId(long consumerId) {
		_consumerId = consumerId;

		if (_consumerExtensionInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _consumerExtensionInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setConsumerId", long.class);

				method.invoke(_consumerExtensionInstanceRemoteModel, consumerId);
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

		if (_consumerExtensionInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _consumerExtensionInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeSettings", String.class);

				method.invoke(_consumerExtensionInstanceRemoteModel,
					typeSettings);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setValues(
		java.util.Map<java.lang.String, java.lang.String> values) {
		try {
			String methodName = "setValues";

			Class<?>[] parameterTypes = new Class<?>[] { java.util.Map.class };

			Object[] parameterValues = new Object[] { values };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getConsumerExtensionGuid() {
		try {
			String methodName = "getConsumerExtensionGuid";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setConsumerExtensionGuid(java.lang.String consumerExtensionGuid) {
		try {
			String methodName = "setConsumerExtensionGuid";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { consumerExtensionGuid };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getValues() {
		try {
			String methodName = "getValues";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.Map<java.lang.String, java.lang.String> returnObj = (java.util.Map<java.lang.String, java.lang.String>)invokeOnRemoteModel(methodName,
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
				ConsumerExtensionInstance.class.getName()));
	}

	public BaseModel<?> getConsumerExtensionInstanceRemoteModel() {
		return _consumerExtensionInstanceRemoteModel;
	}

	public void setConsumerExtensionInstanceRemoteModel(
		BaseModel<?> consumerExtensionInstanceRemoteModel) {
		_consumerExtensionInstanceRemoteModel = consumerExtensionInstanceRemoteModel;
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

		Class<?> remoteModelClass = _consumerExtensionInstanceRemoteModel.getClass();

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

		Object returnValue = method.invoke(_consumerExtensionInstanceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ConsumerExtensionInstanceLocalServiceUtil.addConsumerExtensionInstance(this);
		}
		else {
			ConsumerExtensionInstanceLocalServiceUtil.updateConsumerExtensionInstance(this);
		}
	}

	@Override
	public ConsumerExtensionInstance toEscapedModel() {
		return (ConsumerExtensionInstance)ProxyUtil.newProxyInstance(ConsumerExtensionInstance.class.getClassLoader(),
			new Class[] { ConsumerExtensionInstance.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ConsumerExtensionInstanceClp clone = new ConsumerExtensionInstanceClp();

		clone.setUuid(getUuid());
		clone.setConsumerExtensionInstanceId(getConsumerExtensionInstanceId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setConsumerExtensionKey(getConsumerExtensionKey());
		clone.setConsumerId(getConsumerId());
		clone.setTypeSettings(getTypeSettings());

		return clone;
	}

	@Override
	public int compareTo(ConsumerExtensionInstance consumerExtensionInstance) {
		int value = 0;

		value = getConsumerExtensionKey()
					.compareTo(consumerExtensionInstance.getConsumerExtensionKey());

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

		if (!(obj instanceof ConsumerExtensionInstanceClp)) {
			return false;
		}

		ConsumerExtensionInstanceClp consumerExtensionInstance = (ConsumerExtensionInstanceClp)obj;

		long primaryKey = consumerExtensionInstance.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", consumerExtensionInstanceId=");
		sb.append(getConsumerExtensionInstanceId());
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
		sb.append(", consumerExtensionKey=");
		sb.append(getConsumerExtensionKey());
		sb.append(", consumerId=");
		sb.append(getConsumerId());
		sb.append(", typeSettings=");
		sb.append(getTypeSettings());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.consumer.manager.model.ConsumerExtensionInstance");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>consumerExtensionInstanceId</column-name><column-value><![CDATA[");
		sb.append(getConsumerExtensionInstanceId());
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
			"<column><column-name>consumerExtensionKey</column-name><column-value><![CDATA[");
		sb.append(getConsumerExtensionKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>consumerId</column-name><column-value><![CDATA[");
		sb.append(getConsumerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeSettings</column-name><column-value><![CDATA[");
		sb.append(getTypeSettings());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _consumerExtensionInstanceId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _consumerExtensionKey;
	private long _consumerId;
	private String _typeSettings;
	private BaseModel<?> _consumerExtensionInstanceRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.consumer.manager.service.ClpSerializer.class;
}