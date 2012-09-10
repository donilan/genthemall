package com.ii2d.genthemall;

import junit.framework.TestCase;

import com.ii2d.genthemall.source.DatabaseSource;
import com.ii2d.genthemall.source.Source;

public class ConfigGeneratorTests extends TestCase {

	public void testSomething() {
		// ConfigGenerator g = new ConfigGenerator();
		// g.generate();
	}

	public void testGenerate() {
		Source s = new DatabaseSource("com.mysql.jdbc.Driver",
				"jdbc:mysql://127.0.0.1:3306/hnwnew", "root", "sa", "hnw_user");
		ConfigGenerator g = new ConfigGenerator();
		g.addSource(s);
		g.generate();
	}
}
