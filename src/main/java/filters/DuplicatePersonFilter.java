package filters;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import daos.PersonDAO;
import enterprise.Person;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class DuplicatePersonFilter
 */
@WebFilter(urlPatterns = { "/PersonServlet"})
public class DuplicatePersonFilter extends HttpFilter implements Filter {

	private static final Logger log = LoggerFactory.getLogger(DuplicatePersonFilter.class);
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		
		Long aadhaar = Long.parseLong(request.getParameter("aadhaar"));
		
		PersonDAO personDAO = new PersonDAO();
		
		Person person = personDAO.getPerson(aadhaar);
		
		if(person.getFname() == null)
			chain.doFilter(request, response);
		else {
			if(request.getParameter("deleteRequest") == null) {
				List<Person> people = personDAO.getAllPerson();
				request.setAttribute("aadhaarNumber", aadhaar);
				request.setAttribute("people", people);
				request.setAttribute("greeting", "Aaadhaar already registered.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
				dispatcher.forward(request, response);
			}
			else {
				personDAO.removePerson(aadhaar);
				response.getWriter().write("index.html");
			}
		}
	}


}
