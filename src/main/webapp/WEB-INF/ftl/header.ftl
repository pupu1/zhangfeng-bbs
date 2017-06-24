<#macro header>
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid length">
	
	<div class="navbar-header">
	
		<a class="navbar-brand" href="${ctx}/">小论坛</a>
	</div>
	<#if user??>
	<div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#">${user.nickName}</a></li>
			<li ><a href="#">个人中心</a></li>
			<li ><a href="${ctx}/topic/edit/edit">话题发布</a></li>
			<#if user.type==1>
			<li><a href="${ctx}/permission/">管理员入口</a></li>
			 </#if>
			<li><a href="${ctx}/logout">退出</a></li>
			<li><a href="#">更多</a></li>
		</ul>
	</div>
	<#else>
	<div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#" data-toggle="modal" data-target="#myModalRegister">注册</a></li>
			<li ><a href="#"  data-toggle="modal" data-target="#myModalLogin">登录</a></li>
			<li><a href="#">更多</a></li>
		</ul>
	</div>
	</#if>
	
	
	</div>
</nav>
</#macro>