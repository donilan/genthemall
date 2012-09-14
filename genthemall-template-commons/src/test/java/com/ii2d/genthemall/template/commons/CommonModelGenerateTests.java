package com.ii2d.genthemall.template.commons;

import com.ii2d.genthemall.TemplateGenerator;

public class CommonModelGenerateTests extends CommonGenerateTests {
	
	protected TemplateGenerator tg = new TemplateGenerator();
	
	public void testGenerate() {
		tg.setTemplateFilePath("classpath:com/ii2d/genthemall/template/commons/model");
		tg.setConfigFilePath(CONFIG_FILE_PATH);
		tg.generate();
	}
	
}
