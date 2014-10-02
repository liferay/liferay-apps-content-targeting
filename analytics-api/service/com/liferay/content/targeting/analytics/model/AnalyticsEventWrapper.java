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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AnalyticsEvent}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsEvent
 * @generated
 */
public class AnalyticsEventWrapper implements AnalyticsEvent,
	ModelWrapper<AnalyticsEvent> {
	public AnalyticsEventWrapper(AnalyticsEvent analyticsEvent) {
		_analyticsEvent = analyticsEvent;
	}

	@Override
	public Class<?> getModelClass() {
		return AnalyticsEvent.class;
	}

	@Override
	public String getModelClassName() {
		return AnalyticsEvent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("analyticsEventId", getAnalyticsEventId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("anonymousUserId", getAnonymousUserId());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("elementId", getElementId());
		attributes.put("eventType", getEventType());
		attributes.put("clientIP", getClientIP());
		attributes.put("userAgent", getUserAgent());
		attributes.put("languageId", getLanguageId());
		attributes.put("URL", getURL());
		attributes.put("additionalInfo", getAdditionalInfo());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long analyticsEventId = (Long)attributes.get("analyticsEventId");

		if (analyticsEventId != null) {
			setAnalyticsEventId(analyticsEventId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long anonymousUserId = (Long)attributes.get("anonymousUserId");

		if (anonymousUserId != null) {
			setAnonymousUserId(anonymousUserId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String elementId = (String)attributes.get("elementId");

		if (elementId != null) {
			setElementId(elementId);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}

		String clientIP = (String)attributes.get("clientIP");

		if (clientIP != null) {
			setClientIP(clientIP);
		}

		String userAgent = (String)attributes.get("userAgent");

		if (userAgent != null) {
			setUserAgent(userAgent);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		String URL = (String)attributes.get("URL");

		if (URL != null) {
			setURL(URL);
		}

		String additionalInfo = (String)attributes.get("additionalInfo");

		if (additionalInfo != null) {
			setAdditionalInfo(additionalInfo);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	/**
	* Returns the primary key of this analytics event.
	*
	* @return the primary key of this analytics event
	*/
	@Override
	public long getPrimaryKey() {
		return _analyticsEvent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this analytics event.
	*
	* @param primaryKey the primary key of this analytics event
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_analyticsEvent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the analytics event ID of this analytics event.
	*
	* @return the analytics event ID of this analytics event
	*/
	@Override
	public long getAnalyticsEventId() {
		return _analyticsEvent.getAnalyticsEventId();
	}

	/**
	* Sets the analytics event ID of this analytics event.
	*
	* @param analyticsEventId the analytics event ID of this analytics event
	*/
	@Override
	public void setAnalyticsEventId(long analyticsEventId) {
		_analyticsEvent.setAnalyticsEventId(analyticsEventId);
	}

	/**
	* Returns the company ID of this analytics event.
	*
	* @return the company ID of this analytics event
	*/
	@Override
	public long getCompanyId() {
		return _analyticsEvent.getCompanyId();
	}

	/**
	* Sets the company ID of this analytics event.
	*
	* @param companyId the company ID of this analytics event
	*/
	@Override
	public void setCompanyId(long companyId) {
		_analyticsEvent.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this analytics event.
	*
	* @return the user ID of this analytics event
	*/
	@Override
	public long getUserId() {
		return _analyticsEvent.getUserId();
	}

	/**
	* Sets the user ID of this analytics event.
	*
	* @param userId the user ID of this analytics event
	*/
	@Override
	public void setUserId(long userId) {
		_analyticsEvent.setUserId(userId);
	}

	/**
	* Returns the user uuid of this analytics event.
	*
	* @return the user uuid of this analytics event
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEvent.getUserUuid();
	}

	/**
	* Sets the user uuid of this analytics event.
	*
	* @param userUuid the user uuid of this analytics event
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_analyticsEvent.setUserUuid(userUuid);
	}

	/**
	* Returns the anonymous user ID of this analytics event.
	*
	* @return the anonymous user ID of this analytics event
	*/
	@Override
	public long getAnonymousUserId() {
		return _analyticsEvent.getAnonymousUserId();
	}

	/**
	* Sets the anonymous user ID of this analytics event.
	*
	* @param anonymousUserId the anonymous user ID of this analytics event
	*/
	@Override
	public void setAnonymousUserId(long anonymousUserId) {
		_analyticsEvent.setAnonymousUserId(anonymousUserId);
	}

	/**
	* Returns the anonymous user uuid of this analytics event.
	*
	* @return the anonymous user uuid of this analytics event
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getAnonymousUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEvent.getAnonymousUserUuid();
	}

	/**
	* Sets the anonymous user uuid of this analytics event.
	*
	* @param anonymousUserUuid the anonymous user uuid of this analytics event
	*/
	@Override
	public void setAnonymousUserUuid(java.lang.String anonymousUserUuid) {
		_analyticsEvent.setAnonymousUserUuid(anonymousUserUuid);
	}

	/**
	* Returns the class name of this analytics event.
	*
	* @return the class name of this analytics event
	*/
	@Override
	public java.lang.String getClassName() {
		return _analyticsEvent.getClassName();
	}

	/**
	* Sets the class name of this analytics event.
	*
	* @param className the class name of this analytics event
	*/
	@Override
	public void setClassName(java.lang.String className) {
		_analyticsEvent.setClassName(className);
	}

	/**
	* Returns the class p k of this analytics event.
	*
	* @return the class p k of this analytics event
	*/
	@Override
	public long getClassPK() {
		return _analyticsEvent.getClassPK();
	}

	/**
	* Sets the class p k of this analytics event.
	*
	* @param classPK the class p k of this analytics event
	*/
	@Override
	public void setClassPK(long classPK) {
		_analyticsEvent.setClassPK(classPK);
	}

	/**
	* Returns the element ID of this analytics event.
	*
	* @return the element ID of this analytics event
	*/
	@Override
	public java.lang.String getElementId() {
		return _analyticsEvent.getElementId();
	}

	/**
	* Sets the element ID of this analytics event.
	*
	* @param elementId the element ID of this analytics event
	*/
	@Override
	public void setElementId(java.lang.String elementId) {
		_analyticsEvent.setElementId(elementId);
	}

	/**
	* Returns the event type of this analytics event.
	*
	* @return the event type of this analytics event
	*/
	@Override
	public java.lang.String getEventType() {
		return _analyticsEvent.getEventType();
	}

	/**
	* Sets the event type of this analytics event.
	*
	* @param eventType the event type of this analytics event
	*/
	@Override
	public void setEventType(java.lang.String eventType) {
		_analyticsEvent.setEventType(eventType);
	}

	/**
	* Returns the client i p of this analytics event.
	*
	* @return the client i p of this analytics event
	*/
	@Override
	public java.lang.String getClientIP() {
		return _analyticsEvent.getClientIP();
	}

	/**
	* Sets the client i p of this analytics event.
	*
	* @param clientIP the client i p of this analytics event
	*/
	@Override
	public void setClientIP(java.lang.String clientIP) {
		_analyticsEvent.setClientIP(clientIP);
	}

	/**
	* Returns the user agent of this analytics event.
	*
	* @return the user agent of this analytics event
	*/
	@Override
	public java.lang.String getUserAgent() {
		return _analyticsEvent.getUserAgent();
	}

	/**
	* Sets the user agent of this analytics event.
	*
	* @param userAgent the user agent of this analytics event
	*/
	@Override
	public void setUserAgent(java.lang.String userAgent) {
		_analyticsEvent.setUserAgent(userAgent);
	}

	/**
	* Returns the language ID of this analytics event.
	*
	* @return the language ID of this analytics event
	*/
	@Override
	public java.lang.String getLanguageId() {
		return _analyticsEvent.getLanguageId();
	}

	/**
	* Sets the language ID of this analytics event.
	*
	* @param languageId the language ID of this analytics event
	*/
	@Override
	public void setLanguageId(java.lang.String languageId) {
		_analyticsEvent.setLanguageId(languageId);
	}

	/**
	* Returns the u r l of this analytics event.
	*
	* @return the u r l of this analytics event
	*/
	@Override
	public java.lang.String getURL() {
		return _analyticsEvent.getURL();
	}

	/**
	* Sets the u r l of this analytics event.
	*
	* @param URL the u r l of this analytics event
	*/
	@Override
	public void setURL(java.lang.String URL) {
		_analyticsEvent.setURL(URL);
	}

	/**
	* Returns the additional info of this analytics event.
	*
	* @return the additional info of this analytics event
	*/
	@Override
	public java.lang.String getAdditionalInfo() {
		return _analyticsEvent.getAdditionalInfo();
	}

	/**
	* Sets the additional info of this analytics event.
	*
	* @param additionalInfo the additional info of this analytics event
	*/
	@Override
	public void setAdditionalInfo(java.lang.String additionalInfo) {
		_analyticsEvent.setAdditionalInfo(additionalInfo);
	}

	/**
	* Returns the create date of this analytics event.
	*
	* @return the create date of this analytics event
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _analyticsEvent.getCreateDate();
	}

	/**
	* Sets the create date of this analytics event.
	*
	* @param createDate the create date of this analytics event
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_analyticsEvent.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _analyticsEvent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_analyticsEvent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _analyticsEvent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_analyticsEvent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _analyticsEvent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _analyticsEvent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_analyticsEvent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _analyticsEvent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_analyticsEvent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_analyticsEvent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_analyticsEvent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AnalyticsEventWrapper((AnalyticsEvent)_analyticsEvent.clone());
	}

	@Override
	public int compareTo(AnalyticsEvent analyticsEvent) {
		return _analyticsEvent.compareTo(analyticsEvent);
	}

	@Override
	public int hashCode() {
		return _analyticsEvent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<AnalyticsEvent> toCacheModel() {
		return _analyticsEvent.toCacheModel();
	}

	@Override
	public AnalyticsEvent toEscapedModel() {
		return new AnalyticsEventWrapper(_analyticsEvent.toEscapedModel());
	}

	@Override
	public AnalyticsEvent toUnescapedModel() {
		return new AnalyticsEventWrapper(_analyticsEvent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _analyticsEvent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _analyticsEvent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_analyticsEvent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnalyticsEventWrapper)) {
			return false;
		}

		AnalyticsEventWrapper analyticsEventWrapper = (AnalyticsEventWrapper)obj;

		if (Validator.equals(_analyticsEvent,
					analyticsEventWrapper._analyticsEvent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AnalyticsEvent getWrappedAnalyticsEvent() {
		return _analyticsEvent;
	}

	@Override
	public AnalyticsEvent getWrappedModel() {
		return _analyticsEvent;
	}

	@Override
	public void resetOriginalValues() {
		_analyticsEvent.resetOriginalValues();
	}

	private AnalyticsEvent _analyticsEvent;
}