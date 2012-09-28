package com.ii2d.genthemall.cache;

import java.io.IOException;
import java.sql.SQLException;

import org.codehaus.groovy.control.CompilationFailedException;

import com.ii2d.genthemall.test.GenthemallBaseTestCase;

public class DatabaseCacheTests extends GenthemallBaseTestCase {

	public void testGenerateCache() throws CompilationFailedException, SQLException, IOException, ClassNotFoundException {
		DatabaseCache.makeCache(ds, tables);
	}
}
