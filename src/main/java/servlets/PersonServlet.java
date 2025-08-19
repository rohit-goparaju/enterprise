package servlets;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import enterprise.Person;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7274317475921056871L;

	public static final Logger log = LoggerFactory.getLogger(PersonServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		
		Person person = new Person(0, fname, lname);

		String fullName = fname + " " + lname;
		
		
		log.info("Welcome " + fullName);
		
		req.setAttribute("name", fullName);
		RequestDispatcher dispatcher = req.getRequestDispatcher("welcome.jsp");
		dispatcher.forward(req, resp);
	}
}
