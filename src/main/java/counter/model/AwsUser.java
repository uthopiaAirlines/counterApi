package counter.model;

import java.io.Serializable;

import software.amazon.awssdk.services.cognitoidentityprovider.model.UserType;

public class AwsUser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4205499706780899816L;
	
	private String username;
	private String sub;
	private String email;
	private String phone;
	
	
	
	/**
	 * 
	 */
	public AwsUser(UserType user) {
		super();
		this.username = user.username();
		user.attributes().forEach(attri -> {
//			System.out.println(attri.name());
//			System.out.println(attri.value());
			
			if(attri.name().equals("sub")) {
				this.sub = attri.value();
			}
			
			else if (attri.name().equals("email"))
				this.email = attri.value();
			
			else if (attri.name().equals("phone_number"))
				this.phone = attri.value();
		});
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
