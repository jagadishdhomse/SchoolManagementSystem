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

import schoolmanagement.dto.Assignment;
import schoolmanagement.dto.Student;
import schoolmanagement.dto.Teacher;

@WebServlet("/assign")
public class Addassignmentbys extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sid = req.getParameter("sid");
		String aid = req.getParameter("aid");
		String aname = req.getParameter("aname");
		String marks = req.getParameter("marks");
		
		Assignment a = new Assignment();
		
		a.setSid(Integer.parseInt(sid));
		a.setId(Integer.parseInt(aid));
		a.setName(aname);
		a.setMarks(Integer.parseInt(marks));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
//		Query q = em.createQuery("select a school a where a.email=1? and a.password=2? ");
		
		et.begin();
		em.persist(a);
	
		et.commit();
		
		
		
		RequestDispatcher rd = req.getRequestDispatcher("AddAssignmentandUpdate.html");
		rd.forward(req, resp);
		
	}

}
