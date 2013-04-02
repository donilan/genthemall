package com.ii2d.genthemall.template;

public class Template {

	private static final long DEFAULT_LONG_CACHE = -1;
	
	private String name;
	private String description;
	private String type;
	private String version;
	private String path;
	private String templateText;
	private String originTemplateText;
	private long lastModified;
	private long _lastModified = DEFAULT_LONG_CACHE; // cache
	private boolean allCache;
	private boolean overridable = true;
	private boolean genable = true;
	private Template subTemplate;
	
	public boolean isOverridable() {
		return overridable;
	}

	public void setOverridable(boolean overridable) {
		this.overridable = overridable;
	}

	public boolean isAllCache() {
		return allCache;
	}

	public void setAllCache(boolean allCache) {
		this.allCache = allCache;
	}

	public String toString() {
		return String.format("%s-%s[%s]: %s \n\t\tDest path: [%s]", name, version, type, description, path);
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getTemplateText() {
		return templateText;
	}
	public void setTemplateText(String templateText) {
		this.templateText = templateText;
	}

	public boolean isGenable() {
		return genable;
	}

	public void setGenable(boolean genable) {
		this.genable = genable;
	}

	public String getOriginTemplateText() {
		return originTemplateText;
	}

	public void setOriginTemplateText(String originTemplateText) {
		this.originTemplateText = originTemplateText;
	}

	public void setLastModified(long lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * @return last max modified time about this template and sub template modify time.
	 */
	public long getLastModified() {
		if(_lastModified == DEFAULT_LONG_CACHE) {
			_lastModified = lastModified;
			Template sub = getSubTemplate();
			while(sub != null) {
				if(sub.getLastModified() > lastModified) {
					_lastModified = sub.getLastModified();
				}
				sub = sub.getSubTemplate();
			}
		}
		return _lastModified;
	}

	public void setSubTemplate(Template tmp) {
		subTemplate = tmp;
	}
	public Template getSubTemplate() {
		return subTemplate;
	}
}
