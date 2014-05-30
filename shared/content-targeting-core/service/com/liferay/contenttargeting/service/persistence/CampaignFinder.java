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

/**
 * @author Brian Wing Shun Chan
 */
public interface CampaignFinder {
	public com.liferay.contenttargeting.model.Campaign fetchByG_D_A_U_First(
		long[] groupIds, java.util.Date date, boolean active,
		long[] userSegmentIds)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.contenttargeting.model.Campaign> filterFindByG_D_A_U(
		long[] groupIds, java.util.Date date, boolean active,
		long[] userSegmentIds)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.contenttargeting.model.Campaign> findByG_D_A_U(
		long[] groupIds, java.util.Date date, boolean active,
		long[] userSegmentIds)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.contenttargeting.model.Campaign filterFetchByG_D_A_U_First(
		long[] groupIds, java.util.Date date, boolean active,
		long[] userSegmentIds)
		throws com.liferay.portal.kernel.exception.SystemException;
}