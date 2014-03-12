/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.service;

import com.liferay.contenttargeting.model.CampaignClp;
import com.liferay.contenttargeting.model.RuleInstanceClp;
import com.liferay.contenttargeting.model.UserSegmentClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"content-targeting-core-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"content-targeting-core-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "content-targeting-core";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CampaignClp.class.getName())) {
			return translateInputCampaign(oldModel);
		}

		if (oldModelClassName.equals(RuleInstanceClp.class.getName())) {
			return translateInputRuleInstance(oldModel);
		}

		if (oldModelClassName.equals(UserSegmentClp.class.getName())) {
			return translateInputUserSegment(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputCampaign(BaseModel<?> oldModel) {
		CampaignClp oldClpModel = (CampaignClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCampaignRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRuleInstance(BaseModel<?> oldModel) {
		RuleInstanceClp oldClpModel = (RuleInstanceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRuleInstanceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUserSegment(BaseModel<?> oldModel) {
		UserSegmentClp oldClpModel = (UserSegmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUserSegmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.liferay.contenttargeting.model.impl.CampaignImpl")) {
			return translateOutputCampaign(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.contenttargeting.model.impl.RuleInstanceImpl")) {
			return translateOutputRuleInstance(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.contenttargeting.model.impl.UserSegmentImpl")) {
			return translateOutputUserSegment(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"com.liferay.contenttargeting.UsedUserSegmentException")) {
			return new com.liferay.contenttargeting.UsedUserSegmentException();
		}

		if (className.equals(
					"com.liferay.contenttargeting.NoSuchCampaignException")) {
			return new com.liferay.contenttargeting.NoSuchCampaignException();
		}

		if (className.equals(
					"com.liferay.contenttargeting.NoSuchRuleInstanceException")) {
			return new com.liferay.contenttargeting.NoSuchRuleInstanceException();
		}

		if (className.equals(
					"com.liferay.contenttargeting.NoSuchUserSegmentException")) {
			return new com.liferay.contenttargeting.NoSuchUserSegmentException();
		}

		return throwable;
	}

	public static Object translateOutputCampaign(BaseModel<?> oldModel) {
		CampaignClp newModel = new CampaignClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCampaignRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRuleInstance(BaseModel<?> oldModel) {
		RuleInstanceClp newModel = new RuleInstanceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRuleInstanceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUserSegment(BaseModel<?> oldModel) {
		UserSegmentClp newModel = new UserSegmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUserSegmentRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}