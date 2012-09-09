package com.ii2d.gen.core.util

class NameUtils {
	
	public static final String NO_NAME_TEMPLATE = 'no_name';
	
	public static final String DIR_NAME_TEMPLATE = 'dir_name_';
	
	public static final String NAME = '__NAME__';
	public static final String PASCAL_NAME = '__PASCAL_NAME__';
	public static final String CAMEL_NAME = '__CAMEL_NAME__';

	/**
	 * 把路径里面的魔术变量替换为文件名
	 * @author Doni
	 * @since 2012-09-06
	 */
	public static String replacePath(String path, String name) {
		return path?.replace(NAME, name)?.replace(PASCAL_NAME, toPascalName(name))?.replace(CAMEL_NAME, toCamelName(name));
	}
	
	public static String getTemplateName(String name) {
		if( !''.equals(name)) return name.replace(NO_NAME_TEMPLATE, '').replace(DIR_NAME_TEMPLATE, '/')
		return name
	}
	
	/**
	 * 把名字转换为Pascal格式，例如: FooBar
	 * @author Doni
	 */
	public static String toPascalName(String name) {
		def nameArr = name.toLowerCase().split('_')
		def result = ''
		nameArr.each{
			result +=  it[0].toUpperCase() + it[1..-1]
		}
		return result
	}
	

	
	public static String toCamelName(String name) {
		String result = toPascalName(name)
		return result[0].toLowerCase() + result[1..-1]
	}
}
