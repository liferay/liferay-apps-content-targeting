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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for UserSegment. This utility wraps
 * {@link com.liferay.content.targeting.service.impl.UserSegmentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserSegmentLocalService
 * @see com.liferay.content.targeting.service.base.UserSegmentLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.UserSegmentLocalServiceImpl
 * @generated
 */
@ProviderType
public class UserSegmentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.service.impl.UserSegmentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addCampaignUserSegment(long campaignId,
		com.liferay.content.targeting.model.UserSegment userSegment) {
		getService().addCampaignUserSegment(campaignId, userSegment);
	}

	public static void addCampaignUserSegment(long campaignId,
		long userSegmentId) {
		getService().addCampaignUserSegment(campaignId, userSegmentId);
	}

	public static void addCampaignUserSegments(long campaignId,
		java.util.List<com.liferay.content.targeting.model.UserSegment> UserSegments) {
		getService().addCampaignUserSegments(campaignId, UserSegments);
	}

	public static void addCampaignUserSegments(long campaignId,
		long[] userSegmentIds) {
		getService().addCampaignUserSegments(campaignId, userSegmentIds);
	}

	public static void addTacticUserSegment(long tacticId,
		com.liferay.content.targeting.model.UserSegment userSegment) {
		getService().addTacticUserSegment(tacticId, userSegment);
	}

	public static void addTacticUserSegment(long tacticId, long userSegmentId) {
		getService().addTacticUserSegment(tacticId, userSegmentId);
	}

	public static void addTacticUserSegments(long tacticId,
		java.util.List<com.liferay.content.targeting.model.UserSegment> UserSegments) {
		getService().addTacticUserSegments(tacticId, UserSegments);
	}

	public static void addTacticUserSegments(long tacticId,
		long[] userSegmentIds) {
		getService().addTacticUserSegments(tacticId, userSegmentIds);
	}

	public static com.liferay.content.targeting.model.UserSegment addUserSegment(
		long userId, java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addUserSegment(userId, nameMap, descriptionMap,
			serviceContext);
	}

	/**
	* Adds the user segment to the database. Also notifies the appropriate model listeners.
	*
	* @param userSegment the user segment
	* @return the user segment that was added
	*/
	public static com.liferay.content.targeting.model.UserSegment addUserSegment(
		com.liferay.content.targeting.model.UserSegment userSegment) {
		return getService().addUserSegment(userSegment);
	}

	public static void addUserSegmentResources(
		com.liferay.content.targeting.model.UserSegment userSegment,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService()
			.addUserSegmentResources(userSegment, addGroupPermissions,
			addGuestPermissions);
	}

	public static void addUserSegmentResources(
		com.liferay.content.targeting.model.UserSegment userSegment,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService()
			.addUserSegmentResources(userSegment, groupPermissions,
			guestPermissions);
	}

	public static void clearCampaignUserSegments(long campaignId) {
		getService().clearCampaignUserSegments(campaignId);
	}

	public static void clearTacticUserSegments(long tacticId) {
		getService().clearTacticUserSegments(tacticId);
	}

	/**
	* Creates a new user segment with the primary key. Does not add the user segment to the database.
	*
	* @param userSegmentId the primary key for the new user segment
	* @return the new user segment
	*/
	public static com.liferay.content.targeting.model.UserSegment createUserSegment(
		long userSegmentId) {
		return getService().createUserSegment(userSegmentId);
	}

	public static void deleteCampaignUserSegment(long campaignId,
		com.liferay.content.targeting.model.UserSegment userSegment) {
		getService().deleteCampaignUserSegment(campaignId, userSegment);
	}

	public static void deleteCampaignUserSegment(long campaignId,
		long userSegmentId) {
		getService().deleteCampaignUserSegment(campaignId, userSegmentId);
	}

	public static void deleteCampaignUserSegments(long campaignId,
		java.util.List<com.liferay.content.targeting.model.UserSegment> UserSegments) {
		getService().deleteCampaignUserSegments(campaignId, UserSegments);
	}

	public static void deleteCampaignUserSegments(long campaignId,
		long[] userSegmentIds) {
		getService().deleteCampaignUserSegments(campaignId, userSegmentIds);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static void deleteTacticUserSegment(long tacticId,
		com.liferay.content.targeting.model.UserSegment userSegment) {
		getService().deleteTacticUserSegment(tacticId, userSegment);
	}

	public static void deleteTacticUserSegment(long tacticId, long userSegmentId) {
		getService().deleteTacticUserSegment(tacticId, userSegmentId);
	}

	public static void deleteTacticUserSegments(long tacticId,
		java.util.List<com.liferay.content.targeting.model.UserSegment> UserSegments) {
		getService().deleteTacticUserSegments(tacticId, UserSegments);
	}

	public static void deleteTacticUserSegments(long tacticId,
		long[] userSegmentIds) {
		getService().deleteTacticUserSegments(tacticId, userSegmentIds);
	}

	/**
	* Deletes the user segment from the database. Also notifies the appropriate model listeners.
	*
	* @param userSegment the user segment
	* @return the user segment that was removed
	* @throws PortalException
	*/
	public static com.liferay.content.targeting.model.UserSegment deleteUserSegment(
		com.liferay.content.targeting.model.UserSegment userSegment)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteUserSegment(userSegment);
	}

	/**
	* Deletes the user segment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userSegmentId the primary key of the user segment
	* @return the user segment that was removed
	* @throws PortalException if a user segment with the primary key could not be found
	*/
	public static com.liferay.content.targeting.model.UserSegment deleteUserSegment(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteUserSegment(userSegmentId);
	}

	public static void deleteUserSegments(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().deleteUserSegments(groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.content.targeting.model.UserSegment fetchUserSegment(
		long userSegmentId) {
		return getService().fetchUserSegment(userSegmentId);
	}

	public static com.liferay.content.targeting.model.UserSegment fetchUserSegmentByAssetCategoryId(
		long assetCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().fetchUserSegmentByAssetCategoryId(assetCategoryId);
	}

	/**
	* Returns the user segment matching the UUID and group.
	*
	* @param uuid the user segment's UUID
	* @param groupId the primary key of the group
	* @return the matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public static com.liferay.content.targeting.model.UserSegment fetchUserSegmentByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchUserSegmentByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the campaignIds of the campaigns associated with the user segment.
	*
	* @param userSegmentId the userSegmentId of the user segment
	* @return long[] the campaignIds of campaigns associated with the user segment
	*/
	public static long[] getCampaignPrimaryKeys(long userSegmentId) {
		return getService().getCampaignPrimaryKeys(userSegmentId);
	}

	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getCampaignUserSegments(
		long campaignId) {
		return getService().getCampaignUserSegments(campaignId);
	}

	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getCampaignUserSegments(
		long campaignId, int start, int end) {
		return getService().getCampaignUserSegments(campaignId, start, end);
	}

	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getCampaignUserSegments(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.UserSegment> orderByComparator) {
		return getService()
				   .getCampaignUserSegments(campaignId, start, end,
			orderByComparator);
	}

	public static int getCampaignUserSegmentsCount(long campaignId) {
		return getService().getCampaignUserSegmentsCount(campaignId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the tacticIds of the tactics associated with the user segment.
	*
	* @param userSegmentId the userSegmentId of the user segment
	* @return long[] the tacticIds of tactics associated with the user segment
	*/
	public static long[] getTacticPrimaryKeys(long userSegmentId) {
		return getService().getTacticPrimaryKeys(userSegmentId);
	}

	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getTacticUserSegments(
		long tacticId) {
		return getService().getTacticUserSegments(tacticId);
	}

	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getTacticUserSegments(
		long tacticId, int start, int end) {
		return getService().getTacticUserSegments(tacticId, start, end);
	}

	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getTacticUserSegments(
		long tacticId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.UserSegment> orderByComparator) {
		return getService()
				   .getTacticUserSegments(tacticId, start, end,
			orderByComparator);
	}

	public static int getTacticUserSegmentsCount(long tacticId) {
		return getService().getTacticUserSegmentsCount(tacticId);
	}

	/**
	* Returns the user segment with the primary key.
	*
	* @param userSegmentId the primary key of the user segment
	* @return the user segment
	* @throws PortalException if a user segment with the primary key could not be found
	*/
	public static com.liferay.content.targeting.model.UserSegment getUserSegment(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserSegment(userSegmentId);
	}

	/**
	* Returns the user segment matching the UUID and group.
	*
	* @param uuid the user segment's UUID
	* @param groupId the primary key of the group
	* @return the matching user segment
	* @throws PortalException if a matching user segment could not be found
	*/
	public static com.liferay.content.targeting.model.UserSegment getUserSegmentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserSegmentByUuidAndGroupId(uuid, groupId);
	}

	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserSegments(groupId);
	}

	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserSegments(groupId, start, end, obc);
	}

	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long[] groupIds)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserSegments(groupIds);
	}

	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long[] groupIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserSegments(groupIds, start, end, obc);
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
	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		int start, int end) {
		return getService().getUserSegments(start, end);
	}

	/**
	* Returns all the user segments matching the UUID and company.
	*
	* @param uuid the UUID of the user segments
	* @param companyId the primary key of the company
	* @return the matching user segments, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegmentsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getUserSegmentsByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegmentsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.UserSegment> orderByComparator) {
		return getService()
				   .getUserSegmentsByUuidAndCompanyId(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of user segments.
	*
	* @return the number of user segments
	*/
	public static int getUserSegmentsCount() {
		return getService().getUserSegmentsCount();
	}

	public static int getUserSegmentsCount(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserSegmentsCount(groupId);
	}

	public static int getUserSegmentsCount(long[] groupIds)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserSegmentsCount(groupIds);
	}

	public static boolean hasCampaignUserSegment(long campaignId,
		long userSegmentId) {
		return getService().hasCampaignUserSegment(campaignId, userSegmentId);
	}

	public static boolean hasCampaignUserSegments(long campaignId) {
		return getService().hasCampaignUserSegments(campaignId);
	}

	public static boolean hasTacticUserSegment(long tacticId, long userSegmentId) {
		return getService().hasTacticUserSegment(tacticId, userSegmentId);
	}

	public static boolean hasTacticUserSegments(long tacticId) {
		return getService().hasTacticUserSegments(tacticId);
	}

	public static com.liferay.portal.kernel.search.Hits search(long groupId,
		java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().search(groupId, keywords, start, end);
	}

	public static com.liferay.content.targeting.util.BaseModelSearchResult<com.liferay.content.targeting.model.UserSegment> searchUserSegments(
		long groupId, java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().searchUserSegments(groupId, keywords, start, end);
	}

	public static void setCampaignUserSegments(long campaignId,
		long[] userSegmentIds) {
		getService().setCampaignUserSegments(campaignId, userSegmentIds);
	}

	public static void setTacticUserSegments(long tacticId,
		long[] userSegmentIds) {
		getService().setTacticUserSegments(tacticId, userSegmentIds);
	}

	/**
	* Updates the user segment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userSegment the user segment
	* @return the user segment that was updated
	*/
	public static com.liferay.content.targeting.model.UserSegment updateUserSegment(
		com.liferay.content.targeting.model.UserSegment userSegment) {
		return getService().updateUserSegment(userSegment);
	}

	public static com.liferay.content.targeting.model.UserSegment updateUserSegment(
		long userSegmentId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateUserSegment(userSegmentId, nameMap, descriptionMap,
			serviceContext);
	}

	public static void updateUserSegmentResources(
		com.liferay.content.targeting.model.UserSegment userSegment,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService()
			.updateUserSegmentResources(userSegment, groupPermissions,
			guestPermissions);
	}

	public static UserSegmentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserSegmentLocalService, UserSegmentLocalService> _serviceTracker =
		ServiceTrackerFactory.open(UserSegmentLocalService.class);
}