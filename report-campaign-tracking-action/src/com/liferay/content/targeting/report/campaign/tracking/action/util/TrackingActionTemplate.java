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

package com.liferay.content.targeting.report.campaign.tracking.action.util;

import com.liferay.content.targeting.api.model.TrackingAction;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Eduardo Garcia
 */
public class TrackingActionTemplate {

	public String getInstanceId() {
		return _instanceId;
	}

	public String getTemplate() {
		return _template;
	}

	public String getTemplateKey() {
		String templateKey = _trackingAction.getTrackingActionKey();

		if (Validator.isNotNull(_instanceId)) {
			templateKey = templateKey.concat(StringPool.UNDERLINE).concat(
				String.valueOf(_instanceId));
		}

		return templateKey;
	}

	public TrackingAction getTrackingAction() {
		return _trackingAction;
	}

	public void setInstanceId(String instanceId) {
		_instanceId = instanceId;
	}

	public void setTemplate(String template) {
		_template = template;
	}

	public void setTrackingAction(TrackingAction trackingAction) {
		_trackingAction = trackingAction;
	}

	private String _instanceId;
	private String _template;
	private TrackingAction _trackingAction;

}