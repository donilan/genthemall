package com.ii2d.genthemall;

import junit.framework.TestCase;

public class TemplateGeneratorTests extends TestCase {

	public void testGenerate() {
		
		TemplateGenerator tg = new TemplateGenerator();
		tg.setTemplatePath("classpath:com/ii2d/genthemall/template/core/test");
//		tg.setTemplatePath("src/main/resources/com/ii2d/genthemall/template/core/conf");
		tg.generate();
	}
	
}
