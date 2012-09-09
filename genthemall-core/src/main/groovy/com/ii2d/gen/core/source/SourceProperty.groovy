package com.ii2d.gen.core.source

import groovy.transform.AutoClone

/**
 * 资源属性
 * @author Doni
 *
 */
class SourceProperty {
	String name
	/**
	 * 首字母大写名字
	 */
	String upperCaseFirstName
	String classType
	String columnName
	String columnTypeName
	int size
	boolean nullable
	boolean object = false
	
	private void setucfirstName(){}
	public void setName(String name) {
		this.name = name
		this.upperCaseFirstName = name[0].toUpperCase() + name[1..-1]
	}
	
	public Object clone() throws CloneNotSupportedException {
		SourceProperty sp = new SourceProperty();
		sp.classType = this.classType
		sp.columnName = this.columnName
		sp.columnTypeName = this.columnTypeName
		sp.upperCaseFirstName = this.upperCaseFirstName
		sp.size = this.size
		sp.nullable = this.nullable
		sp.name = this.name
		return sp
	}
}
