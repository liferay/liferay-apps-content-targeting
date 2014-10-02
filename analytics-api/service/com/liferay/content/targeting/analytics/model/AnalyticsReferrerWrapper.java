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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

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

	/**
	* Returns the primary key of this analytics referrer.
	*
	* @return the primary key of this analytics referrer
	*/
	@Override
	public long getPrimaryKey() {
		return _analyticsReferrer.getPrimaryKey();
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

	/**
	* Returns the analytics referrer ID of this analytics referrer.
	*
	* @return the analytics referrer ID of this analytics referrer
	*/
	@Override
	public long getAnalyticsReferrerId() {
		return _analyticsReferrer.getAnalyticsReferrerId();
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
	* Sets the analytics event ID of this analytics referrer.
	*
	* @param analyticsEventId the analytics event ID of this analytics referrer
	*/
	@Override
	public void setAnalyticsEventId(long analyticsEventId) {
		_analyticsReferrer.setAnalyticsEventId(analyticsEventId);
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
	* Sets the referrer class name of this analytics referrer.
	*
	* @param referrerClassName the referrer class name of this analytics referrer
	*/
	@Override
	public void setReferrerClassName(java.lang.String referrerClassName) {
		_analyticsReferrer.setReferrerClassName(referrerClassName);
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
	public boolean isNew() {
		return _analyticsReferrer.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_analyticsReferrer.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _analyticsReferrer.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_analyticsReferrer.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _analyticsReferrer.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _analyticsReferrer.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_analyticsReferrer.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _analyticsReferrer.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_analyticsReferrer.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_analyticsReferrer.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_analyticsReferrer.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AnalyticsReferrerWrapper((AnalyticsReferrer)_analyticsReferrer.clone());
	}

	@Override
	public int compareTo(AnalyticsReferrer analyticsReferrer) {
		return _analyticsReferrer.compareTo(analyticsReferrer);
	}

	@Override
	public int hashCode() {
		return _analyticsReferrer.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<AnalyticsReferrer> toCacheModel() {
		return _analyticsReferrer.toCacheModel();
	}

	@Override
	public AnalyticsReferrer toEscapedModel() {
		return new AnalyticsReferrerWrapper(_analyticsReferrer.toEscapedModel());
	}

	@Override
	public AnalyticsReferrer toUnescapedModel() {
		return new AnalyticsReferrerWrapper(_analyticsReferrer.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _analyticsReferrer.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _analyticsReferrer.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_analyticsReferrer.persist();
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

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AnalyticsReferrer getWrappedAnalyticsReferrer() {
		return _analyticsReferrer;
	}

	@Override
	public AnalyticsReferrer getWrappedModel() {
		return _analyticsReferrer;
	}

	@Override
	public void resetOriginalValues() {
		_analyticsReferrer.resetOriginalValues();
	}

	private AnalyticsReferrer _analyticsReferrer;
}