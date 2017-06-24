<#macro login_page>
<div class="modal fade" id="myModalLogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title text-center" id="myModalLabel">用户登录</h4>
            </div>
             <div class="alert alert-danger alert-dismissable hide input-sm" id="alert">
            <button type="button" class="close center-block" data-dismiss="alert"
                    aria-hidden="true">
                &times;
            </button><small id="error_massage" class="center-block"></small></div>
<div class="modal-body">
<form class="form-horizontal" role="form" action="${ctx}/login" method="post" id="form">
  <div class="form-group">
    <label for="username" class="col-sm-2 control-label">名字</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="userName" name="userName" placeholder="请输入名字">
    </div>
  </div>
  
  <div class="form-group">
    <label for="password" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码">
    </div>
  </div>
 
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
    
      <button type="submit" class="btn btn-default">登录</button>
    </div>
  </div>
</form>
</div>
</div>
</div>
</div>
</#macro>