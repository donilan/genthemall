package com.ii2d.genthemall.template;

import java.io.IOException;

import junit.framework.TestCase;

public class TemplateFinderTests extends TestCase {

	public void testFind() throws IOException {
		System.out.println(TemplateFinder.find("classpath:gt/"));
	}
}
