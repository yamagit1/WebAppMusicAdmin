package yama.database;
/**
 * 
 * @author yamateam
 * mail 	: yamateamhaui@gmail.com
 * address	: ĐH Công Nghiệp Hà Nội-Nhổn-Bắc Từ Liêm-Hà Nội-Việt Nam
 */

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConnectDatabases extends StatusDatabases{

	private String nameHost			= "";
	private String nameServer 		= "";
	private String passServer 		= "";
	private String nameDatabase 	= "";
	private String passDatabase		= "";

	private Connection connectionDatabase;
	private java.sql.Statement  statementDatabase;
	private ResultSet resultSetDatabase;
	/**
	 * construction, khởi tạo các thông tin cho đôi tượng kết nối
	 * @param server : host name
	 * @param passserver : password cho host
	 * @param database : name database cần thao tác
	 * @param passdatabase : password cho database
	 */
	public ConnectDatabases(String host,String server, String passserver,String database,String passdatabase) {
		// TODO Auto-generated constructor stub
		nameHost = host;
		nameServer = server;
		passServer = passserver;
		nameDatabase = database;
		passDatabase = passdatabase;
	}
	public List<String> CD_get_infor()
	{
		List<String> listval= new ArrayList<>();
		listval.clear();
		listval.add(nameHost);
		listval.add(nameServer);
		listval.add(nameDatabase);
		return listval;
	}
	/**
	 * tạo chuỗi uri kết nối
	 * @return chuỗi kết nối không bao gồm thông tin host name và password
	 */
	private String CD_get_uri() {
		String url = "jdbc:mysql://" + nameHost + "/" + nameDatabase + "?characterEncoding=utf8";
		return url;
	}
	/**
	 * thực hiện các kết nối với database
	 * @exception xảy ra ngoại lệ nếu kết nối thất bại,có thể dùng 
	 * SD_get_message_error() để lấy thông tin lỗi
	 */
	public boolean CD_start_connection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connectionDatabase = DriverManager.getConnection(CD_get_uri(),nameServer,passServer);
			statementDatabase = connectionDatabase.createStatement();
			return true;
		}
		catch (Exception e) {
			errorConnection = "[CD_start_connection()]" + e.getMessage();
		}
		return false;
	}
	/**
	 * thực hiện việc đóng và ngắt các kết nối tới database 
	 * @exception xảy ra ngoại lệ nếu thất bại,có thể dùng 
	 * SD_get_message_error() để lấy thông tin lỗi
	 */
	public boolean CD_dis_connection() {
		try {
			resultSetDatabase.close();
			statementDatabase.close();
			connectionDatabase.close();
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			errorConnection = "[CD_dis_connection()]" + e.getMessage();
		}
		return false;
	}
	/**
	 * lấy dữ liệu của 1 table trong database và lưu vào dối tượng {@link ResultSet}
	 * @param tab : tên bảng cần truy xuất
	 * @return dối tượng {@link ResultSet} chứa dữ liệu của table
	 * @exception xảy ra ngoại lệ khi thao tác thất bại
	 */
	public ResultSet CD_get_data(String tab) {
		resultSetDatabase = null;
		String query = "SELECT " + "*" + " FROM " + tab + ";";
		try {
			resultSetDatabase = statementDatabase.executeQuery(query);
		}
		catch (Exception e) {
			errorConnection = "[CD_get_data]" + e.getMessage();
		}
		return resultSetDatabase;
	}
	/**
	 * thực hiện câu truy vấn SQL và trả về kết quả lưu trong đối tượng {@link ResultSet}
	 * @param query : chuỗi truy vấn SQL
	 * @return	đối tượng {@link ResultSet} chứa kết quả truy vấn
	 * @exception xảy ra lỗi khi thao tác thất bại
	 */
	public ResultSet CD_execute_query(String query) {
		ResultSet resultSetDatabasse = null;
		try {
			resultSetDatabasse  = statementDatabase.executeQuery(query);
		}catch (Exception e) {
			errorConnection = "[CD_execute_query]" + e.getMessage();
		}
		return resultSetDatabasse;
	}
	/**
	 * thực hiện câu truy vấn SQL như create table, database drop table, database
	 * @param query : chuỗi truy vấn SQL
	 * @return	đối tượng {@link ResultSet} chứa kết quả truy vấn
	 * @exception xảy ra lỗi khi thao tác thất bại
	 */
	public boolean CD_execute_command(String command) {
		try {
			statementDatabase.execute(command);
			return true;
		}catch (Exception e) {
			errorConnection = "[CD_execute_query]" + e.getMessage();
		}
		return false;
	}
	/**
	 * 
	 */
	public void CD_check_table() {
	}
	/**
	 * kiểm tra xem dữ liệu đã có trong database hay chưa
	 * @param tab
	  * @param col
	 * @return
	 */
	public boolean CD_check_data(String tab,String col,String key) {
		resultSetDatabase = null;
		String query = "SELECT * FROM " + tab + " WHERE " + col + "=" + key + ";";
		//	String query = "SELECT " + "*" + " FROM " + tab + ";";
		try {
			resultSetDatabase = statementDatabase.executeQuery(query);
			if(resultSetDatabase.next()) {
				if(resultSetDatabase.getString(1) !="") {
					return true;
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			errorConnection =  "[CD_check_data]" + e;
		}
		return false;
	}
	/**
	 * 
	 * @param tab
	 * @param col1
	 * @param key1
	 * @param col2
	 * @param key2
	 * @return
	 */
	public boolean CD_check_data(String tab,String col1,String key1,String col2,String key2) {
		resultSetDatabase = null;
		String query = "SELECT * FROM " + tab +" WHERE " + col1 + "='" + key1 + "' AND " + col2 + "='" + key2 + "';";
		try {
			resultSetDatabase = statementDatabase.executeQuery(query);
			resultSetDatabase.next();
			if(resultSetDatabase.getString(1) != null) {
				return true;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			errorConnection = "[check_data(String,String,String)]" + e;
		}
		return false;
	}
	//==================================
}
