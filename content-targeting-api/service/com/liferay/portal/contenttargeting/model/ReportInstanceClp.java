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

package com.liferay.portal.contenttargeting.model;

import com.liferay.portal.contenttargeting.service.ClpSerializer;
import com.liferay.portal.contenttargeting.service.ReportInstanceLocalServiceUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
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
public class ReportInstanceClp extends BaseModelImpl<ReportInstance>
	implements ReportInstance {
	public ReportInstanceClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ReportInstance.class;
	}

	@Override
	public String getModelClassName() {
		return ReportInstance.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _reportInstanceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setReportInstanceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _reportInstanceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("reportInstanceId", getReportInstanceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("reportKey", getReportKey());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("typeSettings", getTypeSettings());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long reportInstanceId = (Long)attributes.get("reportInstanceId");

		if (reportInstanceId != null) {
			setReportInstanceId(reportInstanceId);
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

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String reportKey = (String)attributes.get("reportKey");

		if (reportKey != null) {
			setReportKey(reportKey);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String typeSettings = (String)attributes.get("typeSettings");

		if (typeSettings != null) {
			setTypeSettings(typeSettings);
		}
	}

	@Override
	public long getReportInstanceId() {
		return _reportInstanceId;
	}

	@Override
	public void setReportInstanceId(long reportInstanceId) {
		_reportInstanceId = reportInstanceId;

		if (_reportInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _reportInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setReportInstanceId",
						long.class);

				method.invoke(_reportInstanceRemoteModel, reportInstanceId);
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

		if (_reportInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _reportInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_reportInstanceRemoteModel, groupId);
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

		if (_reportInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _reportInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_reportInstanceRemoteModel, companyId);
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

		if (_reportInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _reportInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_reportInstanceRemoteModel, userId);
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

		if (_reportInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _reportInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_reportInstanceRemoteModel, userName);
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

		if (_reportInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _reportInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_reportInstanceRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReportKey() {
		return _reportKey;
	}

	@Override
	public void setReportKey(String reportKey) {
		_reportKey = reportKey;

		if (_reportInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _reportInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setReportKey", String.class);

				method.invoke(_reportInstanceRemoteModel, reportKey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassName() {
		return _className;
	}

	@Override
	public void setClassName(String className) {
		_className = className;

		if (_reportInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _reportInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setClassName", String.class);

				method.invoke(_reportInstanceRemoteModel, className);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_classPK = classPK;

		if (_reportInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _reportInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_reportInstanceRemoteModel, classPK);
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

		if (_reportInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _reportInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeSettings", String.class);

				method.invoke(_reportInstanceRemoteModel, typeSettings);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getReportInstanceRemoteModel() {
		return _reportInstanceRemoteModel;
	}

	public void setReportInstanceRemoteModel(
		BaseModel<?> reportInstanceRemoteModel) {
		_reportInstanceRemoteModel = reportInstanceRemoteModel;
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

		Class<?> remoteModelClass = _reportInstanceRemoteModel.getClass();

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

		Object returnValue = method.invoke(_reportInstanceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ReportInstanceLocalServiceUtil.addReportInstance(this);
		}
		else {
			ReportInstanceLocalServiceUtil.updateReportInstance(this);
		}
	}

	@Override
	public ReportInstance toEscapedModel() {
		return (ReportInstance)ProxyUtil.newProxyInstance(ReportInstance.class.getClassLoader(),
			new Class[] { ReportInstance.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ReportInstanceClp clone = new ReportInstanceClp();

		clone.setReportInstanceId(getReportInstanceId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setModifiedDate(getModifiedDate());
		clone.setReportKey(getReportKey());
		clone.setClassName(getClassName());
		clone.setClassPK(getClassPK());
		clone.setTypeSettings(getTypeSettings());

		return clone;
	}

	@Override
	public int compareTo(ReportInstance reportInstance) {
		int value = 0;

		value = getReportKey().compareTo(reportInstance.getReportKey());

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

		if (!(obj instanceof ReportInstanceClp)) {
			return false;
		}

		ReportInstanceClp reportInstance = (ReportInstanceClp)obj;

		long primaryKey = reportInstance.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{reportInstanceId=");
		sb.append(getReportInstanceId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", reportKey=");
		sb.append(getReportKey());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", typeSettings=");
		sb.append(getTypeSettings());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.contenttargeting.model.ReportInstance");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>reportInstanceId</column-name><column-value><![CDATA[");
		sb.append(getReportInstanceId());
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
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportKey</column-name><column-value><![CDATA[");
		sb.append(getReportKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>className</column-name><column-value><![CDATA[");
		sb.append(getClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeSettings</column-name><column-value><![CDATA[");
		sb.append(getTypeSettings());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _reportInstanceId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _modifiedDate;
	private String _reportKey;
	private String _className;
	private long _classPK;
	private String _typeSettings;
	private BaseModel<?> _reportInstanceRemoteModel;
}