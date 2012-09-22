package com.ii2d.genthemall.template;

import java.util.List;

/**
 * Template model <br>
 * 0.3.0版本进行大改动
 * @author Doni
 * @since 2012-9-10
 * @version $id$
 * 
 */
public class TemplateInfo {
	
	public static final String TEMPLATE_INFO_FILE_NAME = "template-metadata.properties";
	
	private String name;
	private String sourceType;
	private String description;
	private String generator;
	private List<String> templates;
	private String targetPath;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSourceType() {
		return sourceType;
	}
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGenerator() {
		return generator;
	}
	public void setGenerator(String generator) {
		this.generator = generator;
	}
	public String getTargetPath() {
		return targetPath;
	}
	public void setTargetPath(String targetPath) {
		this.targetPath = targetPath;
	}
	public List<String> getTemplates() {
		return templates;
	}
	public void setTemplates(List<String> templates) {
		this.templates = templates;
	}
	

}
