package com.ii2d.genthemall.source;

import groovy.util.ConfigObject;

import java.util.Collection;
import java.util.List;

public interface Sources {

	ConfigObject getResource(String name);
	
	Collection<ConfigObject> getAllResources();
	
	List<String> getResourceNames();
}
