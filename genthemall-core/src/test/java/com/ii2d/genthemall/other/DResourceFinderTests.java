package com.ii2d.genthemall.other;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;

import junit.framework.TestCase;

import com.ii2d.dbase.util.DResourceFinder;
import com.ii2d.genthemall.template.TemplateInfo;

public class DResourceFinderTests extends TestCase {

	public void testSomething() throws IOException {
		Enumeration<URL> urls = this.getClass().getClassLoader().getResources("com/ii2d/genthemall/template");
		while(urls.hasMoreElements()) {
			System.out.println(urls.nextElement());
		}
		//TODO fix bug
		List<String> list = DResourceFinder.find("classpath:com/ii2d/genthemall",
				new String[] { TemplateInfo.TEMPLATE_INFO_FILE_NAME }, null);
		System.out.println(list);
	}
}
