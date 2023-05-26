package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Studentdao;
import dto.Student;

@WebServlet(urlPatterns = "/login")
public class Loginservlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = (req.getParameter("email"));
		String password = (req.getParameter("password"));

		Studentdao dao = new Studentdao();
		// Student student=dao.fetch(email);

		Student student;
		try {
			long mobile = Long.parseLong(email);
			student = dao.fetch(mobile);
		} catch (NumberFormatException e) {
			student = dao.fetch(email);
		}

		if (student == null) {
			resp.getWriter().print("<h1>Invalid Email/ Mobile </h1>");
			req.getRequestDispatcher("login.html").include(req, resp);

		} else {
			if (student.getPassword().equals(password)) {

				resp.getWriter().print("<h1>Login Successfully</h1>");
                req.setAttribute("student", student);
                req.setAttribute("list", dao.fetch());
                req.getRequestDispatcher("success.jsp").include(req, resp);
				
			} else {
				resp.getWriter().print("<h1> Invalid password </h1>");
				req.getRequestDispatcher("login.html").include(req, resp);
			}
		}
	}
}