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
 * The extended model interface for the RuleInstance service. Represents a row in the &quot;CT_RuleInstance&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see RuleInstanceModel
 * @see com.liferay.content.targeting.model.impl.RuleInstanceImpl
 * @see com.liferay.content.targeting.model.impl.RuleInstanceModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.content.targeting.model.impl.RuleInstanceImpl")
@ProviderType
public interface RuleInstance extends RuleInstanceModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.content.targeting.model.impl.RuleInstanceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RuleInstance, Long> RULE_INSTANCE_ID_ACCESSOR = new Accessor<RuleInstance, Long>() {
			@Override
			public Long get(RuleInstance ruleInstance) {
				return ruleInstance.getRuleInstanceId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RuleInstance> getTypeClass() {
				return RuleInstance.class;
			}
		};

	public java.lang.String getRuleGuid();

	public java.lang.String getUserSegmentName(java.util.Locale locale);

	public java.util.Map<java.lang.String, java.lang.String> getValues();

	public void setRuleGuid(java.lang.String ruleGuid);

	public void setValues(
		java.util.Map<java.lang.String, java.lang.String> values);
}