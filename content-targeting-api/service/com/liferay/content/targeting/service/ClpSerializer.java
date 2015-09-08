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

package com.liferay.content.targeting.service;

import com.liferay.content.targeting.model.AnonymousUserUserSegmentClp;
import com.liferay.content.targeting.model.CampaignClp;
import com.liferay.content.targeting.model.ChannelInstanceClp;
import com.liferay.content.targeting.model.ReportInstanceClp;
import com.liferay.content.targeting.model.RuleInstanceClp;
import com.liferay.content.targeting.model.TacticClp;
import com.liferay.content.targeting.model.TrackingActionInstanceClp;
import com.liferay.content.targeting.model.UserSegmentClp;

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
						"com.liferay.content.targeting.api-deployment-context");

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
							"com.liferay.content.targeting.api-deployment-context");

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
				_servletContextName = "com.liferay.content.targeting.api";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					AnonymousUserUserSegmentClp.class.getName())) {
			return translateInputAnonymousUserUserSegment(oldModel);
		}

		if (oldModelClassName.equals(CampaignClp.class.getName())) {
			return translateInputCampaign(oldModel);
		}

		if (oldModelClassName.equals(ChannelInstanceClp.class.getName())) {
			return translateInputChannelInstance(oldModel);
		}

		if (oldModelClassName.equals(ReportInstanceClp.class.getName())) {
			return translateInputReportInstance(oldModel);
		}

		if (oldModelClassName.equals(RuleInstanceClp.class.getName())) {
			return translateInputRuleInstance(oldModel);
		}

		if (oldModelClassName.equals(TacticClp.class.getName())) {
			return translateInputTactic(oldModel);
		}

		if (oldModelClassName.equals(TrackingActionInstanceClp.class.getName())) {
			return translateInputTrackingActionInstance(oldModel);
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

	public static Object translateInputAnonymousUserUserSegment(
		BaseModel<?> oldModel) {
		AnonymousUserUserSegmentClp oldClpModel = (AnonymousUserUserSegmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAnonymousUserUserSegmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCampaign(BaseModel<?> oldModel) {
		CampaignClp oldClpModel = (CampaignClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCampaignRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputChannelInstance(BaseModel<?> oldModel) {
		ChannelInstanceClp oldClpModel = (ChannelInstanceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getChannelInstanceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputReportInstance(BaseModel<?> oldModel) {
		ReportInstanceClp oldClpModel = (ReportInstanceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getReportInstanceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRuleInstance(BaseModel<?> oldModel) {
		RuleInstanceClp oldClpModel = (RuleInstanceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRuleInstanceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTactic(BaseModel<?> oldModel) {
		TacticClp oldClpModel = (TacticClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTacticRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTrackingActionInstance(
		BaseModel<?> oldModel) {
		TrackingActionInstanceClp oldClpModel = (TrackingActionInstanceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTrackingActionInstanceRemoteModel();

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
					"com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentImpl")) {
			return translateOutputAnonymousUserUserSegment(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.content.targeting.model.impl.CampaignImpl")) {
			return translateOutputCampaign(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.content.targeting.model.impl.ChannelInstanceImpl")) {
			return translateOutputChannelInstance(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.content.targeting.model.impl.ReportInstanceImpl")) {
			return translateOutputReportInstance(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.content.targeting.model.impl.RuleInstanceImpl")) {
			return translateOutputRuleInstance(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.content.targeting.model.impl.TacticImpl")) {
			return translateOutputTactic(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.content.targeting.model.impl.TrackingActionInstanceImpl")) {
			return translateOutputTrackingActionInstance(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.content.targeting.model.impl.UserSegmentImpl")) {
			return translateOutputUserSegment(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
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
					"com.liferay.content.targeting.InvalidChannelException")) {
			return new com.liferay.content.targeting.InvalidChannelException();
		}

		if (className.equals(
					"com.liferay.content.targeting.InvalidChannelsException")) {
			return new com.liferay.content.targeting.InvalidChannelsException();
		}

		if (className.equals(
					"com.liferay.content.targeting.InvalidDateRangeException")) {
			return new com.liferay.content.targeting.InvalidDateRangeException();
		}

		if (className.equals(
					"com.liferay.content.targeting.InvalidNameException")) {
			return new com.liferay.content.targeting.InvalidNameException();
		}

		if (className.equals(
					"com.liferay.content.targeting.InvalidRuleException")) {
			return new com.liferay.content.targeting.InvalidRuleException();
		}

		if (className.equals(
					"com.liferay.content.targeting.InvalidRulesException")) {
			return new com.liferay.content.targeting.InvalidRulesException();
		}

		if (className.equals(
					"com.liferay.content.targeting.InvalidTrackingActionException")) {
			return new com.liferay.content.targeting.InvalidTrackingActionException();
		}

		if (className.equals(
					"com.liferay.content.targeting.InvalidTrackingActionsException")) {
			return new com.liferay.content.targeting.InvalidTrackingActionsException();
		}

		if (className.equals(
					"com.liferay.content.targeting.UsedUserSegmentException")) {
			return new com.liferay.content.targeting.UsedUserSegmentException();
		}

		if (className.equals(
					"com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException")) {
			return new com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException();
		}

		if (className.equals(
					"com.liferay.content.targeting.NoSuchCampaignException")) {
			return new com.liferay.content.targeting.NoSuchCampaignException();
		}

		if (className.equals(
					"com.liferay.content.targeting.NoSuchChannelInstanceException")) {
			return new com.liferay.content.targeting.NoSuchChannelInstanceException();
		}

		if (className.equals(
					"com.liferay.content.targeting.NoSuchReportInstanceException")) {
			return new com.liferay.content.targeting.NoSuchReportInstanceException();
		}

		if (className.equals(
					"com.liferay.content.targeting.NoSuchRuleInstanceException")) {
			return new com.liferay.content.targeting.NoSuchRuleInstanceException();
		}

		if (className.equals(
					"com.liferay.content.targeting.NoSuchTacticException")) {
			return new com.liferay.content.targeting.NoSuchTacticException();
		}

		if (className.equals(
					"com.liferay.content.targeting.NoSuchTrackingActionInstanceException")) {
			return new com.liferay.content.targeting.NoSuchTrackingActionInstanceException();
		}

		if (className.equals(
					"com.liferay.content.targeting.NoSuchUserSegmentException")) {
			return new com.liferay.content.targeting.NoSuchUserSegmentException();
		}

		return throwable;
	}

	public static Object translateOutputAnonymousUserUserSegment(
		BaseModel<?> oldModel) {
		AnonymousUserUserSegmentClp newModel = new AnonymousUserUserSegmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAnonymousUserUserSegmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCampaign(BaseModel<?> oldModel) {
		CampaignClp newModel = new CampaignClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCampaignRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputChannelInstance(BaseModel<?> oldModel) {
		ChannelInstanceClp newModel = new ChannelInstanceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setChannelInstanceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputReportInstance(BaseModel<?> oldModel) {
		ReportInstanceClp newModel = new ReportInstanceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setReportInstanceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRuleInstance(BaseModel<?> oldModel) {
		RuleInstanceClp newModel = new RuleInstanceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRuleInstanceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTactic(BaseModel<?> oldModel) {
		TacticClp newModel = new TacticClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTacticRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTrackingActionInstance(
		BaseModel<?> oldModel) {
		TrackingActionInstanceClp newModel = new TrackingActionInstanceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTrackingActionInstanceRemoteModel(oldModel);

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