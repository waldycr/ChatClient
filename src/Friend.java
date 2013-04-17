import java.net.*;
import java.io.*;
public class Friend implements Serializable{
	private Status stat;
	private InetAddress address;
	private String username;
	
	public Status getStat() {
		return stat;
	}
	public void setStat(Status stat) {
		this.stat = stat;
	}
	public InetAddress getAddress() {
		return address;
	}
	public void setAddress(InetAddress address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
