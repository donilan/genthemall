${'<' }%@ page language="java" pageEncoding="UTF-8"%>
${'<' }%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
${'<' }%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
${'<' }%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
${'<' }%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% 
def showCloumn = columns.findAll{it.isListable}.sort{a,b-> if(a.camelName == 'name') return -1; return 1;}
%>
<table class="list-table" >
	<thead>
		<tr class="head">
			<% showCloumn.each { %> 
			<th>${it.chinese }</th><%}%>
		</tr>
	</thead>
	<c:forEach items="\${${camelName }List }" var="vo" varStatus="s">
	<tr class="\${s.count % 2 eq 0 ? 'even' : 'odd' } \${s.first? 'first': s.last ? 'last': ''}">
		<% showCloumn.each {
				def title = "\${vo.${it.camelName}}"
				def val = "\${vo.${it.camelName}}"
				def clazz = "${it.camelName } ${it.isEditable? 'editable': ''}"
				def editor = ""
				if(it.isEditable) {
					editor = """<input length="${it.maxLength}" class="hide" type="text" name="${it.camelName }" value="\${vo.${it.camelName}}" />"""
				}
				if(it.classType == 'java.util.Date') {
					title = """<fmt:formatDate value="\${vo.${it.camelName }}" pattern="yyyy-MM-dd HH:mm:ss" />"""
					val = """<fmt:formatDate value="\${vo.${it.camelName }}" pattern="yyyy-MM-dd" />"""
					clazz = "date ${it.camelName } ${it.isEditable? 'editable': ''}"
					if(it.isEditable) {
						editor = """<input class="datetimepicker hide" type="text" name="${it.camelName }" value="${title}" />"""
					}
				}
					
		%><td class="${clazz }" title="${title }" >
			<span>${val}</span>
			${editor }
		</td>
		<%}%>
		<td class="hide id-holder" >
			<%if(idColumn){ %><input type="hidden" class="id-column" name="${idColumn.name }" value="\${vo.id }" /><%} %>
		</td>
	</tr>
	</c:forEach>
</table>