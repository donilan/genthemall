package com.ii2d.genthemall.template;

/**
 * Template model
 * @author Doni
 * @since 2012-9-10
 * @version $id$
 */
public class Template {
	
	protected String absolutePath;
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
	
	/**
	 * 最终生成文件的目标地址
	 * @author Doni
	 * @since 2012-9-13
	 * @return
	 */
	public String getRelativeTargetPath() {
		return relativeTargetPath;
	}
	public void setRelativeTargetPath(String relativeTargetPath) {
		this.relativeTargetPath = relativeTargetPath;
	}
}
