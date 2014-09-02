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

package com.liferay.content.targeting.rule.device.test.util;

import com.liferay.portal.kernel.mobile.device.AbstractDevice;
import com.liferay.portal.kernel.mobile.device.Capability;
import com.liferay.portal.kernel.mobile.device.Dimensions;

import java.util.Map;

/**
 * @author Julio Camarero
 */
public class MockiPhoneDevice extends AbstractDevice {

	@Override
	public String getBrand() {
		return null;
	}

	@Override
	public String getBrowser() {
		return null;
	}

	@Override
	public String getBrowserVersion() {
		return null;
	}

	@Override
	public Map<String, Capability> getCapabilities() {
		return null;
	}

	@Override
	public String getCapability(String name) {
		return null;
	}

	@Override
	public String getModel() {
		return null;
	}

	@Override
	public String getOS() {
		return "iPhone OS";
	}

	@Override
	public String getOSVersion() {
		return null;
	}

	@Override
	public String getPointingMethod() {
		return null;
	}

	@Override
	public Dimensions getScreenPhysicalSize() {
		return Dimensions.UNKNOWN;
	}

	@Override
	public Dimensions getScreenResolution() {
		return Dimensions.UNKNOWN;
	}

	@Override
	public boolean hasQwertyKeyboard() {
		return false;
	}

	@Override
	public boolean isTablet() {
		return false;
	}

}