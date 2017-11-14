package yama.serverlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yama.database.Account;
import yama.database.ConnectDatabases;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//	response.getWriter().append("Served at: ").append(request.getContextPath());

	//	ConnectDatabases con = new ConnectDatabases("173.243.120.226:3306","kythuatj_yama", "Hoamoclan1", "kythuatj_appMusic", "");
		ConnectDatabases con = new ConnectDatabases("localhost","root", "hoamoclan", "fist", "");

		Account account = new Account(con);

		account.AC_set_infor(request.getParameter("usr_id"),
				request.getParameter("usr_passwd"),
				request.getParameter("usr_mail"),
				request.getParameter("usr_onl_facebook"),
				request.getParameter("usr_name"));

		String button = request.getParameter("btsubmit");
		con.CD_start_connection();
		switch (button) {
		case "okval":
			
			con.CD_dis_connection();
			response.sendRedirect("pageSource.html");
			break;

		case "ok2val":
			
			con.CD_dis_connection();
			response.sendRedirect("pageError.html");
			break;
			
		case "serverinsert":
			
			account.AC_insert_data();
			con.CD_dis_connection();
			response.sendRedirect("pageUser.jsp?index=0");

			break;

		default:
			con.CD_dis_connection();
			response.sendRedirect("pageError.html");
			break;
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
