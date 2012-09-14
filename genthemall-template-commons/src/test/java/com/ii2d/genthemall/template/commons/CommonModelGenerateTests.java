package com.ii2d.genthemall.template.commons;

import com.ii2d.genthemall.TemplateGenerator;

public class CommonModelGenerateTests extends CommonGenerateTests {

	public void testGenerate() {
		TemplateGenerator tg = new TemplateGenerator();
		tg.setTemplateFilePath("classpath:com/ii2d/genthemall/template/commons/model");
		tg.setConfigFilePath(CONFIG_FILE_PATH);
		tg.generate();
	}
	
}
