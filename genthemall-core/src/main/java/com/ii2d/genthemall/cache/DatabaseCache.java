package com.ii2d.genthemall.cache;

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
import org.codehaus.groovy.control.CompilationFailedException;

import com.ii2d.dbase.util.DDBUtils;
import com.ii2d.genthemall.Generator;
import com.ii2d.genthemall.GeneratorFactory;

public class DatabaseCache {

	public static final String CACHE_PATH = "target/genthemall/database.cache";
	public static final String CACHE_TEMPLATE_PATH = "database.gta";

	public static void makeCache(DataSource ds, List<String> tables)
			throws SQLException, IOException, CompilationFailedException,
			ClassNotFoundException {
		Map<String, Object> binding = new HashMap<String, Object>();
		List<Object> tablesData = new ArrayList<Object>();
		binding.put("tables", tablesData);
		for (String table : tables) {
			Map<String, Object> tMap = new HashMap<String, Object>();
			DDBUtils.getColumns(ds, table, tMap);
			tablesData.add(tMap);
		}
		InputStream in = DatabaseCache.class
				.getResourceAsStream(CACHE_TEMPLATE_PATH);
		File file = new File(CACHE_PATH);
		FileUtils.touch(file);
		OutputStream out = new FileOutputStream(file);
		Generator g = GeneratorFactory.create(in, out, binding);
		g.generate();
	}
}
