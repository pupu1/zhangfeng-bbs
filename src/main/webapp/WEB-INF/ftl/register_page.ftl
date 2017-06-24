<#macro register_page>
<div class="modal fade" id="myModalRegister" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title text-center" id="myModalLabel">用户注册</h4>
            </div>
             <div class="alert alert-danger alert-dismissable hide input-sm" id="alert1">
            <button type="button" class="close center-block" data-dismiss="alert"
                    aria-hidden="true">
                &times;
            </button><small id="error_massage1" class="center-block"></small></div>
<div class="modal-body">

<form class="form-horizontal" role="form" action="${ctx}/register" method="post" id="registerForm">

  <div class="form-group">
    <label for="username" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="RuserName" name="RuserName" placeholder="请输入用户名">
    </div>
  </div>
  
  <div class="form-group">
    <label for="username" class="col-sm-2 control-label">昵称</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入昵称">
    </div>
  </div>
  
  <div class="form-group">
    <label for="username" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="Rpassword" name="Rpassword" placeholder="请输入密码">
    </div>
  </div>
  
  <div class="form-group">
    <label for="username" class="col-sm-2 control-label">确认密码</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="rePassword" name="rePassword" placeholder="请再次密码">
    </div>
  </div>
  
  <div class="form-group">
    <label for="username" class="col-sm-2 control-label">邮箱</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="emall" name="emall" placeholder="请输入邮箱">
    </div>
  </div>
  
  <div class="form-group">
    <label for="name">性别</label>
    <select class="form-control"  id="gender" name="gender" >
      <option value="0">男</option>
      <option value="1">女</option>
    </select>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
    
      <button type="submit" class="btn btn-default">注册</button>
    </div>
  </div>
  
</form>
</div>
</div>
</div>
</div>
</#macro>