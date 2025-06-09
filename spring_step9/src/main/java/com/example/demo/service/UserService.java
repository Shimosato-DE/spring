package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserMapper;

@Service
public class UserService {

	
    @Autowired
    private UserMapper userMapper;//Repository層をDI

    //④コントローラーから引数IDを受取、Repository層の処理結果を返す。
    public User search(UserSearchRequest userSearchRequest) {//searchメソッドを定義。引数はUserSearchRequest型の userSearchRequest　※ここではidのみ
        return userMapper.search(userSearchRequest);//searchメソッドの処理内容の記載
        											//Repositry層UserMapperクラスのsearchメソッドの実行を行う。
        											//引数はuserSearchRequest(id)を渡して、Userエンティティを返す。
    }
}