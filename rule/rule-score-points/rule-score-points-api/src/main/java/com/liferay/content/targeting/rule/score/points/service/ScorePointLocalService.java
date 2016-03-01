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

import com.liferay.content.targeting.rule.score.points.model.ScorePoint;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for ScorePoint. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ScorePointLocalServiceUtil
 * @see com.liferay.content.targeting.rule.score.points.service.base.ScorePointLocalServiceBaseImpl
 * @see com.liferay.content.targeting.rule.score.points.service.impl.ScorePointLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ScorePointLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ScorePointLocalServiceUtil} to access the score point local service. Add custom service methods to {@link com.liferay.content.targeting.rule.score.points.service.impl.ScorePointLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the score point to the database. Also notifies the appropriate model listeners.
	*
	* @param scorePoint the score point
	* @return the score point that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public ScorePoint addScorePoint(ScorePoint scorePoint);

	public ScorePoint addScorePoints(long anonymousUserId, long userSegmentId,
		long points);

	/**
	* Creates a new score point with the primary key. Does not add the score point to the database.
	*
	* @param scorePointId the primary key for the new score point
	* @return the new score point
	*/
	public ScorePoint createScorePoint(long scorePointId);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	* Deletes the score point from the database. Also notifies the appropriate model listeners.
	*
	* @param scorePoint the score point
	* @return the score point that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public ScorePoint deleteScorePoint(ScorePoint scorePoint);

	/**
	* Deletes the score point with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scorePointId the primary key of the score point
	* @return the score point that was removed
	* @throws PortalException if a score point with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public ScorePoint deleteScorePoint(long scorePointId)
		throws PortalException;

	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ScorePoint fetchScorePoint(long scorePointId);

	/**
	* Returns the score point with the matching UUID and company.
	*
	* @param uuid the score point's UUID
	* @param companyId the primary key of the company
	* @return the matching score point, or <code>null</code> if a matching score point could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ScorePoint fetchScorePointByUuidAndCompanyId(java.lang.String uuid,
		long companyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getPoints(long anonymousUserId, long userSegmentId);

	/**
	* Returns the score point with the primary key.
	*
	* @param scorePointId the primary key of the score point
	* @return the score point
	* @throws PortalException if a score point with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ScorePoint getScorePoint(long scorePointId)
		throws PortalException;

	/**
	* Returns the score point with the matching UUID and company.
	*
	* @param uuid the score point's UUID
	* @param companyId the primary key of the company
	* @return the matching score point
	* @throws PortalException if a matching score point could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ScorePoint getScorePointByUuidAndCompanyId(java.lang.String uuid,
		long companyId) throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ScorePoint> getScorePoints(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ScorePoint> getScorePoints(long userSegmentId);

	/**
	* Returns the number of score points.
	*
	* @return the number of score points
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getScorePointsCount();

	public long incrementPoints(long anonymousUserId, long userSegmentId,
		long points);

	/**
	* Updates the score point in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scorePoint the score point
	* @return the score point that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public ScorePoint updateScorePoint(ScorePoint scorePoint);

	public ScorePoint updateScorePoints(long anonymousUserId,
		long userSegmentId, long points);
}