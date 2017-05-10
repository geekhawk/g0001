<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>销售订单管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function()
	{

	});
	function page(n, s)
	{
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/qq/k3/seOrder/">销售订单列表</a></li>
		<shiro:hasPermission name="qq:k3:seOrder:edit">
			<li><a href="${ctx}/qq/k3/seOrder/form">销售订单添加</a></li>
			
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="seOrder" action="${ctx}/qq/k3/seOrder/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}" />
		<ul class="ul-form">
			<li><label>编码类似：</label> <form:input path="fbillNo" htmlEscape="false" maxlength="60" class="input-medium" /></li>
			<li><label>部门：</label> <form:select path="TDepartment.fitemId" class="input-small">
					<form:option value="" label="" />
					<form:option value="" label="" />
					<form:options items="${tDepartmentList}" itemLabel="fname" itemValue="fitemId" htmlEscape="false" />
				</form:select></li>
			<li><label>客户：</label> <form:select path="TOrganization.fitemId" class="input-large">
					<form:option value="" label="" />
					<form:option value="" label="" />
					<form:options items="${tOrganizationList}" itemLabel="fname" itemValue="fitemId" htmlEscape="false" />
				</form:select></li>
			<li><label>业务员：</label> <form:select path="TBaseEmp.fitemId" class="input-small">
					<form:option value="" label="" />
					<form:option value="" label="" />
					<form:options items="${tBaseEmpList}" itemLabel="fname" itemValue="fitemId" htmlEscape="false" />
				</form:select></li>


			<li><label>下单日期：</label> <input name="fBegindate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
				value="<fmt:formatDate value="${seOrder.fBegindate}" pattern="yyyy-MM-dd HH:mm:ss" type="both"/>"
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" /> - <input name="fEnddate" type="text" readonly="readonly" maxlength="20"
				class="input-medium Wdate required" value="<fmt:formatDate value="${seOrder.fEnddate}" pattern="yyyy-MM-dd HH:mm:ss" type="both"/>"
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" /></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" /></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}" />
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>编码</th>
				<th>部门</th>
				<th>客户</th>
				<th>业务员</th>
				<th>日期</th>
				<th>摘要</th>
				<th>制单人</th>
				<shiro:hasPermission name="qq:k3:seOrder:edit">
					<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="seOrder">
				<tr>
					<td><a href="${ctx}/qq/k3/seOrder/form?id= "> ${seOrder.fbillNo} </a></td>
					<td>${seOrder.TDepartment.fname}</td>
					<td>${seOrder.TOrganization.fname}</td>
					<td>${seOrder.TBaseEmp.fname}</td>
					<td>${seOrder.fdate}</td>
					<td>${seOrder.fnote}</td>
					<td>${seOrder.TBaseUser.fname}</td>
				 
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>