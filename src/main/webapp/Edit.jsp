<%@page import="dto.Student"%>
<%@page import="dao.Studentdao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%int id=Integer.parseInt(request.getParameter("id")); %>

<%
Studentdao dao=new Studentdao();
Student student =dao.fetch(id);
%>
<form action="update" method="post">
Id:<input type="text" name="id" value="<%=student.getId() %>" readonly="readonly"><br>
Name:<input type="text" name="name" value="<%=student.getName() %>"><br>
Mobile:<input type="number" name="mobile" value="<%=student.getMobile() %>"><br>
Password:<input type="password" name="password" value="<%=student.getPassword() %>"><br>
Email:<input type="email" name="email" value="<%=student.getEmail() %>"><br>
<button type="reset">Cancel</button><button>Update</button>

</form>
</body>
</html>