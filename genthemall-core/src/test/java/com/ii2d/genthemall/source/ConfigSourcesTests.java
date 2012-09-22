package com.ii2d.genthemall.source;

import com.ii2d.genthemall.test.GenthemallBaseTestCase;

public class ConfigSourcesTests extends GenthemallBaseTestCase {

	public void testSomething() {
		ConfigSources s = new ConfigSources();
		s.setConfigFilePath(configPath);
		System.out.println(s.getResourceNames());
	}
}
