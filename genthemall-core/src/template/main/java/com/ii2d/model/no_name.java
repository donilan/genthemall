package com.ii2d.model;

public class ${source.name} {
	
	<% source.getProperties().each {%>
	private ${it.classType} ${it.name};<% } %>
	
	<% source.getProperties().each {%>
	public ${it.classType} get${it.upperCaseFirstName}() {
		return this.${it.name};
	}
	public void set${it.upperCaseFirstName}(${it.classType} ${it.name}) {
		this.${it.name} = ${it.name};
	}
	<% } %>
}