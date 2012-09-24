package com.ii2d.genthemall.template;

import java.io.IOException;

import com.ii2d.genthemall.test.GenthemallBaseTestCase;

public class TemplateInfoFinderTests extends GenthemallBaseTestCase {

	public void testFinderTemplateInfo() throws IOException {
		TemplateInfoFinder f = new TemplateInfoFinder();
		f.setScanPath("classpath:com/ii2d/genthemall/template/commons");
		f.findAllTemplateInfo();
	}
}
