package com.ii2d.genthemall.template;

import org.apache.commons.lang3.StringUtils;

import com.ii2d.dbase.util.DResourceUtils;

public class TemplateFinderFactory {

	public static TemplateFinder create(String templatePath) {
		if(StringUtils.isNotBlank(templatePath)) {
			if(templatePath.startsWith(DResourceUtils.CLASSPATH_URL_PREFIX)) {
				TemplateFinder tf = new ClasspathTemplateFinder();
				tf.setTemplatePath(templatePath);
				return tf;
			} else {
				TemplateFinder tf = new FileTemplateFinder();
				tf.setTemplatePath(templatePath);
				return tf;
			}
		}
		
		return null;
	}
}
