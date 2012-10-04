
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
	<c:forEach items="${commentList }" var="vo" varStatus="s">
	<tr class="${s.count % 2 eq 0 ? 'even' : 'odd' } ${s.first? 'first': s.last ? 'last': ''}">
		<td class="status editable" title="${vo.status}" >
			<span>${vo.status}</span>
			<input length="11" class="hide" type="text" name="status" value="${vo.status}" />
		</td>
		<td class="date createDate " title="<fmt:formatDate value="${vo.createDate}" pattern="yyyy-MM-dd HH:mm:ss" />" >
			<span><fmt:formatDate value="${vo.createDate}" pattern="yyyy-MM-dd" /></span>
			
		</td>
		<td class="ip editable" title="${vo.ip}" >
			<span>${vo.ip}</span>
			<input length="20" class="hide" type="text" name="ip" value="${vo.ip}" />
		</td>
		<td class="content editable" title="${vo.content}" >
			<span>${vo.content}</span>
			<input length="21845" class="hide" type="text" name="content" value="${vo.content}" />
		</td>
		<td class="userId editable" title="${vo.userId}" >
			<span>${vo.userId}</span>
			<input length="11" class="hide" type="text" name="userId" value="${vo.userId}" />
		</td>
		<td class="referenceTypeId editable" title="${vo.referenceTypeId}" >
			<span>${vo.referenceTypeId}</span>
			<input length="11" class="hide" type="text" name="referenceTypeId" value="${vo.referenceTypeId}" />
		</td>
		<td class="referenceId editable" title="${vo.referenceId}" >
			<span>${vo.referenceId}</span>
			<input length="11" class="hide" type="text" name="referenceId" value="${vo.referenceId}" />
		</td>
		
		<td class="hide id-holder" >
			<input type="hidden" class="id-column" name="Id" value="${vo.id }" />
		</td>
	</tr>
	</c:forEach>
</table>