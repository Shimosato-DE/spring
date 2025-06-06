package com.example.demo.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserUpdateRequest extends UserRequest implements Serializable{

	@NotNull
	private long id;
	
}
