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
 * This class is used by SOAP remote services, specifically {@link com.liferay.content.targeting.service.http.ReportInstanceServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.http.ReportInstanceServiceSoap
 * @generated
 */
@ProviderType
public class ReportInstanceSoap implements Serializable {
	public static ReportInstanceSoap toSoapModel(ReportInstance model) {
		ReportInstanceSoap soapModel = new ReportInstanceSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setReportInstanceId(model.getReportInstanceId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setReportKey(model.getReportKey());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setClassName(model.getClassName());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setTypeSettings(model.getTypeSettings());

		return soapModel;
	}

	public static ReportInstanceSoap[] toSoapModels(ReportInstance[] models) {
		ReportInstanceSoap[] soapModels = new ReportInstanceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ReportInstanceSoap[][] toSoapModels(ReportInstance[][] models) {
		ReportInstanceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ReportInstanceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ReportInstanceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ReportInstanceSoap[] toSoapModels(List<ReportInstance> models) {
		List<ReportInstanceSoap> soapModels = new ArrayList<ReportInstanceSoap>(models.size());

		for (ReportInstance model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ReportInstanceSoap[soapModels.size()]);
	}

	public ReportInstanceSoap() {
	}

	public long getPrimaryKey() {
		return _reportInstanceId;
	}

	public void setPrimaryKey(long pk) {
		setReportInstanceId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getReportInstanceId() {
		return _reportInstanceId;
	}

	public void setReportInstanceId(long reportInstanceId) {
		_reportInstanceId = reportInstanceId;
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

	public String getReportKey() {
		return _reportKey;
	}

	public void setReportKey(String reportKey) {
		_reportKey = reportKey;
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

	public String getTypeSettings() {
		return _typeSettings;
	}

	public void setTypeSettings(String typeSettings) {
		_typeSettings = typeSettings;
	}

	private String _uuid;
	private long _reportInstanceId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _reportKey;
	private String _name;
	private String _description;
	private String _className;
	private long _classPK;
	private String _typeSettings;
}