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

import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.util.Map;

/**
 * The extended model implementation for the TrackingActionInstance service. Represents a row in the &quot;CT_TrackingActionInstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.model.TrackingActionInstance} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class TrackingActionInstanceImpl extends TrackingActionInstanceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a tracking action instance model instance should use the {@link com.liferay.content.targeting.model.TrackingActionInstance} interface instead.
	 */
	public TrackingActionInstanceImpl() {
	}

	@Override
	public String getReferrerClassName() {
		if (getReferrerClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getReferrerClassNameId());
	}

	@Override
	public String getTrackingActionGuid() {
		return _trackingActionGuid;
	}

	@Override
	public Map<String, String> getValues() {
		return _values;
	}

	@Override
	public void setReferrerClassName(String referrerClassName) {
		long referrerClassNameId = 0;

		if (Validator.isNotNull(referrerClassName)) {
			referrerClassNameId = PortalUtil.getClassNameId(referrerClassName);
		}

		setReferrerClassNameId(referrerClassNameId);
	}

	@Override
	public void setTrackingActionGuid(String trackingActionGuid) {
		_trackingActionGuid = trackingActionGuid;
	}

	@Override
	public void setValues(Map<String, String> values) {
		this._values = values;
	}

	private String _trackingActionGuid;
	private Map<String, String> _values;

}