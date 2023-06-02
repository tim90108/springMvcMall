package com.memInfo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEM_INFO")

public class MemInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="ACCOUNT")
	private String account;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="SEX")
	private String sex;
	
	@Column(name="EMAIL")
	private String email;
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", account=" + account + ", password=" + password + ", name=" + name + ", sex="
				+ sex + ", email=" + email + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
