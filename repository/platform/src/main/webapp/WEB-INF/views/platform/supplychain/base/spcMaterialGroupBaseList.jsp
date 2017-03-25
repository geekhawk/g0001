<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>物料基本分类管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treetable.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
			var tpl = $("#treeTableTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
			var data = ${fns:toJson(list)}, ids = [], rootIds = [];
			for (var i=0; i<data.length; i++){
				ids.push(data[i].id);
			}
			ids = ',' + ids.join(',') + ',';
			for (var i=0; i<data.length; i++){
				if (ids.indexOf(','+data[i].parentId+',') == -1){
					if ((','+rootIds.join(',')+',').indexOf(','+data[i].parentId+',') == -1){
						rootIds.push(data[i].parentId);
					}
				}
			}
			for (var i=0; i<rootIds.length; i++){
				addRow("#treeTableList", tpl, data, rootIds[i], true);
			}
			$("#treeTable").treeTable({expandLevel : 5});
		});
		function addRow(list, tpl, data, pid, root){
			for (var i=0; i<data.length; i++){
				var row = data[i];
				if ((${fns:jsGetVal('row.parentId')}) == pid){
					$(list).append(Mustache.render(tpl, {
						dict: {
							delFlag: getDictLabel(${fns:toJson(fns:getDictList('del_flag'))}, row.delFlag),
						blank123:0}, pid: (root?0:pid), row: row
					}));
					addRow(list, tpl, data, row.id);
				}
			}
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/supplychain/base/spcMaterialGroupBase/">物料基本分类列表</a></li>
		<shiro:hasPermission name="supplychain:base:spcMaterialGroupBase:edit"><li><a href="${ctx}/supplychain/base/spcMaterialGroupBase/form">物料基本分类添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="spcMaterialGroupBase" action="${ctx}/supplychain/base/spcMaterialGroupBase/" method="post" class="breadcrumb form-search">
		<ul class="ul-form">
			<li><label>编码：</label>
				<form:input path="no" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>父级编号：</label>
			</li>
		 
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>排序：</label>
				<form:input path="sort" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li><label>创建者：</label>
				<sys:treeselect id="createBy" name="createBy.id" value="${spcMaterialGroupBase.createBy.id}" labelName="createBy.name" labelValue="${spcMaterialGroupBase.createBy.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>创建时间：</label>
				<input name="beginCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${spcMaterialGroupBase.beginCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${spcMaterialGroupBase.endCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>更新者：</label>
				<sys:treeselect id="updateBy" name="updateBy.id" value="${spcMaterialGroupBase.updateBy.id}" labelName="updateBy.name" labelValue="${spcMaterialGroupBase.updateBy.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>更新时间：</label>
				<input name="beginUpdateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${spcMaterialGroupBase.beginUpdateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endUpdateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${spcMaterialGroupBase.endUpdateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>备注信息：</label>
				<form:input path="remarks" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>删除 ：</label>
				<form:radiobuttons path="delFlag" items="${fns:getDictList('del_flag')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="treeTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>编码</th>
				<th>父级编号</th>
			 
				<th>名称</th>
				<th>排序</th>
				<th>创建者</th>
				<th>创建时间</th>
				<th>更新者</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<th>删除标记（0：正常；1：删除）</th>
				<shiro:hasPermission name="supplychain:base:spcMaterialGroupBase:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody id="treeTableList"></tbody>
	</table>
	<script type="text/template" id="treeTableTpl">
		<tr id="{{row.id}}" pId="{{pid}}">
			<td><a href="${ctx}/supplychain/base/spcMaterialGroupBase/form?id={{row.id}}">
				{{row.no}}
			</a></td>
			<td>
				{{row.parent.id}}
			</td>
			 
			<td>
				{{row.name}}
			</td>
			<td>
				{{row.sort}}
			</td>
			<td>
				{{row.createBy.name}}
			</td>
			<td>
				{{row.createDate}}
			</td>
			<td>
				{{row.updateBy.name}}
			</td>
			<td>
				{{row.updateDate}}
			</td>
			<td>
				{{row.remarks}}
			</td>
			<td>
				{{dict.delFlag}}
			</td>
			<shiro:hasPermission name="supplychain:base:spcMaterialGroupBase:edit"><td>
   				<a href="${ctx}/supplychain/base/spcMaterialGroupBase/form?id={{row.id}}">修改</a>
				<a href="${ctx}/supplychain/base/spcMaterialGroupBase/delete?id={{row.id}}" onclick="return confirmx('确认要删除该物料基本分类及所有子物料基本分类吗？', this.href)">删除</a>
				<a href="${ctx}/supplychain/base/spcMaterialGroupBase/form?parent.id={{row.id}}">添加下级</a> 
			</td></shiro:hasPermission>
		</tr>
	</script>
</body>
</html>