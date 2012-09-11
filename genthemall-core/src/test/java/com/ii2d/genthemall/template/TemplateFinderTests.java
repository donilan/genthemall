package com.ii2d.genthemall.template;

import java.io.IOException;

import junit.framework.TestCase;

public class TemplateFinderTests extends TestCase {

	public void testFindTemplates() {
		//new TemplateFinder("src").findTemplates();
	}
	
	public void testFindClassPathFile() throws IOException {
		TemplateFinder tf = new ClasspathTemplateFinder();
		tf.setTemplatePath("classpath:junit");
		tf.findTemplates();
	}
}
