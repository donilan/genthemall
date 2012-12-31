package com.ii2d.genthemall.maven.plugin;

import groovy.util.ConfigObject;

import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.ii2d.genthemall.template.Template;
import com.ii2d.genthemall.template.TemplateHolder;
import com.ii2d.genthemall.util.GeneratorUtils;

/**
 * @goal init
 */
public class InitMojo extends AbstractGenerateMojo {
	
	
	/**
	 * @parameter default-value="springmvc"
	 */
	private String initType;

	@Override
	public void doExecute() throws MojoExecutionException, MojoFailureException {
		try {
			TemplateHolder common = getTemplateHolder("classpath:gtinit/common");
			TemplateHolder initTmpl = getTemplateHolder("classpath:gtinit/" + initType);
			List<Template> tmplList = common.getTemplates();
			tmplList.addAll(initTmpl.getTemplates());
			for(Template t: tmplList) {
				String basePath = getTargetBasePath(t.getType());
				GeneratorUtils.generate(t, new ConfigObject(), FilenameUtils.concat(basePath, t.getPath()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MojoExecutionException(e.getMessage());
		}
		
	}

}
