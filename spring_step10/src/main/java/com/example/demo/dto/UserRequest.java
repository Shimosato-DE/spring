package com.example.demo.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.Data;

//①フォームから受け取るDTOを定義
@Data
public class UserRequest implements Serializable {
	
	@NotEmpty(message="入力してください")
	@Size(max=100, message="100文字以内で入力して下さい")
	private String name;


	
	@Size(max=255, message="255文字以内で入力して下さい")
	private String address;
	
	@Pattern(regexp="0\\\\d{1,4}-\\\\d{1,4}-\\\\d{4}", message="電話番号の形式で入力してください")
	private String phone;

	
	

}
