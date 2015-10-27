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

package com.liferay.content.targeting.report.campaign.mobile.service.persistence;

import com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the consumer data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerDataPersistenceImpl
 * @see ConsumerDataUtil
 * @generated
 */
public interface ConsumerDataPersistence extends BasePersistence<ConsumerData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConsumerDataUtil} to access the consumer data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the consumer datas where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching consumer datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData> findByCampaignId(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the consumer datas where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of consumer datas
	* @param end the upper bound of the range of consumer datas (not inclusive)
	* @return the range of matching consumer datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData> findByCampaignId(
		long campaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the consumer datas where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of consumer datas
	* @param end the upper bound of the range of consumer datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching consumer datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData> findByCampaignId(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first consumer data in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer data
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a matching consumer data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData findByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first consumer data in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer data, or <code>null</code> if a matching consumer data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData fetchByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last consumer data in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer data
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a matching consumer data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData findByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last consumer data in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer data, or <code>null</code> if a matching consumer data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData fetchByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the consumer datas before and after the current consumer data in the ordered set where campaignId = &#63;.
	*
	* @param consumerDataId the primary key of the current consumer data
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next consumer data
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a consumer data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData[] findByCampaignId_PrevAndNext(
		long consumerDataId, long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the consumer datas where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of consumer datas where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching consumer datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the consumer datas where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the matching consumer datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData> findByEventType(
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the consumer datas where eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventType the event type
	* @param start the lower bound of the range of consumer datas
	* @param end the upper bound of the range of consumer datas (not inclusive)
	* @return the range of matching consumer datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData> findByEventType(
		java.lang.String eventType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the consumer datas where eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventType the event type
	* @param start the lower bound of the range of consumer datas
	* @param end the upper bound of the range of consumer datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching consumer datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData> findByEventType(
		java.lang.String eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first consumer data in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer data
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a matching consumer data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData findByEventType_First(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first consumer data in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer data, or <code>null</code> if a matching consumer data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData fetchByEventType_First(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last consumer data in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer data
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a matching consumer data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData findByEventType_Last(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last consumer data in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer data, or <code>null</code> if a matching consumer data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData fetchByEventType_Last(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the consumer datas before and after the current consumer data in the ordered set where eventType = &#63;.
	*
	* @param consumerDataId the primary key of the current consumer data
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next consumer data
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a consumer data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData[] findByEventType_PrevAndNext(
		long consumerDataId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the consumer datas where eventType = &#63; from the database.
	*
	* @param eventType the event type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEventType(java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of consumer datas where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the number of matching consumer datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByEventType(java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the consumer datas where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @return the matching consumer datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData> findByC_GtD(
		long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the consumer datas where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of consumer datas
	* @param end the upper bound of the range of consumer datas (not inclusive)
	* @return the range of matching consumer datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData> findByC_GtD(
		long campaignId, java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the consumer datas where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of consumer datas
	* @param end the upper bound of the range of consumer datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching consumer datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData> findByC_GtD(
		long campaignId, java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first consumer data in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer data
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a matching consumer data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData findByC_GtD_First(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first consumer data in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer data, or <code>null</code> if a matching consumer data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData fetchByC_GtD_First(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last consumer data in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer data
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a matching consumer data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData findByC_GtD_Last(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last consumer data in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer data, or <code>null</code> if a matching consumer data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData fetchByC_GtD_Last(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the consumer datas before and after the current consumer data in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param consumerDataId the primary key of the current consumer data
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next consumer data
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a consumer data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData[] findByC_GtD_PrevAndNext(
		long consumerDataId, long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the consumer datas where campaignId = &#63; and modifiedDate &gt; &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_GtD(long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of consumer datas where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @return the number of matching consumer datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_GtD(long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the consumer data where campaignId = &#63; and consumerId = &#63; and eventType = &#63; or throws a {@link com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException} if it could not be found.
	*
	* @param campaignId the campaign ID
	* @param consumerId the consumer ID
	* @param eventType the event type
	* @return the matching consumer data
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a matching consumer data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData findByC_C_E(
		long campaignId, long consumerId, java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the consumer data where campaignId = &#63; and consumerId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param campaignId the campaign ID
	* @param consumerId the consumer ID
	* @param eventType the event type
	* @return the matching consumer data, or <code>null</code> if a matching consumer data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData fetchByC_C_E(
		long campaignId, long consumerId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the consumer data where campaignId = &#63; and consumerId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param campaignId the campaign ID
	* @param consumerId the consumer ID
	* @param eventType the event type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching consumer data, or <code>null</code> if a matching consumer data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData fetchByC_C_E(
		long campaignId, long consumerId, java.lang.String eventType,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the consumer data where campaignId = &#63; and consumerId = &#63; and eventType = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param consumerId the consumer ID
	* @param eventType the event type
	* @return the consumer data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData removeByC_C_E(
		long campaignId, long consumerId, java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of consumer datas where campaignId = &#63; and consumerId = &#63; and eventType = &#63;.
	*
	* @param campaignId the campaign ID
	* @param consumerId the consumer ID
	* @param eventType the event type
	* @return the number of matching consumer datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C_E(long campaignId, long consumerId,
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the consumer data in the entity cache if it is enabled.
	*
	* @param consumerData the consumer data
	*/
	public void cacheResult(
		com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData consumerData);

	/**
	* Caches the consumer datas in the entity cache if it is enabled.
	*
	* @param consumerDatas the consumer datas
	*/
	public void cacheResult(
		java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData> consumerDatas);

	/**
	* Creates a new consumer data with the primary key. Does not add the consumer data to the database.
	*
	* @param consumerDataId the primary key for the new consumer data
	* @return the new consumer data
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData create(
		long consumerDataId);

	/**
	* Removes the consumer data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param consumerDataId the primary key of the consumer data
	* @return the consumer data that was removed
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a consumer data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData remove(
		long consumerDataId)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData updateImpl(
		com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData consumerData)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the consumer data with the primary key or throws a {@link com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException} if it could not be found.
	*
	* @param consumerDataId the primary key of the consumer data
	* @return the consumer data
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a consumer data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData findByPrimaryKey(
		long consumerDataId)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the consumer data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param consumerDataId the primary key of the consumer data
	* @return the consumer data, or <code>null</code> if a consumer data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData fetchByPrimaryKey(
		long consumerDataId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the consumer datas.
	*
	* @return the consumer datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the consumer datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of consumer datas
	* @param end the upper bound of the range of consumer datas (not inclusive)
	* @return the range of consumer datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the consumer datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of consumer datas
	* @param end the upper bound of the range of consumer datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of consumer datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the consumer datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of consumer datas.
	*
	* @return the number of consumer datas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}