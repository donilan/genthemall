package com.ii2d.genthemall;

import groovy.lang.Writable;
import groovy.text.SimpleTemplateEngine;
import groovy.text.Template;
import groovy.util.ConfigObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ii2d.dbase.util.DResourceUtils;
import com.ii2d.genthemall.exception.GenthemallException;

public abstract class AbstractGenerator implements Generator {

	private static final Log LOG = LogFactory.getLog(AbstractGenerator.class);

	private static final String _DEFAULT_DIST_PATH = "target/genthemall/";

	// target path and file name
	private String targetFile;
	// Map for replace string
	private Map<String, String> replaceMap = new HashMap<String, String>();
	// dist path
	private String distPath;
	// template file path
	private String templatePath;

	/**
	 * 
	 * @author Doni
	 * @since 2012-9-11
	 * @return A map for data binding.
	 */
	abstract ConfigObject getBindingData();

	/**
	 * add a path replace string
	 * 
	 * @author Doni
	 * @since 2012-9-11
	 * @param target
	 *            Replaces target
	 * @param replace
	 *            String for replace
	 */
	public void addReplaceString(String target, String replace) {
		replaceMap.put(target, replace);
	}

	/**
	 * Replace the target path and file name.
	 * 
	 * @author Doni
	 * @since 2012-9-11
	 */
	protected void replaceTarget() {
		Iterator<Entry<String, String>> it = replaceMap.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			targetFile = targetFile.replaceAll(entry.getKey(), entry.getValue());
		}
	}

	public String getTargetFile() {
		if (StringUtils.isBlank(targetFile) || targetFile.length() < 3) {
			throw new GenthemallException("Target cann't be blank or empty");
		}
		if (targetFile.startsWith("/") || targetFile.startsWith("\\")) {
			targetFile = targetFile.substring(1);
		}
		// Replace to final target string.
		replaceTarget();
		return FilenameUtils.concat(getDistPath(), targetFile);
	}

	protected Reader getTemplateAsReader() throws IOException {
		if (StringUtils.isBlank(this.getTemplatePath())) {
			throw new GenthemallException(
					"The param template path cann't be null or empty.");
		}
		LOG.info("Get resource for: " + getTemplatePath());
		return DResourceUtils.getResourceAsReader(this.getTemplatePath());
	}

	public void generate() {
		SimpleTemplateEngine engine = new SimpleTemplateEngine();

		try {
			LOG.info("Loading Config template...");

			Template template = engine.createTemplate(getTemplateAsReader());
			Writable writable = template.make(getBindingData());
			File out = new File(this.getTargetFile());
			FileUtils.touch(out);
			FileWriter f = new FileWriter(out);
			LOG.info("Generating config file to: " + this.getTargetFile());
			writable.writeTo(f);
			f.close();
			LOG.info("Finish generating.");
		} catch (Exception e) {
			throw new GenthemallException(e);
		}
	}

	public String getDistPath() {
		return StringUtils.isBlank(distPath) ? _DEFAULT_DIST_PATH : distPath;
	}

	public void setDestPath(String distPath) {
		this.distPath = distPath;
	}

	/**
	 * Template file cann't use "classpath:" or "file:", by default is "file:"
	 * 
	 * @author Doni
	 * @since 2012-9-11
	 * @param templatePath
	 *            The template file path
	 */
	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}
	
	public String getTemplatePath() {
		return templatePath;
	}

	public void setTargetFile(String targetFile) {
		this.targetFile = targetFile;
	}

}
