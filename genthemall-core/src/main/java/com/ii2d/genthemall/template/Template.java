package com.ii2d.genthemall.template;

public class Template {

	private String name;
	private String description;
	private String type;
	private String version;
	private String path;
	private String templateText;
	
	public String toString() {
		return String.format("%s-%s[%s]: %s \n\tDest path: [%s]", name, version, type, description, path);
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getTemplateText() {
		return templateText;
	}
	public void setTemplateText(String templateText) {
		this.templateText = templateText;
	}
	
}
