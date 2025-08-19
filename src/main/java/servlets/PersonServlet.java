package servlets;

import java.io.IOException;

import enterprise.Person;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		
		Person person = new Person(0, fname, lname);

		String fullName = fname + " " + lname;
		
		
		System.out.println("Welcome " + fullName);
		
		req.setAttribute("name", fullName);
		RequestDispatcher dispatcher = req.getRequestDispatcher("welcome.jsp");
		dispatcher.forward(req, resp);
	}
}
