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

package com.liferay.content.targeting.report.campaign.content.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.content.targeting.report.campaign.content.service.http.CampaignContentServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.report.campaign.content.service.http.CampaignContentServiceSoap
 * @generated
 */
@ProviderType
public class CampaignContentSoap implements Serializable {
	public static CampaignContentSoap toSoapModel(CampaignContent model) {
		CampaignContentSoap soapModel = new CampaignContentSoap();

		soapModel.setCampaignContentId(model.getCampaignContentId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCampaignId(model.getCampaignId());
		soapModel.setClassName(model.getClassName());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setEventType(model.getEventType());
		soapModel.setCount(model.getCount());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static CampaignContentSoap[] toSoapModels(CampaignContent[] models) {
		CampaignContentSoap[] soapModels = new CampaignContentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CampaignContentSoap[][] toSoapModels(
		CampaignContent[][] models) {
		CampaignContentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CampaignContentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CampaignContentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CampaignContentSoap[] toSoapModels(
		List<CampaignContent> models) {
		List<CampaignContentSoap> soapModels = new ArrayList<CampaignContentSoap>(models.size());

		for (CampaignContent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CampaignContentSoap[soapModels.size()]);
	}

	public CampaignContentSoap() {
	}

	public long getPrimaryKey() {
		return _campaignContentId;
	}

	public void setPrimaryKey(long pk) {
		setCampaignContentId(pk);
	}

	public long getCampaignContentId() {
		return _campaignContentId;
	}

	public void setCampaignContentId(long campaignContentId) {
		_campaignContentId = campaignContentId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getCampaignId() {
		return _campaignId;
	}

	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;
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

	public String getEventType() {
		return _eventType;
	}

	public void setEventType(String eventType) {
		_eventType = eventType;
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

	private long _campaignContentId;
	private long _companyId;
	private long _campaignId;
	private String _className;
	private long _classPK;
	private String _eventType;
	private int _count;
	private Date _modifiedDate;
}