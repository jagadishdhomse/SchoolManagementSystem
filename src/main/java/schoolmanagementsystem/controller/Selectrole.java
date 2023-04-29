package schoolmanagementsystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import javax.servlet.http.HttpSession;

import schoolmanagement.dto.Management;
import schoolmanagement.dto.Student;
import schoolmanagement.dto.Teacher;

@WebServlet("/select")
public class Selectrole extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String role = req.getParameter("role");
		
		if(role.equals("management"))
		{
			String email = req.getParameter("email");
			String pass = req.getParameter("password");
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
			EntityManager em = emf.createEntityManager();
			
			Query q = em.createQuery("select a from Management a where a.email=?1 and a.password = ?2");
			
			q.setParameter(1, email);
			q.setParameter(2, pass);
			
			List<Management> management = q.getResultList();
			if(management.size()>0)
			{
				RequestDispatcher rd = req.getRequestDispatcher("AddRemoveTeacherStudent.html");
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
		else if(role.equals("teacher")) {
			
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
			EntityManager em = emf.createEntityManager();
		
			
			Query q = em.createQuery("select b from Teacher b where b.email=?1 and b.password = ?2");
			
			
			q.setParameter(1, email);
			q.setParameter(2, password);
			
			List<Teacher> teacher = q.getResultList();
			Teacher t1 = teacher.get(0);
			HttpSession hs = req.getSession();
			hs.setAttribute("teacher", t1);
			
			if(teacher.size()>0)
			{
				
				RequestDispatcher rd = req.getRequestDispatcher("AddAssignmentandUpdate.html");
				rd.forward(req, resp);
				
			}
			else
			{
				PrintWriter pw = resp.getWriter();
				pw.write("Invalid credential");
				
				RequestDispatcher rd = req.getRequestDispatcher("Login.html");
				rd.forward(req, resp);
				rd.include(req, resp);
				
				resp.setContentType("text/html");
			}

			
			
			
			//RequestDispatcher rd1 = req.getRequestDispatcher("Validationofteacher");
			//rd1.forward(req, resp);
			
			
				
		}
		else if(role.equals("student"))
			{
			
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
			EntityManager em = emf.createEntityManager();
		
			
			Query q = em.createQuery("select b from Student b where b.email=?1 and b.password = ?2");
			
			
			q.setParameter(1, email);
			q.setParameter(2, password);
			
			List<Student> student = q.getResultList();
			Student s1 = student.get(0);
			HttpSession hs = req.getSession();
			hs.setAttribute("student", s1);
			
			if(student.size()>0)
			{
				
				RequestDispatcher rd = req.getRequestDispatcher("Studentoption.html");
				rd.forward(req, resp);
				
			}
			else
			{
				PrintWriter pw = resp.getWriter();
				pw.write("Invalid credential");
				
				RequestDispatcher rd = req.getRequestDispatcher("Login.html");
				rd.forward(req, resp);
				rd.include(req, resp);
				
				resp.setContentType("text/html");
			}

			
			
			
			}
		
		
	}

}
