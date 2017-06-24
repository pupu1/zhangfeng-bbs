<#macro pages pageNum totalPage pagePath="">
<ul class="pagination">
<#if (totalPage>10) >
<#assign fristPage=totalPage-9/>
<#else>
<#assign fristPage=1/>
</#if>


    <li <#if pageNum==1 >class="disabled"</#if>><a href="${ctx}${pagePath}1">&laquo;&laquo;</a></li>
    <li <#if pageNum==1 >class="disabled"</#if>><a href="${ctx}${pagePath}${pageNum-1}">&laquo;</a></li>
    <#list fristPage..totalPage as page>
    <li <#if pageNum==page >class="active disabled"</#if>><a href="${ctx}${pagePath}${page}">${page}</a></li>
	</#list>
    <li <#if pageNum==totalPage >class="disabled"</#if>><a href="${ctx}${pagePath}${pageNum+1}">&raquo;</a></li>
    <li <#if pageNum==totalPage >class="disabled"</#if>><a href="${ctx}${pagePath}${totalPage}">&raquo;&raquo;</a></li>
</ul>
</#macro>