package com.example.TH2.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.TH2.model.Books;
import com.example.TH2.repository.BookRepository;

@Controller
@RequestMapping("books")
public class bookController {
	@Autowired
	private BookRepository bookRepository;
	@GetMapping("addbooks")
	public String list(ModelMap model,@RequestParam Optional<String> message) {
		Iterable<Books> list = bookRepository.findAll();
		if(message.isPresent()) {
			model.addAttribute("message", message.get());
		}
		model.addAttribute("data",list);
		return "redirect:/books/listbooks";
	}
	
	@GetMapping
	public String listBooks(ModelMap model) {
		Iterable<Books> list = bookRepository.findAll();
		model.addAttribute("data", list);
		return "index";
	}
	@GetMapping("listbooks")
	public String Books(ModelMap model) {
		Iterable<Books> list = bookRepository.findAll();
		model.addAttribute("data", list);
		return "books/listBooks";
	}
	@GetMapping("/addbook")
	public String newRegister(ModelMap model) {
		Books books = new Books();
		model.addAttribute("data", books);
		
		return "books/addBook";
	}
	@PostMapping("newbook")
	public String newUser(RedirectAttributes atributes, Books item) {
		bookRepository.save(item);
		atributes.addAttribute("message","New user is saved!");
		return "redirect:/books/addbooks";
	}
	@GetMapping("/viewbook")
	public String viewBook(ModelMap model, @PathVariable String title) {
		
		
		
		return "books/viewBook";
	}
}
