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

package com.liferay.contenttargeting.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for UserSegment. This utility wraps
 * {@link com.liferay.contenttargeting.service.impl.UserSegmentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserSegmentLocalService
 * @see com.liferay.contenttargeting.service.base.UserSegmentLocalServiceBaseImpl
 * @see com.liferay.contenttargeting.service.impl.UserSegmentLocalServiceImpl
 * @generated
 */
public class UserSegmentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.contenttargeting.service.impl.UserSegmentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user segment to the database. Also notifies the appropriate model listeners.
	*
	* @param userSegment the user segment
	* @return the user segment that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.UserSegment addUserSegment(
		com.liferay.contenttargeting.model.UserSegment userSegment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserSegment(userSegment);
	}

	/**
	* Creates a new user segment with the primary key. Does not add the user segment to the database.
	*
	* @param userSegmentId the primary key for the new user segment
	* @return the new user segment
	*/
	public static com.liferay.contenttargeting.model.UserSegment createUserSegment(
		long userSegmentId) {
		return getService().createUserSegment(userSegmentId);
	}

	/**
	* Deletes the user segment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userSegmentId the primary key of the user segment
	* @return the user segment that was removed
	* @throws PortalException if a user segment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.UserSegment deleteUserSegment(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserSegment(userSegmentId);
	}

	/**
	* Deletes the user segment from the database. Also notifies the appropriate model listeners.
	*
	* @param userSegment the user segment
	* @return the user segment that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.UserSegment deleteUserSegment(
		com.liferay.contenttargeting.model.UserSegment userSegment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserSegment(userSegment);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.contenttargeting.model.UserSegment fetchUserSegment(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUserSegment(userSegmentId);
	}

	/**
	* Returns the user segment with the matching UUID and company.
	*
	* @param uuid the user segment's UUID
	* @param companyId the primary key of the company
	* @return the matching user segment, or <code>null</code> if a matching user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.UserSegment fetchUserSegmentByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUserSegmentByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the user segment matching the UUID and group.
	*
	* @param uuid the user segment's UUID
	* @param groupId the primary key of the group
	* @return the matching user segment, or <code>null</code> if a matching user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.UserSegment fetchUserSegmentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUserSegmentByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the user segment with the primary key.
	*
	* @param userSegmentId the primary key of the user segment
	* @return the user segment
	* @throws PortalException if a user segment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.UserSegment getUserSegment(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSegment(userSegmentId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the user segment with the matching UUID and company.
	*
	* @param uuid the user segment's UUID
	* @param companyId the primary key of the company
	* @return the matching user segment
	* @throws PortalException if a matching user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.UserSegment getUserSegmentByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSegmentByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the user segment matching the UUID and group.
	*
	* @param uuid the user segment's UUID
	* @param groupId the primary key of the group
	* @return the matching user segment
	* @throws PortalException if a matching user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.UserSegment getUserSegmentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSegmentByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the user segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @return the range of user segments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contenttargeting.model.UserSegment> getUserSegments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSegments(start, end);
	}

	/**
	* Returns the number of user segments.
	*
	* @return the number of user segments
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserSegmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSegmentsCount();
	}

	/**
	* Updates the user segment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userSegment the user segment
	* @return the user segment that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.UserSegment updateUserSegment(
		com.liferay.contenttargeting.model.UserSegment userSegment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserSegment(userSegment);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addCampaignUserSegment(long campaignId,
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addCampaignUserSegment(campaignId, userSegmentId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addCampaignUserSegment(long campaignId,
		com.liferay.contenttargeting.model.UserSegment userSegment)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addCampaignUserSegment(campaignId, userSegment);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addCampaignUserSegments(long campaignId,
		long[] userSegmentIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addCampaignUserSegments(campaignId, userSegmentIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addCampaignUserSegments(long campaignId,
		java.util.List<com.liferay.contenttargeting.model.UserSegment> UserSegments)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addCampaignUserSegments(campaignId, UserSegments);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearCampaignUserSegments(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearCampaignUserSegments(campaignId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCampaignUserSegment(long campaignId,
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCampaignUserSegment(campaignId, userSegmentId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCampaignUserSegment(long campaignId,
		com.liferay.contenttargeting.model.UserSegment userSegment)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCampaignUserSegment(campaignId, userSegment);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCampaignUserSegments(long campaignId,
		long[] userSegmentIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCampaignUserSegments(campaignId, userSegmentIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCampaignUserSegments(long campaignId,
		java.util.List<com.liferay.contenttargeting.model.UserSegment> UserSegments)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCampaignUserSegments(campaignId, UserSegments);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contenttargeting.model.UserSegment> getCampaignUserSegments(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignUserSegments(campaignId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contenttargeting.model.UserSegment> getCampaignUserSegments(
		long campaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignUserSegments(campaignId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contenttargeting.model.UserSegment> getCampaignUserSegments(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCampaignUserSegments(campaignId, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getCampaignUserSegmentsCount(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignUserSegmentsCount(campaignId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasCampaignUserSegment(long campaignId,
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasCampaignUserSegment(campaignId, userSegmentId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasCampaignUserSegments(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasCampaignUserSegments(campaignId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setCampaignUserSegments(long campaignId,
		long[] userSegmentIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setCampaignUserSegments(campaignId, userSegmentIds);
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

	public static com.liferay.contenttargeting.model.UserSegment addUserSegment(
		long userId, java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addUserSegment(userId, nameMap, descriptionMap,
			serviceContext);
	}

	public static java.util.List<com.liferay.contenttargeting.model.UserSegment> getUserSegments(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSegments(groupId);
	}

	public static java.util.List<com.liferay.contenttargeting.model.UserSegment> getUserSegments(
		long[] groupIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSegments(groupIds);
	}

	public static int getUserSegmentsCount(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSegmentsCount(groupId);
	}

	public static int getUserSegmentsCount(long[] groupIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSegmentsCount(groupIds);
	}

	public static com.liferay.portal.kernel.search.Hits search(long groupId,
		java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().search(groupId, keywords, start, end);
	}

	public static com.liferay.contenttargeting.util.BaseModelSearchResult<com.liferay.contenttargeting.model.UserSegment> searchUserSegments(
		long groupId, java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().searchUserSegments(groupId, keywords, start, end);
	}

	public static com.liferay.contenttargeting.model.UserSegment updateUserSegment(
		long userSegmentId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateUserSegment(userSegmentId, nameMap, descriptionMap,
			serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static UserSegmentLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UserSegmentLocalService.class.getName());

			if (invokableLocalService instanceof UserSegmentLocalService) {
				_service = (UserSegmentLocalService)invokableLocalService;
			}
			else {
				_service = new UserSegmentLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UserSegmentLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(UserSegmentLocalService service) {
	}

	private static UserSegmentLocalService _service;
}