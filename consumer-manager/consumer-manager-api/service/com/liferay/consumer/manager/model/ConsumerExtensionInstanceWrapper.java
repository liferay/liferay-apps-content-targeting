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

package com.liferay.consumer.manager.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ConsumerExtensionInstance}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerExtensionInstance
 * @generated
 */
public class ConsumerExtensionInstanceWrapper
	implements ConsumerExtensionInstance,
		ModelWrapper<ConsumerExtensionInstance> {
	public ConsumerExtensionInstanceWrapper(
		ConsumerExtensionInstance consumerExtensionInstance) {
		_consumerExtensionInstance = consumerExtensionInstance;
	}

	@Override
	public Class<?> getModelClass() {
		return ConsumerExtensionInstance.class;
	}

	@Override
	public String getModelClassName() {
		return ConsumerExtensionInstance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("consumerExtensionInstanceId",
			getConsumerExtensionInstanceId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("consumerExtensionKey", getConsumerExtensionKey());
		attributes.put("consumerId", getConsumerId());
		attributes.put("typeSettings", getTypeSettings());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long consumerExtensionInstanceId = (Long)attributes.get(
				"consumerExtensionInstanceId");

		if (consumerExtensionInstanceId != null) {
			setConsumerExtensionInstanceId(consumerExtensionInstanceId);
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

		String consumerExtensionKey = (String)attributes.get(
				"consumerExtensionKey");

		if (consumerExtensionKey != null) {
			setConsumerExtensionKey(consumerExtensionKey);
		}

		Long consumerId = (Long)attributes.get("consumerId");

		if (consumerId != null) {
			setConsumerId(consumerId);
		}

		String typeSettings = (String)attributes.get("typeSettings");

		if (typeSettings != null) {
			setTypeSettings(typeSettings);
		}
	}

	/**
	* Returns the primary key of this consumer extension instance.
	*
	* @return the primary key of this consumer extension instance
	*/
	@Override
	public long getPrimaryKey() {
		return _consumerExtensionInstance.getPrimaryKey();
	}

	/**
	* Sets the primary key of this consumer extension instance.
	*
	* @param primaryKey the primary key of this consumer extension instance
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_consumerExtensionInstance.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this consumer extension instance.
	*
	* @return the uuid of this consumer extension instance
	*/
	@Override
	public java.lang.String getUuid() {
		return _consumerExtensionInstance.getUuid();
	}

	/**
	* Sets the uuid of this consumer extension instance.
	*
	* @param uuid the uuid of this consumer extension instance
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_consumerExtensionInstance.setUuid(uuid);
	}

	/**
	* Returns the consumer extension instance ID of this consumer extension instance.
	*
	* @return the consumer extension instance ID of this consumer extension instance
	*/
	@Override
	public long getConsumerExtensionInstanceId() {
		return _consumerExtensionInstance.getConsumerExtensionInstanceId();
	}

	/**
	* Sets the consumer extension instance ID of this consumer extension instance.
	*
	* @param consumerExtensionInstanceId the consumer extension instance ID of this consumer extension instance
	*/
	@Override
	public void setConsumerExtensionInstanceId(long consumerExtensionInstanceId) {
		_consumerExtensionInstance.setConsumerExtensionInstanceId(consumerExtensionInstanceId);
	}

	/**
	* Returns the company ID of this consumer extension instance.
	*
	* @return the company ID of this consumer extension instance
	*/
	@Override
	public long getCompanyId() {
		return _consumerExtensionInstance.getCompanyId();
	}

	/**
	* Sets the company ID of this consumer extension instance.
	*
	* @param companyId the company ID of this consumer extension instance
	*/
	@Override
	public void setCompanyId(long companyId) {
		_consumerExtensionInstance.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this consumer extension instance.
	*
	* @return the user ID of this consumer extension instance
	*/
	@Override
	public long getUserId() {
		return _consumerExtensionInstance.getUserId();
	}

	/**
	* Sets the user ID of this consumer extension instance.
	*
	* @param userId the user ID of this consumer extension instance
	*/
	@Override
	public void setUserId(long userId) {
		_consumerExtensionInstance.setUserId(userId);
	}

	/**
	* Returns the user uuid of this consumer extension instance.
	*
	* @return the user uuid of this consumer extension instance
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _consumerExtensionInstance.getUserUuid();
	}

	/**
	* Sets the user uuid of this consumer extension instance.
	*
	* @param userUuid the user uuid of this consumer extension instance
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_consumerExtensionInstance.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this consumer extension instance.
	*
	* @return the user name of this consumer extension instance
	*/
	@Override
	public java.lang.String getUserName() {
		return _consumerExtensionInstance.getUserName();
	}

	/**
	* Sets the user name of this consumer extension instance.
	*
	* @param userName the user name of this consumer extension instance
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_consumerExtensionInstance.setUserName(userName);
	}

	/**
	* Returns the create date of this consumer extension instance.
	*
	* @return the create date of this consumer extension instance
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _consumerExtensionInstance.getCreateDate();
	}

	/**
	* Sets the create date of this consumer extension instance.
	*
	* @param createDate the create date of this consumer extension instance
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_consumerExtensionInstance.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this consumer extension instance.
	*
	* @return the modified date of this consumer extension instance
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _consumerExtensionInstance.getModifiedDate();
	}

	/**
	* Sets the modified date of this consumer extension instance.
	*
	* @param modifiedDate the modified date of this consumer extension instance
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_consumerExtensionInstance.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the consumer extension key of this consumer extension instance.
	*
	* @return the consumer extension key of this consumer extension instance
	*/
	@Override
	public java.lang.String getConsumerExtensionKey() {
		return _consumerExtensionInstance.getConsumerExtensionKey();
	}

	/**
	* Sets the consumer extension key of this consumer extension instance.
	*
	* @param consumerExtensionKey the consumer extension key of this consumer extension instance
	*/
	@Override
	public void setConsumerExtensionKey(java.lang.String consumerExtensionKey) {
		_consumerExtensionInstance.setConsumerExtensionKey(consumerExtensionKey);
	}

	/**
	* Returns the consumer ID of this consumer extension instance.
	*
	* @return the consumer ID of this consumer extension instance
	*/
	@Override
	public long getConsumerId() {
		return _consumerExtensionInstance.getConsumerId();
	}

	/**
	* Sets the consumer ID of this consumer extension instance.
	*
	* @param consumerId the consumer ID of this consumer extension instance
	*/
	@Override
	public void setConsumerId(long consumerId) {
		_consumerExtensionInstance.setConsumerId(consumerId);
	}

	/**
	* Returns the type settings of this consumer extension instance.
	*
	* @return the type settings of this consumer extension instance
	*/
	@Override
	public java.lang.String getTypeSettings() {
		return _consumerExtensionInstance.getTypeSettings();
	}

	/**
	* Sets the type settings of this consumer extension instance.
	*
	* @param typeSettings the type settings of this consumer extension instance
	*/
	@Override
	public void setTypeSettings(java.lang.String typeSettings) {
		_consumerExtensionInstance.setTypeSettings(typeSettings);
	}

	@Override
	public boolean isNew() {
		return _consumerExtensionInstance.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_consumerExtensionInstance.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _consumerExtensionInstance.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_consumerExtensionInstance.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _consumerExtensionInstance.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _consumerExtensionInstance.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_consumerExtensionInstance.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _consumerExtensionInstance.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_consumerExtensionInstance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_consumerExtensionInstance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_consumerExtensionInstance.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ConsumerExtensionInstanceWrapper((ConsumerExtensionInstance)_consumerExtensionInstance.clone());
	}

	@Override
	public int compareTo(
		com.liferay.consumer.manager.model.ConsumerExtensionInstance consumerExtensionInstance) {
		return _consumerExtensionInstance.compareTo(consumerExtensionInstance);
	}

	@Override
	public int hashCode() {
		return _consumerExtensionInstance.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.consumer.manager.model.ConsumerExtensionInstance> toCacheModel() {
		return _consumerExtensionInstance.toCacheModel();
	}

	@Override
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance toEscapedModel() {
		return new ConsumerExtensionInstanceWrapper(_consumerExtensionInstance.toEscapedModel());
	}

	@Override
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance toUnescapedModel() {
		return new ConsumerExtensionInstanceWrapper(_consumerExtensionInstance.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _consumerExtensionInstance.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _consumerExtensionInstance.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_consumerExtensionInstance.persist();
	}

	@Override
	public java.lang.String getConsumerExtensionGuid() {
		return _consumerExtensionInstance.getConsumerExtensionGuid();
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getValues() {
		return _consumerExtensionInstance.getValues();
	}

	@Override
	public void setConsumerExtensionGuid(java.lang.String consumerExtensionGuid) {
		_consumerExtensionInstance.setConsumerExtensionGuid(consumerExtensionGuid);
	}

	@Override
	public void setValues(
		java.util.Map<java.lang.String, java.lang.String> values) {
		_consumerExtensionInstance.setValues(values);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConsumerExtensionInstanceWrapper)) {
			return false;
		}

		ConsumerExtensionInstanceWrapper consumerExtensionInstanceWrapper = (ConsumerExtensionInstanceWrapper)obj;

		if (Validator.equals(_consumerExtensionInstance,
					consumerExtensionInstanceWrapper._consumerExtensionInstance)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _consumerExtensionInstance.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ConsumerExtensionInstance getWrappedConsumerExtensionInstance() {
		return _consumerExtensionInstance;
	}

	@Override
	public ConsumerExtensionInstance getWrappedModel() {
		return _consumerExtensionInstance;
	}

	@Override
	public void resetOriginalValues() {
		_consumerExtensionInstance.resetOriginalValues();
	}

	private ConsumerExtensionInstance _consumerExtensionInstance;
}