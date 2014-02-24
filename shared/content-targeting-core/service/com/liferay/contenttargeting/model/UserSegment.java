/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the UserSegment service. Represents a row in the &quot;CT_UserSegment&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see UserSegmentModel
 * @see com.liferay.contenttargeting.model.impl.UserSegmentImpl
 * @see com.liferay.contenttargeting.model.impl.UserSegmentModelImpl
 * @generated
 */
public interface UserSegment extends UserSegmentModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.contenttargeting.model.impl.UserSegmentImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.lang.String getNameWithGroupName(java.util.Locale locale,
		long groupId);

	public java.util.List<com.liferay.contenttargeting.model.RuleInstance> getRuleInstances()
		throws com.liferay.portal.kernel.exception.SystemException;

	public boolean isRuleEnabled(
		com.liferay.contenttargeting.api.model.Rule rule)
		throws java.lang.Exception;
}