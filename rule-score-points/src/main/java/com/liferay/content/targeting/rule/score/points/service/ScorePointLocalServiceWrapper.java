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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ScorePointLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ScorePointLocalService
 * @generated
 */
@ProviderType
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
	*/
	@Override
	public com.liferay.content.targeting.rule.score.points.model.ScorePoint addScorePoint(
		com.liferay.content.targeting.rule.score.points.model.ScorePoint scorePoint) {
		return _scorePointLocalService.addScorePoint(scorePoint);
	}

	@Override
	public com.liferay.content.targeting.rule.score.points.model.ScorePoint addScorePoints(
		long anonymousUserId, long userSegmentId, long points) {
		return _scorePointLocalService.addScorePoints(anonymousUserId,
			userSegmentId, points);
	}

	/**
	* Creates a new score point with the primary key. Does not add the score point to the database.
	*
	* @param scorePointId the primary key for the new score point
	* @return the new score point
	*/
	@Override
	public com.liferay.content.targeting.rule.score.points.model.ScorePoint createScorePoint(
		long scorePointId) {
		return _scorePointLocalService.createScorePoint(scorePointId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _scorePointLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the score point from the database. Also notifies the appropriate model listeners.
	*
	* @param scorePoint the score point
	* @return the score point that was removed
	*/
	@Override
	public com.liferay.content.targeting.rule.score.points.model.ScorePoint deleteScorePoint(
		com.liferay.content.targeting.rule.score.points.model.ScorePoint scorePoint) {
		return _scorePointLocalService.deleteScorePoint(scorePoint);
	}

	/**
	* Deletes the score point with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scorePointId the primary key of the score point
	* @return the score point that was removed
	* @throws PortalException if a score point with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.rule.score.points.model.ScorePoint deleteScorePoint(
		long scorePointId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _scorePointLocalService.deleteScorePoint(scorePointId);
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
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _scorePointLocalService.dynamicQuery(dynamicQuery);
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
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _scorePointLocalService.dynamicQuery(dynamicQuery, start, end);
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
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _scorePointLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _scorePointLocalService.dynamicQueryCount(dynamicQuery);
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
		return _scorePointLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.content.targeting.rule.score.points.model.ScorePoint fetchScorePoint(
		long scorePointId) {
		return _scorePointLocalService.fetchScorePoint(scorePointId);
	}

	/**
	* Returns the score point with the matching UUID and company.
	*
	* @param uuid the score point's UUID
	* @param companyId the primary key of the company
	* @return the matching score point, or <code>null</code> if a matching score point could not be found
	*/
	@Override
	public com.liferay.content.targeting.rule.score.points.model.ScorePoint fetchScorePointByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _scorePointLocalService.fetchScorePointByUuidAndCompanyId(uuid,
			companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _scorePointLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _scorePointLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _scorePointLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _scorePointLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public long getPoints(long anonymousUserId, long userSegmentId) {
		return _scorePointLocalService.getPoints(anonymousUserId, userSegmentId);
	}

	/**
	* Returns the score point with the primary key.
	*
	* @param scorePointId the primary key of the score point
	* @return the score point
	* @throws PortalException if a score point with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.rule.score.points.model.ScorePoint getScorePoint(
		long scorePointId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _scorePointLocalService.getScorePoint(scorePointId);
	}

	/**
	* Returns the score point with the matching UUID and company.
	*
	* @param uuid the score point's UUID
	* @param companyId the primary key of the company
	* @return the matching score point
	* @throws PortalException if a matching score point could not be found
	*/
	@Override
	public com.liferay.content.targeting.rule.score.points.model.ScorePoint getScorePointByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _scorePointLocalService.getScorePointByUuidAndCompanyId(uuid,
			companyId);
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
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.rule.score.points.model.ScorePoint> getScorePoints(
		int start, int end) {
		return _scorePointLocalService.getScorePoints(start, end);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.rule.score.points.model.ScorePoint> getScorePoints(
		long userSegmentId) {
		return _scorePointLocalService.getScorePoints(userSegmentId);
	}

	/**
	* Returns the number of score points.
	*
	* @return the number of score points
	*/
	@Override
	public int getScorePointsCount() {
		return _scorePointLocalService.getScorePointsCount();
	}

	@Override
	public long incrementPoints(long anonymousUserId, long userSegmentId,
		long points) {
		return _scorePointLocalService.incrementPoints(anonymousUserId,
			userSegmentId, points);
	}

	/**
	* Updates the score point in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scorePoint the score point
	* @return the score point that was updated
	*/
	@Override
	public com.liferay.content.targeting.rule.score.points.model.ScorePoint updateScorePoint(
		com.liferay.content.targeting.rule.score.points.model.ScorePoint scorePoint) {
		return _scorePointLocalService.updateScorePoint(scorePoint);
	}

	@Override
	public com.liferay.content.targeting.rule.score.points.model.ScorePoint updateScorePoints(
		long anonymousUserId, long userSegmentId, long points) {
		return _scorePointLocalService.updateScorePoints(anonymousUserId,
			userSegmentId, points);
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