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

package com.liferay.content.targeting.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ReportInstance}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReportInstance
 * @generated
 */
public class ReportInstanceWrapper implements ReportInstance,
	ModelWrapper<ReportInstance> {
	public ReportInstanceWrapper(ReportInstance reportInstance) {
		_reportInstance = reportInstance;
	}

	@Override
	public Class<?> getModelClass() {
		return ReportInstance.class;
	}

	@Override
	public String getModelClassName() {
		return ReportInstance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("reportInstanceId", getReportInstanceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("reportKey", getReportKey());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("typeSettings", getTypeSettings());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long reportInstanceId = (Long)attributes.get("reportInstanceId");

		if (reportInstanceId != null) {
			setReportInstanceId(reportInstanceId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String reportKey = (String)attributes.get("reportKey");

		if (reportKey != null) {
			setReportKey(reportKey);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String typeSettings = (String)attributes.get("typeSettings");

		if (typeSettings != null) {
			setTypeSettings(typeSettings);
		}
	}

	/**
	* Returns the primary key of this report instance.
	*
	* @return the primary key of this report instance
	*/
	@Override
	public long getPrimaryKey() {
		return _reportInstance.getPrimaryKey();
	}

	/**
	* Sets the primary key of this report instance.
	*
	* @param primaryKey the primary key of this report instance
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_reportInstance.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the report instance ID of this report instance.
	*
	* @return the report instance ID of this report instance
	*/
	@Override
	public long getReportInstanceId() {
		return _reportInstance.getReportInstanceId();
	}

	/**
	* Sets the report instance ID of this report instance.
	*
	* @param reportInstanceId the report instance ID of this report instance
	*/
	@Override
	public void setReportInstanceId(long reportInstanceId) {
		_reportInstance.setReportInstanceId(reportInstanceId);
	}

	/**
	* Returns the group ID of this report instance.
	*
	* @return the group ID of this report instance
	*/
	@Override
	public long getGroupId() {
		return _reportInstance.getGroupId();
	}

	/**
	* Sets the group ID of this report instance.
	*
	* @param groupId the group ID of this report instance
	*/
	@Override
	public void setGroupId(long groupId) {
		_reportInstance.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this report instance.
	*
	* @return the company ID of this report instance
	*/
	@Override
	public long getCompanyId() {
		return _reportInstance.getCompanyId();
	}

	/**
	* Sets the company ID of this report instance.
	*
	* @param companyId the company ID of this report instance
	*/
	@Override
	public void setCompanyId(long companyId) {
		_reportInstance.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this report instance.
	*
	* @return the user ID of this report instance
	*/
	@Override
	public long getUserId() {
		return _reportInstance.getUserId();
	}

	/**
	* Sets the user ID of this report instance.
	*
	* @param userId the user ID of this report instance
	*/
	@Override
	public void setUserId(long userId) {
		_reportInstance.setUserId(userId);
	}

	/**
	* Returns the user uuid of this report instance.
	*
	* @return the user uuid of this report instance
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportInstance.getUserUuid();
	}

	/**
	* Sets the user uuid of this report instance.
	*
	* @param userUuid the user uuid of this report instance
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_reportInstance.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this report instance.
	*
	* @return the user name of this report instance
	*/
	@Override
	public java.lang.String getUserName() {
		return _reportInstance.getUserName();
	}

	/**
	* Sets the user name of this report instance.
	*
	* @param userName the user name of this report instance
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_reportInstance.setUserName(userName);
	}

	/**
	* Returns the modified date of this report instance.
	*
	* @return the modified date of this report instance
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _reportInstance.getModifiedDate();
	}

	/**
	* Sets the modified date of this report instance.
	*
	* @param modifiedDate the modified date of this report instance
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_reportInstance.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the report key of this report instance.
	*
	* @return the report key of this report instance
	*/
	@Override
	public java.lang.String getReportKey() {
		return _reportInstance.getReportKey();
	}

	/**
	* Sets the report key of this report instance.
	*
	* @param reportKey the report key of this report instance
	*/
	@Override
	public void setReportKey(java.lang.String reportKey) {
		_reportInstance.setReportKey(reportKey);
	}

	/**
	* Returns the class name of this report instance.
	*
	* @return the class name of this report instance
	*/
	@Override
	public java.lang.String getClassName() {
		return _reportInstance.getClassName();
	}

	/**
	* Sets the class name of this report instance.
	*
	* @param className the class name of this report instance
	*/
	@Override
	public void setClassName(java.lang.String className) {
		_reportInstance.setClassName(className);
	}

	/**
	* Returns the class p k of this report instance.
	*
	* @return the class p k of this report instance
	*/
	@Override
	public long getClassPK() {
		return _reportInstance.getClassPK();
	}

	/**
	* Sets the class p k of this report instance.
	*
	* @param classPK the class p k of this report instance
	*/
	@Override
	public void setClassPK(long classPK) {
		_reportInstance.setClassPK(classPK);
	}

	/**
	* Returns the type settings of this report instance.
	*
	* @return the type settings of this report instance
	*/
	@Override
	public java.lang.String getTypeSettings() {
		return _reportInstance.getTypeSettings();
	}

	/**
	* Sets the type settings of this report instance.
	*
	* @param typeSettings the type settings of this report instance
	*/
	@Override
	public void setTypeSettings(java.lang.String typeSettings) {
		_reportInstance.setTypeSettings(typeSettings);
	}

	@Override
	public boolean isNew() {
		return _reportInstance.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_reportInstance.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _reportInstance.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_reportInstance.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _reportInstance.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _reportInstance.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_reportInstance.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _reportInstance.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_reportInstance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_reportInstance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_reportInstance.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ReportInstanceWrapper((ReportInstance)_reportInstance.clone());
	}

	@Override
	public int compareTo(ReportInstance reportInstance) {
		return _reportInstance.compareTo(reportInstance);
	}

	@Override
	public int hashCode() {
		return _reportInstance.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<ReportInstance> toCacheModel() {
		return _reportInstance.toCacheModel();
	}

	@Override
	public ReportInstance toEscapedModel() {
		return new ReportInstanceWrapper(_reportInstance.toEscapedModel());
	}

	@Override
	public ReportInstance toUnescapedModel() {
		return new ReportInstanceWrapper(_reportInstance.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _reportInstance.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _reportInstance.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_reportInstance.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ReportInstanceWrapper)) {
			return false;
		}

		ReportInstanceWrapper reportInstanceWrapper = (ReportInstanceWrapper)obj;

		if (Validator.equals(_reportInstance,
					reportInstanceWrapper._reportInstance)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ReportInstance getWrappedReportInstance() {
		return _reportInstance;
	}

	@Override
	public ReportInstance getWrappedModel() {
		return _reportInstance;
	}

	@Override
	public void resetOriginalValues() {
		_reportInstance.resetOriginalValues();
	}

	private ReportInstance _reportInstance;
}