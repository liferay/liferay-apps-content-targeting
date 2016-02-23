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

package com.liferay.content.targeting.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AnonymousUserUserSegment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnonymousUserUserSegment
 * @generated
 */
@ProviderType
public class AnonymousUserUserSegmentWrapper implements AnonymousUserUserSegment,
	ModelWrapper<AnonymousUserUserSegment> {
	public AnonymousUserUserSegmentWrapper(
		AnonymousUserUserSegment anonymousUserUserSegment) {
		_anonymousUserUserSegment = anonymousUserUserSegment;
	}

	@Override
	public Class<?> getModelClass() {
		return AnonymousUserUserSegment.class;
	}

	@Override
	public String getModelClassName() {
		return AnonymousUserUserSegment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("anonymousUserUserSegmentId",
			getAnonymousUserUserSegmentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("anonymousUserId", getAnonymousUserId());
		attributes.put("userSegmentId", getUserSegmentId());
		attributes.put("manual", getManual());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long anonymousUserUserSegmentId = (Long)attributes.get(
				"anonymousUserUserSegmentId");

		if (anonymousUserUserSegmentId != null) {
			setAnonymousUserUserSegmentId(anonymousUserUserSegmentId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long anonymousUserId = (Long)attributes.get("anonymousUserId");

		if (anonymousUserId != null) {
			setAnonymousUserId(anonymousUserId);
		}

		Long userSegmentId = (Long)attributes.get("userSegmentId");

		if (userSegmentId != null) {
			setUserSegmentId(userSegmentId);
		}

		Boolean manual = (Boolean)attributes.get("manual");

		if (manual != null) {
			setManual(manual);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new AnonymousUserUserSegmentWrapper((AnonymousUserUserSegment)_anonymousUserUserSegment.clone());
	}

	@Override
	public int compareTo(
		com.liferay.content.targeting.model.AnonymousUserUserSegment anonymousUserUserSegment) {
		return _anonymousUserUserSegment.compareTo(anonymousUserUserSegment);
	}

	/**
	* Returns the active of this anonymous user user segment.
	*
	* @return the active of this anonymous user user segment
	*/
	@Override
	public boolean getActive() {
		return _anonymousUserUserSegment.getActive();
	}

	/**
	* Returns the anonymous user ID of this anonymous user user segment.
	*
	* @return the anonymous user ID of this anonymous user user segment
	*/
	@Override
	public long getAnonymousUserId() {
		return _anonymousUserUserSegment.getAnonymousUserId();
	}

	/**
	* Returns the anonymous user user segment ID of this anonymous user user segment.
	*
	* @return the anonymous user user segment ID of this anonymous user user segment
	*/
	@Override
	public long getAnonymousUserUserSegmentId() {
		return _anonymousUserUserSegment.getAnonymousUserUserSegmentId();
	}

	/**
	* Returns the anonymous user uuid of this anonymous user user segment.
	*
	* @return the anonymous user uuid of this anonymous user user segment
	*/
	@Override
	public java.lang.String getAnonymousUserUuid() {
		return _anonymousUserUserSegment.getAnonymousUserUuid();
	}

	/**
	* Returns the company ID of this anonymous user user segment.
	*
	* @return the company ID of this anonymous user user segment
	*/
	@Override
	public long getCompanyId() {
		return _anonymousUserUserSegment.getCompanyId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _anonymousUserUserSegment.getExpandoBridge();
	}

	/**
	* Returns the manual of this anonymous user user segment.
	*
	* @return the manual of this anonymous user user segment
	*/
	@Override
	public boolean getManual() {
		return _anonymousUserUserSegment.getManual();
	}

	/**
	* Returns the modified date of this anonymous user user segment.
	*
	* @return the modified date of this anonymous user user segment
	*/
	@Override
	public Date getModifiedDate() {
		return _anonymousUserUserSegment.getModifiedDate();
	}

	/**
	* Returns the primary key of this anonymous user user segment.
	*
	* @return the primary key of this anonymous user user segment
	*/
	@Override
	public long getPrimaryKey() {
		return _anonymousUserUserSegment.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _anonymousUserUserSegment.getPrimaryKeyObj();
	}

	/**
	* Returns the user segment ID of this anonymous user user segment.
	*
	* @return the user segment ID of this anonymous user user segment
	*/
	@Override
	public long getUserSegmentId() {
		return _anonymousUserUserSegment.getUserSegmentId();
	}

	@Override
	public int hashCode() {
		return _anonymousUserUserSegment.hashCode();
	}

	/**
	* Returns <code>true</code> if this anonymous user user segment is active.
	*
	* @return <code>true</code> if this anonymous user user segment is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _anonymousUserUserSegment.isActive();
	}

	@Override
	public boolean isCachedModel() {
		return _anonymousUserUserSegment.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _anonymousUserUserSegment.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this anonymous user user segment is manual.
	*
	* @return <code>true</code> if this anonymous user user segment is manual; <code>false</code> otherwise
	*/
	@Override
	public boolean isManual() {
		return _anonymousUserUserSegment.isManual();
	}

	@Override
	public boolean isNew() {
		return _anonymousUserUserSegment.isNew();
	}

	@Override
	public void persist() {
		_anonymousUserUserSegment.persist();
	}

	/**
	* Sets whether this anonymous user user segment is active.
	*
	* @param active the active of this anonymous user user segment
	*/
	@Override
	public void setActive(boolean active) {
		_anonymousUserUserSegment.setActive(active);
	}

	/**
	* Sets the anonymous user ID of this anonymous user user segment.
	*
	* @param anonymousUserId the anonymous user ID of this anonymous user user segment
	*/
	@Override
	public void setAnonymousUserId(long anonymousUserId) {
		_anonymousUserUserSegment.setAnonymousUserId(anonymousUserId);
	}

	/**
	* Sets the anonymous user user segment ID of this anonymous user user segment.
	*
	* @param anonymousUserUserSegmentId the anonymous user user segment ID of this anonymous user user segment
	*/
	@Override
	public void setAnonymousUserUserSegmentId(long anonymousUserUserSegmentId) {
		_anonymousUserUserSegment.setAnonymousUserUserSegmentId(anonymousUserUserSegmentId);
	}

	/**
	* Sets the anonymous user uuid of this anonymous user user segment.
	*
	* @param anonymousUserUuid the anonymous user uuid of this anonymous user user segment
	*/
	@Override
	public void setAnonymousUserUuid(java.lang.String anonymousUserUuid) {
		_anonymousUserUserSegment.setAnonymousUserUuid(anonymousUserUuid);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_anonymousUserUserSegment.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this anonymous user user segment.
	*
	* @param companyId the company ID of this anonymous user user segment
	*/
	@Override
	public void setCompanyId(long companyId) {
		_anonymousUserUserSegment.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_anonymousUserUserSegment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_anonymousUserUserSegment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_anonymousUserUserSegment.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets whether this anonymous user user segment is manual.
	*
	* @param manual the manual of this anonymous user user segment
	*/
	@Override
	public void setManual(boolean manual) {
		_anonymousUserUserSegment.setManual(manual);
	}

	/**
	* Sets the modified date of this anonymous user user segment.
	*
	* @param modifiedDate the modified date of this anonymous user user segment
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_anonymousUserUserSegment.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_anonymousUserUserSegment.setNew(n);
	}

	/**
	* Sets the primary key of this anonymous user user segment.
	*
	* @param primaryKey the primary key of this anonymous user user segment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_anonymousUserUserSegment.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_anonymousUserUserSegment.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user segment ID of this anonymous user user segment.
	*
	* @param userSegmentId the user segment ID of this anonymous user user segment
	*/
	@Override
	public void setUserSegmentId(long userSegmentId) {
		_anonymousUserUserSegment.setUserSegmentId(userSegmentId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.liferay.content.targeting.model.AnonymousUserUserSegment> toCacheModel() {
		return _anonymousUserUserSegment.toCacheModel();
	}

	@Override
	public com.liferay.content.targeting.model.AnonymousUserUserSegment toEscapedModel() {
		return new AnonymousUserUserSegmentWrapper(_anonymousUserUserSegment.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _anonymousUserUserSegment.toString();
	}

	@Override
	public com.liferay.content.targeting.model.AnonymousUserUserSegment toUnescapedModel() {
		return new AnonymousUserUserSegmentWrapper(_anonymousUserUserSegment.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _anonymousUserUserSegment.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnonymousUserUserSegmentWrapper)) {
			return false;
		}

		AnonymousUserUserSegmentWrapper anonymousUserUserSegmentWrapper = (AnonymousUserUserSegmentWrapper)obj;

		if (Validator.equals(_anonymousUserUserSegment,
					anonymousUserUserSegmentWrapper._anonymousUserUserSegment)) {
			return true;
		}

		return false;
	}

	@Override
	public AnonymousUserUserSegment getWrappedModel() {
		return _anonymousUserUserSegment;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _anonymousUserUserSegment.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _anonymousUserUserSegment.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_anonymousUserUserSegment.resetOriginalValues();
	}

	private final AnonymousUserUserSegment _anonymousUserUserSegment;
}