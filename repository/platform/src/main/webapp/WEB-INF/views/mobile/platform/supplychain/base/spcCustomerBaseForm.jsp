<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>客户信息管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(
			function()
			{
				//$("#name").focus();
				$("#inputForm")
						.validate(
								{
									submitHandler : function(form)
									{
										loading('正在提交，请稍等...');
										form.submit();
									},
									errorContainer : "#messageBox",
									errorPlacement : function(error, element)
									{
										$("#messageBox").text("输入有误，请先更正。");
										if (element.is(":checkbox")
												|| element.is(":radio")
												|| element.parent().is(
														".input-append"))
										{
											error.appendTo(element.parent()
													.parent());
										} else
										{
											error.insertAfter(element);
										}
									}
								});
			});
	function addRow(list, idx, tpl, row)
	{
		$(list).append(Mustache.render(tpl,
		{
			idx : idx,
			delBtn : true,
			row : row
		}));
		$(list + idx).find("select").each(function()
		{
			$(this).val($(this).attr("data-value"));
		});
		$(list + idx).find("input[type='checkbox'], input[type='radio']").each(
				function()
				{
					var ss = $(this).attr("data-value").split(',');
					for (var i = 0; i < ss.length; i++)
					{
						if ($(this).val() == ss[i])
						{
							$(this).attr("checked", "checked");
						}
					}
				});
	}
	function delRow(obj, prefix)
	{
		var id = $(prefix + "_id");
		var delFlag = $(prefix + "_delFlag");
		if (id.val() == "")
		{
			$(obj).parent().parent().remove();
		} else if (delFlag.val() == "0")
		{
			delFlag.val("1");
			$(obj).html("&divide;").attr("title", "撤销删除");
			$(obj).parent().parent().addClass("error");
		} else if (delFlag.val() == "1")
		{
			delFlag.val("0");
			$(obj).html("&times;").attr("title", "删除");
			$(obj).parent().parent().removeClass("error");
		}
	}
</script>
 
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/supplychain/base/spcCustomerBase/">客户信息列表</a></li>
		<li class="active"><a
			href="${ctx}/supplychain/base/spcCustomerBase/form?id=${spcCustomerBase.id}">客户信息<shiro:hasPermission
					name="supplychain:base:spcCustomerBase:edit">${not empty spcCustomerBase.id?'修改':'添加'}</shiro:hasPermission>
				<shiro:lacksPermission name="supplychain:base:spcCustomerBase:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="spcCustomerBase"
		action="${ctx}/supplychain/base/spcCustomerBase/save" method="post"
		class="form-horizontal">
		<form:hidden path="id" />
		<sys:message content="${message}" />
		
		
		<%-- 可折叠fieldset--%>
		<fieldset>
			<legend>
				<a data-toggle="collapse" data-parent="#accordion"
					href="#collapseJibenxinxi"> 基本信息 </a>:
			</legend>
			<div id="collapseJibenxinxi" class="panel-collapse collapse in">
				<%-- 可折叠fieldset--%>


				<div class="control-group">
					<label class="control-label">营业执照编号：</label>
					<div class="controls">
						<form:input path="no" htmlEscape="false" maxlength="64"
							class="input-xlarge required" />
						<span class="help-inline"><font color="red">*</font> </span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">业务代表：</label>
					<div class="controls">
						<sys:treeselect id="saleperson" name="saleperson.id"
							value="${spcCustomerBase.saleperson.id}"
							labelName="saleperson.name"
							labelValue="${spcCustomerBase.saleperson.name}" title="用户"
							url="/sys/office/treeData?type=3" cssClass="required"
							allowClear="true" notAllowSelectParent="true" />
						<span class="help-inline"><font color="red">*</font> </span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">部门：</label>
					<div class="controls">
						<sys:treeselect id="office" name="office.id"
							value="${spcCustomerBase.office.id}" labelName="office.name"
							labelValue="${spcCustomerBase.office.name}" title="部门"
							url="/sys/office/treeData?type=2" cssClass="required"
							allowClear="true" notAllowSelectParent="true" />
						<span class="help-inline"><font color="red">*</font> </span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">所在地：</label>
					<div class="controls">
						<sys:treeselectSyn id="area" name="area.id"
							parentIds="${spcCustomerBase.area.parentIds}"
							value="${spcCustomerBase.area.id}" labelName="area.name"
							labelValue="${spcCustomerBase.area.name}" title="区域"
							url="/sys/area/treeData" urlSyn="/sys/area/treeDataSyn"
							cssClass="required" allowClear="true" notAllowSelectParent="true" />
						<span class="help-inline"><font color="red">*</font> </span>
					</div>
				</div>
                 <div class="control-group">
					<label class="control-label">地址：</label>
					<div class="controls">
						<form:input path="address" htmlEscape="false" maxlength="400"
							class="input-xlarge required" />
						<span class="help-inline"><font color="red">*</font> </span>
					</div>
				</div>

			</div>
		</fieldset>

<%-- 可折叠fieldset--%>
		<fieldset>
			<legend>
				<a data-toggle="collapse" data-parent="#accordion"
					href="#collapseLianxixinxi"> 联系信息 </a>:
			</legend>
			<div id="collapseLianxixinxi" class="panel-collapse collapse in">
				<%-- 可折叠fieldset--%>
				<div class="control-group">
					<label class="control-label">联系人：</label>
					<div class="controls">
						<form:input path="conPerson" htmlEscape="false" maxlength="64"
							class="input-xlarge " />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">联系人职务：</label>
					<div class="controls">
						<form:input path="conPersonPosition" htmlEscape="false"
							maxlength="64" class="input-xlarge " />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">办公电话：</label>
					<div class="controls">
						<form:input path="officePhone" htmlEscape="false" maxlength="64"
							class="input-xlarge " />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">手机：</label>
					<div class="controls">
						<form:input path="mobilePhone" htmlEscape="false" maxlength="64"
							class="input-xlarge " />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">传真：</label>
					<div class="controls">
						<form:input path="fax" htmlEscape="false" maxlength="64"
							class="input-xlarge " />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">email：</label>
					<div class="controls">
						<form:input path="email" htmlEscape="false" maxlength="64"
							class="input-xlarge " />
					</div>
				</div>
			</div>
		</fieldset>

		<%-- 可折叠fieldset--%>
		<fieldset>
			<legend>
				<a data-toggle="collapse" data-parent="#accordion"
					href="#collapseKaipiaoxinxi"> 开票信息 </a>:
			</legend>
			<div id="collapseKaipiaoxinxi" class="panel-collapse collapse in">
				<%-- 可折叠fieldset--%>
				  <div class="control-group">
						<label class="control-label">开票类型：</label>
						<div class="controls">
							<form:select path="invoiceType" class="input-xlarge ">
								<form:option value="" label="" />
								<form:options items="${fns:getDictList('invoiceType')}"
									itemLabel="label" itemValue="value" htmlEscape="false" />
							</form:select>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">税务登记号：</label>
						<div class="controls">
							<form:input path="taxNo" htmlEscape="false" maxlength="32"
								class="input-xlarge " />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">开户银行：</label>
						<div class="controls">
							<form:input path="taxBank" htmlEscape="false" maxlength="320"
								class="input-xlarge " />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">银行账号：</label>
						<div class="controls">
							<form:input path="taxBankNo" htmlEscape="false" maxlength="32"
								class="input-xlarge " />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">开票地址：</label>
						<div class="controls">
							<form:input path="taxAddress" htmlEscape="false" maxlength="320"
								class="input-xlarge " />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">开票电话：</label>
						<div class="controls">
							<form:input path="taxPhone" htmlEscape="false" maxlength="32"
								class="input-xlarge " />
						</div>
					</div>
			</div>
		</fieldset>

		<%-- 可折叠fieldset--%>
		<fieldset>
			<legend>
				<a data-toggle="collapse" data-parent="#accordion"
					href="#collapseQitaxinxi"> 其他信息 </a>:
			</legend>
			<div id="collapseQitaxinxi" class="panel-collapse collapse in">
				<%-- 可折叠fieldset--%>
				<div class="control-group">
					<label class="control-label">加入日期：</label>
					<div class="controls">
						<input name="inDate" type="text" readonly="readonly"
							maxlength="20" class="input-medium Wdate "
							value="<fmt:formatDate value="${spcCustomerBase.inDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" />
					</div>
				</div>
				 
					<div class="control-group">
						<label class="control-label">备注信息：</label>
						<div class="controls">
							<form:textarea path="remarks" htmlEscape="false" rows="4"
								maxlength="255" class="input-xxlarge " />
						</div>
					</div>
			</div>
		</fieldset>

		<%-- 可折叠fieldset--%>
		<fieldset>
			<legend>
				<a data-toggle="collapse" data-parent="#accordion"
					href="#collapsePerson">客户人员对应关系 </a>:
			</legend>
			<div id="collapsePerson" class="panel-collapse collapse in">
				<%-- 可折叠fieldset--%>
 
					<div class="control-group">

						<div class="controls">
							<table id="contentTable" style="width:60%"
								class="table table-striped table-bordered table-condensed">
								<thead>
									<tr>
										<th class="hide"></th>
										<th>人员</th>

										<shiro:hasPermission
											name="supplychain:base:spcCustomerBase:edit">
											<th style="width:10">&nbsp;</th>
										</shiro:hasPermission>
									</tr>
								</thead>
								<tbody id="spcCustomerPersonList">
								</tbody>
								<shiro:hasPermission
									name="supplychain:base:spcCustomerBase:edit">
									<tfoot>
										<tr>
											<td colspan="4"><a href="javascript:"
												onclick="addRow('#spcCustomerPersonList', spcCustomerPersonRowIdx, spcCustomerPersonTpl);spcCustomerPersonRowIdx = spcCustomerPersonRowIdx + 1;"
												class="btn">新增</a></td> 
										</tr>
									</tfoot>
								</shiro:hasPermission>
							</table>
							<script type="text/template" id="spcCustomerPersonTpl">//<!--
						<tr id="spcCustomerPersonList{{idx}}">
							<td class="hide">
								<input id="spcCustomerPersonList{{idx}}_id" name="spcCustomerPersonList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="spcCustomerPersonList{{idx}}_delFlag" name="spcCustomerPersonList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<sys:treeselect id="spcCustomerPersonList{{idx}}_person" name="spcCustomerPersonList[{{idx}}].person.id" value="{{row.person.id}}" labelName="spcCustomerPersonList{{idx}}.person.name" labelValue="{{row.person.name}}"
									title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
							</td>
							 
							<shiro:hasPermission name="supplychain:base:spcCustomerBase:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#spcCustomerPersonList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
							<script type="text/javascript">
								var spcCustomerPersonRowIdx = 0, spcCustomerPersonTpl = $( "#spcCustomerPersonTpl").html() .replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
								$(document)
										.ready(
												function()
												{
													var data = ${fns:toJson(spcCustomerBase.spcCustomerPersonList)};
													for (var i = 0; i < data.length; i++)
													{
														addRow(
																'#spcCustomerPersonList',
																spcCustomerPersonRowIdx,
																spcCustomerPersonTpl,
																data[i]);
														spcCustomerPersonRowIdx = spcCustomerPersonRowIdx + 1;
													}
												});
							</script>
						</div>
					</div>
					
			</div>
				</fieldset>
		<div class="form-actions">
			<shiro:hasPermission name="supplychain:base:spcCustomerBase:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit"
					value="保 存" />&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回"
				onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>