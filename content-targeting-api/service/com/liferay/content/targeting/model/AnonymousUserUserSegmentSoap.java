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
 * This class is used by SOAP remote services, specifically {@link com.liferay.content.targeting.service.http.AnonymousUserUserSegmentServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.http.AnonymousUserUserSegmentServiceSoap
 * @generated
 */
@ProviderType
public class AnonymousUserUserSegmentSoap implements Serializable {
	public static AnonymousUserUserSegmentSoap toSoapModel(
		AnonymousUserUserSegment model) {
		AnonymousUserUserSegmentSoap soapModel = new AnonymousUserUserSegmentSoap();

		soapModel.setAnonymousUserUserSegmentId(model.getAnonymousUserUserSegmentId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAnonymousUserId(model.getAnonymousUserId());
		soapModel.setUserSegmentId(model.getUserSegmentId());
		soapModel.setManual(model.getManual());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static AnonymousUserUserSegmentSoap[] toSoapModels(
		AnonymousUserUserSegment[] models) {
		AnonymousUserUserSegmentSoap[] soapModels = new AnonymousUserUserSegmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnonymousUserUserSegmentSoap[][] toSoapModels(
		AnonymousUserUserSegment[][] models) {
		AnonymousUserUserSegmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnonymousUserUserSegmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnonymousUserUserSegmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnonymousUserUserSegmentSoap[] toSoapModels(
		List<AnonymousUserUserSegment> models) {
		List<AnonymousUserUserSegmentSoap> soapModels = new ArrayList<AnonymousUserUserSegmentSoap>(models.size());

		for (AnonymousUserUserSegment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnonymousUserUserSegmentSoap[soapModels.size()]);
	}

	public AnonymousUserUserSegmentSoap() {
	}

	public long getPrimaryKey() {
		return _anonymousUserUserSegmentId;
	}

	public void setPrimaryKey(long pk) {
		setAnonymousUserUserSegmentId(pk);
	}

	public long getAnonymousUserUserSegmentId() {
		return _anonymousUserUserSegmentId;
	}

	public void setAnonymousUserUserSegmentId(long anonymousUserUserSegmentId) {
		_anonymousUserUserSegmentId = anonymousUserUserSegmentId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getAnonymousUserId() {
		return _anonymousUserId;
	}

	public void setAnonymousUserId(long anonymousUserId) {
		_anonymousUserId = anonymousUserId;
	}

	public long getUserSegmentId() {
		return _userSegmentId;
	}

	public void setUserSegmentId(long userSegmentId) {
		_userSegmentId = userSegmentId;
	}

	public boolean getManual() {
		return _manual;
	}

	public boolean isManual() {
		return _manual;
	}

	public void setManual(boolean manual) {
		_manual = manual;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	private long _anonymousUserUserSegmentId;
	private long _companyId;
	private Date _modifiedDate;
	private long _anonymousUserId;
	private long _userSegmentId;
	private boolean _manual;
	private boolean _active;
}