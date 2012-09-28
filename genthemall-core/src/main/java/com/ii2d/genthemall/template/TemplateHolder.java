package com.ii2d.genthemall.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TemplateHolder {

	private List<Template> templates;
	private Map<String, Template> nameMap = new HashMap<String, Template>();
	
	public TemplateHolder(List<Template> templateList) {
		templates = templateList;
		if(templates == null) {
			templates = new ArrayList<Template>();
		}
		for(Template t: templateList) {
			nameMap.put(t.getName(), t);
		}
	}
	
	public Template getTemplateByName(String name) {
		return nameMap.get(name);
	}
	
	public Set<String> names() {
		return nameMap.keySet();
	}
	
	public int size() {
		return templates.size();
	}
}
