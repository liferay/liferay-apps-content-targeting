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

package com.liferay.content.targeting.report.campaign.newsletter.service.persistence;

import com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the newsletter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterPersistenceImpl
 * @see NewsletterUtil
 * @generated
 */
public interface NewsletterPersistence extends BasePersistence<Newsletter> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NewsletterUtil} to access the newsletter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the newsletters where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching newsletters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter> findByCampaignId(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the newsletters where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.newsletter.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of newsletters
	* @param end the upper bound of the range of newsletters (not inclusive)
	* @return the range of matching newsletters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter> findByCampaignId(
		long campaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the newsletters where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.newsletter.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of newsletters
	* @param end the upper bound of the range of newsletters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching newsletters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter> findByCampaignId(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first newsletter in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching newsletter
	* @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException if a matching newsletter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter findByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first newsletter in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching newsletter, or <code>null</code> if a matching newsletter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter fetchByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last newsletter in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching newsletter
	* @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException if a matching newsletter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter findByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last newsletter in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching newsletter, or <code>null</code> if a matching newsletter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter fetchByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the newsletters before and after the current newsletter in the ordered set where campaignId = &#63;.
	*
	* @param newsletterId the primary key of the current newsletter
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next newsletter
	* @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException if a newsletter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter[] findByCampaignId_PrevAndNext(
		long newsletterId, long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the newsletters where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of newsletters where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching newsletters
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the newsletter where campaignId = &#63; and alias = &#63; and elementId = &#63; and eventType = &#63; or throws a {@link com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException} if it could not be found.
	*
	* @param campaignId the campaign ID
	* @param alias the alias
	* @param elementId the element ID
	* @param eventType the event type
	* @return the matching newsletter
	* @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException if a matching newsletter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter findByC_A_E_E(
		long campaignId, java.lang.String alias, java.lang.String elementId,
		java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the newsletter where campaignId = &#63; and alias = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param campaignId the campaign ID
	* @param alias the alias
	* @param elementId the element ID
	* @param eventType the event type
	* @return the matching newsletter, or <code>null</code> if a matching newsletter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter fetchByC_A_E_E(
		long campaignId, java.lang.String alias, java.lang.String elementId,
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the newsletter where campaignId = &#63; and alias = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param campaignId the campaign ID
	* @param alias the alias
	* @param elementId the element ID
	* @param eventType the event type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching newsletter, or <code>null</code> if a matching newsletter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter fetchByC_A_E_E(
		long campaignId, java.lang.String alias, java.lang.String elementId,
		java.lang.String eventType, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the newsletter where campaignId = &#63; and alias = &#63; and elementId = &#63; and eventType = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param alias the alias
	* @param elementId the element ID
	* @param eventType the event type
	* @return the newsletter that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter removeByC_A_E_E(
		long campaignId, java.lang.String alias, java.lang.String elementId,
		java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of newsletters where campaignId = &#63; and alias = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param campaignId the campaign ID
	* @param alias the alias
	* @param elementId the element ID
	* @param eventType the event type
	* @return the number of matching newsletters
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_A_E_E(long campaignId, java.lang.String alias,
		java.lang.String elementId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the newsletter in the entity cache if it is enabled.
	*
	* @param newsletter the newsletter
	*/
	public void cacheResult(
		com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter newsletter);

	/**
	* Caches the newsletters in the entity cache if it is enabled.
	*
	* @param newsletters the newsletters
	*/
	public void cacheResult(
		java.util.List<com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter> newsletters);

	/**
	* Creates a new newsletter with the primary key. Does not add the newsletter to the database.
	*
	* @param newsletterId the primary key for the new newsletter
	* @return the new newsletter
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter create(
		long newsletterId);

	/**
	* Removes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param newsletterId the primary key of the newsletter
	* @return the newsletter that was removed
	* @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException if a newsletter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter remove(
		long newsletterId)
		throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter updateImpl(
		com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter newsletter)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the newsletter with the primary key or throws a {@link com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException} if it could not be found.
	*
	* @param newsletterId the primary key of the newsletter
	* @return the newsletter
	* @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException if a newsletter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter findByPrimaryKey(
		long newsletterId)
		throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the newsletter with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param newsletterId the primary key of the newsletter
	* @return the newsletter, or <code>null</code> if a newsletter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter fetchByPrimaryKey(
		long newsletterId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the newsletters.
	*
	* @return the newsletters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the newsletters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.newsletter.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of newsletters
	* @param end the upper bound of the range of newsletters (not inclusive)
	* @return the range of newsletters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the newsletters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.newsletter.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of newsletters
	* @param end the upper bound of the range of newsletters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of newsletters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the newsletters from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of newsletters.
	*
	* @return the number of newsletters
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}