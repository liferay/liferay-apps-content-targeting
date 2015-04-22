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

import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.RuleInstanceModel;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.model.UserSegmentModel;
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
import com.liferay.portlet.blogs.model.BlogsEntryModel;

import java.util.ArrayList;
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

		_maxUserSegmentContentDisplayPageCount = GetterUtil.getInteger(
			properties.getProperty(
				"sample.sql.max.user.segment.content.display.page.count"));

		_maxUserSegmentContentListPageCount = GetterUtil.getInteger(
			properties.getProperty(
				"sample.sql.max.user.segment.content.list.page.count"));

		_maxUserSegmentCount = GetterUtil.getInteger(
			properties.getProperty("sample.sql.max.user.segment.count"));

		_maxUserSegmentRuleInstanceCount = GetterUtil.getInteger(
			properties.getProperty(
				"sample.sql.max.user.segment.rule.instance.count"));
	}

	public List<AssetEntryModel> getAssetEntryModels() {
		return _assetEntryModels;
	}

	public int getMaxUserSegmentContentDisplayPageCount() {
		return _maxUserSegmentContentDisplayPageCount;
	}

	public int getMaxUserSegmentContentListPageCount() {
		return _maxUserSegmentContentListPageCount;
	}

	@Override
	public AssetEntryModel newAssetEntryModel(BlogsEntryModel blogsEntryModel) {
		AssetEntryModel assetEntryModel = super.newAssetEntryModel(
			blogsEntryModel);

		_assetEntryModels.add(assetEntryModel);

		return assetEntryModel;
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

		for (int i = 0; i < _userSegmentModels.size(); i++) {
			UserSegmentModel userSegmentModel = _userSegmentModels.get(i);

			int pos = RandomUtil.nextInt(_assetEntryModels.size());

			AssetEntryModel assetEntryModel = _assetEntryModels.get(pos);

			jxPortletPreferences.setValue(
				"assetEntryId" + i,
				String.valueOf(assetEntryModel.getEntryId()));
			jxPortletPreferences.setValue("enablequeryContains" + i, "true");
			jxPortletPreferences.setValue("queryAndOperator" + i, "false");
			jxPortletPreferences.setValue(
				"userSegmentAssetCategoryIds" + i,
				String.valueOf(userSegmentModel.getAssetCategoryId()));
		}

		jxPortletPreferences.setValue("showAssetTitle", "false");
		jxPortletPreferences.setValues(
			"queryLogicIndexes", new String[]{"0", "1", "2"});
		jxPortletPreferences.setValue("contentDefaultValue", "false");
		jxPortletPreferences.setValue("enableSocialBookmarks", "false");
		jxPortletPreferences.setValue(
			"displayStyleGroupId", String.valueOf(groupId));
		jxPortletPreferences.setValue("displayStyle", "full-content");

		return newPortletPreferencesModel(
			plid, portletId,
			_portletPreferencesFactory.toXML(jxPortletPreferences));
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
	private long _lastRightCategoryId = 2;
	private int _maxUserSegmentContentDisplayPageCount;
	private int _maxUserSegmentContentListPageCount;
	private int _maxUserSegmentCount;
	private int _maxUserSegmentRuleInstanceCount;
	private List<RuleInstanceModel> _ruleInstanceModels =
		new ArrayList<RuleInstanceModel>();
	private List<UserSegmentModel> _userSegmentModels =
		new ArrayList<UserSegmentModel>();
	private LayoutModel _visitedLayoutModel;

}