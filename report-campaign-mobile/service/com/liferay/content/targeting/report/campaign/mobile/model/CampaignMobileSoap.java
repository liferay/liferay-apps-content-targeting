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
 * This class is used by SOAP remote services, specifically {@link com.liferay.content.targeting.report.campaign.mobile.service.http.CampaignMobileServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.report.campaign.mobile.service.http.CampaignMobileServiceSoap
 * @generated
 */
public class CampaignMobileSoap implements Serializable {
	public static CampaignMobileSoap toSoapModel(CampaignMobile model) {
		CampaignMobileSoap soapModel = new CampaignMobileSoap();

		soapModel.setCampaignMobileId(model.getCampaignMobileId());
		soapModel.setCampaignId(model.getCampaignId());
		soapModel.setCount(model.getCount());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEventType(model.getEventType());
		soapModel.setClassName(model.getClassName());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setElementId(model.getElementId());
		soapModel.setConsumerId(model.getConsumerId());
		soapModel.setPlaceholderId(model.getPlaceholderId());
		soapModel.setUserSegmentId(model.getUserSegmentId());

		return soapModel;
	}

	public static CampaignMobileSoap[] toSoapModels(CampaignMobile[] models) {
		CampaignMobileSoap[] soapModels = new CampaignMobileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CampaignMobileSoap[][] toSoapModels(CampaignMobile[][] models) {
		CampaignMobileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CampaignMobileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CampaignMobileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CampaignMobileSoap[] toSoapModels(List<CampaignMobile> models) {
		List<CampaignMobileSoap> soapModels = new ArrayList<CampaignMobileSoap>(models.size());

		for (CampaignMobile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CampaignMobileSoap[soapModels.size()]);
	}

	public CampaignMobileSoap() {
	}

	public long getPrimaryKey() {
		return _campaignMobileId;
	}

	public void setPrimaryKey(long pk) {
		setCampaignMobileId(pk);
	}

	public long getCampaignMobileId() {
		return _campaignMobileId;
	}

	public void setCampaignMobileId(long campaignMobileId) {
		_campaignMobileId = campaignMobileId;
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

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
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

	public long getPlaceholderId() {
		return _placeholderId;
	}

	public void setPlaceholderId(long placeholderId) {
		_placeholderId = placeholderId;
	}

	public long getUserSegmentId() {
		return _userSegmentId;
	}

	public void setUserSegmentId(long userSegmentId) {
		_userSegmentId = userSegmentId;
	}

	private long _campaignMobileId;
	private long _campaignId;
	private int _count;
	private Date _modifiedDate;
	private String _eventType;
	private String _className;
	private long _classPK;
	private String _elementId;
	private long _consumerId;
	private long _placeholderId;
	private long _userSegmentId;
}