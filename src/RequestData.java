
public class RequestData {
	private RequestID request;
	private Object obj;
	
	
	public RequestData(RequestID request, Object obj) {
		super();
		this.request = request;
		this.obj = obj;
	}
	public RequestID getRequest() {
		return request;
	}
	public void setRequest(RequestID request) {
		this.request = request;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
}
