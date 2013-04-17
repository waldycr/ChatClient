import java.io.*;
public class Account {
	private String username;
	private int password;
	private String email;
	
	
	public Account(String username, int password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Account(String username, int password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
