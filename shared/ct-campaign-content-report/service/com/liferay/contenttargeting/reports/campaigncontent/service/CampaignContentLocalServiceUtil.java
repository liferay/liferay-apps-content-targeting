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

package com.liferay.contenttargeting.reports.campaigncontent.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for CampaignContent. This utility wraps
 * {@link com.liferay.contenttargeting.reports.campaigncontent.service.impl.CampaignContentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignContentLocalService
 * @see com.liferay.contenttargeting.reports.campaigncontent.service.base.CampaignContentLocalServiceBaseImpl
 * @see com.liferay.contenttargeting.reports.campaigncontent.service.impl.CampaignContentLocalServiceImpl
 * @generated
 */
public class CampaignContentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.contenttargeting.reports.campaigncontent.service.impl.CampaignContentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the campaign content to the database. Also notifies the appropriate model listeners.
	*
	* @param campaignContent the campaign content
	* @return the campaign content that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.reports.campaigncontent.model.CampaignContent addCampaignContent(
		com.liferay.contenttargeting.reports.campaigncontent.model.CampaignContent campaignContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCampaignContent(campaignContent);
	}

	/**
	* Creates a new campaign content with the primary key. Does not add the campaign content to the database.
	*
	* @param campaignContentId the primary key for the new campaign content
	* @return the new campaign content
	*/
	public static com.liferay.contenttargeting.reports.campaigncontent.model.CampaignContent createCampaignContent(
		long campaignContentId) {
		return getService().createCampaignContent(campaignContentId);
	}

	/**
	* Deletes the campaign content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignContentId the primary key of the campaign content
	* @return the campaign content that was removed
	* @throws PortalException if a campaign content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.reports.campaigncontent.model.CampaignContent deleteCampaignContent(
		long campaignContentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCampaignContent(campaignContentId);
	}

	/**
	* Deletes the campaign content from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignContent the campaign content
	* @return the campaign content that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.reports.campaigncontent.model.CampaignContent deleteCampaignContent(
		com.liferay.contenttargeting.reports.campaigncontent.model.CampaignContent campaignContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCampaignContent(campaignContent);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.reports.campaigncontent.model.impl.CampaignContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.reports.campaigncontent.model.impl.CampaignContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.contenttargeting.reports.campaigncontent.model.CampaignContent fetchCampaignContent(
		long campaignContentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCampaignContent(campaignContentId);
	}

	/**
	* Returns the campaign content with the primary key.
	*
	* @param campaignContentId the primary key of the campaign content
	* @return the campaign content
	* @throws PortalException if a campaign content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.reports.campaigncontent.model.CampaignContent getCampaignContent(
		long campaignContentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignContent(campaignContentId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the campaign contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.reports.campaigncontent.model.impl.CampaignContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign contents
	* @param end the upper bound of the range of campaign contents (not inclusive)
	* @return the range of campaign contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contenttargeting.reports.campaigncontent.model.CampaignContent> getCampaignContents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignContents(start, end);
	}

	/**
	* Returns the number of campaign contents.
	*
	* @return the number of campaign contents
	* @throws SystemException if a system exception occurred
	*/
	public static int getCampaignContentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignContentsCount();
	}

	/**
	* Updates the campaign content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param campaignContent the campaign content
	* @return the campaign content that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.reports.campaigncontent.model.CampaignContent updateCampaignContent(
		com.liferay.contenttargeting.reports.campaigncontent.model.CampaignContent campaignContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCampaignContent(campaignContent);
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

	public static com.liferay.contenttargeting.reports.campaigncontent.model.CampaignContent addCampaignContent(
		long campaignId, java.lang.String className, long classPK,
		java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCampaignContent(campaignId, className, classPK,
			eventType, count);
	}

	public static void checkCampaignContentEvents()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().checkCampaignContentEvents();
	}

	public static com.liferay.contenttargeting.reports.campaigncontent.model.CampaignContent getCampaignContent(
		long campaignId, java.lang.String className, long classPK,
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCampaignContent(campaignId, className, classPK, eventType);
	}

	public static java.util.List<com.liferay.contenttargeting.reports.campaigncontent.model.CampaignContent> getCampaignContents(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignContents(campaignId);
	}

	public static java.util.List<com.liferay.contenttargeting.reports.campaigncontent.model.CampaignContent> getCampaignContents(
		long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignContents(campaignId, modifiedDate);
	}

	public static java.util.List<com.liferay.contenttargeting.reports.campaigncontent.model.CampaignContent> getCampaignContents(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCampaignContents(campaignId, start, end,
			orderByComparator);
	}

	public static int getCampaignContentsCount(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignContentsCount(campaignId);
	}

	public static java.util.Date getLastCampaignContentDate() {
		return getService().getLastCampaignContentDate();
	}

	public static void clearService() {
		_service = null;
	}

	public static CampaignContentLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CampaignContentLocalService.class.getName());

			if (invokableLocalService instanceof CampaignContentLocalService) {
				_service = (CampaignContentLocalService)invokableLocalService;
			}
			else {
				_service = new CampaignContentLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CampaignContentLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CampaignContentLocalService service) {
	}

	private static CampaignContentLocalService _service;
}