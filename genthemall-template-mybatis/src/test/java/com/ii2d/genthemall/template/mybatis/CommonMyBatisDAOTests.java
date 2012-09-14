//~ generate by eclipse
package com.ii2d.genthemall.template.mybatis;

import java.io.IOException;

import junit.framework.TestCase;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ii2d.dbase.mybatis.dao.impl.CommonMyBatisDAO;
import com.ii2d.dbase.util.DResourceUtils;
import com.ii2d.model.User;

/**
 * @author Doni
 * @since 2012-9-9
 * @version $id$
 * 
 */
public class CommonMyBatisDAOTests extends TestCase {
	
	private ApplicationContext ac;
	protected CommonMyBatisDAO dao;
	
	public void setUp() {
		try {
			PropertyConfigurator.configure(DResourceUtils.getResourceAsProperties("classpath:log4j.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ac = new ClassPathXmlApplicationContext("classpath:applicationContext-mybatis-test.xml");
		dao = (CommonMyBatisDAO)ac.getBean("commonDao");
	}
	
	public void testQueryById() {
		User u = dao.queryForById(1, User.class);
		System.out.println(u);
	}
	
	public void testQuery() {
		User u = new User();
		u.orLike("name", "二").orderBy("password").orderBy("old_id");
		System.out.println(dao.queryForList(u));
	}
	
}
