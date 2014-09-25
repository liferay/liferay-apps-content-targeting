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

package com.liferay.content.targeting.analytics.model;

import com.liferay.content.targeting.analytics.service.AnalyticsReferrerLocalServiceUtil;
import com.liferay.content.targeting.analytics.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class AnalyticsReferrerClp extends BaseModelImpl<AnalyticsReferrer>
	implements AnalyticsReferrer {
	public AnalyticsReferrerClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AnalyticsReferrer.class;
	}

	@Override
	public String getModelClassName() {
		return AnalyticsReferrer.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _analyticsReferrerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAnalyticsReferrerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _analyticsReferrerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("analyticsReferrerId", getAnalyticsReferrerId());
		attributes.put("analyticsEventId", getAnalyticsEventId());
		attributes.put("referrerClassName", getReferrerClassName());
		attributes.put("referrerClassPK", getReferrerClassPK());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long analyticsReferrerId = (Long)attributes.get("analyticsReferrerId");

		if (analyticsReferrerId != null) {
			setAnalyticsReferrerId(analyticsReferrerId);
		}

		Long analyticsEventId = (Long)attributes.get("analyticsEventId");

		if (analyticsEventId != null) {
			setAnalyticsEventId(analyticsEventId);
		}

		String referrerClassName = (String)attributes.get("referrerClassName");

		if (referrerClassName != null) {
			setReferrerClassName(referrerClassName);
		}

		Long referrerClassPK = (Long)attributes.get("referrerClassPK");

		if (referrerClassPK != null) {
			setReferrerClassPK(referrerClassPK);
		}
	}

	@Override
	public long getAnalyticsReferrerId() {
		return _analyticsReferrerId;
	}

	@Override
	public void setAnalyticsReferrerId(long analyticsReferrerId) {
		_analyticsReferrerId = analyticsReferrerId;

		if (_analyticsReferrerRemoteModel != null) {
			try {
				Class<?> clazz = _analyticsReferrerRemoteModel.getClass();

				Method method = clazz.getMethod("setAnalyticsReferrerId",
						long.class);

				method.invoke(_analyticsReferrerRemoteModel, analyticsReferrerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAnalyticsEventId() {
		return _analyticsEventId;
	}

	@Override
	public void setAnalyticsEventId(long analyticsEventId) {
		_analyticsEventId = analyticsEventId;

		if (_analyticsReferrerRemoteModel != null) {
			try {
				Class<?> clazz = _analyticsReferrerRemoteModel.getClass();

				Method method = clazz.getMethod("setAnalyticsEventId",
						long.class);

				method.invoke(_analyticsReferrerRemoteModel, analyticsEventId);
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

		if (_analyticsReferrerRemoteModel != null) {
			try {
				Class<?> clazz = _analyticsReferrerRemoteModel.getClass();

				Method method = clazz.getMethod("setReferrerClassName",
						String.class);

				method.invoke(_analyticsReferrerRemoteModel, referrerClassName);
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

		if (_analyticsReferrerRemoteModel != null) {
			try {
				Class<?> clazz = _analyticsReferrerRemoteModel.getClass();

				Method method = clazz.getMethod("setReferrerClassPK", long.class);

				method.invoke(_analyticsReferrerRemoteModel, referrerClassPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAnalyticsReferrerRemoteModel() {
		return _analyticsReferrerRemoteModel;
	}

	public void setAnalyticsReferrerRemoteModel(
		BaseModel<?> analyticsReferrerRemoteModel) {
		_analyticsReferrerRemoteModel = analyticsReferrerRemoteModel;
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

		Class<?> remoteModelClass = _analyticsReferrerRemoteModel.getClass();

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

		Object returnValue = method.invoke(_analyticsReferrerRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AnalyticsReferrerLocalServiceUtil.addAnalyticsReferrer(this);
		}
		else {
			AnalyticsReferrerLocalServiceUtil.updateAnalyticsReferrer(this);
		}
	}

	@Override
	public AnalyticsReferrer toEscapedModel() {
		return (AnalyticsReferrer)ProxyUtil.newProxyInstance(AnalyticsReferrer.class.getClassLoader(),
			new Class[] { AnalyticsReferrer.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AnalyticsReferrerClp clone = new AnalyticsReferrerClp();

		clone.setAnalyticsReferrerId(getAnalyticsReferrerId());
		clone.setAnalyticsEventId(getAnalyticsEventId());
		clone.setReferrerClassName(getReferrerClassName());
		clone.setReferrerClassPK(getReferrerClassPK());

		return clone;
	}

	@Override
	public int compareTo(AnalyticsReferrer analyticsReferrer) {
		long primaryKey = analyticsReferrer.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnalyticsReferrerClp)) {
			return false;
		}

		AnalyticsReferrerClp analyticsReferrer = (AnalyticsReferrerClp)obj;

		long primaryKey = analyticsReferrer.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{analyticsReferrerId=");
		sb.append(getAnalyticsReferrerId());
		sb.append(", analyticsEventId=");
		sb.append(getAnalyticsEventId());
		sb.append(", referrerClassName=");
		sb.append(getReferrerClassName());
		sb.append(", referrerClassPK=");
		sb.append(getReferrerClassPK());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.content.targeting.analytics.model.AnalyticsReferrer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>analyticsReferrerId</column-name><column-value><![CDATA[");
		sb.append(getAnalyticsReferrerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>analyticsEventId</column-name><column-value><![CDATA[");
		sb.append(getAnalyticsEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>referrerClassName</column-name><column-value><![CDATA[");
		sb.append(getReferrerClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>referrerClassPK</column-name><column-value><![CDATA[");
		sb.append(getReferrerClassPK());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _analyticsReferrerId;
	private long _analyticsEventId;
	private String _referrerClassName;
	private long _referrerClassPK;
	private BaseModel<?> _analyticsReferrerRemoteModel;
}