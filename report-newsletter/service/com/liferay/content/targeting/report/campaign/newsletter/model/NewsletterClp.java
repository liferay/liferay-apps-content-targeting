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

package com.liferay.content.targeting.report.campaign.newsletter.model;

import com.liferay.content.targeting.report.campaign.newsletter.service.ClpSerializer;
import com.liferay.content.targeting.report.campaign.newsletter.service.NewsletterLocalServiceUtil;

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
public class NewsletterClp extends BaseModelImpl<Newsletter>
	implements Newsletter {
	public NewsletterClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Newsletter.class;
	}

	@Override
	public String getModelClassName() {
		return Newsletter.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _newsletterId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNewsletterId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _newsletterId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("newsletterId", getNewsletterId());
		attributes.put("campaignId", getCampaignId());
		attributes.put("alias", getAlias());
		attributes.put("elementId", getElementId());
		attributes.put("eventType", getEventType());
		attributes.put("count", getCount());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long newsletterId = (Long)attributes.get("newsletterId");

		if (newsletterId != null) {
			setNewsletterId(newsletterId);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		String alias = (String)attributes.get("alias");

		if (alias != null) {
			setAlias(alias);
		}

		String elementId = (String)attributes.get("elementId");

		if (elementId != null) {
			setElementId(elementId);
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
	public long getNewsletterId() {
		return _newsletterId;
	}

	@Override
	public void setNewsletterId(long newsletterId) {
		_newsletterId = newsletterId;

		if (_newsletterRemoteModel != null) {
			try {
				Class<?> clazz = _newsletterRemoteModel.getClass();

				Method method = clazz.getMethod("setNewsletterId", long.class);

				method.invoke(_newsletterRemoteModel, newsletterId);
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

		if (_newsletterRemoteModel != null) {
			try {
				Class<?> clazz = _newsletterRemoteModel.getClass();

				Method method = clazz.getMethod("setCampaignId", long.class);

				method.invoke(_newsletterRemoteModel, campaignId);
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

		if (_newsletterRemoteModel != null) {
			try {
				Class<?> clazz = _newsletterRemoteModel.getClass();

				Method method = clazz.getMethod("setAlias", String.class);

				method.invoke(_newsletterRemoteModel, alias);
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

		if (_newsletterRemoteModel != null) {
			try {
				Class<?> clazz = _newsletterRemoteModel.getClass();

				Method method = clazz.getMethod("setElementId", String.class);

				method.invoke(_newsletterRemoteModel, elementId);
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

		if (_newsletterRemoteModel != null) {
			try {
				Class<?> clazz = _newsletterRemoteModel.getClass();

				Method method = clazz.getMethod("setEventType", String.class);

				method.invoke(_newsletterRemoteModel, eventType);
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

		if (_newsletterRemoteModel != null) {
			try {
				Class<?> clazz = _newsletterRemoteModel.getClass();

				Method method = clazz.getMethod("setCount", int.class);

				method.invoke(_newsletterRemoteModel, count);
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

		if (_newsletterRemoteModel != null) {
			try {
				Class<?> clazz = _newsletterRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_newsletterRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getNewsletterRemoteModel() {
		return _newsletterRemoteModel;
	}

	public void setNewsletterRemoteModel(BaseModel<?> newsletterRemoteModel) {
		_newsletterRemoteModel = newsletterRemoteModel;
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

		Class<?> remoteModelClass = _newsletterRemoteModel.getClass();

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

		Object returnValue = method.invoke(_newsletterRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			NewsletterLocalServiceUtil.addNewsletter(this);
		}
		else {
			NewsletterLocalServiceUtil.updateNewsletter(this);
		}
	}

	@Override
	public Newsletter toEscapedModel() {
		return (Newsletter)ProxyUtil.newProxyInstance(Newsletter.class.getClassLoader(),
			new Class[] { Newsletter.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NewsletterClp clone = new NewsletterClp();

		clone.setNewsletterId(getNewsletterId());
		clone.setCampaignId(getCampaignId());
		clone.setAlias(getAlias());
		clone.setElementId(getElementId());
		clone.setEventType(getEventType());
		clone.setCount(getCount());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(Newsletter newsletter) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				newsletter.getModifiedDate());

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

		if (!(obj instanceof NewsletterClp)) {
			return false;
		}

		NewsletterClp newsletter = (NewsletterClp)obj;

		long primaryKey = newsletter.getPrimaryKey();

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

		sb.append("{newsletterId=");
		sb.append(getNewsletterId());
		sb.append(", campaignId=");
		sb.append(getCampaignId());
		sb.append(", alias=");
		sb.append(getAlias());
		sb.append(", elementId=");
		sb.append(getElementId());
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
			"com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>newsletterId</column-name><column-value><![CDATA[");
		sb.append(getNewsletterId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignId</column-name><column-value><![CDATA[");
		sb.append(getCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>alias</column-name><column-value><![CDATA[");
		sb.append(getAlias());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>elementId</column-name><column-value><![CDATA[");
		sb.append(getElementId());
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

	private long _newsletterId;
	private long _campaignId;
	private String _alias;
	private String _elementId;
	private String _eventType;
	private int _count;
	private Date _modifiedDate;
	private BaseModel<?> _newsletterRemoteModel;
}