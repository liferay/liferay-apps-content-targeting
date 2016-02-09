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

import com.liferay.content.targeting.model.RuleInstance;

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

/**
 * Provides the local service interface for RuleInstance. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see RuleInstanceLocalServiceUtil
 * @see com.liferay.content.targeting.service.base.RuleInstanceLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.RuleInstanceLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface RuleInstanceLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RuleInstanceLocalServiceUtil} to access the rule instance local service. Add custom service methods to {@link com.liferay.content.targeting.service.impl.RuleInstanceLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the rule instance to the database. Also notifies the appropriate model listeners.
	*
	* @param ruleInstance the rule instance
	* @return the rule instance that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public RuleInstance addRuleInstance(RuleInstance ruleInstance);

	public RuleInstance addRuleInstance(long userId, java.lang.String ruleKey,
		long userSegmentId, java.lang.String typeSettings,
		ServiceContext serviceContext) throws PortalException;

	/**
	* Creates a new rule instance with the primary key. Does not add the rule instance to the database.
	*
	* @param ruleInstanceId the primary key for the new rule instance
	* @return the new rule instance
	*/
	public RuleInstance createRuleInstance(long ruleInstanceId);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	* Deletes the rule instance from the database. Also notifies the appropriate model listeners.
	*
	* @param ruleInstance the rule instance
	* @return the rule instance that was removed
	* @throws PortalException
	*/
	@Indexable(type = IndexableType.DELETE)
	public RuleInstance deleteRuleInstance(RuleInstance ruleInstance)
		throws PortalException;

	/**
	* Deletes the rule instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ruleInstanceId the primary key of the rule instance
	* @return the rule instance that was removed
	* @throws PortalException if a rule instance with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public RuleInstance deleteRuleInstance(long ruleInstanceId)
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public RuleInstance fetchRuleInstance(long ruleInstanceId);

	/**
	* Returns the rule instance matching the UUID and group.
	*
	* @param uuid the rule instance's UUID
	* @param groupId the primary key of the group
	* @return the matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RuleInstance fetchRuleInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId);

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
	* Returns the rule instance with the primary key.
	*
	* @param ruleInstanceId the primary key of the rule instance
	* @return the rule instance
	* @throws PortalException if a rule instance with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RuleInstance getRuleInstance(long ruleInstanceId)
		throws PortalException;

	/**
	* Returns the rule instance matching the UUID and group.
	*
	* @param uuid the rule instance's UUID
	* @param groupId the primary key of the group
	* @return the matching rule instance
	* @throws PortalException if a matching rule instance could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RuleInstance getRuleInstanceByUuidAndGroupId(java.lang.String uuid,
		long groupId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RuleInstance> getRuleInstances(java.lang.String ruleKey,
		long userSegmentId);

	/**
	* Returns a range of all the rule instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @return the range of rule instances
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RuleInstance> getRuleInstances(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RuleInstance> getRuleInstances(long userSegmentId);

	/**
	* Returns all the rule instances matching the UUID and company.
	*
	* @param uuid the UUID of the rule instances
	* @param companyId the primary key of the company
	* @return the matching rule instances, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RuleInstance> getRuleInstancesByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	/**
	* Returns a range of rule instances matching the UUID and company.
	*
	* @param uuid the UUID of the rule instances
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching rule instances, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RuleInstance> getRuleInstancesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<RuleInstance> orderByComparator);

	/**
	* Returns the number of rule instances.
	*
	* @return the number of rule instances
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getRuleInstancesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getRuleInstancesCount(java.lang.String ruleKey,
		long userSegmentId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getRuleInstancesCount(long userSegmentId)
		throws PortalException;

	/**
	* Updates the rule instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ruleInstance the rule instance
	* @return the rule instance that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public RuleInstance updateRuleInstance(RuleInstance ruleInstance);

	public RuleInstance updateRuleInstance(long ruleInstanceId,
		java.lang.String typeSettings, ServiceContext serviceContext)
		throws PortalException;
}