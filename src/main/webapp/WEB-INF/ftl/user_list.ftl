<#macro user_list>
 <div class="media">
        <div class="pull-left">
            <a href="#"><img src="http://static.saraba1st.com/image/s1/folder_new.gif" class="img1" alt=""></a>
        </div>
        <div class="media-body">
				<table class="table table-striped">
				  <thead>
				    <tr>
				      <th>用户名</th>
				      <th>姓名</th>
				      <th>角色</th>
				      <th>处理</th>
				    </tr>
				  </thead>
				  <tbody>
				  <#list page.list as list_user>
				    <tr>
				      <td>${list_user.userName}</td>
				      <td>${list_user.nickName}</td>
				      <td>${list_user.role.name}</td>
				      <td><a href="${ctx}/permission/user/edit/${list_user.uuid}">编辑</a></td>
				    </tr>
				  </#list>
				  </tbody>
				</table>
        </div>
			<div class="divide mar-top-5"></div>
	</div>
</#macro>