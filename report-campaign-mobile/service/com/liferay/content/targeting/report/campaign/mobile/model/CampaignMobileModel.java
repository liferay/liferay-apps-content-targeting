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
 * The base model interface for the CampaignMobile service. Represents a row in the &quot;CT_CMR_CampaignMobile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignMobile
 * @see com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileImpl
 * @see com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileModelImpl
 * @generated
 */
public interface CampaignMobileModel extends BaseModel<CampaignMobile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a campaign mobile model instance should use the {@link CampaignMobile} interface instead.
	 */

	/**
	 * Returns the primary key of this campaign mobile.
	 *
	 * @return the primary key of this campaign mobile
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this campaign mobile.
	 *
	 * @param primaryKey the primary key of this campaign mobile
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the campaign mobile ID of this campaign mobile.
	 *
	 * @return the campaign mobile ID of this campaign mobile
	 */
	public long getCampaignMobileId();

	/**
	 * Sets the campaign mobile ID of this campaign mobile.
	 *
	 * @param campaignMobileId the campaign mobile ID of this campaign mobile
	 */
	public void setCampaignMobileId(long campaignMobileId);

	/**
	 * Returns the campaign ID of this campaign mobile.
	 *
	 * @return the campaign ID of this campaign mobile
	 */
	public long getCampaignId();

	/**
	 * Sets the campaign ID of this campaign mobile.
	 *
	 * @param campaignId the campaign ID of this campaign mobile
	 */
	public void setCampaignId(long campaignId);

	/**
	 * Returns the count of this campaign mobile.
	 *
	 * @return the count of this campaign mobile
	 */
	public int getCount();

	/**
	 * Sets the count of this campaign mobile.
	 *
	 * @param count the count of this campaign mobile
	 */
	public void setCount(int count);

	/**
	 * Returns the modified date of this campaign mobile.
	 *
	 * @return the modified date of this campaign mobile
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this campaign mobile.
	 *
	 * @param modifiedDate the modified date of this campaign mobile
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the event type of this campaign mobile.
	 *
	 * @return the event type of this campaign mobile
	 */
	@AutoEscape
	public String getEventType();

	/**
	 * Sets the event type of this campaign mobile.
	 *
	 * @param eventType the event type of this campaign mobile
	 */
	public void setEventType(String eventType);

	/**
	 * Returns the class name of this campaign mobile.
	 *
	 * @return the class name of this campaign mobile
	 */
	@AutoEscape
	public String getClassName();

	/**
	 * Sets the class name of this campaign mobile.
	 *
	 * @param className the class name of this campaign mobile
	 */
	public void setClassName(String className);

	/**
	 * Returns the class p k of this campaign mobile.
	 *
	 * @return the class p k of this campaign mobile
	 */
	public long getClassPK();

	/**
	 * Sets the class p k of this campaign mobile.
	 *
	 * @param classPK the class p k of this campaign mobile
	 */
	public void setClassPK(long classPK);

	/**
	 * Returns the element ID of this campaign mobile.
	 *
	 * @return the element ID of this campaign mobile
	 */
	@AutoEscape
	public String getElementId();

	/**
	 * Sets the element ID of this campaign mobile.
	 *
	 * @param elementId the element ID of this campaign mobile
	 */
	public void setElementId(String elementId);

	/**
	 * Returns the consumer ID of this campaign mobile.
	 *
	 * @return the consumer ID of this campaign mobile
	 */
	public long getConsumerId();

	/**
	 * Sets the consumer ID of this campaign mobile.
	 *
	 * @param consumerId the consumer ID of this campaign mobile
	 */
	public void setConsumerId(long consumerId);

	/**
	 * Returns the placeholder ID of this campaign mobile.
	 *
	 * @return the placeholder ID of this campaign mobile
	 */
	public long getPlaceholderId();

	/**
	 * Sets the placeholder ID of this campaign mobile.
	 *
	 * @param placeholderId the placeholder ID of this campaign mobile
	 */
	public void setPlaceholderId(long placeholderId);

	/**
	 * Returns the user segment ID of this campaign mobile.
	 *
	 * @return the user segment ID of this campaign mobile
	 */
	public long getUserSegmentId();

	/**
	 * Sets the user segment ID of this campaign mobile.
	 *
	 * @param userSegmentId the user segment ID of this campaign mobile
	 */
	public void setUserSegmentId(long userSegmentId);

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
		com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile campaignMobile);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> toCacheModel();

	@Override
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile toEscapedModel();

	@Override
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}