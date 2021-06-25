package jp.co.internous.kabuki.model.form;

import java.io.Serializable;

public class DestinationForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2736720122549944337L;
	
	private long id;
	private long userId;
	private String familyName;
	private String firstName;
	private String address;
	private String telNumber;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId=userId;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName=familyName;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber=telNumber;
	}
	

}
