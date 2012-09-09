package com.ii2d.model;
<%
def objs = []
source.getProperties().findAll{return it.name =~ /^.+Id$/}.each {
	def obj = [:]
	String name = it.name[0..-3]
	obj['name'] = name
	obj['type'] = name[0].toUpperCase() + name[1..-1]
	objs.add(obj)
}

def timeObjs = source.getProperties().findAll{return "java.sql.Date".equals(it.classType)}
%>
@javax.xml.bind.annotation.XmlRootElement(name="${source.name}")
public class ${source.name}Ext extends ${source.name} {
	
	<%objs.each{%>private ${it.type} ${it.name};
	<%}%>
	<%objs.each{%>
	public void set${it.type}(${it.type} ${it.name}) {
		this.${it.name} = ${it.name};
	}
	public ${it.type} get${it.type}() {
		return this.${it.name};
	}
	<%}%><%timeObjs.each{%>
	@javax.xml.bind.annotation.XmlElement(name = "${it.name}")
	public String get${it.upperCaseFirstName}Str() {
		return com.createw.util.DateUtils.formatDatetime(this.${it.name});
	}
	<%}%>
}