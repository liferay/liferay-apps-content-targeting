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

package com.liferay.portal.contenttargeting.report.campaigntrackingaction.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.portal.contenttargeting.report.campaigntrackingaction.service.http.CampaignTrackingActionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portal.contenttargeting.report.campaigntrackingaction.service.http.CampaignTrackingActionServiceSoap
 * @generated
 */
public class CampaignTrackingActionSoap implements Serializable {
	public static CampaignTrackingActionSoap toSoapModel(
		CampaignTrackingAction model) {
		CampaignTrackingActionSoap soapModel = new CampaignTrackingActionSoap();

		soapModel.setCampaignTrackingActionId(model.getCampaignTrackingActionId());
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

	public static CampaignTrackingActionSoap[] toSoapModels(
		CampaignTrackingAction[] models) {
		CampaignTrackingActionSoap[] soapModels = new CampaignTrackingActionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CampaignTrackingActionSoap[][] toSoapModels(
		CampaignTrackingAction[][] models) {
		CampaignTrackingActionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CampaignTrackingActionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CampaignTrackingActionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CampaignTrackingActionSoap[] toSoapModels(
		List<CampaignTrackingAction> models) {
		List<CampaignTrackingActionSoap> soapModels = new ArrayList<CampaignTrackingActionSoap>(models.size());

		for (CampaignTrackingAction model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CampaignTrackingActionSoap[soapModels.size()]);
	}

	public CampaignTrackingActionSoap() {
	}

	public long getPrimaryKey() {
		return _campaignTrackingActionId;
	}

	public void setPrimaryKey(long pk) {
		setCampaignTrackingActionId(pk);
	}

	public long getCampaignTrackingActionId() {
		return _campaignTrackingActionId;
	}

	public void setCampaignTrackingActionId(long campaignTrackingActionId) {
		_campaignTrackingActionId = campaignTrackingActionId;
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

	private long _campaignTrackingActionId;
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