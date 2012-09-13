package com.ii2d.genthemall.example;

import java.io.IOException;

import com.ii2d.dbase.util.DResourceUtils;

import junit.framework.TestCase;

public class SomeTests extends TestCase{
	public void testResource() throws IOException  {
		System.out.println(DResourceUtils.getResourceURL("classpath:com/ii2d/genthemall/template/mybatis/mysql"));
	}
}
