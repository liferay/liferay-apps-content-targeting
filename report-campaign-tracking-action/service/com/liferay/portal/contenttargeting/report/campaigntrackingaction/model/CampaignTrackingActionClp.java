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

package com.liferay.portal.contenttargeting.report.campaigntrackingaction.model;

import com.liferay.portal.contenttargeting.report.campaigntrackingaction.service.CampaignTrackingActionLocalServiceUtil;
import com.liferay.portal.contenttargeting.report.campaigntrackingaction.service.ClpSerializer;
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
public class CampaignTrackingActionClp extends BaseModelImpl<CampaignTrackingAction>
	implements CampaignTrackingAction {
	public CampaignTrackingActionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CampaignTrackingAction.class;
	}

	@Override
	public String getModelClassName() {
		return CampaignTrackingAction.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _campaignTrackingActionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCampaignTrackingActionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _campaignTrackingActionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("campaignTrackingActionId", getCampaignTrackingActionId());
		attributes.put("campaignId", getCampaignId());
		attributes.put("userSegmentId", getUserSegmentId());
		attributes.put("alias", getAlias());
		attributes.put("referrerClassName", getReferrerClassName());
		attributes.put("referrerClassPK", getReferrerClassPK());
		attributes.put("elementId", getElementId());
		attributes.put("eventType", getEventType());
		attributes.put("count", getCount());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long campaignTrackingActionId = (Long)attributes.get(
				"campaignTrackingActionId");

		if (campaignTrackingActionId != null) {
			setCampaignTrackingActionId(campaignTrackingActionId);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		Long userSegmentId = (Long)attributes.get("userSegmentId");

		if (userSegmentId != null) {
			setUserSegmentId(userSegmentId);
		}

		String alias = (String)attributes.get("alias");

		if (alias != null) {
			setAlias(alias);
		}

		String referrerClassName = (String)attributes.get("referrerClassName");

		if (referrerClassName != null) {
			setReferrerClassName(referrerClassName);
		}

		Long referrerClassPK = (Long)attributes.get("referrerClassPK");

		if (referrerClassPK != null) {
			setReferrerClassPK(referrerClassPK);
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
	public long getCampaignTrackingActionId() {
		return _campaignTrackingActionId;
	}

	@Override
	public void setCampaignTrackingActionId(long campaignTrackingActionId) {
		_campaignTrackingActionId = campaignTrackingActionId;

		if (_campaignTrackingActionRemoteModel != null) {
			try {
				Class<?> clazz = _campaignTrackingActionRemoteModel.getClass();

				Method method = clazz.getMethod("setCampaignTrackingActionId",
						long.class);

				method.invoke(_campaignTrackingActionRemoteModel,
					campaignTrackingActionId);
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

		if (_campaignTrackingActionRemoteModel != null) {
			try {
				Class<?> clazz = _campaignTrackingActionRemoteModel.getClass();

				Method method = clazz.getMethod("setCampaignId", long.class);

				method.invoke(_campaignTrackingActionRemoteModel, campaignId);
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

		if (_campaignTrackingActionRemoteModel != null) {
			try {
				Class<?> clazz = _campaignTrackingActionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserSegmentId", long.class);

				method.invoke(_campaignTrackingActionRemoteModel, userSegmentId);
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

		if (_campaignTrackingActionRemoteModel != null) {
			try {
				Class<?> clazz = _campaignTrackingActionRemoteModel.getClass();

				Method method = clazz.getMethod("setAlias", String.class);

				method.invoke(_campaignTrackingActionRemoteModel, alias);
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

		if (_campaignTrackingActionRemoteModel != null) {
			try {
				Class<?> clazz = _campaignTrackingActionRemoteModel.getClass();

				Method method = clazz.getMethod("setReferrerClassName",
						String.class);

				method.invoke(_campaignTrackingActionRemoteModel,
					referrerClassName);
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

		if (_campaignTrackingActionRemoteModel != null) {
			try {
				Class<?> clazz = _campaignTrackingActionRemoteModel.getClass();

				Method method = clazz.getMethod("setReferrerClassPK", long.class);

				method.invoke(_campaignTrackingActionRemoteModel,
					referrerClassPK);
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

		if (_campaignTrackingActionRemoteModel != null) {
			try {
				Class<?> clazz = _campaignTrackingActionRemoteModel.getClass();

				Method method = clazz.getMethod("setElementId", String.class);

				method.invoke(_campaignTrackingActionRemoteModel, elementId);
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

		if (_campaignTrackingActionRemoteModel != null) {
			try {
				Class<?> clazz = _campaignTrackingActionRemoteModel.getClass();

				Method method = clazz.getMethod("setEventType", String.class);

				method.invoke(_campaignTrackingActionRemoteModel, eventType);
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

		if (_campaignTrackingActionRemoteModel != null) {
			try {
				Class<?> clazz = _campaignTrackingActionRemoteModel.getClass();

				Method method = clazz.getMethod("setCount", int.class);

				method.invoke(_campaignTrackingActionRemoteModel, count);
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

		if (_campaignTrackingActionRemoteModel != null) {
			try {
				Class<?> clazz = _campaignTrackingActionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_campaignTrackingActionRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
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

	public BaseModel<?> getCampaignTrackingActionRemoteModel() {
		return _campaignTrackingActionRemoteModel;
	}

	public void setCampaignTrackingActionRemoteModel(
		BaseModel<?> campaignTrackingActionRemoteModel) {
		_campaignTrackingActionRemoteModel = campaignTrackingActionRemoteModel;
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

		Class<?> remoteModelClass = _campaignTrackingActionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_campaignTrackingActionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CampaignTrackingActionLocalServiceUtil.addCampaignTrackingAction(this);
		}
		else {
			CampaignTrackingActionLocalServiceUtil.updateCampaignTrackingAction(this);
		}
	}

	@Override
	public CampaignTrackingAction toEscapedModel() {
		return (CampaignTrackingAction)ProxyUtil.newProxyInstance(CampaignTrackingAction.class.getClassLoader(),
			new Class[] { CampaignTrackingAction.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CampaignTrackingActionClp clone = new CampaignTrackingActionClp();

		clone.setCampaignTrackingActionId(getCampaignTrackingActionId());
		clone.setCampaignId(getCampaignId());
		clone.setUserSegmentId(getUserSegmentId());
		clone.setAlias(getAlias());
		clone.setReferrerClassName(getReferrerClassName());
		clone.setReferrerClassPK(getReferrerClassPK());
		clone.setElementId(getElementId());
		clone.setEventType(getEventType());
		clone.setCount(getCount());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(CampaignTrackingAction campaignTrackingAction) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				campaignTrackingAction.getModifiedDate());

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

		if (!(obj instanceof CampaignTrackingActionClp)) {
			return false;
		}

		CampaignTrackingActionClp campaignTrackingAction = (CampaignTrackingActionClp)obj;

		long primaryKey = campaignTrackingAction.getPrimaryKey();

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

		sb.append("{campaignTrackingActionId=");
		sb.append(getCampaignTrackingActionId());
		sb.append(", campaignId=");
		sb.append(getCampaignId());
		sb.append(", userSegmentId=");
		sb.append(getUserSegmentId());
		sb.append(", alias=");
		sb.append(getAlias());
		sb.append(", referrerClassName=");
		sb.append(getReferrerClassName());
		sb.append(", referrerClassPK=");
		sb.append(getReferrerClassPK());
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
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.portal.contenttargeting.report.campaigntrackingaction.model.CampaignTrackingAction");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>campaignTrackingActionId</column-name><column-value><![CDATA[");
		sb.append(getCampaignTrackingActionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignId</column-name><column-value><![CDATA[");
		sb.append(getCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userSegmentId</column-name><column-value><![CDATA[");
		sb.append(getUserSegmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>alias</column-name><column-value><![CDATA[");
		sb.append(getAlias());
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

	private long _campaignTrackingActionId;
	private long _campaignId;
	private long _userSegmentId;
	private String _alias;
	private String _referrerClassName;
	private long _referrerClassPK;
	private String _elementId;
	private String _eventType;
	private int _count;
	private Date _modifiedDate;
	private BaseModel<?> _campaignTrackingActionRemoteModel;
}