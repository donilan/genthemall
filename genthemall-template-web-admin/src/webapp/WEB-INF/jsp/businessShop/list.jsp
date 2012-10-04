
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
		</tr>
	</thead>
	<c:forEach items="${businessShopList }" var="vo" varStatus="s">
	<tr class="${s.count % 2 eq 0 ? 'even' : 'odd' } ${s.first? 'first': s.last ? 'last': ''}">
		<td class="tmpName editable" title="${vo.tmpName}" >
			<span>${vo.tmpName}</span>
			<input length="255" class="hide" type="text" name="tmpName" value="${vo.tmpName}" />
		</td>
		<td class="shopId editable" title="${vo.shopId}" >
			<span>${vo.shopId}</span>
			<input length="11" class="hide" type="text" name="shopId" value="${vo.shopId}" />
		</td>
		
		<td class="hide id-holder" >
			
		</td>
	</tr>
	</c:forEach>
</table>