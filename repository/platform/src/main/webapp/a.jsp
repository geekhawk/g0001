<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="org.springframework.web.context.support.*"%>
<%@page import="org.springframework.context.*"%>
<%@page import="org.springframework.web.context.support.*"%>
<%@page import="org.springframework.context.*"%>
<%@page import="com.tester.*"%>
<%@page import="com.tester.hibernate.*"%>
<%@page import="org.springframework.web.context.ContextLoader"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.qq.k3.seOrder.service.*"%>
<%@page import="com.qq.k3.seOrder.pojo.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<%
		    WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
			/*
			UserServiceHBT us = (UserServiceHBT) wac.getBean("userServiceHBT"); 
			UserInfoBean user = new UserInfoBean();
			//user.setNickName("1212");
			//user = us.findById("402880e45bd8c70f015bd8c770ef0001");
			user.setId("402880e45bd8c70f015bd8c770ef0001");
			user.setNickName("3");
			java.sql.Timestamp date = new java.sql.Timestamp(new Date().getTime());
			user.setDate(date);
			us.merge(user);
			us.saveOrUpdate(user);
			us.saveOrUpdate(user); 
			//out.println(us.findByExample(user).size());
  */
      SeorderService seorderService = (SeorderService) wac.getBean("seorderService"); 
  
			 
	%>
</body>
</html>
