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

import schoolmanagement.dto.Student;
import schoolmanagement.dto.Teacher;

@WebServlet("/updatestudent")
public class Updatestudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String sid = req.getParameter("sid");
		String sname = req.getParameter("sname");
		String dob = req.getParameter("dob");
		String semail = req.getParameter("semail");
		String spassword = req.getParameter("spassword");
		
		Student s = new Student();
		s.setId(Integer.parseInt(sid));
		s.setName(sname);
		s.setDob(dob);
		s.setEmail(semail);
		s.setPassword(spassword);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		
		et.begin();
		em.merge(s);
		et.commit();
		
		
		
		RequestDispatcher rd = req.getRequestDispatcher("Studentoption.html");
		rd.forward(req, resp);
		
	}
	

}
