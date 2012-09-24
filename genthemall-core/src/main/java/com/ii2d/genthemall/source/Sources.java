package com.ii2d.genthemall.source;

import groovy.util.ConfigObject;

import java.util.Collection;
import java.util.List;

public interface Sources {

	public static final String ONE_RESOURCE = "ONE-RESOURCE";
	public static final String TYPE_DATABASE = "db";
	public static final String TYPE_CONFIG = "config";
	public static final String TYPE_BEAN = "bean";
	
	ConfigObject getSource(String name);
	
	Collection<ConfigObject> getAllResources();
	
	List<String> getResourceNames();
}
