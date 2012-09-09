package com.ii2d.gen.core.source


abstract class AbstractSource implements Source {
	
	protected ClassTypeFixer classTypeFixer
	protected String lowerCaseFirstName
	protected List<SourceProperty> properties = []
	protected List<SourceProperty> objectProperties = null
	protected String name
	protected String table
	
	public void setTable(String table) {
		this.table = table
	}
	public String getTable() {
		return this.table;
	}
	
	public List<SourceProperty> getProperties() {
		return this.properties;
	}
	
	public List<SourceProperty> getObjectProperties() {
		if(objectProperties != null) {
			return objectProperties;
		}
		objectProperties = []
		properties.findAll{it.name =~ /.+Id$/ }.each {
			SourceProperty sp = it.clone()
			sp.classType = it.name[0].toUpperCase() + it.name[1..-3]
			sp.name = it.name[0] + it.name[1..-3]
			sp.object = true
			objectProperties.add(sp)
		}
		return objectProperties
	}
	
	public void setName(String name) {
		this.name = name;
		this.lowerCaseFirstName = name[0].toLowerCase() + name[1..-1]
	}
	
	public String getLowerCaseFirstName() {
		return this.lowerCaseFirstName
	}
	
	public String getName() {
		return name
	}
	public void setClassTypeFixer(ClassTypeFixer fixer) {
		this.classTypeFixer = fixer
		
	}
	protected String fixClassType(String type) {
		if(this.classTypeFixer) {
			return this.classTypeFixer.fix(type)
		}
		return type
	}
	

}
