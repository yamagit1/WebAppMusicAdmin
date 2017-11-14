package yama.serverlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yama.database.ConnectDatabases;
import yama.database.OnlineSong;
import yama.database.Top100;

/**
 * Servlet implementation class SongController
 */
@WebServlet("/SongController")
public class SongController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SongController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//		ConnectDatabases con = new ConnectDatabases("173.243.120.226:3306","kythuatj_yama", "Hoamoclan1", "kythuatj_appMusic", "");
		ConnectDatabases con = new ConnectDatabases("localhost","root", "hoamoclan", "appMusic", "");
		if (con.CD_start_connection())
		{
			String url = "https://nhac.vn/bang-xep-hang-bai-hat-au-my-bxbR";
			
			OnlineSong onlineSong = new OnlineSong(con);
			Top100 top100 = new Top100(con);
			ArrayList<Top100> listTop100 = Top100.TOP_get_Top(url);
			
			for (Top100 i : listTop100)
			{

				top100.TOP_set_infor(
						i.TOP_get_index(),
						"1",					//i.OLS_get_category(),
						i.TOP_get_id(),
						i.TOP_get_name(),
						i.TOP_get_artist(),
						i.TOP_get_link_page_infor(),
						i.TOP_get_link_mp3(),
						i.TOP_get_link_img(),
						i.TOP_get_link_lyric());
				
				top100.TOP_getData();
				
				onlineSong.OLS_set_infor(
						top100.TOP_get_id(),
						"1",						//i.OLS_get_category(),
						top100.TOP_get_name(),
						top100.TOP_get_artist(),
						top100.TOP_get_link_page_infor(),
						top100.TOP_get_link_mp3(),
						top100.TOP_get_link_img(),
						top100.TOP_get_link_lyric());
				
				onlineSong.OLS_insert_data();
				top100.TOP_insert_data();
			}
		}
		con.CD_dis_connection();
		
		response.sendRedirect("pageTop100.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
