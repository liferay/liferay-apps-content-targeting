package com.liferay.content.targeting.sample;

import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.List;

/**
 * Sample portlet using the Content Targeting API
 *
 * @author Julio Camarero
 */
public class SampleClientPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		List<UserSegment> userSegments = null;

		try {
			userSegments = UserSegmentLocalServiceUtil.getUserSegments(
				themeDisplay.getScopeGroupId());
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		renderRequest.setAttribute("userSegments", userSegments);

		super.doView(renderRequest, renderResponse);
	}
}