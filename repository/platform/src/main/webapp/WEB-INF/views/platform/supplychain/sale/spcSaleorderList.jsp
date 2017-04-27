<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>销售订单管理</title>
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
		<li class="active"><a href="${ctx}/supplychain/sale/spcSaleorder/">销售订单列表</a></li>
		<shiro:hasPermission name="supplychain:sale:spcSaleorder:edit"><li><a href="${ctx}/supplychain/sale/spcSaleorder/form">销售订单添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="spcSaleorder" action="${ctx}/supplychain/sale/spcSaleorder/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>编码：</label>
				<form:input path="no" htmlEscape="false" maxlength="60" class="input-medium"/>
			</li>
			<li><label>客户：</label>
				<form:input path="customer.id" htmlEscape="false" maxlength="60" class="input-medium"/>
			</li>
			<li><label>下单日期：</label>
				<input name="beginOrderdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${spcSaleorder.beginOrderdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endOrderdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${spcSaleorder.endOrderdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>创建者：</label>
				<sys:treeselect id="createBy" name="createBy.id" value="${spcSaleorder.createBy.id}" labelName="createBy.name" labelValue="${spcSaleorder.createBy.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>创建时间：</label>
				<input name="beginCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${spcSaleorder.beginCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${spcSaleorder.endCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>更新者：</label>
				<sys:treeselect id="updateBy" name="updateBy.id" value="${spcSaleorder.updateBy.id}" labelName="updateBy.name" labelValue="${spcSaleorder.updateBy.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>删除标记（0：正常；1：删除）：</label>
				<form:radiobuttons path="delFlag" items="${fns:getDictList('del_flag')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>编码</th>
				<th>客户</th>
				<th>下单日期</th>
				<th>创建者</th>
				<th>创建时间</th>
				<th>更新者</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<th>删除标记（0：正常；1：删除）</th>
				<shiro:hasPermission name="supplychain:sale:spcSaleorder:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="spcSaleorder">
			<tr>
				<td><a href="${ctx}/supplychain/sale/spcSaleorder/form?id=${spcSaleorder.id}">
					${spcSaleorder.no}
				</a></td>
				<td>
					${spcSaleorder.customer.name}
				</td>
				<td>
					<fmt:formatDate value="${spcSaleorder.orderdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${spcSaleorder.createBy.name}
				</td>
				<td>
					<fmt:formatDate value="${spcSaleorder.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${spcSaleorder.updateBy.name}
				</td>
				<td>
					<fmt:formatDate value="${spcSaleorder.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${spcSaleorder.remarks}
				</td>
				<td>
					${fns:getDictLabel(spcSaleorder.delFlag, 'del_flag', '')}
				</td>
				<shiro:hasPermission name="supplychain:sale:spcSaleorder:edit"><td>
    				<a href="${ctx}/supplychain/sale/spcSaleorder/form?id=${spcSaleorder.id}">修改</a>
					<a href="${ctx}/supplychain/sale/spcSaleorder/delete?id=${spcSaleorder.id}" onclick="return confirmx('确认要删除该销售订单吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>