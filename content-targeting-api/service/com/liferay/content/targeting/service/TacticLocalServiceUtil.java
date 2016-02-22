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
 * Provides the local service utility for Tactic. This utility wraps
 * {@link com.liferay.content.targeting.service.impl.TacticLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TacticLocalService
 * @see com.liferay.content.targeting.service.base.TacticLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.TacticLocalServiceImpl
 * @generated
 */
@ProviderType
public class TacticLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.service.impl.TacticLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the tactic to the database. Also notifies the appropriate model listeners.
	*
	* @param tactic the tactic
	* @return the tactic that was added
	*/
	public static com.liferay.content.targeting.model.Tactic addTactic(
		com.liferay.content.targeting.model.Tactic tactic) {
		return getService().addTactic(tactic);
	}

	public static com.liferay.content.targeting.model.Tactic addTactic(
		long userId, long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		long[] userSegmentsIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addTactic(userId, campaignId, nameMap, descriptionMap,
			userSegmentsIds, serviceContext);
	}

	public static void addUserSegmentTactic(long userSegmentId,
		com.liferay.content.targeting.model.Tactic tactic) {
		getService().addUserSegmentTactic(userSegmentId, tactic);
	}

	public static void addUserSegmentTactic(long userSegmentId, long tacticId) {
		getService().addUserSegmentTactic(userSegmentId, tacticId);
	}

	public static void addUserSegmentTactics(long userSegmentId,
		java.util.List<com.liferay.content.targeting.model.Tactic> Tactics) {
		getService().addUserSegmentTactics(userSegmentId, Tactics);
	}

	public static void addUserSegmentTactics(long userSegmentId,
		long[] tacticIds) {
		getService().addUserSegmentTactics(userSegmentId, tacticIds);
	}

	public static void clearUserSegmentTactics(long userSegmentId) {
		getService().clearUserSegmentTactics(userSegmentId);
	}

	/**
	* Creates a new tactic with the primary key. Does not add the tactic to the database.
	*
	* @param tacticId the primary key for the new tactic
	* @return the new tactic
	*/
	public static com.liferay.content.targeting.model.Tactic createTactic(
		long tacticId) {
		return getService().createTactic(tacticId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the tactic from the database. Also notifies the appropriate model listeners.
	*
	* @param tactic the tactic
	* @return the tactic that was removed
	* @throws PortalException
	*/
	public static com.liferay.content.targeting.model.Tactic deleteTactic(
		com.liferay.content.targeting.model.Tactic tactic)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTactic(tactic);
	}

	/**
	* Deletes the tactic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tacticId the primary key of the tactic
	* @return the tactic that was removed
	* @throws PortalException if a tactic with the primary key could not be found
	*/
	public static com.liferay.content.targeting.model.Tactic deleteTactic(
		long tacticId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTactic(tacticId);
	}

	public static void deleteUserSegmentTactic(long userSegmentId,
		com.liferay.content.targeting.model.Tactic tactic) {
		getService().deleteUserSegmentTactic(userSegmentId, tactic);
	}

	public static void deleteUserSegmentTactic(long userSegmentId, long tacticId) {
		getService().deleteUserSegmentTactic(userSegmentId, tacticId);
	}

	public static void deleteUserSegmentTactics(long userSegmentId,
		java.util.List<com.liferay.content.targeting.model.Tactic> Tactics) {
		getService().deleteUserSegmentTactics(userSegmentId, Tactics);
	}

	public static void deleteUserSegmentTactics(long userSegmentId,
		long[] tacticIds) {
		getService().deleteUserSegmentTactics(userSegmentId, tacticIds);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.content.targeting.model.Tactic fetchTactic(
		long tacticId) {
		return getService().fetchTactic(tacticId);
	}

	/**
	* Returns the tactic matching the UUID and group.
	*
	* @param uuid the tactic's UUID
	* @param groupId the primary key of the group
	* @return the matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public static com.liferay.content.targeting.model.Tactic fetchTacticByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchTacticByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
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
	* Returns the tactic with the primary key.
	*
	* @param tacticId the primary key of the tactic
	* @return the tactic
	* @throws PortalException if a tactic with the primary key could not be found
	*/
	public static com.liferay.content.targeting.model.Tactic getTactic(
		long tacticId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTactic(tacticId);
	}

	/**
	* Returns the tactic matching the UUID and group.
	*
	* @param uuid the tactic's UUID
	* @param groupId the primary key of the group
	* @return the matching tactic
	* @throws PortalException if a matching tactic could not be found
	*/
	public static com.liferay.content.targeting.model.Tactic getTacticByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTacticByUuidAndGroupId(uuid, groupId);
	}

	public static java.util.List<com.liferay.content.targeting.model.Tactic> getTactics(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTactics(campaignId);
	}

	public static java.util.List<com.liferay.content.targeting.model.Tactic> getTactics(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTactics(campaignId, start, end, obc);
	}

	/**
	* Returns a range of all the tactics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @return the range of tactics
	*/
	public static java.util.List<com.liferay.content.targeting.model.Tactic> getTactics(
		int start, int end) {
		return getService().getTactics(start, end);
	}

	/**
	* Returns all the tactics matching the UUID and company.
	*
	* @param uuid the UUID of the tactics
	* @param companyId the primary key of the company
	* @return the matching tactics, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.content.targeting.model.Tactic> getTacticsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getTacticsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of tactics matching the UUID and company.
	*
	* @param uuid the UUID of the tactics
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching tactics, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.content.targeting.model.Tactic> getTacticsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.Tactic> orderByComparator) {
		return getService()
				   .getTacticsByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of tactics.
	*
	* @return the number of tactics
	*/
	public static int getTacticsCount() {
		return getService().getTacticsCount();
	}

	public static int getTacticsCount(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTacticsCount(campaignId);
	}

	/**
	* Returns the userSegmentIds of the user segments associated with the tactic.
	*
	* @param tacticId the tacticId of the tactic
	* @return long[] the userSegmentIds of user segments associated with the tactic
	*/
	public static long[] getUserSegmentPrimaryKeys(long tacticId) {
		return getService().getUserSegmentPrimaryKeys(tacticId);
	}

	public static java.util.List<com.liferay.content.targeting.model.Tactic> getUserSegmentTactics(
		long userSegmentId) {
		return getService().getUserSegmentTactics(userSegmentId);
	}

	public static java.util.List<com.liferay.content.targeting.model.Tactic> getUserSegmentTactics(
		long userSegmentId, int start, int end) {
		return getService().getUserSegmentTactics(userSegmentId, start, end);
	}

	public static java.util.List<com.liferay.content.targeting.model.Tactic> getUserSegmentTactics(
		long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.Tactic> orderByComparator) {
		return getService()
				   .getUserSegmentTactics(userSegmentId, start, end,
			orderByComparator);
	}

	public static int getUserSegmentTacticsCount(long userSegmentId) {
		return getService().getUserSegmentTacticsCount(userSegmentId);
	}

	public static boolean hasUserSegmentTactic(long userSegmentId, long tacticId) {
		return getService().hasUserSegmentTactic(userSegmentId, tacticId);
	}

	public static boolean hasUserSegmentTactics(long userSegmentId) {
		return getService().hasUserSegmentTactics(userSegmentId);
	}

	public static com.liferay.content.targeting.util.BaseModelSearchResult<com.liferay.content.targeting.model.Tactic> searchTactics(
		long campaignId, long groupId, java.lang.String keywords, int start,
		int end) throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .searchTactics(campaignId, groupId, keywords, start, end);
	}

	public static com.liferay.content.targeting.util.BaseModelSearchResult<com.liferay.content.targeting.model.Tactic> searchTactics(
		long groupId, java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().searchTactics(groupId, keywords, start, end);
	}

	public static void setUserSegmentTactics(long userSegmentId,
		long[] tacticIds) {
		getService().setUserSegmentTactics(userSegmentId, tacticIds);
	}

	/**
	* Updates the tactic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tactic the tactic
	* @return the tactic that was updated
	*/
	public static com.liferay.content.targeting.model.Tactic updateTactic(
		com.liferay.content.targeting.model.Tactic tactic) {
		return getService().updateTactic(tactic);
	}

	public static com.liferay.content.targeting.model.Tactic updateTactic(
		long tacticId, long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		long[] userSegmentsIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateTactic(tacticId, campaignId, nameMap, descriptionMap,
			userSegmentsIds, serviceContext);
	}

	public static TacticLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TacticLocalService, TacticLocalService> _serviceTracker =
		ServiceTrackerFactory.open(TacticLocalService.class);
}