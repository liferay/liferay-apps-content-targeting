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

package com.liferay.contenttargeting.service.persistence;

import com.liferay.contenttargeting.model.Campaign;
import com.liferay.contenttargeting.model.impl.CampaignImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.Date;
import java.util.List;

/**
 * @author Eduardo Garcia
 */
public class CampaignFinderImpl
	extends BasePersistenceImpl<Campaign> implements CampaignFinder {

	public static final String FIND_BY_G_D_U =
		CampaignFinder.class.getName() + ".findByG_D_U";

	@Override
	public Campaign fetchByG_D_U(long groupId, Date date, long[] userSegmentIds)
		throws SystemException {

		return doFetchByG_D_U(groupId, date, userSegmentIds, false);
	}

	@Override
	public Campaign filterFetchByG_D_U(
			long groupId, Date date, long[] userSegmentIds)
		throws SystemException {

		return doFetchByG_D_U(groupId, date, userSegmentIds, true);
	}

	protected Campaign doFetchByG_D_U(
			long groupId, Date date, long[] userSegmentIds,
			boolean inlineSQLHelper)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			CustomSQLUtil.reloadCustomSQL();

			String sql = CustomSQLUtil.get(FIND_BY_G_D_U);

			sql = StringUtil.replace(
				sql, "[$USER_SEGMENT_IDS$]", StringUtil.merge(userSegmentIds));

			if (inlineSQLHelper) {
				sql = InlineSQLHelperUtil.replacePermissionCheck(
					sql, Campaign.class.getName(), "CT_Campaign.campaignId",
					PortalUtil.getSiteGroupId(groupId));
			}

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("Campaign", CampaignImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);
			qPos.add(date);
			qPos.add(date);

			List<Campaign> campaigns = q.list();

			if (!campaigns.isEmpty()) {
				return campaigns.get(0);
			}

			return null;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

}