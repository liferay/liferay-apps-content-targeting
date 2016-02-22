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

package com.liferay.content.targeting.rule.time;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.portal.json.JSONObjectImpl;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author Julio Camarero
 */
@PrepareForTest({CalendarFactoryUtil.class, JSONFactoryUtil.class})
@RunWith(PowerMockRunner.class)
public class TimeRuleTest extends PowerMockito {

	@Before
	public void setUp() throws Exception {
		_timeRule = new TimeRule();

		mockStatic(CalendarFactoryUtil.class);
		mockStatic(JSONFactoryUtil.class);

		when(
			JSONFactoryUtil.createJSONObject(Mockito.anyString())
		).thenAnswer(
			new Answer<JSONObject>() {

				@Override
				public JSONObject answer(InvocationOnMock invocation)
					throws Throwable {

					Object[] args = invocation.getArguments();

					return new JSONObjectImpl((String)args[0]);
				}

			}
		);

		when(
			JSONFactoryUtil.createJSONObject()
		).thenReturn(
			new JSONObjectImpl()
		);

		when(
			CalendarFactoryUtil.getCalendar(
				Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(),
				Mockito.anyInt(), Mockito.anyInt())
		).thenAnswer(
			new Answer<Calendar>() {

				@Override
				public Calendar answer(InvocationOnMock invocation)
					throws Throwable {

					Object[] args = invocation.getArguments();

					return new GregorianCalendar(
						(Integer)args[0], (Integer)args[1], (Integer)args[2],
						(Integer)args[3], (Integer)args[4]);
				}

			}
		);

		when(
			CalendarFactoryUtil.getCalendar()
		).thenReturn(
			new GregorianCalendar()
		);

		_5minutesAgo = new GregorianCalendar();
		_5minutesAgo.set(
			Calendar.MINUTE, (_5minutesAgo.get(Calendar.MINUTE) - 5));

		_in5minutes = new GregorianCalendar();
		_in5minutes.set(
			Calendar.MINUTE, (_in5minutes.get(Calendar.MINUTE) + 5));
	}

	@Test
	public void testInTime() throws Exception {
		when(
			_anonymousUser.getUser()
		).thenReturn(
			_user
		);

		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			_generateJSON(_5minutesAgo, _in5minutes)
		);

		Assert.assertTrue(
			_timeRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testNotInTime() throws Exception {
		when(
			_anonymousUser.getUser()
		).thenReturn(
			_user
		);

		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			_generateJSON(_in5minutes, _5minutesAgo)
		);

		Assert.assertFalse(
			_timeRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testUnknown() throws Exception {
		when(
			_anonymousUser.getUser()
		).thenReturn(
			null
		);

		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			_generateJSON(_5minutesAgo, _in5minutes)
		);

		Assert.assertTrue(
			_timeRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	private String _generateJSON(Calendar startDate, Calendar endDate) {
		JSONObject jsonObj = new JSONObjectImpl();

		jsonObj.put("endTimeHour", endDate.get(Calendar.HOUR));
		jsonObj.put("endTimeMinute", endDate.get(Calendar.MINUTE));
		jsonObj.put("endTimeAmPm", endDate.get(Calendar.AM_PM));
		jsonObj.put("startTimeHour", startDate.get(Calendar.HOUR));
		jsonObj.put("startTimeMinute", startDate.get(Calendar.MINUTE));
		jsonObj.put("startTimeAmPm", startDate.get(Calendar.AM_PM));

		return jsonObj.toString();
	}

	private Calendar _5minutesAgo;

	@Mock
	private AnonymousUser _anonymousUser;

	private Calendar _in5minutes;

	@Mock
	private RuleInstance _ruleInstance;

	private TimeRule _timeRule;

	@Mock
	private User _user;

}