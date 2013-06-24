package com.ii2d.genthemall.maven.plugin;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

import com.ii2d.genthemall.cache.DatabaseCache;
import com.ii2d.genthemall.template.TemplateFinder;
import com.ii2d.genthemall.template.TemplateHolder;


public abstract class AbstractGenerateMojo extends AbstractMojo {
	
	/**
	 * @parameter expression="${project}"
	 * @required
	 * @readonly
	 */
	protected MavenProject project;
	
	/**
	 * @parameter default-value="classpath:gt/"
	 */
	private String templatePath;
	
	/**
	 * @parameter
	 */
	protected List<GenerateConfig> generateConfigs;
	
	/**
	 * @parameter
	 */
	private DatabaseSource databaseSource;
	
	/**
	 * @parameter
	 */
	protected Map<String, String> targetPathMap;
	
	/**
	 * @parameter default-value="classpath:genthemall.conf"
	 */
	@Deprecated
	protected String configFile;
	
	/**
	 * @parameter default-value=true expression="${maven.genthemall.refreshCache}"
	 */
	private boolean refreshCache;
	
	public static final String TARGET_TYPE_DEFAULT = "default";
	public static final String TARGET_TYPE_ROOT = "root";
	public static final String TARGET_TYPE_WEB = "web";
	public static final String TARGET_TYPE_JSP = "jsp";
	public static final String TARGET_TYPE_RESOURCES = "resources";
	public static final String TARGET_TYPE_JAVA_CODE = "javaCode";
	private Map<String, String> defaultTargetPathMap = new HashMap<String, String>();
	public AbstractGenerateMojo() {
		defaultTargetPathMap.put(TARGET_TYPE_JAVA_CODE, "src/main/java");
		defaultTargetPathMap.put(TARGET_TYPE_RESOURCES, "src/main/resources");
		defaultTargetPathMap.put(TARGET_TYPE_WEB, "src/main/webapp");
		defaultTargetPathMap.put(TARGET_TYPE_DEFAULT, "target/genthemall");
		defaultTargetPathMap.put(TARGET_TYPE_JSP, "src/main/webapp/WEB-INF/jsp");
		defaultTargetPathMap.put(TARGET_TYPE_ROOT, "./");
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public DatabaseSource getDatabaseSource() {
		return databaseSource;
	}

	public void setDatabaseSource(DatabaseSource databaseSource) {
		this.databaseSource = databaseSource;
	}
	
	@SuppressWarnings("rawtypes")
	protected ClassLoader getClassloader() throws DependencyResolutionRequiredException, MalformedURLException {
		List runtimeClasspathElements = project
				.getRuntimeClasspathElements();
		URL[] runtimeUrls = new URL[runtimeClasspathElements.size()];
		for (int i = 0; i < runtimeClasspathElements.size(); i++) {
			String element = (String) runtimeClasspathElements.get(i);
			runtimeUrls[i] = new File(element).toURI().toURL();
		}
		URLClassLoader newLoader = new URLClassLoader(runtimeUrls, Thread
				.currentThread().getContextClassLoader());
		return newLoader;
	}
	
	protected TemplateHolder getTemplateHolder() throws MalformedURLException, IOException, DependencyResolutionRequiredException {
		return TemplateFinder.findToHodler(
				this.getClassloader(), this.getTemplatePath());
	}
	
	protected TemplateHolder getTemplateHolder(String tmplPath) throws MalformedURLException, IOException, DependencyResolutionRequiredException, SQLException {
		if (refreshCache) {
			DatabaseSource ds = this.getDatabaseSource();
			try {
				DatabaseCache.makeCache(ds, ds.getTables());
			} catch(SQLException e) {
				getLog().error(String.format("Fail to making cache: ", e.getMessage()));
				throw e;
			} catch (Exception e) {
				e.printStackTrace();
			}
			getLog().info("Make database cache success.");
		}
		return TemplateFinder.findToHodler(
				this.getClassloader(), tmplPath);
	}
	
	protected String getTargetBasePath(String type) {
		String p = defaultTargetPathMap.get(type);
		if (StringUtils.isEmpty(p)) {
			return defaultTargetPathMap.get(TARGET_TYPE_DEFAULT);
		}
		return p;
	}

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		if (targetPathMap != null) {
			defaultTargetPathMap.putAll(targetPathMap);
		}
		Set<String> tables = new HashSet<String>();
		for( GenerateConfig gc: this.generateConfigs) {
			if(StringUtils.isNotBlank(gc.getTables()))
				for(String t: gc.getTables().split(",")) {
					tables.add(StringUtils.trim(t));
				}
		}
		try {
			DatabaseCache.makeCache(this.getDatabaseSource(), new ArrayList<String>(tables));
		} catch (Exception e) {
			throw new MojoExecutionException(e.getMessage());
		}
		doExecute();
	}
	
	public abstract void doExecute() throws MojoExecutionException, MojoFailureException;
	
}
