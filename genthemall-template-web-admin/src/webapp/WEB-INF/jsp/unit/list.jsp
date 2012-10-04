
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
		</tr>
	</thead>
	<c:forEach items="${unitList }" var="vo" varStatus="s">
	<tr class="${s.count % 2 eq 0 ? 'even' : 'odd' } ${s.first? 'first': s.last ? 'last': ''}">
		<td class="name editable" title="${vo.name}" >
			<span>${vo.name}</span>
			<input length="255" class="hide" type="text" name="name" value="${vo.name}" />
		</td>
		<td class="simplePinYinName editable" title="${vo.simplePinYinName}" >
			<span>${vo.simplePinYinName}</span>
			<input length="255" class="hide" type="text" name="simplePinYinName" value="${vo.simplePinYinName}" />
		</td>
		<td class="pinYinName editable" title="${vo.pinYinName}" >
			<span>${vo.pinYinName}</span>
			<input length="255" class="hide" type="text" name="pinYinName" value="${vo.pinYinName}" />
		</td>
		<td class="showOrder editable" title="${vo.showOrder}" >
			<span>${vo.showOrder}</span>
			<input length="11" class="hide" type="text" name="showOrder" value="${vo.showOrder}" />
		</td>
		<td class="unitTypeId editable" title="${vo.unitTypeId}" >
			<span>${vo.unitTypeId}</span>
			<input length="11" class="hide" type="text" name="unitTypeId" value="${vo.unitTypeId}" />
		</td>
		
		<td class="hide id-holder" >
			<input type="hidden" class="id-column" name="Id" value="${vo.id }" />
		</td>
	</tr>
	</c:forEach>
</table>