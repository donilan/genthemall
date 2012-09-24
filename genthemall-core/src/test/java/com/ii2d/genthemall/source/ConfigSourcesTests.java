package com.ii2d.genthemall.source;

import com.ii2d.genthemall.test.GenthemallBaseTestCase;

public class ConfigSourcesTests extends GenthemallBaseTestCase {

	@SuppressWarnings("unchecked")
	public void testSomething() {
		ConfigSources s = new ConfigSources();
		s.put("configFilePath", configPath);
		System.out.println(s.getResourceNames());
	}
}
