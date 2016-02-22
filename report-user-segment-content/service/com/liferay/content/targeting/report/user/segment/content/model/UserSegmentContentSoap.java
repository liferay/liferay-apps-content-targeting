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

package com.liferay.content.targeting.report.user.segment.content.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.content.targeting.report.user.segment.content.service.http.UserSegmentContentServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.report.user.segment.content.service.http.UserSegmentContentServiceSoap
 * @generated
 */
@ProviderType
public class UserSegmentContentSoap implements Serializable {
	public static UserSegmentContentSoap toSoapModel(UserSegmentContent model) {
		UserSegmentContentSoap soapModel = new UserSegmentContentSoap();

		soapModel.setUserSegmentContentId(model.getUserSegmentContentId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserSegmentId(model.getUserSegmentId());
		soapModel.setClassName(model.getClassName());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setEventType(model.getEventType());
		soapModel.setCount(model.getCount());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static UserSegmentContentSoap[] toSoapModels(
		UserSegmentContent[] models) {
		UserSegmentContentSoap[] soapModels = new UserSegmentContentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserSegmentContentSoap[][] toSoapModels(
		UserSegmentContent[][] models) {
		UserSegmentContentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserSegmentContentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserSegmentContentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserSegmentContentSoap[] toSoapModels(
		List<UserSegmentContent> models) {
		List<UserSegmentContentSoap> soapModels = new ArrayList<UserSegmentContentSoap>(models.size());

		for (UserSegmentContent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserSegmentContentSoap[soapModels.size()]);
	}

	public UserSegmentContentSoap() {
	}

	public long getPrimaryKey() {
		return _userSegmentContentId;
	}

	public void setPrimaryKey(long pk) {
		setUserSegmentContentId(pk);
	}

	public long getUserSegmentContentId() {
		return _userSegmentContentId;
	}

	public void setUserSegmentContentId(long userSegmentContentId) {
		_userSegmentContentId = userSegmentContentId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserSegmentId() {
		return _userSegmentId;
	}

	public void setUserSegmentId(long userSegmentId) {
		_userSegmentId = userSegmentId;
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

	private long _userSegmentContentId;
	private long _companyId;
	private long _userSegmentId;
	private String _className;
	private long _classPK;
	private String _eventType;
	private int _count;
	private Date _modifiedDate;
}