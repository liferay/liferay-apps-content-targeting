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

package com.liferay.analytics.model;

import com.liferay.analytics.service.AnalyticsEventLocalServiceUtil;
import com.liferay.analytics.service.ClpSerializer;

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
public class AnalyticsEventClp extends BaseModelImpl<AnalyticsEvent>
	implements AnalyticsEvent {
	public AnalyticsEventClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AnalyticsEvent.class;
	}

	@Override
	public String getModelClassName() {
		return AnalyticsEvent.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _analyticsEventId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAnalyticsEventId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _analyticsEventId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("analyticsEventId", getAnalyticsEventId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("anonymousUserId", getAnonymousUserId());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("referrerClassName", getReferrerClassName());
		attributes.put("referrerClassPK", getReferrerClassPK());
		attributes.put("eventType", getEventType());
		attributes.put("clientIP", getClientIP());
		attributes.put("userAgent", getUserAgent());
		attributes.put("languageId", getLanguageId());
		attributes.put("URL", getURL());
		attributes.put("additionalInfo", getAdditionalInfo());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long analyticsEventId = (Long)attributes.get("analyticsEventId");

		if (analyticsEventId != null) {
			setAnalyticsEventId(analyticsEventId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long anonymousUserId = (Long)attributes.get("anonymousUserId");

		if (anonymousUserId != null) {
			setAnonymousUserId(anonymousUserId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String referrerClassName = (String)attributes.get("referrerClassName");

		if (referrerClassName != null) {
			setReferrerClassName(referrerClassName);
		}

		Long referrerClassPK = (Long)attributes.get("referrerClassPK");

		if (referrerClassPK != null) {
			setReferrerClassPK(referrerClassPK);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}

		String clientIP = (String)attributes.get("clientIP");

		if (clientIP != null) {
			setClientIP(clientIP);
		}

		String userAgent = (String)attributes.get("userAgent");

		if (userAgent != null) {
			setUserAgent(userAgent);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		String URL = (String)attributes.get("URL");

		if (URL != null) {
			setURL(URL);
		}

		String additionalInfo = (String)attributes.get("additionalInfo");

		if (additionalInfo != null) {
			setAdditionalInfo(additionalInfo);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public long getAnalyticsEventId() {
		return _analyticsEventId;
	}

	@Override
	public void setAnalyticsEventId(long analyticsEventId) {
		_analyticsEventId = analyticsEventId;

		if (_analyticsEventRemoteModel != null) {
			try {
				Class<?> clazz = _analyticsEventRemoteModel.getClass();

				Method method = clazz.getMethod("setAnalyticsEventId",
						long.class);

				method.invoke(_analyticsEventRemoteModel, analyticsEventId);
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

		if (_analyticsEventRemoteModel != null) {
			try {
				Class<?> clazz = _analyticsEventRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_analyticsEventRemoteModel, companyId);
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

		if (_analyticsEventRemoteModel != null) {
			try {
				Class<?> clazz = _analyticsEventRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_analyticsEventRemoteModel, userId);
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
	public long getAnonymousUserId() {
		return _anonymousUserId;
	}

	@Override
	public void setAnonymousUserId(long anonymousUserId) {
		_anonymousUserId = anonymousUserId;

		if (_analyticsEventRemoteModel != null) {
			try {
				Class<?> clazz = _analyticsEventRemoteModel.getClass();

				Method method = clazz.getMethod("setAnonymousUserId", long.class);

				method.invoke(_analyticsEventRemoteModel, anonymousUserId);
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
	public String getClassName() {
		return _className;
	}

	@Override
	public void setClassName(String className) {
		_className = className;

		if (_analyticsEventRemoteModel != null) {
			try {
				Class<?> clazz = _analyticsEventRemoteModel.getClass();

				Method method = clazz.getMethod("setClassName", String.class);

				method.invoke(_analyticsEventRemoteModel, className);
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

		if (_analyticsEventRemoteModel != null) {
			try {
				Class<?> clazz = _analyticsEventRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_analyticsEventRemoteModel, classPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReferrerClassName() {
		return _referrerClassName;
	}

	@Override
	public void setReferrerClassName(String referrerClassName) {
		_referrerClassName = referrerClassName;

		if (_analyticsEventRemoteModel != null) {
			try {
				Class<?> clazz = _analyticsEventRemoteModel.getClass();

				Method method = clazz.getMethod("setReferrerClassName",
						String.class);

				method.invoke(_analyticsEventRemoteModel, referrerClassName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getReferrerClassPK() {
		return _referrerClassPK;
	}

	@Override
	public void setReferrerClassPK(long referrerClassPK) {
		_referrerClassPK = referrerClassPK;

		if (_analyticsEventRemoteModel != null) {
			try {
				Class<?> clazz = _analyticsEventRemoteModel.getClass();

				Method method = clazz.getMethod("setReferrerClassPK", long.class);

				method.invoke(_analyticsEventRemoteModel, referrerClassPK);
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

		if (_analyticsEventRemoteModel != null) {
			try {
				Class<?> clazz = _analyticsEventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventType", String.class);

				method.invoke(_analyticsEventRemoteModel, eventType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClientIP() {
		return _clientIP;
	}

	@Override
	public void setClientIP(String clientIP) {
		_clientIP = clientIP;

		if (_analyticsEventRemoteModel != null) {
			try {
				Class<?> clazz = _analyticsEventRemoteModel.getClass();

				Method method = clazz.getMethod("setClientIP", String.class);

				method.invoke(_analyticsEventRemoteModel, clientIP);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserAgent() {
		return _userAgent;
	}

	@Override
	public void setUserAgent(String userAgent) {
		_userAgent = userAgent;

		if (_analyticsEventRemoteModel != null) {
			try {
				Class<?> clazz = _analyticsEventRemoteModel.getClass();

				Method method = clazz.getMethod("setUserAgent", String.class);

				method.invoke(_analyticsEventRemoteModel, userAgent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLanguageId() {
		return _languageId;
	}

	@Override
	public void setLanguageId(String languageId) {
		_languageId = languageId;

		if (_analyticsEventRemoteModel != null) {
			try {
				Class<?> clazz = _analyticsEventRemoteModel.getClass();

				Method method = clazz.getMethod("setLanguageId", String.class);

				method.invoke(_analyticsEventRemoteModel, languageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getURL() {
		return _URL;
	}

	@Override
	public void setURL(String URL) {
		_URL = URL;

		if (_analyticsEventRemoteModel != null) {
			try {
				Class<?> clazz = _analyticsEventRemoteModel.getClass();

				Method method = clazz.getMethod("setURL", String.class);

				method.invoke(_analyticsEventRemoteModel, URL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAdditionalInfo() {
		return _additionalInfo;
	}

	@Override
	public void setAdditionalInfo(String additionalInfo) {
		_additionalInfo = additionalInfo;

		if (_analyticsEventRemoteModel != null) {
			try {
				Class<?> clazz = _analyticsEventRemoteModel.getClass();

				Method method = clazz.getMethod("setAdditionalInfo",
						String.class);

				method.invoke(_analyticsEventRemoteModel, additionalInfo);
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

		if (_analyticsEventRemoteModel != null) {
			try {
				Class<?> clazz = _analyticsEventRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_analyticsEventRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAnalyticsEventRemoteModel() {
		return _analyticsEventRemoteModel;
	}

	public void setAnalyticsEventRemoteModel(
		BaseModel<?> analyticsEventRemoteModel) {
		_analyticsEventRemoteModel = analyticsEventRemoteModel;
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

		Class<?> remoteModelClass = _analyticsEventRemoteModel.getClass();

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

		Object returnValue = method.invoke(_analyticsEventRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AnalyticsEventLocalServiceUtil.addAnalyticsEvent(this);
		}
		else {
			AnalyticsEventLocalServiceUtil.updateAnalyticsEvent(this);
		}
	}

	@Override
	public AnalyticsEvent toEscapedModel() {
		return (AnalyticsEvent)ProxyUtil.newProxyInstance(AnalyticsEvent.class.getClassLoader(),
			new Class[] { AnalyticsEvent.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AnalyticsEventClp clone = new AnalyticsEventClp();

		clone.setAnalyticsEventId(getAnalyticsEventId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setAnonymousUserId(getAnonymousUserId());
		clone.setClassName(getClassName());
		clone.setClassPK(getClassPK());
		clone.setReferrerClassName(getReferrerClassName());
		clone.setReferrerClassPK(getReferrerClassPK());
		clone.setEventType(getEventType());
		clone.setClientIP(getClientIP());
		clone.setUserAgent(getUserAgent());
		clone.setLanguageId(getLanguageId());
		clone.setURL(getURL());
		clone.setAdditionalInfo(getAdditionalInfo());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(AnalyticsEvent analyticsEvent) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				analyticsEvent.getCreateDate());

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

		if (!(obj instanceof AnalyticsEventClp)) {
			return false;
		}

		AnalyticsEventClp analyticsEvent = (AnalyticsEventClp)obj;

		long primaryKey = analyticsEvent.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{analyticsEventId=");
		sb.append(getAnalyticsEventId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", anonymousUserId=");
		sb.append(getAnonymousUserId());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", referrerClassName=");
		sb.append(getReferrerClassName());
		sb.append(", referrerClassPK=");
		sb.append(getReferrerClassPK());
		sb.append(", eventType=");
		sb.append(getEventType());
		sb.append(", clientIP=");
		sb.append(getClientIP());
		sb.append(", userAgent=");
		sb.append(getUserAgent());
		sb.append(", languageId=");
		sb.append(getLanguageId());
		sb.append(", URL=");
		sb.append(getURL());
		sb.append(", additionalInfo=");
		sb.append(getAdditionalInfo());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.liferay.analytics.model.AnalyticsEvent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>analyticsEventId</column-name><column-value><![CDATA[");
		sb.append(getAnalyticsEventId());
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
			"<column><column-name>anonymousUserId</column-name><column-value><![CDATA[");
		sb.append(getAnonymousUserId());
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
			"<column><column-name>referrerClassName</column-name><column-value><![CDATA[");
		sb.append(getReferrerClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>referrerClassPK</column-name><column-value><![CDATA[");
		sb.append(getReferrerClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventType</column-name><column-value><![CDATA[");
		sb.append(getEventType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clientIP</column-name><column-value><![CDATA[");
		sb.append(getClientIP());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userAgent</column-name><column-value><![CDATA[");
		sb.append(getUserAgent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageId</column-name><column-value><![CDATA[");
		sb.append(getLanguageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>URL</column-name><column-value><![CDATA[");
		sb.append(getURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>additionalInfo</column-name><column-value><![CDATA[");
		sb.append(getAdditionalInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _analyticsEventId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _anonymousUserId;
	private String _anonymousUserUuid;
	private String _className;
	private long _classPK;
	private String _referrerClassName;
	private long _referrerClassPK;
	private String _eventType;
	private String _clientIP;
	private String _userAgent;
	private String _languageId;
	private String _URL;
	private String _additionalInfo;
	private Date _createDate;
	private BaseModel<?> _analyticsEventRemoteModel;
}