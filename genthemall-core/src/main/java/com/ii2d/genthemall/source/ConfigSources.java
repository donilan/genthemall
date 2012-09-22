package com.ii2d.genthemall.source;

import java.io.IOException;

import groovy.util.ConfigObject;
import groovy.util.ConfigSlurper;

import com.ii2d.dbase.util.Assert;
import com.ii2d.dbase.util.DResourceUtils;
import com.ii2d.genthemall.exception.GenthemallException;


public class ConfigSources extends AbstractSources {
	
	private static final long serialVersionUID = 1L;
	
	private String configPath;

	@Override
	public void initResources() {
		Assert.hasLength(configPath);
		try {
			ConfigObject configs = new ConfigSlurper().parse(DResourceUtils
					.getResourceURL(configPath));
			this.merge(configs);
		} catch (IOException e) {
			throw new GenthemallException(e);
		}
	}
	public void setConfigFilePath(String configPath) {
		this.configPath = configPath;
	}

}
