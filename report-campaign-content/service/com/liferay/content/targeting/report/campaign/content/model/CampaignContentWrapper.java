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

package com.liferay.content.targeting.report.campaign.content.model;

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
 * This class is a wrapper for {@link CampaignContent}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignContent
 * @generated
 */
@ProviderType
public class CampaignContentWrapper implements CampaignContent,
	ModelWrapper<CampaignContent> {
	public CampaignContentWrapper(CampaignContent campaignContent) {
		_campaignContent = campaignContent;
	}

	@Override
	public Class<?> getModelClass() {
		return CampaignContent.class;
	}

	@Override
	public String getModelClassName() {
		return CampaignContent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("campaignContentId", getCampaignContentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("campaignId", getCampaignId());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("eventType", getEventType());
		attributes.put("count", getCount());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long campaignContentId = (Long)attributes.get("campaignContentId");

		if (campaignContentId != null) {
			setCampaignContentId(campaignContentId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
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
		return new CampaignContentWrapper((CampaignContent)_campaignContent.clone());
	}

	@Override
	public int compareTo(
		com.liferay.content.targeting.report.campaign.content.model.CampaignContent campaignContent) {
		return _campaignContent.compareTo(campaignContent);
	}

	/**
	* Returns the campaign content ID of this campaign content.
	*
	* @return the campaign content ID of this campaign content
	*/
	@Override
	public long getCampaignContentId() {
		return _campaignContent.getCampaignContentId();
	}

	/**
	* Returns the campaign ID of this campaign content.
	*
	* @return the campaign ID of this campaign content
	*/
	@Override
	public long getCampaignId() {
		return _campaignContent.getCampaignId();
	}

	/**
	* Returns the class name of this campaign content.
	*
	* @return the class name of this campaign content
	*/
	@Override
	public java.lang.String getClassName() {
		return _campaignContent.getClassName();
	}

	/**
	* Returns the class p k of this campaign content.
	*
	* @return the class p k of this campaign content
	*/
	@Override
	public long getClassPK() {
		return _campaignContent.getClassPK();
	}

	/**
	* Returns the company ID of this campaign content.
	*
	* @return the company ID of this campaign content
	*/
	@Override
	public long getCompanyId() {
		return _campaignContent.getCompanyId();
	}

	/**
	* Returns the count of this campaign content.
	*
	* @return the count of this campaign content
	*/
	@Override
	public int getCount() {
		return _campaignContent.getCount();
	}

	/**
	* Returns the event type of this campaign content.
	*
	* @return the event type of this campaign content
	*/
	@Override
	public java.lang.String getEventType() {
		return _campaignContent.getEventType();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _campaignContent.getExpandoBridge();
	}

	/**
	* Returns the modified date of this campaign content.
	*
	* @return the modified date of this campaign content
	*/
	@Override
	public Date getModifiedDate() {
		return _campaignContent.getModifiedDate();
	}

	/**
	* Returns the primary key of this campaign content.
	*
	* @return the primary key of this campaign content
	*/
	@Override
	public long getPrimaryKey() {
		return _campaignContent.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _campaignContent.getPrimaryKeyObj();
	}

	@Override
	public java.lang.String getTitle(java.util.Locale locale) {
		return _campaignContent.getTitle(locale);
	}

	@Override
	public java.lang.String getType(java.util.Locale locale) {
		return _campaignContent.getType(locale);
	}

	@Override
	public int hashCode() {
		return _campaignContent.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _campaignContent.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _campaignContent.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _campaignContent.isNew();
	}

	@Override
	public void persist() {
		_campaignContent.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_campaignContent.setCachedModel(cachedModel);
	}

	/**
	* Sets the campaign content ID of this campaign content.
	*
	* @param campaignContentId the campaign content ID of this campaign content
	*/
	@Override
	public void setCampaignContentId(long campaignContentId) {
		_campaignContent.setCampaignContentId(campaignContentId);
	}

	/**
	* Sets the campaign ID of this campaign content.
	*
	* @param campaignId the campaign ID of this campaign content
	*/
	@Override
	public void setCampaignId(long campaignId) {
		_campaignContent.setCampaignId(campaignId);
	}

	/**
	* Sets the class name of this campaign content.
	*
	* @param className the class name of this campaign content
	*/
	@Override
	public void setClassName(java.lang.String className) {
		_campaignContent.setClassName(className);
	}

	/**
	* Sets the class p k of this campaign content.
	*
	* @param classPK the class p k of this campaign content
	*/
	@Override
	public void setClassPK(long classPK) {
		_campaignContent.setClassPK(classPK);
	}

	/**
	* Sets the company ID of this campaign content.
	*
	* @param companyId the company ID of this campaign content
	*/
	@Override
	public void setCompanyId(long companyId) {
		_campaignContent.setCompanyId(companyId);
	}

	/**
	* Sets the count of this campaign content.
	*
	* @param count the count of this campaign content
	*/
	@Override
	public void setCount(int count) {
		_campaignContent.setCount(count);
	}

	/**
	* Sets the event type of this campaign content.
	*
	* @param eventType the event type of this campaign content
	*/
	@Override
	public void setEventType(java.lang.String eventType) {
		_campaignContent.setEventType(eventType);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_campaignContent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_campaignContent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_campaignContent.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified date of this campaign content.
	*
	* @param modifiedDate the modified date of this campaign content
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_campaignContent.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_campaignContent.setNew(n);
	}

	/**
	* Sets the primary key of this campaign content.
	*
	* @param primaryKey the primary key of this campaign content
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_campaignContent.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_campaignContent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.liferay.content.targeting.report.campaign.content.model.CampaignContent> toCacheModel() {
		return _campaignContent.toCacheModel();
	}

	@Override
	public com.liferay.content.targeting.report.campaign.content.model.CampaignContent toEscapedModel() {
		return new CampaignContentWrapper(_campaignContent.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _campaignContent.toString();
	}

	@Override
	public com.liferay.content.targeting.report.campaign.content.model.CampaignContent toUnescapedModel() {
		return new CampaignContentWrapper(_campaignContent.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _campaignContent.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CampaignContentWrapper)) {
			return false;
		}

		CampaignContentWrapper campaignContentWrapper = (CampaignContentWrapper)obj;

		if (Validator.equals(_campaignContent,
					campaignContentWrapper._campaignContent)) {
			return true;
		}

		return false;
	}

	@Override
	public CampaignContent getWrappedModel() {
		return _campaignContent;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _campaignContent.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _campaignContent.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_campaignContent.resetOriginalValues();
	}

	private final CampaignContent _campaignContent;
}