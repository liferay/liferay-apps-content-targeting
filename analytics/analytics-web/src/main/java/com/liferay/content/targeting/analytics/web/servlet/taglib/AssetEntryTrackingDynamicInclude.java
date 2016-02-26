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

package com.liferay.content.targeting.analytics.web.servlet.taglib;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pavel Savinov
 */
@Component(immediate = true, service = DynamicInclude.class)
public class AssetEntryTrackingDynamicInclude extends TrackingDynamicInclude {

	@Override
	public void include(
			HttpServletRequest request, HttpServletResponse response,
			String key)
		throws IOException {

		AssetEntry assetEntry = (AssetEntry)request.getAttribute(
			"view.jsp-assetEntry");

		if (assetEntry != null) {
			try {
				doInclude(
					response, "view", AssetEntry.class.getName(),
					assetEntry.getClassPK(), AssetEntry.class.getName(),
					new long[] {assetEntry.getClassPK()});
			}
			catch (Exception e) {
				_log.error("Unable to include analytics tracking JS", e);
			}
		}
	}

	@Override
	public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
		dynamicIncludeRegistry.register(
			"com.liferay.asset.publisher.web#/view_content.jsp#post");
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AssetEntryTrackingDynamicInclude.class);

}