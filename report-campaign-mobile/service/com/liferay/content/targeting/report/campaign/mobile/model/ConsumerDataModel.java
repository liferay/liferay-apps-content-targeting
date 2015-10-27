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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ConsumerData service. Represents a row in the &quot;CT_CMR_ConsumerData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerData
 * @see com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataImpl
 * @see com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl
 * @generated
 */
public interface ConsumerDataModel extends BaseModel<ConsumerData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a consumer data model instance should use the {@link ConsumerData} interface instead.
	 */

	/**
	 * Returns the primary key of this consumer data.
	 *
	 * @return the primary key of this consumer data
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this consumer data.
	 *
	 * @param primaryKey the primary key of this consumer data
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the consumer data ID of this consumer data.
	 *
	 * @return the consumer data ID of this consumer data
	 */
	public long getConsumerDataId();

	/**
	 * Sets the consumer data ID of this consumer data.
	 *
	 * @param consumerDataId the consumer data ID of this consumer data
	 */
	public void setConsumerDataId(long consumerDataId);

	/**
	 * Returns the campaign ID of this consumer data.
	 *
	 * @return the campaign ID of this consumer data
	 */
	public long getCampaignId();

	/**
	 * Sets the campaign ID of this consumer data.
	 *
	 * @param campaignId the campaign ID of this consumer data
	 */
	public void setCampaignId(long campaignId);

	/**
	 * Returns the count of this consumer data.
	 *
	 * @return the count of this consumer data
	 */
	public int getCount();

	/**
	 * Sets the count of this consumer data.
	 *
	 * @param count the count of this consumer data
	 */
	public void setCount(int count);

	/**
	 * Returns the modified date of this consumer data.
	 *
	 * @return the modified date of this consumer data
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this consumer data.
	 *
	 * @param modifiedDate the modified date of this consumer data
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the event type of this consumer data.
	 *
	 * @return the event type of this consumer data
	 */
	@AutoEscape
	public String getEventType();

	/**
	 * Sets the event type of this consumer data.
	 *
	 * @param eventType the event type of this consumer data
	 */
	public void setEventType(String eventType);

	/**
	 * Returns the element ID of this consumer data.
	 *
	 * @return the element ID of this consumer data
	 */
	@AutoEscape
	public String getElementId();

	/**
	 * Sets the element ID of this consumer data.
	 *
	 * @param elementId the element ID of this consumer data
	 */
	public void setElementId(String elementId);

	/**
	 * Returns the consumer ID of this consumer data.
	 *
	 * @return the consumer ID of this consumer data
	 */
	public long getConsumerId();

	/**
	 * Sets the consumer ID of this consumer data.
	 *
	 * @param consumerId the consumer ID of this consumer data
	 */
	public void setConsumerId(long consumerId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData consumerData);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData> toCacheModel();

	@Override
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData toEscapedModel();

	@Override
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}