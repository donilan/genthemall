package com.ii2d.genthemall.mojo;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import com.ii2d.gen.core.Generator;
import com.ii2d.gen.core.source.ClassTypeFixer;
import com.ii2d.gen.core.source.DatabaseSource;
import com.ii2d.gen.core.source.Source;
import com.ii2d.gen.core.util.NameUtils;
import com.ii2d.gen.core.util.SqlUtils;

/**
 * @goal generate
 */
public class GenerateMojo extends AbstractMojo {
	
	/**
	 * Path of template
	 * @parameter
	 */
	private String templatePath;
	
	/**
	 * Path of targetPath
	 * @parameter
	 */
	private String targetPath;
	
	/**
	 * classTypeFixer for one class type change to another type
	 * @parameter
	 */
	private Map<String, String> classTypeFixer;
	
	/**
	 * Settings for database
	 * @parameter
	 */
	private Map<String, String> databaseSettings;
	
	/**
	 * Table for generate
	 * @parameter expression="${genthemall.database.table}"
	 */
	private String table;

	/**
	 * Table prefix like 'DB_'
	 * @parameter expression="${genthemall.database.tablePrefix}"
	 */
	private String tablePrefix = "";
	
	/**
	 * Generate4tables like 'table1,table2,table3'
	 * @parameter expression="${genthemall.database.generate4tables}"
	 */
	private String generate4tables = "";
	
	/**
	 * Is generate all table
	 * @parameter expression="${genThemAll}"
	 */
	private boolean genThemAll = false;
	
	/**
	 * Remove prefix for generate file.
	 * @parameter expression="${genthemall.generate.removePrefix}"
	 */
	private boolean removePrefix = false;
	/**
	 * Target file name <br />
	 * Example, If targetName is 'User' and the template file 
	 * name is 'no_name.java', then file name which by generate 
	 * will be User.java
	 * @parameter expression="${genthemall.generate.targetName}"
	 */
	private String targetName;

	public void execute() throws MojoExecutionException {
		if(databaseSettings != null && databaseSettings.size() < 2) {
			throw new MojoExecutionException("Database settings must be config.");
		}
		this.getLog().info("URL: " + databaseSettings.get("url"));
		this.getLog().info("driver: " + databaseSettings.get("driver"));
		this.getLog().info("user: " + databaseSettings.get("user"));
		
		Map<String, String> databaseSettings2 = new HashMap<String, String>(databaseSettings);
		
		Generator generator = new Generator();
		Source source = null;
		Set<String> tables = new HashSet<String>();
		
		if(table != null) {
			tables.add(table);
		}
		if(StringUtils.isNotBlank(this.generate4tables)) {
			String[] tableArray = StringUtils.split(this.generate4tables, ",");
			for(String t: tableArray) {
				tables.add(StringUtils.trim(t));
			}
		} else if(genThemAll) { // 是否需要查找所有表生成
			String regex = ".+";
			if(StringUtils.isNotBlank(tablePrefix)) {
				regex = tablePrefix + ".+";
			}
			tables.addAll(SqlUtils.getAllTable(databaseSettings, regex));
		}
		
		
		Iterator<String> it = tables.iterator();
		while(it.hasNext()) {
			String table = it.next();
			this.getLog().info("generating... for table : " + table);
			if(StringUtils.isNotBlank(templatePath)) {
				generator.setTemplateBasePath(templatePath);
			}
			if(StringUtils.isNotBlank(targetPath)) {
				generator.setTargetBasePath(targetPath);
			}
			source = new DatabaseSource(databaseSettings2, table);
			
			// 使用数据库的表名字
			if(StringUtils.isBlank(targetName) || genThemAll) {
				String tableName = table;
				if(removePrefix) {
					tableName = tableName.replaceFirst(tablePrefix, "");
				}
				targetName = NameUtils.toPascalName(tableName);
			}
			if(source != null) {
				if(classTypeFixer != null) {
					ClassTypeFixer fixer = new ClassTypeFixer(classTypeFixer);
					source.setClassTypeFixer(fixer);
				}
				source.init();
				source.setName(targetName);
				generator.setTargetName(targetName);
				generator.binding("source", source);
				generator.generate();
			}
		}
	}
}
