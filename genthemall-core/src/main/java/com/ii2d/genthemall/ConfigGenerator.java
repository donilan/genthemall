package com.ii2d.genthemall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ii2d.genthemall.source.Source;


public class ConfigGenerator extends AbstractDatabaseGenerator {

	public static final Log LOG = LogFactory.getLog(ConfigGenerator.class);
	
	protected List<Source> sourceList;
	
	public static final String DEFAULT_TARGET = "genthemall.conf.groovy";
	public static final String DATA_NAME = "data";
	
	public ConfigGenerator() {
		this(new ArrayList<Source>());
	}
	
	public ConfigGenerator(List<Source> sourceList) {
		this(sourceList, DEFAULT_TARGET);
	}
	
	public ConfigGenerator(List<Source> sourceList, String target) {
		this.sourceList = sourceList;
		this.setTarget(target);
	}
	
	public boolean addSource(Source source) {
		if(sourceList != null) {
			return sourceList.add(source);
		}
		return false;
	}

	@Override
	Map<String, Object> getDataBindingMap() {
		Map<String, Object> bind = new HashMap<String, Object>();
		bind.put(DATA_NAME, sourceList);
		return bind;
	}
}
