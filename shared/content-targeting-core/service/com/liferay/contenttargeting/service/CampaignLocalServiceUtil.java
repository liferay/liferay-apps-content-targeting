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
 * Provides the local service utility for Campaign. This utility wraps
 * {@link com.liferay.contenttargeting.service.impl.CampaignLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignLocalService
 * @see com.liferay.contenttargeting.service.base.CampaignLocalServiceBaseImpl
 * @see com.liferay.contenttargeting.service.impl.CampaignLocalServiceImpl
 * @generated
 */
public class CampaignLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.contenttargeting.service.impl.CampaignLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the campaign to the database. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.Campaign addCampaign(
		com.liferay.contenttargeting.model.Campaign campaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCampaign(campaign);
	}

	/**
	* Creates a new campaign with the primary key. Does not add the campaign to the database.
	*
	* @param campaignId the primary key for the new campaign
	* @return the new campaign
	*/
	public static com.liferay.contenttargeting.model.Campaign createCampaign(
		long campaignId) {
		return getService().createCampaign(campaignId);
	}

	/**
	* Deletes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign that was removed
	* @throws PortalException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.Campaign deleteCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCampaign(campaignId);
	}

	/**
	* Deletes the campaign from the database. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.Campaign deleteCampaign(
		com.liferay.contenttargeting.model.Campaign campaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCampaign(campaign);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.contenttargeting.model.Campaign fetchCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCampaign(campaignId);
	}

	/**
	* Returns the campaign with the matching UUID and company.
	*
	* @param uuid the campaign's UUID
	* @param companyId the primary key of the company
	* @return the matching campaign, or <code>null</code> if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.Campaign fetchCampaignByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCampaignByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the campaign matching the UUID and group.
	*
	* @param uuid the campaign's UUID
	* @param groupId the primary key of the group
	* @return the matching campaign, or <code>null</code> if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.Campaign fetchCampaignByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCampaignByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the campaign with the primary key.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign
	* @throws PortalException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.Campaign getCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaign(campaignId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the campaign with the matching UUID and company.
	*
	* @param uuid the campaign's UUID
	* @param companyId the primary key of the company
	* @return the matching campaign
	* @throws PortalException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.Campaign getCampaignByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the campaign matching the UUID and group.
	*
	* @param uuid the campaign's UUID
	* @param groupId the primary key of the group
	* @return the matching campaign
	* @throws PortalException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.Campaign getCampaignByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contenttargeting.model.Campaign> getCampaigns(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaigns(start, end);
	}

	/**
	* Returns the number of campaigns.
	*
	* @return the number of campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int getCampaignsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignsCount();
	}

	/**
	* Updates the campaign in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.Campaign updateCampaign(
		com.liferay.contenttargeting.model.Campaign campaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCampaign(campaign);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addUserSegmentCampaign(long userSegmentId,
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addUserSegmentCampaign(userSegmentId, campaignId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addUserSegmentCampaign(long userSegmentId,
		com.liferay.contenttargeting.model.Campaign campaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addUserSegmentCampaign(userSegmentId, campaign);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addUserSegmentCampaigns(long userSegmentId,
		long[] campaignIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addUserSegmentCampaigns(userSegmentId, campaignIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addUserSegmentCampaigns(long userSegmentId,
		java.util.List<com.liferay.contenttargeting.model.Campaign> Campaigns)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addUserSegmentCampaigns(userSegmentId, Campaigns);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearUserSegmentCampaigns(long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearUserSegmentCampaigns(userSegmentId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserSegmentCampaign(long userSegmentId,
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserSegmentCampaign(userSegmentId, campaignId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserSegmentCampaign(long userSegmentId,
		com.liferay.contenttargeting.model.Campaign campaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserSegmentCampaign(userSegmentId, campaign);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserSegmentCampaigns(long userSegmentId,
		long[] campaignIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserSegmentCampaigns(userSegmentId, campaignIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserSegmentCampaigns(long userSegmentId,
		java.util.List<com.liferay.contenttargeting.model.Campaign> Campaigns)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserSegmentCampaigns(userSegmentId, Campaigns);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contenttargeting.model.Campaign> getUserSegmentCampaigns(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSegmentCampaigns(userSegmentId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contenttargeting.model.Campaign> getUserSegmentCampaigns(
		long userSegmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSegmentCampaigns(userSegmentId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contenttargeting.model.Campaign> getUserSegmentCampaigns(
		long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getUserSegmentCampaigns(userSegmentId, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserSegmentCampaignsCount(long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSegmentCampaignsCount(userSegmentId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasUserSegmentCampaign(long userSegmentId,
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasUserSegmentCampaign(userSegmentId, campaignId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasUserSegmentCampaigns(long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasUserSegmentCampaigns(userSegmentId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setUserSegmentCampaigns(long userSegmentId,
		long[] campaignIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setUserSegmentCampaigns(userSegmentId, campaignIds);
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

	public static com.liferay.contenttargeting.model.Campaign addCampaign(
		long userId, java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate, int priority,
		long[] userSegmentIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCampaign(userId, nameMap, descriptionMap, startDate,
			endDate, priority, userSegmentIds, serviceContext);
	}

	public static com.liferay.contenttargeting.model.Campaign fetchCurrentMaxPriorityCampaign(
		long groupId, long[] userSegmentIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchCurrentMaxPriorityCampaign(groupId, userSegmentIds);
	}

	public static java.util.List<com.liferay.contenttargeting.model.Campaign> getCampaigns(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaigns(groupId);
	}

	public static java.util.List<com.liferay.contenttargeting.model.Campaign> getCampaigns(
		long[] groupIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaigns(groupIds);
	}

	public static long getCampaignsCount(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignsCount(groupId);
	}

	public static long getCampaignsCount(long[] groupIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignsCount(groupIds);
	}

	public static com.liferay.portal.kernel.search.Hits search(long groupId,
		java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().search(groupId, keywords, start, end);
	}

	public static com.liferay.contenttargeting.util.BaseModelSearchResult<com.liferay.contenttargeting.model.Campaign> searchCampaigns(
		long groupId, java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().searchCampaigns(groupId, keywords, start, end);
	}

	public static com.liferay.contenttargeting.model.Campaign updateCampaign(
		long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate, int priority,
		long[] userSegmentIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCampaign(campaignId, nameMap, descriptionMap,
			startDate, endDate, priority, userSegmentIds, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static CampaignLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CampaignLocalService.class.getName());

			if (invokableLocalService instanceof CampaignLocalService) {
				_service = (CampaignLocalService)invokableLocalService;
			}
			else {
				_service = new CampaignLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CampaignLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CampaignLocalService service) {
	}

	private static CampaignLocalService _service;
}