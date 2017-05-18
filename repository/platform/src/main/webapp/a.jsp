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
<%@page import="com.qq.k3.seOrder.entity.*"%>
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
 		       /* 
 		        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
 	 	 		SeOrderService seorderService = (SeOrderService) wac.getBean("seorderService");
 	 	 		SeOrderId seorderId = new SeOrderId("0", 1152);
 	 	 		SeOrder order = seorderService.findById(seorderId);
 	 	 		seorderId = new SeOrderId("0", 1153);
 	 	 		order.setId(seorderId);
 	 	 		seorderService.add(order);
 	 	 		*/
 	 	 		com.qq.k3.seOrder.utils.SeOrderIdGenerator  gter = new com.qq.k3.seOrder.utils.SeOrderIdGenerator();
 	 	 		out.println(gter.generate());
 	 	 		
 	%>
</body>
</html>
