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

package com.liferay.content.targeting.anonymous.users.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.content.targeting.anonymous.users.service.http.AnonymousUserServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.anonymous.users.service.http.AnonymousUserServiceSoap
 * @generated
 */
@ProviderType
public class AnonymousUserSoap implements Serializable {
	public static AnonymousUserSoap toSoapModel(AnonymousUser model) {
		AnonymousUserSoap soapModel = new AnonymousUserSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAnonymousUserId(model.getAnonymousUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLastIp(model.getLastIp());
		soapModel.setTypeSettings(model.getTypeSettings());

		return soapModel;
	}

	public static AnonymousUserSoap[] toSoapModels(AnonymousUser[] models) {
		AnonymousUserSoap[] soapModels = new AnonymousUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnonymousUserSoap[][] toSoapModels(AnonymousUser[][] models) {
		AnonymousUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnonymousUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnonymousUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnonymousUserSoap[] toSoapModels(List<AnonymousUser> models) {
		List<AnonymousUserSoap> soapModels = new ArrayList<AnonymousUserSoap>(models.size());

		for (AnonymousUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnonymousUserSoap[soapModels.size()]);
	}

	public AnonymousUserSoap() {
	}

	public long getPrimaryKey() {
		return _anonymousUserId;
	}

	public void setPrimaryKey(long pk) {
		setAnonymousUserId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAnonymousUserId() {
		return _anonymousUserId;
	}

	public void setAnonymousUserId(long anonymousUserId) {
		_anonymousUserId = anonymousUserId;
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

	public String getLastIp() {
		return _lastIp;
	}

	public void setLastIp(String lastIp) {
		_lastIp = lastIp;
	}

	public String getTypeSettings() {
		return _typeSettings;
	}

	public void setTypeSettings(String typeSettings) {
		_typeSettings = typeSettings;
	}

	private String _uuid;
	private long _anonymousUserId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _lastIp;
	private String _typeSettings;
}