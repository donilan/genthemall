<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table class="list-table" >
	<thead>
		<tr class="head">
			 
			<th>Name</th> 
			<th>Status</th> 
			<th>ParentTreeCode</th> 
			<th>TreeCode</th>
		</tr>
	</thead>
	<c:forEach items="${newsTypeList }" var="vo" varStatus="s">
	<tr class="${s.count % 2 eq 0 ? 'even' : 'odd' } ${s.first? 'first': s.last ? 'last': ''}">
		<td class="name editable" title="${vo.name}" >
			<span>${vo.name}</span>
			<input length="255" class="hide" type="text" name="name" value="${vo.name}" />
		</td>
		<td class="status editable" title="${vo.status}" >
			<span>${vo.status}</span>
			<input length="11" class="hide" type="text" name="status" value="${vo.status}" />
		</td>
		<td class="parentTreeCode editable" title="${vo.parentTreeCode}" >
			<span>${vo.parentTreeCode}</span>
			<input length="255" class="hide" type="text" name="parentTreeCode" value="${vo.parentTreeCode}" />
		</td>
		<td class="treeCode editable" title="${vo.treeCode}" >
			<span>${vo.treeCode}</span>
			<input length="255" class="hide" type="text" name="treeCode" value="${vo.treeCode}" />
		</td>
		
		<td class="hide id-holder" >
			<input type="hidden" class="id-column" name="Id" value="${vo.id }" />
		</td>
	</tr>
	</c:forEach>
</table>