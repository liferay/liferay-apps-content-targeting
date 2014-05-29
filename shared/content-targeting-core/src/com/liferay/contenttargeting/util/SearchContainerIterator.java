package com.liferay.contenttargeting.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Collections;
import java.util.List;

/**
 * @author Julio Camarero
 */
public class SearchContainerIterator<R> {

	public List<R> getResults(int start, int end)
		throws PortalException, SystemException {

		return Collections.emptyList();
	}

	public int getTotal() throws PortalException, SystemException {
		return 0;
	}

}