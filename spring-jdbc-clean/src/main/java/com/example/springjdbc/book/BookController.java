package com.example.springjdbc.book;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
	private BookDAO bookDAO =new BookDAO();
	@GetMapping("/books")
	public String getBooks(Model model) throws IOException{
		List<Book> books=bookDAO.selectAllBooks();
		model.addAttribute("books",books);
		return "books";
		
		
	}
	@GetMapping("/book/{bookcode}")
	public String getBook(Model model,@PathVariable String bookcode) {
		model.addAttribute("bookcode",bookcode);
		Book book = bookDAO.selectBook(Integer.valueOf(bookcode));
		model.addAttribute("book",book);
		return "Book-detail";
	}
//	@PostMapping("/book/save/{bookcode}")
//	public String addBook(Book book, @PathVariable String bookcode) throws SQLException{
//		bookDAO.insertBook(book);
//		return "redirect:/books";
//	}
	@PostMapping("/book/save")
	public String addBook(Book book) throws SQLException{
		bookDAO.insertBook(book);
		return "redirect:/books";
	}
	
	@PutMapping("/book/save/{bookcode}")
	public String update(Book book, @PathVariable String bookcode) throws SQLException{
		bookDAO.updateBook(book);
		return "redirect:/books";
		
	}
	@GetMapping("/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addBook";
	}
	@RequestMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") String id,Model model) {
//		model.addAttribute("bookcode", id);
		bookDAO.deleteBook(Integer.valueOf(id));
		System.out.print(id);
//		model.addAttribute("book",book);
		return "redirect:/books";
	}
	
}
