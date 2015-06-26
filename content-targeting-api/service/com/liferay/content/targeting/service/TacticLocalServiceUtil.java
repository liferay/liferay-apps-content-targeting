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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

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
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.Tactic addTactic(
		com.liferay.content.targeting.model.Tactic tactic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTactic(tactic);
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
	* Deletes the tactic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tacticId the primary key of the tactic
	* @return the tactic that was removed
	* @throws PortalException if a tactic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.Tactic deleteTactic(
		long tacticId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTactic(tacticId);
	}

	/**
	* Deletes the tactic from the database. Also notifies the appropriate model listeners.
	*
	* @param tactic the tactic
	* @return the tactic that was removed
	* @throws PortalException
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.Tactic deleteTactic(
		com.liferay.content.targeting.model.Tactic tactic)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTactic(tactic);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
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
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
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
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.content.targeting.model.Tactic fetchTactic(
		long tacticId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTactic(tacticId);
	}

	/**
	* Returns the tactic with the matching UUID and company.
	*
	* @param uuid the tactic's UUID
	* @param companyId the primary key of the company
	* @return the matching tactic, or <code>null</code> if a matching tactic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.Tactic fetchTacticByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTacticByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the tactic matching the UUID and group.
	*
	* @param uuid the tactic's UUID
	* @param groupId the primary key of the group
	* @return the matching tactic, or <code>null</code> if a matching tactic could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.Tactic fetchTacticByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTacticByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the tactic with the primary key.
	*
	* @param tacticId the primary key of the tactic
	* @return the tactic
	* @throws PortalException if a tactic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.Tactic getTactic(
		long tacticId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTactic(tacticId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static com.liferay.content.targeting.model.Tactic getTacticByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTacticByUuidAndCompanyId(uuid, companyId);
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
	public static com.liferay.content.targeting.model.Tactic getTacticByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTacticByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<com.liferay.content.targeting.model.Tactic> getTactics(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTactics(start, end);
	}

	/**
	* Returns the number of tactics.
	*
	* @return the number of tactics
	* @throws SystemException if a system exception occurred
	*/
	public static int getTacticsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTacticsCount();
	}

	/**
	* Updates the tactic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tactic the tactic
	* @return the tactic that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.Tactic updateTactic(
		com.liferay.content.targeting.model.Tactic tactic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTactic(tactic);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addUserSegmentTactic(long userSegmentId, long tacticId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addUserSegmentTactic(userSegmentId, tacticId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addUserSegmentTactic(long userSegmentId,
		com.liferay.content.targeting.model.Tactic tactic)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addUserSegmentTactic(userSegmentId, tactic);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addUserSegmentTactics(long userSegmentId,
		long[] tacticIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addUserSegmentTactics(userSegmentId, tacticIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addUserSegmentTactics(long userSegmentId,
		java.util.List<com.liferay.content.targeting.model.Tactic> Tactics)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addUserSegmentTactics(userSegmentId, Tactics);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearUserSegmentTactics(long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearUserSegmentTactics(userSegmentId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserSegmentTactic(long userSegmentId, long tacticId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserSegmentTactic(userSegmentId, tacticId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserSegmentTactic(long userSegmentId,
		com.liferay.content.targeting.model.Tactic tactic)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserSegmentTactic(userSegmentId, tactic);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserSegmentTactics(long userSegmentId,
		long[] tacticIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserSegmentTactics(userSegmentId, tacticIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserSegmentTactics(long userSegmentId,
		java.util.List<com.liferay.content.targeting.model.Tactic> Tactics)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserSegmentTactics(userSegmentId, Tactics);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.Tactic> getUserSegmentTactics(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSegmentTactics(userSegmentId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.Tactic> getUserSegmentTactics(
		long userSegmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSegmentTactics(userSegmentId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.Tactic> getUserSegmentTactics(
		long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getUserSegmentTactics(userSegmentId, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserSegmentTacticsCount(long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSegmentTacticsCount(userSegmentId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasUserSegmentTactic(long userSegmentId, long tacticId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasUserSegmentTactic(userSegmentId, tacticId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasUserSegmentTactics(long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasUserSegmentTactics(userSegmentId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setUserSegmentTactics(long userSegmentId,
		long[] tacticIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setUserSegmentTactics(userSegmentId, tacticIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.content.targeting.model.Tactic addTactic(
		long userId, long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		long[] userSegmentsIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addTactic(userId, campaignId, nameMap, descriptionMap,
			userSegmentsIds, serviceContext);
	}

	public static java.util.List<com.liferay.content.targeting.model.Tactic> getResults(
		long campaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getResults(campaignId, start, end);
	}

	public static int getTotal(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTotal(campaignId);
	}

	public static com.liferay.content.targeting.util.BaseModelSearchResult<com.liferay.content.targeting.model.Tactic> searchTactics(
		long campaignId, long groupId, java.lang.String keywords, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchTactics(campaignId, groupId, keywords, start, end);
	}

	public static com.liferay.content.targeting.util.BaseModelSearchResult<com.liferay.content.targeting.model.Tactic> searchTactics(
		long groupId, java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().searchTactics(groupId, keywords, start, end);
	}

	public static com.liferay.content.targeting.model.Tactic updateTactic(
		long tacticId, long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		long[] userSegmentsIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateTactic(tacticId, campaignId, nameMap, descriptionMap,
			userSegmentsIds, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static TacticLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TacticLocalService.class.getName());

			if (invokableLocalService instanceof TacticLocalService) {
				_service = (TacticLocalService)invokableLocalService;
			}
			else {
				_service = new TacticLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(TacticLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(TacticLocalService service) {
	}

	private static TacticLocalService _service;
}