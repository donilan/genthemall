package com.ii2d.genthemall.maven.plugin;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.maven.plugin.AbstractMojo;

public abstract class AbstractGenerateMojo extends AbstractMojo {
	/**
	 * @parameter default-value="classpath:com/ii2d/genthemall/template/"
	 */
	private String templatePath;
	
	
	/**
	 * @parameter
	 */
	private BasicDataSource dataSource;


	public String getTemplatePath() {
		return templatePath;
	}


	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}


	public BasicDataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
}
