package com.ii2d.genthemall;

import groovy.util.ConfigObject;
import groovy.util.ConfigSlurper;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ii2d.dbase.util.DNameUtils;
import com.ii2d.dbase.util.DResourceUtils;
import com.ii2d.genthemall.exception.GenthemallException;
import com.ii2d.genthemall.template.ClasspathTemplateFinder;
import com.ii2d.genthemall.template.Template;
import com.ii2d.genthemall.template.FileTemplateFinder;
import com.ii2d.genthemall.template.TemplateFinder;

public class TemplateGenerator extends AbstractGenerator {

	private static final Log LOG = LogFactory.getLog(TemplateGenerator.class);

	public static final String DEFAULT_CONFIG_PATH = "file:target/genthemall/genthemall.conf.groovy";
	public static final String DEFAULT_TEMPLATE_PATH = "src/main/template";

	protected String configFilePath;
	protected String templatePath;
	protected List<Template> templates;
	private ConfigObject toBeUsed;
	@Override
	ConfigObject getBindingData() {
		return toBeUsed;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void generate() {
		if (templates == null) {
			TemplateFinder finder = null;
			if (getTemplatePath().startsWith(
					DResourceUtils.CLASSPATH_URL_PREFIX)) {
				finder = new ClasspathTemplateFinder();
			} else {
				finder = new FileTemplateFinder();
			}
			finder.setTemplatePath(this.getTemplatePath());
			templates = finder.findTemplates();
			LOG.info(String.format("Found %d template files.", templates.size()));
			for(int i = 0; i < templates.size(); ++i) {
				LOG.info(String.format("--Template [%d]: %s", i+1, templates.get(i).getName()));
			}
		}
		try {
			ConfigObject configs = new ConfigSlurper().parse(DResourceUtils
					.getResourceURL(getConfigFilePath()));
			Iterator<String> keysIt = configs.keySet().iterator();
			while (keysIt.hasNext()) {
				String key = keysIt.next();
				Object tmp = configs.get(key);
				if (tmp instanceof ConfigObject) {
					ConfigObject config = (ConfigObject) tmp;
					for(int i = 0; i < templates.size(); ++i) {
						Template t = templates.get(i);
						this.setTemplatePath(t.getAbsolutePath());
						this.toBeUsed = config;
						this.setTargetFile(changeTargetPath(config, t.getRelativePath()));
						super.generate();
					}
				}
			}
		} catch (IOException e) {
			throw new GenthemallException(e);
		}
	}
	
	/**
	 * change target path to real path
	 * @author Doni
	 * @since 2012-9-12
	 * @param co Config Object
	 * @param targetPath Origine target path
	 * @return path to save
	 */
	@SuppressWarnings("unchecked")
	protected String changeTargetPath(ConfigObject co, String targetPath) {
		Iterator<String> propIt = co.keySet().iterator();
		while(propIt.hasNext()) {
			String key = propIt.next();
			Object valObj = co.get(key);
			if(valObj instanceof String) {
				String val = valObj.toString();
				key = DNameUtils.toKeyName(key);
				targetPath = targetPath.replaceAll(key, val);
			}
		}
		return targetPath;
	}

	public String getConfigFilePath() {
		if (StringUtils.isBlank(configFilePath)) {
			LOG.info("Source config file path is empty, use default "
					+ DEFAULT_CONFIG_PATH);
			return DEFAULT_CONFIG_PATH;
		}
		return configFilePath;
	}

	public void setConfigFilePath(String configFilePath) {
		this.configFilePath = configFilePath;
	}

	public String getTemplatePath() {
		if (StringUtils.isBlank(templatePath)) {
			LOG.info("Template path is empty, use default "
					+ DEFAULT_TEMPLATE_PATH);
			return DEFAULT_TEMPLATE_PATH;
		}
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

}
