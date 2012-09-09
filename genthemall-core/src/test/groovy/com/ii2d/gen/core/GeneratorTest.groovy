package com.ii2d.gen.core;

import com.ii2d.gen.core.source.ClassTypeFixer;
import com.ii2d.gen.core.source.DatabaseSource

import groovy.util.GroovyTestCase;

class GeneratorTest extends GroovyTestCase {
	
	public void testGenerate() {
		def source = new DatabaseSource(SettingForTest.DB, 'user');
		ClassTypeFixer fix = new ClassTypeFixer(['java.math.BigDecimal': 'Long'])
		source.setClassTypeFixer(fix)
		source.name = 'user'
		//source.init()
		//def generate = new Generator()
		//generate.targetName = 'User'
		//generate.binding('source', source)
		//generate.setTemplateBasePath("src/template")
		//generate.setTargetBasePath("target/generator")
		//generate.generate()
	}
}
