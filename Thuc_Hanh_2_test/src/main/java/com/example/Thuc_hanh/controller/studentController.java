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

import com.example.Thuc_hanh.model.Student;
import com.example.Thuc_hanh.repository.StudentRepository;

@Controller
@RequestMapping("student")
public class studentController {
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping()
	public String Books(ModelMap model) {
		Iterable<Student> list = studentRepository.findAll();
		model.addAttribute("data", list);
		return "index";
	}
	@GetMapping("/addstudent")
	public String newStudent(ModelMap model) {
		Student student = new Student();
		model.addAttribute("student", student);
		
		return "addStudent";
	}

	
	@RequestMapping("newstudent")
    public String Add(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) throws SQLException{
        Student a = studentRepository.findStudentById(student.getId());
        if(result.hasErrors()){
        	
            if(a != null)
            model.addAttribute("error","ID bị trùng");
            return "addStudent";
        }

        if(a != null){
            model.addAttribute("error","ID bị trùng");
            model.addAttribute("student", new Student());
            return "addStudent";
        }
        studentRepository.save(student);
        return "redirect:/student";
    }
	
	@GetMapping("/editstudent/{id}")
	public ModelAndView showEditStudent(@PathVariable(name="id") String id) {
		ModelAndView edit = new ModelAndView("editForm");
		Student st = studentRepository.findStudentById(id);
		edit.addObject("student",st);
		return edit;
	}
	@PostMapping("/updatestudent")
	public String newUser(RedirectAttributes atributes,ModelMap model,
			@Valid Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "editForm";
		}
		studentRepository.save(student);
		
		return "redirect:/student";
	}
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(name="id") String id) {
		studentRepository.deleteById(id);
		return "redirect:/student";
	}
}
