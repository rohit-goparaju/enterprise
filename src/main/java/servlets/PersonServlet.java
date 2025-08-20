package servlets;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import daos.PersonDAO;
import enterprise.Person;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7274317475921056871L;

	public static final Logger log = LoggerFactory.getLogger(PersonServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		Long aadhaar = Long.parseLong(req.getParameter("aadhaar"));
		
		Person person = new Person();

		person.setFname(fname);
		person.setLname(lname);
		person.setAadhaar(aadhaar);
		
		PersonDAO personDAO = new PersonDAO();
		personDAO.addPerson(person);
		
		//set the correct file path wrt tomcat in rolling file.
		log.error("Welcome " + fname+ " " + lname);
		
		List<Person> people = personDAO.getAllPerson();
		
		req.setAttribute("aadhaarNumber", aadhaar);
		req.setAttribute("people", people);
		req.setAttribute("greeting", "Congratulations, you are now registered user.");
		RequestDispatcher dispatcher = req.getRequestDispatcher("welcome.jsp");
		dispatcher.forward(req, resp);
	}
}
