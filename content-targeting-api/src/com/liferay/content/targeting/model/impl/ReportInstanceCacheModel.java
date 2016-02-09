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

package com.liferay.content.targeting.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.model.ReportInstance;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ReportInstance in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ReportInstance
 * @generated
 */
@ProviderType
public class ReportInstanceCacheModel implements CacheModel<ReportInstance>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ReportInstanceCacheModel)) {
			return false;
		}

		ReportInstanceCacheModel reportInstanceCacheModel = (ReportInstanceCacheModel)obj;

		if (reportInstanceId == reportInstanceCacheModel.reportInstanceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, reportInstanceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", reportInstanceId=");
		sb.append(reportInstanceId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", reportKey=");
		sb.append(reportKey);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", typeSettings=");
		sb.append(typeSettings);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ReportInstance toEntityModel() {
		ReportInstanceImpl reportInstanceImpl = new ReportInstanceImpl();

		if (uuid == null) {
			reportInstanceImpl.setUuid(StringPool.BLANK);
		}
		else {
			reportInstanceImpl.setUuid(uuid);
		}

		reportInstanceImpl.setReportInstanceId(reportInstanceId);
		reportInstanceImpl.setGroupId(groupId);
		reportInstanceImpl.setCompanyId(companyId);
		reportInstanceImpl.setUserId(userId);

		if (userName == null) {
			reportInstanceImpl.setUserName(StringPool.BLANK);
		}
		else {
			reportInstanceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			reportInstanceImpl.setCreateDate(null);
		}
		else {
			reportInstanceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			reportInstanceImpl.setModifiedDate(null);
		}
		else {
			reportInstanceImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (reportKey == null) {
			reportInstanceImpl.setReportKey(StringPool.BLANK);
		}
		else {
			reportInstanceImpl.setReportKey(reportKey);
		}

		if (name == null) {
			reportInstanceImpl.setName(StringPool.BLANK);
		}
		else {
			reportInstanceImpl.setName(name);
		}

		if (description == null) {
			reportInstanceImpl.setDescription(StringPool.BLANK);
		}
		else {
			reportInstanceImpl.setDescription(description);
		}

		if (className == null) {
			reportInstanceImpl.setClassName(StringPool.BLANK);
		}
		else {
			reportInstanceImpl.setClassName(className);
		}

		reportInstanceImpl.setClassPK(classPK);

		if (typeSettings == null) {
			reportInstanceImpl.setTypeSettings(StringPool.BLANK);
		}
		else {
			reportInstanceImpl.setTypeSettings(typeSettings);
		}

		reportInstanceImpl.resetOriginalValues();

		return reportInstanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		reportInstanceId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		reportKey = objectInput.readUTF();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		className = objectInput.readUTF();

		classPK = objectInput.readLong();
		typeSettings = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(reportInstanceId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (reportKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reportKey);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPK);

		if (typeSettings == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typeSettings);
		}
	}

	public String uuid;
	public long reportInstanceId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String reportKey;
	public String name;
	public String description;
	public String className;
	public long classPK;
	public String typeSettings;
}