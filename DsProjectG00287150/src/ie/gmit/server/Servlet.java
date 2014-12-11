package ie.gmit.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
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
	}

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (fs == null) {
			fs = new FibService();
		}
		String rType = request.getSession().getAttribute("request-type").toString();
		if (rType.equals("Add")) {
			String jobNumber = "";
			jobNumber += fs.add(Integer.parseInt(request.getParameter("number")));
			request.getSession().setAttribute("jobNumber", jobNumber);
			request.getSession().setAttribute("timer", 10);
			request.getRequestDispatcher("Interrim.jsp").forward(request, response);
		} else if (rType.equals("Poll")) {
			String results = "";
			try {
				results += fs.getResult(Integer.parseInt(request.getSession().getAttribute("jobNumber").toString()));
			} catch (NumberFormatException e) {
				e.getMessage();
			}
			if (!results.equals("") || results != null) {
				request.getSession().setAttribute("results", results);
				request.getRequestDispatcher("Results.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("Interrim.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}