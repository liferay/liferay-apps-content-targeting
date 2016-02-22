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
 * This class is used by SOAP remote services, specifically {@link com.liferay.content.targeting.service.http.RuleInstanceServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.http.RuleInstanceServiceSoap
 * @generated
 */
@ProviderType
public class RuleInstanceSoap implements Serializable {
	public static RuleInstanceSoap toSoapModel(RuleInstance model) {
		RuleInstanceSoap soapModel = new RuleInstanceSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setRuleInstanceId(model.getRuleInstanceId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRuleKey(model.getRuleKey());
		soapModel.setUserSegmentId(model.getUserSegmentId());
		soapModel.setTypeSettings(model.getTypeSettings());

		return soapModel;
	}

	public static RuleInstanceSoap[] toSoapModels(RuleInstance[] models) {
		RuleInstanceSoap[] soapModels = new RuleInstanceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RuleInstanceSoap[][] toSoapModels(RuleInstance[][] models) {
		RuleInstanceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RuleInstanceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RuleInstanceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RuleInstanceSoap[] toSoapModels(List<RuleInstance> models) {
		List<RuleInstanceSoap> soapModels = new ArrayList<RuleInstanceSoap>(models.size());

		for (RuleInstance model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RuleInstanceSoap[soapModels.size()]);
	}

	public RuleInstanceSoap() {
	}

	public long getPrimaryKey() {
		return _ruleInstanceId;
	}

	public void setPrimaryKey(long pk) {
		setRuleInstanceId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getRuleInstanceId() {
		return _ruleInstanceId;
	}

	public void setRuleInstanceId(long ruleInstanceId) {
		_ruleInstanceId = ruleInstanceId;
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

	public String getRuleKey() {
		return _ruleKey;
	}

	public void setRuleKey(String ruleKey) {
		_ruleKey = ruleKey;
	}

	public long getUserSegmentId() {
		return _userSegmentId;
	}

	public void setUserSegmentId(long userSegmentId) {
		_userSegmentId = userSegmentId;
	}

	public String getTypeSettings() {
		return _typeSettings;
	}

	public void setTypeSettings(String typeSettings) {
		_typeSettings = typeSettings;
	}

	private String _uuid;
	private long _ruleInstanceId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _ruleKey;
	private long _userSegmentId;
	private String _typeSettings;
}