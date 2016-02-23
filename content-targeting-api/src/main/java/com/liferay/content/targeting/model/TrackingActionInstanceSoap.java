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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.content.targeting.service.http.TrackingActionInstanceServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.http.TrackingActionInstanceServiceSoap
 * @generated
 */
@ProviderType
public class TrackingActionInstanceSoap implements Serializable {
	public static TrackingActionInstanceSoap toSoapModel(
		TrackingActionInstance model) {
		TrackingActionInstanceSoap soapModel = new TrackingActionInstanceSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTrackingActionInstanceId(model.getTrackingActionInstanceId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTrackingActionKey(model.getTrackingActionKey());
		soapModel.setCampaignId(model.getCampaignId());
		soapModel.setReportInstanceId(model.getReportInstanceId());
		soapModel.setAlias(model.getAlias());
		soapModel.setReferrerClassName(model.getReferrerClassName());
		soapModel.setReferrerClassPK(model.getReferrerClassPK());
		soapModel.setElementId(model.getElementId());
		soapModel.setEventType(model.getEventType());
		soapModel.setTypeSettings(model.getTypeSettings());

		return soapModel;
	}

	public static TrackingActionInstanceSoap[] toSoapModels(
		TrackingActionInstance[] models) {
		TrackingActionInstanceSoap[] soapModels = new TrackingActionInstanceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TrackingActionInstanceSoap[][] toSoapModels(
		TrackingActionInstance[][] models) {
		TrackingActionInstanceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TrackingActionInstanceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TrackingActionInstanceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TrackingActionInstanceSoap[] toSoapModels(
		List<TrackingActionInstance> models) {
		List<TrackingActionInstanceSoap> soapModels = new ArrayList<TrackingActionInstanceSoap>(models.size());

		for (TrackingActionInstance model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TrackingActionInstanceSoap[soapModels.size()]);
	}

	public TrackingActionInstanceSoap() {
	}

	public long getPrimaryKey() {
		return _trackingActionInstanceId;
	}

	public void setPrimaryKey(long pk) {
		setTrackingActionInstanceId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTrackingActionInstanceId() {
		return _trackingActionInstanceId;
	}

	public void setTrackingActionInstanceId(long trackingActionInstanceId) {
		_trackingActionInstanceId = trackingActionInstanceId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public String getTrackingActionKey() {
		return _trackingActionKey;
	}

	public void setTrackingActionKey(String trackingActionKey) {
		_trackingActionKey = trackingActionKey;
	}

	public long getCampaignId() {
		return _campaignId;
	}

	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;
	}

	public long getReportInstanceId() {
		return _reportInstanceId;
	}

	public void setReportInstanceId(long reportInstanceId) {
		_reportInstanceId = reportInstanceId;
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

	public String getTypeSettings() {
		return _typeSettings;
	}

	public void setTypeSettings(String typeSettings) {
		_typeSettings = typeSettings;
	}

	private String _uuid;
	private long _trackingActionInstanceId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _trackingActionKey;
	private long _campaignId;
	private long _reportInstanceId;
	private String _alias;
	private String _referrerClassName;
	private long _referrerClassPK;
	private String _elementId;
	private String _eventType;
	private String _typeSettings;
}