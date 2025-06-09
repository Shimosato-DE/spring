package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserRequest;

@Controller
public class UserController {
	//②Getリクエストを受取ページを返す。
	@GetMapping("/user/add")//Getリクエスト
	public String displayAdd(@ModelAttribute UserRequest userRequest) {//UserRequestインスタン生成後、ModelにuserRequestとして格納
		return "user/add";//ページ返す
	}
	
	//③Post利すエストを受け取りページを返す。エラーがあった場合、発生下エラーを"ValidationError"にリスト形式で格納してページに表示。
	@PostMapping("/user/create")
	public String create(@Validated @ModelAttribute UserRequest userRequest ,BindingResult result, Model model) {
		
		if(result.hasErrors()) {//バリデーションエラーがある場合この処理へ。
			List<String> errorList = new ArrayList<String>();//バリデーションで発生した全てのエラーを格納するためのStringリストを作成。
			for(ObjectError error: result.getAllErrors()){//result.getAllErrors()は、バリデーション中に発生した全てのエラーオブジェクトをリストとして取得。
				errorList.add(error.getDefaultMessage());//各 ObjectErrorオブジェクトから、デフォルトのエラーメッセージを取得し、errorList に追加
			}
			model.addAttribute("validationError", errorList);//エラーリストに格納されているエラーをtymeleafに表示
			return "user/add";
		}
		
		return "user/add";
	} 
}
