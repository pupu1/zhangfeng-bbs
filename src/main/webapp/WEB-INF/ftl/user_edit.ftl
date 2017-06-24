<#include "./layout.ftl"/>
<@index> 
<div class="panel panel-default length">
<div class="panel-heading">
	<ul class="nav nav-pills">
		<li <#if per_tab=='user'>class="active"</#if>><a href="${ctx}/permission/user/1">用户管理</a></li>
		<li <#if per_tab=='userEdit'>class="active"</#if>><a href="">用户编辑</a></li>
	</ul>
</div>
<div class="panel-body">
	<form class="form-horizontal" role="form" action="${ctx}/permission/userEdited" method="post" id="userEditForm">
		<div class="form-group">
			<label for="userName" >用户名</label>
		    	<div>
		      		<input type="text" class="form-control" id="userName" name="userName"value="${perUser.userName}" disabled>
		      		<input type="hidden" class="form-control" id="uuid" name="uuid" value="${perUser.uuid}">
				</div>
			<label for="nikeName" >昵称</label>
		    	<div>
		      		<input type="text" class="form-control" id="nickName" name="nickName" value="${perUser.nickName}" disabled>
				</div>
			<label for="role" >身份管理</label>
		    	<div>
		      		<select class="form-control" id="role" name="role">
		      			<#list roles as role>
					    	<option value="${role.id}" <#if role.id==perUser.type>selected="selected"</#if>>${role.name}</option>
						</#list>
					    </select>
				</div>
				<div>
				 	<button type="submit" class="btn btn-default">编辑</button>
				</div>
		</div>
	</form>  
</div>
</@index>