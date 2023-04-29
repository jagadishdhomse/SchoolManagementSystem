<%@page import="schoolmanagement.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
            Student s = (Student)session.getAttribute("student");
%>
<form action="updatestudent" method="post">
id :<input type="number" id="sid" value="<%= s.getId()%>" name="sid">
name of Student:<input type="text"  id="sname" value="<%= s.getName()%>" name="sname">
Date of Birth:  <input type="text" id="dob" value="<%=s.getDob() %>" name="dob">
email of student:<input type="email" id="semail" value="<%= s.getEmail()%>" name="semail">
password of student:<input type="hidden" id="spassword" value="<%= s.getPassword()%>" name="spassword">
<input type="submit">

</form>
</body>
</html>