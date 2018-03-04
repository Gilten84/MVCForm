package beans;

import java.io.Serializable;


public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user = "";
	private String email = "";
	private String password = "";
	
	private String message="";
	
	public String getMessage() {
		return message;
	}
	public User()
	{
		
	}
	public User(String user, String email, String password) {
		super();
		this.user = user;
		this.email = email;
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean validate()
	{
		if (this.user==""||this.email==""||this.password=="") {this.message="Please fill all fields"; return false;}
		if (!this.email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"))
		{
			this.message="Please enter correct email adress"; return false;
		}
		
		if (this.password.length()<8) { this.message="Password length should be at least 8 symbols"; return false;}
		
		return true;
	}

}
