/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.hook.action;

import com.liferay.contenttargeting.model.CTUser;
import com.liferay.contenttargeting.util.CTUserUtil;
import com.liferay.contenttargeting.util.WebKeys;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleConstants;

import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Eudaldo
 */
public class JournalViewAction extends BaseStrutsPortletAction {

	@Override
	public String render(
			StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String forward = originalStrutsPortletAction.render(
			portletConfig, renderRequest, renderResponse);

		JournalArticle article = (JournalArticle)renderRequest.getAttribute(
			WebKeys.JOURNAL_ARTICLE);

		if (article == null) {
			return forward;
		}

		CTUser ctUser = CTUserUtil.getCTUser(renderRequest, renderResponse);

		Message message = new Message();

		message.put("className", JournalArticle.class.getName());
		message.put("classPK", getClassPK(article));
		message.put("ctUserId", ctUser.getCTUserId());
		message.put("groupId", themeDisplay.getScopeGroupId());

		MessageBusUtil.sendMessage("liferay/analytics", message);

		return forward;
	}

	protected long getClassPK(JournalArticle article) {
		if ((article.isDraft() || article.isPending()) &&
			(article.getVersion() !=
				JournalArticleConstants.VERSION_DEFAULT)) {

			return article.getPrimaryKey();
		}
		else {
			return article.getResourcePrimKey();
		}
	}

}