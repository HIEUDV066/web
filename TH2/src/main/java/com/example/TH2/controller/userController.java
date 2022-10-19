package com.example.TH2.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.TH2.model.User;
import com.example.TH2.repository.RegisterRepository;

@Controller
@RequestMapping("addUser")
public class userController {
	@Autowired
	private RegisterRepository registerRepository;
	
	
	@GetMapping
	public String list(ModelMap model,@RequestParam Optional<String> message) {
		Iterable<User> list = registerRepository.findAll();
		if(message.isPresent()) {
			model.addAttribute("message", message.get());
		}
		model.addAttribute("users",list);
		return "redirect:/books/listbooks";
	}
	
	@GetMapping("/newRegister")
	public String newRegister(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		
		return "users/registerUser";
	}
	@PostMapping("newUser")
	public String newUser(RedirectAttributes atributes, User item) {
		registerRepository.save(item);
		atributes.addAttribute("message","New user is saved!");
		return "redirect:/addUser";
	}
	
	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	public Optional<User> findByName(String name){
		return registerRepository.findByName(name);
	}
	
	@PostMapping("/checkLogin")
	public String checkLogin(RedirectAttributes atributes, @RequestParam("username")String username,
			@RequestParam("password")String password) {
		Optional<User> listUser = findByName(username);
		if(listUser.isPresent() && listUser.get().getPassword().equals(password)) {
			System.out.println("Login thanh cong");
			return "redirect:/books/listbooks";
		}else {
			System.out.println("login that bai");
		}
			
		return "books";
	}
}
