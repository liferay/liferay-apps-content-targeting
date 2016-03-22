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

package com.liferay.content.targeting.analytics.service.impl;

import com.liferay.content.targeting.analytics.model.AnalyticsReferrer;
import com.liferay.content.targeting.analytics.service.base.AnalyticsReferrerLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * The implementation of the analytics referrer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.analytics.service.AnalyticsReferrerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.analytics.service.base.AnalyticsReferrerLocalServiceBaseImpl
 * @see com.liferay.content.targeting.analytics.service.AnalyticsReferrerLocalServiceUtil
 */
public class AnalyticsReferrerLocalServiceImpl
	extends AnalyticsReferrerLocalServiceBaseImpl {

	@Override
	public AnalyticsReferrer addAnalyticsReferrer(
			long analyticsEventId, String referrerClassName,
			long referrerClassPK)
		throws PortalException {

		long analyticsReferrerId = counterLocalService.increment();

		AnalyticsReferrer analyticsReferrer =
			analyticsReferrerPersistence.create(analyticsReferrerId);

		analyticsReferrer.setAnalyticsEventId(analyticsEventId);
		analyticsReferrer.setReferrerClassName(referrerClassName);
		analyticsReferrer.setReferrerClassPK(referrerClassPK);

		analyticsReferrerPersistence.update(analyticsReferrer);

		return analyticsReferrer;
	}

	@Override
	public int getAnalyticsReferrerCount(
		long analyticsEventId, String referrerClassName, long referrerClassPK) {

		return getAnalyticsReferrerCount(
			new long[] {analyticsEventId}, referrerClassName, referrerClassPK);
	}

	@Override
	public int getAnalyticsReferrerCount(
		long[] analyticsEventIds, String referrerClassName, long classPK) {

		long referrerClassNameId = classNameLocalService.getClassNameId(
			referrerClassName);

		return analyticsReferrerPersistence.countByA_R_R(
			analyticsEventIds, referrerClassNameId, classPK);
	}

	@Override
	public int getAnalyticsReferrerCount(
		String referrerClassName, long classPK) {

		long referrerClassNameId = classNameLocalService.getClassNameId(
			referrerClassName);

		return analyticsReferrerPersistence.countByR_R(
			referrerClassNameId, classPK);
	}

	@Override
	public List<AnalyticsReferrer> getAnalyticsReferrers(
		long analyticsEventId) {

		return analyticsReferrerPersistence.findByAnalyticsEventId(
			analyticsEventId);
	}

}