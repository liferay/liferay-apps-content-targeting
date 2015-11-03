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

package com.liferay.content.targeting.report.campaign.mobile.model;

import com.liferay.content.targeting.report.campaign.mobile.service.CampaignMobileLocalServiceUtil;
import com.liferay.content.targeting.report.campaign.mobile.service.ClpSerializer;

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
public class CampaignMobileClp extends BaseModelImpl<CampaignMobile>
	implements CampaignMobile {
	public CampaignMobileClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CampaignMobile.class;
	}

	@Override
	public String getModelClassName() {
		return CampaignMobile.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _campaignMobileId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCampaignMobileId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _campaignMobileId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("campaignMobileId", getCampaignMobileId());
		attributes.put("campaignId", getCampaignId());
		attributes.put("count", getCount());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("eventType", getEventType());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("elementId", getElementId());
		attributes.put("consumerId", getConsumerId());
		attributes.put("placeholderId", getPlaceholderId());
		attributes.put("userSegmentId", getUserSegmentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long campaignMobileId = (Long)attributes.get("campaignMobileId");

		if (campaignMobileId != null) {
			setCampaignMobileId(campaignMobileId);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		Integer count = (Integer)attributes.get("count");

		if (count != null) {
			setCount(count);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String elementId = (String)attributes.get("elementId");

		if (elementId != null) {
			setElementId(elementId);
		}

		Long consumerId = (Long)attributes.get("consumerId");

		if (consumerId != null) {
			setConsumerId(consumerId);
		}

		Long placeholderId = (Long)attributes.get("placeholderId");

		if (placeholderId != null) {
			setPlaceholderId(placeholderId);
		}

		Long userSegmentId = (Long)attributes.get("userSegmentId");

		if (userSegmentId != null) {
			setUserSegmentId(userSegmentId);
		}
	}

	@Override
	public long getCampaignMobileId() {
		return _campaignMobileId;
	}

	@Override
	public void setCampaignMobileId(long campaignMobileId) {
		_campaignMobileId = campaignMobileId;

		if (_campaignMobileRemoteModel != null) {
			try {
				Class<?> clazz = _campaignMobileRemoteModel.getClass();

				Method method = clazz.getMethod("setCampaignMobileId",
						long.class);

				method.invoke(_campaignMobileRemoteModel, campaignMobileId);
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

		if (_campaignMobileRemoteModel != null) {
			try {
				Class<?> clazz = _campaignMobileRemoteModel.getClass();

				Method method = clazz.getMethod("setCampaignId", long.class);

				method.invoke(_campaignMobileRemoteModel, campaignId);
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

		if (_campaignMobileRemoteModel != null) {
			try {
				Class<?> clazz = _campaignMobileRemoteModel.getClass();

				Method method = clazz.getMethod("setCount", int.class);

				method.invoke(_campaignMobileRemoteModel, count);
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

		if (_campaignMobileRemoteModel != null) {
			try {
				Class<?> clazz = _campaignMobileRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_campaignMobileRemoteModel, modifiedDate);
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

		if (_campaignMobileRemoteModel != null) {
			try {
				Class<?> clazz = _campaignMobileRemoteModel.getClass();

				Method method = clazz.getMethod("setEventType", String.class);

				method.invoke(_campaignMobileRemoteModel, eventType);
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

		if (_campaignMobileRemoteModel != null) {
			try {
				Class<?> clazz = _campaignMobileRemoteModel.getClass();

				Method method = clazz.getMethod("setClassName", String.class);

				method.invoke(_campaignMobileRemoteModel, className);
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

		if (_campaignMobileRemoteModel != null) {
			try {
				Class<?> clazz = _campaignMobileRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_campaignMobileRemoteModel, classPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getElementId() {
		return _elementId;
	}

	@Override
	public void setElementId(String elementId) {
		_elementId = elementId;

		if (_campaignMobileRemoteModel != null) {
			try {
				Class<?> clazz = _campaignMobileRemoteModel.getClass();

				Method method = clazz.getMethod("setElementId", String.class);

				method.invoke(_campaignMobileRemoteModel, elementId);
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

		if (_campaignMobileRemoteModel != null) {
			try {
				Class<?> clazz = _campaignMobileRemoteModel.getClass();

				Method method = clazz.getMethod("setConsumerId", long.class);

				method.invoke(_campaignMobileRemoteModel, consumerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPlaceholderId() {
		return _placeholderId;
	}

	@Override
	public void setPlaceholderId(long placeholderId) {
		_placeholderId = placeholderId;

		if (_campaignMobileRemoteModel != null) {
			try {
				Class<?> clazz = _campaignMobileRemoteModel.getClass();

				Method method = clazz.getMethod("setPlaceholderId", long.class);

				method.invoke(_campaignMobileRemoteModel, placeholderId);
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

		if (_campaignMobileRemoteModel != null) {
			try {
				Class<?> clazz = _campaignMobileRemoteModel.getClass();

				Method method = clazz.getMethod("setUserSegmentId", long.class);

				method.invoke(_campaignMobileRemoteModel, userSegmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getConsumerName(java.util.Locale locale) {
		try {
			String methodName = "getConsumerName";

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

	@Override
	public java.lang.String getUserSegmentName(java.util.Locale locale) {
		try {
			String methodName = "getUserSegmentName";

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
	public java.lang.String getPlaceholderName(java.util.Locale locale) {
		try {
			String methodName = "getPlaceholderName";

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

	public BaseModel<?> getCampaignMobileRemoteModel() {
		return _campaignMobileRemoteModel;
	}

	public void setCampaignMobileRemoteModel(
		BaseModel<?> campaignMobileRemoteModel) {
		_campaignMobileRemoteModel = campaignMobileRemoteModel;
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

		Class<?> remoteModelClass = _campaignMobileRemoteModel.getClass();

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

		Object returnValue = method.invoke(_campaignMobileRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CampaignMobileLocalServiceUtil.addCampaignMobile(this);
		}
		else {
			CampaignMobileLocalServiceUtil.updateCampaignMobile(this);
		}
	}

	@Override
	public CampaignMobile toEscapedModel() {
		return (CampaignMobile)ProxyUtil.newProxyInstance(CampaignMobile.class.getClassLoader(),
			new Class[] { CampaignMobile.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CampaignMobileClp clone = new CampaignMobileClp();

		clone.setCampaignMobileId(getCampaignMobileId());
		clone.setCampaignId(getCampaignId());
		clone.setCount(getCount());
		clone.setModifiedDate(getModifiedDate());
		clone.setEventType(getEventType());
		clone.setClassName(getClassName());
		clone.setClassPK(getClassPK());
		clone.setElementId(getElementId());
		clone.setConsumerId(getConsumerId());
		clone.setPlaceholderId(getPlaceholderId());
		clone.setUserSegmentId(getUserSegmentId());

		return clone;
	}

	@Override
	public int compareTo(CampaignMobile campaignMobile) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				campaignMobile.getModifiedDate());

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

		if (!(obj instanceof CampaignMobileClp)) {
			return false;
		}

		CampaignMobileClp campaignMobile = (CampaignMobileClp)obj;

		long primaryKey = campaignMobile.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{campaignMobileId=");
		sb.append(getCampaignMobileId());
		sb.append(", campaignId=");
		sb.append(getCampaignId());
		sb.append(", count=");
		sb.append(getCount());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", eventType=");
		sb.append(getEventType());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", elementId=");
		sb.append(getElementId());
		sb.append(", consumerId=");
		sb.append(getConsumerId());
		sb.append(", placeholderId=");
		sb.append(getPlaceholderId());
		sb.append(", userSegmentId=");
		sb.append(getUserSegmentId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>campaignMobileId</column-name><column-value><![CDATA[");
		sb.append(getCampaignMobileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignId</column-name><column-value><![CDATA[");
		sb.append(getCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>count</column-name><column-value><![CDATA[");
		sb.append(getCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventType</column-name><column-value><![CDATA[");
		sb.append(getEventType());
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
			"<column><column-name>elementId</column-name><column-value><![CDATA[");
		sb.append(getElementId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>consumerId</column-name><column-value><![CDATA[");
		sb.append(getConsumerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>placeholderId</column-name><column-value><![CDATA[");
		sb.append(getPlaceholderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userSegmentId</column-name><column-value><![CDATA[");
		sb.append(getUserSegmentId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _campaignMobileId;
	private long _campaignId;
	private int _count;
	private Date _modifiedDate;
	private String _eventType;
	private String _className;
	private long _classPK;
	private String _elementId;
	private long _consumerId;
	private long _placeholderId;
	private long _userSegmentId;
	private BaseModel<?> _campaignMobileRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.content.targeting.report.campaign.mobile.service.ClpSerializer.class;
}