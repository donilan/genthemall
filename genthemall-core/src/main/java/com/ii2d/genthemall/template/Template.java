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

	/**
	 * 模板的绝对地址
	 * @author Doni
	 * @since 2012-9-13
	 */
	public String getAbsolutePath() {
		return absolutePath;
	}
	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}
	/**
	 * 模板的相对地址
	 * @author Doni
	 * @since 2012-9-13
	 */
	public String getRelativePath() {
		return relativePath;
	}
	public void setRelativePath(String path) {
		this.relativePath = path;
	}
	/**
	 * 模板名称
	 * @author Doni
	 * @since 2012-9-13
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
