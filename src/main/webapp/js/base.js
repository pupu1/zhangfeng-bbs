 $(function () {
	 
        $("#form").submit(function () {
            var userName = $("#userName");
            var password = $("#password");
            if (userName.val()==null||userName.val().length == 0) {
            	$("#alert").removeClass("hide");
            	$("#error_massage").html("用户名不能为空");
                userName.focus();
                return false;
            }
            if (password.val()==null||password.val().length == 0) {
            	$("#alert").removeClass("hide");
            	$("#error_massage").html("密码不能为空");
                password.focus();
                return false;
            }
        });
        
        	
        	$("#RuserName").blur(function(){
        	var userName = $("#RuserName").val();
       	 $.ajax({  
       		 		type: "POST",  
       	            data: "userName="+userName,  
       	            url: "./userNameCheck",  
       	            success: function(data) {
	       	                 if(data=="false"){
	       	                 $("#alert1").removeClass("hide");
	                   	$("#error_massage1").html("用户名重复");
	       	                 }  
	       	                 if(data=="true"){
	       	                	 $("#alert1").addClass("hide");
	       	                 }  
       	            }  
       	        });  
        });
        
        $("#registerForm").submit(function () {
        	var RuserName = $("#RuserName");
        	var nickName = $("#nickName");
        	var Rpassword = $("#Rpassword");
        	var emall = $("#emall");
        	var rePassword = $("#rePassword");
        	if (RuserName.val()==null||RuserName.val().length == 0) {
        		$("#alert1").removeClass("hide");
        		$("#error_massage1").html("用户名不能为空");
        		RuserName.focus();
        		return false;
        	}
        	if (nickName.val()==null||nickName.val().length == 0) {
        		$("#alert1").removeClass("hide");
        		$("#error_massage1").html("昵称不能为空");
        		nickName.focus();
        		return false;
        	}
        	if (Rpassword.val()==null||Rpassword.val().length == 0) {
        		$("#alert1").removeClass("hide");
        		$("#error_massage1").html("密码不能为空");
        		Rpassword.focus();
        		return false;
        	}
        	if (rePassword.val()==null||rePassword.val().length == 0||rePassword.val()!=Rpassword.val()) {
        		$("#alert1").removeClass("hide");
        		$("#error_massage1").html("密码必须相同");
        		rePassword.focus();
        		return false;
        	}
        	if (emall.val()==null||emall.val().length == 0) {
        		$("#alert1").removeClass("hide");
        		$("#error_massage1").html("邮箱不能为空");
        		emall.focus();
        		return false;
        	}
        });
        
        $('#summernote').summernote({  
        	lang : 'zh-CN',
			minHeight : 300, 
            callbacks: {  
                onImageUpload: function(files) { //the onImageUpload API  
                    img = sendFile(files[0]);  
            }  
        }  
        });  
      
    function sendFile(file) {  
        data = new FormData();  
        data.append("file", file);  
        console.log(data); 
       /* var path="<%=request.getcontextpath()%>"+"/upload";*/
        $.ajax({  
            data: data,  
            type: "POST",  
            url: "../../upload",  
            cache: false,  
            contentType: false,  
            processData: false,  
            success: function(url) {  
                  $("#summernote").summernote('insertImage', url); // the insertImage API  
            }  
        });  
        
      
    };
 $("#bbsformButton").click(function () {
	 var str = $('#summernote').summernote('code');
	 
	 $("#content").val(str);
	 $("#bbsform").submit();
 });
 });


