<%@page import="schoolmanagement.dto.Teacher"%>
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
            Teacher t = (Teacher)session.getAttribute("teacher");
%>
<form action="updateteacher" method="post">
id : <input type="number" id="tid" value="<%=t.getId() %>" name="tid">
name:<input type="text" id="tname" value="<%= t.getName() %>" name="tname">
Subject:<input type="text" id="tsubject" value="<%= t.getTsubject()%>" name="tsubject">
age:<input type="number" id="tage" value="<%= t.getAge()%>" name="tage">
email:<input type="email" id="email" value="<%= t.getEmail()%>" name="temail">
password:<input type="hidden" id="tpassword" value="<%= t.getPassword()%>" name="tpassword">
<input type="submit">

</form>
</body>
</html>