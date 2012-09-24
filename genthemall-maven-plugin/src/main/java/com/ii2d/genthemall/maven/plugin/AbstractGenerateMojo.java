package com.ii2d.genthemall.maven.plugin;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.maven.plugin.AbstractMojo;

import com.ii2d.dbase.util.Assert;
import com.ii2d.genthemall.source.BeanSources;
import com.ii2d.genthemall.source.ConfigSources;
import com.ii2d.genthemall.source.DatabaseSources;
import com.ii2d.genthemall.source.Sources;

public abstract class AbstractGenerateMojo extends AbstractMojo {
	/**
	 * @parameter default-value="classpath:com/ii2d/genthemall/template/"
	 */
	private String scanPackage;
	
	/**
	 * @parameter
	 */
	private DatabaseSources databaseSources;
	
	/**
	 * @parameter
	 */
	private BasicDataSource dataSource;
	
	/**
	 * @parameter
	 */
	private ConfigSources configSources;
	
	/**
	 * @parameter
	 */
	private BeanSources beanSources;
	
	private Map<String, Sources> sourcesMap = new HashMap<String, Sources>();
	
	protected void _initSourcesMap() {
		if(databaseSources != null) {
			Assert.notNull(dataSource, "如果设置了databaseSources，dataSource对象必须设置参数.");
			Assert.hasLength((String)databaseSources.get("tables"), "如果设置了databaseSources，databaseSources.tables是必须设置参数.");
			
			databaseSources.setDataSource(dataSource);
			sourcesMap.put(Sources.TYPE_DATABASE, databaseSources);
		}
		if(configSources != null) {
			sourcesMap.put(Sources.TYPE_CONFIG, configSources);
		}
		if(beanSources != null) {
			sourcesMap.put(Sources.TYPE_BEAN, beanSources);
		}
	}

	public String getScanPackage() {
		return scanPackage;
	}

	public void setScanPackage(String scanPackage) {
		this.scanPackage = scanPackage;
	}

	public Map<String, Sources> getSourcesMap() {
		return sourcesMap;
	}
	
}
