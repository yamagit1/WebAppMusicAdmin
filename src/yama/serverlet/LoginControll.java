package yama.serverlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import yama.database.Account;
import yama.database.ConnectDatabases;

/**
 * Servlet implementation class LoginControll
 */
@WebServlet("/LoginControll")
public class LoginControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String usr_id = request.getParameter("usr_id");
		String usr_passwd = request.getParameter("usr_passwd");
		
		ConnectDatabases con = new ConnectDatabases("173.243.120.226:3306","kythuatj_yama", "Hoamoclan1", "kythuatj_appMusic", "");
	//	ConnectDatabases con = new ConnectDatabases("localhost","root", "hoamoclan", "fist", "");
		
		Account account = new Account(con);
		
		account.AC_set_infor(usr_id, usr_passwd, "none", "none", "none");
		
		con.CD_start_connection();
		
		boolean login = account.AC_log_in();
		
		con.CD_dis_connection();
		
		if (login)
		{
			response.sendRedirect("index.html");
		}
		else
		{
			response.sendRedirect("login.html");

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
