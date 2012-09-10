package com.ii2d.genthemall;

import groovy.lang.Writable;
import groovy.text.SimpleTemplateEngine;
import groovy.text.Template;

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

import com.ii2d.dbase.util.DResourceUtils;
import com.ii2d.genthemall.exception.GenthemallException;

public abstract class AbstractGenerator implements Generator {

	private static final Log LOG = LogFactory.getLog(AbstractGenerator.class);

	private static final String _DEFAULT_DIST_PATH = "target/genthemall/";

	// target path and file name
	private String target;
	// Map for replace string
	private Map<String, String> replaceMap = new HashMap<String, String>();

	private String distPath;

	/**
	 * 
	 * @author Doni
	 * @since 2012-9-11
	 * @return A map for data binding.
	 */
	abstract Map<String, Object> getDataBindingMap();

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
			target = target.replaceAll(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * Get target string.
	 * 
	 * @author Doni
	 * @since 2012-9-11
	 * @return Target string
	 */
	public String getTarget() {
		if (StringUtils.isBlank(target) || target.length() < 3) {
			throw new GenthemallException("Target cann't be blank or empty");
		}
		if (target.startsWith("/") || target.startsWith("\\")) {
			target = target.substring(1);
		}
		// Replace to final target string.
		replaceTarget();
		return FilenameUtils.concat(getDistPath(), target);
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public void generate() {
		SimpleTemplateEngine engine = new SimpleTemplateEngine();

		try {
			LOG.info("Loading Config template...");
			Template template = engine
					.createTemplate(DResourceUtils
							.getResourceAsReader("com/ii2d/genthemall/config.template"));
			Writable writable = template.make(getDataBindingMap());
			File out = new File(this.getTarget());
			FileUtils.touch(out);
			FileWriter f = new FileWriter(out);
			LOG.info("Generating config file to: " + this.getTarget());
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

	public void setDistPath(String distPath) {
		this.distPath = distPath;
	}

}
