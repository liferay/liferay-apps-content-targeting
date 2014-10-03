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

package com.liferay.content.targeting.report.campaign.newsletter.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Newsletter}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Newsletter
 * @generated
 */
public class NewsletterWrapper implements Newsletter, ModelWrapper<Newsletter> {
	public NewsletterWrapper(Newsletter newsletter) {
		_newsletter = newsletter;
	}

	@Override
	public Class<?> getModelClass() {
		return Newsletter.class;
	}

	@Override
	public String getModelClassName() {
		return Newsletter.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("newsletterId", getNewsletterId());
		attributes.put("campaignId", getCampaignId());
		attributes.put("alias", getAlias());
		attributes.put("elementId", getElementId());
		attributes.put("eventType", getEventType());
		attributes.put("count", getCount());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long newsletterId = (Long)attributes.get("newsletterId");

		if (newsletterId != null) {
			setNewsletterId(newsletterId);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		String alias = (String)attributes.get("alias");

		if (alias != null) {
			setAlias(alias);
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
	* Returns the primary key of this newsletter.
	*
	* @return the primary key of this newsletter
	*/
	@Override
	public long getPrimaryKey() {
		return _newsletter.getPrimaryKey();
	}

	/**
	* Sets the primary key of this newsletter.
	*
	* @param primaryKey the primary key of this newsletter
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_newsletter.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the newsletter ID of this newsletter.
	*
	* @return the newsletter ID of this newsletter
	*/
	@Override
	public long getNewsletterId() {
		return _newsletter.getNewsletterId();
	}

	/**
	* Sets the newsletter ID of this newsletter.
	*
	* @param newsletterId the newsletter ID of this newsletter
	*/
	@Override
	public void setNewsletterId(long newsletterId) {
		_newsletter.setNewsletterId(newsletterId);
	}

	/**
	* Returns the campaign ID of this newsletter.
	*
	* @return the campaign ID of this newsletter
	*/
	@Override
	public long getCampaignId() {
		return _newsletter.getCampaignId();
	}

	/**
	* Sets the campaign ID of this newsletter.
	*
	* @param campaignId the campaign ID of this newsletter
	*/
	@Override
	public void setCampaignId(long campaignId) {
		_newsletter.setCampaignId(campaignId);
	}

	/**
	* Returns the alias of this newsletter.
	*
	* @return the alias of this newsletter
	*/
	@Override
	public java.lang.String getAlias() {
		return _newsletter.getAlias();
	}

	/**
	* Sets the alias of this newsletter.
	*
	* @param alias the alias of this newsletter
	*/
	@Override
	public void setAlias(java.lang.String alias) {
		_newsletter.setAlias(alias);
	}

	/**
	* Returns the element ID of this newsletter.
	*
	* @return the element ID of this newsletter
	*/
	@Override
	public java.lang.String getElementId() {
		return _newsletter.getElementId();
	}

	/**
	* Sets the element ID of this newsletter.
	*
	* @param elementId the element ID of this newsletter
	*/
	@Override
	public void setElementId(java.lang.String elementId) {
		_newsletter.setElementId(elementId);
	}

	/**
	* Returns the event type of this newsletter.
	*
	* @return the event type of this newsletter
	*/
	@Override
	public java.lang.String getEventType() {
		return _newsletter.getEventType();
	}

	/**
	* Sets the event type of this newsletter.
	*
	* @param eventType the event type of this newsletter
	*/
	@Override
	public void setEventType(java.lang.String eventType) {
		_newsletter.setEventType(eventType);
	}

	/**
	* Returns the count of this newsletter.
	*
	* @return the count of this newsletter
	*/
	@Override
	public int getCount() {
		return _newsletter.getCount();
	}

	/**
	* Sets the count of this newsletter.
	*
	* @param count the count of this newsletter
	*/
	@Override
	public void setCount(int count) {
		_newsletter.setCount(count);
	}

	/**
	* Returns the modified date of this newsletter.
	*
	* @return the modified date of this newsletter
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _newsletter.getModifiedDate();
	}

	/**
	* Sets the modified date of this newsletter.
	*
	* @param modifiedDate the modified date of this newsletter
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_newsletter.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _newsletter.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_newsletter.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _newsletter.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_newsletter.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _newsletter.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _newsletter.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_newsletter.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _newsletter.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_newsletter.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_newsletter.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_newsletter.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NewsletterWrapper((Newsletter)_newsletter.clone());
	}

	@Override
	public int compareTo(Newsletter newsletter) {
		return _newsletter.compareTo(newsletter);
	}

	@Override
	public int hashCode() {
		return _newsletter.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<Newsletter> toCacheModel() {
		return _newsletter.toCacheModel();
	}

	@Override
	public Newsletter toEscapedModel() {
		return new NewsletterWrapper(_newsletter.toEscapedModel());
	}

	@Override
	public Newsletter toUnescapedModel() {
		return new NewsletterWrapper(_newsletter.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _newsletter.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _newsletter.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_newsletter.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NewsletterWrapper)) {
			return false;
		}

		NewsletterWrapper newsletterWrapper = (NewsletterWrapper)obj;

		if (Validator.equals(_newsletter, newsletterWrapper._newsletter)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Newsletter getWrappedNewsletter() {
		return _newsletter;
	}

	@Override
	public Newsletter getWrappedModel() {
		return _newsletter;
	}

	@Override
	public void resetOriginalValues() {
		_newsletter.resetOriginalValues();
	}

	private Newsletter _newsletter;
}