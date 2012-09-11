package com.ii2d.genthemall;

import groovy.util.ConfigObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SourceGenerator extends AbstractGenerator {
	
	protected List<ConfigObject> sourceList;
	
	public SourceGenerator() {
		this(new ArrayList<ConfigObject>());
	}

	public SourceGenerator(List<ConfigObject> sourceList) {
		this.sourceList = sourceList;
	}

	public boolean addSource(ConfigObject source) {
		if(sourceList == null) {
			sourceList = new ArrayList<ConfigObject>();
		}
		return sourceList.add(source);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	Map<String, Object> getDataBindingMap() {
		ConfigObject bind = new ConfigObject();
		bind.put(BINDING_DATA_NAME, sourceList);
		return bind;
	}

}
