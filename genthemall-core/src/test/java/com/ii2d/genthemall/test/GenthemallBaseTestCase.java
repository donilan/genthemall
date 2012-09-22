package com.ii2d.genthemall.test;

import junit.framework.TestCase;

import org.apache.commons.dbcp.BasicDataSource;

public class GenthemallBaseTestCase extends TestCase {
	
	protected BasicDataSource ds;
	protected String tables = "user,shop,product";
	protected String configPath = "target/genthemall/mysql.conf";

	@Override
	protected void setUp() throws Exception {
		ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/hnwnew?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("sa");
		super.setUp();
	}

	
}
