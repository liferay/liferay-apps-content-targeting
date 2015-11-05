<#--
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
-->

<#assign assetVocabularyModel = dataFactory.newUserSegmentAssetVocabularyModel(groupId) />

insert into AssetVocabulary values ('${assetVocabularyModel.uuid}', ${assetVocabularyModel.vocabularyId}, ${assetVocabularyModel.groupId}, ${assetVocabularyModel.companyId}, ${assetVocabularyModel.userId}, '${assetVocabularyModel.userName}', '${dataFactory.getDateString(assetVocabularyModel.createDate)}', '${dataFactory.getDateString(assetVocabularyModel.modifiedDate)}', '${assetVocabularyModel.name}', '${assetVocabularyModel.title}', '${assetVocabularyModel.description}', '${assetVocabularyModel.settings}');

<@insertResourcePermissions
	_entry = assetVocabularyModel
/>

<#assign assetEntryModels = dataFactory.getAssetEntryModels() />
<#assign userSegmentModels = dataFactory.newUserSegmentModels(groupId) />

<#list userSegmentModels as userSegmentModel>
	<#assign assetCategoryModel = dataFactory.newUserSegmentAssetCategoryModel(groupId, assetVocabularyModel.vocabularyId, userSegmentModel) />

	insert into AssetCategory values ('${assetCategoryModel.uuid}', ${assetCategoryModel.categoryId}, ${assetCategoryModel.groupId}, ${assetCategoryModel.companyId}, ${assetCategoryModel.userId}, '${assetCategoryModel.userName}', '${dataFactory.getDateString(assetCategoryModel.createDate)}', '${dataFactory.getDateString(assetCategoryModel.modifiedDate)}', ${assetCategoryModel.parentCategoryId}, ${assetCategoryModel.leftCategoryId}, ${assetCategoryModel.rightCategoryId}, '${assetCategoryModel.name}', '${assetCategoryModel.title}', '${assetCategoryModel.description}', ${assetCategoryModel.vocabularyId});

	<@insertResourcePermissions
		_entry = assetCategoryModel
	/>

	<#list assetEntryModels as assetEntryModel>
	insert into AssetEntries_AssetCategories values (${assetCategoryModel.categoryId}, ${assetEntryModel.entryId});
	</#list>

	${dataFactory.setAssetCategoryToUserSegment(assetCategoryModel.categoryId, userSegmentModel_index)}

	insert into CT_UserSegment values ('${userSegmentModel.uuid}', ${userSegmentModel.userSegmentId}, ${userSegmentModel.groupId}, ${assetCategoryModel.categoryId}, ${userSegmentModel.companyId}, ${userSegmentModel.userId}, '${userSegmentModel.userName}', '${dataFactory.getDateString(userSegmentModel.createDate)}', '${dataFactory.getDateString(userSegmentModel.modifiedDate)}', '${userSegmentModel.name}', '${userSegmentModel.description}');

	<@insertResourcePermissions
		_entry = userSegmentModel
	/>

	<#assign ruleInstanceModels = dataFactory.newRuleInstanceModels(groupId, userSegmentModel.userSegmentId) />

	<#list ruleInstanceModels as ruleInstanceModel>
		insert into CT_RuleInstance values ('${ruleInstanceModel.uuid}', ${ruleInstanceModel.ruleInstanceId}, ${ruleInstanceModel.groupId}, ${ruleInstanceModel.companyId}, ${ruleInstanceModel.userId}, '${ruleInstanceModel.userName}', '${dataFactory.getDateString(ruleInstanceModel.createDate)}', '${dataFactory.getDateString(ruleInstanceModel.modifiedDate)}', '${ruleInstanceModel.ruleKey}', ${ruleInstanceModel.userSegmentId}, '${ruleInstanceModel.typeSettings}');

		<@insertResourcePermissions
			_entry = ruleInstanceModel
		/>
	</#list>
</#list>