package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;//@Autowiredを提供。DIを行う時につかう(ここではService層をDI)
import org.springframework.stereotype.Controller;//@Controllerを提供。ControllerとしてBean化する。
import org.springframework.ui.Model;//Modelを提供。Contorollerで受け取ったデータの保存、Viewへの受渡を行う。
import org.springframework.web.bind.annotation.GetMapping;//@GetMappingを提供。GETリクエストを処理するメソッドをマッピングする。
import org.springframework.web.bind.annotation.ModelAttribute;//@Modelattributeを提供。HTTPリクエストのパラメータをJavaオブジェクトにバインドしたり、モデルにデータを追加したりする。
import org.springframework.web.bind.annotation.PostMapping;//@PostMappingを提供。HTTP POSTリクエストを処理するメソッドをマッピングする。

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

		
		//UserSearchRequestをインスタン生成しTymeleafに渡す
//	  @GetMapping("/user/search")
//	  public String displaySearch(Model model) {
//	    model.addAttribute("userSearchRequest", new UserSearchRequest());
//	    return "user/search";
//	  }
	  //②user/searchでGetRequestを受取、ページを返す。ページ内で受渡を行うDTOのインスタンス生成
	  @GetMapping("/user/search")//Getリクエストを受け取る。
	  public String displaySearch(@ModelAttribute UserSearchRequest userSearchRequest) {//idの入力を受け付けるため、@ModelAttributeでUserSearchRequestで自動的にインスタンス生成をおこないmodelに追加する
	    return "user/search";//ページの表示
	  }
	  
	  
	  //③ユーザ情報検索ページからIDwoを受取、IDをサービス層へ渡し、検索結果を取得してページへ返す。
	  @PostMapping("/user/id_search")//Postリスエストを受取る。
	  public String search(@ModelAttribute UserSearchRequest userSearchRequest, Model model) {
	    User user = userService.search(userSearchRequest);//Service層のsearchメソッドを呼び出し、userに格納する。
	    model.addAttribute("userinfo", user);//userに格納した結果をuserinfoに渡す。
	    return "user/search";//ページの表示
	  }
}
