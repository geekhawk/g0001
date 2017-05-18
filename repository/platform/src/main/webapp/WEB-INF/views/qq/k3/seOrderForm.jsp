<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>销售订单管理</title>
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
			$("#seorderEntries" + idx + "_fentryId").val(++seOrderEntryRowIdx); 
			compute();
		}
		function delRow(obj, prefix){
			var id = $(prefix+"_fdetailId");
			var delFlag = $(prefix+"_delFlag");
			if (id.val() == ""){
				$(obj).parent().parent().remove();
				seOrderEntryRowIdx--;
			}else if(delFlag.val() == "0"){
				delFlag.val("1");
				$(obj).html("&divide;").attr("title", "撤销删除");
				$(obj).parent().parent().addClass("error");
			 
			}else if(delFlag.val() == "1"){
				delFlag.val("0");
				$(obj).html("&times;").attr("title", "删除");
				$(obj).parent().parent().removeClass("error");
				 
			}
			
			compute();
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		 </ul><br/>
	<form:form id="inputForm" modelAttribute="seOrder" action="${ctx}/qq/k3/seOrder/save" method="post" class="form-horizontal">
		<form:hidden path="id.fbrNo"/>  <form:hidden path="id.finterId"/>   
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">编码：</label>
			<div class="controls">
				<form:input path="fbillNo" htmlEscape="false" maxlength="60" class="input-xlarge required"  />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		 
		
		<div class="control-group">
			<label class="control-label">客户：</label>
			<div class="controls">
				<form:select path="TOrganization.fitemId" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${tOrganizationList}" itemLabel="fname" itemValue="fitemId" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">交货地点：</label>
			<div class="controls">
				<form:input path="ffetchAdd" htmlEscape="false" maxlength="60" class="input-xlarge required"  />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">部门：</label>
			<div class="controls">
				<form:select path="TDepartment.fitemId" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${tDepartmentList}" itemLabel="fname" itemValue="fitemId" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		
		
		<div class="control-group">
			<label class="control-label">业务员：</label>
			<div class="controls">
				<form:select path="TBaseEmp.fitemId" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${tBaseEmpList}" itemLabel="fname" itemValue="fitemId" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">下单日期：</label>
			<div class="controls">
				<input name="fdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${seOrder.fdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		
		 
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="fexplanation" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div> 
			 <div class="">
					<table id="contentTable" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>#</th>
								<th>产品</th>
								<th>计量单位</th>
								<th>出库类型</th>
								<th>数量</th>
								<th>单价</th>
								<th>金额</th>
								<th>单位体积</th>
								<th>总体积</th>
							<!--  
								<th>单位重量</th>
								<th>总重量</th>--> 
								<th>外配</th>
								<th>外配总金额</th>
								<th>备注信息</th>
								<shiro:hasPermission name="qq:k3:seOrder:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="seorderEntries">
						</tbody>
						<shiro:hasPermission name="qq:k3:seOrder:edit"><tfoot>
							<tr><td colspan="13"><a href="javascript:" onclick="addRow('#seorderEntries', seOrderEntryRowIdx, seOrderEntryTpl); " class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="seOrderEntryTpl">//<!--
						<tr id="seorderEntries{{idx}}">
							<td class="hide">
								<input id="seorderEntries{{idx}}_fdetailId" name="seorderEntries[{{idx}}].fdetailId" type="hidden" value="{{row.fdetailId}}"/> 
                                <input id="seorderEntries{{idx}}_delFlag" name="seorderEntries[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
 <td>
<input id="seorderEntries{{idx}}_fentryId" name="seorderEntries[{{idx}}].fentryId" style="width:20px" type="text" value="{{row.fentryId}}"  readonly="true"   class="input-mini required number" onChange="compute();"/>
 							</td>
                            <td>
								<sys:treeselectSyn id="seorderEntries{{idx}}_ticitemCore" 
name="seorderEntries[{{idx}}].ticitemCore.fitemId" 
value="{{row.ticitemCore.fitemId}}" 
labelName="seorderEntries{{idx}}.ticitemCore.fname" 
labelValue="{{row.ticitemCore.fname}}" 
parentIds="" 
urlSyn="/qq/k3/tItem/treeDataSyn"
title="选择产品" 
url="/qq/k3/tItem/treeData" 
cssClass="required" 
allowClear="true" 
notAllowSelectParent="true"  
onChange=" getMaterialInfo($(seorderEntries{{idx}}_ticitemCoreId).val(),{{idx}});" 
/>
							</td>
							<td>
	<select id="seorderEntries{{idx}}_tmeasureUnit" name="seorderEntries[{{idx}}].tmeasureUnit.fmeasureUnitId" data-value="{{row.tmeasureUnit.fmeasureUnitId}}" class="input-mini required">
									<option value=""></option>  
									<c:forEach items="${tMeasureUnitList}"  var="tMeasureUnit" >
										<option value="${tMeasureUnit.fmeasureUnitId}">${tMeasureUnit.fname}</option>
									</c:forEach>
								</select>
							</td>

							<td>
	<select id="seorderEntries{{idx}}_fentrySelfS0164" name="seorderEntries[{{idx}}].fentrySelfS0164" data-value="{{row.fentrySelfS0164}}" class="input-mini required">
									<option value=""></option> 
									<c:forEach items="${fns:getDictList('K3chukuleixing')}"  var="dict" >
										<option value="${dict.value}">${dict.label}</option>
									</c:forEach>
								</select>
 
							</td>
							<td>
								<input id="seorderEntries{{idx}}_fqty" name="seorderEntries[{{idx}}].fqty" type="text" value="{{row.fqty}}" class="input-mini required number" onChange="compute();"/>
							</td>
							<td>
								<input id="seorderEntries{{idx}}_fprice" name="seorderEntries[{{idx}}].fprice" type="text" value="{{row.fprice}}" class="input-small required number" onChange="compute();"/>
							</td>
							<td>
								<input id="seorderEntries{{idx}}_famount" name="seorderEntries[{{idx}}].famount" type="text" value="{{row.famount}}" class="input-small required number"  readonly="true" />
							</td>
							<td>
								<input id="seorderEntries{{idx}}_unitvolume" name="seorderEntries[{{idx}}].unitvolume" type="text" value="{{row.unitvolume}}" class="input-mini  number"  onChange="compute();"/>
							</td>
							<td>
								<input id="seorderEntries{{idx}}_fentrySelfS0161" name="seorderEntries[{{idx}}].fentrySelfS0161" type="text" value="{{row.fentrySelfS0161}}" class="input-small  number"  readonly="true"/>
							</td>
<!--
							<td>
								<input id="seorderEntries{{idx}}_unitweight" name="seorderEntries[{{idx}}].unitweight" type="text" value="{{row.unitweight}}" class="input-mini  number" onChange="compute();"  />
							</td>
							<td>
								<input id="seorderEntries{{idx}}_weight" name="seorderEntries[{{idx}}].weight" type="text" value="{{row.weight}}" class="input-small  number"  readonly="true"/>
							</td>
--> 
                              <td> 
                                <input id="seorderEntries{{idx}}_fentrySelfS0162" name="seorderEntries[{{idx}}].fentrySelfS0162" type="text" value="{{row.fentrySelfS0162}}" class="input-mini  number" onChange="compute();"  />
							</td>
							<td>
								<input id="seorderEntries{{idx}}_fentrySelfS0163" name="seorderEntries[{{idx}}].fentrySelfS0163" type="text" value="{{row.fentrySelfS0163}}" class="input-small  number"  readonly="true"/>
							</td>
							<td>
								<textarea id="seorderEntries{{idx}}_fnote" name="seorderEntries[{{idx}}].fnote" rows="1" maxlength="255" class="input-small ">{{row.fnote}}</textarea>
							</td>
							<shiro:hasPermission name="qq:k3:seOrder:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#seorderEntries{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						
						var seOrderEntryRowIdx = 0, seOrderEntryTpl = $("#seOrderEntryTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
						$(document).ready(function()
						{
							var data = ${fns:toJson(seOrder.seorderEntries)};
							for (var i = 0; i < data.length; i++)
							{
								addRow('#seorderEntries', seOrderEntryRowIdx, seOrderEntryTpl, data[i]);

							}
							compute();
						});

						function compute()
						{
							var totalAmount = 0;
							var totalVolume = 0;
							var totalWaipei = 0;
							for (var i = 0; i < seOrderEntryRowIdx; i++)
							{
								//行金额计算
								var amount = $("#seorderEntries" + i + "_fqty").val() * $("#seorderEntries" + i + "_fprice").val()
								$("#seorderEntries" + i + "_famount").val(amount.toFixed(4));
								totalAmount += amount;

								//行体积计算
								var volume = $("#seorderEntries" + i + "_fqty").val() * $("#seorderEntries" + i + "_unitvolume").val()
								$("#seorderEntries" + i + "_fentrySelfS0161").val(volume.toFixed(4));
								totalVolume += volume;

								//行重量计算
								var weight = $("#seorderEntries" + i + "_fqty").val() * $("#seorderEntries" + i + "_fentrySelfS0162").val()
								$("#seorderEntries" + i + "_fentrySelfS0163").val(weight.toFixed(4));
								totalWaipei += weight;

							}
							// $("#totalamount").val(totalAmount.toFixed(4));
							// $("#totalvolume").val(totalVolume.toFixed(4));
							// $("#fentrySelfS0163").val(totalWaipei.toFixed(4));
						}

						//选取物料时从后台获取物料信息
						function getMaterialInfo(fitemid, idx)
						{
							strs = {};
							strs['fitemid'] = fitemid;
							$.post("${ctx}/qq/k3/tItem/getIcitemInfo", strs, function(result)
							{
								$("#seorderEntries" + idx + "_fprice").val(result.price);
								$("#seorderEntries" + idx + "_unitvolume").val(result.volume);
								$("#seorderEntries" + idx + "_tmeasureUnit").val(result.measureUnit);
								compute();
							});

						}
					</script>
				</div>
			 
			 
				  
			 
		<div class="form-actions">
			<shiro:hasPermission name="qq:k3:seOrder:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" onClick="compute();" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>