/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.service.http;

import com.liferay.contenttargeting.service.CampaignServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;

import java.rmi.RemoteException;

import java.util.Locale;
import java.util.Map;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.contenttargeting.service.CampaignServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.contenttargeting.model.CampaignSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.contenttargeting.model.Campaign}, that is translated to a
 * {@link com.liferay.contenttargeting.model.CampaignSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignServiceHttp
 * @see com.liferay.contenttargeting.model.CampaignSoap
 * @see com.liferay.contenttargeting.service.CampaignServiceUtil
 * @generated
 */
public class CampaignServiceSoap {
	public static com.liferay.contenttargeting.model.CampaignSoap addCampaign(
		long userId, java.lang.String[] nameMapLanguageIds,
		java.lang.String[] nameMapValues,
		java.lang.String[] descriptionMapLanguageIds,
		java.lang.String[] descriptionMapValues, java.util.Date startDate,
		java.util.Date endDate, int priority, long[] userSegmentIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(nameMapLanguageIds,
					nameMapValues);
			Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(descriptionMapLanguageIds,
					descriptionMapValues);

			com.liferay.contenttargeting.model.Campaign returnValue = CampaignServiceUtil.addCampaign(userId,
					nameMap, descriptionMap, startDate, endDate, priority,
					userSegmentIds, serviceContext);

			return com.liferay.contenttargeting.model.CampaignSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contenttargeting.model.CampaignSoap deleteCampaign(
		long campaignId) throws RemoteException {
		try {
			com.liferay.contenttargeting.model.Campaign returnValue = CampaignServiceUtil.deleteCampaign(campaignId);

			return com.liferay.contenttargeting.model.CampaignSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contenttargeting.model.CampaignSoap fetchCurrentMaxPriorityCampaign(
		long groupId, long[] userSegmentIds) throws RemoteException {
		try {
			com.liferay.contenttargeting.model.Campaign returnValue = CampaignServiceUtil.fetchCurrentMaxPriorityCampaign(groupId,
					userSegmentIds);

			return com.liferay.contenttargeting.model.CampaignSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contenttargeting.model.CampaignSoap[] getCampaigns(
		long groupId) throws RemoteException {
		try {
			java.util.List<com.liferay.contenttargeting.model.Campaign> returnValue =
				CampaignServiceUtil.getCampaigns(groupId);

			return com.liferay.contenttargeting.model.CampaignSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static long getCampaignsCount(long groupId)
		throws RemoteException {
		try {
			long returnValue = CampaignServiceUtil.getCampaignsCount(groupId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contenttargeting.model.CampaignSoap updateCampaign(
		long campaignId, java.lang.String[] nameMapLanguageIds,
		java.lang.String[] nameMapValues,
		java.lang.String[] descriptionMapLanguageIds,
		java.lang.String[] descriptionMapValues, java.util.Date startDate,
		java.util.Date endDate, int priority, long[] userSegmentIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(nameMapLanguageIds,
					nameMapValues);
			Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(descriptionMapLanguageIds,
					descriptionMapValues);

			com.liferay.contenttargeting.model.Campaign returnValue = CampaignServiceUtil.updateCampaign(campaignId,
					nameMap, descriptionMap, startDate, endDate, priority,
					userSegmentIds, serviceContext);

			return com.liferay.contenttargeting.model.CampaignSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CampaignServiceSoap.class);
}