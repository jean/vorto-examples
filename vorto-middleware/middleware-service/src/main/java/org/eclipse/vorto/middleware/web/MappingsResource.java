/**
 * Copyright (c) 2018 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.vorto.middleware.web;

import java.util.Collection;
import java.util.stream.Collectors;

import org.eclipse.vorto.middleware.mappings.IMappingConfigDao;
import org.eclipse.vorto.middleware.web.model.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/mappings")
public class MappingsResource {

	@Autowired
	private IMappingConfigDao mappingConfigDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Mapping> getMappings() {
		return mappingConfigDao.list().stream().map(config -> new Mapping(true,config.getInfoModel().getId(),config.getInfoModel().getDescription())).collect(Collectors.toList());
	}
	
	/**
	 * FIXME: needs access to Vorto Repository to get mapping spec
	 * @param modelId
	 */
	@RequestMapping(value = "/{modelId}/install", method = RequestMethod.PUT)
	public void installMapping(@PathVariable String modelId) {
		throw new UnsupportedOperationException();
	}
}
