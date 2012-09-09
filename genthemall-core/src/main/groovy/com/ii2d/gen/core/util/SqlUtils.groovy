package com.ii2d.gen.core.util;

import groovy.sql.Sql;

class SqlUtils {

	/**
	 * Find all tables from database.
	 * @param dbConfig - url, username, password, driver
	 * @param regex - filter table
	 * @return - ArrayList for table names
	 */
	public static Set<String> getAllTable(Map dbConfig, String regex) {
		def db = Sql.newInstance(dbConfig)
		def tables = db.getConnection().getMetaData().getTables(null, null, null, null)
		Set<String> result = new HashSet<String>()
		while(tables.next()) {
			def name = tables.getString('TABLE_NAME');
			if(name ==~ regex) {
				result.add(name)
			}
		}
		return result
	}
}
