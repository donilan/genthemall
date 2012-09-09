package com.ii2d.gen.core.source

/**
 * Source interface, 资源可以来自于数据库，javaBean等等
 * @author Doni
 *
 */
interface Source {
	
	/**
	 * 给出这个资源提供的所有属性类
	 */
	List<SourceProperty> getProperties();
	
	/**
	* 给出这个资源提供的所有对象类, 在数据库为 xxx_id 的类会自动转换为对象类Xxx
	*/
	List<SourceProperty> getObjectProperties();
	
	/**
	 * Set this source name
	 */
	void setName(String name);
	
	/**
	 * Get this source name 
	 */
	String getName();
	
	/**
	 * Set table name
	 */
	void setTable(String table);
	
	/**
	 * Get table name
	 */
	String getTable();
	
	/**
	 * Get the name lower case first letter
	 */
	String getLowerCaseFirstName();
	
	/**
	 * Set property type fixer
	 */
	void setClassTypeFixer(ClassTypeFixer fixer);
	
	/**
	 * init method
	 */
	void init();
}
