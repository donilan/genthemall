package com.ii2d.genthemall.maven.plugin;

import groovy.util.ConfigObject;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.ii2d.genthemall.SourceGenerator;
import com.ii2d.genthemall.exception.GenthemallException;
import com.ii2d.genthemall.source.DatabaseSource;

/**
 * Goal which generate config file
 * 
 * @goal generate-config
 * 
 */
public class GenerateConfigMojo extends AbstractMojo {

	private static final Log LOG = LogFactory.getLog(GenerateConfigMojo.class);
	/**
	 * @parameter expression="${configTemplateFilePath}" default-value=
	 *            "classpath:com/ii2d/genthemall/template/commons/conf/mysql.config.template"
	 */
	private String configTemplateFilePath;

	/**
	 * @parameter expression="${configDestPath}"
	 *            default-value="${project.build.directory}/genthemall/"
	 */
	private String configDestPath;

	/**
	 * @parameter expression="${driverClass}"
	 *            default-value="com.mysql.jdbc.Driver"
	 */
	private String driverClass;
	/**
	 * @parameter expression="${url}"
	 *            default-value="jdbc:mysql://127.0.0.1:3306/mysql"
	 */
	private String url;
	/**
	 * @parameter expression="${username}" default-value="root"
	 */
	private String username;
	/**
	 * @parameter expression="${password}" default-value="sa"
	 */
	private String password;
	/**
	 * @parameter expression="${tables}"
	 *            default-value="user,db,host,time_zone,time_zone_name"
	 */
	private String tables;

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {

		if (StringUtils.isBlank(driverClass) || StringUtils.isBlank(url)
				|| StringUtils.isBlank(username)
				|| StringUtils.isBlank(password) || StringUtils.isBlank(tables)) {
			String err = String
					.format("driver class: %s, url: %s, username: %s, tables %s and password **** Cann't be empty or null.",
							driverClass, url, username, tables);
			LOG.error(err);
			throw new GenthemallException(err);
		}

		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(url);
		ds.setDriverClassName(driverClass);
		ds.setUsername(username);
		ds.setPassword(password);

		String tableArr[] = tables.split(",");
		SourceGenerator g = new SourceGenerator();
		for (String t : tableArr) {
			t = StringUtils.trimToEmpty(t);
			if (StringUtils.isNotBlank(t)) {
				ConfigObject s = new DatabaseSource(ds, t);
				g.addSource(s);
				g.setTemplateFilePath(configTemplateFilePath);
				g.setDestPath(configDestPath);
			}
		}
		g.generate();
	}

}
