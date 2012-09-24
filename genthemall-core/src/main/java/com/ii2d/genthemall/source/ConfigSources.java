package com.ii2d.genthemall.source;

import java.io.IOException;

import groovy.util.ConfigObject;
import groovy.util.ConfigSlurper;

import com.ii2d.dbase.util.Assert;
import com.ii2d.dbase.util.DResourceUtils;
import com.ii2d.genthemall.exception.GenthemallException;


public class ConfigSources extends AbstractSources {
	
	private static final long serialVersionUID = 1L;
	

	@Override
	public void initResources() {
		String configFilePath = (String)this.get("configFilePath");
		Assert.hasLength(configFilePath, "Config file path cann't be null or empty.");
		try {
			ConfigObject configs = new ConfigSlurper().parse(DResourceUtils
					.getResourceURL(configFilePath));
			this.merge(configs);
		} catch (IOException e) {
			throw new GenthemallException(e);
		}
	}

}
