<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>物料信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/supplychain/base/spcCustomerBase/">物料信息列表</a></li>
		<shiro:hasPermission name="supplychain:base:spcCustomerBase:edit"><li><a href="${ctx}/supplychain/base/spcCustomerBase/form">物料信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="spcCustomerBase" action="${ctx}/supplychain/base/spcCustomerBase/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>营业执照编号：</label>
				<form:input path="no" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>业务代表：</label>
				<sys:treeselect id="saleperson" name="saleperson.id" value="${spcCustomerBase.saleperson.id}" labelName="saleperson.name" labelValue="${spcCustomerBase.saleperson.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>营业执照编号</th>
				<th>业务代表</th>
				<th>所在地</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="supplychain:base:spcCustomerBase:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="spcCustomerBase">
			<tr>
				<td><a href="${ctx}/supplychain/base/spcCustomerBase/form?id=${spcCustomerBase.id}">
					${spcCustomerBase.no}
				</a></td>
				<td>
					${spcCustomerBase.saleperson.name}
				</td>
				<td>
					${spcCustomerBase.area.name}
				</td>
				<td>
					<fmt:formatDate value="${spcCustomerBase.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${spcCustomerBase.remarks}
				</td>
				<shiro:hasPermission name="supplychain:base:spcCustomerBase:edit"><td>
    				<a href="${ctx}/supplychain/base/spcCustomerBase/form?id=${spcCustomerBase.id}">修改</a>
					<a href="${ctx}/supplychain/base/spcCustomerBase/delete?id=${spcCustomerBase.id}" onclick="return confirmx('确认要删除该物料信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>