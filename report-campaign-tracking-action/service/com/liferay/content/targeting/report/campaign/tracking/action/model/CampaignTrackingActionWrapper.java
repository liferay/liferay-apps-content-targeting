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
 * This class is a wrapper for {@link CampaignTrackingAction}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignTrackingAction
 * @generated
 */
public class CampaignTrackingActionWrapper implements CampaignTrackingAction,
	ModelWrapper<CampaignTrackingAction> {
	public CampaignTrackingActionWrapper(
		CampaignTrackingAction campaignTrackingAction) {
		_campaignTrackingAction = campaignTrackingAction;
	}

	@Override
	public Class<?> getModelClass() {
		return CampaignTrackingAction.class;
	}

	@Override
	public String getModelClassName() {
		return CampaignTrackingAction.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("campaignTrackingActionId", getCampaignTrackingActionId());
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
		Long campaignTrackingActionId = (Long)attributes.get(
				"campaignTrackingActionId");

		if (campaignTrackingActionId != null) {
			setCampaignTrackingActionId(campaignTrackingActionId);
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
	* Returns the primary key of this campaign tracking action.
	*
	* @return the primary key of this campaign tracking action
	*/
	@Override
	public long getPrimaryKey() {
		return _campaignTrackingAction.getPrimaryKey();
	}

	/**
	* Sets the primary key of this campaign tracking action.
	*
	* @param primaryKey the primary key of this campaign tracking action
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_campaignTrackingAction.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the campaign tracking action ID of this campaign tracking action.
	*
	* @return the campaign tracking action ID of this campaign tracking action
	*/
	@Override
	public long getCampaignTrackingActionId() {
		return _campaignTrackingAction.getCampaignTrackingActionId();
	}

	/**
	* Sets the campaign tracking action ID of this campaign tracking action.
	*
	* @param campaignTrackingActionId the campaign tracking action ID of this campaign tracking action
	*/
	@Override
	public void setCampaignTrackingActionId(long campaignTrackingActionId) {
		_campaignTrackingAction.setCampaignTrackingActionId(campaignTrackingActionId);
	}

	/**
	* Returns the campaign ID of this campaign tracking action.
	*
	* @return the campaign ID of this campaign tracking action
	*/
	@Override
	public long getCampaignId() {
		return _campaignTrackingAction.getCampaignId();
	}

	/**
	* Sets the campaign ID of this campaign tracking action.
	*
	* @param campaignId the campaign ID of this campaign tracking action
	*/
	@Override
	public void setCampaignId(long campaignId) {
		_campaignTrackingAction.setCampaignId(campaignId);
	}

	/**
	* Returns the user segment ID of this campaign tracking action.
	*
	* @return the user segment ID of this campaign tracking action
	*/
	@Override
	public long getUserSegmentId() {
		return _campaignTrackingAction.getUserSegmentId();
	}

	/**
	* Sets the user segment ID of this campaign tracking action.
	*
	* @param userSegmentId the user segment ID of this campaign tracking action
	*/
	@Override
	public void setUserSegmentId(long userSegmentId) {
		_campaignTrackingAction.setUserSegmentId(userSegmentId);
	}

	/**
	* Returns the alias of this campaign tracking action.
	*
	* @return the alias of this campaign tracking action
	*/
	@Override
	public java.lang.String getAlias() {
		return _campaignTrackingAction.getAlias();
	}

	/**
	* Sets the alias of this campaign tracking action.
	*
	* @param alias the alias of this campaign tracking action
	*/
	@Override
	public void setAlias(java.lang.String alias) {
		_campaignTrackingAction.setAlias(alias);
	}

	/**
	* Returns the referrer class name of this campaign tracking action.
	*
	* @return the referrer class name of this campaign tracking action
	*/
	@Override
	public java.lang.String getReferrerClassName() {
		return _campaignTrackingAction.getReferrerClassName();
	}

	/**
	* Sets the referrer class name of this campaign tracking action.
	*
	* @param referrerClassName the referrer class name of this campaign tracking action
	*/
	@Override
	public void setReferrerClassName(java.lang.String referrerClassName) {
		_campaignTrackingAction.setReferrerClassName(referrerClassName);
	}

	/**
	* Returns the referrer class p k of this campaign tracking action.
	*
	* @return the referrer class p k of this campaign tracking action
	*/
	@Override
	public long getReferrerClassPK() {
		return _campaignTrackingAction.getReferrerClassPK();
	}

	/**
	* Sets the referrer class p k of this campaign tracking action.
	*
	* @param referrerClassPK the referrer class p k of this campaign tracking action
	*/
	@Override
	public void setReferrerClassPK(long referrerClassPK) {
		_campaignTrackingAction.setReferrerClassPK(referrerClassPK);
	}

	/**
	* Returns the element ID of this campaign tracking action.
	*
	* @return the element ID of this campaign tracking action
	*/
	@Override
	public java.lang.String getElementId() {
		return _campaignTrackingAction.getElementId();
	}

	/**
	* Sets the element ID of this campaign tracking action.
	*
	* @param elementId the element ID of this campaign tracking action
	*/
	@Override
	public void setElementId(java.lang.String elementId) {
		_campaignTrackingAction.setElementId(elementId);
	}

	/**
	* Returns the event type of this campaign tracking action.
	*
	* @return the event type of this campaign tracking action
	*/
	@Override
	public java.lang.String getEventType() {
		return _campaignTrackingAction.getEventType();
	}

	/**
	* Sets the event type of this campaign tracking action.
	*
	* @param eventType the event type of this campaign tracking action
	*/
	@Override
	public void setEventType(java.lang.String eventType) {
		_campaignTrackingAction.setEventType(eventType);
	}

	/**
	* Returns the count of this campaign tracking action.
	*
	* @return the count of this campaign tracking action
	*/
	@Override
	public int getCount() {
		return _campaignTrackingAction.getCount();
	}

	/**
	* Sets the count of this campaign tracking action.
	*
	* @param count the count of this campaign tracking action
	*/
	@Override
	public void setCount(int count) {
		_campaignTrackingAction.setCount(count);
	}

	/**
	* Returns the modified date of this campaign tracking action.
	*
	* @return the modified date of this campaign tracking action
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _campaignTrackingAction.getModifiedDate();
	}

	/**
	* Sets the modified date of this campaign tracking action.
	*
	* @param modifiedDate the modified date of this campaign tracking action
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_campaignTrackingAction.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _campaignTrackingAction.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_campaignTrackingAction.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _campaignTrackingAction.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_campaignTrackingAction.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _campaignTrackingAction.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _campaignTrackingAction.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_campaignTrackingAction.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _campaignTrackingAction.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_campaignTrackingAction.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_campaignTrackingAction.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_campaignTrackingAction.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CampaignTrackingActionWrapper((CampaignTrackingAction)_campaignTrackingAction.clone());
	}

	@Override
	public int compareTo(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction campaignTrackingAction) {
		return _campaignTrackingAction.compareTo(campaignTrackingAction);
	}

	@Override
	public int hashCode() {
		return _campaignTrackingAction.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> toCacheModel() {
		return _campaignTrackingAction.toCacheModel();
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction toEscapedModel() {
		return new CampaignTrackingActionWrapper(_campaignTrackingAction.toEscapedModel());
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction toUnescapedModel() {
		return new CampaignTrackingActionWrapper(_campaignTrackingAction.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _campaignTrackingAction.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _campaignTrackingAction.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaignTrackingAction.persist();
	}

	@Override
	public java.lang.String getUserSegmentName(java.util.Locale locale) {
		return _campaignTrackingAction.getUserSegmentName(locale);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CampaignTrackingActionWrapper)) {
			return false;
		}

		CampaignTrackingActionWrapper campaignTrackingActionWrapper = (CampaignTrackingActionWrapper)obj;

		if (Validator.equals(_campaignTrackingAction,
					campaignTrackingActionWrapper._campaignTrackingAction)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CampaignTrackingAction getWrappedCampaignTrackingAction() {
		return _campaignTrackingAction;
	}

	@Override
	public CampaignTrackingAction getWrappedModel() {
		return _campaignTrackingAction;
	}

	@Override
	public void resetOriginalValues() {
		_campaignTrackingAction.resetOriginalValues();
	}

	private CampaignTrackingAction _campaignTrackingAction;
}