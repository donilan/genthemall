package com.ii2d.genthemall.source;

import com.ii2d.genthemall.test.GenthemallBaseTestCase;

public class DatabaseSourcesTests extends GenthemallBaseTestCase {

	@SuppressWarnings("unchecked")
	public void testSomething() {
		DatabaseSources s = new DatabaseSources();
		s.setDataSource(ds);
		s.put("tables", tables);
		assertFalse(s.getResourceNames().isEmpty());
		assertFalse(s.getAllResources().isEmpty());
	}
}
