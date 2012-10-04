
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
			<th>null</th> 
			<th>null</th>
		</tr>
	</thead>
	<c:forEach items="${productTypeList }" var="vo" varStatus="s">
	<tr class="${s.count % 2 eq 0 ? 'even' : 'odd' } ${s.first? 'first': s.last ? 'last': ''}">
		<td class="name editable" title="${vo.name}" >
			<span>${vo.name}</span>
			<input length="255" class="hide" type="text" name="name" value="${vo.name}" />
		</td>
		<td class="showOrder editable" title="${vo.showOrder}" >
			<span>${vo.showOrder}</span>
			<input length="11" class="hide" type="text" name="showOrder" value="${vo.showOrder}" />
		</td>
		<td class="description editable" title="${vo.description}" >
			<span>${vo.description}</span>
			<input length="1023" class="hide" type="text" name="description" value="${vo.description}" />
		</td>
		<td class="parentTreeCode editable" title="${vo.parentTreeCode}" >
			<span>${vo.parentTreeCode}</span>
			<input length="255" class="hide" type="text" name="parentTreeCode" value="${vo.parentTreeCode}" />
		</td>
		<td class="treeCode editable" title="${vo.treeCode}" >
			<span>${vo.treeCode}</span>
			<input length="255" class="hide" type="text" name="treeCode" value="${vo.treeCode}" />
		</td>
		<td class="status editable" title="${vo.status}" >
			<span>${vo.status}</span>
			<input length="11" class="hide" type="text" name="status" value="${vo.status}" />
		</td>
		<td class="date createDate " title="<fmt:formatDate value="${vo.createDate}" pattern="yyyy-MM-dd HH:mm:ss" />" >
			<span><fmt:formatDate value="${vo.createDate}" pattern="yyyy-MM-dd" /></span>
			
		</td>
		<td class="pinYinName editable" title="${vo.pinYinName}" >
			<span>${vo.pinYinName}</span>
			<input length="255" class="hide" type="text" name="pinYinName" value="${vo.pinYinName}" />
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