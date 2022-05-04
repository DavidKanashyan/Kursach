package osago;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="SignUp", urlPatterns="/SignUp")

public class SignUp extends HttpServlet{
	
	protected static String name = "hackerMimo";
	protected static String password = "NeVzLoMaEsH";
	protected static String admin;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestOsag Osag = RequestOsag.fromRequestParameters(request);
		Osag.setAsRequestAttributesAndCalculate(request, response);
		
		request.getRequestDispatcher("/Avtorizatia.jsp").forward(request, response);		
	}
	
	private static class RequestOsag {
		private final String first_calc;
		private final String second_calc;
		private final String third_calc;
		
		private RequestOsag (String login, String password, String fith) {
			this.first_calc = login;
			this.second_calc = password;
			this.third_calc = fith;
		}
		
		public static RequestOsag fromRequestParameters(HttpServletRequest request) {
			return new RequestOsag(
					request.getParameter("login"), 
					request.getParameter("password"),
					request.getParameter("fith"));
		}
		
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setAttribute("login", first_calc);
			request.setAttribute("password", second_calc);
			request.setAttribute("fith", third_calc);
			
			name = first_calc;
			password = second_calc;
			admin = third_calc;
		}
	}
}