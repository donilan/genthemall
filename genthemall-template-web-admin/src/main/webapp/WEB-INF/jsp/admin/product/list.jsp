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
			<th>Description</th> 
			<th>CreateDate</th> 
			<th>Status</th> 
			<th>HnCode</th> 
			<th>UnitId</th> 
			<th>ShopId</th> 
			<th>OriginAreaId</th> 
			<th>ProductTypeId</th>
		</tr>
	</thead>
	<c:forEach items="${productList }" var="vo" varStatus="s">
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
			<input length="21845" class="hide" type="text" name="description" value="${vo.description}" />
		</td>
		<td class="date createDate " title="<fmt:formatDate value="${vo.createDate}" pattern="yyyy-MM-dd HH:mm:ss" />" >
			<span><fmt:formatDate value="${vo.createDate}" pattern="yyyy-MM-dd" /></span>
			
		</td>
		<td class="status editable" title="${vo.status}" >
			<span>${vo.status}</span>
			<input length="11" class="hide" type="text" name="status" value="${vo.status}" />
		</td>
		<td class="hnCode editable" title="${vo.hnCode}" >
			<span>${vo.hnCode}</span>
			<input length="255" class="hide" type="text" name="hnCode" value="${vo.hnCode}" />
		</td>
		<td class="unitId editable" title="${vo.unitId}" >
			<span>${vo.unitId}</span>
			<input length="11" class="hide" type="text" name="unitId" value="${vo.unitId}" />
		</td>
		<td class="shopId editable" title="${vo.shopId}" >
			<span>${vo.shopId}</span>
			<input length="11" class="hide" type="text" name="shopId" value="${vo.shopId}" />
		</td>
		<td class="originAreaId editable" title="${vo.originAreaId}" >
			<span>${vo.originAreaId}</span>
			<input length="11" class="hide" type="text" name="originAreaId" value="${vo.originAreaId}" />
		</td>
		<td class="productTypeId editable" title="${vo.productTypeId}" >
			<span>${vo.productTypeId}</span>
			<input length="11" class="hide" type="text" name="productTypeId" value="${vo.productTypeId}" />
		</td>
		
		<td class="hide id-holder" >
			<input type="hidden" class="id-column" name="Id" value="${vo.id }" />
		</td>
	</tr>
	</c:forEach>
</table>