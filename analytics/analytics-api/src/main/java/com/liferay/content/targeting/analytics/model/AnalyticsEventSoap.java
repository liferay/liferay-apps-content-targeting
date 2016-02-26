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

package com.liferay.content.targeting.analytics.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.content.targeting.analytics.service.http.AnalyticsEventServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.analytics.service.http.AnalyticsEventServiceSoap
 * @generated
 */
@ProviderType
public class AnalyticsEventSoap implements Serializable {
	public static AnalyticsEventSoap toSoapModel(AnalyticsEvent model) {
		AnalyticsEventSoap soapModel = new AnalyticsEventSoap();

		soapModel.setAnalyticsEventId(model.getAnalyticsEventId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setAnonymousUserId(model.getAnonymousUserId());
		soapModel.setClassName(model.getClassName());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setElementId(model.getElementId());
		soapModel.setEventType(model.getEventType());
		soapModel.setClientIP(model.getClientIP());
		soapModel.setUserAgent(model.getUserAgent());
		soapModel.setLanguageId(model.getLanguageId());
		soapModel.setURL(model.getURL());
		soapModel.setAdditionalInfo(model.getAdditionalInfo());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static AnalyticsEventSoap[] toSoapModels(AnalyticsEvent[] models) {
		AnalyticsEventSoap[] soapModels = new AnalyticsEventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnalyticsEventSoap[][] toSoapModels(AnalyticsEvent[][] models) {
		AnalyticsEventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnalyticsEventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnalyticsEventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnalyticsEventSoap[] toSoapModels(List<AnalyticsEvent> models) {
		List<AnalyticsEventSoap> soapModels = new ArrayList<AnalyticsEventSoap>(models.size());

		for (AnalyticsEvent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnalyticsEventSoap[soapModels.size()]);
	}

	public AnalyticsEventSoap() {
	}

	public long getPrimaryKey() {
		return _analyticsEventId;
	}

	public void setPrimaryKey(long pk) {
		setAnalyticsEventId(pk);
	}

	public long getAnalyticsEventId() {
		return _analyticsEventId;
	}

	public void setAnalyticsEventId(long analyticsEventId) {
		_analyticsEventId = analyticsEventId;
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

	public long getAnonymousUserId() {
		return _anonymousUserId;
	}

	public void setAnonymousUserId(long anonymousUserId) {
		_anonymousUserId = anonymousUserId;
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

	public String getClientIP() {
		return _clientIP;
	}

	public void setClientIP(String clientIP) {
		_clientIP = clientIP;
	}

	public String getUserAgent() {
		return _userAgent;
	}

	public void setUserAgent(String userAgent) {
		_userAgent = userAgent;
	}

	public String getLanguageId() {
		return _languageId;
	}

	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	public String getURL() {
		return _URL;
	}

	public void setURL(String URL) {
		_URL = URL;
	}

	public String getAdditionalInfo() {
		return _additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		_additionalInfo = additionalInfo;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private long _analyticsEventId;
	private long _companyId;
	private long _userId;
	private long _anonymousUserId;
	private String _className;
	private long _classPK;
	private String _elementId;
	private String _eventType;
	private String _clientIP;
	private String _userAgent;
	private String _languageId;
	private String _URL;
	private String _additionalInfo;
	private Date _createDate;
}