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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.groovy.control.CompilationFailedException;

import com.ii2d.dbase.util.Assert;
import com.ii2d.dbase.util.DDBUtils;
import com.ii2d.dbase.util.DResourceUtils;
import com.ii2d.genthemall.Generator;
import com.ii2d.genthemall.GeneratorFactory;

public class DatabaseCache {

	public static final String CACHE_PATH = "target/genthemall/cache/db/";
	public static final String CACHE_TEMPLATE_PATH = "database.gt";
	public static final Log LOG = LogFactory.getLog(DatabaseCache.class);
	
	/**
	 * 以逗号拆分表名字符串，并连成链表
	 */
	public static void makeCache(DataSource ds, String tables) throws CompilationFailedException, SQLException, IOException, ClassNotFoundException {
		List<String> tableList = new ArrayList<String>();
		if(StringUtils.isNotBlank(tables)) {
			String tableArr[] = tables.split(",");
			for(String t: tableArr) {
				t = StringUtils.trim(t);
				if(StringUtils.isNotBlank(t))
					tableList.add(t);
			}
		}
		makeCache(ds, tableList);
	}

	public static void makeCache(DataSource ds, List<String> tables)
			throws SQLException, IOException, CompilationFailedException,
			ClassNotFoundException {
		
		//Global config
		ConfigObject globalConfig = null;
		try {
			InputStream in = DResourceUtils.getResourceAsStream("genthemall.conf");
			globalConfig =  new ConfigSlurper().parse(IOUtils.toString(in));
		} catch (IOException e) {
			//Do not thing.
		}
		
		InputStream in = DatabaseCache.class
				.getResourceAsStream(CACHE_TEMPLATE_PATH);
		String templateText = IOUtils.toString(in);
		in.close();
		
		for (String table : tables) {
			Map<String, Object> binding = new HashMap<String, Object>();
			DDBUtils.getColumns(ds, table, binding);
			binding.put("global", globalConfig);
			File file = new File(FilenameUtils.concat(CACHE_PATH, table + ".cache"));
			FileUtils.touch(file);
			OutputStream out = new FileOutputStream(file);
			Generator g = GeneratorFactory.create(templateText, out, binding);
			g.generate();
			out.close();
		}
	}
	
	public static ConfigObject loadCache(String tableName) throws IOException {
		InputStream in = DResourceUtils.getResourceAsStream(FilenameUtils.concat(CACHE_PATH, tableName + ".cache"));
		String text = IOUtils.toString(in);
		ConfigObject conf = new ConfigSlurper().parse(text);
		return conf;
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
