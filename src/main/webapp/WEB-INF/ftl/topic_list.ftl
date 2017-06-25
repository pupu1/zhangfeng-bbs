<#macro topic_list>
 <div class="media">
 	<#list page.list as topic>
        <div class="pull-left">
            <a href="/user/"><img src="http://static.saraba1st.com/image/s1/folder_new.gif" class="img1" alt=""></a>
        </div>
        <div class="media-body">
            <div class="title">
                <a href="${ctx}/topic/intoTopic/${topic.uuid}">${topic.title}</a>
            </div>
            <p class="gray" >
            	<#if topic.isTop>
                    <span class="label label-primary">置顶</span>
                <#elseif topic.isGood>
                    <span class="label label-success">精华</span>
                </#if>
                <span>${topic.tag}</span>
                <span>•</span>
                <span><a href="/user/">${topic.author}</a></span>
                <span class="hidden-sm hidden-xs">•</span>
                <span class="hidden-sm hidden-xs">${topic.viewCount}个回复</span>
                <span class="hidden-sm hidden-xs">•</span>
                <span class="hidden-sm hidden-xs">${topic.replyCount}次浏览</span>
                <span>•</span>
                <span>发布时间:${topic.inTimeView}</span>
                <#if topic.llastReplyName??>
                    <span>•</span>
                    <span>最后回复来自 <a href="/user/">${topic.llastReplyName}</a></span>
                 </#if>
                <#if user?? && user.type== 1>
                    <span class="pull-right">
                        <a href="/reply/edit?id=${topic.uuid}">编辑</a>
                        <a href="javascript:if(confirm('确定要删除吗？'))location.href='${ctx}/topic/delete/${topic.uuid}/${page.pageNum}'">删除</a>
                        <#if topic.isTop==false>
                        <a href="javascript:if(confirm('确定要置顶吗？'))location.href='${ctx}/topic/istop/true/${topic.uuid}/${page.pageNum}'">置顶</a>
                        <#else>
                        <a href="javascript:if(confirm('确定要不置顶吗？'))location.href='${ctx}/topic/istop/false/${topic.uuid}/${page.pageNum}'">不置顶</a>
                        </#if>
                        <#if topic.isGood==false>
                        <a href="javascript:if(confirm('确定要加精吗？'))location.href='${ctx}/topic/isgood/true/${topic.uuid}/${page.pageNum}'">加精</a>
                        <#else>
                        <a href="javascript:if(confirm('确定要不加精吗？'))location.href='${ctx}/topic/isgood/false/${topic.uuid}/${page.pageNum}'">不加精</a>
                        </#if>
					</span>
                 </#if>
                 
            </p>
        </div>
		<#if topic_has_next>
			<div class="divide mar-top-5"></div>
		</#if>
	</#list>
	</div>
</#macro>