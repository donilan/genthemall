package com.ii2d.genthemall.template.web.admin;

import com.ii2d.genthemall.TemplateGenerator;
import com.ii2d.genthemall.template.commons.CommonGenerateTests;

public class TemplateViewsGenerateTests extends CommonGenerateTests {
	
	protected TemplateGenerator tg = new TemplateGenerator();
	
	public void testGenerate() {
		tg.setTemplateFilePath("classpath:com/ii2d/genthemall/template/web/admin/view");
		tg.setDestPath("src/main/webapp/WEB-INF/jsp/admin");
		tg.setConfigFilePath(CONFIG_FILE_PATH);
		tg.generate();
	}
	
}
