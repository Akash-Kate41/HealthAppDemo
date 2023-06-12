package com.example.demo.Entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String userName;
	
	private String password;
	
	private String name;
	
	private String emailId;
	
	private LocalDate DOB;
	
	private String  bloodGroup;
	
	private String gender;	
	
	private String contactNo;
	
	private String address;

	public User() {	
		super();
		
	}

	public User(String userId, String password, String name, String emailId, LocalDate dOB, String bloodGroup,
			String gender, String contactNo, String address) {
		super();
		this.userName = userId;
		this.password = password;
		this.name = name;
		this.emailId = emailId;
		this.DOB = dOB;
		this.bloodGroup = bloodGroup;
		this.gender = gender;
		this.contactNo = contactNo;
		this.address = address;
	}

	public String getUserId() {
		return userName;
	}

	public void setUserId(String userId) {
		this.userName = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
