
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
	<c:forEach items="${printmoduleList }" var="vo" varStatus="s">
	<tr class="${s.count % 2 eq 0 ? 'even' : 'odd' } ${s.first? 'first': s.last ? 'last': ''}">
		<td class="name editable" title="${vo.name}" >
			<span>${vo.name}</span>
			<input length="255" class="hide" type="text" name="name" value="${vo.name}" />
		</td>
		<td class="personname editable" title="${vo.personname}" >
			<span>${vo.personname}</span>
			<input length="255" class="hide" type="text" name="personname" value="${vo.personname}" />
		</td>
		<td class="lastmodtime editable" title="${vo.lastmodtime}" >
			<span>${vo.lastmodtime}</span>
			<input length="255" class="hide" type="text" name="lastmodtime" value="${vo.lastmodtime}" />
		</td>
		<td class="createtime editable" title="${vo.createtime}" >
			<span>${vo.createtime}</span>
			<input length="255" class="hide" type="text" name="createtime" value="${vo.createtime}" />
		</td>
		<td class="personid editable" title="${vo.personid}" >
			<span>${vo.personid}</span>
			<input length="255" class="hide" type="text" name="personid" value="${vo.personid}" />
		</td>
		<td class="flgdeleted editable" title="${vo.flgdeleted}" >
			<span>${vo.flgdeleted}</span>
			<input length="255" class="hide" type="text" name="flgdeleted" value="${vo.flgdeleted}" />
		</td>
		<td class="deletepersonname editable" title="${vo.deletepersonname}" >
			<span>${vo.deletepersonname}</span>
			<input length="255" class="hide" type="text" name="deletepersonname" value="${vo.deletepersonname}" />
		</td>
		<td class="deletepersonid editable" title="${vo.deletepersonid}" >
			<span>${vo.deletepersonid}</span>
			<input length="255" class="hide" type="text" name="deletepersonid" value="${vo.deletepersonid}" />
		</td>
		<td class="deletetime editable" title="${vo.deletetime}" >
			<span>${vo.deletetime}</span>
			<input length="255" class="hide" type="text" name="deletetime" value="${vo.deletetime}" />
		</td>
		<td class="code editable" title="${vo.code}" >
			<span>${vo.code}</span>
			<input length="255" class="hide" type="text" name="code" value="${vo.code}" />
		</td>
		<td class="showorder editable" title="${vo.showorder}" >
			<span>${vo.showorder}</span>
			<input length="255" class="hide" type="text" name="showorder" value="${vo.showorder}" />
		</td>
		<td class="memo editable" title="${vo.memo}" >
			<span>${vo.memo}</span>
			<input length="255" class="hide" type="text" name="memo" value="${vo.memo}" />
		</td>
		
		<td class="hide id-holder" >
			<input type="hidden" class="id-column" name="Id" value="${vo.id }" />
		</td>
	</tr>
	</c:forEach>
</table>