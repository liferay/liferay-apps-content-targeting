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

import com.liferay.content.targeting.service.ChannelInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.ClpSerializer;

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
public class ChannelInstanceClp extends BaseModelImpl<ChannelInstance>
	implements ChannelInstance {
	public ChannelInstanceClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ChannelInstance.class;
	}

	@Override
	public String getModelClassName() {
		return ChannelInstance.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _channelInstanceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setChannelInstanceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _channelInstanceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("channelInstanceId", getChannelInstanceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("channelKey", getChannelKey());
		attributes.put("campaignId", getCampaignId());
		attributes.put("tacticId", getTacticId());
		attributes.put("alias", getAlias());
		attributes.put("typeSettings", getTypeSettings());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long channelInstanceId = (Long)attributes.get("channelInstanceId");

		if (channelInstanceId != null) {
			setChannelInstanceId(channelInstanceId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		String channelKey = (String)attributes.get("channelKey");

		if (channelKey != null) {
			setChannelKey(channelKey);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		Long tacticId = (Long)attributes.get("tacticId");

		if (tacticId != null) {
			setTacticId(tacticId);
		}

		String alias = (String)attributes.get("alias");

		if (alias != null) {
			setAlias(alias);
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

		if (_channelInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _channelInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_channelInstanceRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getChannelInstanceId() {
		return _channelInstanceId;
	}

	@Override
	public void setChannelInstanceId(long channelInstanceId) {
		_channelInstanceId = channelInstanceId;

		if (_channelInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _channelInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setChannelInstanceId",
						long.class);

				method.invoke(_channelInstanceRemoteModel, channelInstanceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_channelInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _channelInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_channelInstanceRemoteModel, groupId);
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

		if (_channelInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _channelInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_channelInstanceRemoteModel, companyId);
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

		if (_channelInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _channelInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_channelInstanceRemoteModel, userId);
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

		if (_channelInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _channelInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_channelInstanceRemoteModel, userName);
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

		if (_channelInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _channelInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_channelInstanceRemoteModel, createDate);
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

		if (_channelInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _channelInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_channelInstanceRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getChannelKey() {
		return _channelKey;
	}

	@Override
	public void setChannelKey(String channelKey) {
		_channelKey = channelKey;

		if (_channelInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _channelInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setChannelKey", String.class);

				method.invoke(_channelInstanceRemoteModel, channelKey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCampaignId() {
		return _campaignId;
	}

	@Override
	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;

		if (_channelInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _channelInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setCampaignId", long.class);

				method.invoke(_channelInstanceRemoteModel, campaignId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTacticId() {
		return _tacticId;
	}

	@Override
	public void setTacticId(long tacticId) {
		_tacticId = tacticId;

		if (_channelInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _channelInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setTacticId", long.class);

				method.invoke(_channelInstanceRemoteModel, tacticId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAlias() {
		return _alias;
	}

	@Override
	public void setAlias(String alias) {
		_alias = alias;

		if (_channelInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _channelInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setAlias", String.class);

				method.invoke(_channelInstanceRemoteModel, alias);
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

		if (_channelInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _channelInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeSettings", String.class);

				method.invoke(_channelInstanceRemoteModel, typeSettings);
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
				ChannelInstance.class.getName()));
	}

	public BaseModel<?> getChannelInstanceRemoteModel() {
		return _channelInstanceRemoteModel;
	}

	public void setChannelInstanceRemoteModel(
		BaseModel<?> channelInstanceRemoteModel) {
		_channelInstanceRemoteModel = channelInstanceRemoteModel;
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

		Class<?> remoteModelClass = _channelInstanceRemoteModel.getClass();

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

		Object returnValue = method.invoke(_channelInstanceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ChannelInstanceLocalServiceUtil.addChannelInstance(this);
		}
		else {
			ChannelInstanceLocalServiceUtil.updateChannelInstance(this);
		}
	}

	@Override
	public ChannelInstance toEscapedModel() {
		return (ChannelInstance)ProxyUtil.newProxyInstance(ChannelInstance.class.getClassLoader(),
			new Class[] { ChannelInstance.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ChannelInstanceClp clone = new ChannelInstanceClp();

		clone.setUuid(getUuid());
		clone.setChannelInstanceId(getChannelInstanceId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setChannelKey(getChannelKey());
		clone.setCampaignId(getCampaignId());
		clone.setTacticId(getTacticId());
		clone.setAlias(getAlias());
		clone.setTypeSettings(getTypeSettings());

		return clone;
	}

	@Override
	public int compareTo(ChannelInstance channelInstance) {
		int value = 0;

		value = getChannelKey().compareTo(channelInstance.getChannelKey());

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

		if (!(obj instanceof ChannelInstanceClp)) {
			return false;
		}

		ChannelInstanceClp channelInstance = (ChannelInstanceClp)obj;

		long primaryKey = channelInstance.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", channelInstanceId=");
		sb.append(getChannelInstanceId());
		sb.append(", groupId=");
		sb.append(getGroupId());
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
		sb.append(", channelKey=");
		sb.append(getChannelKey());
		sb.append(", campaignId=");
		sb.append(getCampaignId());
		sb.append(", tacticId=");
		sb.append(getTacticId());
		sb.append(", alias=");
		sb.append(getAlias());
		sb.append(", typeSettings=");
		sb.append(getTypeSettings());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.liferay.content.targeting.model.ChannelInstance");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>channelInstanceId</column-name><column-value><![CDATA[");
		sb.append(getChannelInstanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
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
			"<column><column-name>channelKey</column-name><column-value><![CDATA[");
		sb.append(getChannelKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignId</column-name><column-value><![CDATA[");
		sb.append(getCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tacticId</column-name><column-value><![CDATA[");
		sb.append(getTacticId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>alias</column-name><column-value><![CDATA[");
		sb.append(getAlias());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeSettings</column-name><column-value><![CDATA[");
		sb.append(getTypeSettings());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _channelInstanceId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _channelKey;
	private long _campaignId;
	private long _tacticId;
	private String _alias;
	private String _typeSettings;
	private BaseModel<?> _channelInstanceRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.content.targeting.service.ClpSerializer.class;
}