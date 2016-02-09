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

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.util.BaseModelSearchResult;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Provides the local service interface for Tactic. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see TacticLocalServiceUtil
 * @see com.liferay.content.targeting.service.base.TacticLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.TacticLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TacticLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TacticLocalServiceUtil} to access the tactic local service. Add custom service methods to {@link com.liferay.content.targeting.service.impl.TacticLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the tactic to the database. Also notifies the appropriate model listeners.
	*
	* @param tactic the tactic
	* @return the tactic that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Tactic addTactic(Tactic tactic);

	@Indexable(type = IndexableType.REINDEX)
	public Tactic addTactic(long userId, long campaignId,
		Map<Locale, java.lang.String> nameMap,
		Map<Locale, java.lang.String> descriptionMap, long[] userSegmentsIds,
		ServiceContext serviceContext) throws PortalException;

	public void addUserSegmentTactic(long userSegmentId, Tactic tactic);

	public void addUserSegmentTactic(long userSegmentId, long tacticId);

	public void addUserSegmentTactics(long userSegmentId, List<Tactic> Tactics);

	public void addUserSegmentTactics(long userSegmentId, long[] tacticIds);

	public void clearUserSegmentTactics(long userSegmentId);

	/**
	* Creates a new tactic with the primary key. Does not add the tactic to the database.
	*
	* @param tacticId the primary key for the new tactic
	* @return the new tactic
	*/
	public Tactic createTactic(long tacticId);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	* Deletes the tactic from the database. Also notifies the appropriate model listeners.
	*
	* @param tactic the tactic
	* @return the tactic that was removed
	* @throws PortalException
	*/
	@Indexable(type = IndexableType.DELETE)
	public Tactic deleteTactic(Tactic tactic) throws PortalException;

	/**
	* Deletes the tactic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tacticId the primary key of the tactic
	* @return the tactic that was removed
	* @throws PortalException if a tactic with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Tactic deleteTactic(long tacticId) throws PortalException;

	public void deleteUserSegmentTactic(long userSegmentId, Tactic tactic);

	public void deleteUserSegmentTactic(long userSegmentId, long tacticId);

	public void deleteUserSegmentTactics(long userSegmentId,
		List<Tactic> Tactics);

	public void deleteUserSegmentTactics(long userSegmentId, long[] tacticIds);

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public Tactic fetchTactic(long tacticId);

	/**
	* Returns the tactic matching the UUID and group.
	*
	* @param uuid the tactic's UUID
	* @param groupId the primary key of the group
	* @return the matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Tactic fetchTacticByUuidAndGroupId(java.lang.String uuid,
		long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

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

	/**
	* Returns the tactic with the primary key.
	*
	* @param tacticId the primary key of the tactic
	* @return the tactic
	* @throws PortalException if a tactic with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Tactic getTactic(long tacticId) throws PortalException;

	/**
	* Returns the tactic matching the UUID and group.
	*
	* @param uuid the tactic's UUID
	* @param groupId the primary key of the group
	* @return the matching tactic
	* @throws PortalException if a matching tactic could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Tactic getTacticByUuidAndGroupId(java.lang.String uuid, long groupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Tactic> getTactics(long campaignId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Tactic> getTactics(long campaignId, int start, int end,
		OrderByComparator obc) throws PortalException;

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
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Tactic> getTactics(int start, int end);

	/**
	* Returns all the tactics matching the UUID and company.
	*
	* @param uuid the UUID of the tactics
	* @param companyId the primary key of the company
	* @return the matching tactics, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Tactic> getTacticsByUuidAndCompanyId(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of tactics matching the UUID and company.
	*
	* @param uuid the UUID of the tactics
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching tactics, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Tactic> getTacticsByUuidAndCompanyId(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Tactic> orderByComparator);

	/**
	* Returns the number of tactics.
	*
	* @return the number of tactics
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTacticsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTacticsCount(long campaignId) throws PortalException;

	/**
	* Returns the userSegmentIds of the user segments associated with the tactic.
	*
	* @param tacticId the tacticId of the tactic
	* @return long[] the userSegmentIds of user segments associated with the tactic
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getUserSegmentPrimaryKeys(long tacticId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Tactic> getUserSegmentTactics(long userSegmentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Tactic> getUserSegmentTactics(long userSegmentId, int start,
		int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Tactic> getUserSegmentTactics(long userSegmentId, int start,
		int end, OrderByComparator<Tactic> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserSegmentTacticsCount(long userSegmentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasUserSegmentTactic(long userSegmentId, long tacticId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasUserSegmentTactics(long userSegmentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BaseModelSearchResult<Tactic> searchTactics(long campaignId,
		long groupId, java.lang.String keywords, int start, int end)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BaseModelSearchResult<Tactic> searchTactics(long groupId,
		java.lang.String keywords, int start, int end)
		throws PortalException;

	public void setUserSegmentTactics(long userSegmentId, long[] tacticIds);

	/**
	* Updates the tactic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tactic the tactic
	* @return the tactic that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Tactic updateTactic(Tactic tactic);

	@Indexable(type = IndexableType.REINDEX)
	public Tactic updateTactic(long tacticId, long campaignId,
		Map<Locale, java.lang.String> nameMap,
		Map<Locale, java.lang.String> descriptionMap, long[] userSegmentsIds,
		ServiceContext serviceContext) throws PortalException;
}