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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AnalyticsReferrerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsReferrerLocalService
 * @generated
 */
@ProviderType
public class AnalyticsReferrerLocalServiceWrapper
	implements AnalyticsReferrerLocalService,
		ServiceWrapper<AnalyticsReferrerLocalService> {
	public AnalyticsReferrerLocalServiceWrapper(
		AnalyticsReferrerLocalService analyticsReferrerLocalService) {
		_analyticsReferrerLocalService = analyticsReferrerLocalService;
	}

	@Override
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer addAnalyticsReferrer(
		long analyticsEventId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _analyticsReferrerLocalService.addAnalyticsReferrer(analyticsEventId,
			className, classPK);
	}

	/**
	* Adds the analytics referrer to the database. Also notifies the appropriate model listeners.
	*
	* @param analyticsReferrer the analytics referrer
	* @return the analytics referrer that was added
	*/
	@Override
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer addAnalyticsReferrer(
		com.liferay.content.targeting.analytics.model.AnalyticsReferrer analyticsReferrer) {
		return _analyticsReferrerLocalService.addAnalyticsReferrer(analyticsReferrer);
	}

	/**
	* Creates a new analytics referrer with the primary key. Does not add the analytics referrer to the database.
	*
	* @param analyticsReferrerId the primary key for the new analytics referrer
	* @return the new analytics referrer
	*/
	@Override
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer createAnalyticsReferrer(
		long analyticsReferrerId) {
		return _analyticsReferrerLocalService.createAnalyticsReferrer(analyticsReferrerId);
	}

	/**
	* Deletes the analytics referrer from the database. Also notifies the appropriate model listeners.
	*
	* @param analyticsReferrer the analytics referrer
	* @return the analytics referrer that was removed
	*/
	@Override
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer deleteAnalyticsReferrer(
		com.liferay.content.targeting.analytics.model.AnalyticsReferrer analyticsReferrer) {
		return _analyticsReferrerLocalService.deleteAnalyticsReferrer(analyticsReferrer);
	}

	/**
	* Deletes the analytics referrer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param analyticsReferrerId the primary key of the analytics referrer
	* @return the analytics referrer that was removed
	* @throws PortalException if a analytics referrer with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer deleteAnalyticsReferrer(
		long analyticsReferrerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _analyticsReferrerLocalService.deleteAnalyticsReferrer(analyticsReferrerId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _analyticsReferrerLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _analyticsReferrerLocalService.dynamicQuery();
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
		return _analyticsReferrerLocalService.dynamicQuery(dynamicQuery);
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
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _analyticsReferrerLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _analyticsReferrerLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _analyticsReferrerLocalService.dynamicQueryCount(dynamicQuery);
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
		return _analyticsReferrerLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer fetchAnalyticsReferrer(
		long analyticsReferrerId) {
		return _analyticsReferrerLocalService.fetchAnalyticsReferrer(analyticsReferrerId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _analyticsReferrerLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the analytics referrer with the primary key.
	*
	* @param analyticsReferrerId the primary key of the analytics referrer
	* @return the analytics referrer
	* @throws PortalException if a analytics referrer with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer getAnalyticsReferrer(
		long analyticsReferrerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _analyticsReferrerLocalService.getAnalyticsReferrer(analyticsReferrerId);
	}

	@Override
	public int getAnalyticsReferrerCount(long analyticsEventId,
		java.lang.String className, long classPK) {
		return _analyticsReferrerLocalService.getAnalyticsReferrerCount(analyticsEventId,
			className, classPK);
	}

	@Override
	public int getAnalyticsReferrerCount(long[] analyticsEventIds,
		java.lang.String className, long classPK) {
		return _analyticsReferrerLocalService.getAnalyticsReferrerCount(analyticsEventIds,
			className, classPK);
	}

	@Override
	public int getAnalyticsReferrerCount(java.lang.String className,
		long classPK) {
		return _analyticsReferrerLocalService.getAnalyticsReferrerCount(className,
			classPK);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsReferrer> getAnalyticsReferrers(
		long analyticsEventId) {
		return _analyticsReferrerLocalService.getAnalyticsReferrers(analyticsEventId);
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
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsReferrer> getAnalyticsReferrers(
		int start, int end) {
		return _analyticsReferrerLocalService.getAnalyticsReferrers(start, end);
	}

	/**
	* Returns the number of analytics referrers.
	*
	* @return the number of analytics referrers
	*/
	@Override
	public int getAnalyticsReferrersCount() {
		return _analyticsReferrerLocalService.getAnalyticsReferrersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _analyticsReferrerLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _analyticsReferrerLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _analyticsReferrerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the analytics referrer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param analyticsReferrer the analytics referrer
	* @return the analytics referrer that was updated
	*/
	@Override
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer updateAnalyticsReferrer(
		com.liferay.content.targeting.analytics.model.AnalyticsReferrer analyticsReferrer) {
		return _analyticsReferrerLocalService.updateAnalyticsReferrer(analyticsReferrer);
	}

	@Override
	public AnalyticsReferrerLocalService getWrappedService() {
		return _analyticsReferrerLocalService;
	}

	@Override
	public void setWrappedService(
		AnalyticsReferrerLocalService analyticsReferrerLocalService) {
		_analyticsReferrerLocalService = analyticsReferrerLocalService;
	}

	private AnalyticsReferrerLocalService _analyticsReferrerLocalService;
}