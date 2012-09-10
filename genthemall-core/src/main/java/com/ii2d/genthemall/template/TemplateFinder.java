package com.ii2d.genthemall.template;

import java.util.ArrayList;
import java.util.List;

/**
 * Template finder
 * @author Doni
 * @since 2012-9-10
 * @version $id$
 */
public class TemplateFinder {
	
	public static final String DEFAULT_TEMPLATE_PATH = "src/main/template";

	protected String templatePath;
	
	protected List<String> templates = new ArrayList<String>();
	
	public TemplateFinder() {
		this(DEFAULT_TEMPLATE_PATH);
	}
	
	public TemplateFinder(String templatePath) {
		this.templatePath = templatePath;
	}
}
