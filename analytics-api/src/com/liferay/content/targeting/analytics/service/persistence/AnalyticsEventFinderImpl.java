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

package com.liferay.content.targeting.analytics.service.persistence;

import com.liferay.content.targeting.analytics.model.AnalyticsEvent;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.Date;
import java.util.List;

/**
 * @author Eudaldo Alonso
 */
public class AnalyticsEventFinderImpl
	extends BasePersistenceImpl<AnalyticsEvent>
	implements AnalyticsEventFinder {

	public static final String FIND_BY_C_GtC_R_R =
		AnalyticsEvent.class.getName() + ".findByC_GtC_R_R";

	@Override
	public List<Object[]> findByC_GtC_R_R(
			long companyId, String referrerClassName, long referrerClassPK,
			Date date)
		throws SystemException {

		return doFindByC_GTC_R_R(
			companyId, referrerClassName, referrerClassPK, date);
	}

	protected List<Object[]> doFindByC_GTC_R_R(
			long companyId, String referrerClassName, long referrerClassPK,
			Date date)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			CustomSQLUtil.reloadCustomSQL();

			String sql = CustomSQLUtil.get(FIND_BY_C_GtC_R_R);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar("className", Type.STRING);
			q.addScalar("classPK", Type.LONG);
			q.addScalar("count", Type.INTEGER);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);
			qPos.add(date);
			qPos.add(referrerClassName);
			qPos.add(referrerClassPK);

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