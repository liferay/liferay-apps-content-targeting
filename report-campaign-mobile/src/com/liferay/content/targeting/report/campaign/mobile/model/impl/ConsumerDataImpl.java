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

package com.liferay.content.targeting.report.campaign.mobile.model.impl;

import com.liferay.consumer.manager.model.Consumer;
import com.liferay.consumer.manager.service.ConsumerLocalService;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.util.StringPool;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import java.util.Locale;

/**
 * The extended model implementation for the ConsumerData service. Represents a row in the &quot;CT_CMR_ConsumerData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class ConsumerDataImpl extends ConsumerDataBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a consumer data model instance should use the {@link com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData} interface instead.
	 */
	public ConsumerDataImpl() {
	}

	@Override
	public String getConsumerName(Locale locale) {
		try {
			Bundle bundle = FrameworkUtil.getBundle(getClass());

			ConsumerLocalService consumerLocalService =
				ServiceTrackerUtil.getService(
					ConsumerLocalService.class, bundle.getBundleContext());

			Consumer consumer = consumerLocalService.getConsumer(
				getConsumerId());

			return consumer.getName(locale);
		}
		catch (Exception e) {
			return StringPool.BLANK;
		}
	}

}