package com.ii2d.genthemall.template;

import java.io.IOException;
import java.util.List;

import com.ii2d.genthemall.test.GenthemallBaseTestCase;

public class TemplateInfoFinderTests extends GenthemallBaseTestCase {

	public void testFinderTemplateInfo() throws IOException {
		TemplateInfoFinder f = new TemplateInfoFinder();
		f.setScanPackage("classpath:com/ii2d/genthemall/template/commons");
		List<TemplateInfo> infos = f.findAllTemplateInfo();
		System.out.println(infos);
	}
}
