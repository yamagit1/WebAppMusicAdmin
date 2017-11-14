package yama.database;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OnlineSong {
	//
	ConnectDatabases con;
	//
	private String song_id;
	private String cate_id;
	private String song_name;
	private String song_artist;
	private String song_link_page_infor;
	private String song_link_mp3;
	private String song_link_img;
	private String song_link_lyric;

	public OnlineSong() {}

	public OnlineSong(ConnectDatabases connect) {
		song_id 			= "none";
		cate_id 			= "none";
		song_name 			= "none";
		song_artist 		= "none";
		song_link_page_infor = "none";
		song_link_mp3 		= "none";
		song_link_img 		= "none";
		song_link_lyric 	= "none";
		con = connect;
	}

	public boolean OLS_set_infor(
			String id,
			String cate,
			String name,
			String artist,
			String linkInfor,
			String linkMp3,
			String linkImg,
			String linkLyric) 
	{
		song_id 			= id;
		cate_id 			= cate;
		song_name 			= name;
		song_artist 		= artist;
		song_link_page_infor = linkInfor;
		song_link_mp3 		= linkMp3;
		song_link_img 		= linkImg;
		song_link_lyric 	= linkLyric;

		return true;
	}

	public String OLS_get_id() {return song_id;}
	public String OLS_get_category() {return cate_id;}
	public String OLS_get_name() {return song_name;}
	public String OLS_get_artist() {return song_artist;}
	public String OLS_get_link_page_infor() {return song_link_page_infor;}
	public String OLS_get_link_mp3() {return song_link_mp3;}
	public String OLS_get_link_img() {return song_link_img;}
	public String OLS_get_link_lyric() {return song_link_lyric;}

	//
	public void OLS_set_id(String id) {song_id = id;}
	public void OLS_set_category(String category) {cate_id = category;}
	public void OLS_set_name(String name) {song_name = name;	}
	public void OLS_set_artist(String artist) {song_artist = artist;}
	public void OLS_set_link_page_infor(String linkInfor) {song_link_page_infor = linkInfor;}
	public void OLS_set_link_mp3(String linkMp3) {song_link_mp3 = linkMp3;}
	public void OLS_set_link_img(String linkImg) {song_link_img 	= linkImg;}
	public void OLS_set_link_lyric(String linkLyric) {song_link_lyric = linkLyric;}

	//data base
	public boolean OLS_insert_data() {
		String cmdQuery = "INSERT INTO tabOnlineSong VALUES('" 
				+ song_id 				+"','" 
				+ cate_id 				+"','" 
				+ song_name 			+"','" 
				+ song_artist 			+"','"
				+ song_link_page_infor 	+"','"
				+ song_link_mp3 		+"','"
				+ song_link_img 		+"','"
				+ song_link_lyric 		+"')";

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

	public boolean OLS_update_data() {
		String cmdQuery = "UPDATE tabOnlineSong SET " +  
				"cate_id = '" 				+ cate_id 					+"'," +
				"song_name = '" 			+ song_name 				+"'," +
				"song_artist = '" 			+ song_artist 				+"'," +
				"song_link_page_infor = '" 	+ song_link_page_infor 		+"'," +
				"song_link_mp3 = '" 		+ song_link_mp3 			+"'," +
				"song_link_img = '" 		+ song_link_img 			+"'," +
				"song_link_lyric = '" 			+ song_link_lyric 		+"'"  +
				" WHERE " +
				"song_id='" 				+ song_id 				+ "'";
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

	public boolean OLS_delete_data() {

		String cmdQuery = "DELETE FROM tabOnlineSong " +
				" WHERE " +
				"song_id='" + song_id + "'";

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

	public static ArrayList<OnlineSong> OLS_get_list_song(int offset, int numberItem) {

		//		ConnectDatabases connect = new ConnectDatabases("173.243.120.226:3306","kythuatj_yama", "Hoamoclan1", "kythuatj_appMusic", "");
		ConnectDatabases connect = new ConnectDatabases("localhost","root", "hoamoclan", "appMusic", "");

		ArrayList<OnlineSong> list= new ArrayList<OnlineSong>();

		String cmdQuery = "SELECT * FROM tabOnlineSong LIMIT " + numberItem + " OFFSET " + offset * numberItem;

		ResultSet res = null;

		connect.CD_start_connection();

		if ((res = connect.CD_execute_query(cmdQuery)) != null)
		{
			try {
				while(res.next())
				{
					OnlineSong item = new OnlineSong();

					item.OLS_set_infor(
							res.getString(1),
							res.getString(2),
							res.getString(3),
							res.getString(4),
							res.getString(5),
							res.getString(6),
							res.getString(7),
							res.getString(8));

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
	

	public static ArrayList<OnlineSong> OLS_get_Top(String url)
	{
		ArrayList<OnlineSong> result = new ArrayList<OnlineSong>();
		OnlineSong song = null;

		String urlFind = url;
		String inputLine;
		try
		{
			URL find = new URL(urlFind);
			BufferedReader in = new BufferedReader(new InputStreamReader(find.openStream()));
			while ((inputLine = in.readLine()) != null) {
				if (inputLine.contains("bxh_song_list"))
				{
					while((inputLine = in.readLine()) != null)
					{
						if(inputLine.contains("<div id=\"footer\""))
						{
							break;
						}
						if (inputLine.contains("<li id=\"song"))
						{
							for (int i = 0; i < 8; i++)
							{
								if((inputLine = in.readLine()) != null)
								{
								}
							}
							String link[] = inputLine.split("\"");
							song = new OnlineSong();
							song.OLS_set_artist(link[7]);
							song.OLS_set_link_page_infor(link[1]);
							song.OLS_set_link_img(link[5]);
							song.OLS_set_id(link[1].substring(link[1].lastIndexOf("-") + 1));
							for (int i = 0; i < 2; i++)
							{
								if((inputLine = in.readLine()) != null)
								{
								}
							}
							String nm[] = inputLine.split("\"");
							nm[4] = nm[4].substring(1);
							nm[4] = nm[4].substring(0, nm[4].indexOf("<"));
							song.OLS_set_name(nm[4]);
							result.add(song);
						}
					}
					break;
				}
			}
			in.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public static ArrayList<OnlineSong> OLS_search(String key)
	{
		System.out.println("key : "+ key);
		String urlFind = "https://nhac.vn/search?q="+key;
		String inputLine;
		ArrayList<OnlineSong> result = new ArrayList<OnlineSong>();
		OnlineSong song = null;
		try
		{
			URL find = new URL(urlFind);
			BufferedReader in = new BufferedReader(new InputStreamReader(find.openStream()));
			while ((inputLine = in.readLine()) != null) {
				if (inputLine.contains("<ul class=\"list_song\">"))
				{
					while ((inputLine = in.readLine()) != null)
					{
						if (inputLine.contains("<div class=\"box_title\">"))
						{
							break;
						}
						if (inputLine.contains("<li id=\"song"))
						{
							for (int i = 0; i < 1; i++)
							{
								if((inputLine = in.readLine()) != null)
								{
								}
							}
							String link[] = inputLine.split("\"");
							song = new OnlineSong();
							song.OLS_set_name(link[7]);
							song.OLS_set_artist(link[9]);
							song.OLS_set_link_page_infor(link[3]);
							song.OLS_set_id(link[3].substring(link[3].lastIndexOf("-") + 1));
							result.add(song);				
							//	System.out.println(link[3]);
							//	System.out.println(link[7]);
							//	System.out.println(link[9]);
						}
					}
					break;
				}
			}
			in.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
		}
		return result;
	}

	public boolean OLS_getData(String url)
	{
		String urlFind = url;
		String inputLine;
		try
		{
			URL find = new URL(urlFind);
			BufferedReader in = new BufferedReader(new InputStreamReader(find.openStream()));
			while ((inputLine = in.readLine()) != null) {

				if (inputLine.contains("<img class=\"img_detail"))
				{	
					String urlimg[] = inputLine.split("\"");
					song_link_img = urlimg[3];
					//System.out.println(urlimg[3]);
				}
				if (inputLine.contains("sources: [{\"file\":"))
				{
					String link[] = inputLine.split("\"");
					link[3] = link[3].replace("\\/", "/");
					song_link_mp3 = link[3];
					song_link_lyric = "https://nhac.vn/lyric/" + song_id + ".vtt";
				//	System.out.println(link[3]);
				}
			}
			in.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return false;
		}
		return true;
	}
	
	public boolean OLS_getData()
	{
		String urlFind = song_link_page_infor;
		String inputLine;
		try
		{
			URL find = new URL(urlFind);
			BufferedReader in = new BufferedReader(new InputStreamReader(find.openStream()));
			while ((inputLine = in.readLine()) != null) {

				if (inputLine.contains("<img class=\"img_detail"))
				{	
					String urlimg[] = inputLine.split("\"");
					song_link_img = urlimg[3];
					//System.out.println(urlimg[3]);
				}
				if (inputLine.contains("sources: [{\"file\":"))
				{
					String link[] = inputLine.split("\"");
					link[3] = link[3].replace("\\/", "/");
					song_link_mp3 = link[3];
					song_link_lyric = "https://nhac.vn/lyric/" + song_id + ".vtt";
				//	System.out.println(link[3]);
				}
			}
			in.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			return false;
		}
		return true;
	}
	
	public ArrayList<OnlineSong> OLS_getAllSong(String url)
	{
		ArrayList<OnlineSong> result = new ArrayList<OnlineSong>();
		OnlineSong song = null;

		String urlFind = url;
		String inputLine;
		String[] content;
		String[] link;
		int currentIndex = 0;
		try
		{
			URL find = new URL(urlFind);
			BufferedReader in = new BufferedReader(new InputStreamReader(find.openStream()));
			while ((inputLine = in.readLine()) != null) {
				if (inputLine.contains("<ul class=\"list_item_music\""))
				{
					while((inputLine = in.readLine()) != null)
					{
						if(inputLine.contains("</ul>"))
						{
							break;
						}
						if (inputLine.contains("<li>"))
						{
							currentIndex++;
							song = new OnlineSong();
							for (int i = 0; i < 2; i++)
							{
								if((inputLine = in.readLine()) != null)
								{
									//	System.out.println(inputLine);
								}
							}
							//System.out.println("\t\t\t\t=====");
							if (currentIndex > 3)
							{
								inputLine = in.readLine();
							}

							link = inputLine.split("\"");
							song.OLS_set_link_page_infor(link[1]);
							inputLine = inputLine.replace("<", ">");
							content = inputLine.split(">");
							song.OLS_set_name(content[4]);
							
							result.add(song);
						}
					}
					break;
				}
			}
			in.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

}
