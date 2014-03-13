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

import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.anonymoususers.util.AnonymousUsersManager;
import com.liferay.contenttargeting.util.WebKeys;
import com.liferay.osgi.util.ServiceTrackerUtil;
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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

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

		if (_anonymousUsersManager == null) {
			_intiAnonymousUserManager();
		}

		AnonymousUser anonymousUser = _anonymousUsersManager.getAnonymousUser(
			renderRequest, renderResponse);

		Message message = new Message();

		message.put("className", JournalArticle.class.getName());
		message.put("classPK", getClassPK(article));
		message.put("anonymousUserId", anonymousUser.getAnonymousUserId());
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

	private void _intiAnonymousUserManager() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_anonymousUsersManager = ServiceTrackerUtil.getService(
			AnonymousUsersManager.class, bundle.getBundleContext());
	}

	private AnonymousUsersManager _anonymousUsersManager;

}