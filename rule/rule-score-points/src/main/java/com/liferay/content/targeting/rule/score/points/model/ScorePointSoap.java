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

package com.liferay.content.targeting.rule.score.points.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.content.targeting.rule.score.points.service.http.ScorePointServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.rule.score.points.service.http.ScorePointServiceSoap
 * @generated
 */
@ProviderType
public class ScorePointSoap implements Serializable {
	public static ScorePointSoap toSoapModel(ScorePoint model) {
		ScorePointSoap soapModel = new ScorePointSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setScorePointId(model.getScorePointId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAnonymousUserId(model.getAnonymousUserId());
		soapModel.setUserSegmentId(model.getUserSegmentId());
		soapModel.setPoints(model.getPoints());

		return soapModel;
	}

	public static ScorePointSoap[] toSoapModels(ScorePoint[] models) {
		ScorePointSoap[] soapModels = new ScorePointSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ScorePointSoap[][] toSoapModels(ScorePoint[][] models) {
		ScorePointSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ScorePointSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ScorePointSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ScorePointSoap[] toSoapModels(List<ScorePoint> models) {
		List<ScorePointSoap> soapModels = new ArrayList<ScorePointSoap>(models.size());

		for (ScorePoint model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ScorePointSoap[soapModels.size()]);
	}

	public ScorePointSoap() {
	}

	public long getPrimaryKey() {
		return _scorePointId;
	}

	public void setPrimaryKey(long pk) {
		setScorePointId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getScorePointId() {
		return _scorePointId;
	}

	public void setScorePointId(long scorePointId) {
		_scorePointId = scorePointId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public long getPoints() {
		return _points;
	}

	public void setPoints(long points) {
		_points = points;
	}

	private String _uuid;
	private long _scorePointId;
	private long _companyId;
	private long _anonymousUserId;
	private long _userSegmentId;
	private long _points;
}