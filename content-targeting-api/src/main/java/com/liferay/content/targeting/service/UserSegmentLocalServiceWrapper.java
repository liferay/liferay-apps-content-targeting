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

package com.liferay.content.targeting.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserSegmentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserSegmentLocalService
 * @generated
 */
@ProviderType
public class UserSegmentLocalServiceWrapper implements UserSegmentLocalService,
	ServiceWrapper<UserSegmentLocalService> {
	public UserSegmentLocalServiceWrapper(
		UserSegmentLocalService userSegmentLocalService) {
		_userSegmentLocalService = userSegmentLocalService;
	}

	@Override
	public void addCampaignUserSegment(long campaignId,
		com.liferay.content.targeting.model.UserSegment userSegment) {
		_userSegmentLocalService.addCampaignUserSegment(campaignId, userSegment);
	}

	@Override
	public void addCampaignUserSegment(long campaignId, long userSegmentId) {
		_userSegmentLocalService.addCampaignUserSegment(campaignId,
			userSegmentId);
	}

	@Override
	public void addCampaignUserSegments(long campaignId,
		java.util.List<com.liferay.content.targeting.model.UserSegment> UserSegments) {
		_userSegmentLocalService.addCampaignUserSegments(campaignId,
			UserSegments);
	}

	@Override
	public void addCampaignUserSegments(long campaignId, long[] userSegmentIds) {
		_userSegmentLocalService.addCampaignUserSegments(campaignId,
			userSegmentIds);
	}

	@Override
	public void addTacticUserSegment(long tacticId,
		com.liferay.content.targeting.model.UserSegment userSegment) {
		_userSegmentLocalService.addTacticUserSegment(tacticId, userSegment);
	}

	@Override
	public void addTacticUserSegment(long tacticId, long userSegmentId) {
		_userSegmentLocalService.addTacticUserSegment(tacticId, userSegmentId);
	}

	@Override
	public void addTacticUserSegments(long tacticId,
		java.util.List<com.liferay.content.targeting.model.UserSegment> UserSegments) {
		_userSegmentLocalService.addTacticUserSegments(tacticId, UserSegments);
	}

	@Override
	public void addTacticUserSegments(long tacticId, long[] userSegmentIds) {
		_userSegmentLocalService.addTacticUserSegments(tacticId, userSegmentIds);
	}

	@Override
	public com.liferay.content.targeting.model.UserSegment addUserSegment(
		long userId, java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentLocalService.addUserSegment(userId, nameMap,
			descriptionMap, serviceContext);
	}

	/**
	* Adds the user segment to the database. Also notifies the appropriate model listeners.
	*
	* @param userSegment the user segment
	* @return the user segment that was added
	*/
	@Override
	public com.liferay.content.targeting.model.UserSegment addUserSegment(
		com.liferay.content.targeting.model.UserSegment userSegment) {
		return _userSegmentLocalService.addUserSegment(userSegment);
	}

	@Override
	public void addUserSegmentResources(
		com.liferay.content.targeting.model.UserSegment userSegment,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {
		_userSegmentLocalService.addUserSegmentResources(userSegment,
			addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addUserSegmentResources(
		com.liferay.content.targeting.model.UserSegment userSegment,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {
		_userSegmentLocalService.addUserSegmentResources(userSegment,
			groupPermissions, guestPermissions);
	}

	@Override
	public void clearCampaignUserSegments(long campaignId) {
		_userSegmentLocalService.clearCampaignUserSegments(campaignId);
	}

	@Override
	public void clearTacticUserSegments(long tacticId) {
		_userSegmentLocalService.clearTacticUserSegments(tacticId);
	}

	/**
	* Creates a new user segment with the primary key. Does not add the user segment to the database.
	*
	* @param userSegmentId the primary key for the new user segment
	* @return the new user segment
	*/
	@Override
	public com.liferay.content.targeting.model.UserSegment createUserSegment(
		long userSegmentId) {
		return _userSegmentLocalService.createUserSegment(userSegmentId);
	}

	@Override
	public void deleteCampaignUserSegment(long campaignId,
		com.liferay.content.targeting.model.UserSegment userSegment) {
		_userSegmentLocalService.deleteCampaignUserSegment(campaignId,
			userSegment);
	}

	@Override
	public void deleteCampaignUserSegment(long campaignId, long userSegmentId) {
		_userSegmentLocalService.deleteCampaignUserSegment(campaignId,
			userSegmentId);
	}

	@Override
	public void deleteCampaignUserSegments(long campaignId,
		java.util.List<com.liferay.content.targeting.model.UserSegment> UserSegments) {
		_userSegmentLocalService.deleteCampaignUserSegments(campaignId,
			UserSegments);
	}

	@Override
	public void deleteCampaignUserSegments(long campaignId,
		long[] userSegmentIds) {
		_userSegmentLocalService.deleteCampaignUserSegments(campaignId,
			userSegmentIds);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deleteTacticUserSegment(long tacticId,
		com.liferay.content.targeting.model.UserSegment userSegment) {
		_userSegmentLocalService.deleteTacticUserSegment(tacticId, userSegment);
	}

	@Override
	public void deleteTacticUserSegment(long tacticId, long userSegmentId) {
		_userSegmentLocalService.deleteTacticUserSegment(tacticId, userSegmentId);
	}

	@Override
	public void deleteTacticUserSegments(long tacticId,
		java.util.List<com.liferay.content.targeting.model.UserSegment> UserSegments) {
		_userSegmentLocalService.deleteTacticUserSegments(tacticId, UserSegments);
	}

	@Override
	public void deleteTacticUserSegments(long tacticId, long[] userSegmentIds) {
		_userSegmentLocalService.deleteTacticUserSegments(tacticId,
			userSegmentIds);
	}

	/**
	* Deletes the user segment from the database. Also notifies the appropriate model listeners.
	*
	* @param userSegment the user segment
	* @return the user segment that was removed
	* @throws PortalException
	*/
	@Override
	public com.liferay.content.targeting.model.UserSegment deleteUserSegment(
		com.liferay.content.targeting.model.UserSegment userSegment)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentLocalService.deleteUserSegment(userSegment);
	}

	/**
	* Deletes the user segment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userSegmentId the primary key of the user segment
	* @return the user segment that was removed
	* @throws PortalException if a user segment with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.UserSegment deleteUserSegment(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentLocalService.deleteUserSegment(userSegmentId);
	}

	@Override
	public void deleteUserSegments(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		_userSegmentLocalService.deleteUserSegments(groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userSegmentLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _userSegmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _userSegmentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _userSegmentLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _userSegmentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _userSegmentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.content.targeting.model.UserSegment fetchUserSegment(
		long userSegmentId) {
		return _userSegmentLocalService.fetchUserSegment(userSegmentId);
	}

	@Override
	public com.liferay.content.targeting.model.UserSegment fetchUserSegmentByAssetCategoryId(
		long assetCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentLocalService.fetchUserSegmentByAssetCategoryId(assetCategoryId);
	}

	/**
	* Returns the user segment matching the UUID and group.
	*
	* @param uuid the user segment's UUID
	* @param groupId the primary key of the group
	* @return the matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.UserSegment fetchUserSegmentByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _userSegmentLocalService.fetchUserSegmentByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _userSegmentLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the campaignIds of the campaigns associated with the user segment.
	*
	* @param userSegmentId the userSegmentId of the user segment
	* @return long[] the campaignIds of campaigns associated with the user segment
	*/
	@Override
	public long[] getCampaignPrimaryKeys(long userSegmentId) {
		return _userSegmentLocalService.getCampaignPrimaryKeys(userSegmentId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getCampaignUserSegments(
		long campaignId) {
		return _userSegmentLocalService.getCampaignUserSegments(campaignId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getCampaignUserSegments(
		long campaignId, int start, int end) {
		return _userSegmentLocalService.getCampaignUserSegments(campaignId,
			start, end);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getCampaignUserSegments(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.UserSegment> orderByComparator) {
		return _userSegmentLocalService.getCampaignUserSegments(campaignId,
			start, end, orderByComparator);
	}

	@Override
	public int getCampaignUserSegmentsCount(long campaignId) {
		return _userSegmentLocalService.getCampaignUserSegmentsCount(campaignId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _userSegmentLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _userSegmentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _userSegmentLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the tacticIds of the tactics associated with the user segment.
	*
	* @param userSegmentId the userSegmentId of the user segment
	* @return long[] the tacticIds of tactics associated with the user segment
	*/
	@Override
	public long[] getTacticPrimaryKeys(long userSegmentId) {
		return _userSegmentLocalService.getTacticPrimaryKeys(userSegmentId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getTacticUserSegments(
		long tacticId) {
		return _userSegmentLocalService.getTacticUserSegments(tacticId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getTacticUserSegments(
		long tacticId, int start, int end) {
		return _userSegmentLocalService.getTacticUserSegments(tacticId, start,
			end);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getTacticUserSegments(
		long tacticId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.UserSegment> orderByComparator) {
		return _userSegmentLocalService.getTacticUserSegments(tacticId, start,
			end, orderByComparator);
	}

	@Override
	public int getTacticUserSegmentsCount(long tacticId) {
		return _userSegmentLocalService.getTacticUserSegmentsCount(tacticId);
	}

	/**
	* Returns the user segment with the primary key.
	*
	* @param userSegmentId the primary key of the user segment
	* @return the user segment
	* @throws PortalException if a user segment with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.UserSegment getUserSegment(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentLocalService.getUserSegment(userSegmentId);
	}

	/**
	* Returns the user segment matching the UUID and group.
	*
	* @param uuid the user segment's UUID
	* @param groupId the primary key of the group
	* @return the matching user segment
	* @throws PortalException if a matching user segment could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.UserSegment getUserSegmentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentLocalService.getUserSegmentByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentLocalService.getUserSegments(groupId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentLocalService.getUserSegments(groupId, start, end, obc);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long[] groupIds)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentLocalService.getUserSegments(groupIds);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long[] groupIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentLocalService.getUserSegments(groupIds, start, end,
			obc);
	}

	/**
	* Returns a range of all the user segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @return the range of user segments
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		int start, int end) {
		return _userSegmentLocalService.getUserSegments(start, end);
	}

	/**
	* Returns all the user segments matching the UUID and company.
	*
	* @param uuid the UUID of the user segments
	* @param companyId the primary key of the company
	* @return the matching user segments, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegmentsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _userSegmentLocalService.getUserSegmentsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of user segments matching the UUID and company.
	*
	* @param uuid the UUID of the user segments
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching user segments, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegmentsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.UserSegment> orderByComparator) {
		return _userSegmentLocalService.getUserSegmentsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of user segments.
	*
	* @return the number of user segments
	*/
	@Override
	public int getUserSegmentsCount() {
		return _userSegmentLocalService.getUserSegmentsCount();
	}

	@Override
	public int getUserSegmentsCount(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentLocalService.getUserSegmentsCount(groupId);
	}

	@Override
	public int getUserSegmentsCount(long[] groupIds)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentLocalService.getUserSegmentsCount(groupIds);
	}

	@Override
	public boolean hasCampaignUserSegment(long campaignId, long userSegmentId) {
		return _userSegmentLocalService.hasCampaignUserSegment(campaignId,
			userSegmentId);
	}

	@Override
	public boolean hasCampaignUserSegments(long campaignId) {
		return _userSegmentLocalService.hasCampaignUserSegments(campaignId);
	}

	@Override
	public boolean hasTacticUserSegment(long tacticId, long userSegmentId) {
		return _userSegmentLocalService.hasTacticUserSegment(tacticId,
			userSegmentId);
	}

	@Override
	public boolean hasTacticUserSegments(long tacticId) {
		return _userSegmentLocalService.hasTacticUserSegments(tacticId);
	}

	@Override
	public com.liferay.portal.kernel.search.Hits search(long groupId,
		java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentLocalService.search(groupId, keywords, start, end);
	}

	@Override
	public com.liferay.content.targeting.util.BaseModelSearchResult<com.liferay.content.targeting.model.UserSegment> searchUserSegments(
		long groupId, java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentLocalService.searchUserSegments(groupId, keywords,
			start, end);
	}

	@Override
	public void setCampaignUserSegments(long campaignId, long[] userSegmentIds) {
		_userSegmentLocalService.setCampaignUserSegments(campaignId,
			userSegmentIds);
	}

	@Override
	public void setTacticUserSegments(long tacticId, long[] userSegmentIds) {
		_userSegmentLocalService.setTacticUserSegments(tacticId, userSegmentIds);
	}

	/**
	* Updates the user segment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userSegment the user segment
	* @return the user segment that was updated
	*/
	@Override
	public com.liferay.content.targeting.model.UserSegment updateUserSegment(
		com.liferay.content.targeting.model.UserSegment userSegment) {
		return _userSegmentLocalService.updateUserSegment(userSegment);
	}

	@Override
	public com.liferay.content.targeting.model.UserSegment updateUserSegment(
		long userSegmentId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userSegmentLocalService.updateUserSegment(userSegmentId,
			nameMap, descriptionMap, serviceContext);
	}

	@Override
	public void updateUserSegmentResources(
		com.liferay.content.targeting.model.UserSegment userSegment,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {
		_userSegmentLocalService.updateUserSegmentResources(userSegment,
			groupPermissions, guestPermissions);
	}

	@Override
	public UserSegmentLocalService getWrappedService() {
		return _userSegmentLocalService;
	}

	@Override
	public void setWrappedService(
		UserSegmentLocalService userSegmentLocalService) {
		_userSegmentLocalService = userSegmentLocalService;
	}

	private UserSegmentLocalService _userSegmentLocalService;
}