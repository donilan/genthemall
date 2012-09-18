package com.ii2d.genthemall.template.web.admin;


public class TemplateMybatisMysqlGenerateTests extends com.ii2d.genthemall.template.mybatis.TemplateMybatisMysqlGenerateTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		tg.setDestPath("src/test/resources");
	}
	
}
