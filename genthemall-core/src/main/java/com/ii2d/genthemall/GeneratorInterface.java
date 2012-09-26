package com.ii2d.genthemall;

/**
 * Generator
 * @author Doni
 * @since 2012-9-11
 * @version $id$
 */
public interface GeneratorInterface {
	
	public static final String BINDING_DATA_NAME = "data";
	
	/**
	 * Generate method
	 * @author Doni
	 * @since 2012-9-11
	 */
	void generate();
	
	void generate(String name);
	
}
