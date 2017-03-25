<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>物料信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
		function addRow(list, idx, tpl, row){
			$(list).append(Mustache.render(tpl, {
				idx: idx, delBtn: true, row: row
			}));
			$(list+idx).find("select").each(function(){
				$(this).val($(this).attr("data-value"));
			});
			$(list+idx).find("input[type='checkbox'], input[type='radio']").each(function(){
				var ss = $(this).attr("data-value").split(',');
				for (var i=0; i<ss.length; i++){
					if($(this).val() == ss[i]){
						$(this).attr("checked","checked");
					}
				}
			});
		}
		function delRow(obj, prefix){
			var id = $(prefix+"_id");
			var delFlag = $(prefix+"_delFlag");
			if (id.val() == ""){
				$(obj).parent().parent().remove();
			}else if(delFlag.val() == "0"){
				delFlag.val("1");
				$(obj).html("&divide;").attr("title", "撤销删除");
				$(obj).parent().parent().addClass("error");
			}else if(delFlag.val() == "1"){
				delFlag.val("0");
				$(obj).html("&times;").attr("title", "删除");
				$(obj).parent().parent().removeClass("error");
			}
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/supplychain/base/spcMaterialBase/">物料信息列表</a></li>
		<li class="active"><a href="${ctx}/supplychain/base/spcMaterialBase/form?id=${spcMaterialBase.id}">物料信息<shiro:hasPermission name="supplychain:base:spcMaterialBase:edit">${not empty spcMaterialBase.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="supplychain:base:spcMaterialBase:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="spcMaterialBase" action="${ctx}/supplychain/base/spcMaterialBase/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">编码：</label>
			<div class="controls">
				<form:input path="no" htmlEscape="false" maxlength="240" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">名称：</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">规格：</label>
			<div class="controls">
				<form:input path="model" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">计量单位：</label>
			<div class="controls">
				<form:select path="mearureunit.id" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${spcMeasureunitList}" itemLabel="name" itemValue="id" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		
		
		<div class="control-group">
			<label class="control-label">基本分类：</label>
			<div class="controls">
				<sys:treeselect id="groupBase" name="groupBase.id" 
				value="${spcMaterialBase.groupBase.id}" labelName="groupBase.name" 
				labelValue="${spcMaterialBase.groupBase.name}"
					title="父级编号" url="/supplychain/base/spcMaterialGroupBase/treeData" 
					extId="${spcMaterialBase.id}" cssClass="" allowClear="true"/>
			
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		
		
		<div class="control-group">
			<label class="control-label">单价：</label>
			<div class="controls">
				<form:input path="price" htmlEscape="false" class="input-xlarge  number"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">长度：</label>
			<div class="controls">
				<form:input path="length" htmlEscape="false" class="input-xlarge  number"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">宽度：</label>
			<div class="controls">
				<form:input path="width" htmlEscape="false" class="input-xlarge  number"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">高度：</label>
			<div class="controls">
				<form:input path="height" htmlEscape="false" class="input-xlarge  number"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">净重：</label>
			<div class="controls">
				<form:input path="netweight" htmlEscape="false" class="input-xlarge  number"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">毛重：</label>
			<div class="controls">
				<form:input path="grossweight" htmlEscape="false" class="input-xlarge  number"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">加入日期：</label>
			<div class="controls">
				<input name="inDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${spcMaterialBase.inDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
			<div class="control-group">
				<label class="control-label">业务数据子表：</label>
				<div class="controls">
					<table id="contentTable" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>所属部门</th>
								<th>库存数量</th>
								<th>备注信息</th>
								<shiro:hasPermission name="supplychain:base:spcMaterialBase:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="spcMaterialInventoryList">
						</tbody>
						<shiro:hasPermission name="supplychain:base:spcMaterialBase:edit"><tfoot>
							<tr><td colspan="5"><a href="javascript:" onclick="addRow('#spcMaterialInventoryList', spcMaterialInventoryRowIdx, spcMaterialInventoryTpl);spcMaterialInventoryRowIdx = spcMaterialInventoryRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="spcMaterialInventoryTpl">//<!--
						<tr id="spcMaterialInventoryList{{idx}}">
							<td class="hide">
								<input id="spcMaterialInventoryList{{idx}}_id" name="spcMaterialInventoryList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="spcMaterialInventoryList{{idx}}_delFlag" name="spcMaterialInventoryList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<sys:treeselect id="spcMaterialInventoryList{{idx}}_office" name="spcMaterialInventoryList[{{idx}}].office.id" value="{{row.office.id}}" labelName="spcMaterialInventoryList{{idx}}.office.name" labelValue="{{row.office.name}}"
									title="部门" url="/sys/office/treeData?type=2" cssClass="" allowClear="true" notAllowSelectParent="true"/>
							</td>
							<td>
								<input id="spcMaterialInventoryList{{idx}}_qty" name="spcMaterialInventoryList[{{idx}}].qty" type="text" value="{{row.qty}}" class="input-small  number"/>
							</td>
							<td>
								<textarea id="spcMaterialInventoryList{{idx}}_remarks" name="spcMaterialInventoryList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="supplychain:base:spcMaterialBase:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#spcMaterialInventoryList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var spcMaterialInventoryRowIdx = 0, spcMaterialInventoryTpl = $("#spcMaterialInventoryTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(spcMaterialBase.spcMaterialInventoryList)};
							for (var i=0; i<data.length; i++){
								addRow('#spcMaterialInventoryList', spcMaterialInventoryRowIdx, spcMaterialInventoryTpl, data[i]);
								spcMaterialInventoryRowIdx = spcMaterialInventoryRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
		<div class="form-actions">
			<shiro:hasPermission name="supplychain:base:spcMaterialBase:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>