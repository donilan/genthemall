
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
			<th>null</th> 
			<th>null</th> 
			<th>null</th>
		</tr>
	</thead>
	<c:forEach items="${menuList }" var="vo" varStatus="s">
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
		<td class="uri editable" title="${vo.uri}" >
			<span>${vo.uri}</span>
			<input length="1023" class="hide" type="text" name="uri" value="${vo.uri}" />
		</td>
		<td class="menuKey editable" title="${vo.menuKey}" >
			<span>${vo.menuKey}</span>
			<input length="255" class="hide" type="text" name="menuKey" value="${vo.menuKey}" />
		</td>
		<td class="menuTypeId editable" title="${vo.menuTypeId}" >
			<span>${vo.menuTypeId}</span>
			<input length="11" class="hide" type="text" name="menuTypeId" value="${vo.menuTypeId}" />
		</td>
		<td class="parentId editable" title="${vo.parentId}" >
			<span>${vo.parentId}</span>
			<input length="11" class="hide" type="text" name="parentId" value="${vo.parentId}" />
		</td>
		
		<td class="hide id-holder" >
			<input type="hidden" class="id-column" name="Id" value="${vo.id }" />
		</td>
	</tr>
	</c:forEach>
</table>