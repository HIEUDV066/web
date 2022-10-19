package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.PhoneDAO;
import model.phone;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id_raw = request.getParameter("id");
		String name = request.getParameter("name");
		String describle = request.getParameter("describle");
		int id;
		try {
			id = Integer.parseInt(id_raw);
			PhoneDAO cbd= new PhoneDAO();
			phone p = cbd.getPhoneByID(id);
			//co roi
			if (p!=null) {
				String ms = id_raw +"existed";
				request.setAttribute("error", ms);
				request.getRequestDispatcher("new.jsp").forward(request, response);
			}else {//chua co
				phone p1=new phone(id, name,describle);
				cbd.insert(p1);
				response.sendRedirect("list");
			}
		} catch (NumberFormatException e) {
			System.out.println(e);
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
