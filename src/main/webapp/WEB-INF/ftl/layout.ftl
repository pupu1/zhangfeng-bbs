<#macro index>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<title>主页</title>
	<#assign ctx=request.getContextPath()>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ctx}/css/base.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="${ctx}/js/base.js"></script>
	<link  rel="stylesheet" href="https://cdn.bootcss.com/summernote/0.8.4/summernote.css">
	<script src="http://cdn.bootcss.com/summernote/0.8.4/summernote.js"></script>
	<script src="${ctx}/js/summernote-zh-CN.js"></script>
</head>
<body>

<#include "./header.ftl">
<@header/>
<#include "./login_page.ftl">
<@login_page/>
<#include "./register_page.ftl">
<@register_page/>
<#nested />
</body>
</html>
</#macro>