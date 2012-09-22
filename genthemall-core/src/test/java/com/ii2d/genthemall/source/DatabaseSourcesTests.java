package com.ii2d.genthemall.source;

import com.ii2d.genthemall.test.GenthemallBaseTestCase;

public class DatabaseSourcesTests extends GenthemallBaseTestCase {

	public void testSomething() {
		DatabaseSources s = new DatabaseSources();
		s.setDataSource(ds);
		s.setTables(tables);
		assertFalse(s.getResourceNames().isEmpty());
		assertFalse(s.getAllResources().isEmpty());
	}
}
