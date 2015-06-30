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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TacticLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TacticLocalService
 * @generated
 */
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
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.model.Tactic addTactic(
		com.liferay.content.targeting.model.Tactic tactic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.addTactic(tactic);
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
	* Deletes the tactic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tacticId the primary key of the tactic
	* @return the tactic that was removed
	* @throws PortalException if a tactic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.model.Tactic deleteTactic(
		long tacticId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.deleteTactic(tacticId);
	}

	/**
	* Deletes the tactic from the database. Also notifies the appropriate model listeners.
	*
	* @param tactic the tactic
	* @return the tactic that was removed
	* @throws PortalException
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.model.Tactic deleteTactic(
		com.liferay.content.targeting.model.Tactic tactic)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.deleteTactic(tactic);
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
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
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
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
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
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.content.targeting.model.Tactic fetchTactic(long tacticId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.fetchTactic(tacticId);
	}

	/**
	* Returns the tactic with the matching UUID and company.
	*
	* @param uuid the tactic's UUID
	* @param companyId the primary key of the company
	* @return the matching tactic, or <code>null</code> if a matching tactic could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.model.Tactic fetchTacticByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.fetchTacticByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the tactic matching the UUID and group.
	*
	* @param uuid the tactic's UUID
	* @param groupId the primary key of the group
	* @return the matching tactic, or <code>null</code> if a matching tactic could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.model.Tactic fetchTacticByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.fetchTacticByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the tactic with the primary key.
	*
	* @param tacticId the primary key of the tactic
	* @return the tactic
	* @throws PortalException if a tactic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.model.Tactic getTactic(long tacticId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.getTactic(tacticId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the tactic with the matching UUID and company.
	*
	* @param uuid the tactic's UUID
	* @param companyId the primary key of the company
	* @return the matching tactic
	* @throws PortalException if a matching tactic could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.model.Tactic getTacticByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.getTacticByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the tactic matching the UUID and group.
	*
	* @param uuid the tactic's UUID
	* @param groupId the primary key of the group
	* @return the matching tactic
	* @throws PortalException if a matching tactic could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.model.Tactic getTacticByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.getTacticByUuidAndGroupId(uuid, groupId);
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
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.model.Tactic> getTactics(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.getTactics(start, end);
	}

	/**
	* Returns the number of tactics.
	*
	* @return the number of tactics
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTacticsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.getTacticsCount();
	}

	/**
	* Updates the tactic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tactic the tactic
	* @return the tactic that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.model.Tactic updateTactic(
		com.liferay.content.targeting.model.Tactic tactic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.updateTactic(tactic);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addUserSegmentTactic(long userSegmentId, long tacticId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_tacticLocalService.addUserSegmentTactic(userSegmentId, tacticId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addUserSegmentTactic(long userSegmentId,
		com.liferay.content.targeting.model.Tactic tactic)
		throws com.liferay.portal.kernel.exception.SystemException {
		_tacticLocalService.addUserSegmentTactic(userSegmentId, tactic);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addUserSegmentTactics(long userSegmentId, long[] tacticIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_tacticLocalService.addUserSegmentTactics(userSegmentId, tacticIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addUserSegmentTactics(long userSegmentId,
		java.util.List<com.liferay.content.targeting.model.Tactic> Tactics)
		throws com.liferay.portal.kernel.exception.SystemException {
		_tacticLocalService.addUserSegmentTactics(userSegmentId, Tactics);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearUserSegmentTactics(long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_tacticLocalService.clearUserSegmentTactics(userSegmentId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteUserSegmentTactic(long userSegmentId, long tacticId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_tacticLocalService.deleteUserSegmentTactic(userSegmentId, tacticId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteUserSegmentTactic(long userSegmentId,
		com.liferay.content.targeting.model.Tactic tactic)
		throws com.liferay.portal.kernel.exception.SystemException {
		_tacticLocalService.deleteUserSegmentTactic(userSegmentId, tactic);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteUserSegmentTactics(long userSegmentId, long[] tacticIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_tacticLocalService.deleteUserSegmentTactics(userSegmentId, tacticIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteUserSegmentTactics(long userSegmentId,
		java.util.List<com.liferay.content.targeting.model.Tactic> Tactics)
		throws com.liferay.portal.kernel.exception.SystemException {
		_tacticLocalService.deleteUserSegmentTactics(userSegmentId, Tactics);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.model.Tactic> getUserSegmentTactics(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.getUserSegmentTactics(userSegmentId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.model.Tactic> getUserSegmentTactics(
		long userSegmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.getUserSegmentTactics(userSegmentId, start,
			end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.model.Tactic> getUserSegmentTactics(
		long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.getUserSegmentTactics(userSegmentId, start,
			end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUserSegmentTacticsCount(long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.getUserSegmentTacticsCount(userSegmentId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasUserSegmentTactic(long userSegmentId, long tacticId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.hasUserSegmentTactic(userSegmentId, tacticId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasUserSegmentTactics(long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.hasUserSegmentTactics(userSegmentId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setUserSegmentTactics(long userSegmentId, long[] tacticIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_tacticLocalService.setUserSegmentTactics(userSegmentId, tacticIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tacticLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tacticLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tacticLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.liferay.content.targeting.model.Tactic addTactic(long userId,
		long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		long[] userSegmentsIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.addTactic(userId, campaignId, nameMap,
			descriptionMap, userSegmentsIds, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.Tactic> getResults(
		long campaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.getResults(campaignId, start, end);
	}

	@Override
	public int getTotal(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.getTotal(campaignId);
	}

	@Override
	public com.liferay.content.targeting.util.BaseModelSearchResult<com.liferay.content.targeting.model.Tactic> searchTactics(
		long campaignId, long groupId, java.lang.String keywords, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.searchTactics(campaignId, groupId, keywords,
			start, end);
	}

	@Override
	public com.liferay.content.targeting.util.BaseModelSearchResult<com.liferay.content.targeting.model.Tactic> searchTactics(
		long groupId, java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.searchTactics(groupId, keywords, start, end);
	}

	@Override
	public com.liferay.content.targeting.model.Tactic updateTactic(
		long tacticId, long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		long[] userSegmentsIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tacticLocalService.updateTactic(tacticId, campaignId, nameMap,
			descriptionMap, userSegmentsIds, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TacticLocalService getWrappedTacticLocalService() {
		return _tacticLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTacticLocalService(
		TacticLocalService tacticLocalService) {
		_tacticLocalService = tacticLocalService;
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