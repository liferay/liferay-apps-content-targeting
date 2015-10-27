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
 * This class is a wrapper for {@link ConsumerData}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerData
 * @generated
 */
public class ConsumerDataWrapper implements ConsumerData,
	ModelWrapper<ConsumerData> {
	public ConsumerDataWrapper(ConsumerData consumerData) {
		_consumerData = consumerData;
	}

	@Override
	public Class<?> getModelClass() {
		return ConsumerData.class;
	}

	@Override
	public String getModelClassName() {
		return ConsumerData.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("consumerDataId", getConsumerDataId());
		attributes.put("campaignId", getCampaignId());
		attributes.put("count", getCount());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("eventType", getEventType());
		attributes.put("elementId", getElementId());
		attributes.put("consumerId", getConsumerId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long consumerDataId = (Long)attributes.get("consumerDataId");

		if (consumerDataId != null) {
			setConsumerDataId(consumerDataId);
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

		String elementId = (String)attributes.get("elementId");

		if (elementId != null) {
			setElementId(elementId);
		}

		Long consumerId = (Long)attributes.get("consumerId");

		if (consumerId != null) {
			setConsumerId(consumerId);
		}
	}

	/**
	* Returns the primary key of this consumer data.
	*
	* @return the primary key of this consumer data
	*/
	@Override
	public long getPrimaryKey() {
		return _consumerData.getPrimaryKey();
	}

	/**
	* Sets the primary key of this consumer data.
	*
	* @param primaryKey the primary key of this consumer data
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_consumerData.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the consumer data ID of this consumer data.
	*
	* @return the consumer data ID of this consumer data
	*/
	@Override
	public long getConsumerDataId() {
		return _consumerData.getConsumerDataId();
	}

	/**
	* Sets the consumer data ID of this consumer data.
	*
	* @param consumerDataId the consumer data ID of this consumer data
	*/
	@Override
	public void setConsumerDataId(long consumerDataId) {
		_consumerData.setConsumerDataId(consumerDataId);
	}

	/**
	* Returns the campaign ID of this consumer data.
	*
	* @return the campaign ID of this consumer data
	*/
	@Override
	public long getCampaignId() {
		return _consumerData.getCampaignId();
	}

	/**
	* Sets the campaign ID of this consumer data.
	*
	* @param campaignId the campaign ID of this consumer data
	*/
	@Override
	public void setCampaignId(long campaignId) {
		_consumerData.setCampaignId(campaignId);
	}

	/**
	* Returns the count of this consumer data.
	*
	* @return the count of this consumer data
	*/
	@Override
	public int getCount() {
		return _consumerData.getCount();
	}

	/**
	* Sets the count of this consumer data.
	*
	* @param count the count of this consumer data
	*/
	@Override
	public void setCount(int count) {
		_consumerData.setCount(count);
	}

	/**
	* Returns the modified date of this consumer data.
	*
	* @return the modified date of this consumer data
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _consumerData.getModifiedDate();
	}

	/**
	* Sets the modified date of this consumer data.
	*
	* @param modifiedDate the modified date of this consumer data
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_consumerData.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the event type of this consumer data.
	*
	* @return the event type of this consumer data
	*/
	@Override
	public java.lang.String getEventType() {
		return _consumerData.getEventType();
	}

	/**
	* Sets the event type of this consumer data.
	*
	* @param eventType the event type of this consumer data
	*/
	@Override
	public void setEventType(java.lang.String eventType) {
		_consumerData.setEventType(eventType);
	}

	/**
	* Returns the element ID of this consumer data.
	*
	* @return the element ID of this consumer data
	*/
	@Override
	public java.lang.String getElementId() {
		return _consumerData.getElementId();
	}

	/**
	* Sets the element ID of this consumer data.
	*
	* @param elementId the element ID of this consumer data
	*/
	@Override
	public void setElementId(java.lang.String elementId) {
		_consumerData.setElementId(elementId);
	}

	/**
	* Returns the consumer ID of this consumer data.
	*
	* @return the consumer ID of this consumer data
	*/
	@Override
	public long getConsumerId() {
		return _consumerData.getConsumerId();
	}

	/**
	* Sets the consumer ID of this consumer data.
	*
	* @param consumerId the consumer ID of this consumer data
	*/
	@Override
	public void setConsumerId(long consumerId) {
		_consumerData.setConsumerId(consumerId);
	}

	@Override
	public boolean isNew() {
		return _consumerData.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_consumerData.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _consumerData.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_consumerData.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _consumerData.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _consumerData.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_consumerData.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _consumerData.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_consumerData.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_consumerData.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_consumerData.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ConsumerDataWrapper((ConsumerData)_consumerData.clone());
	}

	@Override
	public int compareTo(
		com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData consumerData) {
		return _consumerData.compareTo(consumerData);
	}

	@Override
	public int hashCode() {
		return _consumerData.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData> toCacheModel() {
		return _consumerData.toCacheModel();
	}

	@Override
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData toEscapedModel() {
		return new ConsumerDataWrapper(_consumerData.toEscapedModel());
	}

	@Override
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData toUnescapedModel() {
		return new ConsumerDataWrapper(_consumerData.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _consumerData.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _consumerData.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_consumerData.persist();
	}

	@Override
	public java.lang.String getConsumerName(java.util.Locale locale) {
		return _consumerData.getConsumerName(locale);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConsumerDataWrapper)) {
			return false;
		}

		ConsumerDataWrapper consumerDataWrapper = (ConsumerDataWrapper)obj;

		if (Validator.equals(_consumerData, consumerDataWrapper._consumerData)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ConsumerData getWrappedConsumerData() {
		return _consumerData;
	}

	@Override
	public ConsumerData getWrappedModel() {
		return _consumerData;
	}

	@Override
	public void resetOriginalValues() {
		_consumerData.resetOriginalValues();
	}

	private ConsumerData _consumerData;
}