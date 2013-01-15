package com.ii2d.genthemall.test;

import junit.framework.TestCase;

import org.apache.commons.dbcp.BasicDataSource;

public abstract class GenthemallBaseTestCase extends TestCase {
	
	protected BasicDataSource ds;
	protected String tables = "user,db";
	protected String templatePath = "classpath:gt/";

	@Override
	protected void setUp() throws Exception {
		ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/mysql?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("123456");
		
		super.setUp();
	}

	
}
