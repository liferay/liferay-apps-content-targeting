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

package com.liferay.content.targeting.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class InvalidNameException extends PortalException {

	public static final int DUPLICATED = 2;

	public static final int EMPTY = 1;

	public InvalidNameException() {
	}

	public InvalidNameException(int type) {
		_type = type;
	}

	public InvalidNameException(String msg) {
		super(msg);
	}

	public int getType() {
		return _type;
	}

	public boolean isDuplicated() {
		if (_type == DUPLICATED) {
			return true;
		}

		return false;
	}

	public boolean isEmpty() {
		if (_type == EMPTY) {
			return true;
		}

		return false;
	}

	private int _type;

}