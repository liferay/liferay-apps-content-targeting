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

package com.liferay.content.targeting.report.campaign.tracking.action.util.comparator;

import com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Eudaldo Alonso
 */
public class CampaignTrackingActionTotalCountComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC =
		"CampaignTrackingActionTotal.count ASC";

	public static final String ORDER_BY_DESC =
		"CampaignTrackingActionTotal.count DESC";

	public static final String[] ORDER_BY_FIELDS = {"count"};

	public CampaignTrackingActionTotalCountComparator() {
		this(false);
	}

	public CampaignTrackingActionTotalCountComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		CampaignTrackingActionTotal campaignTrackingActionTotal1 =
			(CampaignTrackingActionTotal)obj1;
		CampaignTrackingActionTotal campaignTrackingActionTotal2 =
			(CampaignTrackingActionTotal)obj2;

		int count1 = campaignTrackingActionTotal1.getCount();
		int count2 = campaignTrackingActionTotal2.getCount();

		int value = 0;

		if (count1 < count2) {
			value = -1;
		}
		else if (count1 > count2) {
			value = 1;
		}

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}