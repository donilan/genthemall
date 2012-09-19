<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
	<head>
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
			<div id="top-wrapper">
				<div id="top-manu">
					<ul>
						<li>index</li>
					</ul>
				</div>
			</div>
			<div id="middle-wrapper"></div>
			<div id="bottom-wrapper"></div>
		</div>
	</body>
</html>