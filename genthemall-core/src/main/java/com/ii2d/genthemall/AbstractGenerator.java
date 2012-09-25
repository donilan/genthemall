package com.ii2d.genthemall;

import groovy.lang.Writable;
import groovy.text.SimpleTemplateEngine;
import groovy.text.Template;
import groovy.util.ConfigObject;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ii2d.dbase.util.Assert;
import com.ii2d.dbase.util.DResourceUtils;
import com.ii2d.dbase.util.DStringUtils;
import com.ii2d.genthemall.exception.GenthemallException;
import com.ii2d.genthemall.source.Sources;
import com.ii2d.genthemall.template.TemplateInfo;

public abstract class AbstractGenerator implements Generator {

	private static final Log LOG = LogFactory.getLog(AbstractGenerator.class);
	
	public static final String TARGET_TYPE_DEFAULT = "default";
	public static final String TARGET_TYPE_WEB = "web";
	public static final String TARGET_TYPE_RESOURCES = "resources";
	public static final String TARGET_TYPE_JAVA_CODE = "javaCode";

	protected Map<String, String> targetPathMap = new HashMap<String, String>();

	protected TemplateInfo templateInfo;
	protected Sources sources;

	public AbstractGenerator() {
		targetPathMap.put(TARGET_TYPE_JAVA_CODE, "src/test/java");
		targetPathMap.put(TARGET_TYPE_RESOURCES, "src/test/resources");
		targetPathMap.put(TARGET_TYPE_WEB, "src/webapp");
		targetPathMap.put(TARGET_TYPE_DEFAULT, "target/genthemall");
	}

	public Map<String, String> getTargetPathMap() {
		return targetPathMap;
	}

	public void setTargetPathMap(Map<String, String> map) {
		targetPathMap.putAll(map);
	}

	public TemplateInfo getTemplateInfo() {
		return templateInfo;
	}

	public void setTemplateInfo(TemplateInfo templateInfo) {
		this.templateInfo = templateInfo;
	}

	public Sources getSources() {
		return sources;
	}

	public void setSources(Sources sources) {
		this.sources = sources;
	}

	public void generate() {
		generate(Sources.ONE_RESOURCE);
	}

	@SuppressWarnings("unchecked")
	public void generate(String sourceName) {
		Assert.notNull(sources);
		Assert.notNull(templateInfo);
		SimpleTemplateEngine engine = new SimpleTemplateEngine();
		ConfigObject data = sources.getSource(sourceName);
		try {
			LOG.info(String.format("Loading template info[%s]...",
					templateInfo.getName()));
			for (String templatePath : templateInfo.getTemplates()) {

				// Base path for dest file.
				String basePath = this.targetPathMap
						.get(templateInfo.getType());
				if (StringUtils.isBlank(basePath)) {
					LOG.info(
							"Template type in properties file is not defined or this type: ["
									+ templateInfo.getType() + "] not found. So use default.");
					basePath = this.targetPathMap.get(TARGET_TYPE_DEFAULT);
				}
				String destDir = FilenameUtils.concat(basePath,
						templateInfo.getTargetPath());
				LOG.info(destDir);
				String templateDestPath = FilenameUtils.concat(destDir, FilenameUtils.getName(templatePath));
				// End path handler

				
				Template template = engine.createTemplate(DResourceUtils
						.getResourceAsReader(templatePath));
				Writable writable = template.make(data);

				String destPath = DStringUtils.replaceAll(templateDestPath,
						data);

				File out = new File(destPath);
				FileUtils.touch(out);
				FileWriter f = new FileWriter(out);
				LOG.info("Generating dest file to: " + destPath);
				writable.writeTo(f);
				f.close();

			}
			LOG.info("Finish generating.\n");
		} catch (Exception e) {
			throw new GenthemallException(e);
		}
	}

}
