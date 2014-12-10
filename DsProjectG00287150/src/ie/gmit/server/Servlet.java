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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rType = request.getParameter("request-type");
		if(rType.equals("Add")){
			String number = "";
					number += fs.add(Integer.parseInt(request.getParameter("max")));
					
			//out.write("Job Num:");
		}
		else if(rType.equals("Poll")){
			String number = "";
			response.getOutputStream().print(number);
			number += fs.add(Integer.parseInt(request.getParameter("jobNumber")));
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}
