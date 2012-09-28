package com.ii2d.genthemall.maven.plugin;

public class GenerateConfig {
	private String tables;
	private String includeTemplate;
	private String excludeTemplate;
	public String getTables() {
		return tables;
	}
	public void setTables(String tables) {
		this.tables = tables;
	}
	public String getIncludeTemplate() {
		return includeTemplate;
	}
	public void setIncludeTemplate(String includeTemplate) {
		this.includeTemplate = includeTemplate;
	}
	public String getExcludeTemplate() {
		return excludeTemplate;
	}
	public void setExcludeTemplate(String excludeTemplate) {
		this.excludeTemplate = excludeTemplate;
	}
	
	
}
