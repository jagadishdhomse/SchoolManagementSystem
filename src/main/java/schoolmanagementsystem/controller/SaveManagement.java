package schoolmanagementsystem.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import schoolmanagement.dto.Management;

@WebServlet("/savemanagementdata")
public class SaveManagement extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	super.doPost(req, resp);
	
	String id =req.getParameter("id");
	String email = req.getParameter("email");
	String pass = req.getParameter("password");
	
	Management m = new Management();
	m.setId(Integer.parseInt(id));
	m.setEmail(email);
	m.setPassword(pass);
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	et.begin();
	em.persist(m);
	et.commit();
	
	RequestDispatcher rd = req.getRequestDispatcher("Login.html");
	rd.forward(req, resp);
}
}
