<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table class="list-table" >
	<thead>
		<tr class="head">
			 
			<th>CreateDate</th> 
			<th>Source</th> 
			<th>Status</th> 
			<th>Title</th> 
			<th>Content</th> 
			<th>NewsTypeId</th>
		</tr>
	</thead>
	<c:forEach items="${newsList }" var="vo" varStatus="s">
	<tr class="${s.count % 2 eq 0 ? 'even' : 'odd' } ${s.first? 'first': s.last ? 'last': ''}">
		<td class="date createDate " title="<fmt:formatDate value="${vo.createDate}" pattern="yyyy-MM-dd HH:mm:ss" />" >
			<span><fmt:formatDate value="${vo.createDate}" pattern="yyyy-MM-dd" /></span>
			
		</td>
		<td class="source editable" title="${vo.source}" >
			<span>${vo.source}</span>
			<input class="hide" type="text" name="source" value="${vo.source}" />
		</td>
		<td class="status editable" title="${vo.status}" >
			<span>${vo.status}</span>
			<input class="hide" type="text" name="status" value="${vo.status}" />
		</td>
		<td class="title editable" title="${vo.title}" >
			<span>${vo.title}</span>
			<input class="hide" type="text" name="title" value="${vo.title}" />
		</td>
		<td class="content editable" title="${vo.content}" >
			<span>${vo.content}</span>
			<input class="hide" type="text" name="content" value="${vo.content}" />
		</td>
		<td class="newsTypeId editable" title="${vo.newsTypeId}" >
			<span>${vo.newsTypeId}</span>
			<input class="hide" type="text" name="newsTypeId" value="${vo.newsTypeId}" />
		</td>
		
		<td class="hide id-holder" >
			<input type="hidden" class="id-column" name="Id" value="${vo.id }" />
		</td>
	</tr>
	</c:forEach>
</table>