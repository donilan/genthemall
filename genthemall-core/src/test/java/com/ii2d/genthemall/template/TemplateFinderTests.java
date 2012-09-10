package com.ii2d.genthemall.template;

import junit.framework.TestCase;

public class TemplateFinderTests extends TestCase {

	public void testFindTemplates() {
		new TemplateFinder("src").findTemplates();
	}
}
