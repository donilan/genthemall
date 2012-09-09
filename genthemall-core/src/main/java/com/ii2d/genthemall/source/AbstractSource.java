package com.ii2d.genthemall.source;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public abstract class AbstractSource implements Source {
	
	protected String name;
	protected List<SourceProperty> properties;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<SourceProperty> getSourceProperties() {
		if(this.properties == null) {
			this.properties = new ArrayList<SourceProperty>();
		}
		return this.properties;
	}
	
	public boolean addSourceProperty(SourceProperty p) {
		if(this.properties == null) {
			this.properties = new ArrayList<SourceProperty>();
		}
		return this.properties.add(p);
	}
	
	public boolean addSourceProperty(Collection<SourceProperty> properties) {
		if(this.properties == null) {
			this.properties = new ArrayList<SourceProperty>();
		}
		return this.properties.addAll(properties);
	}
}
