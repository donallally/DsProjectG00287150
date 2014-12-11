package ie.gmit.server;

import ie.gmit.Fibonacci;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private FibService fs;

	public Servlet() {
		super();
		fs = new FibService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rType = request.getParameter("request-type");

		if (rType.equals("Add")) {
			String number = "";
			number += fs.add(Integer.parseInt(request.getParameter("max")));
			response.addHeader("jobNumber", number);
			response.addHeader("Refresh","10");//refresh every 10 seconds
			response.sendRedirect("Interrim.jsp");
		} else if (rType.equals("Poll")) {
			String jobNumber = "";
			response.getOutputStream().print(jobNumber);
			jobNumber += fs.add(Integer.parseInt(request.getParameter("jobNumber")));
			
			if (fs.getResult(Integer.parseInt(jobNumber)) != null) {
				response.sendRedirect("Results.jsp"); //send client to this page
				//if the result is found, display them
			}
			else{
				response.sendRedirect("Interrim.jsp"); //send client to this page
				//if results are not found then continue to show wait
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
