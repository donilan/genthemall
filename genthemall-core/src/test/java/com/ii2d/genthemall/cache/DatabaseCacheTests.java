package com.ii2d.genthemall.cache;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.groovy.control.CompilationFailedException;

import com.ii2d.genthemall.test.GenthemallBaseTestCase;

public class DatabaseCacheTests extends GenthemallBaseTestCase {

	public void testGenerateCache() throws CompilationFailedException, SQLException, IOException, ClassNotFoundException {
		List<String> tables = new ArrayList<String>();
		tables.add("user");
		tables.add("shop");
		DatabaseCache.makeCache(ds, tables);
	}
}
