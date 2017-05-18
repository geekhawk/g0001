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
			 
			spcSaleorderEntryRowIdx++;
			compute();
		}
		function delRow(obj, prefix){
			var id = $(prefix+"_id");
			var delFlag = $(prefix+"_delFlag");
			if (id.val() == ""){
				$(obj).parent().parent().remove();
				spcSaleorderEntryRowIdx--;
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
		<li><a href="${ctx}/supplychain/sale/spcSaleorder/">销售订单列表</a></li>
		<li class="active"><a href="${ctx}/supplychain/sale/spcSaleorder/form?id=${spcSaleorder.id}">销售订单<shiro:hasPermission name="supplychain:sale:spcSaleorder:edit">${not empty spcSaleorder.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="supplychain:sale:spcSaleorder:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="spcSaleorder" action="${ctx}/supplychain/sale/spcSaleorder/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">编码：</label>
			<div class="controls">
				<form:input path="no" htmlEscape="false" maxlength="60" class="input-xlarge required" readonly="true"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		 
		
		<div class="control-group">
			<label class="control-label">客户：</label>
			<div class="controls">
				<form:select path="customer.id" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${spcCustomerBaseList}" itemLabel="name" itemValue="id" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">下单日期：</label>
			<div class="controls">
				<input name="orderdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${spcSaleorder.orderdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">合计金额：</label>
			<div class="controls">
				<form:input path="totalamount" htmlEscape="false" class="input-xlarge required number" readonly="true"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">合计体积：</label>
			<div class="controls">
				<form:input path="totalvolume" htmlEscape="false" class="input-xlarge required number" readonly="true"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">合计重量：</label>
			<div class="controls">
				<form:input path="totalweight" htmlEscape="false" class="input-xlarge required number" readonly="true"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
			 
			 
				<div class="">
					<table id="contentTable" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>产品</th>
								<th>计量单位</th>
								<th>是否赠品</th>
								<th>数量</th>
								<th>单价</th>
								<th>金额</th>
								<th>单位体积</th>
								<th>体积</th>
								<th>单位重量</th>
								<th>重量</th>
								<th>备注信息</th>
								<shiro:hasPermission name="supplychain:sale:spcSaleorder:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="spcSaleorderEntries">
						</tbody>
						<shiro:hasPermission name="supplychain:sale:spcSaleorder:edit"><tfoot>
							<tr><td colspan="13"><a href="javascript:" onclick="addRow('#spcSaleorderEntries', spcSaleorderEntryRowIdx, spcSaleorderEntryTpl); " class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="spcSaleorderEntryTpl">//<!--
						<tr id="spcSaleorderEntries{{idx}}">
							<td class="hide">
								<input id="spcSaleorderEntries{{idx}}_id" name="spcSaleorderEntries[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="spcSaleorderEntries{{idx}}_delFlag" name="spcSaleorderEntries[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<sys:treeselectSyn id="spcSaleorderEntries{{idx}}_material" 
name="spcSaleorderEntries[{{idx}}].material.id" 
value="{{row.material.id}}" 
labelName="spcSaleorderEntries{{idx}}.material.name" 
labelValue="{{row.material.name}}" 
parentIds="" 
urlSyn="/supplychain/base/spcMaterialBase/treeDataSyn"
title="选择产品" 
url="/supplychain/base/spcMaterialGroupBase/treeData" 
cssClass="required" 
allowClear="true" 
notAllowSelectParent="true" 
onChange="getMaterialInfo($(spcSaleorderEntries{{idx}}_materialId).val(),{{idx}});" 
/>
							</td>
							<td>
								<select id="spcSaleorderEntries{{idx}}_measureunit" name="spcSaleorderEntries[{{idx}}].measureunit.id" data-value="{{row.measureunit.id}}" class="input-small required">
									<option value=""></option>
									<c:forEach items="${spcMeasureunitList}"  var="measureunit" >
										<option value="${measureunit.id}">${measureunit.name}</option>
									</c:forEach>
								</select>
							</td>
							<td>
								<c:forEach items="${fns:getDictList('isgiftFLag')}" var="dict" varStatus="dictStatus">
									<span><input id="spcSaleorderEntries{{idx}}_isgift${dictStatus.index}" name="spcSaleorderEntries[{{idx}}].isgift" type="radio" value="${dict.value}" data-value="{{row.isgift}}"
 <c:if  test="${row.isgift==null&&dict.value=='0'}"> checked="checked"</c:if>  
>
                                            <label for="spcSaleorderEntries{{idx}}_isgift${dictStatus.index}">${dict.label}</label></span>
								</c:forEach>
							</td>
							<td>
								<input id="spcSaleorderEntries{{idx}}_qty" name="spcSaleorderEntries[{{idx}}].qty" type="text" value="{{row.qty}}" class="input-mini required number" onChange="compute();"/>
							</td>
							<td>
								<input id="spcSaleorderEntries{{idx}}_price" name="spcSaleorderEntries[{{idx}}].price" type="text" value="{{row.price}}" class="input-small required number" onChange="compute();"/>
							</td>
							<td>
								<input id="spcSaleorderEntries{{idx}}_amount" name="spcSaleorderEntries[{{idx}}].amount" type="text" value="{{row.amount}}" class="input-small required number"  readonly="true" />
							</td>
							<td>
								<input id="spcSaleorderEntries{{idx}}_unitvolume" name="spcSaleorderEntries[{{idx}}].unitvolume" type="text" value="{{row.unitvolume}}" class="input-mini  number"  onChange="compute();"/>
							</td>
							<td>
								<input id="spcSaleorderEntries{{idx}}_volume" name="spcSaleorderEntries[{{idx}}].volume" type="text" value="{{row.volume}}" class="input-small  number"  readonly="true"/>
							</td>
							<td>
								<input id="spcSaleorderEntries{{idx}}_unitweight" name="spcSaleorderEntries[{{idx}}].unitweight" type="text" value="{{row.unitweight}}" class="input-mini  number" onChange="compute();"  />
							</td>
							<td>
								<input id="spcSaleorderEntries{{idx}}_weight" name="spcSaleorderEntries[{{idx}}].weight" type="text" value="{{row.weight}}" class="input-small  number"  readonly="true"/>
							</td>
							<td>
								<textarea id="spcSaleorderEntries{{idx}}_remarks" name="spcSaleorderEntries[{{idx}}].remarks" rows="1" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="supplychain:sale:spcSaleorder:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#spcSaleorderEntries{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var spcSaleorderEntryRowIdx = 0, spcSaleorderEntryTpl = $("#spcSaleorderEntryTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(spcSaleorder.spcSaleorderEntries)};
							for (var i=0; i<data.length; i++){
								addRow('#spcSaleorderEntries', spcSaleorderEntryRowIdx, spcSaleorderEntryTpl, data[i]);
							 
							}compute();
						});
						
					 
						function compute()
						 {
						    var totalAmount = 0;
						    var totalVolume = 0;
						    var totalWeight = 0; 
						   for(var i=0;i<spcSaleorderEntryRowIdx;i++)
						  {
						   if( $("#spcSaleorderEntries"+i+"_delFlag").val()=="0")
						   {
						   
						  //行金额计算
						    var amount = $("#spcSaleorderEntries"+i+"_qty").val()* $("#spcSaleorderEntries"+i+"_price").val()
						    $("#spcSaleorderEntries"+i+"_amount").val(amount.toFixed(4));
						    totalAmount += amount;
						    
						    //行体积计算
						    var volume = $("#spcSaleorderEntries"+i+"_qty").val()* $("#spcSaleorderEntries"+i+"_unitvolume").val()
						    $("#spcSaleorderEntries"+i+"_volume").val(volume.toFixed(4));
						    totalVolume  +=  volume;
						    
						    //行重量计算
						    var weight = $("#spcSaleorderEntries"+i+"_qty").val()* $("#spcSaleorderEntries"+i+"_unitweight").val()
						    $("#spcSaleorderEntries"+i+"_weight").val(weight.toFixed(4));
						    totalWeight +=  weight;
						    }
						  }
						 $("#totalamount").val(totalAmount.toFixed(4));
						 $("#totalvolume").val(totalVolume.toFixed(4));
						 $("#totalweight").val(totalWeight.toFixed(4));
						}
						
						
						
						function getMaterialInfo(materialid,idx)
						{
							 
							strs = {};
							strs['materialid'] = materialid  ;

							$.post( "${ctx}/supplychain/base/spcMaterialBase/getMaterialInfo",
											strs, function(result)
											{  
											 
											  $("#spcSaleorderEntries"+idx+"_measureunit").val(result.mearureunit.id);
											  $("#spcSaleorderEntries"+idx+"_price").val(result.price);
											  $("#spcSaleorderEntries"+idx+"_unitvolume").val(result.volume);
											  $("#spcSaleorderEntries"+idx+"_unitweight").val(result.weight);
											    compute();
											});

						}
					</script>
				</div>
			 
		<div class="form-actions">
			<shiro:hasPermission name="supplychain:sale:spcSaleorder:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" onClick="compute();" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>