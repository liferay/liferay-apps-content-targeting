/**
 * Copyright (c) 2000-2015 Liferay, Inc. All rights reserved.
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

package com.liferay.content.targeting.report.campaign.mobile;

import com.liferay.content.targeting.api.model.BaseReport;
import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile;
import com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData;
import com.liferay.content.targeting.report.campaign.mobile.service.CampaignMobileLocalService;
import com.liferay.content.targeting.report.campaign.mobile.service.ConsumerDataLocalService;
import com.liferay.content.targeting.util.SearchContainerIterator;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.StringPool;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
import java.util.Map;

/**
 * @author Brian Chan
 */
@Component(
	immediate = true, service = Report.class)
public class CampaignMobileReport extends BaseReport {

	public static final String EVENT_TYPE = "eventType";
	public static final String CAMPAIGN_ID = "campaignId";
	public static final String INSTALLATION = "installation";
	public static final String SESSION = "session";
	public static final String SESSION_SCREEN = "sessionOnScreen";
	public static final String AT_ON_SCREEN = "atOnScreen";
	public static final String FORM_SUBMIT = "formSubmit";
	public static final String FORM_VIEW = "formView";
	public static final String FORM_INTERACTION = "formInteraction";
	public static final String VIEW = "view";
	public static final String BUTTON_CLICK = "buttonClick";
	public static final String CLICK = "click";

	@Activate
	@Override
	public void activate() {
		super.activate();
	}

	@Deactivate
	@Override
	public void deActivate() {
		super.deActivate();
	}

	@Override
	public String getIcon() {
		return "icon-puzzle";
	}

	@Override
	public String getReportType() {
		return Campaign.class.getName();
	}

	@Reference
	public void setCampaignMobileLocalService(CampaignMobileLocalService campaignMobileLocalService) {
		_campaignMobileLocalService = campaignMobileLocalService;
	}

	@Reference
	public void setConsumerDataLocalService(ConsumerDataLocalService consumerDataLocalService) {
		_consumerDataLocalService = consumerDataLocalService;
	}

	@Override
	public String updateReport(long classPK) {
		try {
			_campaignMobileLocalService.checkCampaignContentEvents(classPK);
			_consumerDataLocalService.checkConsumerDataEvents(classPK);
		}
		catch (Exception e) {
			_log.error("Cannot update report", e);
		}

		return StringPool.BLANK;
	}

	@Override
	protected void populateContext(ReportInstance reportInstance, Map<String, Object> context) {
		populateContext(context);
	}

	@Override
	protected void populateContext(Map<String, Object> context) {
		final long classPK = MapUtil.getLong(context, "classPK", 0);

		ClassLoader classLoader = getClass().getClassLoader();

		context.put("contentViewsIterator",
			createCampaignMobileIterator(createViewQuery(classPK, classLoader), createViewQuery(classPK, classLoader)));

		context.put("linkAndButtonClicksIterator",
			createCampaignMobileIterator(createClickQuery(classPK, classLoader), createClickQuery(classPK, classLoader)));

		context.put("atOnScreenIterator",
			createCampaignMobileIterator(createOnScreenQuery(classPK), createOnScreenQuery(classPK)));

		context.put("formIterator",
			createConsumerIterator(createFormQuery(), createFormQuery()));

		context.put("appInstallationsIterator",
			createConsumerIterator(createInstallationsQuery(), createInstallationsQuery()));

		context.put("appSessionsIterator",
			createConsumerIterator(createSessionQuery(), createSessionQuery()));

		context.put("sessionScreenIterator",
			createConsumerIterator(createSessionScreenQuery(), createSessionScreenQuery()));
	}

	private DynamicQuery createViewQuery(long classPK, ClassLoader classLoader) {
		return DynamicQueryFactoryUtil.forClass(CampaignMobile.class, classLoader)
			.add(PropertyFactoryUtil.forName(EVENT_TYPE).eq(VIEW))
			.add(PropertyFactoryUtil.forName(CAMPAIGN_ID).eq(classPK));
	}

	private DynamicQuery createClickQuery(long classPK, ClassLoader classLoader) {
		Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
		disjunction.add(PropertyFactoryUtil.forName(EVENT_TYPE).eq(BUTTON_CLICK));
		disjunction.add(PropertyFactoryUtil.forName(EVENT_TYPE).eq(CLICK));

		return DynamicQueryFactoryUtil.forClass(CampaignMobile.class, classLoader)
			.add(disjunction)
			.add(PropertyFactoryUtil.forName(CAMPAIGN_ID).eq(classPK));
	}

	private DynamicQuery createOnScreenQuery(long classPK) {
		ClassLoader classLoader = getClass().getClassLoader();
		return DynamicQueryFactoryUtil.forClass(CampaignMobile.class, classLoader)
			.add(PropertyFactoryUtil.forName(CAMPAIGN_ID).eq(classPK))
			.add(PropertyFactoryUtil.forName(EVENT_TYPE).eq(AT_ON_SCREEN));
	}

	private DynamicQuery createFormQuery() {
		ClassLoader classLoader = getClass().getClassLoader();
		Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
		disjunction.add(PropertyFactoryUtil.forName(EVENT_TYPE).eq(FORM_SUBMIT));
		disjunction.add(PropertyFactoryUtil.forName(EVENT_TYPE).eq(FORM_VIEW));
		disjunction.add(PropertyFactoryUtil.forName(EVENT_TYPE).eq(FORM_INTERACTION));

		return DynamicQueryFactoryUtil.forClass(ConsumerData.class, classLoader)
			.add(disjunction);
	}

	private DynamicQuery createQuery(String eventType) {
		ClassLoader classLoader = getClass().getClassLoader();
		return DynamicQueryFactoryUtil.forClass(ConsumerData.class, classLoader)
			.add(PropertyFactoryUtil.forName(EVENT_TYPE).eq(eventType));
	}

	private DynamicQuery createInstallationsQuery() {
		return createQuery(INSTALLATION);
	}

	private DynamicQuery createSessionQuery() {
		return createQuery(SESSION);
	}

	private DynamicQuery createSessionScreenQuery() {
		return createQuery(SESSION_SCREEN);
	}

	private SearchContainerIterator<CampaignMobile> createCampaignMobileIterator(final DynamicQuery query, final DynamicQuery count) {
		return new SearchContainerIterator<CampaignMobile>() {
			@Override
			public List<CampaignMobile> getResults(int start, int end)
				throws PortalException, SystemException {
				return _campaignMobileLocalService.dynamicQuery(query, start, end);
			}

			@Override
			public int getTotal() throws PortalException, SystemException {
				return (int) _campaignMobileLocalService.dynamicQueryCount(count);
			}
		};
	}

	private SearchContainerIterator<ConsumerData> createConsumerIterator(final DynamicQuery query, final DynamicQuery count) {
		return new SearchContainerIterator<ConsumerData>() {
			@Override
			public List<ConsumerData> getResults(int start, int end)
				throws PortalException, SystemException {
				return _consumerDataLocalService.dynamicQuery(query, start, end);
			}

			@Override
			public int getTotal() throws PortalException, SystemException {
				return (int) _consumerDataLocalService.dynamicQueryCount(count);
			}
		};
	}

	private static Log _log = LogFactoryUtil.getLog(CampaignMobileReport.class);

	private CampaignMobileLocalService _campaignMobileLocalService;
	private ConsumerDataLocalService _consumerDataLocalService;

}