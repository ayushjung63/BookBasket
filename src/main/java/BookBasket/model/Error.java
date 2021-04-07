package BookBasket.model;

public class Error {
	int status;
	String message;
	

	public Error() {
		super();
	}
	
	public Error(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Error [status=" + status + ", message=" + message + "]";
	}
	
	
	
}
