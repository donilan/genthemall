package com.ii2d.genthemall.template;

/**
 * Template model
 * @author Doni
 * @since 2012-9-10
 * @version $id$
 */
public class Template {
	
	protected String absolutePath;
	protected String relativePath;
	protected String relativeTargetPath;
	protected String name;

	public String getAbsolutePath() {
		return absolutePath;
	}
	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}
	public String getRelativePath() {
		return relativePath;
	}
	public void setRelativePath(String path) {
		this.relativePath = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRelativeTargetPath() {
		return relativeTargetPath;
	}
	public void setRelativeTargetPath(String relativeTargetPath) {
		this.relativeTargetPath = relativeTargetPath;
	}
	
}
