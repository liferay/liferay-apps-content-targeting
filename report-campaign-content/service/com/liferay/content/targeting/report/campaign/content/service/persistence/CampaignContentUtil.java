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

package com.liferay.content.targeting.report.campaign.content.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.report.campaign.content.model.CampaignContent;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the campaign content service. This utility wraps {@link com.liferay.content.targeting.report.campaign.content.service.persistence.impl.CampaignContentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignContentPersistence
 * @see com.liferay.content.targeting.report.campaign.content.service.persistence.impl.CampaignContentPersistenceImpl
 * @generated
 */
@ProviderType
public class CampaignContentUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CampaignContent campaignContent) {
		getPersistence().clearCache(campaignContent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CampaignContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CampaignContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CampaignContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CampaignContent> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CampaignContent update(CampaignContent campaignContent) {
		return getPersistence().update(campaignContent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CampaignContent update(CampaignContent campaignContent,
		ServiceContext serviceContext) {
		return getPersistence().update(campaignContent, serviceContext);
	}

	/**
	* Returns all the campaign contents where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching campaign contents
	*/
	public static List<CampaignContent> findByCampaignId(long campaignId) {
		return getPersistence().findByCampaignId(campaignId);
	}

	/**
	* Returns a range of all the campaign contents where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of campaign contents
	* @param end the upper bound of the range of campaign contents (not inclusive)
	* @return the range of matching campaign contents
	*/
	public static List<CampaignContent> findByCampaignId(long campaignId,
		int start, int end) {
		return getPersistence().findByCampaignId(campaignId, start, end);
	}

	/**
	* Returns an ordered range of all the campaign contents where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of campaign contents
	* @param end the upper bound of the range of campaign contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaign contents
	*/
	public static List<CampaignContent> findByCampaignId(long campaignId,
		int start, int end, OrderByComparator<CampaignContent> orderByComparator) {
		return getPersistence()
				   .findByCampaignId(campaignId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the campaign contents where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of campaign contents
	* @param end the upper bound of the range of campaign contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching campaign contents
	*/
	public static List<CampaignContent> findByCampaignId(long campaignId,
		int start, int end,
		OrderByComparator<CampaignContent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCampaignId(campaignId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first campaign content in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign content
	* @throws NoSuchCampaignContentException if a matching campaign content could not be found
	*/
	public static CampaignContent findByCampaignId_First(long campaignId,
		OrderByComparator<CampaignContent> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.content.exception.NoSuchCampaignContentException {
		return getPersistence()
				   .findByCampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the first campaign content in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign content, or <code>null</code> if a matching campaign content could not be found
	*/
	public static CampaignContent fetchByCampaignId_First(long campaignId,
		OrderByComparator<CampaignContent> orderByComparator) {
		return getPersistence()
				   .fetchByCampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the last campaign content in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign content
	* @throws NoSuchCampaignContentException if a matching campaign content could not be found
	*/
	public static CampaignContent findByCampaignId_Last(long campaignId,
		OrderByComparator<CampaignContent> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.content.exception.NoSuchCampaignContentException {
		return getPersistence()
				   .findByCampaignId_Last(campaignId, orderByComparator);
	}

	/**
	* Returns the last campaign content in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign content, or <code>null</code> if a matching campaign content could not be found
	*/
	public static CampaignContent fetchByCampaignId_Last(long campaignId,
		OrderByComparator<CampaignContent> orderByComparator) {
		return getPersistence()
				   .fetchByCampaignId_Last(campaignId, orderByComparator);
	}

	/**
	* Returns the campaign contents before and after the current campaign content in the ordered set where campaignId = &#63;.
	*
	* @param campaignContentId the primary key of the current campaign content
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign content
	* @throws NoSuchCampaignContentException if a campaign content with the primary key could not be found
	*/
	public static CampaignContent[] findByCampaignId_PrevAndNext(
		long campaignContentId, long campaignId,
		OrderByComparator<CampaignContent> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.content.exception.NoSuchCampaignContentException {
		return getPersistence()
				   .findByCampaignId_PrevAndNext(campaignContentId, campaignId,
			orderByComparator);
	}

	/**
	* Removes all the campaign contents where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	*/
	public static void removeByCampaignId(long campaignId) {
		getPersistence().removeByCampaignId(campaignId);
	}

	/**
	* Returns the number of campaign contents where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching campaign contents
	*/
	public static int countByCampaignId(long campaignId) {
		return getPersistence().countByCampaignId(campaignId);
	}

	/**
	* Returns all the campaign contents where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @return the matching campaign contents
	*/
	public static List<CampaignContent> findByC_GtD(long campaignId,
		Date modifiedDate) {
		return getPersistence().findByC_GtD(campaignId, modifiedDate);
	}

	/**
	* Returns a range of all the campaign contents where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of campaign contents
	* @param end the upper bound of the range of campaign contents (not inclusive)
	* @return the range of matching campaign contents
	*/
	public static List<CampaignContent> findByC_GtD(long campaignId,
		Date modifiedDate, int start, int end) {
		return getPersistence().findByC_GtD(campaignId, modifiedDate, start, end);
	}

	/**
	* Returns an ordered range of all the campaign contents where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of campaign contents
	* @param end the upper bound of the range of campaign contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaign contents
	*/
	public static List<CampaignContent> findByC_GtD(long campaignId,
		Date modifiedDate, int start, int end,
		OrderByComparator<CampaignContent> orderByComparator) {
		return getPersistence()
				   .findByC_GtD(campaignId, modifiedDate, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the campaign contents where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of campaign contents
	* @param end the upper bound of the range of campaign contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching campaign contents
	*/
	public static List<CampaignContent> findByC_GtD(long campaignId,
		Date modifiedDate, int start, int end,
		OrderByComparator<CampaignContent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_GtD(campaignId, modifiedDate, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first campaign content in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign content
	* @throws NoSuchCampaignContentException if a matching campaign content could not be found
	*/
	public static CampaignContent findByC_GtD_First(long campaignId,
		Date modifiedDate, OrderByComparator<CampaignContent> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.content.exception.NoSuchCampaignContentException {
		return getPersistence()
				   .findByC_GtD_First(campaignId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the first campaign content in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign content, or <code>null</code> if a matching campaign content could not be found
	*/
	public static CampaignContent fetchByC_GtD_First(long campaignId,
		Date modifiedDate, OrderByComparator<CampaignContent> orderByComparator) {
		return getPersistence()
				   .fetchByC_GtD_First(campaignId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the last campaign content in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign content
	* @throws NoSuchCampaignContentException if a matching campaign content could not be found
	*/
	public static CampaignContent findByC_GtD_Last(long campaignId,
		Date modifiedDate, OrderByComparator<CampaignContent> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.content.exception.NoSuchCampaignContentException {
		return getPersistence()
				   .findByC_GtD_Last(campaignId, modifiedDate, orderByComparator);
	}

	/**
	* Returns the last campaign content in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign content, or <code>null</code> if a matching campaign content could not be found
	*/
	public static CampaignContent fetchByC_GtD_Last(long campaignId,
		Date modifiedDate, OrderByComparator<CampaignContent> orderByComparator) {
		return getPersistence()
				   .fetchByC_GtD_Last(campaignId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the campaign contents before and after the current campaign content in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignContentId the primary key of the current campaign content
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign content
	* @throws NoSuchCampaignContentException if a campaign content with the primary key could not be found
	*/
	public static CampaignContent[] findByC_GtD_PrevAndNext(
		long campaignContentId, long campaignId, Date modifiedDate,
		OrderByComparator<CampaignContent> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.content.exception.NoSuchCampaignContentException {
		return getPersistence()
				   .findByC_GtD_PrevAndNext(campaignContentId, campaignId,
			modifiedDate, orderByComparator);
	}

	/**
	* Removes all the campaign contents where campaignId = &#63; and modifiedDate &gt; &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	*/
	public static void removeByC_GtD(long campaignId, Date modifiedDate) {
		getPersistence().removeByC_GtD(campaignId, modifiedDate);
	}

	/**
	* Returns the number of campaign contents where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @return the number of matching campaign contents
	*/
	public static int countByC_GtD(long campaignId, Date modifiedDate) {
		return getPersistence().countByC_GtD(campaignId, modifiedDate);
	}

	/**
	* Returns the campaign content where campaignId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; or throws a {@link NoSuchCampaignContentException} if it could not be found.
	*
	* @param campaignId the campaign ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the matching campaign content
	* @throws NoSuchCampaignContentException if a matching campaign content could not be found
	*/
	public static CampaignContent findByC_C_C_E(long campaignId,
		java.lang.String className, long classPK, java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.content.exception.NoSuchCampaignContentException {
		return getPersistence()
				   .findByC_C_C_E(campaignId, className, classPK, eventType);
	}

	/**
	* Returns the campaign content where campaignId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param campaignId the campaign ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the matching campaign content, or <code>null</code> if a matching campaign content could not be found
	*/
	public static CampaignContent fetchByC_C_C_E(long campaignId,
		java.lang.String className, long classPK, java.lang.String eventType) {
		return getPersistence()
				   .fetchByC_C_C_E(campaignId, className, classPK, eventType);
	}

	/**
	* Returns the campaign content where campaignId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param campaignId the campaign ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching campaign content, or <code>null</code> if a matching campaign content could not be found
	*/
	public static CampaignContent fetchByC_C_C_E(long campaignId,
		java.lang.String className, long classPK, java.lang.String eventType,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByC_C_C_E(campaignId, className, classPK, eventType,
			retrieveFromCache);
	}

	/**
	* Removes the campaign content where campaignId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the campaign content that was removed
	*/
	public static CampaignContent removeByC_C_C_E(long campaignId,
		java.lang.String className, long classPK, java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.content.exception.NoSuchCampaignContentException {
		return getPersistence()
				   .removeByC_C_C_E(campaignId, className, classPK, eventType);
	}

	/**
	* Returns the number of campaign contents where campaignId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param campaignId the campaign ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the number of matching campaign contents
	*/
	public static int countByC_C_C_E(long campaignId,
		java.lang.String className, long classPK, java.lang.String eventType) {
		return getPersistence()
				   .countByC_C_C_E(campaignId, className, classPK, eventType);
	}

	/**
	* Caches the campaign content in the entity cache if it is enabled.
	*
	* @param campaignContent the campaign content
	*/
	public static void cacheResult(CampaignContent campaignContent) {
		getPersistence().cacheResult(campaignContent);
	}

	/**
	* Caches the campaign contents in the entity cache if it is enabled.
	*
	* @param campaignContents the campaign contents
	*/
	public static void cacheResult(List<CampaignContent> campaignContents) {
		getPersistence().cacheResult(campaignContents);
	}

	/**
	* Creates a new campaign content with the primary key. Does not add the campaign content to the database.
	*
	* @param campaignContentId the primary key for the new campaign content
	* @return the new campaign content
	*/
	public static CampaignContent create(long campaignContentId) {
		return getPersistence().create(campaignContentId);
	}

	/**
	* Removes the campaign content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignContentId the primary key of the campaign content
	* @return the campaign content that was removed
	* @throws NoSuchCampaignContentException if a campaign content with the primary key could not be found
	*/
	public static CampaignContent remove(long campaignContentId)
		throws com.liferay.content.targeting.report.campaign.content.exception.NoSuchCampaignContentException {
		return getPersistence().remove(campaignContentId);
	}

	public static CampaignContent updateImpl(CampaignContent campaignContent) {
		return getPersistence().updateImpl(campaignContent);
	}

	/**
	* Returns the campaign content with the primary key or throws a {@link NoSuchCampaignContentException} if it could not be found.
	*
	* @param campaignContentId the primary key of the campaign content
	* @return the campaign content
	* @throws NoSuchCampaignContentException if a campaign content with the primary key could not be found
	*/
	public static CampaignContent findByPrimaryKey(long campaignContentId)
		throws com.liferay.content.targeting.report.campaign.content.exception.NoSuchCampaignContentException {
		return getPersistence().findByPrimaryKey(campaignContentId);
	}

	/**
	* Returns the campaign content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campaignContentId the primary key of the campaign content
	* @return the campaign content, or <code>null</code> if a campaign content with the primary key could not be found
	*/
	public static CampaignContent fetchByPrimaryKey(long campaignContentId) {
		return getPersistence().fetchByPrimaryKey(campaignContentId);
	}

	public static java.util.Map<java.io.Serializable, CampaignContent> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the campaign contents.
	*
	* @return the campaign contents
	*/
	public static List<CampaignContent> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the campaign contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign contents
	* @param end the upper bound of the range of campaign contents (not inclusive)
	* @return the range of campaign contents
	*/
	public static List<CampaignContent> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the campaign contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign contents
	* @param end the upper bound of the range of campaign contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of campaign contents
	*/
	public static List<CampaignContent> findAll(int start, int end,
		OrderByComparator<CampaignContent> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the campaign contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign contents
	* @param end the upper bound of the range of campaign contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of campaign contents
	*/
	public static List<CampaignContent> findAll(int start, int end,
		OrderByComparator<CampaignContent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the campaign contents from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of campaign contents.
	*
	* @return the number of campaign contents
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CampaignContentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CampaignContentPersistence, CampaignContentPersistence> _serviceTracker =
		ServiceTrackerFactory.open(CampaignContentPersistence.class);
}