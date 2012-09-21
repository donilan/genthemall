<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<script type="text/javascript">
	var contextPath = '<spring:url value="/" />';
</script>
	<link rel="stylesheet" type="text/css"
		href="<spring:url value="/resources/admin/css/yui-cssreset-3.7.0.css" />">
	<link rel="stylesheet" type="text/css"
		href="<spring:url value="/resources/admin/css/jquery-ui/ui-lightness/jquery-ui-1.8.23.custom.css" />">
	<link rel="stylesheet" type="text/css"
		href="<spring:url value="/resources/admin/css/default/style.css" />">
	<script type="text/javascript"
		src="<spring:url value="/resources/admin/js/jquery-1.8.1.js" />"></script>
	<script type="text/javascript"
		src="<spring:url value="/resources/admin/js/jquery-ui-1.8.23.custom.min.js" />"></script>
	<script type="text/javascript"
		src="<spring:url value="/resources/admin/js/application.js" />"></script>
	</head>
<body>
	<div id="main-wrapper">
		<div id="left-side"></div>
		<div id="right-side"></div>
		<div id="topbar-menu"></div>
	</div>
</body>
</html>