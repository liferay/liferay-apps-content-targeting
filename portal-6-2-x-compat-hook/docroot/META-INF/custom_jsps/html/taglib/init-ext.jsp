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
private List<Group> _doGetAncestorSiteGroups(long groupId)
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

protected Group _doGetCurrentSiteGroup(long groupId)
	throws PortalException, SystemException {

	long siteGroupId = PortalUtil.getSiteGroupId(groupId);

	Group siteGroup = GroupLocalServiceUtil.getGroup(siteGroupId);

	if (!siteGroup.isLayoutPrototype()) {
		return siteGroup;
	}

	return null;
}

private long[] _getCurrentAndAncestorSiteGroupIds(long groupId)
	throws PortalException, SystemException {

	List<Group> groups = _getCurrentAndAncestorSiteGroups(groupId);

	long[] groupIds = new long[groups.size()];

	for (int i = 0; i < groups.size(); i++) {
		Group group = groups.get(i);

		groupIds[i] = group.getGroupId();
	}

	return groupIds;
}

private long[] _getCurrentAndAncestorSiteGroupIds(long[] groupIds)
	throws PortalException, SystemException {

	List<Group> groups = _getCurrentAndAncestorSiteGroups(groupIds);

	long[] currentAndAncestorSiteGroupIds = new long[groups.size()];

	for (int i = 0; i < groups.size(); i++) {
		Group group = groups.get(i);

		currentAndAncestorSiteGroupIds[i] = group.getGroupId();
	}

	return currentAndAncestorSiteGroupIds;
}

private List<Group> _getCurrentAndAncestorSiteGroups(long groupId)
	throws PortalException, SystemException {

	Set<Group> groups = new LinkedHashSet<Group>();

	Group siteGroup = _doGetCurrentSiteGroup(groupId);

	if (siteGroup != null) {
		groups.add(siteGroup);
	}

	groups.addAll(
		_doGetAncestorSiteGroups(groupId));

	return new ArrayList<Group>(groups);
}

private List<Group> _getCurrentAndAncestorSiteGroups(long[] groupIds)
	throws PortalException, SystemException {

	Set<Group> groups = new LinkedHashSet<Group>();

	for (int i = 0; i < groupIds.length; i++) {
		groups.addAll(
			_getCurrentAndAncestorSiteGroups(groupIds[i]));
	}

	return new ArrayList<Group>(groups);
}
%>