package com.ii2d.genthemall.config;

import junit.framework.TestCase;

public class ConfigReaderTests extends TestCase {

	public void testRead() {
		ConfigReader r = new ConfigReader("target/genthemall/genthemall.conf.groovy");
		System.out.println(r.read());
		assertNotNull(r.read());
	}
}
