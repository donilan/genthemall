
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table class="list-table" >
	<thead>
		<tr class="head">
			 
			<th>null</th> 
			<th>null</th> 
			<th>null</th> 
			<th>null</th>
		</tr>
	</thead>
	<c:forEach items="${dictionaryList }" var="vo" varStatus="s">
	<tr class="${s.count % 2 eq 0 ? 'even' : 'odd' } ${s.first? 'first': s.last ? 'last': ''}">
		<td class="dictDescription editable" title="${vo.dictDescription}" >
			<span>${vo.dictDescription}</span>
			<input length="255" class="hide" type="text" name="dictDescription" value="${vo.dictDescription}" />
		</td>
		<td class="dictValue editable" title="${vo.dictValue}" >
			<span>${vo.dictValue}</span>
			<input length="255" class="hide" type="text" name="dictValue" value="${vo.dictValue}" />
		</td>
		<td class="dictKey editable" title="${vo.dictKey}" >
			<span>${vo.dictKey}</span>
			<input length="255" class="hide" type="text" name="dictKey" value="${vo.dictKey}" />
		</td>
		<td class="tableName editable" title="${vo.tableName}" >
			<span>${vo.tableName}</span>
			<input length="255" class="hide" type="text" name="tableName" value="${vo.tableName}" />
		</td>
		
		<td class="hide id-holder" >
			<input type="hidden" class="id-column" name="Id" value="${vo.id }" />
		</td>
	</tr>
	</c:forEach>
</table>