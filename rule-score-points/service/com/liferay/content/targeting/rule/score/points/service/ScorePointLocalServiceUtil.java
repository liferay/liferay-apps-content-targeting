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

package com.liferay.content.targeting.rule.score.points.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ScorePoint. This utility wraps
 * {@link com.liferay.content.targeting.rule.score.points.service.impl.ScorePointLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ScorePointLocalService
 * @see com.liferay.content.targeting.rule.score.points.service.base.ScorePointLocalServiceBaseImpl
 * @see com.liferay.content.targeting.rule.score.points.service.impl.ScorePointLocalServiceImpl
 * @generated
 */
public class ScorePointLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.rule.score.points.service.impl.ScorePointLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the score point to the database. Also notifies the appropriate model listeners.
	*
	* @param scorePoint the score point
	* @return the score point that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint addScorePoint(
		com.liferay.content.targeting.rule.score.points.model.ScorePoint scorePoint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addScorePoint(scorePoint);
	}

	/**
	* Creates a new score point with the primary key. Does not add the score point to the database.
	*
	* @param scorePointId the primary key for the new score point
	* @return the new score point
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint createScorePoint(
		long scorePointId) {
		return getService().createScorePoint(scorePointId);
	}

	/**
	* Deletes the score point with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scorePointId the primary key of the score point
	* @return the score point that was removed
	* @throws PortalException if a score point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint deleteScorePoint(
		long scorePointId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteScorePoint(scorePointId);
	}

	/**
	* Deletes the score point from the database. Also notifies the appropriate model listeners.
	*
	* @param scorePoint the score point
	* @return the score point that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint deleteScorePoint(
		com.liferay.content.targeting.rule.score.points.model.ScorePoint scorePoint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteScorePoint(scorePoint);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.score.points.model.impl.ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.score.points.model.impl.ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint fetchScorePoint(
		long scorePointId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchScorePoint(scorePointId);
	}

	/**
	* Returns the score point with the primary key.
	*
	* @param scorePointId the primary key of the score point
	* @return the score point
	* @throws PortalException if a score point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint getScorePoint(
		long scorePointId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getScorePoint(scorePointId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the score points.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.score.points.model.impl.ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @return the range of score points
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.rule.score.points.model.ScorePoint> getScorePoints(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScorePoints(start, end);
	}

	/**
	* Returns the number of score points.
	*
	* @return the number of score points
	* @throws SystemException if a system exception occurred
	*/
	public static int getScorePointsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScorePointsCount();
	}

	/**
	* Updates the score point in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scorePoint the score point
	* @return the score point that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint updateScorePoint(
		com.liferay.content.targeting.rule.score.points.model.ScorePoint scorePoint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateScorePoint(scorePoint);
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

	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint addScorePoints(
		long anonymousUserId, long userSegmentId, long points)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addScorePoints(anonymousUserId, userSegmentId, points);
	}

	public static long getPoints(long anonymousUserId, long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPoints(anonymousUserId, userSegmentId);
	}

	public static java.util.List<com.liferay.content.targeting.rule.score.points.model.ScorePoint> getScorePoints(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScorePoints(userSegmentId);
	}

	public static long incrementPoints(long anonymousUserId,
		long userSegmentId, long points)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .incrementPoints(anonymousUserId, userSegmentId, points);
	}

	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint updateScorePoints(
		long anonymousUserId, long userSegmentId, long points)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateScorePoints(anonymousUserId, userSegmentId, points);
	}

	public static void clearService() {
		_service = null;
	}

	public static ScorePointLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ScorePointLocalService.class.getName());

			if (invokableLocalService instanceof ScorePointLocalService) {
				_service = (ScorePointLocalService)invokableLocalService;
			}
			else {
				_service = new ScorePointLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ScorePointLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ScorePointLocalService service) {
	}

	private static ScorePointLocalService _service;
}