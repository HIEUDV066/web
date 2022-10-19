package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num_raw = request.getParameter("num");
		int num=0;
		try {
			num = Integer.parseInt(num_raw);
			int id, age;
			String name;
			boolean g;
			String[] n = {"A","B","C","D","E","G","H"};
			Random r = new Random();
			List<Student> list = new ArrayList<>();
			for (int i = 0; i< num; i++) {
				id = i+1;
				g = r.nextBoolean();
				if(g) {
					name = "Mr "+n[r.nextInt(n.length)];
				}else
					name = "Mss "+n[r.nextInt(n.length)];
				age = r.nextInt(23-19)+19;
				Student s = new Student(id, age, name, g);
				list.add(s);
			}
			request.setAttribute("data", list);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}catch (NumberFormatException e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
