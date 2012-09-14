package com.ii2d.genthemall;

import groovy.lang.Writable;
import groovy.text.SimpleTemplateEngine;
import groovy.text.Template;
import groovy.util.ConfigObject;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ii2d.dbase.util.Assert;
import com.ii2d.dbase.util.DResourceUtils;
import com.ii2d.genthemall.exception.GenthemallException;

public abstract class AbstractGenerator implements Generator {

	private static final Log LOG = LogFactory.getLog(AbstractGenerator.class);

	private static final String _DEFAULT_DIST_PATH = "target/genthemall/";

	// dist path
	protected String destPath;
	// target file name
	protected String destFile;
	// Map for replace string
	protected Map<String, String> replaceMap = new HashMap<String, String>();
	// template file path
	protected String templateFilePath;

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
			destFile = destFile
					.replaceAll(entry.getKey(), entry.getValue());
		}
	}

	public String getDestFile() {
		Assert.hasText(this.destFile);
		if (destFile.startsWith("/") || destFile.startsWith("\\")) {
			destFile = destFile.substring(1);
		}
		// Replace to final target string.
		replaceTarget();
		return FilenameUtils.concat(getDestPath(), destFile);
	}

	public void generate() {
		Assert.hasText(this.getTemplateFilePath());
		Assert.hasText(this.getDestFile());
		SimpleTemplateEngine engine = new SimpleTemplateEngine();

		try {
			LOG.info(String.format("Loading Config template [%s]...", this.getTemplateFilePath()));

			Template template = engine.createTemplate(DResourceUtils
					.getResourceAsReader(this.getTemplateFilePath()));
			Writable writable = template.make(getBindingData());
			File out = new File(this.getDestFile());
			FileUtils.touch(out);
			FileWriter f = new FileWriter(out);
			LOG.info("Generating config file to: " + this.getDestFile());
			writable.writeTo(f);
			f.close();
			LOG.info("Finish generating.\n");
		} catch (Exception e) {
			throw new GenthemallException(e);
		}
	}

	public String getDestPath() {
		return StringUtils.isBlank(destPath) ? _DEFAULT_DIST_PATH : destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

	/**
	 * Template file cann't use "classpath:" or "file:", by default is "file:"
	 * 
	 * @author Doni
	 * @since 2012-9-11
	 * @param templatePath
	 *            The template file path
	 */
	public void setTemplateFilePath(String templatePath) {
		this.templateFilePath = templatePath;
	}

	public String getTemplateFilePath() {
		return templateFilePath;
	}

}
