package com.example.demo.entity;

import java.util.Date;

import lombok.Data;

@Data
public class User {
	
	private long id;
	private String name;
	private String address;
	private String phone;
	private Date updateDate;
	private Date createDate;
	private Date deloteDate;

}
