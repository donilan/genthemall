package com.ii2d.gen.core.util;

import groovy.util.GroovyTestCase;

class NameUtilsTest extends GroovyTestCase {
	
	public void testGetTemplateName() {
		assertEquals(NameUtils.getTemplateName("abc.txt"), "abc.txt")
		assertEquals(NameUtils.getTemplateName("no_name.txt"), ".txt")
	}
	
}
