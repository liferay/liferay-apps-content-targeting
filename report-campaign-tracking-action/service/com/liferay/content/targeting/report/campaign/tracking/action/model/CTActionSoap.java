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

package com.liferay.content.targeting.report.campaign.tracking.action.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.content.targeting.report.campaign.tracking.action.service.http.CTActionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.http.CTActionServiceSoap
 * @generated
 */
public class CTActionSoap implements Serializable {
	public static CTActionSoap toSoapModel(CTAction model) {
		CTActionSoap soapModel = new CTActionSoap();

		soapModel.setCTActionId(model.getCTActionId());
		soapModel.setCampaignId(model.getCampaignId());
		soapModel.setUserSegmentId(model.getUserSegmentId());
		soapModel.setAlias(model.getAlias());
		soapModel.setReferrerClassName(model.getReferrerClassName());
		soapModel.setReferrerClassPK(model.getReferrerClassPK());
		soapModel.setElementId(model.getElementId());
		soapModel.setEventType(model.getEventType());
		soapModel.setCount(model.getCount());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static CTActionSoap[] toSoapModels(CTAction[] models) {
		CTActionSoap[] soapModels = new CTActionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CTActionSoap[][] toSoapModels(CTAction[][] models) {
		CTActionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CTActionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CTActionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CTActionSoap[] toSoapModels(List<CTAction> models) {
		List<CTActionSoap> soapModels = new ArrayList<CTActionSoap>(models.size());

		for (CTAction model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CTActionSoap[soapModels.size()]);
	}

	public CTActionSoap() {
	}

	public long getPrimaryKey() {
		return _CTActionId;
	}

	public void setPrimaryKey(long pk) {
		setCTActionId(pk);
	}

	public long getCTActionId() {
		return _CTActionId;
	}

	public void setCTActionId(long CTActionId) {
		_CTActionId = CTActionId;
	}

	public long getCampaignId() {
		return _campaignId;
	}

	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;
	}

	public long getUserSegmentId() {
		return _userSegmentId;
	}

	public void setUserSegmentId(long userSegmentId) {
		_userSegmentId = userSegmentId;
	}

	public String getAlias() {
		return _alias;
	}

	public void setAlias(String alias) {
		_alias = alias;
	}

	public String getReferrerClassName() {
		return _referrerClassName;
	}

	public void setReferrerClassName(String referrerClassName) {
		_referrerClassName = referrerClassName;
	}

	public long getReferrerClassPK() {
		return _referrerClassPK;
	}

	public void setReferrerClassPK(long referrerClassPK) {
		_referrerClassPK = referrerClassPK;
	}

	public String getElementId() {
		return _elementId;
	}

	public void setElementId(String elementId) {
		_elementId = elementId;
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

	private long _CTActionId;
	private long _campaignId;
	private long _userSegmentId;
	private String _alias;
	private String _referrerClassName;
	private long _referrerClassPK;
	private String _elementId;
	private String _eventType;
	private int _count;
	private Date _modifiedDate;
}