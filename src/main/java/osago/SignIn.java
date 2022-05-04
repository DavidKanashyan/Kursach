package osago;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="SignIn", urlPatterns="/SignIn")

public class SignIn extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestOsag Osag = RequestOsag.fromRequestParameters(request);
		Osag.setAsRequestAttributesAndCalculate(request, response);
		
		
		
	}
	
	private static class RequestOsag {
		private final String first_calc;
		private final String second_calc;
		
		private RequestOsag (String login, String password) {
			this.first_calc = login;
			this.second_calc = password;
		}
		
		public static RequestOsag fromRequestParameters(HttpServletRequest request) {
			return new RequestOsag(
					request.getParameter("login"), 
					request.getParameter("password"));
		}
		
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setAttribute("login", first_calc);
			request.setAttribute("password", second_calc);
			
			final String admin = "admin";
			final String user = "user";
			
			if(first_calc.contentEquals(SignUp.name) && second_calc.contentEquals(SignUp.password) && user.contentEquals(SignUp.admin)) {
				request.getRequestDispatcher("/Osnovnaya.jsp").forward(request, response);
			} else if (first_calc.contentEquals(SignUp.name) && second_calc.contentEquals(SignUp.password) && admin.contentEquals(SignUp.admin)) {
				request.getRequestDispatcher("/Admin.jsp").forward(request, response);
			} else if (!(first_calc.contentEquals(SignUp.name)) && second_calc.contentEquals(SignUp.password)){
				request.setAttribute("login", "Логин неверный");
				request.setAttribute("password", "Пароль верный");
				request.getRequestDispatcher("/Avtorizatia.jsp").forward(request, response);
			} else if (first_calc.contentEquals(SignUp.name) && !(second_calc.contentEquals(SignUp.password))){
				request.setAttribute("login", "Логин верный");
				request.setAttribute("password", "Пароль неверный");
				request.getRequestDispatcher("/Avtorizatia.jsp").forward(request, response);
			} else if (!(first_calc.contentEquals(SignUp.name) && second_calc.contentEquals(SignUp.password))){
				request.setAttribute("login", "Логин неверный");
				request.setAttribute("password", "Пароль неверный");
				request.getRequestDispatcher("/Avtorizatia.jsp").forward(request, response);
			}
			
			
		}
	}
}