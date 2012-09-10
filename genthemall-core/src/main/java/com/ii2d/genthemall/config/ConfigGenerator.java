package com.ii2d.genthemall.config;

import groovy.lang.Writable;
import groovy.text.SimpleTemplateEngine;
import groovy.text.Template;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ii2d.dbase.util.DResourceUtils;
import com.ii2d.genthemall.exception.GenthemallException;
import com.ii2d.genthemall.source.Source;


public class ConfigGenerator {
	
	public static final Log LOG = LogFactory.getLog(ConfigGenerator.class);
	
	protected List<Source> sourceList;
	protected String target;
	
	public static final String DEFAULT_TARGET = "target/genthemall.conf.groovy";
	public static final String DATA_NAME = "sources";
	
	public ConfigGenerator() {
		this(new ArrayList<Source>());
	}
	
	public ConfigGenerator(List<Source> sourceList) {
		this(sourceList, DEFAULT_TARGET);
	}
	
	public ConfigGenerator(List<Source> sourceList, String target) {
		this.sourceList = sourceList;
		this.target = target;
	}
	
	public boolean addSource(Source source) {
		if(sourceList != null) {
			return sourceList.add(source);
		}
		return false;
	}
	
	public void generate() {
		SimpleTemplateEngine engine = new SimpleTemplateEngine();
		Map<String, Object> bind = new HashMap<String, Object>();
		bind.put(DATA_NAME, sourceList);
		try {
			LOG.info("Loading Config template...");
			Template template = engine.createTemplate(DResourceUtils.getResourceAsReader("com/ii2d/genthemall/config.template"));
			Writable writable = template.make(bind);
			FileWriter f = new FileWriter(new File(this.target));
			LOG.info("Generating config file to: " + this.target);
			writable.writeTo(f);
			f.close();
			LOG.info("Finish generating.");
		} catch (Exception e) {
			throw new GenthemallException(e);
		} 
	}
}
