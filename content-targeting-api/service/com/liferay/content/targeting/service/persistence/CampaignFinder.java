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

package com.liferay.content.targeting.service.persistence;

import aQute.bnd.annotation.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface CampaignFinder {
	public com.liferay.content.targeting.model.Campaign fetchByG_D_A_U_First(
		long[] groupIds, java.util.Date date, boolean active,
		long[] userSegmentIds);

	public java.util.Map<java.io.Serializable, com.liferay.content.targeting.model.Campaign> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	public java.util.List<com.liferay.content.targeting.model.Campaign> filterFindByG_D_A_U(
		long[] groupIds, java.util.Date date, boolean active,
		long[] userSegmentIds);

	public com.liferay.content.targeting.model.Campaign filterFetchByG_D_A_U_First(
		long[] groupIds, java.util.Date date, boolean active,
		long[] userSegmentIds);

	public java.util.List<com.liferay.content.targeting.model.Campaign> findByG_D_A_U(
		long[] groupIds, java.util.Date date, boolean active,
		long[] userSegmentIds);
}