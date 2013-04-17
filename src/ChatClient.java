
import java.io.*;
import java.net.*;

public class ChatClient {

	Socket socket;
	private ObjectOutputStream output = null;
	private ObjectInputStream input = null;
	private FriendList FL = null;
	private Account myacc = null;
	
	
	
	public ChatClient(Socket socket, FriendList fL) {
		super();
		this.socket = socket;
		FL = new FriendList(socket);
		input = new ObjectOutputStream(socket.getOutputStream());
		output = new ObjectInputStream(socket.getInputStream());
		
	}

	public void connect(){
		System.out.println("Client Program Started...");
		System.out.println("Client Program Connecting...");
		RequestData inputData;

		while(socket.isConnected()){
			inputData = (RequestData) input.readObject();

			if(inputData != null){
				switch(inputData.getRequest()){
				case login:
					myacc = (Account) inputData.getObj();
					FL.getList();
				case refresh:
					FL = (FriendList) inputData.getObj();
					break;
				case logoff:
					socket.close();
					break;
				case error:
					System.out.println("Server: " + (String)inputData.getObj());
					break;
				default:
					break;

				}
			}

		}
	}
	
	public void getFriendList(){
		FL.getList();
	}
	
	public void setStatus(Status stat){
		RequestData request = new RequestData(RequestID.setstatus,stat);
		try {
			output.writeObject(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}
	
	public void login(String username, String password){
		myacc = new Account(username, password.hashCode());
		RequestData request = new RequestData(RequestID.login, myacc);
		output.writeObject(request);
	}
	
	public void logoff(){
		RequestData request = new RequestData(RequestID.logoff, null);
		output.writeObject(request);
	}

	
}
