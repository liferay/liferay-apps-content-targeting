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

package com.liferay.content.targeting.util;

import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.service.TacticLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Savinov
 */
public class TacticUtil {

	public static final String[] SELECTED_FIELD_NAMES =
		{Field.COMPANY_ID, Field.GROUP_ID, Field.UID, "tacticId"};

	public static List<Tactic> getTactics(Hits hits) throws PortalException {
		List<Tactic> tactics = null;

		if (hits != null) {
			List<Document> documents = hits.toList();

			tactics = new ArrayList<>(documents.size());

			for (Document document : documents) {
				long tacticId = GetterUtil.getLong(document.get("tacticId"));

				Tactic tactic = TacticLocalServiceUtil.fetchTactic(tacticId);

				if (tactic == null) {
					tactics = null;

					Indexer indexer = IndexerRegistryUtil.getIndexer(
						Tactic.class);

					long companyId = GetterUtil.getLong(
						document.get(Field.COMPANY_ID));

					indexer.delete(companyId, document.getUID());
				}
				else if (tactics != null) {
					tactics.add(tactic);
				}
			}
		}
		else {
			tactics = new ArrayList<>(0);
		}

		return tactics;
	}

}