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

package com.liferay.content.targeting.report.user.segment.content.model.impl;

import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Locale;

/**
 * The extended model implementation for the UserSegmentContent service. Represents a row in the &quot;UserSegmentContentReport_UserSegmentContent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class UserSegmentContentImpl extends UserSegmentContentBaseImpl {

	public UserSegmentContentImpl() {
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

}