package com.ii2d.genthemall.config;

import groovy.util.ConfigObject;
import groovy.util.ConfigSlurper;

import java.io.File;
import java.net.MalformedURLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ii2d.genthemall.exception.GenthemallException;

public class ConfigReader {
	
	private static final Log LOG = LogFactory.getLog(ConfigReader.class);

	public static final String DEFAULT_CONFIG_PATH = "genthemall.conf.groovy";
	
	private String path;
	
	public ConfigReader() {
		this(DEFAULT_CONFIG_PATH);
	}
	
	public ConfigReader(String path) {
		this.path = path;
	}
	
	public ConfigObject read() {
		File configFile = new File(path);
		if(configFile.exists())
			try {
				return new ConfigSlurper().parse(configFile.toURI().toURL());
			} catch (MalformedURLException e) {
				throw new GenthemallException(e);
			}
		String err = "Config file: " + path + " not exists.";
		LOG.error(err);
		throw new GenthemallException(err);
	}
}
