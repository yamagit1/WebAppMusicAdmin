package yama.database;
import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Category {
	//
	ConnectDatabases con;
	//
	private String cate_id;
	private String cate_name;
	
	public Category() {}
	
	public Category(ConnectDatabases connect) {
		cate_id 			= "none";
		cate_name 			= "none";
		con = connect;
	}

	public boolean CATE_set_infor(
			String id,
			String name) 
	{
		cate_id 			= id;
		cate_name 			= name;
		
		return true;
	}

	public String CATE_get_id() {return cate_id;}
	public String CATE_get_name() {return cate_name;}
	
	//
	public void CATE_set_id(String id) {cate_id = id;}
	public void CATE_set_name(String name) {cate_name = name;}

	//data base
		public boolean CATE_insert_data() {
		String cmdQuery = "INSERT INTO tabCategorySong VALUES('" 
				+ cate_id 				+"','" 
				+ cate_name 			+"')";

		if (con.CD_execute_command(cmdQuery))
		{
			System.out.println("insert complie");
			return true;
		}
		else
		{
			System.out.println("insert faile");
			return false;
		}

	}
		
	public boolean CATE_update_data() {
		String cmdQuery = "UPDATE tabCategorySong SET " +  
				"cate_name = '" 			+ cate_name 		+"'"  +
				" WHERE " +
				"cate_id='" 				+ cate_id 				+ "'";
		if (con.CD_execute_command(cmdQuery))
		{
			System.out.println("update complie");
			return true;
		}
		else
		{
			System.out.println("update faile");
			return false;
		}
	}
	
	public boolean CATE_delete_data() {
		
		String cmdQuery = "DELETE FROM tabCategorySong " +
				" WHERE " +
				"cate_id='" + cate_id + "'";
		
		if (con.CD_execute_command(cmdQuery))
		{
			System.out.println("delete complie");
			return true;
		}
		else
		{
			System.out.println("delete falie");
			return false;
		}
	}

	public static ArrayList<Category> CATE_get_list_category(int offset, int numberItem) {

		//		ConnectDatabases connect = new ConnectDatabases("173.243.120.226:3306","kythuatj_yama", "Hoamoclan1", "kythuatj_appMusic", "");
			ConnectDatabases connect = new ConnectDatabases("localhost","root", "hoamoclan", "appMusic", "");
		
			ArrayList<Category> list= new ArrayList<Category>();
			
			String cmdQuery = "SELECT * FROM tabCategorySong LIMIT " + numberItem + " OFFSET " + offset * numberItem;
			
			ResultSet res = null;
			
			connect.CD_start_connection();
			
			if ((res = connect.CD_execute_query(cmdQuery)) != null)
			{
				try {
					while(res.next())
					{
						Category item = new Category();
						
						item.CATE_set_infor(
								res.getString(1),
								res.getString(2));
						
						list.add(item);
					}
				}
				catch (Exception e) {
					connect.CD_dis_connection();
					System.out.println("error fet list");
					// TODO: handle exception
				}
			}
			else
			{
				System.out.println("load falie");
			}
			connect.CD_dis_connection();

			return list;
	}
	
	
}
