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
 * This class is a wrapper for {@link CampaignTrackingActionTotal}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignTrackingActionTotal
 * @generated
 */
public class CampaignTrackingActionTotalWrapper
	implements CampaignTrackingActionTotal,
		ModelWrapper<CampaignTrackingActionTotal> {
	public CampaignTrackingActionTotalWrapper(
		CampaignTrackingActionTotal campaignTrackingActionTotal) {
		_campaignTrackingActionTotal = campaignTrackingActionTotal;
	}

	@Override
	public Class<?> getModelClass() {
		return CampaignTrackingActionTotal.class;
	}

	@Override
	public String getModelClassName() {
		return CampaignTrackingActionTotal.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("campaignTrackingActionTotalId",
			getCampaignTrackingActionTotalId());
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
		Long campaignTrackingActionTotalId = (Long)attributes.get(
				"campaignTrackingActionTotalId");

		if (campaignTrackingActionTotalId != null) {
			setCampaignTrackingActionTotalId(campaignTrackingActionTotalId);
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
	* Returns the primary key of this campaign tracking action total.
	*
	* @return the primary key of this campaign tracking action total
	*/
	@Override
	public long getPrimaryKey() {
		return _campaignTrackingActionTotal.getPrimaryKey();
	}

	/**
	* Sets the primary key of this campaign tracking action total.
	*
	* @param primaryKey the primary key of this campaign tracking action total
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_campaignTrackingActionTotal.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the campaign tracking action total ID of this campaign tracking action total.
	*
	* @return the campaign tracking action total ID of this campaign tracking action total
	*/
	@Override
	public long getCampaignTrackingActionTotalId() {
		return _campaignTrackingActionTotal.getCampaignTrackingActionTotalId();
	}

	/**
	* Sets the campaign tracking action total ID of this campaign tracking action total.
	*
	* @param campaignTrackingActionTotalId the campaign tracking action total ID of this campaign tracking action total
	*/
	@Override
	public void setCampaignTrackingActionTotalId(
		long campaignTrackingActionTotalId) {
		_campaignTrackingActionTotal.setCampaignTrackingActionTotalId(campaignTrackingActionTotalId);
	}

	/**
	* Returns the campaign ID of this campaign tracking action total.
	*
	* @return the campaign ID of this campaign tracking action total
	*/
	@Override
	public long getCampaignId() {
		return _campaignTrackingActionTotal.getCampaignId();
	}

	/**
	* Sets the campaign ID of this campaign tracking action total.
	*
	* @param campaignId the campaign ID of this campaign tracking action total
	*/
	@Override
	public void setCampaignId(long campaignId) {
		_campaignTrackingActionTotal.setCampaignId(campaignId);
	}

	/**
	* Returns the alias of this campaign tracking action total.
	*
	* @return the alias of this campaign tracking action total
	*/
	@Override
	public java.lang.String getAlias() {
		return _campaignTrackingActionTotal.getAlias();
	}

	/**
	* Sets the alias of this campaign tracking action total.
	*
	* @param alias the alias of this campaign tracking action total
	*/
	@Override
	public void setAlias(java.lang.String alias) {
		_campaignTrackingActionTotal.setAlias(alias);
	}

	/**
	* Returns the referrer class name of this campaign tracking action total.
	*
	* @return the referrer class name of this campaign tracking action total
	*/
	@Override
	public java.lang.String getReferrerClassName() {
		return _campaignTrackingActionTotal.getReferrerClassName();
	}

	/**
	* Sets the referrer class name of this campaign tracking action total.
	*
	* @param referrerClassName the referrer class name of this campaign tracking action total
	*/
	@Override
	public void setReferrerClassName(java.lang.String referrerClassName) {
		_campaignTrackingActionTotal.setReferrerClassName(referrerClassName);
	}

	/**
	* Returns the referrer class p k of this campaign tracking action total.
	*
	* @return the referrer class p k of this campaign tracking action total
	*/
	@Override
	public long getReferrerClassPK() {
		return _campaignTrackingActionTotal.getReferrerClassPK();
	}

	/**
	* Sets the referrer class p k of this campaign tracking action total.
	*
	* @param referrerClassPK the referrer class p k of this campaign tracking action total
	*/
	@Override
	public void setReferrerClassPK(long referrerClassPK) {
		_campaignTrackingActionTotal.setReferrerClassPK(referrerClassPK);
	}

	/**
	* Returns the element ID of this campaign tracking action total.
	*
	* @return the element ID of this campaign tracking action total
	*/
	@Override
	public java.lang.String getElementId() {
		return _campaignTrackingActionTotal.getElementId();
	}

	/**
	* Sets the element ID of this campaign tracking action total.
	*
	* @param elementId the element ID of this campaign tracking action total
	*/
	@Override
	public void setElementId(java.lang.String elementId) {
		_campaignTrackingActionTotal.setElementId(elementId);
	}

	/**
	* Returns the event type of this campaign tracking action total.
	*
	* @return the event type of this campaign tracking action total
	*/
	@Override
	public java.lang.String getEventType() {
		return _campaignTrackingActionTotal.getEventType();
	}

	/**
	* Sets the event type of this campaign tracking action total.
	*
	* @param eventType the event type of this campaign tracking action total
	*/
	@Override
	public void setEventType(java.lang.String eventType) {
		_campaignTrackingActionTotal.setEventType(eventType);
	}

	/**
	* Returns the count of this campaign tracking action total.
	*
	* @return the count of this campaign tracking action total
	*/
	@Override
	public int getCount() {
		return _campaignTrackingActionTotal.getCount();
	}

	/**
	* Sets the count of this campaign tracking action total.
	*
	* @param count the count of this campaign tracking action total
	*/
	@Override
	public void setCount(int count) {
		_campaignTrackingActionTotal.setCount(count);
	}

	/**
	* Returns the modified date of this campaign tracking action total.
	*
	* @return the modified date of this campaign tracking action total
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _campaignTrackingActionTotal.getModifiedDate();
	}

	/**
	* Sets the modified date of this campaign tracking action total.
	*
	* @param modifiedDate the modified date of this campaign tracking action total
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_campaignTrackingActionTotal.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _campaignTrackingActionTotal.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_campaignTrackingActionTotal.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _campaignTrackingActionTotal.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_campaignTrackingActionTotal.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _campaignTrackingActionTotal.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _campaignTrackingActionTotal.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_campaignTrackingActionTotal.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _campaignTrackingActionTotal.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_campaignTrackingActionTotal.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_campaignTrackingActionTotal.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_campaignTrackingActionTotal.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CampaignTrackingActionTotalWrapper((CampaignTrackingActionTotal)_campaignTrackingActionTotal.clone());
	}

	@Override
	public int compareTo(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal campaignTrackingActionTotal) {
		return _campaignTrackingActionTotal.compareTo(campaignTrackingActionTotal);
	}

	@Override
	public int hashCode() {
		return _campaignTrackingActionTotal.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal> toCacheModel() {
		return _campaignTrackingActionTotal.toCacheModel();
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal toEscapedModel() {
		return new CampaignTrackingActionTotalWrapper(_campaignTrackingActionTotal.toEscapedModel());
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal toUnescapedModel() {
		return new CampaignTrackingActionTotalWrapper(_campaignTrackingActionTotal.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _campaignTrackingActionTotal.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _campaignTrackingActionTotal.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaignTrackingActionTotal.persist();
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> getViewsByUserSegment()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignTrackingActionTotal.getViewsByUserSegment();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CampaignTrackingActionTotalWrapper)) {
			return false;
		}

		CampaignTrackingActionTotalWrapper campaignTrackingActionTotalWrapper = (CampaignTrackingActionTotalWrapper)obj;

		if (Validator.equals(_campaignTrackingActionTotal,
					campaignTrackingActionTotalWrapper._campaignTrackingActionTotal)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CampaignTrackingActionTotal getWrappedCampaignTrackingActionTotal() {
		return _campaignTrackingActionTotal;
	}

	@Override
	public CampaignTrackingActionTotal getWrappedModel() {
		return _campaignTrackingActionTotal;
	}

	@Override
	public void resetOriginalValues() {
		_campaignTrackingActionTotal.resetOriginalValues();
	}

	private CampaignTrackingActionTotal _campaignTrackingActionTotal;
}