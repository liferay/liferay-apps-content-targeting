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

import com.liferay.content.targeting.model.UserSegment;
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
import com.liferay.portal.kernel.search.Hits;
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
 * Provides the local service interface for UserSegment. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserSegmentLocalServiceUtil
 * @see com.liferay.content.targeting.service.base.UserSegmentLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.UserSegmentLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface UserSegmentLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserSegmentLocalServiceUtil} to access the user segment local service. Add custom service methods to {@link com.liferay.content.targeting.service.impl.UserSegmentLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public void addCampaignUserSegment(long campaignId, UserSegment userSegment);

	public void addCampaignUserSegment(long campaignId, long userSegmentId);

	public void addCampaignUserSegments(long campaignId,
		List<UserSegment> UserSegments);

	public void addCampaignUserSegments(long campaignId, long[] userSegmentIds);

	public void addTacticUserSegment(long tacticId, UserSegment userSegment);

	public void addTacticUserSegment(long tacticId, long userSegmentId);

	public void addTacticUserSegments(long tacticId,
		List<UserSegment> UserSegments);

	public void addTacticUserSegments(long tacticId, long[] userSegmentIds);

	@Indexable(type = IndexableType.REINDEX)
	public UserSegment addUserSegment(long userId,
		Map<Locale, java.lang.String> nameMap,
		Map<Locale, java.lang.String> descriptionMap,
		ServiceContext serviceContext) throws PortalException;

	/**
	* Adds the user segment to the database. Also notifies the appropriate model listeners.
	*
	* @param userSegment the user segment
	* @return the user segment that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public UserSegment addUserSegment(UserSegment userSegment);

	public void addUserSegmentResources(UserSegment userSegment,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws PortalException;

	public void addUserSegmentResources(UserSegment userSegment,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws PortalException;

	public void clearCampaignUserSegments(long campaignId);

	public void clearTacticUserSegments(long tacticId);

	/**
	* Creates a new user segment with the primary key. Does not add the user segment to the database.
	*
	* @param userSegmentId the primary key for the new user segment
	* @return the new user segment
	*/
	public UserSegment createUserSegment(long userSegmentId);

	public void deleteCampaignUserSegment(long campaignId,
		UserSegment userSegment);

	public void deleteCampaignUserSegment(long campaignId, long userSegmentId);

	public void deleteCampaignUserSegments(long campaignId,
		List<UserSegment> UserSegments);

	public void deleteCampaignUserSegments(long campaignId,
		long[] userSegmentIds);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public void deleteTacticUserSegment(long tacticId, UserSegment userSegment);

	public void deleteTacticUserSegment(long tacticId, long userSegmentId);

	public void deleteTacticUserSegments(long tacticId,
		List<UserSegment> UserSegments);

	public void deleteTacticUserSegments(long tacticId, long[] userSegmentIds);

	/**
	* Deletes the user segment from the database. Also notifies the appropriate model listeners.
	*
	* @param userSegment the user segment
	* @return the user segment that was removed
	* @throws PortalException
	*/
	@Indexable(type = IndexableType.DELETE)
	public UserSegment deleteUserSegment(UserSegment userSegment)
		throws PortalException;

	/**
	* Deletes the user segment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userSegmentId the primary key of the user segment
	* @return the user segment that was removed
	* @throws PortalException if a user segment with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public UserSegment deleteUserSegment(long userSegmentId)
		throws PortalException;

	public void deleteUserSegments(long groupId) throws PortalException;

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public UserSegment fetchUserSegment(long userSegmentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserSegment fetchUserSegmentByAssetCategoryId(long assetCategoryId)
		throws PortalException;

	/**
	* Returns the user segment matching the UUID and group.
	*
	* @param uuid the user segment's UUID
	* @param groupId the primary key of the group
	* @return the matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserSegment fetchUserSegmentByUuidAndGroupId(java.lang.String uuid,
		long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	* Returns the campaignIds of the campaigns associated with the user segment.
	*
	* @param userSegmentId the userSegmentId of the user segment
	* @return long[] the campaignIds of campaigns associated with the user segment
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getCampaignPrimaryKeys(long userSegmentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserSegment> getCampaignUserSegments(long campaignId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserSegment> getCampaignUserSegments(long campaignId,
		int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserSegment> getCampaignUserSegments(long campaignId,
		int start, int end, OrderByComparator<UserSegment> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCampaignUserSegmentsCount(long campaignId);

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
	* Returns the tacticIds of the tactics associated with the user segment.
	*
	* @param userSegmentId the userSegmentId of the user segment
	* @return long[] the tacticIds of tactics associated with the user segment
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getTacticPrimaryKeys(long userSegmentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserSegment> getTacticUserSegments(long tacticId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserSegment> getTacticUserSegments(long tacticId, int start,
		int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserSegment> getTacticUserSegments(long tacticId, int start,
		int end, OrderByComparator<UserSegment> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTacticUserSegmentsCount(long tacticId);

	/**
	* Returns the user segment with the primary key.
	*
	* @param userSegmentId the primary key of the user segment
	* @return the user segment
	* @throws PortalException if a user segment with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserSegment getUserSegment(long userSegmentId)
		throws PortalException;

	/**
	* Returns the user segment matching the UUID and group.
	*
	* @param uuid the user segment's UUID
	* @param groupId the primary key of the group
	* @return the matching user segment
	* @throws PortalException if a matching user segment could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserSegment getUserSegmentByUuidAndGroupId(java.lang.String uuid,
		long groupId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserSegment> getUserSegments(long groupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserSegment> getUserSegments(long groupId, int start, int end,
		OrderByComparator obc) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserSegment> getUserSegments(long[] groupIds)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserSegment> getUserSegments(long[] groupIds, int start,
		int end, OrderByComparator obc) throws PortalException;

	/**
	* Returns a range of all the user segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @return the range of user segments
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserSegment> getUserSegments(int start, int end);

	/**
	* Returns all the user segments matching the UUID and company.
	*
	* @param uuid the UUID of the user segments
	* @param companyId the primary key of the company
	* @return the matching user segments, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserSegment> getUserSegmentsByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	/**
	* Returns a range of user segments matching the UUID and company.
	*
	* @param uuid the UUID of the user segments
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching user segments, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserSegment> getUserSegmentsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<UserSegment> orderByComparator);

	/**
	* Returns the number of user segments.
	*
	* @return the number of user segments
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserSegmentsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserSegmentsCount(long groupId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserSegmentsCount(long[] groupIds) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasCampaignUserSegment(long campaignId, long userSegmentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasCampaignUserSegments(long campaignId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasTacticUserSegment(long tacticId, long userSegmentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasTacticUserSegments(long tacticId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Hits search(long groupId, java.lang.String keywords, int start,
		int end) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BaseModelSearchResult<UserSegment> searchUserSegments(long groupId,
		java.lang.String keywords, int start, int end)
		throws PortalException;

	public void setCampaignUserSegments(long campaignId, long[] userSegmentIds);

	public void setTacticUserSegments(long tacticId, long[] userSegmentIds);

	/**
	* Updates the user segment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userSegment the user segment
	* @return the user segment that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public UserSegment updateUserSegment(UserSegment userSegment);

	@Indexable(type = IndexableType.REINDEX)
	public UserSegment updateUserSegment(long userSegmentId,
		Map<Locale, java.lang.String> nameMap,
		Map<Locale, java.lang.String> descriptionMap,
		ServiceContext serviceContext) throws PortalException;

	public void updateUserSegmentResources(UserSegment userSegment,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws PortalException;
}