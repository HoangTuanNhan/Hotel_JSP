<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hoàng Tuấn Nhân</title>
</head>
<body>
		<%
		String msg = request.getParameter("msg");
		if (msg != null) {
			out.print(msg);
		}
		
	%>
	<%
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		if ("admin".equals(username) && "123456".equals(password)) {
			out.print("Chào admin !");
		}
	
		
	%>

</body>
</html>