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
 * This class is a wrapper for {@link CTActionTotal}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTActionTotal
 * @generated
 */
@ProviderType
public class CTActionTotalWrapper implements CTActionTotal,
	ModelWrapper<CTActionTotal> {
	public CTActionTotalWrapper(CTActionTotal ctActionTotal) {
		_ctActionTotal = ctActionTotal;
	}

	@Override
	public Class<?> getModelClass() {
		return CTActionTotal.class;
	}

	@Override
	public String getModelClassName() {
		return CTActionTotal.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("CTActionTotalId", getCTActionTotalId());
		attributes.put("companyId", getCompanyId());
		attributes.put("campaignId", getCampaignId());
		attributes.put("reportInstanceId", getReportInstanceId());
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
		Long CTActionTotalId = (Long)attributes.get("CTActionTotalId");

		if (CTActionTotalId != null) {
			setCTActionTotalId(CTActionTotalId);
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
		return new CTActionTotalWrapper((CTActionTotal)_ctActionTotal.clone());
	}

	@Override
	public int compareTo(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal ctActionTotal) {
		return _ctActionTotal.compareTo(ctActionTotal);
	}

	/**
	* Returns the alias of this c t action total.
	*
	* @return the alias of this c t action total
	*/
	@Override
	public java.lang.String getAlias() {
		return _ctActionTotal.getAlias();
	}

	/**
	* Returns the c t action total ID of this c t action total.
	*
	* @return the c t action total ID of this c t action total
	*/
	@Override
	public long getCTActionTotalId() {
		return _ctActionTotal.getCTActionTotalId();
	}

	/**
	* Returns the campaign ID of this c t action total.
	*
	* @return the campaign ID of this c t action total
	*/
	@Override
	public long getCampaignId() {
		return _ctActionTotal.getCampaignId();
	}

	/**
	* Returns the company ID of this c t action total.
	*
	* @return the company ID of this c t action total
	*/
	@Override
	public long getCompanyId() {
		return _ctActionTotal.getCompanyId();
	}

	/**
	* Returns the count of this c t action total.
	*
	* @return the count of this c t action total
	*/
	@Override
	public int getCount() {
		return _ctActionTotal.getCount();
	}

	/**
	* Returns the element ID of this c t action total.
	*
	* @return the element ID of this c t action total
	*/
	@Override
	public java.lang.String getElementId() {
		return _ctActionTotal.getElementId();
	}

	/**
	* Returns the event type of this c t action total.
	*
	* @return the event type of this c t action total
	*/
	@Override
	public java.lang.String getEventType() {
		return _ctActionTotal.getEventType();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _ctActionTotal.getExpandoBridge();
	}

	/**
	* Returns the modified date of this c t action total.
	*
	* @return the modified date of this c t action total
	*/
	@Override
	public Date getModifiedDate() {
		return _ctActionTotal.getModifiedDate();
	}

	/**
	* Returns the primary key of this c t action total.
	*
	* @return the primary key of this c t action total
	*/
	@Override
	public long getPrimaryKey() {
		return _ctActionTotal.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ctActionTotal.getPrimaryKeyObj();
	}

	/**
	* Returns the referrer class name of this c t action total.
	*
	* @return the referrer class name of this c t action total
	*/
	@Override
	public java.lang.String getReferrerClassName() {
		return _ctActionTotal.getReferrerClassName();
	}

	/**
	* Returns the referrer class p k of this c t action total.
	*
	* @return the referrer class p k of this c t action total
	*/
	@Override
	public long getReferrerClassPK() {
		return _ctActionTotal.getReferrerClassPK();
	}

	/**
	* Returns the report instance ID of this c t action total.
	*
	* @return the report instance ID of this c t action total
	*/
	@Override
	public long getReportInstanceId() {
		return _ctActionTotal.getReportInstanceId();
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getViewsByUserSegment()
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ctActionTotal.getViewsByUserSegment();
	}

	@Override
	public int hashCode() {
		return _ctActionTotal.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _ctActionTotal.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _ctActionTotal.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _ctActionTotal.isNew();
	}

	@Override
	public void persist() {
		_ctActionTotal.persist();
	}

	/**
	* Sets the alias of this c t action total.
	*
	* @param alias the alias of this c t action total
	*/
	@Override
	public void setAlias(java.lang.String alias) {
		_ctActionTotal.setAlias(alias);
	}

	/**
	* Sets the c t action total ID of this c t action total.
	*
	* @param CTActionTotalId the c t action total ID of this c t action total
	*/
	@Override
	public void setCTActionTotalId(long CTActionTotalId) {
		_ctActionTotal.setCTActionTotalId(CTActionTotalId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ctActionTotal.setCachedModel(cachedModel);
	}

	/**
	* Sets the campaign ID of this c t action total.
	*
	* @param campaignId the campaign ID of this c t action total
	*/
	@Override
	public void setCampaignId(long campaignId) {
		_ctActionTotal.setCampaignId(campaignId);
	}

	/**
	* Sets the company ID of this c t action total.
	*
	* @param companyId the company ID of this c t action total
	*/
	@Override
	public void setCompanyId(long companyId) {
		_ctActionTotal.setCompanyId(companyId);
	}

	/**
	* Sets the count of this c t action total.
	*
	* @param count the count of this c t action total
	*/
	@Override
	public void setCount(int count) {
		_ctActionTotal.setCount(count);
	}

	/**
	* Sets the element ID of this c t action total.
	*
	* @param elementId the element ID of this c t action total
	*/
	@Override
	public void setElementId(java.lang.String elementId) {
		_ctActionTotal.setElementId(elementId);
	}

	/**
	* Sets the event type of this c t action total.
	*
	* @param eventType the event type of this c t action total
	*/
	@Override
	public void setEventType(java.lang.String eventType) {
		_ctActionTotal.setEventType(eventType);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_ctActionTotal.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_ctActionTotal.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_ctActionTotal.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified date of this c t action total.
	*
	* @param modifiedDate the modified date of this c t action total
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_ctActionTotal.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_ctActionTotal.setNew(n);
	}

	/**
	* Sets the primary key of this c t action total.
	*
	* @param primaryKey the primary key of this c t action total
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ctActionTotal.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_ctActionTotal.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the referrer class name of this c t action total.
	*
	* @param referrerClassName the referrer class name of this c t action total
	*/
	@Override
	public void setReferrerClassName(java.lang.String referrerClassName) {
		_ctActionTotal.setReferrerClassName(referrerClassName);
	}

	/**
	* Sets the referrer class p k of this c t action total.
	*
	* @param referrerClassPK the referrer class p k of this c t action total
	*/
	@Override
	public void setReferrerClassPK(long referrerClassPK) {
		_ctActionTotal.setReferrerClassPK(referrerClassPK);
	}

	/**
	* Sets the report instance ID of this c t action total.
	*
	* @param reportInstanceId the report instance ID of this c t action total
	*/
	@Override
	public void setReportInstanceId(long reportInstanceId) {
		_ctActionTotal.setReportInstanceId(reportInstanceId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> toCacheModel() {
		return _ctActionTotal.toCacheModel();
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal toEscapedModel() {
		return new CTActionTotalWrapper(_ctActionTotal.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ctActionTotal.toString();
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal toUnescapedModel() {
		return new CTActionTotalWrapper(_ctActionTotal.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _ctActionTotal.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CTActionTotalWrapper)) {
			return false;
		}

		CTActionTotalWrapper ctActionTotalWrapper = (CTActionTotalWrapper)obj;

		if (Validator.equals(_ctActionTotal, ctActionTotalWrapper._ctActionTotal)) {
			return true;
		}

		return false;
	}

	@Override
	public CTActionTotal getWrappedModel() {
		return _ctActionTotal;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _ctActionTotal.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _ctActionTotal.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_ctActionTotal.resetOriginalValues();
	}

	private final CTActionTotal _ctActionTotal;
}