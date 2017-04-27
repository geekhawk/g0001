<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>编码规则表管理</title>
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
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sys/billcoder/">编码规则表列表</a></li>
		<li class="active"><a href="${ctx}/sys/billcoder/form?id=${billcoder.id}">编码规则表<shiro:hasPermission name="sys:billcoder:edit">${not empty billcoder.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:billcoder:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="billcoder" action="${ctx}/sys/billcoder/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	 
        <div class="control-group">
			<label class="control-label">编码：</label>
			<div class="controls">
				<form:input path="no" htmlEscape="false" maxlength="100" class="input-xlarge required  "/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		
			
		<div class="control-group">
			<label class="control-label">名称：</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">编码规则说明
			</label>
			<div class="controls">
				<span> 
			1.固定字符串{C:ABcD}将转换为ABcD,推荐使用字母与数字和特殊字符“-”“_”“·”,不推荐使用其他特殊字符与汉字 。  <br/>
			2.时间：{T:yyyy}当前四位年份,{T:yy}当前两位年份,{T:MM}当前月份,{T:dd}当前日期,{T:HH}当前小时数,{T:mm}当前分钟,{T:ss}当前秒。<br/>
			3.流水号，一个编码规则只支持一个流水号，{y,6}按年置0流水6位；流水号{M,6}按月置0流水6位；流水号{d,6}按日置0流水6位；流水号{N,6}置0流水6位。<br/> 
			4.推荐使用的编码规则。基础资料类：在数据量不大的情况下，推荐使用{C:ABcD},{N,8}样式。<br/>
			单据类：使用{C:ABcd},{T:yyyy}或{T:yy},{T:MM},{T:dd}{y,6}样式。<br/>
			5.关于编码的唯一性效验问题，建议使用数据库唯一键来进行约束。
			</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">编码规则：</label>
			<div class="controls">
				<form:textarea path="expression"   htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否唯一(1:是;0:否)：</label>
			<div class="controls">
				<form:input path="isunique" htmlEscape="false" maxlength="4" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">上次取出流水号时间：</label>
			<div class="controls">
				<input name="lastFlowDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${billcoder.lastFlowDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">递增量：</label>
			<div class="controls">
				<form:input path="increassment" htmlEscape="false" maxlength="10" class="input-xlarge required digits"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">当前流水号：</label>
			<div class="controls">
				<form:input path="currentFlowNo" htmlEscape="false" maxlength="20" class="input-xlarge required digits"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sys:billcoder:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>