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
 * This class is a wrapper for {@link CTAction}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTAction
 * @generated
 */
@ProviderType
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
		attributes.put("companyId", getCompanyId());
		attributes.put("campaignId", getCampaignId());
		attributes.put("reportInstanceId", getReportInstanceId());
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

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		Long reportInstanceId = (Long)attributes.get("reportInstanceId");

		if (reportInstanceId != null) {
			setReportInstanceId(reportInstanceId);
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
	public java.lang.Object clone() {
		return new CTActionWrapper((CTAction)_ctAction.clone());
	}

	@Override
	public int compareTo(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction ctAction) {
		return _ctAction.compareTo(ctAction);
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
	* Returns the c t action ID of this c t action.
	*
	* @return the c t action ID of this c t action
	*/
	@Override
	public long getCTActionId() {
		return _ctAction.getCTActionId();
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
	* Returns the company ID of this c t action.
	*
	* @return the company ID of this c t action
	*/
	@Override
	public long getCompanyId() {
		return _ctAction.getCompanyId();
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
	* Returns the element ID of this c t action.
	*
	* @return the element ID of this c t action
	*/
	@Override
	public java.lang.String getElementId() {
		return _ctAction.getElementId();
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

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _ctAction.getExpandoBridge();
	}

	/**
	* Returns the modified date of this c t action.
	*
	* @return the modified date of this c t action
	*/
	@Override
	public Date getModifiedDate() {
		return _ctAction.getModifiedDate();
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

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ctAction.getPrimaryKeyObj();
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
	* Returns the referrer class p k of this c t action.
	*
	* @return the referrer class p k of this c t action
	*/
	@Override
	public long getReferrerClassPK() {
		return _ctAction.getReferrerClassPK();
	}

	/**
	* Returns the report instance ID of this c t action.
	*
	* @return the report instance ID of this c t action
	*/
	@Override
	public long getReportInstanceId() {
		return _ctAction.getReportInstanceId();
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

	@Override
	public java.lang.String getUserSegmentName(java.util.Locale locale) {
		return _ctAction.getUserSegmentName(locale);
	}

	@Override
	public int hashCode() {
		return _ctAction.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _ctAction.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _ctAction.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _ctAction.isNew();
	}

	@Override
	public void persist() {
		_ctAction.persist();
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
	* Sets the c t action ID of this c t action.
	*
	* @param CTActionId the c t action ID of this c t action
	*/
	@Override
	public void setCTActionId(long CTActionId) {
		_ctAction.setCTActionId(CTActionId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ctAction.setCachedModel(cachedModel);
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
	* Sets the company ID of this c t action.
	*
	* @param companyId the company ID of this c t action
	*/
	@Override
	public void setCompanyId(long companyId) {
		_ctAction.setCompanyId(companyId);
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
	* Sets the element ID of this c t action.
	*
	* @param elementId the element ID of this c t action
	*/
	@Override
	public void setElementId(java.lang.String elementId) {
		_ctAction.setElementId(elementId);
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

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_ctAction.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_ctAction.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_ctAction.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified date of this c t action.
	*
	* @param modifiedDate the modified date of this c t action
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_ctAction.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_ctAction.setNew(n);
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

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_ctAction.setPrimaryKeyObj(primaryKeyObj);
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
	* Sets the referrer class p k of this c t action.
	*
	* @param referrerClassPK the referrer class p k of this c t action
	*/
	@Override
	public void setReferrerClassPK(long referrerClassPK) {
		_ctAction.setReferrerClassPK(referrerClassPK);
	}

	/**
	* Sets the report instance ID of this c t action.
	*
	* @param reportInstanceId the report instance ID of this c t action
	*/
	@Override
	public void setReportInstanceId(long reportInstanceId) {
		_ctAction.setReportInstanceId(reportInstanceId);
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

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> toCacheModel() {
		return _ctAction.toCacheModel();
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction toEscapedModel() {
		return new CTActionWrapper(_ctAction.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ctAction.toString();
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction toUnescapedModel() {
		return new CTActionWrapper(_ctAction.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _ctAction.toXmlString();
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

	@Override
	public CTAction getWrappedModel() {
		return _ctAction;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _ctAction.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _ctAction.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_ctAction.resetOriginalValues();
	}

	private final CTAction _ctAction;
}