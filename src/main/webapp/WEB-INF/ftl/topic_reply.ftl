 <#include "./layout.ftl"/>
 <@index>
 <div class="panel panel-default length"> 
	<div class="panel-body">
		<div class="media">
                    <div class="media-body">
                        <h2 class="topic-detail-title">${topic.title}</h2>
                        <p class="gray">
                        	<#if topic.isTop>
                                <span class="label label-primary">置顶</span>
                                <span>•</span>
                            <#elseif topic.isGood>
                                <span class="label label-success">精华</span>
                                <span>•</span>
                            </#if>
                            <span><a href="#">${topic.author}</a></span>
                            <span>•</span>
                            <span>发布时间:${topic.inTimeView}</span>
                            <span>•</span>
                            <span>${topic.replyCount}次浏览</span>
                            <span>•</span>
                            <span>${topic.viewCount}个回复</span>
                            <span>•</span>
                            <span>来自 <a href="#">所属分类</a></span>
                            
                        </p>
                    </div>
                    <div class="media-right">
                        <img src="http://static.saraba1st.com/image/s1/folder_new.gif" class="img2" alt="">
                    </div>
		</div>
	</div>
    <div class="divide "></div>
	<div class="panel-body">
    	${topic.content}
	</div>
	<div class="divide"></div>
	<div class="panel-footer">
		<#if collect??>
			<a href="${ctx}/collect/delete/${topic.uuid}/${page.pageNum}">取消收藏</a>
		<#else>
			<a href="${ctx}/collect/add/${topic.uuid}/${page.pageNum}">加入收藏</a>
		</#if>			
		<span id="collect" class="pull-right">${collectCount!0}个收藏</span>
	</div>
</div>


<div class="panel panel-default length">
	<#if topic.replyCount == 0>
		<div class="panel-body text-center">目前暂无回复</div>
	<#else>
		<div class="panel-heading">${topic.replyCount} 条回复</div>
		<div class="panel-body">
         	<#include "./reply_list.ftl"/>
			<@reply_list />
			<#include "./page.ftl"/>
			<@pages  pageNum=page.pageNum totalPage=page.totalPage pagePath="/reply/${topic.uuid}/"/>       
		</div>
	</#if>
</div>

<#if user??>
	<div class="panel panel-default length">
		<#include "./edit.ftl"/>
		<@edit path="/reply/create">
		</@edit>
	</div>
</#if>
</@index>