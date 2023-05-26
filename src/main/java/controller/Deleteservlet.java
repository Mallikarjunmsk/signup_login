package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Studentdao;

@WebServlet("/delete")
public class Deleteservlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		Studentdao dao=new Studentdao();
		dao.delete(id);
		
		
		resp.getWriter().print("<h1>Delete Successfuly</h1>");
		req.getRequestDispatcher("home.html").include(req, resp);

	}
}
