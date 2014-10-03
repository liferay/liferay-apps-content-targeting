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

package com.liferay.content.targeting.report.campaign.newsletter.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.content.targeting.report.campaign.newsletter.service.http.NewsletterServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.report.campaign.newsletter.service.http.NewsletterServiceSoap
 * @generated
 */
public class NewsletterSoap implements Serializable {
	public static NewsletterSoap toSoapModel(Newsletter model) {
		NewsletterSoap soapModel = new NewsletterSoap();

		soapModel.setNewsletterId(model.getNewsletterId());
		soapModel.setCampaignId(model.getCampaignId());
		soapModel.setAlias(model.getAlias());
		soapModel.setElementId(model.getElementId());
		soapModel.setEventType(model.getEventType());
		soapModel.setCount(model.getCount());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static NewsletterSoap[] toSoapModels(Newsletter[] models) {
		NewsletterSoap[] soapModels = new NewsletterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NewsletterSoap[][] toSoapModels(Newsletter[][] models) {
		NewsletterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NewsletterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NewsletterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NewsletterSoap[] toSoapModels(List<Newsletter> models) {
		List<NewsletterSoap> soapModels = new ArrayList<NewsletterSoap>(models.size());

		for (Newsletter model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NewsletterSoap[soapModels.size()]);
	}

	public NewsletterSoap() {
	}

	public long getPrimaryKey() {
		return _newsletterId;
	}

	public void setPrimaryKey(long pk) {
		setNewsletterId(pk);
	}

	public long getNewsletterId() {
		return _newsletterId;
	}

	public void setNewsletterId(long newsletterId) {
		_newsletterId = newsletterId;
	}

	public long getCampaignId() {
		return _campaignId;
	}

	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;
	}

	public String getAlias() {
		return _alias;
	}

	public void setAlias(String alias) {
		_alias = alias;
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

	private long _newsletterId;
	private long _campaignId;
	private String _alias;
	private String _elementId;
	private String _eventType;
	private int _count;
	private Date _modifiedDate;
}