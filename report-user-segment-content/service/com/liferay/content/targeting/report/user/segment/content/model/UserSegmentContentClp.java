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

package com.liferay.content.targeting.report.user.segment.content.model;

import com.liferay.content.targeting.report.user.segment.content.service.ClpSerializer;
import com.liferay.content.targeting.report.user.segment.content.service.UserSegmentContentLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class UserSegmentContentClp extends BaseModelImpl<UserSegmentContent>
	implements UserSegmentContent {
	public UserSegmentContentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UserSegmentContent.class;
	}

	@Override
	public String getModelClassName() {
		return UserSegmentContent.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _userSegmentContentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserSegmentContentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userSegmentContentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userSegmentContentId", getUserSegmentContentId());
		attributes.put("userSegmentId", getUserSegmentId());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("eventType", getEventType());
		attributes.put("count", getCount());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userSegmentContentId = (Long)attributes.get("userSegmentContentId");

		if (userSegmentContentId != null) {
			setUserSegmentContentId(userSegmentContentId);
		}

		Long userSegmentId = (Long)attributes.get("userSegmentId");

		if (userSegmentId != null) {
			setUserSegmentId(userSegmentId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}

		Integer count = (Integer)attributes.get("count");

		if (count != null) {
			setCount(count);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public long getUserSegmentContentId() {
		return _userSegmentContentId;
	}

	@Override
	public void setUserSegmentContentId(long userSegmentContentId) {
		_userSegmentContentId = userSegmentContentId;

		if (_userSegmentContentRemoteModel != null) {
			try {
				Class<?> clazz = _userSegmentContentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserSegmentContentId",
						long.class);

				method.invoke(_userSegmentContentRemoteModel,
					userSegmentContentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserSegmentId() {
		return _userSegmentId;
	}

	@Override
	public void setUserSegmentId(long userSegmentId) {
		_userSegmentId = userSegmentId;

		if (_userSegmentContentRemoteModel != null) {
			try {
				Class<?> clazz = _userSegmentContentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserSegmentId", long.class);

				method.invoke(_userSegmentContentRemoteModel, userSegmentId);
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

		if (_userSegmentContentRemoteModel != null) {
			try {
				Class<?> clazz = _userSegmentContentRemoteModel.getClass();

				Method method = clazz.getMethod("setClassName", String.class);

				method.invoke(_userSegmentContentRemoteModel, className);
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

		if (_userSegmentContentRemoteModel != null) {
			try {
				Class<?> clazz = _userSegmentContentRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_userSegmentContentRemoteModel, classPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventType() {
		return _eventType;
	}

	@Override
	public void setEventType(String eventType) {
		_eventType = eventType;

		if (_userSegmentContentRemoteModel != null) {
			try {
				Class<?> clazz = _userSegmentContentRemoteModel.getClass();

				Method method = clazz.getMethod("setEventType", String.class);

				method.invoke(_userSegmentContentRemoteModel, eventType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCount() {
		return _count;
	}

	@Override
	public void setCount(int count) {
		_count = count;

		if (_userSegmentContentRemoteModel != null) {
			try {
				Class<?> clazz = _userSegmentContentRemoteModel.getClass();

				Method method = clazz.getMethod("setCount", int.class);

				method.invoke(_userSegmentContentRemoteModel, count);
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

		if (_userSegmentContentRemoteModel != null) {
			try {
				Class<?> clazz = _userSegmentContentRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_userSegmentContentRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getType(java.util.Locale locale) {
		try {
			String methodName = "getType";

			Class<?>[] parameterTypes = new Class<?>[] { java.util.Locale.class };

			Object[] parameterValues = new Object[] { locale };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getTitle(java.util.Locale locale) {
		try {
			String methodName = "getTitle";

			Class<?>[] parameterTypes = new Class<?>[] { java.util.Locale.class };

			Object[] parameterValues = new Object[] { locale };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getUserSegmentContentRemoteModel() {
		return _userSegmentContentRemoteModel;
	}

	public void setUserSegmentContentRemoteModel(
		BaseModel<?> userSegmentContentRemoteModel) {
		_userSegmentContentRemoteModel = userSegmentContentRemoteModel;
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

		Class<?> remoteModelClass = _userSegmentContentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_userSegmentContentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UserSegmentContentLocalServiceUtil.addUserSegmentContent(this);
		}
		else {
			UserSegmentContentLocalServiceUtil.updateUserSegmentContent(this);
		}
	}

	@Override
	public UserSegmentContent toEscapedModel() {
		return (UserSegmentContent)ProxyUtil.newProxyInstance(UserSegmentContent.class.getClassLoader(),
			new Class[] { UserSegmentContent.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserSegmentContentClp clone = new UserSegmentContentClp();

		clone.setUserSegmentContentId(getUserSegmentContentId());
		clone.setUserSegmentId(getUserSegmentId());
		clone.setClassName(getClassName());
		clone.setClassPK(getClassPK());
		clone.setEventType(getEventType());
		clone.setCount(getCount());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(UserSegmentContent userSegmentContent) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				userSegmentContent.getModifiedDate());

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

		if (!(obj instanceof UserSegmentContentClp)) {
			return false;
		}

		UserSegmentContentClp userSegmentContent = (UserSegmentContentClp)obj;

		long primaryKey = userSegmentContent.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{userSegmentContentId=");
		sb.append(getUserSegmentContentId());
		sb.append(", userSegmentId=");
		sb.append(getUserSegmentId());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", eventType=");
		sb.append(getEventType());
		sb.append(", count=");
		sb.append(getCount());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userSegmentContentId</column-name><column-value><![CDATA[");
		sb.append(getUserSegmentContentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userSegmentId</column-name><column-value><![CDATA[");
		sb.append(getUserSegmentId());
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
			"<column><column-name>eventType</column-name><column-value><![CDATA[");
		sb.append(getEventType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>count</column-name><column-value><![CDATA[");
		sb.append(getCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userSegmentContentId;
	private long _userSegmentId;
	private String _className;
	private long _classPK;
	private String _eventType;
	private int _count;
	private Date _modifiedDate;
	private BaseModel<?> _userSegmentContentRemoteModel;
}