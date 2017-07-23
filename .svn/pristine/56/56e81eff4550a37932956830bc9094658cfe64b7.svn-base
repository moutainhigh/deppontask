<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
	<title>Bootstrap响应式登录界面模板</title>
    <!-- Bootstrap core CSS -->
    <link href="/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/assets/css/plugins/select/bootstrap-select.min.css" rel="stylesheet">
	<script src="/assets/js/jquery-2.1.1.js"></script>
	<script src="/assets/js/bootstrap.min.js"></script>
	<link href="/assets/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
	<script src="/assets/js/plugins/sweetalert/sweetalert.min.js"></script>
	
  </head>
<style type="text/css">
html,body {
	height: 100%;
}
.box {
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#6699FF', endColorstr='#6699FF'); /*  IE */
	background-image:linear-gradient(bottom, #F3F3F5 0%, #F3F3F5 100%);
	background-image:-o-linear-gradient(bottom, #F3F3F5 0%, #F3F3F5 100%);
	background-image:-moz-linear-gradient(bottom, #F3F3F5 0%,#F3F3F5 100%);
	background-image:-webkit-linear-gradient(bottom, #F3F3F5 0%, #F3F3F5 100%);
	background-image:-ms-linear-gradient(bottom,#F3F3F5 0%, #F3F3F5 100%);
	margin: 0 auto;
	position: relative;
	width: 100%;
	height: 100%;
}
.login-box {
	width: 100%;
	max-width:500px;
	height: 400px;
	position: absolute;
	top: 50%;

	margin-top: -200px;
	/*设置负值，为要定位子盒子的一半高度*/
	
}
@media screen and (min-width:500px){
	.login-box {
		left: 50%;
		/*设置负值，为要定位子盒子的一半宽度*/
		margin-left: -250px;
	}
}	

.form {
	width: 100%;
	max-width:500px;
	height: 275px;
	margin: 25px auto 0px auto;
	padding-top: 25px;
}	
.login-content {
	height: 300px;
	width: 100%;
	max-width:500px;
	background-color: rgba(255, 250, 2550, .6);
	float: left;
}		
	
	
.input-group {
	margin: 0px 0px 30px 0px !important;
}
.form-control,
.input-group {
	height: 40px;
}

.form-group {
	margin-bottom: 0px !important;
}
.login-title {
	padding: 20px 10px;
	background-color: rgba(0, 0, 0, .6);
}
.login-title h1 {
	margin-top: 10px !important;
}
.login-title small {
	color: #fff;
}

.link p {
	line-height: 20px;
	margin-top: 30px;
}
.btn-sm {
	padding: 8px 24px !important;
	font-size: 16px !important;
} 
</style>

</head>

<body>
<div class="box">
		<div class="login-box">
			<div class="login-title text-center">
				<h1><small>任务中心</small></h1>
			</div>
			<div class="login-content ">
			<div class="form">
			<form action="#" method="post"  id="form">
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
							<input type="text" id="userName" name="userName" class="form-control" placeholder="用户名">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input type="text" id="passWord" name="passWord" class="form-control" placeholder="密码">
						</div>
					</div>
				</div>
				<div class="form-group form-actions">
					<div class="col-xs-4 col-xs-offset-4 ">
						<button type="button" onclick="checklogin()" class="btn btn-sm btn-info">
							<span class="glyphicon glyphicon-off"></span> 
								登录
							<span class="glyphicon glyphicon-off"></span>
						</button>	
					</div>
				</div>
			</form>
			</div>
		</div>
	</div>
</div>
						

<script>

	function checklogin(){
		var params = {};
        $.each($('#form').parent().find(".form-control"), function () {
                var name = $(this).attr("name");
                var value = $(this).val().trim();
                params[name] = value;
        }); 	
         if (!params['userName']) {
        	 	sweetAlert("请输入用户名", "请输入用户名", "error");
                return;
        }
        if (!params['passWord']) {
                sweetAlert("请输入密码", "请输入密码", "error");
                return;
        }
        
        $.ajax({
        	async : false, 
            url: 'api/job-queue/login',
            type: 'POST',
            dataType: 'json',
            data: params,
            success: function (json) {
                if (json && json.success) {
                   var obj = eval(json);
                   var id=obj.userEntity.id;
                   var date = new Date();
                   date.setTime(date.getTime()+( 1000*60*60));
                   //将cookie保存5秒钟
                   setCookie("userName",obj.userEntity.userName,date.toGMTString());
                   setCookie("deptName",obj.userEntity.deptName,date.toGMTString());
                   setCookie("deptCode",obj.userEntity.deptCode,date.toGMTString());
                   setCookie("authority",obj.userEntity.authority,date.toGMTString());
                   window.location.href = "http://localhost:8081/index.htm";
                } else {
                    if (json) {
                        swal(json['msg']);
                    }
                }
            }
        });
   }
	 function setCookie(name,value,time ){
	        document.cookie=name+"="+encodeURI(value)+
	        ((time) ? "; time=" + time : "") ;
	        }
</script>	
</body>
</html>
