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
 * Provides a wrapper for {@link TacticLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TacticLocalService
 * @generated
 */
@ProviderType
public class TacticLocalServiceWrapper implements TacticLocalService,
	ServiceWrapper<TacticLocalService> {
	public TacticLocalServiceWrapper(TacticLocalService tacticLocalService) {
		_tacticLocalService = tacticLocalService;
	}

	/**
	* Adds the tactic to the database. Also notifies the appropriate model listeners.
	*
	* @param tactic the tactic
	* @return the tactic that was added
	*/
	@Override
	public com.liferay.content.targeting.model.Tactic addTactic(
		com.liferay.content.targeting.model.Tactic tactic) {
		return _tacticLocalService.addTactic(tactic);
	}

	@Override
	public com.liferay.content.targeting.model.Tactic addTactic(long userId,
		long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		long[] userSegmentsIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tacticLocalService.addTactic(userId, campaignId, nameMap,
			descriptionMap, userSegmentsIds, serviceContext);
	}

	@Override
	public void addUserSegmentTactic(long userSegmentId,
		com.liferay.content.targeting.model.Tactic tactic) {
		_tacticLocalService.addUserSegmentTactic(userSegmentId, tactic);
	}

	@Override
	public void addUserSegmentTactic(long userSegmentId, long tacticId) {
		_tacticLocalService.addUserSegmentTactic(userSegmentId, tacticId);
	}

	@Override
	public void addUserSegmentTactics(long userSegmentId,
		java.util.List<com.liferay.content.targeting.model.Tactic> Tactics) {
		_tacticLocalService.addUserSegmentTactics(userSegmentId, Tactics);
	}

	@Override
	public void addUserSegmentTactics(long userSegmentId, long[] tacticIds) {
		_tacticLocalService.addUserSegmentTactics(userSegmentId, tacticIds);
	}

	@Override
	public void clearUserSegmentTactics(long userSegmentId) {
		_tacticLocalService.clearUserSegmentTactics(userSegmentId);
	}

	/**
	* Creates a new tactic with the primary key. Does not add the tactic to the database.
	*
	* @param tacticId the primary key for the new tactic
	* @return the new tactic
	*/
	@Override
	public com.liferay.content.targeting.model.Tactic createTactic(
		long tacticId) {
		return _tacticLocalService.createTactic(tacticId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tacticLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the tactic from the database. Also notifies the appropriate model listeners.
	*
	* @param tactic the tactic
	* @return the tactic that was removed
	* @throws PortalException
	*/
	@Override
	public com.liferay.content.targeting.model.Tactic deleteTactic(
		com.liferay.content.targeting.model.Tactic tactic)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tacticLocalService.deleteTactic(tactic);
	}

	/**
	* Deletes the tactic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tacticId the primary key of the tactic
	* @return the tactic that was removed
	* @throws PortalException if a tactic with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.Tactic deleteTactic(
		long tacticId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tacticLocalService.deleteTactic(tacticId);
	}

	@Override
	public void deleteUserSegmentTactic(long userSegmentId,
		com.liferay.content.targeting.model.Tactic tactic) {
		_tacticLocalService.deleteUserSegmentTactic(userSegmentId, tactic);
	}

	@Override
	public void deleteUserSegmentTactic(long userSegmentId, long tacticId) {
		_tacticLocalService.deleteUserSegmentTactic(userSegmentId, tacticId);
	}

	@Override
	public void deleteUserSegmentTactics(long userSegmentId,
		java.util.List<com.liferay.content.targeting.model.Tactic> Tactics) {
		_tacticLocalService.deleteUserSegmentTactics(userSegmentId, Tactics);
	}

	@Override
	public void deleteUserSegmentTactics(long userSegmentId, long[] tacticIds) {
		_tacticLocalService.deleteUserSegmentTactics(userSegmentId, tacticIds);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tacticLocalService.dynamicQuery();
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
		return _tacticLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _tacticLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _tacticLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _tacticLocalService.dynamicQueryCount(dynamicQuery);
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
		return _tacticLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.content.targeting.model.Tactic fetchTactic(long tacticId) {
		return _tacticLocalService.fetchTactic(tacticId);
	}

	/**
	* Returns the tactic matching the UUID and group.
	*
	* @param uuid the tactic's UUID
	* @param groupId the primary key of the group
	* @return the matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.Tactic fetchTacticByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _tacticLocalService.fetchTacticByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _tacticLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _tacticLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _tacticLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _tacticLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tacticLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the tactic with the primary key.
	*
	* @param tacticId the primary key of the tactic
	* @return the tactic
	* @throws PortalException if a tactic with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.Tactic getTactic(long tacticId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tacticLocalService.getTactic(tacticId);
	}

	/**
	* Returns the tactic matching the UUID and group.
	*
	* @param uuid the tactic's UUID
	* @param groupId the primary key of the group
	* @return the matching tactic
	* @throws PortalException if a matching tactic could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.Tactic getTacticByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tacticLocalService.getTacticByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.Tactic> getTactics(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tacticLocalService.getTactics(campaignId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.Tactic> getTactics(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tacticLocalService.getTactics(campaignId, start, end, obc);
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
	@Override
	public java.util.List<com.liferay.content.targeting.model.Tactic> getTactics(
		int start, int end) {
		return _tacticLocalService.getTactics(start, end);
	}

	/**
	* Returns all the tactics matching the UUID and company.
	*
	* @param uuid the UUID of the tactics
	* @param companyId the primary key of the company
	* @return the matching tactics, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.model.Tactic> getTacticsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _tacticLocalService.getTacticsByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.liferay.content.targeting.model.Tactic> getTacticsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.Tactic> orderByComparator) {
		return _tacticLocalService.getTacticsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of tactics.
	*
	* @return the number of tactics
	*/
	@Override
	public int getTacticsCount() {
		return _tacticLocalService.getTacticsCount();
	}

	@Override
	public int getTacticsCount(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tacticLocalService.getTacticsCount(campaignId);
	}

	/**
	* Returns the userSegmentIds of the user segments associated with the tactic.
	*
	* @param tacticId the tacticId of the tactic
	* @return long[] the userSegmentIds of user segments associated with the tactic
	*/
	@Override
	public long[] getUserSegmentPrimaryKeys(long tacticId) {
		return _tacticLocalService.getUserSegmentPrimaryKeys(tacticId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.Tactic> getUserSegmentTactics(
		long userSegmentId) {
		return _tacticLocalService.getUserSegmentTactics(userSegmentId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.Tactic> getUserSegmentTactics(
		long userSegmentId, int start, int end) {
		return _tacticLocalService.getUserSegmentTactics(userSegmentId, start,
			end);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.Tactic> getUserSegmentTactics(
		long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.Tactic> orderByComparator) {
		return _tacticLocalService.getUserSegmentTactics(userSegmentId, start,
			end, orderByComparator);
	}

	@Override
	public int getUserSegmentTacticsCount(long userSegmentId) {
		return _tacticLocalService.getUserSegmentTacticsCount(userSegmentId);
	}

	@Override
	public boolean hasUserSegmentTactic(long userSegmentId, long tacticId) {
		return _tacticLocalService.hasUserSegmentTactic(userSegmentId, tacticId);
	}

	@Override
	public boolean hasUserSegmentTactics(long userSegmentId) {
		return _tacticLocalService.hasUserSegmentTactics(userSegmentId);
	}

	@Override
	public com.liferay.content.targeting.util.BaseModelSearchResult<com.liferay.content.targeting.model.Tactic> searchTactics(
		long campaignId, long groupId, java.lang.String keywords, int start,
		int end) throws com.liferay.portal.kernel.exception.PortalException {
		return _tacticLocalService.searchTactics(campaignId, groupId, keywords,
			start, end);
	}

	@Override
	public com.liferay.content.targeting.util.BaseModelSearchResult<com.liferay.content.targeting.model.Tactic> searchTactics(
		long groupId, java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tacticLocalService.searchTactics(groupId, keywords, start, end);
	}

	@Override
	public void setUserSegmentTactics(long userSegmentId, long[] tacticIds) {
		_tacticLocalService.setUserSegmentTactics(userSegmentId, tacticIds);
	}

	/**
	* Updates the tactic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tactic the tactic
	* @return the tactic that was updated
	*/
	@Override
	public com.liferay.content.targeting.model.Tactic updateTactic(
		com.liferay.content.targeting.model.Tactic tactic) {
		return _tacticLocalService.updateTactic(tactic);
	}

	@Override
	public com.liferay.content.targeting.model.Tactic updateTactic(
		long tacticId, long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		long[] userSegmentsIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tacticLocalService.updateTactic(tacticId, campaignId, nameMap,
			descriptionMap, userSegmentsIds, serviceContext);
	}

	@Override
	public TacticLocalService getWrappedService() {
		return _tacticLocalService;
	}

	@Override
	public void setWrappedService(TacticLocalService tacticLocalService) {
		_tacticLocalService = tacticLocalService;
	}

	private TacticLocalService _tacticLocalService;
}