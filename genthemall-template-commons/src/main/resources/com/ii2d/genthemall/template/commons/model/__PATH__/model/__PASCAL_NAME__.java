//~ Generate by genthemall
package ${packageName}.model;

public class <%print pascalName%> extends ${fartherTable? fartherTable.modelClassName: 'com.ii2d.dbase.mybatis.model.BaseMyBatisModel'} {
	
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
	
	/**
	 * Generate by genthemall
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder(100);
		sb.append("${modelClassName}.toString {\\n\\t");
		<%allColumns.findAll{it.maxLength < 256}.each {%>
		sb.append("${it.camelName}: [");
		sb.append(this.${it.camelName});
		sb.append("], ");<%}%>
		sb.append("\\n}");
		return sb.toString();
	}
}