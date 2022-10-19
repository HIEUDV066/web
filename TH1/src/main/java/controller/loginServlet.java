package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String name = request.getParameter("user");
        String ageString = request.getParameter("age");

        int age = Integer.parseInt(ageString);
        if (age < 15)
            writer.println("<h1>Ban " + name + " dang duoi do tuoi lao dong</h1>");
        else if (age >= 15 && age < 65)
            writer.println("<h1>Ban " + name + " dang trong do tuoi lao dong</h1>");
        else {
            writer.println("<h1>Ban " + name + " da ngoai do tuoi lao dong</h1>");
        }
		doGet(request, response);
	}

}
