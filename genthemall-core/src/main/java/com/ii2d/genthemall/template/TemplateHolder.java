package com.ii2d.genthemall.template;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ii2d.dbase.template.DTemplate;
import com.ii2d.dbase.template.ParserException;
import com.ii2d.dbase.template.context.Context;
import com.ii2d.dbase.template.finder.DTemplateFinder;
import com.ii2d.dbase.template.finder.ITemplateFinder;

/**
 * hold all the templates
 * @author Administrator
 *
 */
public class TemplateHolder implements ITemplateFinder {
	
	public static final Log LOG = LogFactory.getLog(TemplateHolder.class);

	private Map<String, Template> nameMap = new HashMap<String, Template>();

	public TemplateHolder(){}
	public TemplateHolder(List<Template> templateList) {
		for (Template t : templateList) {
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
		return nameMap.size();
	}

	public List<Template> getTemplates() {
		return new ArrayList<Template>(this.nameMap.values());
	}

	@Override
	public String getTemplateString(String name) throws IOException {
		Template t = this.nameMap.get(name);
		if (t != null) {
			return t.getOriginTemplateText();
		}
		throw new IOException(String.format("Template name [%s] not found.",
				name));
	}

	public void merge(TemplateHolder holder) {
		for (Entry<String, Template> en : holder.nameMap.entrySet()) {
			this.nameMap.put(en.getKey(), en.getValue());
		}
	}

	/**
	 * template generate template
	 * @throws ParserException
	 * @throws IOException
	 */
	public void compile() throws ParserException, IOException {
		DTemplateFinder.register(this);
		for (Entry<String, Template> en : nameMap.entrySet()) {
			Template t = en.getValue();
			LOG.debug(String.format("Compiling template: [%s] version: [%s]", t.getName(), t.getVersion()));
			String content = StringUtils.trimToNull(t.getTemplateText());
			t.setOriginTemplateText(content);
			DTemplate tmpl = new DTemplate(content, new Context());
			t.setTemplateText(StringUtils.trimToNull(tmpl.render()));
			
		}
	}
}
