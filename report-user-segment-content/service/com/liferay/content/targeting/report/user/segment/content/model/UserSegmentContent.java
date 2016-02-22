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

package com.liferay.content.targeting.report.user.segment.content.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the UserSegmentContent service. Represents a row in the &quot;CT_USCR_UserSegmentContent&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see UserSegmentContentModel
 * @see com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentImpl
 * @see com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentImpl")
@ProviderType
public interface UserSegmentContent extends UserSegmentContentModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UserSegmentContent, Long> USER_SEGMENT_CONTENT_ID_ACCESSOR =
		new Accessor<UserSegmentContent, Long>() {
			@Override
			public Long get(UserSegmentContent userSegmentContent) {
				return userSegmentContent.getUserSegmentContentId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UserSegmentContent> getTypeClass() {
				return UserSegmentContent.class;
			}
		};

	public java.lang.String getTitle(java.util.Locale locale);

	public java.lang.String getType(java.util.Locale locale);
}