package com.ii2d.genthemall.maven.plugin;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.ii2d.genthemall.template.TemplateInfo;
import com.ii2d.genthemall.template.TemplateInfoFinder;

/**
 * 
 * @description A Mojo for list template infos.
 * @goal list
 */
public class ListTemplateInfoMojo extends AbstractGenerateMojo {

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		_initSourcesMap();
		
		Set<String> sourceName = this.getSourcesMap().keySet();
		Iterator<String> it = sourceName.iterator();
		int i = 0;
		getLog().info(String.format("\nFound [%d] sources in pom.xml config.", sourceName.size()));
		while(it.hasNext()) {
			getLog().info(String.format("[%d] %s", ++i, it.next()));
		}
		
		TemplateInfoFinder finder = new TemplateInfoFinder();
		finder.setScanPath(this.getScanPackage());
		try {
			i = 0;
			List<TemplateInfo> infos = finder.findAllTemplateInfo();
			getLog().info(String.format("\nFound [%d] template in %s", infos.size(), this.getScanPackage()));
			for(TemplateInfo t: infos) {
				getLog().info(String.format("[%d] %s: %s", ++i, t.getName(), t.getDescription()));
			}
		} catch (IOException e) {
			getLog().error(e);
			throw new MojoExecutionException(e.getMessage());
		}
	}

}
