package com.ii2d.genthemall.template;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.DirectoryWalker;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Template finder
 * @author Doni
 * @since 2012-9-10
 * @version $id$
 */
public class TemplateFinder extends DirectoryWalker<Template> {
	
	public static final String DEFAULT_TEMPLATE_PATH = "src/main/template";

	private static final Log LOG = LogFactory.getLog(TemplateFinder.class);
	
	protected String templatePath;
	
	protected List<Template> templates;
	
	public TemplateFinder() {
		this(DEFAULT_TEMPLATE_PATH);
	}
	
	public TemplateFinder(String templatePath) {
		this.templatePath = templatePath;
	}
	
	public List<Template> findTemplates() {
		if(templates == null) {
			templates = new ArrayList<Template>();
			try {
				walk(new File(templatePath), templates);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return templates;
	}

	@Override
	protected void handleFile(File file, int depth, Collection<Template> results)
			throws IOException {
		Template t = new Template();
		t.absolutePath = file.getAbsolutePath();
		t.path = file.getPath();
		t.name = file.getName();
		
		// remove prefix
		if(t.path.trim().startsWith(templatePath)) {
			t.path = t.path.substring(templatePath.length()+1);
		}
		LOG.info(String.format("Found a file, absolutePath: %s, path: %s, file name: %s", t.absolutePath, t.path, t.name));
		results.add(t);
	}
	
	
}
