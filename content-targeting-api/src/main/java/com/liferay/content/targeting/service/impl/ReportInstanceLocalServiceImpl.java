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

package com.liferay.content.targeting.service.impl;

import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.content.targeting.exception.DuplicateReportInstanceException;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.service.base.ReportInstanceLocalServiceBaseImpl;
import com.liferay.content.targeting.util.BaseModelSearchResult;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.facet.MultiValueFacet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * The implementation of the report instance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.service.ReportInstanceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.base.ReportInstanceLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.ReportInstanceLocalServiceUtil
 */
public class ReportInstanceLocalServiceImpl
	extends ReportInstanceLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ReportInstance addReportInstance(
			long userId, String reportKey, String className, long classPK,
			Map<Locale, String> nameMap, Map<Locale, String> descriptionMap,
			String typeSettings, ServiceContext serviceContext)
		throws PortalException {

		Report report = reportsRegistry.getReport(reportKey);

		if (!report.isInstantiable() &&
			(reportInstancePersistence.countByR_C_C(
				reportKey, className, classPK) > 0)) {

			throw new DuplicateReportInstanceException(
				"A report instance of the type " + reportKey + " already " +
					"exists in this classPK " + classPK
			);
		}

		User user = userLocalService.getUser(userId);

		long groupId = serviceContext.getScopeGroupId();

		long reportInstanceId = counterLocalService.increment();

		ReportInstance reportInstance = reportInstancePersistence.create(
			reportInstanceId);

		reportInstance.setCreateDate(new Date());
		reportInstance.setUuid(serviceContext.getUuid());
		reportInstance.setGroupId(groupId);
		reportInstance.setCompanyId(user.getCompanyId());
		reportInstance.setUserId(user.getUserId());
		reportInstance.setUserName(user.getFullName());

		reportInstance.setModifiedDate(new Date());
		reportInstance.setReportKey(reportKey);
		reportInstance.setClassName(className);
		reportInstance.setClassPK(classPK);
		reportInstance.setNameMap(nameMap);
		reportInstance.setDescriptionMap(descriptionMap);
		reportInstance.setTypeSettings(typeSettings);

		reportInstancePersistence.update(reportInstance);

		return reportInstance;
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ReportInstance addReportInstance(
			long userId, String reportKey, String className, long classPK,
			String typeSettings, ServiceContext serviceContext)
		throws PortalException {

		Map<Locale, String> descriptionMap = new HashMap<>();
		Map<Locale, String> nameMap = new HashMap<>();

		Set<Locale> availableLocales = LanguageUtil.getAvailableLocales();

		Report report = reportsRegistry.getReport(reportKey);

		for (Locale locale : availableLocales) {
			nameMap.put(locale, report.getName(locale));
			descriptionMap.put(locale, report.getDescription(locale));
		}

		return addReportInstance(
			userId, reportKey, className, classPK, nameMap, descriptionMap,
			typeSettings, serviceContext);
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public ReportInstance deleteReportInstance(long reportInstanceId)
		throws PortalException {

		ReportInstance reportInstance = reportInstancePersistence.remove(
			reportInstanceId);

		List<TrackingActionInstance> trackingActionInstances =
			trackingActionInstanceLocalService.
				getTrackingActionInstancesByReportInstanceId(reportInstanceId);

		for (TrackingActionInstance trackingActionInstance
				: trackingActionInstances) {

			trackingActionInstanceLocalService.deleteTrackingActionInstance(
				trackingActionInstance.getTrackingActionInstanceId());
		}

		return reportInstance;
	}

	@Override
	public ReportInstance fetchReportInstance(
		String reportKey, String className, long classPK) {

		List<ReportInstance> reportInstances =
			reportInstancePersistence.findByR_C_C(
				reportKey, className, classPK);

		if (reportInstances.isEmpty() || (reportInstances.size() > 1)) {
			return null;
		}

		return reportInstances.get(0);
	}

	@Override
	public List<ReportInstance> findReportInstances(
		String reportKey, String className, long classPK) {

		return reportInstancePersistence.findByR_C_C(
			reportKey, className, classPK);
	}

	@Override
	public Report getReport(String reportKey) {
		return reportsRegistry.getReport(reportKey);
	}

	@Override
	public int getReportInstanceCount(
		String reportKey, String className, long classPK) {

		return reportInstancePersistence.countByR_C_C(
			reportKey, className, classPK);
	}

	@Override
	public List<ReportInstance> getReportInstances(
		String className, long classPK) {

		return reportInstancePersistence.findByC_C(className, classPK);
	}

	@Override
	public List<ReportInstance> getReportInstances(
		String className, long classPK, int start, int end) {

		return reportInstancePersistence.findByC_C(
			className, classPK, start, end);
	}

	@Override
	public List<ReportInstance> searchReportInstances(
			long groupId, String className, long classPK, String keywords,
			int start, int end)
		throws PortalException {

		SearchContext searchContext = buildSearchContext(
			groupId, className, classPK, keywords, start, end);

		return searchReportInstances(searchContext).getBaseModels();
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ReportInstance updateReportInstance(
			long reportInstanceId, long userId, String reportKey,
			String className, long classPK, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException {

		ReportInstance reportInstance = getReportInstance(reportInstanceId);

		reportInstance.setModifiedDate(new Date());
		reportInstance.setReportKey(reportKey);
		reportInstance.setClassName(className);
		reportInstance.setClassPK(classPK);
		reportInstance.setNameMap(nameMap);
		reportInstance.setDescriptionMap(descriptionMap);
		reportInstance.setTypeSettings(typeSettings);

		reportInstancePersistence.update(reportInstance);

		return reportInstance;
	}

	protected SearchContext buildSearchContext(
			long groupId, String className, long classPK, String keywords,
			int start, int end)
		throws PortalException {

		SearchContext searchContext = new SearchContext();

		Group group = groupLocalService.getGroup(groupId);

		MultiValueFacet classNameFacet = new MultiValueFacet(searchContext);

		classNameFacet.setFieldName("className");
		classNameFacet.setStatic(true);
		classNameFacet.setValues(new String[] {className});

		MultiValueFacet classPKFacet = new MultiValueFacet(searchContext);

		classPKFacet.setFieldName("classPK");
		classPKFacet.setStatic(true);
		classPKFacet.setValues(new long[] {classPK});

		searchContext.addFacet(classNameFacet);
		searchContext.addFacet(classPKFacet);
		searchContext.setCompanyId(group.getCompanyId());
		searchContext.setGroupIds(new long[] {groupId});
		searchContext.setEnd(end);
		searchContext.setKeywords(keywords == null ? "" : keywords);
		searchContext.setStart(start);

		return searchContext;
	}

	protected BaseModelSearchResult<ReportInstance> searchReportInstances(
			SearchContext searchContext)
		throws PortalException {

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			ReportInstance.class);

		for (int i = 0; i < 10; i++) {
			Hits hits = indexer.search(searchContext);

			List<ReportInstance> reportInstances = null;

			if (hits != null) {
				List<Document> documents = hits.toList();

				reportInstances = new ArrayList<>(documents.size());

				for (Document document : documents) {
					long reportInstanceId = GetterUtil.getLong(
						document.get("reportInstanceId"));

					ReportInstance reportInstance = getReportInstance(
						reportInstanceId);

					if (reportInstance != null) {
						reportInstances.add(reportInstance);
					}
				}
			}
			else {
				reportInstances = new ArrayList<>(0);
			}

			if ((hits != null) && (reportInstances != null)) {
				return new BaseModelSearchResult<>(
					reportInstances, hits.getLength());
			}
		}

		throw new SearchException(
			"Unable to fix the search index after 10 attempts");
	}

	@ServiceReference(type = ReportsRegistry.class)
	protected ReportsRegistry reportsRegistry;

}