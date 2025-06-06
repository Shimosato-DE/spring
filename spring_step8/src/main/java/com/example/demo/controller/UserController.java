package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;//Listインターフェイスのimport 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user/list")
	public String dispalayList(Model model) {
		List<User> userList = userService.searchByAll();
		model.addAttribute("userlist", userList);
		return "user/list";
	}

	@GetMapping("/user/add")
	public String displayAdd(Model model) {
		model.addAttribute("userRequest", new UserRequest());
		//templateにDTO(UserRequest)
		return "user/add";
	}

	@PostMapping("/user/create")
	public String displayCreate(@Validated @ModelAttribute UserRequest request, BindingResult result, Model model,  RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			//入力チェックでエラーの場合
			List<String> errorList = new ArrayList<String>();
			for(ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}

			model.addAttribute("validationError", errorList);
			return "/user/add";
			}
		
			userService.create(request);
			return "redirect:/user/list";		
			
//		if(userService.isPhoneAlreadyExists(request.getPhone())) {
//			
//			//同じ電話番号がすでにDBに登録されていれば、登録不可。
//			redirectAttributes.addFlashAttribute("validationError", "すでに登録されている電話番号です");
//			return "redirect:/user/add";
//		}else {
//			userService.create(request);
//			return "redirect:/user/list";
//		}	
	}

	
	@GetMapping("/user/{id}")
	public String displayView(@PathVariable long id, Model model) {
		User user = userService.findById(id);//送信されてきたIDに対応するレコードを取得
		model.addAttribute("userData", user);//ページへuserインスタンスを渡す
		return "user/view";//viewを返す
	}

	@GetMapping("/user/{id}/edit")
	public String displayEdit(@PathVariable long id, Model model) {
		User user = userService.findById(id);//送信されてきたIDに対応するレコードを取得、userへ格納
		UserUpdateRequest userUpdateRequest = new UserUpdateRequest();//UpDateインスタンス生成
		userUpdateRequest.setId(user.getId());//userのidフィールドの値をgetし、setでUpDateインスタンスのフィールドへ格納
		userUpdateRequest.setName(user.getName());
		userUpdateRequest.setPhone(user.getPhone());
		userUpdateRequest.setAddress(user.getAddress());
		model.addAttribute("userUpdateRequest", userUpdateRequest);//ページへUpDateインスタンスを渡す
		return "user/edit";//editページを返す

	}
	
	@PostMapping("/user/update")
	public String update(@Validated @ModelAttribute UserUpdateRequest userUpdateRequest, BindingResult result, Model model) {
		

		if(result.hasErrors()) {
			//入力チェックでエラーの場合
			List<String> errorList = new ArrayList<String>();
			for(ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}

			model.addAttribute("validationError", errorList);
			return "/user/editr";
			}
		
		userService.update(userUpdateRequest);
		return String.format("redirect:/user/%d", userUpdateRequest.getId());
	}

}
