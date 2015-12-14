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
 * This class is used by SOAP remote services, specifically {@link com.liferay.content.targeting.service.http.ChannelInstanceServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.http.ChannelInstanceServiceSoap
 * @generated
 */
@ProviderType
public class ChannelInstanceSoap implements Serializable {
	public static ChannelInstanceSoap toSoapModel(ChannelInstance model) {
		ChannelInstanceSoap soapModel = new ChannelInstanceSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setChannelInstanceId(model.getChannelInstanceId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setChannelKey(model.getChannelKey());
		soapModel.setCampaignId(model.getCampaignId());
		soapModel.setTacticId(model.getTacticId());
		soapModel.setAlias(model.getAlias());
		soapModel.setTypeSettings(model.getTypeSettings());

		return soapModel;
	}

	public static ChannelInstanceSoap[] toSoapModels(ChannelInstance[] models) {
		ChannelInstanceSoap[] soapModels = new ChannelInstanceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChannelInstanceSoap[][] toSoapModels(
		ChannelInstance[][] models) {
		ChannelInstanceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ChannelInstanceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChannelInstanceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChannelInstanceSoap[] toSoapModels(
		List<ChannelInstance> models) {
		List<ChannelInstanceSoap> soapModels = new ArrayList<ChannelInstanceSoap>(models.size());

		for (ChannelInstance model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChannelInstanceSoap[soapModels.size()]);
	}

	public ChannelInstanceSoap() {
	}

	public long getPrimaryKey() {
		return _channelInstanceId;
	}

	public void setPrimaryKey(long pk) {
		setChannelInstanceId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getChannelInstanceId() {
		return _channelInstanceId;
	}

	public void setChannelInstanceId(long channelInstanceId) {
		_channelInstanceId = channelInstanceId;
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

	public String getChannelKey() {
		return _channelKey;
	}

	public void setChannelKey(String channelKey) {
		_channelKey = channelKey;
	}

	public long getCampaignId() {
		return _campaignId;
	}

	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;
	}

	public long getTacticId() {
		return _tacticId;
	}

	public void setTacticId(long tacticId) {
		_tacticId = tacticId;
	}

	public String getAlias() {
		return _alias;
	}

	public void setAlias(String alias) {
		_alias = alias;
	}

	public String getTypeSettings() {
		return _typeSettings;
	}

	public void setTypeSettings(String typeSettings) {
		_typeSettings = typeSettings;
	}

	private String _uuid;
	private long _channelInstanceId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _channelKey;
	private long _campaignId;
	private long _tacticId;
	private String _alias;
	private String _typeSettings;
}