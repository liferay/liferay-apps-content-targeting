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
 * This class is a wrapper for {@link AnalyticsReferrer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsReferrer
 * @generated
 */
@ProviderType
public class AnalyticsReferrerWrapper implements AnalyticsReferrer,
	ModelWrapper<AnalyticsReferrer> {
	public AnalyticsReferrerWrapper(AnalyticsReferrer analyticsReferrer) {
		_analyticsReferrer = analyticsReferrer;
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
	public java.lang.Object clone() {
		return new AnalyticsReferrerWrapper((AnalyticsReferrer)_analyticsReferrer.clone());
	}

	@Override
	public int compareTo(
		com.liferay.content.targeting.analytics.model.AnalyticsReferrer analyticsReferrer) {
		return _analyticsReferrer.compareTo(analyticsReferrer);
	}

	/**
	* Returns the analytics event ID of this analytics referrer.
	*
	* @return the analytics event ID of this analytics referrer
	*/
	@Override
	public long getAnalyticsEventId() {
		return _analyticsReferrer.getAnalyticsEventId();
	}

	/**
	* Returns the analytics referrer ID of this analytics referrer.
	*
	* @return the analytics referrer ID of this analytics referrer
	*/
	@Override
	public long getAnalyticsReferrerId() {
		return _analyticsReferrer.getAnalyticsReferrerId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _analyticsReferrer.getExpandoBridge();
	}

	/**
	* Returns the primary key of this analytics referrer.
	*
	* @return the primary key of this analytics referrer
	*/
	@Override
	public long getPrimaryKey() {
		return _analyticsReferrer.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _analyticsReferrer.getPrimaryKeyObj();
	}

	/**
	* Returns the referrer class name of this analytics referrer.
	*
	* @return the referrer class name of this analytics referrer
	*/
	@Override
	public java.lang.String getReferrerClassName() {
		return _analyticsReferrer.getReferrerClassName();
	}

	/**
	* Returns the referrer class p k of this analytics referrer.
	*
	* @return the referrer class p k of this analytics referrer
	*/
	@Override
	public long getReferrerClassPK() {
		return _analyticsReferrer.getReferrerClassPK();
	}

	@Override
	public int hashCode() {
		return _analyticsReferrer.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _analyticsReferrer.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _analyticsReferrer.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _analyticsReferrer.isNew();
	}

	@Override
	public void persist() {
		_analyticsReferrer.persist();
	}

	/**
	* Sets the analytics event ID of this analytics referrer.
	*
	* @param analyticsEventId the analytics event ID of this analytics referrer
	*/
	@Override
	public void setAnalyticsEventId(long analyticsEventId) {
		_analyticsReferrer.setAnalyticsEventId(analyticsEventId);
	}

	/**
	* Sets the analytics referrer ID of this analytics referrer.
	*
	* @param analyticsReferrerId the analytics referrer ID of this analytics referrer
	*/
	@Override
	public void setAnalyticsReferrerId(long analyticsReferrerId) {
		_analyticsReferrer.setAnalyticsReferrerId(analyticsReferrerId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_analyticsReferrer.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_analyticsReferrer.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_analyticsReferrer.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_analyticsReferrer.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_analyticsReferrer.setNew(n);
	}

	/**
	* Sets the primary key of this analytics referrer.
	*
	* @param primaryKey the primary key of this analytics referrer
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_analyticsReferrer.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_analyticsReferrer.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the referrer class name of this analytics referrer.
	*
	* @param referrerClassName the referrer class name of this analytics referrer
	*/
	@Override
	public void setReferrerClassName(java.lang.String referrerClassName) {
		_analyticsReferrer.setReferrerClassName(referrerClassName);
	}

	/**
	* Sets the referrer class p k of this analytics referrer.
	*
	* @param referrerClassPK the referrer class p k of this analytics referrer
	*/
	@Override
	public void setReferrerClassPK(long referrerClassPK) {
		_analyticsReferrer.setReferrerClassPK(referrerClassPK);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.liferay.content.targeting.analytics.model.AnalyticsReferrer> toCacheModel() {
		return _analyticsReferrer.toCacheModel();
	}

	@Override
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer toEscapedModel() {
		return new AnalyticsReferrerWrapper(_analyticsReferrer.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _analyticsReferrer.toString();
	}

	@Override
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer toUnescapedModel() {
		return new AnalyticsReferrerWrapper(_analyticsReferrer.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _analyticsReferrer.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnalyticsReferrerWrapper)) {
			return false;
		}

		AnalyticsReferrerWrapper analyticsReferrerWrapper = (AnalyticsReferrerWrapper)obj;

		if (Validator.equals(_analyticsReferrer,
					analyticsReferrerWrapper._analyticsReferrer)) {
			return true;
		}

		return false;
	}

	@Override
	public AnalyticsReferrer getWrappedModel() {
		return _analyticsReferrer;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _analyticsReferrer.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _analyticsReferrer.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_analyticsReferrer.resetOriginalValues();
	}

	private final AnalyticsReferrer _analyticsReferrer;
}