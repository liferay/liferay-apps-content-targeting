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

import com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.CTActionTotalFinder;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.Date;
import java.util.List;

/**
 * @author Eudaldo Alonso
 */
public class CTActionTotalFinderImpl
	extends CTActionTotalFinderBaseImpl implements CTActionTotalFinder {

	public static final String FIND_BY_ANALYICS_WITH_CLASS_NAME =
		CTActionTotalFinder.class.getName() + ".findByAnalyticsWithClassName";

	public static final String FIND_BY_ANALYICS_WITH_ELEMENT_ID =
		CTActionTotalFinder.class.getName() + ".findByAnalyticsWithElementId";

	@Override
	public List<Object[]> findByAnalyticsWithClassName(Date modifiedDate) {
		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_ANALYICS_WITH_CLASS_NAME);

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar("className", Type.STRING);
			q.addScalar("classPK", Type.LONG);
			q.addScalar("eventType", Type.STRING);
			q.addScalar("count", Type.INTEGER);

			QueryPos qPos = QueryPos.getInstance(q);

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
	public List<Object[]> findByAnalyticsWithElementId(Date modifiedDate) {
		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_ANALYICS_WITH_ELEMENT_ID);

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar("elementId", Type.STRING);
			q.addScalar("eventType", Type.STRING);
			q.addScalar("count", Type.INTEGER);

			QueryPos qPos = QueryPos.getInstance(q);

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