package com.ii2d.genthemall.template.commons;

import groovy.util.ConfigObject;

import org.apache.commons.dbcp.BasicDataSource;

import com.ii2d.genthemall.SourceGenerator;
import com.ii2d.genthemall.source.DatabaseSource;

public class MysqlConfigGenerateTests extends CommonGenerateTests {

	public void testGenerate() {
		SourceGenerator g = new SourceGenerator();
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/hnwnew");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("sa");
		
		ConfigObject user = new DatabaseSource(ds, "user");
		ConfigObject user_abc_info = new DatabaseSource(ds, "user_abc_info");
		ConfigObject shop = new DatabaseSource(ds, "shop");
		ConfigObject news = new DatabaseSource(ds, "news");
		ConfigObject newsType = new DatabaseSource(ds, "news_type");
		g.addSource(user);
		g.addSource(user_abc_info);
		g.addSource(shop);
		g.addSource(news);
		g.addSource(newsType);
		g.setTemplateFilePath("classpath:com/ii2d/genthemall/template/commons/conf/mysql.conf");
		g.setDestPath(CONFIG_PATH);
		g.generate();
	}
}
