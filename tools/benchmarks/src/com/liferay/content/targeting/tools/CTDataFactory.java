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

package com.liferay.content.targeting.tools;

import com.liferay.content.targeting.model.CampaignModel;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.RuleInstanceModel;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.model.UserSegmentModel;
import com.liferay.content.targeting.model.impl.CampaignModelImpl;
import com.liferay.content.targeting.model.impl.RuleInstanceModelImpl;
import com.liferay.content.targeting.model.impl.UserSegmentModelImpl;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.security.RandomUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CompanyModel;
import com.liferay.portal.model.LayoutModel;
import com.liferay.portal.model.PortletConstants;
import com.liferay.portal.model.PortletPreferencesModel;
import com.liferay.portal.model.ResourcePermissionModel;
import com.liferay.portal.model.UserModel;
import com.liferay.portal.tools.samplesqlbuilder.DataFactory;
import com.liferay.portal.tools.samplesqlbuilder.SequentialUUID;
import com.liferay.portlet.PortletPreferencesFactory;
import com.liferay.portlet.PortletPreferencesFactoryImpl;
import com.liferay.portlet.PortletPreferencesImpl;
import com.liferay.portlet.asset.model.AssetCategoryModel;
import com.liferay.portlet.asset.model.AssetEntryModel;
import com.liferay.portlet.asset.model.AssetVocabularyModel;
import com.liferay.portlet.journal.model.JournalArticleModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.portlet.PortletPreferences;

/**
 * @author Eudaldo Alonso
 */
public class CTDataFactory extends DataFactory {

	public CTDataFactory(Properties properties) throws Exception {
		super(properties);

		_maxCampaignContentDisplayPageCount = GetterUtil.getInteger(
			properties.getProperty(
				"sample.sql.max.campaign.content.display.page.count"));

		_maxCampaignContentDisplayPortletCount = GetterUtil.getInteger(
			properties.getProperty(
				"sample.sql.max.campaign.content.display.portlet.count"));

		_maxCampaignContentDisplayQueryRuleCount = GetterUtil.getInteger(
			properties.getProperty(
				"sample.sql.max.campaign.content.display.query.rule.count"));

		_maxCampaignCount = GetterUtil.getInteger(
			properties.getProperty("sample.sql.max.campaign.count"));

		_maxUserSegmentContentDisplayPageCount = GetterUtil.getInteger(
			properties.getProperty(
				"sample.sql.max.user.segment.content.display.page.count"));

		_maxUserSegmentContentDisplayPortletCount = GetterUtil.getInteger(
			properties.getProperty(
				"sample.sql.max.user.segment.content.display.portlet.count"));

		_maxUserSegmentContentDisplayQueryRuleCount = GetterUtil.getInteger(
			properties.getProperty(
				"sample.sql.max.user.segment.content.display.query.rule." +
					"count"));

		_maxUserSegmentContentListPageCount = GetterUtil.getInteger(
			properties.getProperty(
				"sample.sql.max.user.segment.content.list.page.count"));

		_maxUserSegmentContentListPortletCount = GetterUtil.getInteger(
			properties.getProperty(
				"sample.sql.max.user.segment.content.list.portlet.count"));

		_maxUserSegmentCount = GetterUtil.getInteger(
			properties.getProperty("sample.sql.max.user.segment.count"));

		_maxUserSegmentRuleInstanceCount = GetterUtil.getInteger(
			properties.getProperty(
				"sample.sql.max.user.segment.rule.instance.count"));
	}

	public List<AssetEntryModel> getAssetEntryModels() {
		return _assetEntryModels;
	}

	public long getCampaignUserSegmentId(int index) {
		if (index >= _userSegmentModels.size()) {
			return -1;
		}

		UserSegmentModel userSegmentModel = _userSegmentModels.get(index);

		return userSegmentModel.getUserSegmentId();
	}

	public int getMaxCampaignContentDisplayPageCount() {
		return _maxCampaignContentDisplayPageCount;
	}

	public int getMaxCampaignContentDisplayPortletCount() {
		return _maxCampaignContentDisplayPortletCount;
	}

	public int getMaxUserSegmentContentDisplayPageCount() {
		return _maxUserSegmentContentDisplayPageCount;
	}

	public int getMaxUserSegmentContentDisplayPortletCount() {
		return _maxUserSegmentContentDisplayPortletCount;
	}

	public int getMaxUserSegmentContentListPageCount() {
		return _maxUserSegmentContentListPageCount;
	}

	public int getMaxUserSegmentContentListPortletCount() {
		return _maxUserSegmentContentListPortletCount;
	}

	public String getPortletLayoutColumn(String portletIdPrefix, int count) {
		StringBundler sb = new StringBundler(3 * count);

		for (int i = 1; i <= count; i++) {
			sb.append(portletIdPrefix);
			sb.append(i);
			sb.append(StringPool.COMMA);
		}

		return sb.toString();
	}

	@Override
	public AssetEntryModel newAssetEntryModel(
		JournalArticleModel journalArticleModel) {

		AssetEntryModel assetEntryModel = super.newAssetEntryModel(
			journalArticleModel);

		_assetEntryModels.add(assetEntryModel);

		return assetEntryModel;
	}

	public PortletPreferencesModel
		newCampaignContentDisplayPortletPreferenceModels(
			long groupId, long plid, String portletId)
		throws Exception {

		PortletPreferences jxPortletPreferences = new PortletPreferencesImpl();

		jxPortletPreferences.setValue(
			"assetEntryIdDefault", String.valueOf(getAssetEntryId()));
		jxPortletPreferences.setValue("contentDefaultValue", "true");
		jxPortletPreferences.setValue("showAssetTitle", "false");
		jxPortletPreferences.setValue("contentDefaultValue", "false");
		jxPortletPreferences.setValue("enableSocialBookmarks", "false");
		jxPortletPreferences.setValue(
			"displayStyleGroupId", String.valueOf(groupId));
		jxPortletPreferences.setValue("displayStyle", "full-content");

		List<String> queryRuleIndexes = new ArrayList<String>(
			_maxCampaignContentDisplayQueryRuleCount);

		if (!_campaignModels.isEmpty()) {
			for (int i = 0; i < _maxCampaignContentDisplayQueryRuleCount; i++) {
				jxPortletPreferences.setValue(
					"assetEntryId" + i, String.valueOf(getAssetEntryId()));

				int pos = RandomUtil.nextInt(_campaignModels.size());

				CampaignModel campaignModel = _campaignModels.get(pos);

				jxPortletPreferences.setValue(
					"campaignId" + i,
					String.valueOf(campaignModel.getCampaignId()));

				queryRuleIndexes.add(String.valueOf(i));
			}
		}

		jxPortletPreferences.setValues(
			"queryLogicIndexes",
			queryRuleIndexes.toArray(new String[queryRuleIndexes.size()]));

		return newPortletPreferencesModel(
			plid, portletId,
			_portletPreferencesFactory.toXML(jxPortletPreferences));
	}

	public List<CampaignModel> newCampaignModels(long groupId)
		throws Exception {

		_campaignModels = new ArrayList<CampaignModel>(_maxCampaignCount);

		for (int i = 0; i < _maxCampaignCount; i++) {
			_campaignModels.add(newCampaignModel(groupId, i));
		}

		return _campaignModels;
	}

	@Override
	public List<LayoutModel> newPublicLayoutModels(long groupId) {
		List<LayoutModel> layoutModels = super.newPublicLayoutModels(groupId);

		_visitedLayoutModel = newLayoutModel(
			groupId, "visited-page", StringPool.BLANK, StringPool.BLANK);

		layoutModels.add(_visitedLayoutModel);

		return layoutModels;
	}

	public List<ResourcePermissionModel> newResourcePermissionModels(
		CampaignModel campaignModel) {

		return newResourcePermissionModels(
			RuleInstance.class.getName(),
			String.valueOf(campaignModel.getCampaignId()), getUserId());
	}

	public List<ResourcePermissionModel> newResourcePermissionModels(
		RuleInstanceModel ruleInstanceModel) {

		return newResourcePermissionModels(
			RuleInstance.class.getName(),
			String.valueOf(ruleInstanceModel.getRuleInstanceId()), getUserId());
	}

	public List<ResourcePermissionModel> newResourcePermissionModels(
		UserSegmentModel userSegmentModel) {

		return newResourcePermissionModels(
			UserSegment.class.getName(),
			String.valueOf(userSegmentModel.getUserSegmentId()), getUserId());
	}

	public List<RuleInstanceModel> newRuleInstanceModels(
			long groupId, long userSegmentId)
		throws Exception {

		List<RuleInstanceModel> ruleInstanceModels =
			new ArrayList<RuleInstanceModel>(_maxUserSegmentRuleInstanceCount);

		for (int i = 0; i < _maxUserSegmentRuleInstanceCount; i++) {
			ruleInstanceModels.add(
				newRuleInstanceModel(groupId, userSegmentId));
		}

		return ruleInstanceModels;
	}

	public AssetCategoryModel newUserSegmentAssetCategoryModel(
		long groupId, long assetVocabularyId,
		UserSegmentModel userSegmentModel) {

		AssetCategoryModel assetCategoryModel = newAssetCategoryModel(
			groupId, _lastRightCategoryId, userSegmentModel.getName("en_US"),
			assetVocabularyId);

		_lastRightCategoryId += 2;

		return assetCategoryModel;
	}

	public AssetVocabularyModel newUserSegmentAssetVocabularyModel(
		long groupId) {

		return newAssetVocabularyModel(
			groupId, getUserId(), getUserName(), "User Segment");
	}

	public PortletPreferencesModel
		newUserSegmentContentDisplayPortletPreferenceModels(
			long groupId, long plid, String portletId)
		throws Exception {

		PortletPreferences jxPortletPreferences = new PortletPreferencesImpl();

		jxPortletPreferences.setValue(
			"assetEntryIdDefault", String.valueOf(getAssetEntryId()));
		jxPortletPreferences.setValue("contentDefaultValue", "true");
		jxPortletPreferences.setValue("showAssetTitle", "false");
		jxPortletPreferences.setValue("contentDefaultValue", "false");
		jxPortletPreferences.setValue("enableSocialBookmarks", "false");
		jxPortletPreferences.setValue(
			"displayStyleGroupId", String.valueOf(groupId));
		jxPortletPreferences.setValue("displayStyle", "full-content");

		List<String> queryRuleIndexes = new ArrayList<String>(
			_maxUserSegmentContentDisplayQueryRuleCount);

		if (!_userSegmentModels.isEmpty()) {
			for (int i = 0; i < _maxUserSegmentContentDisplayQueryRuleCount;
				i++) {

				int pos = RandomUtil.nextInt(_userSegmentModels.size());

				UserSegmentModel userSegmentModel = _userSegmentModels.get(pos);

				jxPortletPreferences.setValue(
					"assetEntryId" + i, String.valueOf(getAssetEntryId()));
				jxPortletPreferences.setValue("queryContains" + i, "true");
				jxPortletPreferences.setValue("queryAndOperator" + i, "false");
				jxPortletPreferences.setValue(
					"userSegmentAssetCategoryIds" + i,
					String.valueOf(userSegmentModel.getAssetCategoryId()));

				queryRuleIndexes.add(String.valueOf(i));
			}
		}

		jxPortletPreferences.setValues(
			"queryLogicIndexes",
			queryRuleIndexes.toArray(new String[queryRuleIndexes.size()]));

		return newPortletPreferencesModel(
			plid, portletId,
			_portletPreferencesFactory.toXML(jxPortletPreferences));
	}

	public PortletPreferencesModel
		newUserSegmentContentListPortletPreferenceModels(
			long plid, String portletId)
		throws Exception {

		return newPortletPreferencesModel(
			plid, portletId, PortletConstants.DEFAULT_PREFERENCES);
	}

	public List<UserSegmentModel> newUserSegmentModels(long groupId)
		throws Exception {

		initRuleInstanceModels(groupId);

		_userSegmentModels = new ArrayList<UserSegmentModel>(
			_maxUserSegmentCount);

		for (int i = 0; i < _maxUserSegmentCount; i++) {
			_userSegmentModels.add(newUserSegmentModel(groupId, i));
		}

		return _userSegmentModels;
	}

	public void setAssetCategoryToUserSegment(long assetCategoryId, int index) {
		UserSegmentModel userSegmentModel = _userSegmentModels.get(index);

		userSegmentModel.setAssetCategoryId(assetCategoryId);
	}

	protected long getAssetEntryId() {
		if (_assetEntryModels.isEmpty()) {
			return -1;
		}

		int pos = RandomUtil.nextInt(_assetEntryModels.size());

		AssetEntryModel assetEntryModel = _assetEntryModels.get(pos);

		return assetEntryModel.getEntryId();
	}

	protected long getCompanyId() {
		CompanyModel companyModel = getCompanyModel();

		return companyModel.getCompanyId();
	}

	protected long getUserId() {
		UserModel userModel = getSampleUserModel();

		return userModel.getUserId();
	}

	protected String getUserName() {
		UserModel userModel = getSampleUserModel();

		return userModel.getFirstName();
	}

	protected void initRuleInstanceModels(long groupId) {

		// Age Rule

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("youngerThan", 100);
		jsonObj.put("olderThan", 30);

		_ruleInstanceModels.add(
			newRuleInstanceModel("AgeRule", jsonObj.toString()));

		// Browser Rule

		_ruleInstanceModels.add(newRuleInstanceModel("BrowserRule", "Firefox"));

		// Gender Rule

		_ruleInstanceModels.add(newRuleInstanceModel("GenderRule", "male"));

		// Page Visited Rule

		_ruleInstanceModels.add(
			newRuleInstanceModel(
				"PageVisitedRule",
				String.valueOf(_visitedLayoutModel.getPlid())));

		// Site Member Rule

		_ruleInstanceModels.add(
			newRuleInstanceModel("SiteMemberRule", String.valueOf(groupId)));

		// User Logged Rule

		_ruleInstanceModels.add(
			newRuleInstanceModel("UserLogged", StringPool.BLANK));
	}

	protected CampaignModel newCampaignModel(long groupId, int index) {
		setClassLoader();

		CampaignModel campaignModel = new CampaignModelImpl();

		campaignModel.setUuid(SequentialUUID.generate());
		campaignModel.setCampaignId(getCounterNext());
		campaignModel.setGroupId(groupId);
		campaignModel.setCompanyId(getCompanyId());
		campaignModel.setUserId(getUserId());
		campaignModel.setUserName(getUserName());

		campaignModel.setCreateDate(new Date());
		campaignModel.setModifiedDate(new Date());

		StringBundler sb = new StringBundler(5);

		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><root ");
		sb.append("available-locales=\"en_US\" default-locale=\"en_US\">");
		sb.append("<Name language-id=\"en_US\">Campaign ");
		sb.append(index);
		sb.append("</Name></root>");

		campaignModel.setName(sb.toString());

		sb = new StringBundler(5);

		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><root ");
		sb.append("available-locales=\"en_US\" default-locale=\"en_US\">");
		sb.append("<Description language-id=\"en_US\">Campaign ");
		sb.append(index);
		sb.append("</Description></root>");

		campaignModel.setDescription(sb.toString());

		Calendar startDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();

		startDate.add(Calendar.YEAR, -1);
		endDate.add(Calendar.YEAR, 1);

		campaignModel.setStartDate(startDate.getTime());
		campaignModel.setEndDate(endDate.getTime());

		campaignModel.setPriority(RandomUtil.nextInt(5));
		campaignModel.setActive(true);

		return campaignModel;
	}

	protected RuleInstanceModel newRuleInstanceModel(
		long groupId, long userSegmentId) {

		int pos = RandomUtil.nextInt(_ruleInstanceModels.size());

		RuleInstanceModel ruleInstanceModel =
			(RuleInstanceModel)_ruleInstanceModels.get(pos).clone();

		ruleInstanceModel.setUuid(SequentialUUID.generate());
		ruleInstanceModel.setRuleInstanceId(getCounterNext());
		ruleInstanceModel.setGroupId(groupId);
		ruleInstanceModel.setUserSegmentId(userSegmentId);

		return ruleInstanceModel;
	}

	protected RuleInstanceModel newRuleInstanceModel(
		String ruleKey, String typeSettings) {

		setClassLoader();

		RuleInstanceModel ruleInstanceModel = new RuleInstanceModelImpl();

		ruleInstanceModel.setCompanyId(getCompanyId());
		ruleInstanceModel.setUserId(getUserId());
		ruleInstanceModel.setUserName(getUserName());
		ruleInstanceModel.setCreateDate(new Date());
		ruleInstanceModel.setModifiedDate(new Date());
		ruleInstanceModel.setRuleKey(ruleKey);
		ruleInstanceModel.setTypeSettings(typeSettings);

		return ruleInstanceModel;
	}

	protected UserSegmentModel newUserSegmentModel(long groupId, int index) {
		setClassLoader();

		UserSegmentModel userSegmentModel = new UserSegmentModelImpl();

		userSegmentModel.setUuid(SequentialUUID.generate());
		userSegmentModel.setUserSegmentId(getCounterNext());
		userSegmentModel.setGroupId(groupId);
		userSegmentModel.setCompanyId(getCompanyId());
		userSegmentModel.setUserId(getUserId());
		userSegmentModel.setUserName(getUserName());

		userSegmentModel.setCreateDate(new Date());
		userSegmentModel.setModifiedDate(new Date());

		StringBundler sb = new StringBundler(5);

		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><root ");
		sb.append("available-locales=\"en_US\" default-locale=\"en_US\">");
		sb.append("<Name language-id=\"en_US\">User Segment ");
		sb.append(index);
		sb.append("</Name></root>");

		userSegmentModel.setName(sb.toString());

		sb = new StringBundler(5);

		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><root ");
		sb.append("available-locales=\"en_US\" default-locale=\"en_US\">");
		sb.append("<Description language-id=\"en_US\">User Segment ");
		sb.append(index);
		sb.append("</Description></root>");

		userSegmentModel.setDescription(sb.toString());

		return userSegmentModel;
	}

	protected void setClassLoader() {
		Thread currentThread = Thread.currentThread();

		PortletClassLoaderUtil.setClassLoader(
			currentThread.getContextClassLoader());
	}

	private static PortletPreferencesFactory _portletPreferencesFactory =
		new PortletPreferencesFactoryImpl();

	private List<AssetEntryModel> _assetEntryModels =
		new ArrayList<AssetEntryModel>();
	private List<CampaignModel> _campaignModels =
		new ArrayList<CampaignModel>();
	private long _lastRightCategoryId = 2;
	private int _maxCampaignContentDisplayPageCount;
	private int _maxCampaignContentDisplayPortletCount;
	private int _maxCampaignContentDisplayQueryRuleCount;
	private int _maxCampaignCount;
	private int _maxUserSegmentContentDisplayPageCount;
	private int _maxUserSegmentContentDisplayPortletCount;
	private int _maxUserSegmentContentDisplayQueryRuleCount;
	private int _maxUserSegmentContentListPageCount;
	private int _maxUserSegmentContentListPortletCount;
	private int _maxUserSegmentCount;
	private int _maxUserSegmentRuleInstanceCount;
	private List<RuleInstanceModel> _ruleInstanceModels =
		new ArrayList<RuleInstanceModel>();
	private List<UserSegmentModel> _userSegmentModels =
		new ArrayList<UserSegmentModel>();
	private LayoutModel _visitedLayoutModel;

}