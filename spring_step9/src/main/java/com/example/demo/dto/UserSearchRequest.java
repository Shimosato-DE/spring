package com.example.demo.dto;

import java.io.Serializable;

import lombok.Data;

//① フォームで受渡を行うデータを定義
@Data
public class UserSearchRequest implements Serializable{

	private long id;
	
}
