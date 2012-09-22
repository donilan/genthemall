package com.ii2d.genthemall.template;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FilenameUtils;

import com.ii2d.dbase.util.Assert;
import com.ii2d.dbase.util.DResourceFinder;
import com.ii2d.dbase.util.DResourceUtils;

/**
 * 模板信息对象查找器
 * 
 * @author Doni
 * @since 2012-9-22
 * @version $id$
 */
public class TemplateInfoFinder {
	
	protected List<TemplateInfo> infos;

	protected String scanPackage;

	public List<TemplateInfo> findAllTemplateInfo()
			throws IOException {
		Assert.hasLength(scanPackage);
		if(infos != null) {
			return infos;
		}
		List<String> infoPropFiles = DResourceFinder.find(scanPackage,
				new String[] { TemplateInfo.TEMPLATE_INFO_FILE_NAME }, null);
		infos = new ArrayList<TemplateInfo>();
		for(String p: infoPropFiles) {
			infos.add(_findTemplateInfo(p));
		}
		return infos;
	}
	
	public TemplateInfo findTemplateInfoByName(String name) throws IOException {
		for(TemplateInfo info: findAllTemplateInfo()) {
			if(info.getName().equals(name))
				return info;
		}
		return null;
	}
	
	public void setScanPackage(String scanPackage) {
		this.scanPackage = scanPackage;
	}

	private TemplateInfo _findTemplateInfo(String propertiesPath)
			throws IOException {
		Properties prop = DResourceUtils
				.getResourceAsProperties(propertiesPath);
		Enumeration<Object> keys = prop.keys();
		TemplateInfo t = new TemplateInfo();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			String value = (String) prop.getProperty(key);
			try {
				BeanUtils.setProperty(t, key, value);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		t.setTemplates(DResourceFinder.find(
				FilenameUtils.getFullPath(propertiesPath), null,
				new String[] { TemplateInfo.TEMPLATE_INFO_FILE_NAME }));
		return t;
	}
}
