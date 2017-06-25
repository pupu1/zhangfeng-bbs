<#include "./layout.ftl"/>
<@index> 
<div class="panel panel-default length">
<div class="panel-heading">
	<ul class="nav nav-pills">
		<li <#if per_tab=='user'>class="active"</#if>><a href="${ctx}/permission/user/1">用户管理</a></li>
		<li <#if per_tab=='permission'>class="active"</#if>><a href="${ctx}/permission/permissionPage">权限管理</a></li>
	</ul>
</div>
<div class="panel-body">
<#include "./user_list.ftl"/>
<@user_list/>
<#include "./page.ftl"/>
<@pages  pageNum=page.pageNum totalPage=page.totalPage pagePath="/permission/user/"/>
</div>
</div>
</@index>