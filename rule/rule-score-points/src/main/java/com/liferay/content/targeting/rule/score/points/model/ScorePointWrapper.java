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

package com.liferay.content.targeting.rule.score.points.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ScorePoint}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ScorePoint
 * @generated
 */
@ProviderType
public class ScorePointWrapper implements ScorePoint, ModelWrapper<ScorePoint> {
	public ScorePointWrapper(ScorePoint scorePoint) {
		_scorePoint = scorePoint;
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("scorePointId", getScorePointId());
		attributes.put("companyId", getCompanyId());
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

		Long scorePointId = (Long)attributes.get("scorePointId");

		if (scorePointId != null) {
			setScorePointId(scorePointId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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
	public java.lang.Object clone() {
		return new ScorePointWrapper((ScorePoint)_scorePoint.clone());
	}

	@Override
	public int compareTo(
		com.liferay.content.targeting.rule.score.points.model.ScorePoint scorePoint) {
		return _scorePoint.compareTo(scorePoint);
	}

	/**
	* Returns the anonymous user ID of this score point.
	*
	* @return the anonymous user ID of this score point
	*/
	@Override
	public long getAnonymousUserId() {
		return _scorePoint.getAnonymousUserId();
	}

	/**
	* Returns the anonymous user uuid of this score point.
	*
	* @return the anonymous user uuid of this score point
	*/
	@Override
	public java.lang.String getAnonymousUserUuid() {
		return _scorePoint.getAnonymousUserUuid();
	}

	/**
	* Returns the company ID of this score point.
	*
	* @return the company ID of this score point
	*/
	@Override
	public long getCompanyId() {
		return _scorePoint.getCompanyId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _scorePoint.getExpandoBridge();
	}

	/**
	* Returns the points of this score point.
	*
	* @return the points of this score point
	*/
	@Override
	public long getPoints() {
		return _scorePoint.getPoints();
	}

	/**
	* Returns the primary key of this score point.
	*
	* @return the primary key of this score point
	*/
	@Override
	public long getPrimaryKey() {
		return _scorePoint.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _scorePoint.getPrimaryKeyObj();
	}

	/**
	* Returns the score point ID of this score point.
	*
	* @return the score point ID of this score point
	*/
	@Override
	public long getScorePointId() {
		return _scorePoint.getScorePointId();
	}

	/**
	* Returns the user segment ID of this score point.
	*
	* @return the user segment ID of this score point
	*/
	@Override
	public long getUserSegmentId() {
		return _scorePoint.getUserSegmentId();
	}

	/**
	* Returns the uuid of this score point.
	*
	* @return the uuid of this score point
	*/
	@Override
	public java.lang.String getUuid() {
		return _scorePoint.getUuid();
	}

	@Override
	public int hashCode() {
		return _scorePoint.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _scorePoint.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _scorePoint.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _scorePoint.isNew();
	}

	@Override
	public void persist() {
		_scorePoint.persist();
	}

	/**
	* Sets the anonymous user ID of this score point.
	*
	* @param anonymousUserId the anonymous user ID of this score point
	*/
	@Override
	public void setAnonymousUserId(long anonymousUserId) {
		_scorePoint.setAnonymousUserId(anonymousUserId);
	}

	/**
	* Sets the anonymous user uuid of this score point.
	*
	* @param anonymousUserUuid the anonymous user uuid of this score point
	*/
	@Override
	public void setAnonymousUserUuid(java.lang.String anonymousUserUuid) {
		_scorePoint.setAnonymousUserUuid(anonymousUserUuid);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_scorePoint.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this score point.
	*
	* @param companyId the company ID of this score point
	*/
	@Override
	public void setCompanyId(long companyId) {
		_scorePoint.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_scorePoint.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_scorePoint.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_scorePoint.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_scorePoint.setNew(n);
	}

	/**
	* Sets the points of this score point.
	*
	* @param points the points of this score point
	*/
	@Override
	public void setPoints(long points) {
		_scorePoint.setPoints(points);
	}

	/**
	* Sets the primary key of this score point.
	*
	* @param primaryKey the primary key of this score point
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_scorePoint.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_scorePoint.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the score point ID of this score point.
	*
	* @param scorePointId the score point ID of this score point
	*/
	@Override
	public void setScorePointId(long scorePointId) {
		_scorePoint.setScorePointId(scorePointId);
	}

	/**
	* Sets the user segment ID of this score point.
	*
	* @param userSegmentId the user segment ID of this score point
	*/
	@Override
	public void setUserSegmentId(long userSegmentId) {
		_scorePoint.setUserSegmentId(userSegmentId);
	}

	/**
	* Sets the uuid of this score point.
	*
	* @param uuid the uuid of this score point
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_scorePoint.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.liferay.content.targeting.rule.score.points.model.ScorePoint> toCacheModel() {
		return _scorePoint.toCacheModel();
	}

	@Override
	public com.liferay.content.targeting.rule.score.points.model.ScorePoint toEscapedModel() {
		return new ScorePointWrapper(_scorePoint.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _scorePoint.toString();
	}

	@Override
	public com.liferay.content.targeting.rule.score.points.model.ScorePoint toUnescapedModel() {
		return new ScorePointWrapper(_scorePoint.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _scorePoint.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScorePointWrapper)) {
			return false;
		}

		ScorePointWrapper scorePointWrapper = (ScorePointWrapper)obj;

		if (Validator.equals(_scorePoint, scorePointWrapper._scorePoint)) {
			return true;
		}

		return false;
	}

	@Override
	public ScorePoint getWrappedModel() {
		return _scorePoint;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _scorePoint.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _scorePoint.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_scorePoint.resetOriginalValues();
	}

	private final ScorePoint _scorePoint;
}