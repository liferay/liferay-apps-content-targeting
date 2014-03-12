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

package com.liferay.contenttargeting.rules.scorepoints.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ScorePointLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ScorePointLocalService
 * @generated
 */
public class ScorePointLocalServiceWrapper implements ScorePointLocalService,
	ServiceWrapper<ScorePointLocalService> {
	public ScorePointLocalServiceWrapper(
		ScorePointLocalService scorePointLocalService) {
		_scorePointLocalService = scorePointLocalService;
	}

	/**
	* Adds the score point to the database. Also notifies the appropriate model listeners.
	*
	* @param scorePoint the score point
	* @return the score point that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint addScorePoint(
		com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint scorePoint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scorePointLocalService.addScorePoint(scorePoint);
	}

	/**
	* Creates a new score point with the primary key. Does not add the score point to the database.
	*
	* @param Id the primary key for the new score point
	* @return the new score point
	*/
	@Override
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint createScorePoint(
		long Id) {
		return _scorePointLocalService.createScorePoint(Id);
	}

	/**
	* Deletes the score point with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Id the primary key of the score point
	* @return the score point that was removed
	* @throws PortalException if a score point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint deleteScorePoint(
		long Id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scorePointLocalService.deleteScorePoint(Id);
	}

	/**
	* Deletes the score point from the database. Also notifies the appropriate model listeners.
	*
	* @param scorePoint the score point
	* @return the score point that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint deleteScorePoint(
		com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint scorePoint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scorePointLocalService.deleteScorePoint(scorePoint);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _scorePointLocalService.dynamicQuery();
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
		return _scorePointLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.rules.scorepoints.model.impl.ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _scorePointLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.rules.scorepoints.model.impl.ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _scorePointLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _scorePointLocalService.dynamicQueryCount(dynamicQuery);
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
		return _scorePointLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint fetchScorePoint(
		long Id) throws com.liferay.portal.kernel.exception.SystemException {
		return _scorePointLocalService.fetchScorePoint(Id);
	}

	/**
	* Returns the score point with the primary key.
	*
	* @param Id the primary key of the score point
	* @return the score point
	* @throws PortalException if a score point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint getScorePoint(
		long Id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scorePointLocalService.getScorePoint(Id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scorePointLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the score points.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.rules.scorepoints.model.impl.ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @return the range of score points
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint> getScorePoints(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scorePointLocalService.getScorePoints(start, end);
	}

	/**
	* Returns the number of score points.
	*
	* @return the number of score points
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getScorePointsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scorePointLocalService.getScorePointsCount();
	}

	/**
	* Updates the score point in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scorePoint the score point
	* @return the score point that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint updateScorePoint(
		com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint scorePoint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scorePointLocalService.updateScorePoint(scorePoint);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _scorePointLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_scorePointLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _scorePointLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.liferay.contenttargeting.rules.scorepoints.service.ScorePointLocalServiceUtil} to access the score point local service.
	*/
	@Override
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint addScorePoints(
		long anonymousUserId, long userSegmentId, long points)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scorePointLocalService.addScorePoints(anonymousUserId,
			userSegmentId, points);
	}

	@Override
	public long getPoints(long anonymousUserId, long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scorePointLocalService.getPoints(anonymousUserId, userSegmentId);
	}

	@Override
	public long incrementPoints(long anonymousUserId, long userSegmentId,
		long points) throws com.liferay.portal.kernel.exception.SystemException {
		return _scorePointLocalService.incrementPoints(anonymousUserId,
			userSegmentId, points);
	}

	@Override
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint updateScorePoints(
		long anonymousUserId, long userSegmentId, long points)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scorePointLocalService.updateScorePoints(anonymousUserId,
			userSegmentId, points);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ScorePointLocalService getWrappedScorePointLocalService() {
		return _scorePointLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedScorePointLocalService(
		ScorePointLocalService scorePointLocalService) {
		_scorePointLocalService = scorePointLocalService;
	}

	@Override
	public ScorePointLocalService getWrappedService() {
		return _scorePointLocalService;
	}

	@Override
	public void setWrappedService(ScorePointLocalService scorePointLocalService) {
		_scorePointLocalService = scorePointLocalService;
	}

	private ScorePointLocalService _scorePointLocalService;
}