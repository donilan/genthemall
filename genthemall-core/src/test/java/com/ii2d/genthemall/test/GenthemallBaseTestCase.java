package com.ii2d.genthemall.test;

import junit.framework.TestCase;

import org.apache.commons.dbcp.BasicDataSource;

import com.ii2d.genthemall.DefaultGenerator;
import com.ii2d.genthemall.source.ConfigSources;
import com.ii2d.genthemall.source.DatabaseSources;
import com.ii2d.genthemall.template.TemplateInfoFinder;

public abstract class GenthemallBaseTestCase extends TestCase {
	
	protected BasicDataSource ds;
	protected String tables = "user,shop,product";
	protected String configPath = "target/genthemall/mysql.conf";
	protected DatabaseSources databaseSources;
	protected ConfigSources configSources;
	protected TemplateInfoFinder templateInfoFinder;
	protected DefaultGenerator generator;

	@SuppressWarnings("unchecked")
	@Override
	protected void setUp() throws Exception {
		ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/hnwnew?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("sa");
		
		databaseSources = new DatabaseSources();
		databaseSources.setDataSource(ds);
		databaseSources.put("tables", tables);
		
		configSources = new ConfigSources();
		configSources.put("configFilePath", "target/genthemall/mysql.conf");
		
		templateInfoFinder = new TemplateInfoFinder();
		templateInfoFinder.setScanPath("classpath:com/ii2d/genthemall/template/commons");
		
		generator = new DefaultGenerator();
		super.setUp();
	}

	
}
