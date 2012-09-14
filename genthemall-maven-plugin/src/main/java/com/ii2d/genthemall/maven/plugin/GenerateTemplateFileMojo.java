package com.ii2d.genthemall.maven.plugin;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.ii2d.dbase.util.Assert;
import com.ii2d.genthemall.TemplateGenerator;

/**
 * 
 * @description A Mojo for generating Java sources from some template file.
 * @goal generate
 * @phase generate-sources
 */
public class GenerateTemplateFileMojo extends AbstractMojo {

	private static final Log LOG = LogFactory
			.getLog(GenerateTemplateFileMojo.class);

	/**
	 * @parameter expression="${configFilePath}"
	 *            default-value="${project.build.directory}/genthemall/mysql.conf"
	 */
	private String configFilePath;

	/**
	 * @parameter
	 */
	private List<TemplateInfo> templateInfos;

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		Assert.notNull(templateInfos);
		try {
			LOG.info(String.format("There is %d template info in pom config.",
					templateInfos.size()));
			for (TemplateInfo m : templateInfos) {
				TemplateGenerator g = new TemplateGenerator();
				g.setConfigFilePath(configFilePath);
				g.setTemplateFilePath(m.getTemplatePath());
				g.setDestPath(m.getDestPath());
				g.generate();
				LOG.info(String.format("Done for config:\n\t\t%s\n\t\t%s\n\n",
						m.getTemplatePath(), m.getDestPath()));
			}
		} catch (Exception e) {
			LOG.error(e);
			e.printStackTrace();
			throw new MojoExecutionException(e.getMessage());
		}
	}

}
