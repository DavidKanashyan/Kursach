package osago;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Osag", urlPatterns="/Osag")

public class Osag extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestOsag Osag = RequestOsag.fromRequestParameters(request);
		Osag.setAsRequestAttributesAndCalculate(request);
		
		request.getRequestDispatcher("/Resultat.jsp").forward(request, response);		
	}
	
	private static class RequestOsag {
		private final String first_calc;
		private final String second_calc;
		private final String third_calc;
		private final String fourth_calc;
		private final String fith_calc;
		private final String sixth_calc;
		private final String seventh_calc;
		private double result;
		
		private RequestOsag (String first, String second, String third, String fourth, String fith, String sixth, String seventh) {
			this.first_calc = first;
			this.second_calc = second;
			this.third_calc = third;
			this.fourth_calc = fourth;
			this.fith_calc = fith;
			this.sixth_calc = sixth;
			this.seventh_calc = seventh;
		}
		
		public static RequestOsag fromRequestParameters(HttpServletRequest request) {
			return new RequestOsag(
					request.getParameter("first"), 
					request.getParameter("second"),
					request.getParameter("third"),
					request.getParameter("fourth"),
					request.getParameter("fith"),
					request.getParameter("sixth"),
					request.getParameter("seventh"));
		}
		
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) throws IOException {
			request.setAttribute("first", first_calc);
			request.setAttribute("second", second_calc);
			request.setAttribute("third", third_calc);
			request.setAttribute("fourth", fourth_calc);
			request.setAttribute("fith", fith_calc);
			request.setAttribute("sixth", sixth_calc);
			request.setAttribute("seventh", seventh_calc);
			
			double first_try;
			double second_try;
			double third_try;
			double fourth_try;
			double fith_try;
			double sixth_try;
			double seventh_try;
			try {
				first_try=Double.parseDouble(first_calc);
			}
			catch (NumberFormatException e) {
				first_try=0;
			}
			try {
				second_try=Double.parseDouble(second_calc);
			}
			catch (NumberFormatException e) {
				second_try=0;
			}
			try {
				third_try=Double.parseDouble(third_calc);
			}
			catch (NumberFormatException e) {
				third_try=0;
			}
			try {
				fourth_try=Double.parseDouble(fourth_calc);
			}
			catch (NumberFormatException e) {
				fourth_try=0;
			}
			try {
				fith_try=Double.parseDouble(fith_calc);
			}
			catch (NumberFormatException e) {
				fith_try=0;
			}
			try {
				sixth_try=Double.parseDouble(sixth_calc);
			}
			catch (NumberFormatException e) {
				sixth_try=0;
			}
			try {
				seventh_try=Double.parseDouble(seventh_calc);
			}
			catch (NumberFormatException e) {
				seventh_try=0;
			}
			One_tarif Osag = new One_tarif(first_try, second_try, third_try, fourth_try, fith_try, sixth_try, seventh_try);
			double sa = Osag.getSum();
			DecimalFormat Osa = new DecimalFormat("###.##");
			result = sa;
			
			try {
				new PdfListener(first_calc, second_calc, third_calc, fourth_calc, fith_calc, sixth_calc, seventh_calc, Osa.format(result));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
			request.setAttribute("result", Osa.format(result) + " рублей");
		}
	}
}