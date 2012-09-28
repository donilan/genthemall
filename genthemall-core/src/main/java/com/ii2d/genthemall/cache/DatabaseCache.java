package com.ii2d.genthemall.cache;

import groovy.util.ConfigObject;
import groovy.util.ConfigSlurper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.groovy.control.CompilationFailedException;

import com.ii2d.dbase.util.Assert;
import com.ii2d.dbase.util.DDBUtils;
import com.ii2d.dbase.util.DResourceUtils;
import com.ii2d.genthemall.Generator;
import com.ii2d.genthemall.GeneratorFactory;

public class DatabaseCache {

	public static final String CACHE_PATH = "target/genthemall/cache/db/";
	public static final String CACHE_TEMPLATE_PATH = "database.gta";
	
	public static void makeCache(DataSource ds, String tables) throws CompilationFailedException, SQLException, IOException, ClassNotFoundException {
		List<String> tableList = new ArrayList<String>();
		if(StringUtils.isNotBlank(tables)) {
			String tableArr[] = tables.split(",");
			for(String t: tableArr) {
				tableList.add(t);
			}
		}
		makeCache(ds, tableList);
	}

	public static void makeCache(DataSource ds, List<String> tables)
			throws SQLException, IOException, CompilationFailedException,
			ClassNotFoundException {
		InputStream in = DatabaseCache.class
				.getResourceAsStream(CACHE_TEMPLATE_PATH);
		String templateText = IOUtils.toString(in);
		in.close();
		
		for (String table : tables) {
			Map<String, Object> tMap = new HashMap<String, Object>();
			DDBUtils.getColumns(ds, table, tMap);
			File file = new File(FilenameUtils.concat(CACHE_PATH, table + ".cache"));
			FileUtils.touch(file);
			OutputStream out = new FileOutputStream(file);
			Generator g = GeneratorFactory.create(templateText, out, tMap);
			g.generate();
			out.close();
		}
	}
	
	public static ConfigObject loadCache(String tableName) throws IOException {
		InputStream in = DResourceUtils.getResourceAsStream(FilenameUtils.concat(CACHE_PATH, tableName + ".cache"));
		String text = IOUtils.toString(in);
		return new ConfigSlurper().parse(text);
	}
	
	@SuppressWarnings("unchecked")
	public static ConfigObject loadCache(String tables[], String keyName) throws IOException {
		Assert.hasText(keyName, "Param keyName must not null or empty.");
		ConfigObject conf = new ConfigObject();
		List<ConfigObject> caches = new ArrayList<ConfigObject>();
		for(String table: tables) {
			caches.add(loadCache(table));
		}
		conf.put(keyName, caches);
		return conf;
	}
}
