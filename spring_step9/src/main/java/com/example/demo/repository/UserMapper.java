package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.User;

//⑤Service層からIDを引数をして受取、XML記載の対象のidでSQLクエリを実行。DBからUserエンティティにバインドされた結果をService層に返す。
@Mapper//MyBatisのMapperインタフェースであることを示す
public interface UserMapper {

   public abstract User search(UserSearchRequest user);//戻り値User型で、DBから検索された情報をUserエンティティとして返す
    									//searchメソッド(XMLのid属性と対応)
    									//メソッド引数は、UserSearchRequest型のuserオブジェクト(id)を受け取る。
    									//mybatisがuserオブジェクトのGetterメソッドを使ってidを取得し、SQLクエリの#{id}に値をバインドする。
}