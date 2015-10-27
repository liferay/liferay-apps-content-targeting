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

package com.liferay.content.targeting.report.campaign.mobile.service.persistence;

import com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.Date;
import java.util.List;

public class ConsumerDataFinderImpl extends BasePersistenceImpl<CampaignMobile> implements ConsumerDataFinder {

	public List<Object[]> findBy(long companyId, Date date) throws SystemException {

		Session session = null;

		try {
			session = openSession();

			CustomSQLUtil.reloadCustomSQL();

			String sql = CustomSQLUtil.get(FIND_BY);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar("className", Type.STRING);
			q.addScalar("classPK", Type.LONG);
			q.addScalar("elementId", Type.STRING);
			q.addScalar("eventType", Type.STRING);
			q.addScalar("consumerId", Type.LONG);
			q.addScalar("count", Type.INTEGER);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);
			qPos.add(date);

			return q.list();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Object[]> sumTimeOnScreen(
		String eventType, long companyId, Date date) throws SystemException {

		Session session = null;

		try {
			session = openSession();

			CustomSQLUtil.reloadCustomSQL();

			String sql = CustomSQLUtil.get(SUM_TIME_ON_SCREEN);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar("className", Type.STRING);
			q.addScalar("classPK", Type.LONG);
			q.addScalar("eventType", Type.STRING);
			q.addScalar("consumerId", Type.LONG);
			q.addScalar("count", Type.INTEGER);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(eventType);
			qPos.add(companyId);
			qPos.add(date);

			return q.list();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public static final String SUM_TIME_ON_SCREEN =
		ConsumerDataFinder.class.getName() +
			".sumTimeOnScreen";

	public static final String FIND_BY =
		ConsumerDataFinder.class.getName() +
			".findBy";

}
