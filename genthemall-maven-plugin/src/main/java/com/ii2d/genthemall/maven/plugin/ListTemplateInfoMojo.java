package com.ii2d.genthemall.maven.plugin;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.ii2d.genthemall.template.Template;

/**
 * @description A Mojo for list template infos.
 * @goal list
 * @requiresDependencyResolution runtime
 */
public class ListTemplateInfoMojo extends AbstractGenerateMojo {

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		try {
			List<Template> templates = getTemplateHolder().getTemplates();
			for (int i = 0; i < templates.size(); ++i) {
				Template t = templates.get(i);
				getLog().info(String.format("[%d] %s", i + 1, t.toString()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printClassLoader(ClassLoader classLoader) {
		if (null == classLoader) {
			return;
		}
		System.out.println("--------------------");
		System.out.println(classLoader);
		if (classLoader instanceof URLClassLoader) {
			URLClassLoader ucl = (URLClassLoader) classLoader;
			int i = 0;
			for (URL url : ucl.getURLs()) {
				System.out.println("url[" + (i++) + "]=" + url);
			}
		}
		printClassLoader(classLoader.getParent());
	}
}
