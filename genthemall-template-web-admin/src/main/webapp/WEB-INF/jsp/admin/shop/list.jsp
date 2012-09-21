<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table class="list-table" >
	<thead>
		<tr class="head">
			 
			<th>Name</th> 
			<th>ShowOrder</th> 
			<th>Address</th> 
			<th>Email</th> 
			<th>Fax</th> 
			<th>Phone</th> 
			<th>Telephone</th> 
			<th>ZipCode</th> 
			<th>Contact</th> 
			<th>Description</th> 
			<th>CreateDate</th> 
			<th>Deleted</th> 
			<th>Status</th> 
			<th>AreaId</th> 
			<th>UserId</th> 
			<th>ShopTypeId</th>
		</tr>
	</thead>
	<c:forEach items="${shopList }" var="vo" varStatus="s">
	<tr class="${s.count % 2 eq 0 ? 'even' : 'odd' } ${s.first? 'first': s.last ? 'last': ''}">
		<td class="name editable" title="${vo.name}" >
			<span>${vo.name}</span>
			<input class="hide" type="text" name="name" value="${vo.name}" />
		</td>
		<td class="showOrder editable" title="${vo.showOrder}" >
			<span>${vo.showOrder}</span>
			<input class="hide" type="text" name="showOrder" value="${vo.showOrder}" />
		</td>
		<td class="address editable" title="${vo.address}" >
			<span>${vo.address}</span>
			<input class="hide" type="text" name="address" value="${vo.address}" />
		</td>
		<td class="email editable" title="${vo.email}" >
			<span>${vo.email}</span>
			<input class="hide" type="text" name="email" value="${vo.email}" />
		</td>
		<td class="fax editable" title="${vo.fax}" >
			<span>${vo.fax}</span>
			<input class="hide" type="text" name="fax" value="${vo.fax}" />
		</td>
		<td class="phone editable" title="${vo.phone}" >
			<span>${vo.phone}</span>
			<input class="hide" type="text" name="phone" value="${vo.phone}" />
		</td>
		<td class="telephone editable" title="${vo.telephone}" >
			<span>${vo.telephone}</span>
			<input class="hide" type="text" name="telephone" value="${vo.telephone}" />
		</td>
		<td class="zipCode editable" title="${vo.zipCode}" >
			<span>${vo.zipCode}</span>
			<input class="hide" type="text" name="zipCode" value="${vo.zipCode}" />
		</td>
		<td class="contact editable" title="${vo.contact}" >
			<span>${vo.contact}</span>
			<input class="hide" type="text" name="contact" value="${vo.contact}" />
		</td>
		<td class="description editable" title="${vo.description}" >
			<span>${vo.description}</span>
			<input class="hide" type="text" name="description" value="${vo.description}" />
		</td>
		<td class="date createDate " title="<fmt:formatDate value="${vo.createDate}" pattern="yyyy-MM-dd HH:mm:ss" />" >
			<span><fmt:formatDate value="${vo.createDate}" pattern="yyyy-MM-dd" /></span>
			
		</td>
		<td class="deleted editable" title="${vo.deleted}" >
			<span>${vo.deleted}</span>
			<input class="hide" type="text" name="deleted" value="${vo.deleted}" />
		</td>
		<td class="status editable" title="${vo.status}" >
			<span>${vo.status}</span>
			<input class="hide" type="text" name="status" value="${vo.status}" />
		</td>
		<td class="areaId editable" title="${vo.areaId}" >
			<span>${vo.areaId}</span>
			<input class="hide" type="text" name="areaId" value="${vo.areaId}" />
		</td>
		<td class="userId editable" title="${vo.userId}" >
			<span>${vo.userId}</span>
			<input class="hide" type="text" name="userId" value="${vo.userId}" />
		</td>
		<td class="shopTypeId editable" title="${vo.shopTypeId}" >
			<span>${vo.shopTypeId}</span>
			<input class="hide" type="text" name="shopTypeId" value="${vo.shopTypeId}" />
		</td>
		
		<td class="hide id-holder" >
			<input type="hidden" class="id-column" name="Id" value="${vo.id }" />
		</td>
	</tr>
	</c:forEach>
</table>