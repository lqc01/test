package pojo;
public class UserForm {
	private int id;
	public String uname;//涓庤姹傚弬鏁板悕绉扮浉鍚�
	private String upass;
	private String reupass;
	public double money;
	
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getReupass() {
		return reupass;
	}
	public void setReupass(String reupass) {
		this.reupass = reupass;
	}
}
