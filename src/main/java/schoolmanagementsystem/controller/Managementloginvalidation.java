package schoolmanagementsystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import schoolmanagement.dto.Management;
import schoolmanagement.dto.Teacher;

@WebServlet("/check")
public class Managementloginvalidation extends HttpServlet{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

	String email = req.getParameter("email");
	String pass = req.getParameter("password");
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
	EntityManager em = emf.createEntityManager();
	
	Query q = em.createQuery("select a from Management a where a.Email=?1 and a.Pass = ?2");
	
	q.setParameter(1, email);
	q.setParameter(2, pass);
	
	List<Management> management = q.getResultList();
	if(management.size()>0)
	{
		RequestDispatcher rd = req.getRequestDispatcher("AddManagement.html");
		rd.forward(req, resp);
		
	}
	else
	{
		PrintWriter pw = resp.getWriter();
		pw.write("Invalid credential");
		
		RequestDispatcher rd = req.getRequestDispatcher("Login.html");
		rd.forward(req, resp);
		rd.include(req, resp);
	}

}
}
