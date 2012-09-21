<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table class="list-table" >
	<thead>
		<tr class="head">
			 
			<th>AuthorizeStatus</th> 
			<th>CustomerName</th> 
			<th>CustomerNo</th> 
			<th>SignStatus</th> 
			<th>UserId</th>
		</tr>
	</thead>
	<c:forEach items="${userAbcInfoList }" var="vo" varStatus="s">
	<tr class="${s.count % 2 eq 0 ? 'even' : 'odd' } ${s.first? 'first': s.last ? 'last': ''}">
		<td class="authorizeStatus editable" title="${vo.authorizeStatus}" >
			<span>${vo.authorizeStatus}</span>
			<input length="11" class="hide" type="text" name="authorizeStatus" value="${vo.authorizeStatus}" />
		</td>
		<td class="customerName editable" title="${vo.customerName}" >
			<span>${vo.customerName}</span>
			<input length="20" class="hide" type="text" name="customerName" value="${vo.customerName}" />
		</td>
		<td class="customerNo editable" title="${vo.customerNo}" >
			<span>${vo.customerNo}</span>
			<input length="20" class="hide" type="text" name="customerNo" value="${vo.customerNo}" />
		</td>
		<td class="signStatus editable" title="${vo.signStatus}" >
			<span>${vo.signStatus}</span>
			<input length="11" class="hide" type="text" name="signStatus" value="${vo.signStatus}" />
		</td>
		<td class="userId editable" title="${vo.userId}" >
			<span>${vo.userId}</span>
			<input length="11" class="hide" type="text" name="userId" value="${vo.userId}" />
		</td>
		
		<td class="hide id-holder" >
			<input type="hidden" class="id-column" name="Id" value="${vo.id }" />
		</td>
	</tr>
	</c:forEach>
</table>