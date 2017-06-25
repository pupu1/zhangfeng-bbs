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
	<div class="row">
		<div class="col-md-1 column">
		</div>
		<div class="col-md-10 column">
		<form class="form-horizontal" role="form" action="${ctx}${path}" method="post" id="bbsform">
		<div class="form-group">
		    <label for="role">角色</label>
		    <select class="form-control">
			    <#list roles as role>
			    	<option value="${role.id}">${role.name}</option>
			    </#list>
		    </select>
		    <label for="permission">权限</label>
				<div>
					<#list permissions as permission>
	 					<label class="checkbox-inline">
	   						 <input type="checkbox" id="${permission.name}" name="permission[]" value="${permission.id}">${permission.name}
	  					</label>
  					</#list>
		  		</div>
		  </div>
		</form>  
		</div>
		<div class="col-md-1 column"></div>
	</div>
</div>
</@index>