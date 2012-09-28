package com.ii2d.genthemall.maven.plugin;

import org.apache.maven.plugin.AbstractMojo;

public abstract class AbstractGenerateMojo extends AbstractMojo {
	
	/**
	 * @parameter default-value="classpath:com/ii2d/genthemall/template/"
	 */
	private String templatePath;
	
	/**
	 * @parameter
	 */
	private DatabaseSource databaseSource;

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
	
}
