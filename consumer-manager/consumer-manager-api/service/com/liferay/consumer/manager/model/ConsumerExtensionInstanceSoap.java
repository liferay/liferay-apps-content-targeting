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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.consumer.manager.service.http.ConsumerExtensionInstanceServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.consumer.manager.service.http.ConsumerExtensionInstanceServiceSoap
 * @generated
 */
public class ConsumerExtensionInstanceSoap implements Serializable {
	public static ConsumerExtensionInstanceSoap toSoapModel(
		ConsumerExtensionInstance model) {
		ConsumerExtensionInstanceSoap soapModel = new ConsumerExtensionInstanceSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setConsumerExtensionInstanceId(model.getConsumerExtensionInstanceId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setConsumerExtensionKey(model.getConsumerExtensionKey());
		soapModel.setConsumerId(model.getConsumerId());
		soapModel.setTypeSettings(model.getTypeSettings());

		return soapModel;
	}

	public static ConsumerExtensionInstanceSoap[] toSoapModels(
		ConsumerExtensionInstance[] models) {
		ConsumerExtensionInstanceSoap[] soapModels = new ConsumerExtensionInstanceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ConsumerExtensionInstanceSoap[][] toSoapModels(
		ConsumerExtensionInstance[][] models) {
		ConsumerExtensionInstanceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ConsumerExtensionInstanceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ConsumerExtensionInstanceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ConsumerExtensionInstanceSoap[] toSoapModels(
		List<ConsumerExtensionInstance> models) {
		List<ConsumerExtensionInstanceSoap> soapModels = new ArrayList<ConsumerExtensionInstanceSoap>(models.size());

		for (ConsumerExtensionInstance model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ConsumerExtensionInstanceSoap[soapModels.size()]);
	}

	public ConsumerExtensionInstanceSoap() {
	}

	public long getPrimaryKey() {
		return _consumerExtensionInstanceId;
	}

	public void setPrimaryKey(long pk) {
		setConsumerExtensionInstanceId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getConsumerExtensionInstanceId() {
		return _consumerExtensionInstanceId;
	}

	public void setConsumerExtensionInstanceId(long consumerExtensionInstanceId) {
		_consumerExtensionInstanceId = consumerExtensionInstanceId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getConsumerExtensionKey() {
		return _consumerExtensionKey;
	}

	public void setConsumerExtensionKey(String consumerExtensionKey) {
		_consumerExtensionKey = consumerExtensionKey;
	}

	public long getConsumerId() {
		return _consumerId;
	}

	public void setConsumerId(long consumerId) {
		_consumerId = consumerId;
	}

	public String getTypeSettings() {
		return _typeSettings;
	}

	public void setTypeSettings(String typeSettings) {
		_typeSettings = typeSettings;
	}

	private String _uuid;
	private long _consumerExtensionInstanceId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _consumerExtensionKey;
	private long _consumerId;
	private String _typeSettings;
}