package yama.database;
/**
 * 
 * @author yamateam
 * mail 	: yamateamhaui@gmail.com
 * address	: ĐH Công Nghiệp Hà Nội-Nhổn-Bắc Từ Liêm-Hà Nội-Việt Nam
 */
public class StatusDatabases {
	protected int isConnection;
	protected String errorConnection;
	protected int timeOut;
	public StatusDatabases() {
		// TODO Auto-generated constructor stub
		isConnection = 0;
		errorConnection = "";
		timeOut = 0;
	}
	public void SD_set_status(int status) {}
	public String SD_get_messsage_error() {
		return errorConnection;
	}
	public void SD_set_time_out(int time) {
		timeOut = time;
	}

}
