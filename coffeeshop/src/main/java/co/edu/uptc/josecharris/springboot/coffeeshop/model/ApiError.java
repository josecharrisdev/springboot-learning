package co.edu.uptc.josecharris.springboot.coffeeshop.model;

public class ApiError {
	private int code;
	private String message;
	private long timestamp;
	
	public ApiError() {
		
	}
	
	public ApiError(int code, String message) {
		super();
		this.code = code;
		this.message = message;
		this.timestamp = System.currentTimeMillis();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	
}
