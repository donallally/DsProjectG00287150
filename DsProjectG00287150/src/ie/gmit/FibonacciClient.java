package ie.gmit;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FibonacciClient extends HttpServlet {
	private String remoteHost = null;


	public void init() throws ServletException {
		ServletContext ctx = getServletContext();
		remoteHost = ctx.getInitParameter("RMI_SERVER");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String detail = req.getParameter("id");
		out.print("<H1>Servlet Works Okay: " + detail + "</H1>");
		out.print("RMI Server is located at " + remoteHost);
		out.print("<P>Maybe add additional parameters for port number, protocol and object name");		
		
		//You can use this method to implement the functionality of an RMI client
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
 	}
}
