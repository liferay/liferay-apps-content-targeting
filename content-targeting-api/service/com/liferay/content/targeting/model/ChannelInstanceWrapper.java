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

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

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
@ProviderType
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

	@Override
	public java.lang.Object clone() {
		return new ChannelInstanceWrapper((ChannelInstance)_channelInstance.clone());
	}

	@Override
	public int compareTo(
		com.liferay.content.targeting.model.ChannelInstance channelInstance) {
		return _channelInstance.compareTo(channelInstance);
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
	* Returns the campaign ID of this channel instance.
	*
	* @return the campaign ID of this channel instance
	*/
	@Override
	public long getCampaignId() {
		return _channelInstance.getCampaignId();
	}

	@Override
	public java.lang.String getChannelGuid() {
		return _channelInstance.getChannelGuid();
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
	* Returns the channel key of this channel instance.
	*
	* @return the channel key of this channel instance
	*/
	@Override
	public java.lang.String getChannelKey() {
		return _channelInstance.getChannelKey();
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
	* Returns the create date of this channel instance.
	*
	* @return the create date of this channel instance
	*/
	@Override
	public Date getCreateDate() {
		return _channelInstance.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _channelInstance.getExpandoBridge();
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
	* Returns the modified date of this channel instance.
	*
	* @return the modified date of this channel instance
	*/
	@Override
	public Date getModifiedDate() {
		return _channelInstance.getModifiedDate();
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

	@Override
	public Serializable getPrimaryKeyObj() {
		return _channelInstance.getPrimaryKeyObj();
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
	* Returns the type settings of this channel instance.
	*
	* @return the type settings of this channel instance
	*/
	@Override
	public java.lang.String getTypeSettings() {
		return _channelInstance.getTypeSettings();
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
	* Returns the user name of this channel instance.
	*
	* @return the user name of this channel instance
	*/
	@Override
	public java.lang.String getUserName() {
		return _channelInstance.getUserName();
	}

	/**
	* Returns the user uuid of this channel instance.
	*
	* @return the user uuid of this channel instance
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _channelInstance.getUserUuid();
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

	@Override
	public Map<java.lang.String, java.lang.String> getValues() {
		return _channelInstance.getValues();
	}

	@Override
	public int hashCode() {
		return _channelInstance.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _channelInstance.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _channelInstance.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _channelInstance.isNew();
	}

	@Override
	public void persist() {
		_channelInstance.persist();
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

	@Override
	public void setCachedModel(boolean cachedModel) {
		_channelInstance.setCachedModel(cachedModel);
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

	@Override
	public void setChannelGuid(java.lang.String channelGuid) {
		_channelInstance.setChannelGuid(channelGuid);
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
	* Sets the channel key of this channel instance.
	*
	* @param channelKey the channel key of this channel instance
	*/
	@Override
	public void setChannelKey(java.lang.String channelKey) {
		_channelInstance.setChannelKey(channelKey);
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
	* Sets the create date of this channel instance.
	*
	* @param createDate the create date of this channel instance
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_channelInstance.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_channelInstance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_channelInstance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_channelInstance.setExpandoBridgeAttributes(serviceContext);
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
	* Sets the modified date of this channel instance.
	*
	* @param modifiedDate the modified date of this channel instance
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_channelInstance.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_channelInstance.setNew(n);
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

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_channelInstance.setPrimaryKeyObj(primaryKeyObj);
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
	* Sets the type settings of this channel instance.
	*
	* @param typeSettings the type settings of this channel instance
	*/
	@Override
	public void setTypeSettings(java.lang.String typeSettings) {
		_channelInstance.setTypeSettings(typeSettings);
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
	* Sets the user name of this channel instance.
	*
	* @param userName the user name of this channel instance
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_channelInstance.setUserName(userName);
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
	* Sets the uuid of this channel instance.
	*
	* @param uuid the uuid of this channel instance
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_channelInstance.setUuid(uuid);
	}

	@Override
	public void setValues(Map<java.lang.String, java.lang.String> values) {
		_channelInstance.setValues(values);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.liferay.content.targeting.model.ChannelInstance> toCacheModel() {
		return _channelInstance.toCacheModel();
	}

	@Override
	public com.liferay.content.targeting.model.ChannelInstance toEscapedModel() {
		return new ChannelInstanceWrapper(_channelInstance.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _channelInstance.toString();
	}

	@Override
	public com.liferay.content.targeting.model.ChannelInstance toUnescapedModel() {
		return new ChannelInstanceWrapper(_channelInstance.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _channelInstance.toXmlString();
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

	@Override
	public ChannelInstance getWrappedModel() {
		return _channelInstance;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _channelInstance.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _channelInstance.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_channelInstance.resetOriginalValues();
	}

	private final ChannelInstance _channelInstance;
}