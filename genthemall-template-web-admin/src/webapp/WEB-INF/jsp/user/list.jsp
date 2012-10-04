
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
			<th>null</th> 
			<th>null</th> 
			<th>null</th>
		</tr>
	</thead>
	<c:forEach items="${userList }" var="vo" varStatus="s">
	<tr class="${s.count % 2 eq 0 ? 'even' : 'odd' } ${s.first? 'first': s.last ? 'last': ''}">
		<td class="name editable" title="${vo.name}" >
			<span>${vo.name}</span>
			<input length="40" class="hide" type="text" name="name" value="${vo.name}" />
		</td>
		<td class="address editable" title="${vo.address}" >
			<span>${vo.address}</span>
			<input length="255" class="hide" type="text" name="address" value="${vo.address}" />
		</td>
		<td class="areaCode editable" title="${vo.areaCode}" >
			<span>${vo.areaCode}</span>
			<input length="10" class="hide" type="text" name="areaCode" value="${vo.areaCode}" />
		</td>
		<td class="telephone editable" title="${vo.telephone}" >
			<span>${vo.telephone}</span>
			<input length="20" class="hide" type="text" name="telephone" value="${vo.telephone}" />
		</td>
		<td class="phone editable" title="${vo.phone}" >
			<span>${vo.phone}</span>
			<input length="20" class="hide" type="text" name="phone" value="${vo.phone}" />
		</td>
		<td class="zipCode editable" title="${vo.zipCode}" >
			<span>${vo.zipCode}</span>
			<input length="20" class="hide" type="text" name="zipCode" value="${vo.zipCode}" />
		</td>
		<td class="idCard editable" title="${vo.idCard}" >
			<span>${vo.idCard}</span>
			<input length="40" class="hide" type="text" name="idCard" value="${vo.idCard}" />
		</td>
		<td class="date createDate " title="<fmt:formatDate value="${vo.createDate}" pattern="yyyy-MM-dd HH:mm:ss" />" >
			<span><fmt:formatDate value="${vo.createDate}" pattern="yyyy-MM-dd" /></span>
			
		</td>
		<td class="status editable" title="${vo.status}" >
			<span>${vo.status}</span>
			<input length="11" class="hide" type="text" name="status" value="${vo.status}" />
		</td>
		<td class="password editable" title="${vo.password}" >
			<span>${vo.password}</span>
			<input length="40" class="hide" type="text" name="password" value="${vo.password}" />
		</td>
		<td class="loginId editable" title="${vo.loginId}" >
			<span>${vo.loginId}</span>
			<input length="30" class="hide" type="text" name="loginId" value="${vo.loginId}" />
		</td>
		<td class="userTypeId editable" title="${vo.userTypeId}" >
			<span>${vo.userTypeId}</span>
			<input length="11" class="hide" type="text" name="userTypeId" value="${vo.userTypeId}" />
		</td>
		
		<td class="hide id-holder" >
			<input type="hidden" class="id-column" name="Id" value="${vo.id }" />
		</td>
	</tr>
	</c:forEach>
</table>