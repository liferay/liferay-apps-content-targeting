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
 * The extended model interface for the ChannelInstance service. Represents a row in the &quot;CT_ChannelInstance&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ChannelInstanceModel
 * @see com.liferay.content.targeting.model.impl.ChannelInstanceImpl
 * @see com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.content.targeting.model.impl.ChannelInstanceImpl")
@ProviderType
public interface ChannelInstance extends ChannelInstanceModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.content.targeting.model.impl.ChannelInstanceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ChannelInstance, Long> CHANNEL_INSTANCE_ID_ACCESSOR =
		new Accessor<ChannelInstance, Long>() {
			@Override
			public Long get(ChannelInstance channelInstance) {
				return channelInstance.getChannelInstanceId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ChannelInstance> getTypeClass() {
				return ChannelInstance.class;
			}
		};

	public java.lang.String getChannelGuid();

	public java.util.Map<java.lang.String, java.lang.String> getValues();

	public void setChannelGuid(java.lang.String channelGuid);

	public void setValues(
		java.util.Map<java.lang.String, java.lang.String> values);
}