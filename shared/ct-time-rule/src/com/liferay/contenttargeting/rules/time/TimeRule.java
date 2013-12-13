/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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
package com.liferay.contenttargeting.rules.time;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Deactivate;
import com.liferay.contenttargeting.api.model.Rule;

/**
 * @author Julio Camarero
 */
@Component(immediate = true)
public class TimeRule implements Rule {

	@Override
	public String getName() {
		return "time";
	}

	@Activate
	public void activate () {
	}

	@Deactivate
	public void deActivate () {
	}

}
