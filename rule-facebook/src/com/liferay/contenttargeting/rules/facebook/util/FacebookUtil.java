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

package com.liferay.contenttargeting.rules.facebook.util;

import com.liferay.portal.kernel.util.GetterUtil;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.json.JsonObject;
import com.restfb.types.NamedFacebookType;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.User;

import java.util.List;

/**
 * @author Eudaldo Alonso
 */
public class FacebookUtil {

	public static Page getFacebookPage(String accessToken, String url) {
		FacebookClient facebookClient = new DefaultFacebookClient(accessToken);

		return facebookClient.fetchObject(url, Page.class);
	}

	public static User getFacebookUser(String accessToken) {
		FacebookClient facebookClient = new DefaultFacebookClient(accessToken);

		return facebookClient.fetchObject("me", User.class);
	}

	public static long getFriendsCount(String accessToken) {
		FacebookClient facebookClient = new DefaultFacebookClient(accessToken);

		String query = "SELECT friend_count FROM user WHERE uid = me()";

		List<JsonObject> jsonObjects = facebookClient.executeFqlQuery(
			query, JsonObject.class);

		JsonObject jsonObject = jsonObjects.get(0);

		return GetterUtil.getLong(jsonObject.get("friend_count"));
	}

	public static boolean isUserLikes(String accessToken, String url) {
		Page page = getFacebookPage(accessToken, url);

		FacebookClient facebookClient = new DefaultFacebookClient(accessToken);

		Post.Likes postLikes = facebookClient.fetchObject(
			"me/likes/" + page.getId(), Post.Likes.class);

		List<NamedFacebookType> likes = postLikes.getData();

		if (likes.size() > 0) {
			return true;
		}

		return false;
	}

}