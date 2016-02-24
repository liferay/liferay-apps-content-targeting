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

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pavel Savinov
 */
@Component(immediate = true, service = DynamicInclude.class)
public class FileEntryTrackingDynamicInclude extends TrackingDynamicInclude {

	@Override
	public void include(
			HttpServletRequest request, HttpServletResponse response,
			String key)
		throws IOException {

		FileEntry fileEntry = (FileEntry)request.getAttribute(
			WebKeys.DOCUMENT_LIBRARY_FILE_ENTRY);

		if (fileEntry != null) {
			try {
				doInclude(
					response, "view", DLFileEntry.class.getName(),
					fileEntry.getPrimaryKey(), DLFileEntry.class.getName(),
					new long[] {fileEntry.getPrimaryKey()});
			}
			catch (Exception e) {
				_log.error("Unable to include analytics tracking JS", e);
			}
		}
	}

	@Override
	public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
		dynamicIncludeRegistry.register(
			"com.liferay.document.library.web#/document_library/" +
				"view_file_entry.jsp#post");
	}

	private static final Log _log = LogFactoryUtil.getLog(
		FileEntryTrackingDynamicInclude.class);

}