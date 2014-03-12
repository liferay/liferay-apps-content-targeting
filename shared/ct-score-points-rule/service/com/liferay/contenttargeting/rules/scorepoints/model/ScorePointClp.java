/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.rules.scorepoints.model;

import com.liferay.contenttargeting.rules.scorepoints.service.ClpSerializer;
import com.liferay.contenttargeting.rules.scorepoints.service.ScorePointLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class ScorePointClp extends BaseModelImpl<ScorePoint>
	implements ScorePoint {
	public ScorePointClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ScorePoint.class;
	}

	@Override
	public String getModelClassName() {
		return ScorePoint.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _Id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _Id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("Id", getId());
		attributes.put("anonymousUserId", getAnonymousUserId());
		attributes.put("userSegmentId", getUserSegmentId());
		attributes.put("points", getPoints());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long Id = (Long)attributes.get("Id");

		if (Id != null) {
			setId(Id);
		}

		Long anonymousUserId = (Long)attributes.get("anonymousUserId");

		if (anonymousUserId != null) {
			setAnonymousUserId(anonymousUserId);
		}

		Long userSegmentId = (Long)attributes.get("userSegmentId");

		if (userSegmentId != null) {
			setUserSegmentId(userSegmentId);
		}

		Long points = (Long)attributes.get("points");

		if (points != null) {
			setPoints(points);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_scorePointRemoteModel != null) {
			try {
				Class<?> clazz = _scorePointRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_scorePointRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getId() {
		return _Id;
	}

	@Override
	public void setId(long Id) {
		_Id = Id;

		if (_scorePointRemoteModel != null) {
			try {
				Class<?> clazz = _scorePointRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_scorePointRemoteModel, Id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAnonymousUserId() {
		return _anonymousUserId;
	}

	@Override
	public void setAnonymousUserId(long anonymousUserId) {
		_anonymousUserId = anonymousUserId;

		if (_scorePointRemoteModel != null) {
			try {
				Class<?> clazz = _scorePointRemoteModel.getClass();

				Method method = clazz.getMethod("setAnonymousUserId", long.class);

				method.invoke(_scorePointRemoteModel, anonymousUserId);
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
	public long getUserSegmentId() {
		return _userSegmentId;
	}

	@Override
	public void setUserSegmentId(long userSegmentId) {
		_userSegmentId = userSegmentId;

		if (_scorePointRemoteModel != null) {
			try {
				Class<?> clazz = _scorePointRemoteModel.getClass();

				Method method = clazz.getMethod("setUserSegmentId", long.class);

				method.invoke(_scorePointRemoteModel, userSegmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPoints() {
		return _points;
	}

	@Override
	public void setPoints(long points) {
		_points = points;

		if (_scorePointRemoteModel != null) {
			try {
				Class<?> clazz = _scorePointRemoteModel.getClass();

				Method method = clazz.getMethod("setPoints", long.class);

				method.invoke(_scorePointRemoteModel, points);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getScorePointRemoteModel() {
		return _scorePointRemoteModel;
	}

	public void setScorePointRemoteModel(BaseModel<?> scorePointRemoteModel) {
		_scorePointRemoteModel = scorePointRemoteModel;
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

		Class<?> remoteModelClass = _scorePointRemoteModel.getClass();

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

		Object returnValue = method.invoke(_scorePointRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ScorePointLocalServiceUtil.addScorePoint(this);
		}
		else {
			ScorePointLocalServiceUtil.updateScorePoint(this);
		}
	}

	@Override
	public ScorePoint toEscapedModel() {
		return (ScorePoint)ProxyUtil.newProxyInstance(ScorePoint.class.getClassLoader(),
			new Class[] { ScorePoint.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ScorePointClp clone = new ScorePointClp();

		clone.setUuid(getUuid());
		clone.setId(getId());
		clone.setAnonymousUserId(getAnonymousUserId());
		clone.setUserSegmentId(getUserSegmentId());
		clone.setPoints(getPoints());

		return clone;
	}

	@Override
	public int compareTo(ScorePoint scorePoint) {
		int value = 0;

		if (getAnonymousUserId() < scorePoint.getAnonymousUserId()) {
			value = -1;
		}
		else if (getAnonymousUserId() > scorePoint.getAnonymousUserId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof ScorePointClp)) {
			return false;
		}

		ScorePointClp scorePoint = (ScorePointClp)obj;

		long primaryKey = scorePoint.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", Id=");
		sb.append(getId());
		sb.append(", anonymousUserId=");
		sb.append(getAnonymousUserId());
		sb.append(", userSegmentId=");
		sb.append(getUserSegmentId());
		sb.append(", points=");
		sb.append(getPoints());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>anonymousUserId</column-name><column-value><![CDATA[");
		sb.append(getAnonymousUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userSegmentId</column-name><column-value><![CDATA[");
		sb.append(getUserSegmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>points</column-name><column-value><![CDATA[");
		sb.append(getPoints());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _Id;
	private long _anonymousUserId;
	private String _anonymousUserUuid;
	private long _userSegmentId;
	private long _points;
	private BaseModel<?> _scorePointRemoteModel;
}