package schoolmanagementsystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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

import schoolmanagement.dto.Teacher;

@WebServlet("/deleteteacher")
public class DeleteTeacher extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		String tid = req.getParameter("tid");
	

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Teacher t = em.find(Teacher.class, Integer.parseInt(tid));
		
		 et.begin();
		 em.remove(t);
		 et.commit();
		 
		 
		 PrintWriter pw = resp.getWriter();
		 System.out.println("Data deleted");
		 
		 RequestDispatcher rd = req.getRequestDispatcher("AddRemoveTeacherStudent.html");
		 rd.forward(req, resp);
		 rd.include(req, resp);
		 resp.setContentType("text/html");
	}

}
