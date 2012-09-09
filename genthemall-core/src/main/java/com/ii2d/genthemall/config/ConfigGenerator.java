package com.ii2d.genthemall.config;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class ConfigGenerator {
	public void generate() {
		URL url = this.getClass().getClassLoader().getResource("META-INF/maven/com.ii2d/dbase-utils/pom.xml");
		try {
			System.out.println(IOUtils.toString(url.openStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
