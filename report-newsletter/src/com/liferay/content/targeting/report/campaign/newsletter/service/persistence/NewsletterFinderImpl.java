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
package com.liferay.content.targeting.report.campaign.newsletter.service.persistence;

import com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter;
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
 * @author Julio Camarero
 */
public class NewsletterFinderImpl extends BasePersistenceImpl<Newsletter>
	implements NewsletterFinder {

	public static final String FIND_BY_ANALYICS_WITH_ELEMENT_ID =
		NewsletterFinder.class.getName() +
			".findByAnalyticsWithElementId";

	public List<Object[]> findByAnalyticsWithElementId(
			long campaignId, Date modifiedDate)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_ANALYICS_WITH_ELEMENT_ID);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar("elementId", Type.STRING);
			q.addScalar("eventType", Type.STRING);
			q.addScalar("alias", Type.STRING);

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
