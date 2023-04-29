package schoolmanagementsystem.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
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

@WebServlet("/Teacher")
public class AddTeacher  extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String tid = req.getParameter("tid");
		String tname = req.getParameter("tname");
		String tsubject = req.getParameter("tsubject");
		String tage = req.getParameter("tage");
		String temail = req.getParameter("temail");
		String tpassword = req.getParameter("tpassword");
		
		Teacher t = new Teacher();
		t.setId(Integer.parseInt(tid));
		t.setName(tname);
		t.setTsubject(tsubject);
		t.setAge(Integer.parseInt(tage));
		t.setEmail(temail);
		t.setPassword(tpassword);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
//		Query q = em.createQuery("select a school a where a.email=1? and a.password=2? ");
		
		et.begin();
		em.persist(t);
		et.commit();
		
		
		
		RequestDispatcher rd = req.getRequestDispatcher("AddRemoveTeacherStudent.html");
		rd.forward(req, resp);
		
		
		
	}
}
