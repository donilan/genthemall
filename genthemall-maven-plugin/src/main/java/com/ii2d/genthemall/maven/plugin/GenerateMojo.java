package com.ii2d.genthemall.maven.plugin;

import java.util.List;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.ii2d.dbase.util.Assert;
import com.ii2d.genthemall.DefaultGenerator;
import com.ii2d.genthemall.source.Sources;
import com.ii2d.genthemall.template.TemplateInfo;
import com.ii2d.genthemall.template.TemplateInfoFinder;


/**
 * 
 * @description A Mojo for generating Java sources from some template file.
 * @goal generate
 * @phase generate-sources
 */
public class GenerateMojo extends AbstractGenerateMojo {

	/**
	 * @parameter
	 */
	private List<String> templates;


	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		Assert.notNull(templates);
		_initSourcesMap();
		try {
			TemplateInfoFinder finder = new TemplateInfoFinder();
			finder.setScanPath(this.getScanPackage());
			for(String template: templates) {
				TemplateInfo t = finder.findTemplateInfoByName(template);
				Assert.notNull(t, String.format("Template info [%s] not found.", template));
				Sources s = this.getSourcesMap().get(t.getSourceType());
				Assert.notNull(s, String.format("Source type [%s] not found.", t.getSourceType()));
				DefaultGenerator gen = new DefaultGenerator();
				gen.setTemplateInfo(t);
				gen.setSources(s);
				gen.generate();
			}
		} catch (Exception e) {
			getLog().error(e);
			throw new MojoExecutionException(e.getMessage());
		}
	}

}
