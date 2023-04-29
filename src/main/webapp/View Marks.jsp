<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="schoolmanagement.dto.Assignment"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
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

	<% Student s=(Student)session.getAttribute("student");
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("school");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		int sid = s.getId();
		String sname = s.getName();
		//Student s1=em.find(Student.class, s.getId());
		
		Query q= em.createQuery("select a from Assignment a where a.sid=?1");
		List<Assignment> ass=q.getResultList();
		q.setParameter(1, sid);
		
		List<Assignment> assignments=s1.getAssignment();	
	%>
	<table align="center" border="2" bordercolore="blue" cellpadding="20" style="background-color: yellow;">
						<caption style="color: red; font-size: xx-large; font-size-adjust: inherit; font-family: cursive; text-shadow: 2px 2px black ">Assignment Table</caption>
						<tr bgcolor="#DEB887">
							<th>Assignment Id</th>
							<th>Assignment Name</th>
							<th>Assignment Marks</th>
						</tr>
						<tr>
							<%for(Assignment a:assignments)
									
							{%>
							<tr>
								<td><%= a.getId()%></td>
								<td><%=a.getName() %></td>
								<td><%=a.getMarks() %></td>
							</tr>
							<%} %>
						</tr>						
					</table>
</body>
</html>