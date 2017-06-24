<#include "./layout.ftl"/>
<@index> 
<div class="panel panel-default length">
<div class="panel-heading">
	<ul class="nav nav-pills">
		<li <#if tab=='all'>class="active"</#if>><a href="${ctx}/tab/all">全部</a></li>
		<li <#if tab=='新闻'>class="active"</#if>><a href="${ctx}/tab/news">新闻</a></li>
		<li <#if tab=='动画'>class="active"</#if>><a href="${ctx}/tab/anime">动画</a></li>
		<li <#if tab=='游戏'>class="active"</#if>><a href="${ctx}/tab/game">游戏</a></li>
	</ul>
</div>
<div class="panel-body">
<#include "./topic_list.ftl"/>
<@topic_list/>
<#include "./page.ftl"/>
<@pages  pageNum=page.pageNum totalPage=page.totalPage pagePath="/tab/"+tab+"?pageNum="/>
</div>
</div>
</@index>