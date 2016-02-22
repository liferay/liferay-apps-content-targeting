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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the UserSegment service. Represents a row in the &quot;CT_UserSegment&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see UserSegmentModel
 * @see com.liferay.content.targeting.model.impl.UserSegmentImpl
 * @see com.liferay.content.targeting.model.impl.UserSegmentModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.content.targeting.model.impl.UserSegmentImpl")
@ProviderType
public interface UserSegment extends UserSegmentModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.content.targeting.model.impl.UserSegmentImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UserSegment, Long> USER_SEGMENT_ID_ACCESSOR = new Accessor<UserSegment, Long>() {
			@Override
			public Long get(UserSegment userSegment) {
				return userSegment.getUserSegmentId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UserSegment> getTypeClass() {
				return UserSegment.class;
			}
		};

	public long getAssetCategoryId(long groupId);

	public java.lang.String getNameWithGroupName(java.util.Locale locale,
		long groupId);

	public java.util.List<com.liferay.content.targeting.model.RuleInstance> getRuleInstances();

	public boolean isRuleEnabled(
		com.liferay.content.targeting.api.model.Rule rule)
		throws java.lang.Exception;
}