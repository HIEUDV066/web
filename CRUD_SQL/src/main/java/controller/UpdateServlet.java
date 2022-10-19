package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxResultset.ColumnMetaDataOrBuilder;

import dal.PhoneDAO;
import model.phone;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_raw = request.getParameter("id");
		try {
			int id=Integer.parseInt(id_raw);
			PhoneDAO cdb = new PhoneDAO();
			phone p = cdb.getPhoneByID(id);
			request.setAttribute("phone", p);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id_raw = request.getParameter("id");
		String name = request.getParameter("name");
		String describle = request.getParameter("describle");
		int id;
		try {
			id=Integer.parseInt(id_raw);
			PhoneDAO cdb = new PhoneDAO();
			phone p = new phone(id,name,describle);
			cdb.update(p);
			response.sendRedirect("list");
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
	}

}
