package com.ii2d.genthemall.template.mybatis;



public class TemplateModelGenerateTests extends com.ii2d.genthemall.template.commons.CommonModelGenerateTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.tg.setDestPath("src/test/java");
	}
	
}