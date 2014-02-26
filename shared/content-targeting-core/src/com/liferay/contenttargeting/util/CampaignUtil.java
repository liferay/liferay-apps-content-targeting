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

package com.liferay.contenttargeting.util;

import com.liferay.contenttargeting.model.Campaign;
import com.liferay.contenttargeting.service.CampaignLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eudaldo Alonso
 */
public class CampaignUtil {

	public static final String[] SELECTED_FIELD_NAMES =
		{Field.COMPANY_ID, Field.GROUP_ID, Field.UID, "campaignId"};

	public static List<Campaign> getCampaigns(Hits hits)
		throws PortalException, SystemException {

		List<Document> documents = hits.toList();

		List<Campaign> campaigns = new ArrayList<Campaign>(documents.size());

		for (Document document : documents) {
			long campaignId = GetterUtil.getLong(document.get("campaignId"));

			Campaign campaign = CampaignLocalServiceUtil.fetchCampaign(
				campaignId);

			if (campaign == null) {
				campaigns = null;

				Indexer indexer = IndexerRegistryUtil.getIndexer(
					Campaign.class);

				long companyId = GetterUtil.getLong(
					document.get(Field.COMPANY_ID));

				indexer.delete(companyId, document.getUID());
			}
			else if (campaigns != null) {
				campaigns.add(campaign);
			}
		}

		return campaigns;
	}

}