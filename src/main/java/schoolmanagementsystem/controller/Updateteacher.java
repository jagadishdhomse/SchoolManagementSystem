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

import schoolmanagement.dto.Teacher;

@WebServlet("/updateteacher")
public class Updateteacher extends HttpServlet{
	@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		
		String tid = req.getParameter("tid");
		String tname = req.getParameter("tname");
		String tsubject = req.getParameter("tsubject");
		String tage = req.getParameter("tage");
		String temail = req.getParameter("temail");
		String tpassword = req.getParameter("tpassword");
		int id = Integer.parseInt(tid);
		
		Teacher t = new Teacher();
		 
		t.setId(id);
		t.setName(tname);
		t.setTsubject(tsubject);
		t.setAge(Integer.parseInt(tage));
		t.setEmail(temail);
		t.setPassword(tpassword);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		
		et.begin();
		em.merge(t);
		et.commit();
		
		
		
		RequestDispatcher rd = req.getRequestDispatcher("AddAssignmentandUpdate.html");
		rd.forward(req, resp);
		
	}

}
