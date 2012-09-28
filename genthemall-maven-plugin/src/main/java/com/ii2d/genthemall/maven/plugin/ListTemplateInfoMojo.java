package com.ii2d.genthemall.maven.plugin;

import java.io.IOException;
import java.util.List;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.ii2d.genthemall.template.Template;
import com.ii2d.genthemall.template.TemplateFinder;

/**
 * 
 * @description A Mojo for list template infos.
 * @goal list
 */
public class ListTemplateInfoMojo extends AbstractGenerateMojo {

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		
		try {
			List<Template> templates = TemplateFinder.find(this.getTemplatePath());
			for(int i = 0; i < templates.size(); ++i) {
				Template t = templates.get(i);
				getLog().info(String.format("[%d] %s", i+1, t.toString()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
