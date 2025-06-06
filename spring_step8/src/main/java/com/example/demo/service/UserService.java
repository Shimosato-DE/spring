package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//該当クラスが「サービスクラス（ビジネスロジックを担当）」であることをSpringに知らせ、自動的にDIコンテナに登録するために使う

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	//
	public List<User> searchByAll(){
		return  userRepository.findAll();
		//findAll():JpaRepositoryインターフェースが提供するメソッド
		//データベース内のすべてのレコードを取得
	}
	
	public User findById(long id) {
		return userRepository.findById(id).get();
	}
		//findById():引数で取得したidのカラムを
	
	public void create(UserRequest userRequest) {
		Date now = new Date();
		User user = new User();
		user.setName(userRequest.getName());
		user.setAddress(userRequest.getAddress());
		user.setPhone(userRequest.getPhone());
		user.setCreateDate(now);
		user.setUpdateDate(now);
		userRepository.save(user);
		//save():JpaRepositoryインターフェースが提供するメソッド
		//引数は保存したいエンティティ/新規のエンティティは挿入/既存のエンティティは更新
	
		
	}
	
	public void update(UserUpdateRequest userUpdateRequest) {
		User user = findById(userUpdateRequest.getId());
		user.setAddress(userUpdateRequest.getAddress());
		user.setName(userUpdateRequest.getName());
		user.setPhone(userUpdateRequest.getPhone());
		user.setUpdateDate(new Date());
		userRepository.save(user);
	}
		
	public boolean isPhoneAlreadyExists(String phone) {
			return userRepository.findByPhone(phone).isPresent();
	}
}
