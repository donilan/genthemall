package com.ii2d.genthemall;

/**
 * Generator
 * @author Doni
 * @since 2012-9-11
 * @version $id$
 */
public interface Generator {
	
	public static final String BINDING_DATA_NAME = "data";
	
	/**
	 * Generate method
	 * @author Doni
	 * @since 2012-9-11
	 */
	void generate();
	
	/**
	 * Get target string.
	 * 
	 * @author Doni
	 * @since 2012-9-11
	 * @return Target string
	 */
	String getTargetFile();
	
	/**
	 * Template file path
	 * @author Doni
	 * @since 2012-9-12
	 * @param templatePath The Template file
	 */
	void setTemplatePath(String templatePath);
	
	/**
	 * Set destination path
	 * @author Doni
	 * @since 2012-9-12
	 * @param distPath The Destination path
	 */
	void setDestPath(String destPath);
	
	/**
	 * Set target file path
	 * @author Doni
	 * @since 2012-9-12
	 * @param targetFile The target file
	 */
	void setTargetFile(String targetFile);
}
