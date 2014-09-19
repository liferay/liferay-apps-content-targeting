<%--
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
--%>

<%!
private long[] getCurrentAndAncestorSiteGroupIds(long groupId)
	throws PortalException, SystemException {

	List<Group> groups = new ArrayList<Group>();

	long siteGroupId = PortalUtil.getSiteGroupId(groupId);

	Group siteGroup = GroupLocalServiceUtil.getGroup(siteGroupId);

	if (!siteGroup.isLayoutPrototype()) {
		groups.add(siteGroup);
	}

	groups.addAll(doGetAncestorSiteGroupIds(groupId));

	long[] groupIds = new long[groups.size()];

	for (int i = 0; i < groups.size(); i++) {
		Group group = groups.get(i);

		groupIds[i] = group.getGroupId();
	}

	return groupIds;
}

protected List<Group> doGetAncestorSiteGroupIds(long groupId)
	throws PortalException, SystemException {

	List<Group> groups = new ArrayList<Group>();

	long siteGroupId = PortalUtil.getSiteGroupId(groupId);

	Group siteGroup = GroupLocalServiceUtil.getGroup(siteGroupId);

	groups.addAll(siteGroup.getAncestors());

	if (!siteGroup.isCompany()) {
		groups.add(
			GroupLocalServiceUtil.getCompanyGroup(
				siteGroup.getCompanyId()));
	}

	return groups;
}
%>