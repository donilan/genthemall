package com.ii2d.genthemall.maven.plugin;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.project.MavenProject;

import com.ii2d.genthemall.template.TemplateFinder;
import com.ii2d.genthemall.template.TemplateHolder;


public abstract class AbstractGenerateMojo extends AbstractMojo {
	
	/**
	 * @parameter expression="${project}"
	 * @required
	 * @readonly
	 */
	protected MavenProject project;
	
	/**
	 * @parameter default-value="classpath:com/ii2d/genthemall/template/"
	 */
	private String templatePath;
	
	/**
	 * @parameter
	 */
	private DatabaseSource databaseSource;
	
	/**
	 * @parameter default-value="classpath:genthemall.conf"
	 */
	protected String configFile;

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public DatabaseSource getDatabaseSource() {
		return databaseSource;
	}

	public void setDatabaseSource(DatabaseSource databaseSource) {
		this.databaseSource = databaseSource;
	}
	
	@SuppressWarnings("rawtypes")
	protected ClassLoader getClassloader() throws DependencyResolutionRequiredException, MalformedURLException {
		List runtimeClasspathElements = project
				.getRuntimeClasspathElements();
		URL[] runtimeUrls = new URL[runtimeClasspathElements.size()];
		for (int i = 0; i < runtimeClasspathElements.size(); i++) {
			String element = (String) runtimeClasspathElements.get(i);
			runtimeUrls[i] = new File(element).toURI().toURL();
		}
		URLClassLoader newLoader = new URLClassLoader(runtimeUrls, Thread
				.currentThread().getContextClassLoader());
		return newLoader;
	}
	
	protected TemplateHolder getTemplateHolder() throws MalformedURLException, IOException, DependencyResolutionRequiredException {
		return TemplateFinder.findToHodler(
				this.getClassloader(), this.getTemplatePath());
	}
}
