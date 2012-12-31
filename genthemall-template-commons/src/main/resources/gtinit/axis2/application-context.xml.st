<%/*
name="init-axis2-application-context"
type="resources"
overridable=false
description="Spring config."
path="application-context.xml"
version="0.1"
*/%><?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:aop="http://www.springframework.org/schema/aop"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="
		http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
        http://www.springframework.org/schema/context 
        http://www.springframework.org/schema/context/spring-context-3.0.xsd
        http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop.xsd">
	
	<context:component-scan base-package="com.ii2d" />
	<import resource="classpath:application-context-security.xml"/>
	<import resource="classpath:/com/ii2d/dbase/mybatis/applicationContext-mybatis.xml"/>

</beans>