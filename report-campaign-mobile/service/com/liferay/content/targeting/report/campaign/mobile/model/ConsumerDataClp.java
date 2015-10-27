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

import com.liferay.content.targeting.report.campaign.mobile.service.ClpSerializer;
import com.liferay.content.targeting.report.campaign.mobile.service.ConsumerDataLocalServiceUtil;

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
public class ConsumerDataClp extends BaseModelImpl<ConsumerData>
	implements ConsumerData {
	public ConsumerDataClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ConsumerData.class;
	}

	@Override
	public String getModelClassName() {
		return ConsumerData.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _consumerDataId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setConsumerDataId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _consumerDataId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("consumerDataId", getConsumerDataId());
		attributes.put("campaignId", getCampaignId());
		attributes.put("count", getCount());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("eventType", getEventType());
		attributes.put("elementId", getElementId());
		attributes.put("consumerId", getConsumerId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long consumerDataId = (Long)attributes.get("consumerDataId");

		if (consumerDataId != null) {
			setConsumerDataId(consumerDataId);
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

		String elementId = (String)attributes.get("elementId");

		if (elementId != null) {
			setElementId(elementId);
		}

		Long consumerId = (Long)attributes.get("consumerId");

		if (consumerId != null) {
			setConsumerId(consumerId);
		}
	}

	@Override
	public long getConsumerDataId() {
		return _consumerDataId;
	}

	@Override
	public void setConsumerDataId(long consumerDataId) {
		_consumerDataId = consumerDataId;

		if (_consumerDataRemoteModel != null) {
			try {
				Class<?> clazz = _consumerDataRemoteModel.getClass();

				Method method = clazz.getMethod("setConsumerDataId", long.class);

				method.invoke(_consumerDataRemoteModel, consumerDataId);
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

		if (_consumerDataRemoteModel != null) {
			try {
				Class<?> clazz = _consumerDataRemoteModel.getClass();

				Method method = clazz.getMethod("setCampaignId", long.class);

				method.invoke(_consumerDataRemoteModel, campaignId);
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

		if (_consumerDataRemoteModel != null) {
			try {
				Class<?> clazz = _consumerDataRemoteModel.getClass();

				Method method = clazz.getMethod("setCount", int.class);

				method.invoke(_consumerDataRemoteModel, count);
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

		if (_consumerDataRemoteModel != null) {
			try {
				Class<?> clazz = _consumerDataRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_consumerDataRemoteModel, modifiedDate);
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

		if (_consumerDataRemoteModel != null) {
			try {
				Class<?> clazz = _consumerDataRemoteModel.getClass();

				Method method = clazz.getMethod("setEventType", String.class);

				method.invoke(_consumerDataRemoteModel, eventType);
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

		if (_consumerDataRemoteModel != null) {
			try {
				Class<?> clazz = _consumerDataRemoteModel.getClass();

				Method method = clazz.getMethod("setElementId", String.class);

				method.invoke(_consumerDataRemoteModel, elementId);
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

		if (_consumerDataRemoteModel != null) {
			try {
				Class<?> clazz = _consumerDataRemoteModel.getClass();

				Method method = clazz.getMethod("setConsumerId", long.class);

				method.invoke(_consumerDataRemoteModel, consumerId);
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

	public BaseModel<?> getConsumerDataRemoteModel() {
		return _consumerDataRemoteModel;
	}

	public void setConsumerDataRemoteModel(BaseModel<?> consumerDataRemoteModel) {
		_consumerDataRemoteModel = consumerDataRemoteModel;
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

		Class<?> remoteModelClass = _consumerDataRemoteModel.getClass();

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

		Object returnValue = method.invoke(_consumerDataRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ConsumerDataLocalServiceUtil.addConsumerData(this);
		}
		else {
			ConsumerDataLocalServiceUtil.updateConsumerData(this);
		}
	}

	@Override
	public ConsumerData toEscapedModel() {
		return (ConsumerData)ProxyUtil.newProxyInstance(ConsumerData.class.getClassLoader(),
			new Class[] { ConsumerData.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ConsumerDataClp clone = new ConsumerDataClp();

		clone.setConsumerDataId(getConsumerDataId());
		clone.setCampaignId(getCampaignId());
		clone.setCount(getCount());
		clone.setModifiedDate(getModifiedDate());
		clone.setEventType(getEventType());
		clone.setElementId(getElementId());
		clone.setConsumerId(getConsumerId());

		return clone;
	}

	@Override
	public int compareTo(ConsumerData consumerData) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				consumerData.getModifiedDate());

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

		if (!(obj instanceof ConsumerDataClp)) {
			return false;
		}

		ConsumerDataClp consumerData = (ConsumerDataClp)obj;

		long primaryKey = consumerData.getPrimaryKey();

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

		sb.append("{consumerDataId=");
		sb.append(getConsumerDataId());
		sb.append(", campaignId=");
		sb.append(getCampaignId());
		sb.append(", count=");
		sb.append(getCount());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", eventType=");
		sb.append(getEventType());
		sb.append(", elementId=");
		sb.append(getElementId());
		sb.append(", consumerId=");
		sb.append(getConsumerId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>consumerDataId</column-name><column-value><![CDATA[");
		sb.append(getConsumerDataId());
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
			"<column><column-name>elementId</column-name><column-value><![CDATA[");
		sb.append(getElementId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>consumerId</column-name><column-value><![CDATA[");
		sb.append(getConsumerId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _consumerDataId;
	private long _campaignId;
	private int _count;
	private Date _modifiedDate;
	private String _eventType;
	private String _elementId;
	private long _consumerId;
	private BaseModel<?> _consumerDataRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.content.targeting.report.campaign.mobile.service.ClpSerializer.class;
}