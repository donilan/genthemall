package com.ii2d.genthemall.template.mybatis;

import com.ii2d.genthemall.TemplateGenerator;
import com.ii2d.genthemall.template.commons.CommonGenerateTests;

public class TemplateMybatisMysqlGenerateTests extends CommonGenerateTests {

	protected TemplateGenerator tg = new TemplateGenerator();
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		tg.setDestPath("src/test/resources");
	}

	public void testGenerate() {
		
		tg.setTemplateFilePath("classpath:com/ii2d/genthemall/template/mybatis/mysql");
		tg.setConfigFilePath(CONFIG_FILE_PATH);
		tg.generate();
	}
	
}
