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
 * This class is a wrapper for {@link CTActionTotal}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTActionTotal
 * @generated
 */
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
		attributes.put("campaignId", getCampaignId());
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

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
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
	* Returns the primary key of this c t action total.
	*
	* @return the primary key of this c t action total
	*/
	@Override
	public long getPrimaryKey() {
		return _ctActionTotal.getPrimaryKey();
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
	* Sets the c t action total ID of this c t action total.
	*
	* @param CTActionTotalId the c t action total ID of this c t action total
	*/
	@Override
	public void setCTActionTotalId(long CTActionTotalId) {
		_ctActionTotal.setCTActionTotalId(CTActionTotalId);
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
	* Sets the campaign ID of this c t action total.
	*
	* @param campaignId the campaign ID of this c t action total
	*/
	@Override
	public void setCampaignId(long campaignId) {
		_ctActionTotal.setCampaignId(campaignId);
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
	* Sets the alias of this c t action total.
	*
	* @param alias the alias of this c t action total
	*/
	@Override
	public void setAlias(java.lang.String alias) {
		_ctActionTotal.setAlias(alias);
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
	* Sets the referrer class name of this c t action total.
	*
	* @param referrerClassName the referrer class name of this c t action total
	*/
	@Override
	public void setReferrerClassName(java.lang.String referrerClassName) {
		_ctActionTotal.setReferrerClassName(referrerClassName);
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
	* Sets the referrer class p k of this c t action total.
	*
	* @param referrerClassPK the referrer class p k of this c t action total
	*/
	@Override
	public void setReferrerClassPK(long referrerClassPK) {
		_ctActionTotal.setReferrerClassPK(referrerClassPK);
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
	* Sets the element ID of this c t action total.
	*
	* @param elementId the element ID of this c t action total
	*/
	@Override
	public void setElementId(java.lang.String elementId) {
		_ctActionTotal.setElementId(elementId);
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

	/**
	* Sets the event type of this c t action total.
	*
	* @param eventType the event type of this c t action total
	*/
	@Override
	public void setEventType(java.lang.String eventType) {
		_ctActionTotal.setEventType(eventType);
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
	* Sets the count of this c t action total.
	*
	* @param count the count of this c t action total
	*/
	@Override
	public void setCount(int count) {
		_ctActionTotal.setCount(count);
	}

	/**
	* Returns the modified date of this c t action total.
	*
	* @return the modified date of this c t action total
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _ctActionTotal.getModifiedDate();
	}

	/**
	* Sets the modified date of this c t action total.
	*
	* @param modifiedDate the modified date of this c t action total
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_ctActionTotal.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _ctActionTotal.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_ctActionTotal.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _ctActionTotal.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ctActionTotal.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _ctActionTotal.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _ctActionTotal.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ctActionTotal.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ctActionTotal.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_ctActionTotal.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_ctActionTotal.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ctActionTotal.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CTActionTotalWrapper((CTActionTotal)_ctActionTotal.clone());
	}

	@Override
	public int compareTo(CTActionTotal ctActionTotal) {
		return _ctActionTotal.compareTo(ctActionTotal);
	}

	@Override
	public int hashCode() {
		return _ctActionTotal.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<CTActionTotal> toCacheModel() {
		return _ctActionTotal.toCacheModel();
	}

	@Override
	public CTActionTotal toEscapedModel() {
		return new CTActionTotalWrapper(_ctActionTotal.toEscapedModel());
	}

	@Override
	public CTActionTotal toUnescapedModel() {
		return new CTActionTotalWrapper(_ctActionTotal.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ctActionTotal.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ctActionTotal.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ctActionTotal.persist();
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getViewsByUserSegment()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionTotal.getViewsByUserSegment();
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

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CTActionTotal getWrappedCTActionTotal() {
		return _ctActionTotal;
	}

	@Override
	public CTActionTotal getWrappedModel() {
		return _ctActionTotal;
	}

	@Override
	public void resetOriginalValues() {
		_ctActionTotal.resetOriginalValues();
	}

	private CTActionTotal _ctActionTotal;
}