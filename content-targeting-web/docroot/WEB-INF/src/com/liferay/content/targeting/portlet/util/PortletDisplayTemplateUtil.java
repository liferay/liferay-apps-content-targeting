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

package com.liferay.content.targeting.portlet.util;

import com.liferay.asset.publisher.web.util.AssetPublisherHelper;
import com.liferay.dynamic.data.lists.web.configuration.DDLWebConfigurationKeys;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalServiceUtil;
import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.templateparser.Transformer;
import com.liferay.portlet.display.template.PortletDisplayTemplateConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

/**
 * @author Eduardo Garcia
 */
public class PortletDisplayTemplateUtil
	extends com.liferay.portlet.display.template.PortletDisplayTemplateUtil {

	public static String renderDDMTemplate(
			PortletRequest portletRequest, ThemeDisplay themeDisplay,
			long ddmTemplateId, List<?> entries,
			Map<String, Object> contextObjects)
		throws Exception {

		DDMTemplate ddmTemplate = DDMTemplateLocalServiceUtil.getTemplate(
			ddmTemplateId);

		String language = ddmTemplate.getLanguage();

		if (language.equals(TemplateConstants.LANG_TYPE_VM)) {
			_log.error("Velocity Application Display Templates not supported");

			return null;
		}

		contextObjects.put(
			PortletDisplayTemplateConstants.TEMPLATE_ID, ddmTemplateId);
		contextObjects.put(PortletDisplayTemplateConstants.ENTRIES, entries);

		if (!entries.isEmpty()) {
			contextObjects.put(
				PortletDisplayTemplateConstants.ENTRY, entries.get(0));
		}

		contextObjects.putAll(_getPortletPreferences(portletRequest));

		// Compatibility with existing Application Display Templates

		Object portletJspTagLibs = contextObjects.get("PortletJspTagLibs");

		if (portletJspTagLibs != null) {
			contextObjects.put("taglibLiferayHash", portletJspTagLibs);
		}

		contextObjects.put("assetPublisherHelper", new AssetPublisherHelper());

		Transformer transformer = new Transformer(
			DDLWebConfigurationKeys.DYNAMIC_DATA_LISTS_ERROR_TEMPLATE, true);

		UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter();

		return transformer.transform(
			themeDisplay, contextObjects, ddmTemplate.getScript(), language,
			unsyncStringWriter);
	}

	private static Map<String, Object> _getPortletPreferences(
		PortletRequest portletRequest) {

		Map<String, Object> contextObjects = new HashMap<>();

		PortletPreferences portletPreferences = portletRequest.getPreferences();

		Map<String, String[]> map = portletPreferences.getMap();

		contextObjects.put(
			PortletDisplayTemplateConstants.PORTLET_PREFERENCES, map);

		for (Map.Entry<String, String[]> entry : map.entrySet()) {
			String[] values = entry.getValue();

			if (ArrayUtil.isEmpty(values)) {
				continue;
			}

			String value = values[0];

			if (value == null) {
				continue;
			}

			contextObjects.put(entry.getKey(), value);
		}

		return contextObjects;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		PortletDisplayTemplateUtil.class);

}