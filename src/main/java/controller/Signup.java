package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Studentdao;
import dto.Student;

@WebServlet("/Signup")
public class Signup extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//	 // String name=req.getParameter("name");
//	String email=req.getParameter("email");
//	long mobile=Long.parseLong(req.getParameter("mobile"));
//	String password = req.getParameter("password");
//	String gender=req.getParameter("gender");
	
//	System.out.println(name);
//	System.out.println(email);
//	System.out.println(mobile);   // Insted of using this we can directly accessing		                             
//	System.out.println(password); //It is waste of storage memmory
//	System.out.println(gender);
	
	Student student=new Student();
	student.setEmail(req.getParameter("email"));
	student.setGender(req.getParameter("gender"));
	student.setMobile(Long.parseLong(req.getParameter("mobile")));
	student.setName(req.getParameter("name"));
	student.setPassword(req.getParameter("password"));
	
	Studentdao dao=new Studentdao();
	dao.save(student);
	
	resp.getWriter().print("<h1>Data Saved Succesfully</h1>");
	req.getRequestDispatcher("login.html").include(req, resp);
	}
}