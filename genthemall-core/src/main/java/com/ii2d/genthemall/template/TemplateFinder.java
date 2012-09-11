package com.ii2d.genthemall.template;

import java.util.List;

public interface TemplateFinder {
	/**
	 * Find templates
	 * @author Doni
	 * @since 2012-9-11
	 * @return
	 */
	List<Template> findTemplates();
	
	void setTemplatePath(String templatePath);
}
