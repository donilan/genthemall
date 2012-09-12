package com.ii2d.genthemall.maven.plugin;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.ii2d.genthemall.Generator;
import com.ii2d.genthemall.TemplateGenerator;

/**
 * 
 * @description A Mojo for generating Java sources from some template file.
 * @goal generate
 * @phase generate-sources
 */
public class GenerateTemplateFileMojo extends AbstractMojo {
	
	private static final Log LOG = LogFactory.getLog(GenerateTemplateFileMojo.class);
	
	/**
	 * @parameter expression="${templatePath}"
	 *            default-value="src/main/template"
	 */
	private String templatePath;
	/**
	 * @parameter expression="${destPath}"
	 *            default-value="${project.build.directory}/genthemall/"
	 */
	private String destPath;
	

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		Generator g = new TemplateGenerator();
		g.setTemplatePath(templatePath);
		g.setDestPath(destPath);
		try {
			g.generate();
		} catch(Exception e) {
			LOG.error(e);
			e.printStackTrace();
			throw new MojoExecutionException(e.getMessage());
		}
	}

}
