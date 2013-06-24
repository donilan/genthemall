package com.ii2d.genthemall;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.codehaus.groovy.control.CompilationFailedException;

import com.ii2d.genthemall.cache.DatabaseCache;
import com.ii2d.genthemall.template.Template;
import com.ii2d.genthemall.template.TemplateFinder;
import com.ii2d.genthemall.test.GenthemallBaseTestCase;
import com.ii2d.genthemall.util.GeneratorUtils;

public class GeneratorTests extends GenthemallBaseTestCase {

	public void testGenerate() throws FileNotFoundException, IOException, CompilationFailedException, SQLException, ClassNotFoundException{
		DatabaseCache.makeCache(ds, tables);
		List<Template> templates = TemplateFinder.find(templatePath);
		for(Template t: templates) {
			t.setPath(FilenameUtils.concat("target/genthemall", t.getPath()));
			GeneratorUtils.generate(t, DatabaseCache.loadCache("user"), true);
		}
	}
}
