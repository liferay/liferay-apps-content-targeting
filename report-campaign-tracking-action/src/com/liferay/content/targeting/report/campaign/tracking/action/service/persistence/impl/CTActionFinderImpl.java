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

package com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.impl;

import com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.CTActionFinder;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.Date;
import java.util.List;

/**
 * @author Eduardo Garcia
 */
public class CTActionFinderImpl
	extends CTActionFinderBaseImpl implements CTActionFinder {

	public static final String FIND_BY_ANALYICS_WITH_CLASS_NAME =
		CTActionFinder.class.getName() + ".findByAnalyticsWithClassName";

	public static final String FIND_BY_ANALYICS_WITH_ELEMENT_ID =
		CTActionFinder.class.getName() + ".findByAnalyticsWithElementId";

	@Override
	public List<Object[]> findByAnalyticsWithClassName(
		long campaignId, Date modifiedDate) {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_ANALYICS_WITH_CLASS_NAME);

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar("referrerClassPK", Type.LONG);
			q.addScalar("className", Type.STRING);
			q.addScalar("classPK", Type.LONG);
			q.addScalar("eventType", Type.STRING);
			q.addScalar("alias_", Type.STRING);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(campaignId);
			qPos.add(modifiedDate);

			return q.list();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	public List<Object[]> findByAnalyticsWithElementId(
		long campaignId, Date modifiedDate) {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_ANALYICS_WITH_ELEMENT_ID);

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar("referrerClassPK", Type.LONG);
			q.addScalar("elementId", Type.STRING);
			q.addScalar("eventType", Type.STRING);
			q.addScalar("alias_", Type.STRING);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(campaignId);
			qPos.add(modifiedDate);

			return q.list();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

}