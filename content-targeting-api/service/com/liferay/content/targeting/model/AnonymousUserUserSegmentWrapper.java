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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

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

	/**
	* Returns the primary key of this anonymous user user segment.
	*
	* @return the primary key of this anonymous user user segment
	*/
	@Override
	public long getPrimaryKey() {
		return _anonymousUserUserSegment.getPrimaryKey();
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
	* Sets the anonymous user user segment ID of this anonymous user user segment.
	*
	* @param anonymousUserUserSegmentId the anonymous user user segment ID of this anonymous user user segment
	*/
	@Override
	public void setAnonymousUserUserSegmentId(long anonymousUserUserSegmentId) {
		_anonymousUserUserSegment.setAnonymousUserUserSegmentId(anonymousUserUserSegmentId);
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

	/**
	* Sets the company ID of this anonymous user user segment.
	*
	* @param companyId the company ID of this anonymous user user segment
	*/
	@Override
	public void setCompanyId(long companyId) {
		_anonymousUserUserSegment.setCompanyId(companyId);
	}

	/**
	* Returns the modified date of this anonymous user user segment.
	*
	* @return the modified date of this anonymous user user segment
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _anonymousUserUserSegment.getModifiedDate();
	}

	/**
	* Sets the modified date of this anonymous user user segment.
	*
	* @param modifiedDate the modified date of this anonymous user user segment
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_anonymousUserUserSegment.setModifiedDate(modifiedDate);
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
	* Sets the anonymous user ID of this anonymous user user segment.
	*
	* @param anonymousUserId the anonymous user ID of this anonymous user user segment
	*/
	@Override
	public void setAnonymousUserId(long anonymousUserId) {
		_anonymousUserUserSegment.setAnonymousUserId(anonymousUserId);
	}

	/**
	* Returns the anonymous user uuid of this anonymous user user segment.
	*
	* @return the anonymous user uuid of this anonymous user user segment
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getAnonymousUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _anonymousUserUserSegment.getAnonymousUserUuid();
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

	/**
	* Returns the user segment ID of this anonymous user user segment.
	*
	* @return the user segment ID of this anonymous user user segment
	*/
	@Override
	public long getUserSegmentId() {
		return _anonymousUserUserSegment.getUserSegmentId();
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
	* Returns <code>true</code> if this anonymous user user segment is manual.
	*
	* @return <code>true</code> if this anonymous user user segment is manual; <code>false</code> otherwise
	*/
	@Override
	public boolean isManual() {
		return _anonymousUserUserSegment.isManual();
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
	* Returns the active of this anonymous user user segment.
	*
	* @return the active of this anonymous user user segment
	*/
	@Override
	public boolean getActive() {
		return _anonymousUserUserSegment.getActive();
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

	/**
	* Sets whether this anonymous user user segment is active.
	*
	* @param active the active of this anonymous user user segment
	*/
	@Override
	public void setActive(boolean active) {
		_anonymousUserUserSegment.setActive(active);
	}

	@Override
	public boolean isNew() {
		return _anonymousUserUserSegment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_anonymousUserUserSegment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _anonymousUserUserSegment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_anonymousUserUserSegment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _anonymousUserUserSegment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _anonymousUserUserSegment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_anonymousUserUserSegment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _anonymousUserUserSegment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_anonymousUserUserSegment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_anonymousUserUserSegment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_anonymousUserUserSegment.setExpandoBridgeAttributes(serviceContext);
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

	@Override
	public int hashCode() {
		return _anonymousUserUserSegment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.content.targeting.model.AnonymousUserUserSegment> toCacheModel() {
		return _anonymousUserUserSegment.toCacheModel();
	}

	@Override
	public com.liferay.content.targeting.model.AnonymousUserUserSegment toEscapedModel() {
		return new AnonymousUserUserSegmentWrapper(_anonymousUserUserSegment.toEscapedModel());
	}

	@Override
	public com.liferay.content.targeting.model.AnonymousUserUserSegment toUnescapedModel() {
		return new AnonymousUserUserSegmentWrapper(_anonymousUserUserSegment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _anonymousUserUserSegment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _anonymousUserUserSegment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_anonymousUserUserSegment.persist();
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

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AnonymousUserUserSegment getWrappedAnonymousUserUserSegment() {
		return _anonymousUserUserSegment;
	}

	@Override
	public AnonymousUserUserSegment getWrappedModel() {
		return _anonymousUserUserSegment;
	}

	@Override
	public void resetOriginalValues() {
		_anonymousUserUserSegment.resetOriginalValues();
	}

	private AnonymousUserUserSegment _anonymousUserUserSegment;
}