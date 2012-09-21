<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table class="list-table" >
	<thead>
		<tr class="head">
			 
			<th>Name</th> 
			<th>CreateDate</th> 
			<th>Status</th>
		</tr>
	</thead>
	<c:forEach items="${userTypeList }" var="vo" varStatus="s">
	<tr class="${s.count % 2 eq 0 ? 'even' : 'odd' } ${s.first? 'first': s.last ? 'last': ''}">
		<td class="name editable" title="${vo.name}" >
			<span>${vo.name}</span>
			<input length="255" class="hide" type="text" name="name" value="${vo.name}" />
		</td>
		<td class="date createDate " title="<fmt:formatDate value="${vo.createDate}" pattern="yyyy-MM-dd HH:mm:ss" />" >
			<span><fmt:formatDate value="${vo.createDate}" pattern="yyyy-MM-dd" /></span>
			
		</td>
		<td class="status editable" title="${vo.status}" >
			<span>${vo.status}</span>
			<input length="11" class="hide" type="text" name="status" value="${vo.status}" />
		</td>
		
		<td class="hide id-holder" >
			<input type="hidden" class="id-column" name="Id" value="${vo.id }" />
		</td>
	</tr>
	</c:forEach>
</table>