package com.ii2d.genthemall;

import groovy.util.ConfigObject;
import junit.framework.TestCase;

import org.apache.commons.dbcp.BasicDataSource;

import com.ii2d.genthemall.source.DatabaseSource;

public class ConfigGeneratorTests extends TestCase {

	public void testSomething() {
		// ConfigGenerator g = new ConfigGenerator();
		// g.generate();
	}

	public void testGenerate() {
		Source2ConfigGenerator g = new Source2ConfigGenerator();
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/hnwnew");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("sa");
		
		ConfigObject s1 = new DatabaseSource(ds, "user");
		ConfigObject s2 = new DatabaseSource(ds, "user_abc_info");
		
		g.addSource(s1);
		g.addSource(s2);
		g.generate();
	}
}
