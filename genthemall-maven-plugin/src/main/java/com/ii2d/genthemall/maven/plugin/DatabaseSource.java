package com.ii2d.genthemall.maven.plugin;

import org.apache.commons.dbcp.BasicDataSource;

public class DatabaseSource extends BasicDataSource {
	private String tables;

	public String getTables() {
		return tables;
	}

	public void setTables(String tables) {
		this.tables = tables;
	}
	
}
