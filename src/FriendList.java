import java.io.*;
import java.net.*;

public class FriendList implements Serializable {

	private Socket socket = null;
	private ObjectOutputStream output = null;
	private static final long serialVersionUID = 1L;
	private Friend[] friends = new Friend[100];

	public FriendList(Socket socket) {
		super();
		this.socket = socket;
		try{
		output = new ObjectOutputStream(socket.getOutputStream());
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	
	public void getList(){
		RequestID request = RequestID.getlist;
		try {
			output.writeObject(new RequestData(request, this));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void addFriend(String username){
		RequestID request = RequestID.addfriend;
		
		try {
			output.writeObject(new RequestData(request, username));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteFriend(String username){
		RequestID request = RequestID.deletefriend;
		
		try {
			output.writeObject(new RequestData(request, username));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sync(){
		
	}
}
