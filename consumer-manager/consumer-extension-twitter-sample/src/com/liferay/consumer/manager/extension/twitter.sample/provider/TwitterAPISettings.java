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

package com.liferay.consumer.manager.extension.twitter.sample.provider;

/**
 * @author Eduardo Garcia
 */
public class TwitterAPISettings {

	public String getAccessKey() {
		return _accessKey;
	}

	public String getAccessSecret() {
		return _accessSecret;
	}

	public String getConsumerKey() {
		return _consumerKey;
	}

	public String getConsumerSecret() {
		return _consumerSecret;
	}

	public void setAccessKey(String accessKey) {
		_accessKey = accessKey;
	}

	public void setAccessSecret(String accessSecret) {
		_accessSecret = accessSecret;
	}

	public void setConsumerKey(String consumerKey) {
		_consumerKey = consumerKey;
	}

	public void setConsumerSecret(String ConsumerSecret) {
		_consumerSecret = ConsumerSecret;
	}

	private String _accessKey;
	private String _accessSecret;
	private String _consumerKey;
	private String _consumerSecret;

}