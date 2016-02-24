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
 * The extended model interface for the AnonymousUserUserSegment service. Represents a row in the &quot;CT_AnonymousUserUserSegment&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AnonymousUserUserSegmentModel
 * @see com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentImpl
 * @see com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentImpl")
@ProviderType
public interface AnonymousUserUserSegment extends AnonymousUserUserSegmentModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AnonymousUserUserSegment, Long> ANONYMOUS_USER_USER_SEGMENT_ID_ACCESSOR =
		new Accessor<AnonymousUserUserSegment, Long>() {
			@Override
			public Long get(AnonymousUserUserSegment anonymousUserUserSegment) {
				return anonymousUserUserSegment.getAnonymousUserUserSegmentId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AnonymousUserUserSegment> getTypeClass() {
				return AnonymousUserUserSegment.class;
			}
		};
}