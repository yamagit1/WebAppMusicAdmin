package yama.database;


import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author yamateam
 * mail 	: yamateamhaui@gmail.com
 * address	: ĐH Công Nghiệp Hà Nội-Nhổn-Bắc Từ Liêm-Hà Nội-Việt Nam
 */
public class Account {
	//
	ConnectDatabases con;
	//
	private String usr_id;
	private String usr_pass;
	private String usr_mail;
	private String usr_onl_facebook;
	private String usr_name;
	public PrintWriter out;

	public Account() {
		usr_id				= "1";
		usr_pass			= "none";
		usr_mail			= "offline";
		usr_onl_facebook	= "offline";
		usr_name			= "none";
		con = null;
	}
	public Account(ConnectDatabases connect) {
		usr_id				= "1";
		usr_pass			= "none";
		usr_mail			= "offline";
		usr_onl_facebook	= "offline";
		usr_name			= "none";
		con = connect;
	}
	public void AC_set_infor(String id, String pass, String status, String facebook, String name) {
		usr_id				= id;
		usr_pass			= pass;
		usr_mail			= status;
		usr_onl_facebook	= facebook;
		usr_name			= name;
	}

	public void AC_set_id(String val) {usr_id = val;}
	public void AC_set_passwd(String val) {usr_pass = val;}
	public void AC_set_mail(String val) {usr_mail = val;}
	public void AC_set_facebook(String val) {usr_onl_facebook = val;}
	public void AC_set_name(String val) {usr_name = val;}
	public void AC_set_connection(ConnectDatabases cn) {con = cn;}
	public void AC_set_out(PrintWriter cn) {out = cn;}

	public String AC_get_id() {return usr_id;}
	public String AC_get_passwd() {return usr_pass;}
	public String AC_get_mail() {return usr_mail;}
	public String AC_get_facebook() {return usr_onl_facebook;}
	public String AC_get_name() {return usr_name;}
	//data base

	public boolean AC_insert_data() {
		String cmdQuery = "INSERT INTO tabAccount VALUES('" 
				+ usr_id 		+"','" 
				+ usr_pass 		+"','" 
				+ usr_mail 	+"','" 
				+ usr_onl_facebook 	+"','"
				+ usr_name 		+"')";

		//		String cmd = "CREATE TABLE tabLocalSong(local_id nvarchar(50) not null primary key)";

		if (con.CD_execute_command(cmdQuery))
		{
			//System.out.println("insert complie");
			return true;
		}
		else
		{
			//System.out.println("insert faile");
			return false;
		}

	}
	public boolean AC_update_data() {

		String cmdQuery = "UPDATE tabAccount SET " +  
				"usr_passwd = '" 			+ usr_pass 				+"'," +
				"usr_mail = '" 				+ usr_mail 				+"'," +
				"usr_onl_facebook = '" 		+ usr_onl_facebook 		+"'," +
				"usr_name = '"				+ usr_name 				+"'"  +
				" WHERE " +
				"usr_id='" 					+ usr_id 				+ "'";

		if (con.CD_execute_command(cmdQuery))
		{
			//System.out.println("AC_update_data complie");

			return true;
		}
		else
		{
			//System.out.println("AC_update_data faile");

			return false;
		}
	}

	public boolean AC_delete_data() {
		String cmdQuery = "DELETE FROM tabAccount " +
				" WHERE " +
				"usr_id='" + usr_id + "'";

		if (con.CD_execute_command(cmdQuery))
		{
			//System.out.println("delete complie");
			return true;
		}
		else
		{
			//System.out.println("delete falie");
			return false;
		}
	}

	public boolean AC_log_in()
	{
		if (con.CD_check_data("tabAccount", "usr_id", usr_id, "usr_passwd", usr_pass))
		{
			//System.out.println("AC_log_in complie");
			return true;			
		}
		else
		{
			//System.out.println("AC_log_in fail");
			return false;
		}
	}
	public static ArrayList<Account> AC_get_list_item(int offset) {
		//	ConnectDatabases connect = new ConnectDatabases("173.243.120.226:3306","kythuatj_yama", "Hoamoclan1", "kythuatj_appMusic", "");
		ConnectDatabases connect = new ConnectDatabases("localhost","root", "hoamoclan", "fist", "");

		int numberItem = 2;
		ArrayList<Account> list= new ArrayList<Account>();
		String cmdQuery = "SELECT * FROM tabAccount LIMIT " + numberItem + " OFFSET " + offset * numberItem;
		ResultSet res = null;
		connect.CD_start_connection();
		if ((res = connect.CD_execute_query(cmdQuery)) != null)
		{
			try {
				while(res.next())
				{
					Account ac = new Account();
					ac.AC_set_infor(res.getString(1),
							res.getString(2),
							res.getString(3),
							res.getString(4),
							res.getString(5));
					list.add(ac);

				}
			}
			catch (Exception e) {
				connect.CD_dis_connection();
//				System.out.println("error fet list");
				// TODO: handle exception
			}
		}
		else
		{
//			System.out.println("login falie");
		}
		connect.CD_dis_connection();
		return list;
	}
}
