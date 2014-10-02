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

package com.liferay.content.targeting.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TrackingActionInstance}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrackingActionInstance
 * @generated
 */
public class TrackingActionInstanceWrapper implements TrackingActionInstance,
	ModelWrapper<TrackingActionInstance> {
	public TrackingActionInstanceWrapper(
		TrackingActionInstance trackingActionInstance) {
		_trackingActionInstance = trackingActionInstance;
	}

	@Override
	public Class<?> getModelClass() {
		return TrackingActionInstance.class;
	}

	@Override
	public String getModelClassName() {
		return TrackingActionInstance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("trackingActionInstanceId", getTrackingActionInstanceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("trackingActionKey", getTrackingActionKey());
		attributes.put("campaignId", getCampaignId());
		attributes.put("alias", getAlias());
		attributes.put("referrerClassName", getReferrerClassName());
		attributes.put("referrerClassPK", getReferrerClassPK());
		attributes.put("elementId", getElementId());
		attributes.put("eventType", getEventType());
		attributes.put("typeSettings", getTypeSettings());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long trackingActionInstanceId = (Long)attributes.get(
				"trackingActionInstanceId");

		if (trackingActionInstanceId != null) {
			setTrackingActionInstanceId(trackingActionInstanceId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String trackingActionKey = (String)attributes.get("trackingActionKey");

		if (trackingActionKey != null) {
			setTrackingActionKey(trackingActionKey);
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

		String typeSettings = (String)attributes.get("typeSettings");

		if (typeSettings != null) {
			setTypeSettings(typeSettings);
		}
	}

	/**
	* Returns the primary key of this tracking action instance.
	*
	* @return the primary key of this tracking action instance
	*/
	@Override
	public long getPrimaryKey() {
		return _trackingActionInstance.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tracking action instance.
	*
	* @param primaryKey the primary key of this tracking action instance
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_trackingActionInstance.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this tracking action instance.
	*
	* @return the uuid of this tracking action instance
	*/
	@Override
	public java.lang.String getUuid() {
		return _trackingActionInstance.getUuid();
	}

	/**
	* Sets the uuid of this tracking action instance.
	*
	* @param uuid the uuid of this tracking action instance
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_trackingActionInstance.setUuid(uuid);
	}

	/**
	* Returns the tracking action instance ID of this tracking action instance.
	*
	* @return the tracking action instance ID of this tracking action instance
	*/
	@Override
	public long getTrackingActionInstanceId() {
		return _trackingActionInstance.getTrackingActionInstanceId();
	}

	/**
	* Sets the tracking action instance ID of this tracking action instance.
	*
	* @param trackingActionInstanceId the tracking action instance ID of this tracking action instance
	*/
	@Override
	public void setTrackingActionInstanceId(long trackingActionInstanceId) {
		_trackingActionInstance.setTrackingActionInstanceId(trackingActionInstanceId);
	}

	/**
	* Returns the group ID of this tracking action instance.
	*
	* @return the group ID of this tracking action instance
	*/
	@Override
	public long getGroupId() {
		return _trackingActionInstance.getGroupId();
	}

	/**
	* Sets the group ID of this tracking action instance.
	*
	* @param groupId the group ID of this tracking action instance
	*/
	@Override
	public void setGroupId(long groupId) {
		_trackingActionInstance.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this tracking action instance.
	*
	* @return the company ID of this tracking action instance
	*/
	@Override
	public long getCompanyId() {
		return _trackingActionInstance.getCompanyId();
	}

	/**
	* Sets the company ID of this tracking action instance.
	*
	* @param companyId the company ID of this tracking action instance
	*/
	@Override
	public void setCompanyId(long companyId) {
		_trackingActionInstance.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this tracking action instance.
	*
	* @return the user ID of this tracking action instance
	*/
	@Override
	public long getUserId() {
		return _trackingActionInstance.getUserId();
	}

	/**
	* Sets the user ID of this tracking action instance.
	*
	* @param userId the user ID of this tracking action instance
	*/
	@Override
	public void setUserId(long userId) {
		_trackingActionInstance.setUserId(userId);
	}

	/**
	* Returns the user uuid of this tracking action instance.
	*
	* @return the user uuid of this tracking action instance
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstance.getUserUuid();
	}

	/**
	* Sets the user uuid of this tracking action instance.
	*
	* @param userUuid the user uuid of this tracking action instance
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_trackingActionInstance.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this tracking action instance.
	*
	* @return the user name of this tracking action instance
	*/
	@Override
	public java.lang.String getUserName() {
		return _trackingActionInstance.getUserName();
	}

	/**
	* Sets the user name of this tracking action instance.
	*
	* @param userName the user name of this tracking action instance
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_trackingActionInstance.setUserName(userName);
	}

	/**
	* Returns the create date of this tracking action instance.
	*
	* @return the create date of this tracking action instance
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _trackingActionInstance.getCreateDate();
	}

	/**
	* Sets the create date of this tracking action instance.
	*
	* @param createDate the create date of this tracking action instance
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_trackingActionInstance.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this tracking action instance.
	*
	* @return the modified date of this tracking action instance
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _trackingActionInstance.getModifiedDate();
	}

	/**
	* Sets the modified date of this tracking action instance.
	*
	* @param modifiedDate the modified date of this tracking action instance
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_trackingActionInstance.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the tracking action key of this tracking action instance.
	*
	* @return the tracking action key of this tracking action instance
	*/
	@Override
	public java.lang.String getTrackingActionKey() {
		return _trackingActionInstance.getTrackingActionKey();
	}

	/**
	* Sets the tracking action key of this tracking action instance.
	*
	* @param trackingActionKey the tracking action key of this tracking action instance
	*/
	@Override
	public void setTrackingActionKey(java.lang.String trackingActionKey) {
		_trackingActionInstance.setTrackingActionKey(trackingActionKey);
	}

	/**
	* Returns the campaign ID of this tracking action instance.
	*
	* @return the campaign ID of this tracking action instance
	*/
	@Override
	public long getCampaignId() {
		return _trackingActionInstance.getCampaignId();
	}

	/**
	* Sets the campaign ID of this tracking action instance.
	*
	* @param campaignId the campaign ID of this tracking action instance
	*/
	@Override
	public void setCampaignId(long campaignId) {
		_trackingActionInstance.setCampaignId(campaignId);
	}

	/**
	* Returns the alias of this tracking action instance.
	*
	* @return the alias of this tracking action instance
	*/
	@Override
	public java.lang.String getAlias() {
		return _trackingActionInstance.getAlias();
	}

	/**
	* Sets the alias of this tracking action instance.
	*
	* @param alias the alias of this tracking action instance
	*/
	@Override
	public void setAlias(java.lang.String alias) {
		_trackingActionInstance.setAlias(alias);
	}

	/**
	* Returns the referrer class name of this tracking action instance.
	*
	* @return the referrer class name of this tracking action instance
	*/
	@Override
	public java.lang.String getReferrerClassName() {
		return _trackingActionInstance.getReferrerClassName();
	}

	/**
	* Sets the referrer class name of this tracking action instance.
	*
	* @param referrerClassName the referrer class name of this tracking action instance
	*/
	@Override
	public void setReferrerClassName(java.lang.String referrerClassName) {
		_trackingActionInstance.setReferrerClassName(referrerClassName);
	}

	/**
	* Returns the referrer class p k of this tracking action instance.
	*
	* @return the referrer class p k of this tracking action instance
	*/
	@Override
	public long getReferrerClassPK() {
		return _trackingActionInstance.getReferrerClassPK();
	}

	/**
	* Sets the referrer class p k of this tracking action instance.
	*
	* @param referrerClassPK the referrer class p k of this tracking action instance
	*/
	@Override
	public void setReferrerClassPK(long referrerClassPK) {
		_trackingActionInstance.setReferrerClassPK(referrerClassPK);
	}

	/**
	* Returns the element ID of this tracking action instance.
	*
	* @return the element ID of this tracking action instance
	*/
	@Override
	public java.lang.String getElementId() {
		return _trackingActionInstance.getElementId();
	}

	/**
	* Sets the element ID of this tracking action instance.
	*
	* @param elementId the element ID of this tracking action instance
	*/
	@Override
	public void setElementId(java.lang.String elementId) {
		_trackingActionInstance.setElementId(elementId);
	}

	/**
	* Returns the event type of this tracking action instance.
	*
	* @return the event type of this tracking action instance
	*/
	@Override
	public java.lang.String getEventType() {
		return _trackingActionInstance.getEventType();
	}

	/**
	* Sets the event type of this tracking action instance.
	*
	* @param eventType the event type of this tracking action instance
	*/
	@Override
	public void setEventType(java.lang.String eventType) {
		_trackingActionInstance.setEventType(eventType);
	}

	/**
	* Returns the type settings of this tracking action instance.
	*
	* @return the type settings of this tracking action instance
	*/
	@Override
	public java.lang.String getTypeSettings() {
		return _trackingActionInstance.getTypeSettings();
	}

	/**
	* Sets the type settings of this tracking action instance.
	*
	* @param typeSettings the type settings of this tracking action instance
	*/
	@Override
	public void setTypeSettings(java.lang.String typeSettings) {
		_trackingActionInstance.setTypeSettings(typeSettings);
	}

	@Override
	public boolean isNew() {
		return _trackingActionInstance.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_trackingActionInstance.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _trackingActionInstance.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_trackingActionInstance.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _trackingActionInstance.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _trackingActionInstance.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_trackingActionInstance.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _trackingActionInstance.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_trackingActionInstance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_trackingActionInstance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_trackingActionInstance.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TrackingActionInstanceWrapper((TrackingActionInstance)_trackingActionInstance.clone());
	}

	@Override
	public int compareTo(TrackingActionInstance trackingActionInstance) {
		return _trackingActionInstance.compareTo(trackingActionInstance);
	}

	@Override
	public int hashCode() {
		return _trackingActionInstance.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<TrackingActionInstance> toCacheModel() {
		return _trackingActionInstance.toCacheModel();
	}

	@Override
	public TrackingActionInstance toEscapedModel() {
		return new TrackingActionInstanceWrapper(_trackingActionInstance.toEscapedModel());
	}

	@Override
	public TrackingActionInstance toUnescapedModel() {
		return new TrackingActionInstanceWrapper(_trackingActionInstance.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _trackingActionInstance.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _trackingActionInstance.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_trackingActionInstance.persist();
	}

	@Override
	public java.lang.String getTrackingActionGuid() {
		return _trackingActionInstance.getTrackingActionGuid();
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getValues() {
		return _trackingActionInstance.getValues();
	}

	@Override
	public void setTrackingActionGuid(java.lang.String trackingActionGuid) {
		_trackingActionInstance.setTrackingActionGuid(trackingActionGuid);
	}

	@Override
	public void setValues(
		java.util.Map<java.lang.String, java.lang.String> values) {
		_trackingActionInstance.setValues(values);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TrackingActionInstanceWrapper)) {
			return false;
		}

		TrackingActionInstanceWrapper trackingActionInstanceWrapper = (TrackingActionInstanceWrapper)obj;

		if (Validator.equals(_trackingActionInstance,
					trackingActionInstanceWrapper._trackingActionInstance)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _trackingActionInstance.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TrackingActionInstance getWrappedTrackingActionInstance() {
		return _trackingActionInstance;
	}

	@Override
	public TrackingActionInstance getWrappedModel() {
		return _trackingActionInstance;
	}

	@Override
	public void resetOriginalValues() {
		_trackingActionInstance.resetOriginalValues();
	}

	private TrackingActionInstance _trackingActionInstance;
}