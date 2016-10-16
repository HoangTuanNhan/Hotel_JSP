<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BT1</title>
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" media="screen" />
 <script type="text/javascript" src="<%=request.getContextPath()%>/libraries/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/libraries/js/jquery.validate.min.js"></script>
<title>BT3</title>	

</head>
<body>
	<div>


		
	<form action="<%=request.getContextPath()%>/upload" method="post" enctype="multipart/form-data" id="frmLogin">
		
			<div class="title">
				<h2>Upload ảnh</h2>
			</div>
			<div class="main">
				<div class="nhat">
					Hình ảnh: 
					<input type="file" name="upload" value="<%if(request.getParameter("upload")!=null){ %><%=request.getParameter("upload") %><%} %>"  class="ds" required />
				</div>	
				
				<div class="duoi">
					<input type="submit" name="submit" value="Up hình" class="sub">
				</div>
				
			</div>
		</form>
			<%
	if (request.getAttribute("url") != null){
		String url = (String) request.getAttribute("url");
	%>
	<img src="<%=url%>" width="100px" alt="" />
	<% }%>
		
	
	</div>
</body>
</html>