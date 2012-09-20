<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<!--[if IE 8]>
<html xmlns="http://www.w3.org/1999/xhtml" class="ie8"  dir="ltr" lang="zh-CN">
<![endif]-->
<!--[if !(IE 8) ]><!-->
<html xmlns="http://www.w3.org/1999/xhtml"  dir="ltr" lang="zh-CN">
<!--<![endif]-->
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" href="<spring:url value="/css/yui-cssreset-3.7.0.css" />" type="text/css" >
	<link rel="stylesheet" href="<spring:url value="/css/default/style.css" />" type="text/css" >
	<link rel="stylesheet" href="<spring:url value="/css/ddsmoothmenu.css" />" type="text/css" >
	<script type="text/javascript">
	var contextPath = '<spring:url value="/" />';
	</script>
	<script type="text/javascript" src='<spring:url value="/js/jquery-1.8.1.js" />'></script>
	<script type="text/javascript" src='<spring:url value="/js/ddsmoothmenu-1.5.js" />'></script>
	<script type="text/javascript" src='<spring:url value="/js/application.js" />'></script>
</head>
<body>
	<div id="main-wrapper">
		
		<div id="middle-wrapper"></div>
	</div>
	<div id="admin-bar" style="position: fixed; width: 100%; height: 28px; z-index: 99999; background-color: #464646; color: #CCC; top:0; left: 0;">
		<div id="top-manu">
			<ul>
				<li>index</li>
			</ul>
		</div>
	</div>
</body>
</html>