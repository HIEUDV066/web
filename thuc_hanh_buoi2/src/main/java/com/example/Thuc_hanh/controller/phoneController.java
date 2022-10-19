package com.example.Thuc_hanh.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Thuc_hanh.model.Phone;

import com.example.Thuc_hanh.repository.PhoneRepository;



@Controller
@RequestMapping("phone")
public class phoneController {
	@Autowired
	private PhoneRepository phoneRepository;
	
	@GetMapping()
	public String phones(ModelMap model) {
		Iterable<Phone> list = phoneRepository.findAll();
		model.addAttribute("data", list);
		return "index";
	}
	@GetMapping("/addphone")
	public String newPhone(ModelMap model) {
		Phone phone = new Phone();
		model.addAttribute("phone", phone);
		
		return "addStudent";
	}

	
	@RequestMapping("newphone")
    public String Add(@Valid @ModelAttribute("phone") Phone phone, BindingResult result, Model model) throws SQLException{
        Phone a = phoneRepository.findPhoneById(phone.getId());
        if(result.hasErrors()){
        	
            if(a != null)
            model.addAttribute("error","ID bị trùng");
            return "addStudent";
        }

        if(a != null){
            model.addAttribute("error","ID bị trùng");
            model.addAttribute("phone", new Phone());
            return "addStudent";
        }
        phoneRepository.save(phone);
        return "redirect:/phone";
    }
	
	@GetMapping("/editphone/{id}")
	public ModelAndView showEditPhone(@PathVariable(name="id") String id) {
		ModelAndView edit = new ModelAndView("editForm");
		Phone st = phoneRepository.findPhoneById(id);
		edit.addObject("student",st);
		return edit;
	}
	@PostMapping("/updatephone")
	public String newUser(RedirectAttributes atributes,ModelMap model,
			@Valid Phone phone, BindingResult result) {
		if (result.hasErrors()) {
			return "editForm";
		}
		phoneRepository.save(phone);
		
		return "redirect:/phone";
	}
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(name="id") String id) {
		phoneRepository.deleteById(id);
		return "redirect:/phone";
	}
}
