<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>计量单位管理</title>
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
		<li class="active"><a href="${ctx}/supplychain/base/spcMeasureunit/">计量单位列表</a></li>
		<shiro:hasPermission name="supplychain:base:spcMeasureunit:edit"><li><a href="${ctx}/supplychain/base/spcMeasureunit/form">计量单位添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="spcMeasureunit" action="${ctx}/supplychain/base/spcMeasureunit/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		
		<li><label>编号：</label>
				<form:input path="no" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			 
			<li><label>加入日期：</label>
				<input name="inDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${spcMeasureunit.inDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>创建者：</label>
				<sys:treeselect id="createBy" name="createBy.id" value="${spcMeasureunit.createBy.id}" labelName="createBy.name" labelValue="${spcMeasureunit.createBy.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>创建时间：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${spcMeasureunit.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>更新者：</label>
				<sys:treeselect id="updateBy" name="updateBy.id" value="${spcMeasureunit.updateBy.id}" labelName="updateBy.name" labelValue="${spcMeasureunit.updateBy.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>更新时间：</label>
				<input name="updateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${spcMeasureunit.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>备注信息：</label>
				<form:input path="remarks" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>删除标记：</label>
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
				<th>名称</th>
				<th>编号</th>
				 
				<th>加入日期</th>
				<th>创建者</th>
				<th>创建时间</th>
				<th>更新者</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<th>删除标记（0：正常；1：删除）</th>
				<shiro:hasPermission name="supplychain:base:spcMeasureunit:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="spcMeasureunit">
			<tr>
				<td><a href="${ctx}/supplychain/base/spcMeasureunit/form?id=${spcMeasureunit.id}">
					${spcMeasureunit.name}
				</a></td>
				<td>
					${spcMeasureunit.no}
				</td>
				 
				<td>
					<fmt:formatDate value="${spcMeasureunit.inDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${spcMeasureunit.createBy.name}
				</td>
				<td>
					<fmt:formatDate value="${spcMeasureunit.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${spcMeasureunit.updateBy.name}
				</td>
				<td>
					<fmt:formatDate value="${spcMeasureunit.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${spcMeasureunit.remarks}
				</td>
				<td>
					${fns:getDictLabel(spcMeasureunit.delFlag, 'del_flag', '')}
				</td>
				<shiro:hasPermission name="supplychain:base:spcMeasureunit:edit"><td>
    				<a href="${ctx}/supplychain/base/spcMeasureunit/form?id=${spcMeasureunit.id}">修改</a>
					<a href="${ctx}/supplychain/base/spcMeasureunit/delete?id=${spcMeasureunit.id}" onclick="return confirmx('确认要删除该计量单位吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>