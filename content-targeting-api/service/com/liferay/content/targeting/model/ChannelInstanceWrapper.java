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
 * This class is a wrapper for {@link ChannelInstance}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChannelInstance
 * @generated
 */
public class ChannelInstanceWrapper implements ChannelInstance,
	ModelWrapper<ChannelInstance> {
	public ChannelInstanceWrapper(ChannelInstance channelInstance) {
		_channelInstance = channelInstance;
	}

	@Override
	public Class<?> getModelClass() {
		return ChannelInstance.class;
	}

	@Override
	public String getModelClassName() {
		return ChannelInstance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("channelInstanceId", getChannelInstanceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("channelKey", getChannelKey());
		attributes.put("campaignId", getCampaignId());
		attributes.put("tacticId", getTacticId());
		attributes.put("alias", getAlias());
		attributes.put("typeSettings", getTypeSettings());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long channelInstanceId = (Long)attributes.get("channelInstanceId");

		if (channelInstanceId != null) {
			setChannelInstanceId(channelInstanceId);
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

		String channelKey = (String)attributes.get("channelKey");

		if (channelKey != null) {
			setChannelKey(channelKey);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		Long tacticId = (Long)attributes.get("tacticId");

		if (tacticId != null) {
			setTacticId(tacticId);
		}

		String alias = (String)attributes.get("alias");

		if (alias != null) {
			setAlias(alias);
		}

		String typeSettings = (String)attributes.get("typeSettings");

		if (typeSettings != null) {
			setTypeSettings(typeSettings);
		}
	}

	/**
	* Returns the primary key of this channel instance.
	*
	* @return the primary key of this channel instance
	*/
	@Override
	public long getPrimaryKey() {
		return _channelInstance.getPrimaryKey();
	}

	/**
	* Sets the primary key of this channel instance.
	*
	* @param primaryKey the primary key of this channel instance
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_channelInstance.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this channel instance.
	*
	* @return the uuid of this channel instance
	*/
	@Override
	public java.lang.String getUuid() {
		return _channelInstance.getUuid();
	}

	/**
	* Sets the uuid of this channel instance.
	*
	* @param uuid the uuid of this channel instance
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_channelInstance.setUuid(uuid);
	}

	/**
	* Returns the channel instance ID of this channel instance.
	*
	* @return the channel instance ID of this channel instance
	*/
	@Override
	public long getChannelInstanceId() {
		return _channelInstance.getChannelInstanceId();
	}

	/**
	* Sets the channel instance ID of this channel instance.
	*
	* @param channelInstanceId the channel instance ID of this channel instance
	*/
	@Override
	public void setChannelInstanceId(long channelInstanceId) {
		_channelInstance.setChannelInstanceId(channelInstanceId);
	}

	/**
	* Returns the group ID of this channel instance.
	*
	* @return the group ID of this channel instance
	*/
	@Override
	public long getGroupId() {
		return _channelInstance.getGroupId();
	}

	/**
	* Sets the group ID of this channel instance.
	*
	* @param groupId the group ID of this channel instance
	*/
	@Override
	public void setGroupId(long groupId) {
		_channelInstance.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this channel instance.
	*
	* @return the company ID of this channel instance
	*/
	@Override
	public long getCompanyId() {
		return _channelInstance.getCompanyId();
	}

	/**
	* Sets the company ID of this channel instance.
	*
	* @param companyId the company ID of this channel instance
	*/
	@Override
	public void setCompanyId(long companyId) {
		_channelInstance.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this channel instance.
	*
	* @return the user ID of this channel instance
	*/
	@Override
	public long getUserId() {
		return _channelInstance.getUserId();
	}

	/**
	* Sets the user ID of this channel instance.
	*
	* @param userId the user ID of this channel instance
	*/
	@Override
	public void setUserId(long userId) {
		_channelInstance.setUserId(userId);
	}

	/**
	* Returns the user uuid of this channel instance.
	*
	* @return the user uuid of this channel instance
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _channelInstance.getUserUuid();
	}

	/**
	* Sets the user uuid of this channel instance.
	*
	* @param userUuid the user uuid of this channel instance
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_channelInstance.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this channel instance.
	*
	* @return the user name of this channel instance
	*/
	@Override
	public java.lang.String getUserName() {
		return _channelInstance.getUserName();
	}

	/**
	* Sets the user name of this channel instance.
	*
	* @param userName the user name of this channel instance
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_channelInstance.setUserName(userName);
	}

	/**
	* Returns the create date of this channel instance.
	*
	* @return the create date of this channel instance
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _channelInstance.getCreateDate();
	}

	/**
	* Sets the create date of this channel instance.
	*
	* @param createDate the create date of this channel instance
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_channelInstance.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this channel instance.
	*
	* @return the modified date of this channel instance
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _channelInstance.getModifiedDate();
	}

	/**
	* Sets the modified date of this channel instance.
	*
	* @param modifiedDate the modified date of this channel instance
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_channelInstance.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the channel key of this channel instance.
	*
	* @return the channel key of this channel instance
	*/
	@Override
	public java.lang.String getChannelKey() {
		return _channelInstance.getChannelKey();
	}

	/**
	* Sets the channel key of this channel instance.
	*
	* @param channelKey the channel key of this channel instance
	*/
	@Override
	public void setChannelKey(java.lang.String channelKey) {
		_channelInstance.setChannelKey(channelKey);
	}

	/**
	* Returns the campaign ID of this channel instance.
	*
	* @return the campaign ID of this channel instance
	*/
	@Override
	public long getCampaignId() {
		return _channelInstance.getCampaignId();
	}

	/**
	* Sets the campaign ID of this channel instance.
	*
	* @param campaignId the campaign ID of this channel instance
	*/
	@Override
	public void setCampaignId(long campaignId) {
		_channelInstance.setCampaignId(campaignId);
	}

	/**
	* Returns the tactic ID of this channel instance.
	*
	* @return the tactic ID of this channel instance
	*/
	@Override
	public long getTacticId() {
		return _channelInstance.getTacticId();
	}

	/**
	* Sets the tactic ID of this channel instance.
	*
	* @param tacticId the tactic ID of this channel instance
	*/
	@Override
	public void setTacticId(long tacticId) {
		_channelInstance.setTacticId(tacticId);
	}

	/**
	* Returns the alias of this channel instance.
	*
	* @return the alias of this channel instance
	*/
	@Override
	public java.lang.String getAlias() {
		return _channelInstance.getAlias();
	}

	/**
	* Sets the alias of this channel instance.
	*
	* @param alias the alias of this channel instance
	*/
	@Override
	public void setAlias(java.lang.String alias) {
		_channelInstance.setAlias(alias);
	}

	/**
	* Returns the type settings of this channel instance.
	*
	* @return the type settings of this channel instance
	*/
	@Override
	public java.lang.String getTypeSettings() {
		return _channelInstance.getTypeSettings();
	}

	/**
	* Sets the type settings of this channel instance.
	*
	* @param typeSettings the type settings of this channel instance
	*/
	@Override
	public void setTypeSettings(java.lang.String typeSettings) {
		_channelInstance.setTypeSettings(typeSettings);
	}

	@Override
	public boolean isNew() {
		return _channelInstance.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_channelInstance.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _channelInstance.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_channelInstance.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _channelInstance.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _channelInstance.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_channelInstance.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _channelInstance.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_channelInstance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_channelInstance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_channelInstance.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ChannelInstanceWrapper((ChannelInstance)_channelInstance.clone());
	}

	@Override
	public int compareTo(
		com.liferay.content.targeting.model.ChannelInstance channelInstance) {
		return _channelInstance.compareTo(channelInstance);
	}

	@Override
	public int hashCode() {
		return _channelInstance.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.content.targeting.model.ChannelInstance> toCacheModel() {
		return _channelInstance.toCacheModel();
	}

	@Override
	public com.liferay.content.targeting.model.ChannelInstance toEscapedModel() {
		return new ChannelInstanceWrapper(_channelInstance.toEscapedModel());
	}

	@Override
	public com.liferay.content.targeting.model.ChannelInstance toUnescapedModel() {
		return new ChannelInstanceWrapper(_channelInstance.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _channelInstance.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _channelInstance.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_channelInstance.persist();
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getValues() {
		return _channelInstance.getValues();
	}

	@Override
	public void setValues(
		java.util.Map<java.lang.String, java.lang.String> values) {
		_channelInstance.setValues(values);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ChannelInstanceWrapper)) {
			return false;
		}

		ChannelInstanceWrapper channelInstanceWrapper = (ChannelInstanceWrapper)obj;

		if (Validator.equals(_channelInstance,
					channelInstanceWrapper._channelInstance)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _channelInstance.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ChannelInstance getWrappedChannelInstance() {
		return _channelInstance;
	}

	@Override
	public ChannelInstance getWrappedModel() {
		return _channelInstance;
	}

	@Override
	public void resetOriginalValues() {
		_channelInstance.resetOriginalValues();
	}

	private ChannelInstance _channelInstance;
}