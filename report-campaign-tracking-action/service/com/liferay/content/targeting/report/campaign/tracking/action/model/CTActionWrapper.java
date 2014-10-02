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

package com.liferay.content.targeting.report.campaign.tracking.action.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CTAction}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTAction
 * @generated
 */
public class CTActionWrapper implements CTAction, ModelWrapper<CTAction> {
	public CTActionWrapper(CTAction ctAction) {
		_ctAction = ctAction;
	}

	@Override
	public Class<?> getModelClass() {
		return CTAction.class;
	}

	@Override
	public String getModelClassName() {
		return CTAction.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("CTActionId", getCTActionId());
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
		Long CTActionId = (Long)attributes.get("CTActionId");

		if (CTActionId != null) {
			setCTActionId(CTActionId);
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

	/**
	* Returns the primary key of this c t action.
	*
	* @return the primary key of this c t action
	*/
	@Override
	public long getPrimaryKey() {
		return _ctAction.getPrimaryKey();
	}

	/**
	* Sets the primary key of this c t action.
	*
	* @param primaryKey the primary key of this c t action
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ctAction.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the c t action ID of this c t action.
	*
	* @return the c t action ID of this c t action
	*/
	@Override
	public long getCTActionId() {
		return _ctAction.getCTActionId();
	}

	/**
	* Sets the c t action ID of this c t action.
	*
	* @param CTActionId the c t action ID of this c t action
	*/
	@Override
	public void setCTActionId(long CTActionId) {
		_ctAction.setCTActionId(CTActionId);
	}

	/**
	* Returns the campaign ID of this c t action.
	*
	* @return the campaign ID of this c t action
	*/
	@Override
	public long getCampaignId() {
		return _ctAction.getCampaignId();
	}

	/**
	* Sets the campaign ID of this c t action.
	*
	* @param campaignId the campaign ID of this c t action
	*/
	@Override
	public void setCampaignId(long campaignId) {
		_ctAction.setCampaignId(campaignId);
	}

	/**
	* Returns the user segment ID of this c t action.
	*
	* @return the user segment ID of this c t action
	*/
	@Override
	public long getUserSegmentId() {
		return _ctAction.getUserSegmentId();
	}

	/**
	* Sets the user segment ID of this c t action.
	*
	* @param userSegmentId the user segment ID of this c t action
	*/
	@Override
	public void setUserSegmentId(long userSegmentId) {
		_ctAction.setUserSegmentId(userSegmentId);
	}

	/**
	* Returns the alias of this c t action.
	*
	* @return the alias of this c t action
	*/
	@Override
	public java.lang.String getAlias() {
		return _ctAction.getAlias();
	}

	/**
	* Sets the alias of this c t action.
	*
	* @param alias the alias of this c t action
	*/
	@Override
	public void setAlias(java.lang.String alias) {
		_ctAction.setAlias(alias);
	}

	/**
	* Returns the referrer class name of this c t action.
	*
	* @return the referrer class name of this c t action
	*/
	@Override
	public java.lang.String getReferrerClassName() {
		return _ctAction.getReferrerClassName();
	}

	/**
	* Sets the referrer class name of this c t action.
	*
	* @param referrerClassName the referrer class name of this c t action
	*/
	@Override
	public void setReferrerClassName(java.lang.String referrerClassName) {
		_ctAction.setReferrerClassName(referrerClassName);
	}

	/**
	* Returns the referrer class p k of this c t action.
	*
	* @return the referrer class p k of this c t action
	*/
	@Override
	public long getReferrerClassPK() {
		return _ctAction.getReferrerClassPK();
	}

	/**
	* Sets the referrer class p k of this c t action.
	*
	* @param referrerClassPK the referrer class p k of this c t action
	*/
	@Override
	public void setReferrerClassPK(long referrerClassPK) {
		_ctAction.setReferrerClassPK(referrerClassPK);
	}

	/**
	* Returns the element ID of this c t action.
	*
	* @return the element ID of this c t action
	*/
	@Override
	public java.lang.String getElementId() {
		return _ctAction.getElementId();
	}

	/**
	* Sets the element ID of this c t action.
	*
	* @param elementId the element ID of this c t action
	*/
	@Override
	public void setElementId(java.lang.String elementId) {
		_ctAction.setElementId(elementId);
	}

	/**
	* Returns the event type of this c t action.
	*
	* @return the event type of this c t action
	*/
	@Override
	public java.lang.String getEventType() {
		return _ctAction.getEventType();
	}

	/**
	* Sets the event type of this c t action.
	*
	* @param eventType the event type of this c t action
	*/
	@Override
	public void setEventType(java.lang.String eventType) {
		_ctAction.setEventType(eventType);
	}

	/**
	* Returns the count of this c t action.
	*
	* @return the count of this c t action
	*/
	@Override
	public int getCount() {
		return _ctAction.getCount();
	}

	/**
	* Sets the count of this c t action.
	*
	* @param count the count of this c t action
	*/
	@Override
	public void setCount(int count) {
		_ctAction.setCount(count);
	}

	/**
	* Returns the modified date of this c t action.
	*
	* @return the modified date of this c t action
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _ctAction.getModifiedDate();
	}

	/**
	* Sets the modified date of this c t action.
	*
	* @param modifiedDate the modified date of this c t action
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_ctAction.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _ctAction.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_ctAction.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _ctAction.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ctAction.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _ctAction.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _ctAction.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ctAction.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ctAction.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_ctAction.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_ctAction.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ctAction.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CTActionWrapper((CTAction)_ctAction.clone());
	}

	@Override
	public int compareTo(CTAction ctAction) {
		return _ctAction.compareTo(ctAction);
	}

	@Override
	public int hashCode() {
		return _ctAction.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<CTAction> toCacheModel() {
		return _ctAction.toCacheModel();
	}

	@Override
	public CTAction toEscapedModel() {
		return new CTActionWrapper(_ctAction.toEscapedModel());
	}

	@Override
	public CTAction toUnescapedModel() {
		return new CTActionWrapper(_ctAction.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ctAction.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ctAction.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ctAction.persist();
	}

	@Override
	public java.lang.String getUserSegmentName(java.util.Locale locale) {
		return _ctAction.getUserSegmentName(locale);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CTActionWrapper)) {
			return false;
		}

		CTActionWrapper ctActionWrapper = (CTActionWrapper)obj;

		if (Validator.equals(_ctAction, ctActionWrapper._ctAction)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CTAction getWrappedCTAction() {
		return _ctAction;
	}

	@Override
	public CTAction getWrappedModel() {
		return _ctAction;
	}

	@Override
	public void resetOriginalValues() {
		_ctAction.resetOriginalValues();
	}

	private CTAction _ctAction;
}