package com.ii2d.genthemall;

import groovy.util.ConfigObject;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

public class SourceGenerator extends AbstractGenerator {
	
	protected List<ConfigObject> sourceList;
	
	public boolean addSource(ConfigObject source) {
		if(sourceList == null) {
			sourceList = new ArrayList<ConfigObject>();
		}
		return sourceList.add(source);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	ConfigObject getBindingData() {
		ConfigObject bind = new ConfigObject();
		bind.put(BINDING_DATA_NAME, sourceList);
		return bind;
	}

	@Override
	public String getDestFile() {
		this.destFile = FilenameUtils.getName(this.getTemplateFilePath());
		return super.getDestFile();
	}

	
}
