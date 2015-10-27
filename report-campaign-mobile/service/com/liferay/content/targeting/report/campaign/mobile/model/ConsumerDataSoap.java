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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.content.targeting.report.campaign.mobile.service.http.ConsumerDataServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.report.campaign.mobile.service.http.ConsumerDataServiceSoap
 * @generated
 */
public class ConsumerDataSoap implements Serializable {
	public static ConsumerDataSoap toSoapModel(ConsumerData model) {
		ConsumerDataSoap soapModel = new ConsumerDataSoap();

		soapModel.setConsumerDataId(model.getConsumerDataId());
		soapModel.setCampaignId(model.getCampaignId());
		soapModel.setCount(model.getCount());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEventType(model.getEventType());
		soapModel.setElementId(model.getElementId());
		soapModel.setConsumerId(model.getConsumerId());

		return soapModel;
	}

	public static ConsumerDataSoap[] toSoapModels(ConsumerData[] models) {
		ConsumerDataSoap[] soapModels = new ConsumerDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ConsumerDataSoap[][] toSoapModels(ConsumerData[][] models) {
		ConsumerDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ConsumerDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ConsumerDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ConsumerDataSoap[] toSoapModels(List<ConsumerData> models) {
		List<ConsumerDataSoap> soapModels = new ArrayList<ConsumerDataSoap>(models.size());

		for (ConsumerData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ConsumerDataSoap[soapModels.size()]);
	}

	public ConsumerDataSoap() {
	}

	public long getPrimaryKey() {
		return _consumerDataId;
	}

	public void setPrimaryKey(long pk) {
		setConsumerDataId(pk);
	}

	public long getConsumerDataId() {
		return _consumerDataId;
	}

	public void setConsumerDataId(long consumerDataId) {
		_consumerDataId = consumerDataId;
	}

	public long getCampaignId() {
		return _campaignId;
	}

	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;
	}

	public int getCount() {
		return _count;
	}

	public void setCount(int count) {
		_count = count;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getEventType() {
		return _eventType;
	}

	public void setEventType(String eventType) {
		_eventType = eventType;
	}

	public String getElementId() {
		return _elementId;
	}

	public void setElementId(String elementId) {
		_elementId = elementId;
	}

	public long getConsumerId() {
		return _consumerId;
	}

	public void setConsumerId(long consumerId) {
		_consumerId = consumerId;
	}

	private long _consumerDataId;
	private long _campaignId;
	private int _count;
	private Date _modifiedDate;
	private String _eventType;
	private String _elementId;
	private long _consumerId;
}