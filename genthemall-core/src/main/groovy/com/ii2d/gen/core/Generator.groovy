package com.ii2d.gen.core

import com.ii2d.gen.core.exception.GenerateException
import com.ii2d.gen.core.util.NameUtils;

import groovy.io.FileVisitResult;
import groovy.text.SimpleTemplateEngine

/**
 * Generator class
 * @author Doni
 *
 */
class Generator {
	
	public static final String DEFAULT_TEMPLATE_PATH = "src/template"
	public static final String DEFAULT_TARGET_PATH = "target/generator"
	
	def binding = [:]
	String templateBasePath = DEFAULT_TEMPLATE_PATH
	String excludeTemplateFolders = ['.svn']
	String targetBasePath = DEFAULT_TARGET_PATH
	String targetName
	
	public void addExcludeTemplateFolder(String folder) {
		excludeTemplateFolders.add(folder)
	}
	
	public String generate(String templateStr) {
		def engine = new SimpleTemplateEngine()
		def template = engine.createTemplate(templateStr).make(binding)
		return template.toString()
	}
	
	public void generate(File input, File out) throws GenerateException {
		if(input.exists()) {
			out.getParentFile().mkdirs()
			out.write(generate(input.text))
		} else {
			throw new GenerateException('Cannot found template file: ' + input.getName())
		}
	}
	
	public void generate() throws GenerateException {
		new File(templateBasePath).traverse(preDir: {if(excludeTemplateFolders.contains(it.name)) return FileVisitResult.SKIP_SUBTREE}) { template ->
			if(template.isFile()) {
				def templateDir = template.getParentFile().absolutePath
				//def templateFileName = NameUtils.getTemplateName(template.getName())
				templateBasePath = templateBasePath.replaceAll(/[\\\/]/, {File.separator})  // replace "\" and  "/" to current os's File.separator
				def targetFilePath = templateDir.replace(templateBasePath, targetBasePath)
				
				def distPath = NameUtils.replacePath("${targetFilePath}/${template.getName()}", targetName)
				
				generate(template, new File(distPath))
			}
		}
	}
	
	
	public void binding(String key, Object value) {
		binding[key] = value
	}
}
