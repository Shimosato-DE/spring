package com.example.demo.repository;

import java.util.Optional;//存在するかもしれないし、存在しないかもしれない。という状況を明示的に示すためのコンテナオブジェクト

import org.springframework.data.jpa.repository.JpaRepository;//JpaRepository を使用するための import 
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

//JpaRepositoryを継承
@Repository
public interface UserRepository extends JpaRepository <User, Long>{
	
	Optional<User> findByPhone(String phone);
	
}