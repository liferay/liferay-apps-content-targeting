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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.taglib.BaseDynamicInclude;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Pavel Savinov
 */
@Component(immediate = true, service = DynamicInclude.class)
public class AnalyticsTopHeadDynamicInclude extends BaseDynamicInclude {

    @Override
    public void include(
            HttpServletRequest request, HttpServletResponse response,
            String key)
        throws IOException {

        RequestDispatcher requestDispatcher =
            _servletContext.getRequestDispatcher(_JSP_PATH);

        try {
            requestDispatcher.include(request, response);
        }
        catch (ServletException se) {
            _log.error("Unable to include JSP " + _JSP_PATH, se);

            throw new IOException("Unable to include JSP " + _JSP_PATH, se);
        }

    }

    @Override
    public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
        dynamicIncludeRegistry.register(
            "/html/common/themes/top_head.jsp#post");
    }

    @Reference(
        target = "(osgi.web.symbolicname=com.liferay.content.targeting.analytics.web)",
        unbind = "-"
    )
    protected void setServletContext(ServletContext servletContext) {
        _servletContext = servletContext;
    }

    private static final String _JSP_PATH =
        "/html/common/themes/top_js-ext.jsp";

    private static final Log _log = LogFactoryUtil.getLog(
        AnalyticsTopHeadDynamicInclude.class);

    private volatile ServletContext _servletContext;

}
