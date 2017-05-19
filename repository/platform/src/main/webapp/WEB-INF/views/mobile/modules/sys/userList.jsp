<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<section id="user_section">
    <header>
        <nav class="left">
            <a href="#" data-icon="previous" data-target="back">返回</a>
        </nav>
        <h1 class="title">个人信息</h1> 
    </header>
    <article class="active">
    	<div style="line-height:50px;padding:10px;">
    		手机端功能开发完善中。<br/> 
    		如有好的建议，请联系 QQ:370782955  谢谢！<br/>
    	</div>
    	 
    </article>
    <script type="text/javascript">
	$('body').delegate('#user_section','pageinit',function(){
	});
	$('body').delegate('#user_section','pageshow',function(){
        var hash = J.Util.parseHash(location.hash);
        console.log(hash.param);
	});
	</script>
</section>