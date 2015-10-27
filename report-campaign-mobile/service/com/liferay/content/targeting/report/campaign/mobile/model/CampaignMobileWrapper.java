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

package com.liferay.content.targeting.report.campaign.mobile.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CampaignMobile}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignMobile
 * @generated
 */
public class CampaignMobileWrapper implements CampaignMobile,
	ModelWrapper<CampaignMobile> {
	public CampaignMobileWrapper(CampaignMobile campaignMobile) {
		_campaignMobile = campaignMobile;
	}

	@Override
	public Class<?> getModelClass() {
		return CampaignMobile.class;
	}

	@Override
	public String getModelClassName() {
		return CampaignMobile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("campaignMobileId", getCampaignMobileId());
		attributes.put("campaignId", getCampaignId());
		attributes.put("count", getCount());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("eventType", getEventType());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("elementId", getElementId());
		attributes.put("consumerId", getConsumerId());
		attributes.put("placeholderId", getPlaceholderId());
		attributes.put("userSegmentId", getUserSegmentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long campaignMobileId = (Long)attributes.get("campaignMobileId");

		if (campaignMobileId != null) {
			setCampaignMobileId(campaignMobileId);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		Integer count = (Integer)attributes.get("count");

		if (count != null) {
			setCount(count);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
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

		Long consumerId = (Long)attributes.get("consumerId");

		if (consumerId != null) {
			setConsumerId(consumerId);
		}

		Long placeholderId = (Long)attributes.get("placeholderId");

		if (placeholderId != null) {
			setPlaceholderId(placeholderId);
		}

		Long userSegmentId = (Long)attributes.get("userSegmentId");

		if (userSegmentId != null) {
			setUserSegmentId(userSegmentId);
		}
	}

	/**
	* Returns the primary key of this campaign mobile.
	*
	* @return the primary key of this campaign mobile
	*/
	@Override
	public long getPrimaryKey() {
		return _campaignMobile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this campaign mobile.
	*
	* @param primaryKey the primary key of this campaign mobile
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_campaignMobile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the campaign mobile ID of this campaign mobile.
	*
	* @return the campaign mobile ID of this campaign mobile
	*/
	@Override
	public long getCampaignMobileId() {
		return _campaignMobile.getCampaignMobileId();
	}

	/**
	* Sets the campaign mobile ID of this campaign mobile.
	*
	* @param campaignMobileId the campaign mobile ID of this campaign mobile
	*/
	@Override
	public void setCampaignMobileId(long campaignMobileId) {
		_campaignMobile.setCampaignMobileId(campaignMobileId);
	}

	/**
	* Returns the campaign ID of this campaign mobile.
	*
	* @return the campaign ID of this campaign mobile
	*/
	@Override
	public long getCampaignId() {
		return _campaignMobile.getCampaignId();
	}

	/**
	* Sets the campaign ID of this campaign mobile.
	*
	* @param campaignId the campaign ID of this campaign mobile
	*/
	@Override
	public void setCampaignId(long campaignId) {
		_campaignMobile.setCampaignId(campaignId);
	}

	/**
	* Returns the count of this campaign mobile.
	*
	* @return the count of this campaign mobile
	*/
	@Override
	public int getCount() {
		return _campaignMobile.getCount();
	}

	/**
	* Sets the count of this campaign mobile.
	*
	* @param count the count of this campaign mobile
	*/
	@Override
	public void setCount(int count) {
		_campaignMobile.setCount(count);
	}

	/**
	* Returns the modified date of this campaign mobile.
	*
	* @return the modified date of this campaign mobile
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _campaignMobile.getModifiedDate();
	}

	/**
	* Sets the modified date of this campaign mobile.
	*
	* @param modifiedDate the modified date of this campaign mobile
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_campaignMobile.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the event type of this campaign mobile.
	*
	* @return the event type of this campaign mobile
	*/
	@Override
	public java.lang.String getEventType() {
		return _campaignMobile.getEventType();
	}

	/**
	* Sets the event type of this campaign mobile.
	*
	* @param eventType the event type of this campaign mobile
	*/
	@Override
	public void setEventType(java.lang.String eventType) {
		_campaignMobile.setEventType(eventType);
	}

	/**
	* Returns the class name of this campaign mobile.
	*
	* @return the class name of this campaign mobile
	*/
	@Override
	public java.lang.String getClassName() {
		return _campaignMobile.getClassName();
	}

	/**
	* Sets the class name of this campaign mobile.
	*
	* @param className the class name of this campaign mobile
	*/
	@Override
	public void setClassName(java.lang.String className) {
		_campaignMobile.setClassName(className);
	}

	/**
	* Returns the class p k of this campaign mobile.
	*
	* @return the class p k of this campaign mobile
	*/
	@Override
	public long getClassPK() {
		return _campaignMobile.getClassPK();
	}

	/**
	* Sets the class p k of this campaign mobile.
	*
	* @param classPK the class p k of this campaign mobile
	*/
	@Override
	public void setClassPK(long classPK) {
		_campaignMobile.setClassPK(classPK);
	}

	/**
	* Returns the element ID of this campaign mobile.
	*
	* @return the element ID of this campaign mobile
	*/
	@Override
	public java.lang.String getElementId() {
		return _campaignMobile.getElementId();
	}

	/**
	* Sets the element ID of this campaign mobile.
	*
	* @param elementId the element ID of this campaign mobile
	*/
	@Override
	public void setElementId(java.lang.String elementId) {
		_campaignMobile.setElementId(elementId);
	}

	/**
	* Returns the consumer ID of this campaign mobile.
	*
	* @return the consumer ID of this campaign mobile
	*/
	@Override
	public long getConsumerId() {
		return _campaignMobile.getConsumerId();
	}

	/**
	* Sets the consumer ID of this campaign mobile.
	*
	* @param consumerId the consumer ID of this campaign mobile
	*/
	@Override
	public void setConsumerId(long consumerId) {
		_campaignMobile.setConsumerId(consumerId);
	}

	/**
	* Returns the placeholder ID of this campaign mobile.
	*
	* @return the placeholder ID of this campaign mobile
	*/
	@Override
	public long getPlaceholderId() {
		return _campaignMobile.getPlaceholderId();
	}

	/**
	* Sets the placeholder ID of this campaign mobile.
	*
	* @param placeholderId the placeholder ID of this campaign mobile
	*/
	@Override
	public void setPlaceholderId(long placeholderId) {
		_campaignMobile.setPlaceholderId(placeholderId);
	}

	/**
	* Returns the user segment ID of this campaign mobile.
	*
	* @return the user segment ID of this campaign mobile
	*/
	@Override
	public long getUserSegmentId() {
		return _campaignMobile.getUserSegmentId();
	}

	/**
	* Sets the user segment ID of this campaign mobile.
	*
	* @param userSegmentId the user segment ID of this campaign mobile
	*/
	@Override
	public void setUserSegmentId(long userSegmentId) {
		_campaignMobile.setUserSegmentId(userSegmentId);
	}

	@Override
	public boolean isNew() {
		return _campaignMobile.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_campaignMobile.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _campaignMobile.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_campaignMobile.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _campaignMobile.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _campaignMobile.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_campaignMobile.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _campaignMobile.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_campaignMobile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_campaignMobile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_campaignMobile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CampaignMobileWrapper((CampaignMobile)_campaignMobile.clone());
	}

	@Override
	public int compareTo(
		com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile campaignMobile) {
		return _campaignMobile.compareTo(campaignMobile);
	}

	@Override
	public int hashCode() {
		return _campaignMobile.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> toCacheModel() {
		return _campaignMobile.toCacheModel();
	}

	@Override
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile toEscapedModel() {
		return new CampaignMobileWrapper(_campaignMobile.toEscapedModel());
	}

	@Override
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile toUnescapedModel() {
		return new CampaignMobileWrapper(_campaignMobile.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _campaignMobile.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _campaignMobile.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaignMobile.persist();
	}

	@Override
	public java.lang.String getTitle(java.util.Locale locale) {
		return _campaignMobile.getTitle(locale);
	}

	@Override
	public java.lang.String getType(java.util.Locale locale) {
		return _campaignMobile.getType(locale);
	}

	@Override
	public java.lang.String getConsumerName(java.util.Locale locale) {
		return _campaignMobile.getConsumerName(locale);
	}

	@Override
	public java.lang.String getPlaceholderName(java.util.Locale locale) {
		return _campaignMobile.getPlaceholderName(locale);
	}

	@Override
	public java.lang.String getUserSegmentName(java.util.Locale locale) {
		return _campaignMobile.getUserSegmentName(locale);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CampaignMobileWrapper)) {
			return false;
		}

		CampaignMobileWrapper campaignMobileWrapper = (CampaignMobileWrapper)obj;

		if (Validator.equals(_campaignMobile,
					campaignMobileWrapper._campaignMobile)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CampaignMobile getWrappedCampaignMobile() {
		return _campaignMobile;
	}

	@Override
	public CampaignMobile getWrappedModel() {
		return _campaignMobile;
	}

	@Override
	public void resetOriginalValues() {
		_campaignMobile.resetOriginalValues();
	}

	private CampaignMobile _campaignMobile;
}