package com.example.demo.entity;

import java.util.Date;

import lombok.Data;

//①DBとデータの受渡を行う
@Data//各フィールドのGetterSetterを生成するために使用(@Getter/@Setterでもいいのか、、)
public class User {

	private long id;
	private String name;
	private String address;
	private String phone;
	private Date updateDate;
	private Date createDate;
	private Date deleteDate;
	
}
