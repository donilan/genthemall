package com.ii2d.genthemall.maven.plugin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.codehaus.groovy.control.CompilationFailedException;

import com.ii2d.dbase.util.DFilterUtils;
import com.ii2d.genthemall.cache.DatabaseCache;
import com.ii2d.genthemall.template.Template;
import com.ii2d.genthemall.template.TemplateHolder;
import com.ii2d.genthemall.util.GeneratorUtils;

/**
 * 
 * @description A Mojo for generating Java sources from some template file.
 * @goal generate
 * @phase generate-sources
 * @requiresDependencyResolution runtime
 */
public class GenerateMojo extends AbstractGenerateMojo {


	/**
	 * @parameter expression="${maven.genthemall.refreshAll}"
	 * 
	 */
	private boolean refreshAll;
	
	public boolean isRefreshAll() {
		return refreshAll;
	}

	public void setRefreshAll(boolean refreshAll) {
		this.refreshAll = refreshAll;
	}

	@SuppressWarnings("unchecked")
	private Collection<String> _findNames(TemplateHolder templates,
			GenerateConfig config) {
		final String[] includes = _trimStringArray(StringUtils.split(
				config.getIncludeTemplate(), ","));
		final String[] excludes = _trimStringArray(StringUtils.split(
				config.getExcludeTemplate(), ","));
		return CollectionUtils.select(templates.names(), new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				return DFilterUtils.isThisOneYouWant((String) arg0, includes,
						excludes);
			}
		});
	}

	@Override
	public void doExecute() throws MojoExecutionException, MojoFailureException {
		if (generateConfigs == null)
			return;
		try {
			TemplateHolder templates = getTemplateHolder();
			templates.compile();
			getLog().info(
					String.format(
							"Found %d templates, and load %d config in pom.xml file.",
							templates.size(), generateConfigs.size()));
			getLog().info("* * * * Generating * * * *");
			for (final GenerateConfig config : generateConfigs) {
				String[] tables = _trimStringArray(StringUtils.split(config.getTables(), ","));
				if (tables == null)
					return;
				
				Collection<String> names = _findNames(templates, config);
				for (String name : names) {
					getLog().debug("+generating for Template: " + name);
					Template t = templates.getTemplateByName(name);
					if(!t.isGenable()) continue; 
					String basePath = getTargetBasePath(t.getType());
					if (t.isAllCache()) {
						GeneratorUtils.generate(t,
								DatabaseCache.loadCache(tables, "data"),
								FilenameUtils.concat(basePath, t.getPath()),
								refreshAll);
					} else {
						gen4one(tables, t, basePath);
					}
				}
			}
			getLog().info("Done.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new MojoExecutionException(e.getMessage());
		}

	}
	
	private String[] _trimStringArray(String[] arr) {
		if(arr == null)
			return null; 
		for(int i = 0; i < arr.length; ++i) {
			arr[i] = StringUtils.trimToEmpty(arr[i]);
		}
		return arr;
	}

	private void gen4one(String[] tables, Template t, String basePath)
			throws CompilationFailedException, FileNotFoundException,
			IOException, ClassNotFoundException {
		for (String table : tables) {
			GeneratorUtils.generate(t, DatabaseCache.loadCache(table),
					FilenameUtils.concat(basePath, t.getPath()),
					refreshAll);
		}
	}

}
