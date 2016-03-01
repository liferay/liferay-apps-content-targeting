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

package com.liferay.content.targeting.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Pavel Savinov
 */
@ExtendedObjectClassDefinition(category = "content-targeting")
@Meta.OCD(
	id = "com.liferay.content.targeting.configuration.AnonymousUserUserSegmentServiceConfiguration",
	localization = "content/Language",
	name = "%com.liferay.content.targeting.configuration.name"
)
public interface AnonymousUserUserSegmentServiceConfiguration {

	@Meta.AD(deflt = "1", required = false)
	public int anonymousUserUserSegmentCheckInterval();

	@Meta.AD(deflt = "3", required = false)
	public int anonymousUserUserSegmentMaxAge();

}