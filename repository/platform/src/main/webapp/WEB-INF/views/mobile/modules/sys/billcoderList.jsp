<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>编码规则表管理</title>
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
		<li class="active"><a href="${ctx}/sys/billcoder/">编码规则表列表</a></li>
		<shiro:hasPermission name="sys:billcoder:edit"><li><a href="${ctx}/sys/billcoder/form">编码规则表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="billcoder" action="${ctx}/sys/billcoder/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>编码：</label>
				<form:input path="no" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>编码规则：</label>
				<form:input path="expression" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>是否唯一(1:是;0:否)：</label>
				<form:input path="isunique" htmlEscape="false" maxlength="4" class="input-medium"/>
			</li>
			<li><label>上次取出流水号时间：</label>
				<input name="beginLastFlowDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${billcoder.beginLastFlowDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endLastFlowDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${billcoder.endLastFlowDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>递增量：</label>
				<form:input path="increassment" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li><label>当前流水号：</label>
				<form:input path="currentFlowNo" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>创建者：</label>
				<sys:treeselect id="createBy" name="createBy.id" value="${billcoder.createBy.id}" labelName="createBy.name" labelValue="${billcoder.createBy.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>创建时间：</label>
				<input name="beginCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${billcoder.beginCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${billcoder.endCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>更新者：</label>
				<sys:treeselect id="updateBy" name="updateBy.id" value="${billcoder.updateBy.id}" labelName="updateBy.name" labelValue="${billcoder.updateBy.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>更新时间：</label>
				<input name="beginUpdateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${billcoder.beginUpdateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endUpdateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${billcoder.endUpdateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>备注信息：</label>
				<form:input path="remarks" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>删除标记 ：</label>
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
				<th>名称</th>
				<th>编码规则</th>
				<th>是否唯一(1:是;0:否)</th>
				<th>上次取出流水号时间</th>
				<th>递增量</th>
				<th>当前流水号</th>
				<th>创建者</th>
				<th>创建时间</th>
				<th>更新者</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="sys:billcoder:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="billcoder">
			<tr>
				<td><a href="${ctx}/sys/billcoder/form?id=${billcoder.id}">
					${billcoder.no}
				</a></td>
				<td>
					${billcoder.name}
				</td>
				<td>
					${billcoder.expression}
				</td>
				<td>
					${billcoder.isunique}
				</td>
				<td>
					<fmt:formatDate value="${billcoder.lastFlowDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${billcoder.increassment}
				</td>
				<td>
					${billcoder.currentFlowNo}
				</td>
				<td>
					${billcoder.createBy.name}
				</td>
				<td>
					<fmt:formatDate value="${billcoder.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${billcoder.updateBy.name}
				</td>
				<td>
					<fmt:formatDate value="${billcoder.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${billcoder.remarks}
				</td>
				<shiro:hasPermission name="sys:billcoder:edit"><td>
    				<a href="${ctx}/sys/billcoder/form?id=${billcoder.id}">修改</a>
					<a href="${ctx}/sys/billcoder/delete?id=${billcoder.id}" onclick="return confirmx('确认要删除该编码规则表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>