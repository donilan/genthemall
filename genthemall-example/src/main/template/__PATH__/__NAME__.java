//~ Generate by genthemall
package ${packageName}.model;

public class <%print pascalName%> extends com.ii2d.dbase.mybatis.model.BaseMyBatisModel {
	
	private static final long serialVersionUID = 1L;
	<%columns.each {%>
	protected ${it.classType} ${it.camelName};<%}%>
	<%columns.each {%>
	public void ${it.setter}(${it.classType} ${it.camelName}) {
		this.${it.camelName} = ${it.camelName};
	}
	public ${it.classType} ${it.getter}() {
		return this.${it.camelName};
	}
	<%}%>
}