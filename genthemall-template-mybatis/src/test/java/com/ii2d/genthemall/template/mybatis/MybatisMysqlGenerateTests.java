package com.ii2d.genthemall.template.mybatis;

import com.ii2d.genthemall.TemplateGenerator;
import com.ii2d.genthemall.template.commons.CommonGenerateTests;

public class MybatisMysqlGenerateTests extends CommonGenerateTests {

	public void testGenerate() {
		TemplateGenerator tg = new TemplateGenerator();
		tg.setTemplateFilePath("classpath:com/ii2d/genthemall/template/mybatis/mysql");
		tg.setConfigFilePath(CONFIG_FILE_PATH);
		tg.setDestPath("src/test/resources");
		tg.generate();
	}
	
}
