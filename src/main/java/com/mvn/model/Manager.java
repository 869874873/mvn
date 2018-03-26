package com.mvn.model;

public class Manager {
	
	private Integer id;
	
	private String facultyName;
	
	private String facultyNo;
	
	private String facultyPhone;
	
	private String pwd;
	
	

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getFacultyNo() {
		return facultyNo;
	}

	public void setFacultyNo(String facultyNo) {
		this.facultyNo = facultyNo;
	}

	public String getFacultyPhone() {
		return facultyPhone;
	}

	public void setFacultyPhone(String facultyPhone) {
		this.facultyPhone = facultyPhone;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", facultyName=" + facultyName + ", facultyNo=" + facultyNo + ", facultyPhone="
				+ facultyPhone + "]";
	}
	
	

}
