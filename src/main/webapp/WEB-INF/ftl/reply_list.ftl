<#macro reply_list>
 <div class="media">
 	<#list page.list as reply>
        <div class="pull-left">
            <a href="/user/"><img src="http://static.saraba1st.com/image/s1/folder_new.gif" class="img1" alt=""></a>
        </div>
        <div class="media-body">
            <p class="gray" >
                <span>•</span>
                <span><a href="/user/">${reply.author}</a></span>
                <span>•</span>
                <span>发布时间:${reply.inTimeView}</span>
                <span>•</span>
                <span class="strong">${page.pageNum*2-1+reply_index}楼</span>
                
            </p>
        </div>
        <div class="divide "></div>
                <div class="panel-body">
                	${reply.content}
                </div>
		<#if reply_has_next>
			<div class="divide mar-top-5"></div>
		</#if>
	</#list>
	</div>
</#macro>