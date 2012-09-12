package ${packageName};

public class ${name} {
	<% attrs.each { p ->%>
	protected ${p.className} ${p.camelName};
	<%}%>
}