<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" media="screen" />
 <script type="text/javascript" src="<%=request.getContextPath()%>/libraries/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/libraries/js/jquery.validate.min.js"></script>
<title>BT3</title>

</head>
<body>
<!-- Start Validate -->
	<script type="text/javascript">
			$().ready(function(){
				$("#frmLogin").validate({
					rules:{
						username : {
							required:true,
							
						},
						password: {
							required:true,
						}
						
					},
					messages:{
						username:{
							required:"Vui nhập nhập username",
						
						},
						password:{
							required:"Vui nhập nhập password",
						
						}
						
					}
				});
			});
		</script>  
<!-- End Validate -->
	<div>
		<form action="<%=request.getContextPath() %>/login" method="POST" id="frmLogin" >
			
			<div class="title">
				<h2>Login</h2>
			</div>
			<div class="main">
				<div class="nhat">
					Tên đăng nhập: 
					<input type="text" name="username" value="<%if(request.getParameter("username")!=null){ %><%=request.getParameter("usename") %><%} %>"  class="ds" />
				</div >
					<div class="nhat">
					Mật khẩu: 
					<input type="text" name="password" value="<%if(request.getParameter("password")!=null){ %><%=request.getParameter("password") %><%} %>"  class="ds"  />
				</div>
				<div class="duoi">
					<input type="submit" name="submit" value="Đăng nhập" class="sub">
				</div>
			</div>
		</form>
	</div>
</body>
</html>