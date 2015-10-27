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

import com.liferay.consumer.manager.extension.screens.model.Placeholder;
import com.liferay.consumer.manager.extension.screens.service.PlaceholderLocalService;
import com.liferay.consumer.manager.model.Consumer;
import com.liferay.consumer.manager.service.ConsumerLocalService;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import java.util.Locale;

/**
 * The extended model implementation for the CampaignMobile service. Represents a row in the &quot;CT_ASASLKJFLASD_CampaignMobile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class CampaignMobileImpl extends CampaignMobileBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a campaign mobile model instance should use the {@link com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile} interface instead.
	 */
	public CampaignMobileImpl() {
	}

	@Override
	public String getTitle(Locale locale) {
		AssetRendererFactory assetRendererFactory =
			AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(
				this.getClassName());

		try {
			AssetRenderer assetRenderer = assetRendererFactory.getAssetRenderer(
				this.getClassPK());

			return assetRenderer.getTitle(locale);
		}
		catch (Exception e) {
			return StringPool.BLANK;
		}
	}

	@Override
	public String getType(Locale locale) {
		return ResourceActionsUtil.getModelResource(
			locale, this.getClassName());
	}

	@Override
	public String getConsumerName(Locale locale) {
		try {
			Bundle bundle = FrameworkUtil.getBundle(getClass());

			ConsumerLocalService consumerLocalServiceImpl =
				ServiceTrackerUtil.getService(
					ConsumerLocalService.class, bundle.getBundleContext());

			Consumer consumer = consumerLocalServiceImpl.getConsumer(
				getConsumerId());

			return consumer.getName(locale);
		}
		catch (Exception e) {
			return StringPool.BLANK;
		}
	}

	@Override
	public String getPlaceholderName(Locale locale) {
		try {
			Bundle bundle = FrameworkUtil.getBundle(getClass());

			PlaceholderLocalService placeholderLocalService =
				ServiceTrackerUtil.getService(
					PlaceholderLocalService.class, bundle.getBundleContext());

			Placeholder placeholder = placeholderLocalService.getPlaceholder(
				getPlaceholderId());

			return placeholder.getName(locale);
		}
		catch (Exception e) {
			return StringPool.BLANK;
		}
	}

	public String getUserSegmentName(Locale locale) {
		try {
			Bundle bundle = FrameworkUtil.getBundle(getClass());

			UserSegmentLocalService userSegmentLocalService =
				ServiceTrackerUtil.getService(
					UserSegmentLocalService.class, bundle.getBundleContext());

			UserSegment userSegment = userSegmentLocalService.getUserSegment(
				getUserSegmentId());

			return userSegment.getName(locale);
		}
		catch (Exception e) {
			return StringPool.BLANK;
		}
	}

}