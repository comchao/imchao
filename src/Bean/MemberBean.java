package Bean;

import java.sql.Timestamp;

public class MemberBean {
	int userid;
	String name;
	String username;
	String email;
	String password;
	Timestamp datetime;
	boolean valid;
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getDatetime() {
		return datetime;
	}
	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}
}
