package com.ii2d.gen.core.source

import com.ii2d.gen.core.util.NameUtils;

import groovy.sql.Sql

class DatabaseSource extends AbstractSource {
	
	private Map dbConfig

	public DatabaseSource(Map map, String table) {
		this.dbConfig = map
		this.table = table
	}
	
	public void init() {
		properties.clear()
		def db = Sql.newInstance(dbConfig)
		db.query("SELECT * FROM " + table) { result ->
			def meta = result.metaData
			(1..meta.getColumnCount()).each { i->
				SourceProperty p = new SourceProperty()
				p.classType = fixClassType(meta.getColumnClassName(i))
				p.name = fixColumnName(meta.getColumnName(i))
				p.columnName = meta.getColumnName(i)
				p.size = meta.getColumnDisplaySize(i)
				p.columnTypeName = meta.getColumnTypeName(i)
				p.nullable = meta.isNullable(i)
				properties.add(p)
			}
		}
	}
	
	protected String fixColumnName(String name) {
		return NameUtils.toCamelName(name)
	}
	
	
}
