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

package com.liferay.content.targeting.internal;

import com.liferay.content.targeting.api.model.TrackingAction;
import com.liferay.content.targeting.api.model.TrackingActionsRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

/**
 * @author Eduardo Garcia
 */
@Component
public class DefaultTrackingActionsRegistryImpl
	implements TrackingActionsRegistry {

	@Override
	public TrackingAction getTrackingAction(String trackingActionKey) {
		return _trackingActions.get(trackingActionKey);
	}

	@Override
	public Map<String, TrackingAction> getTrackingActions() {
		return _trackingActions;
	}

	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC, unbind = "unregisterTrackingAction"
	)
	public void registerTrackingAction(TrackingAction trackingAction) {
		_trackingActions.put(
			trackingAction.getTrackingActionKey(), trackingAction);
	}

	public void unregisterTrackingAction(TrackingAction trackingAction) {
		_trackingActions.remove(trackingAction);
	}

	private final Map<String, TrackingAction> _trackingActions =
		new ConcurrentHashMap<>();

}