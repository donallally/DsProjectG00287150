package ie.gmit;

import java.io.IOException;
import java.rmi.Naming;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FibServer fs;

	public Servlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
	try{
		fs = (FibServer) Naming.lookup("rmi://127.0.0.1:1090/FibServer"); //look at this location
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String rType = request.getSession().getAttribute("request-type").toString();//get the request type from the jspPage
		if (rType.equals("Add")) {//is its an add request then do this
			int number = Integer.parseInt(request.getParameter("number"));//take the user entered number
			String jobNumber = "";
			jobNumber += fs.add(number);//add the number
			request.getSession().setAttribute("jobNumber", jobNumber);//tell the page to display this number
			request.getSession().setAttribute("timer", 10);//refresh the page every 10 seconds
			request.getRequestDispatcher("Interrim.jsp").forward(request, response);//display the next page
			
		} 
		else if (rType.equals("Poll")) {//if its a poll request
			String results = "";
			try {
				results += fs.getResult(Integer.parseInt(request.getSession().getAttribute("jobNumber").toString()));//retreve the results
			} 
			catch (Exception e) {
				e.getMessage();
			}
			System.out.println(results);//print out the results on server screen (used for debugging)
			if (!results.equals("") && results.equals("null")) {//if its an empty string of is null
				request.getSession().setAttribute("results", results);//set the results label to the sequence
				request.getRequestDispatcher("Results.jsp").forward(request, response);//display the results page
			} 
			else {
				request.getRequestDispatcher("Interrim.jsp").forward(request, response);//else display display a wait page
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}