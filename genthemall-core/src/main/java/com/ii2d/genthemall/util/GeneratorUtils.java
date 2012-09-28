package com.ii2d.genthemall.util;

import static com.ii2d.dbase.util.DStringUtils.replaceAll;
import groovy.util.ConfigObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.codehaus.groovy.control.CompilationFailedException;

import com.ii2d.dbase.util.DNameUtils;
import com.ii2d.genthemall.Generator;
import com.ii2d.genthemall.GeneratorFactory;
import com.ii2d.genthemall.template.Template;

public class GeneratorUtils {

	public static void generate(Template t, ConfigObject bindingData)
			throws FileNotFoundException, IOException,
			CompilationFailedException, ClassNotFoundException {
		String path = replaceAll(t.getPath(), DNameUtils.toReplaceMap(bindingData));
		File file = new File(path);
		FileUtils.touch(file);
		Generator g = GeneratorFactory.create(t.getTemplateText(), file, bindingData);
		g.generate();
	}
}
