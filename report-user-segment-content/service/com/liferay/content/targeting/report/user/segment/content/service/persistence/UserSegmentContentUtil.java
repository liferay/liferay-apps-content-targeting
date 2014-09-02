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

package com.liferay.content.targeting.report.user.segment.content.service.persistence;

import com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the user segment content service. This utility wraps {@link UserSegmentContentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserSegmentContentPersistence
 * @see UserSegmentContentPersistenceImpl
 * @generated
 */
public class UserSegmentContentUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(UserSegmentContent userSegmentContent) {
		getPersistence().clearCache(userSegmentContent);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserSegmentContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserSegmentContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserSegmentContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UserSegmentContent update(
		UserSegmentContent userSegmentContent) throws SystemException {
		return getPersistence().update(userSegmentContent);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UserSegmentContent update(
		UserSegmentContent userSegmentContent, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(userSegmentContent, serviceContext);
	}

	/**
	* Returns all the user segment contents where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @return the matching user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> findByUserSegmentId(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserSegmentId(userSegmentId);
	}

	/**
	* Returns a range of all the user segment contents where userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of user segment contents
	* @param end the upper bound of the range of user segment contents (not inclusive)
	* @return the range of matching user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> findByUserSegmentId(
		long userSegmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserSegmentId(userSegmentId, start, end);
	}

	/**
	* Returns an ordered range of all the user segment contents where userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of user segment contents
	* @param end the upper bound of the range of user segment contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> findByUserSegmentId(
		long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserSegmentId(userSegmentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first user segment content in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user segment content
	* @throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent findByUserSegmentId_First(
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserSegmentId_First(userSegmentId, orderByComparator);
	}

	/**
	* Returns the first user segment content in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user segment content, or <code>null</code> if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent fetchByUserSegmentId_First(
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserSegmentId_First(userSegmentId, orderByComparator);
	}

	/**
	* Returns the last user segment content in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user segment content
	* @throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent findByUserSegmentId_Last(
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserSegmentId_Last(userSegmentId, orderByComparator);
	}

	/**
	* Returns the last user segment content in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user segment content, or <code>null</code> if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent fetchByUserSegmentId_Last(
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserSegmentId_Last(userSegmentId, orderByComparator);
	}

	/**
	* Returns the user segment contents before and after the current user segment content in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentContentId the primary key of the current user segment content
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user segment content
	* @throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException if a user segment content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent[] findByUserSegmentId_PrevAndNext(
		long userSegmentContentId, long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserSegmentId_PrevAndNext(userSegmentContentId,
			userSegmentId, orderByComparator);
	}

	/**
	* Removes all the user segment contents where userSegmentId = &#63; from the database.
	*
	* @param userSegmentId the user segment ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserSegmentId(long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserSegmentId(userSegmentId);
	}

	/**
	* Returns the number of user segment contents where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @return the number of matching user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserSegmentId(long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserSegmentId(userSegmentId);
	}

	/**
	* Returns all the user segment contents where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param modifiedDate the modified date
	* @return the matching user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> findByC_GtD(
		long userSegmentId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_GtD(userSegmentId, modifiedDate);
	}

	/**
	* Returns a range of all the user segment contents where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of user segment contents
	* @param end the upper bound of the range of user segment contents (not inclusive)
	* @return the range of matching user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> findByC_GtD(
		long userSegmentId, java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_GtD(userSegmentId, modifiedDate, start, end);
	}

	/**
	* Returns an ordered range of all the user segment contents where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of user segment contents
	* @param end the upper bound of the range of user segment contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> findByC_GtD(
		long userSegmentId, java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_GtD(userSegmentId, modifiedDate, start, end,
			orderByComparator);
	}

	/**
	* Returns the first user segment content in the ordered set where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user segment content
	* @throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent findByC_GtD_First(
		long userSegmentId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_GtD_First(userSegmentId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the first user segment content in the ordered set where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user segment content, or <code>null</code> if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent fetchByC_GtD_First(
		long userSegmentId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_GtD_First(userSegmentId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the last user segment content in the ordered set where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user segment content
	* @throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent findByC_GtD_Last(
		long userSegmentId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_GtD_Last(userSegmentId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the last user segment content in the ordered set where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user segment content, or <code>null</code> if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent fetchByC_GtD_Last(
		long userSegmentId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_GtD_Last(userSegmentId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the user segment contents before and after the current user segment content in the ordered set where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param userSegmentContentId the primary key of the current user segment content
	* @param userSegmentId the user segment ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user segment content
	* @throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException if a user segment content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent[] findByC_GtD_PrevAndNext(
		long userSegmentContentId, long userSegmentId,
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_GtD_PrevAndNext(userSegmentContentId,
			userSegmentId, modifiedDate, orderByComparator);
	}

	/**
	* Removes all the user segment contents where userSegmentId = &#63; and modifiedDate &gt; &#63; from the database.
	*
	* @param userSegmentId the user segment ID
	* @param modifiedDate the modified date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_GtD(long userSegmentId,
		java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_GtD(userSegmentId, modifiedDate);
	}

	/**
	* Returns the number of user segment contents where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param modifiedDate the modified date
	* @return the number of matching user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_GtD(long userSegmentId,
		java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_GtD(userSegmentId, modifiedDate);
	}

	/**
	* Returns the user segment content where userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; or throws a {@link com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException} if it could not be found.
	*
	* @param userSegmentId the user segment ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the matching user segment content
	* @throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent findByC_C_C_E(
		long userSegmentId, java.lang.String className, long classPK,
		java.lang.String eventType)
		throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_E(userSegmentId, className, classPK, eventType);
	}

	/**
	* Returns the user segment content where userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userSegmentId the user segment ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the matching user segment content, or <code>null</code> if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent fetchByC_C_C_E(
		long userSegmentId, java.lang.String className, long classPK,
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_C_E(userSegmentId, className, classPK, eventType);
	}

	/**
	* Returns the user segment content where userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userSegmentId the user segment ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user segment content, or <code>null</code> if a matching user segment content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent fetchByC_C_C_E(
		long userSegmentId, java.lang.String className, long classPK,
		java.lang.String eventType, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_C_E(userSegmentId, className, classPK,
			eventType, retrieveFromCache);
	}

	/**
	* Removes the user segment content where userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; from the database.
	*
	* @param userSegmentId the user segment ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the user segment content that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent removeByC_C_C_E(
		long userSegmentId, java.lang.String className, long classPK,
		java.lang.String eventType)
		throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByC_C_C_E(userSegmentId, className, classPK, eventType);
	}

	/**
	* Returns the number of user segment contents where userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the number of matching user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_C_C_E(long userSegmentId,
		java.lang.String className, long classPK, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByC_C_C_E(userSegmentId, className, classPK, eventType);
	}

	/**
	* Caches the user segment content in the entity cache if it is enabled.
	*
	* @param userSegmentContent the user segment content
	*/
	public static void cacheResult(
		com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent userSegmentContent) {
		getPersistence().cacheResult(userSegmentContent);
	}

	/**
	* Caches the user segment contents in the entity cache if it is enabled.
	*
	* @param userSegmentContents the user segment contents
	*/
	public static void cacheResult(
		java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> userSegmentContents) {
		getPersistence().cacheResult(userSegmentContents);
	}

	/**
	* Creates a new user segment content with the primary key. Does not add the user segment content to the database.
	*
	* @param userSegmentContentId the primary key for the new user segment content
	* @return the new user segment content
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent create(
		long userSegmentContentId) {
		return getPersistence().create(userSegmentContentId);
	}

	/**
	* Removes the user segment content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userSegmentContentId the primary key of the user segment content
	* @return the user segment content that was removed
	* @throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException if a user segment content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent remove(
		long userSegmentContentId)
		throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(userSegmentContentId);
	}

	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent updateImpl(
		com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent userSegmentContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userSegmentContent);
	}

	/**
	* Returns the user segment content with the primary key or throws a {@link com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException} if it could not be found.
	*
	* @param userSegmentContentId the primary key of the user segment content
	* @return the user segment content
	* @throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException if a user segment content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent findByPrimaryKey(
		long userSegmentContentId)
		throws com.liferay.content.targeting.report.user.segment.content.NoSuchUserSegmentContentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(userSegmentContentId);
	}

	/**
	* Returns the user segment content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userSegmentContentId the primary key of the user segment content
	* @return the user segment content, or <code>null</code> if a user segment content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent fetchByPrimaryKey(
		long userSegmentContentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userSegmentContentId);
	}

	/**
	* Returns all the user segment contents.
	*
	* @return the user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user segment contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user segment contents
	* @param end the upper bound of the range of user segment contents (not inclusive)
	* @return the range of user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user segment contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user segment contents
	* @param end the upper bound of the range of user segment contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user segment contents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user segment contents.
	*
	* @return the number of user segment contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserSegmentContentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserSegmentContentPersistence)PortletBeanLocatorUtil.locate(com.liferay.content.targeting.report.user.segment.content.service.ClpSerializer.getServletContextName(),
					UserSegmentContentPersistence.class.getName());

			ReferenceRegistry.registerReference(UserSegmentContentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UserSegmentContentPersistence persistence) {
	}

	private static UserSegmentContentPersistence _persistence;
}