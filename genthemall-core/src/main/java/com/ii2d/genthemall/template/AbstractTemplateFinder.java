package com.ii2d.genthemall.template;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTemplateFinder {

	protected String templatePath;

	protected List<Template> templates;

	public List<Template> findTemplates() {
		if (templates == null) {
			templates = new ArrayList<Template>();
			runFinder(templates);
		}
		return templates;
	}

	protected abstract void runFinder(List<Template> templates);

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

}
