package com.ii2d.gen.core.source;

import com.ii2d.gen.core.SettingForTest;

import groovy.util.GroovyTestCase;

class DatabaseSourceTests extends GroovyTestCase {
	
	public void testSource() {
		def source = new DatabaseSource(SettingForTest.DB, SettingForTest.TABLE);
		
	}
}
