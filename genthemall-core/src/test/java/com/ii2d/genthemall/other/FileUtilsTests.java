package com.ii2d.genthemall.other;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class FileUtilsTests extends TestCase {

	public void testTouchFile() {
		try {
			FileUtils.touch(new File("target/path1/path2/path3/file.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	public void testPathConcat() {
		String expected = File.separator + "etc" + File.separator + "genthemall";
		assertEquals(expected, FilenameUtils.concat("/etc//", "genthemall"));
		assertEquals(expected, FilenameUtils.concat("/etc/", "genthemall"));
		assertEquals(expected, FilenameUtils.concat("/etc//", "./genthemall"));
	}
}
