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

package com.liferay.content.targeting.analytics.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for AnalyticsReferrer. This utility wraps
 * {@link com.liferay.content.targeting.analytics.service.impl.AnalyticsReferrerLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsReferrerLocalService
 * @see com.liferay.content.targeting.analytics.service.base.AnalyticsReferrerLocalServiceBaseImpl
 * @see com.liferay.content.targeting.analytics.service.impl.AnalyticsReferrerLocalServiceImpl
 * @generated
 */
public class AnalyticsReferrerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.analytics.service.impl.AnalyticsReferrerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the analytics referrer to the database. Also notifies the appropriate model listeners.
	*
	* @param analyticsReferrer the analytics referrer
	* @return the analytics referrer that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.analytics.model.AnalyticsReferrer addAnalyticsReferrer(
		com.liferay.content.targeting.analytics.model.AnalyticsReferrer analyticsReferrer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAnalyticsReferrer(analyticsReferrer);
	}

	/**
	* Creates a new analytics referrer with the primary key. Does not add the analytics referrer to the database.
	*
	* @param analyticsReferrerId the primary key for the new analytics referrer
	* @return the new analytics referrer
	*/
	public static com.liferay.content.targeting.analytics.model.AnalyticsReferrer createAnalyticsReferrer(
		long analyticsReferrerId) {
		return getService().createAnalyticsReferrer(analyticsReferrerId);
	}

	/**
	* Deletes the analytics referrer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param analyticsReferrerId the primary key of the analytics referrer
	* @return the analytics referrer that was removed
	* @throws PortalException if a analytics referrer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.analytics.model.AnalyticsReferrer deleteAnalyticsReferrer(
		long analyticsReferrerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAnalyticsReferrer(analyticsReferrerId);
	}

	/**
	* Deletes the analytics referrer from the database. Also notifies the appropriate model listeners.
	*
	* @param analyticsReferrer the analytics referrer
	* @return the analytics referrer that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.analytics.model.AnalyticsReferrer deleteAnalyticsReferrer(
		com.liferay.content.targeting.analytics.model.AnalyticsReferrer analyticsReferrer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAnalyticsReferrer(analyticsReferrer);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.analytics.model.impl.AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.analytics.model.impl.AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.content.targeting.analytics.model.AnalyticsReferrer fetchAnalyticsReferrer(
		long analyticsReferrerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAnalyticsReferrer(analyticsReferrerId);
	}

	/**
	* Returns the analytics referrer with the primary key.
	*
	* @param analyticsReferrerId the primary key of the analytics referrer
	* @return the analytics referrer
	* @throws PortalException if a analytics referrer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.analytics.model.AnalyticsReferrer getAnalyticsReferrer(
		long analyticsReferrerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAnalyticsReferrer(analyticsReferrerId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the analytics referrers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.analytics.model.impl.AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @return the range of analytics referrers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsReferrer> getAnalyticsReferrers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAnalyticsReferrers(start, end);
	}

	/**
	* Returns the number of analytics referrers.
	*
	* @return the number of analytics referrers
	* @throws SystemException if a system exception occurred
	*/
	public static int getAnalyticsReferrersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAnalyticsReferrersCount();
	}

	/**
	* Updates the analytics referrer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param analyticsReferrer the analytics referrer
	* @return the analytics referrer that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.analytics.model.AnalyticsReferrer updateAnalyticsReferrer(
		com.liferay.content.targeting.analytics.model.AnalyticsReferrer analyticsReferrer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAnalyticsReferrer(analyticsReferrer);
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

	public static com.liferay.content.targeting.analytics.model.AnalyticsReferrer addAnalyticsReferrer(
		long analyticsEventId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addAnalyticsReferrer(analyticsEventId, className, classPK);
	}

	public static int getAnalyticsReferrerCount(long analyticsEventId,
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getAnalyticsReferrerCount(analyticsEventId, className,
			classPK);
	}

	public static int getAnalyticsReferrerCount(long[] analyticsEventIds,
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getAnalyticsReferrerCount(analyticsEventIds, className,
			classPK);
	}

	public static int getAnalyticsReferrerCount(java.lang.String className,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAnalyticsReferrerCount(className, classPK);
	}

	public static void clearService() {
		_service = null;
	}

	public static AnalyticsReferrerLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AnalyticsReferrerLocalService.class.getName());

			if (invokableLocalService instanceof AnalyticsReferrerLocalService) {
				_service = (AnalyticsReferrerLocalService)invokableLocalService;
			}
			else {
				_service = new AnalyticsReferrerLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AnalyticsReferrerLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(AnalyticsReferrerLocalService service) {
	}

	private static AnalyticsReferrerLocalService _service;
}