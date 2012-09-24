package com.ii2d.genthemall;

import java.io.IOException;
import java.util.List;

import com.ii2d.genthemall.template.TemplateInfo;
import com.ii2d.genthemall.test.GenthemallBaseTestCase;

public class DefaultGeneratorTests extends GenthemallBaseTestCase {

	public void testGenerateConfig() throws IOException {
		List<TemplateInfo> templateInfos = templateInfoFinder.findAllTemplateInfo();
		for(TemplateInfo t: templateInfos) {
			generator.setSources(databaseSources);
			generator.setTemplateInfo(t);
			generator.generate();
		}
	}
}
