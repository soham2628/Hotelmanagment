package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="User")
public class User {
	@Id
	@SequenceGenerator(name="seq_User",sequenceName="UserSequence",initialValue=4000,allocationSize=100)
	@GeneratedValue(generator="seq_User")
	@Column(name="userId")
	private long userid;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="name")
	private String name;
	
	@Column(name="contactNumber")
	private long contactNumber;
	
	@Column(name="aadharNumber")
	private long aadharNumber;
	
	@Column(name="password")
	private String password;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="type")
	private String roles;

	
	public User(int userid, String userName, String name, long contactNumber, long aadharNumber, String password,
			boolean active, String roles) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.name = name;
		this.contactNumber = contactNumber;
		this.aadharNumber = aadharNumber;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}


	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	public long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", userName=" + userName + ", name=" + name + ", contactNumber="
				+ contactNumber + ", aadharNumber=" + aadharNumber + ", password=" + password + ", active=" + active
				+ ", roles=" + roles + "]";
	}
	
}
