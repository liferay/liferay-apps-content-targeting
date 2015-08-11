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
 * This class is used by SOAP remote services, specifically {@link com.liferay.consumer.manager.service.http.ConsumerServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.consumer.manager.service.http.ConsumerServiceSoap
 * @generated
 */
public class ConsumerSoap implements Serializable {
	public static ConsumerSoap toSoapModel(Consumer model) {
		ConsumerSoap soapModel = new ConsumerSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setConsumerId(model.getConsumerId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setConsumerKey(model.getConsumerKey());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ConsumerSoap[] toSoapModels(Consumer[] models) {
		ConsumerSoap[] soapModels = new ConsumerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ConsumerSoap[][] toSoapModels(Consumer[][] models) {
		ConsumerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ConsumerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ConsumerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ConsumerSoap[] toSoapModels(List<Consumer> models) {
		List<ConsumerSoap> soapModels = new ArrayList<ConsumerSoap>(models.size());

		for (Consumer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ConsumerSoap[soapModels.size()]);
	}

	public ConsumerSoap() {
	}

	public long getPrimaryKey() {
		return _consumerId;
	}

	public void setPrimaryKey(long pk) {
		setConsumerId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getConsumerId() {
		return _consumerId;
	}

	public void setConsumerId(long consumerId) {
		_consumerId = consumerId;
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

	public String getConsumerKey() {
		return _consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		_consumerKey = consumerKey;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private String _uuid;
	private long _consumerId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _consumerKey;
	private String _name;
	private String _description;
}