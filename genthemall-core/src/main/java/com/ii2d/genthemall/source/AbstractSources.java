package com.ii2d.genthemall.source;

import groovy.util.ConfigObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AbstractSources extends ConfigObject implements Sources {
	
	private static final long serialVersionUID = 1L;
	private static final Log LOG = LogFactory.getLog(AbstractSources.class);
	public static final String ONE_RESOURCE = "ONE-RESOURCE";
	private boolean isInit = false;
	
	protected boolean isInit() {
		return isInit;
	}

	public abstract void initResources();
	
	private void _init() {
		if(!isInit()) {
			initResources();
			isInit = true;
		}
	}
	
	@Override
	public ConfigObject getResource(String name) {
		_init();
		if(ONE_RESOURCE.equals(name))
			return this;
		Object tmp = this.get(name);
		if(tmp instanceof ConfigObject)
			return (ConfigObject)tmp;
		LOG.error("No such config object can be found with name: " + name);
		return null;
	}

	@Override
	public Collection<ConfigObject> getAllResources() {
		_init();
		List<ConfigObject> results = new ArrayList<ConfigObject>();
		for(Object tmp: this.values()) {
			if(tmp instanceof ConfigObject) {
				results.add((ConfigObject)tmp);
			}
		}
		return results;
	}

	@Override
	public List<String> getResourceNames() {
		_init();
		List<String> names = new ArrayList<String>();
		for(Object tmp: this.keySet()) {
			if(tmp instanceof String)
				names.add((String)tmp);
		}
		if(names.isEmpty())
			names.add(ONE_RESOURCE);
		return names;
	}

}
