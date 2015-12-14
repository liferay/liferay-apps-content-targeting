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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.content.targeting.analytics.service.http.AnalyticsReferrerServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.analytics.service.http.AnalyticsReferrerServiceSoap
 * @generated
 */
@ProviderType
public class AnalyticsReferrerSoap implements Serializable {
	public static AnalyticsReferrerSoap toSoapModel(AnalyticsReferrer model) {
		AnalyticsReferrerSoap soapModel = new AnalyticsReferrerSoap();

		soapModel.setAnalyticsReferrerId(model.getAnalyticsReferrerId());
		soapModel.setAnalyticsEventId(model.getAnalyticsEventId());
		soapModel.setReferrerClassName(model.getReferrerClassName());
		soapModel.setReferrerClassPK(model.getReferrerClassPK());

		return soapModel;
	}

	public static AnalyticsReferrerSoap[] toSoapModels(
		AnalyticsReferrer[] models) {
		AnalyticsReferrerSoap[] soapModels = new AnalyticsReferrerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnalyticsReferrerSoap[][] toSoapModels(
		AnalyticsReferrer[][] models) {
		AnalyticsReferrerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnalyticsReferrerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnalyticsReferrerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnalyticsReferrerSoap[] toSoapModels(
		List<AnalyticsReferrer> models) {
		List<AnalyticsReferrerSoap> soapModels = new ArrayList<AnalyticsReferrerSoap>(models.size());

		for (AnalyticsReferrer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnalyticsReferrerSoap[soapModels.size()]);
	}

	public AnalyticsReferrerSoap() {
	}

	public long getPrimaryKey() {
		return _analyticsReferrerId;
	}

	public void setPrimaryKey(long pk) {
		setAnalyticsReferrerId(pk);
	}

	public long getAnalyticsReferrerId() {
		return _analyticsReferrerId;
	}

	public void setAnalyticsReferrerId(long analyticsReferrerId) {
		_analyticsReferrerId = analyticsReferrerId;
	}

	public long getAnalyticsEventId() {
		return _analyticsEventId;
	}

	public void setAnalyticsEventId(long analyticsEventId) {
		_analyticsEventId = analyticsEventId;
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

	private long _analyticsReferrerId;
	private long _analyticsEventId;
	private String _referrerClassName;
	private long _referrerClassPK;
}