package com.ii2d.genthemall.template;

import java.io.IOException;

import junit.framework.TestCase;

public class TemplateFinderTests extends TestCase {

	public void testFindTemplates() {
		TemplateFinder tf =new FileTemplateFinder();
		tf.setTemplatePath("src/main");
	}
	
	public void testFindClassPathFile() throws IOException {
		TemplateFinder tf = new ClasspathTemplateFinder();
		tf.setTemplatePath("classpath:junit");
		tf.findTemplates();
	}
}
