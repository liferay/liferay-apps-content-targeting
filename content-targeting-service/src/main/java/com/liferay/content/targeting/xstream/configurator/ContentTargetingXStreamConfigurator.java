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

package com.liferay.content.targeting.xstream.configurator;

import com.liferay.content.targeting.model.impl.CampaignImpl;
import com.liferay.content.targeting.model.impl.ChannelInstanceImpl;
import com.liferay.content.targeting.model.impl.RuleInstanceImpl;
import com.liferay.content.targeting.model.impl.TacticImpl;
import com.liferay.content.targeting.model.impl.TrackingActionInstanceImpl;
import com.liferay.content.targeting.model.impl.UserSegmentImpl;
import com.liferay.exportimport.kernel.xstream.XStreamAlias;
import com.liferay.exportimport.kernel.xstream.XStreamConverter;
import com.liferay.exportimport.kernel.xstream.XStreamType;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portlet.asset.model.impl.AssetEntryImpl;
import com.liferay.xstream.configurator.XStreamConfigurator;

import java.util.List;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Pavel Savinov
 */
@Component(immediate = true, service = XStreamConfigurator.class)
public class ContentTargetingXStreamConfigurator
	implements XStreamConfigurator {

	@Override
	public List<XStreamType> getAllowedXStreamTypes() {
		return ListUtil.toList(this._xStreamTypes);
	}

	@Override
	public List<XStreamAlias> getXStreamAliases() {
		return ListUtil.toList(_xStreamAliases);
	}

	@Override
	public List<XStreamConverter> getXStreamConverters() {
		return null;
	}

	@Activate
	protected void activate() {
		_xStreamAliases = new XStreamAlias[] {
			new XStreamAlias(AssetEntryImpl.class, "AssetEntry"),
			new XStreamAlias(CampaignImpl.class, "Campaign"),
			new XStreamAlias(ChannelInstanceImpl.class, "ChannelInstance"),
			new XStreamAlias(RuleInstanceImpl.class, "RuleInstance"),
			new XStreamAlias(TacticImpl.class, "Tactic"),
			new XStreamAlias(
				TrackingActionInstanceImpl.class, "TrackingActionInstance"),
			new XStreamAlias(UserSegmentImpl.class, "UserSegment")
		};

		_xStreamTypes = new XStreamType[] {
			new XStreamType(AssetEntryImpl.class)
		};
	}

	private XStreamAlias[] _xStreamAliases;
	private XStreamType[] _xStreamTypes;

}