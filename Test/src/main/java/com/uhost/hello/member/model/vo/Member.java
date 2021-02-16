package com.uhost.hello.member.model.vo;

public class Member {
	private int no;
	private String name;
	private String address;
	private String phone;
	private String gender;
	
	public Member() {};
	
	public Member(int no, String name, String address, String phone, String gender) {
		super();
		this.no = no;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Member [no=" + no + ", name=" + name + ", address=" + address + ", phone=" + phone + ", gender="
				+ gender + "]";
	}
	
}
