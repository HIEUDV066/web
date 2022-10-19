package com.ducnm.btl1.controller;

import com.ducnm.btl1.entities.Student;
import com.ducnm.btl1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController {
    @InitBinder
    public void initBinder(WebDataBinder data) {
        SimpleDateFormat sf = new SimpleDateFormat("MM-dd-yyyy");
        data.registerCustomEditor(Date.class, new CustomDateEditor(sf,true));
    }
    @Autowired
    private StudentService studentService;
    @RequestMapping("/")
    public String home(Model model){
        List<Student> students = studentService.getListStudent();
//        System.out.println(students.get(0));
        model.addAttribute("students",students);
        return "home";
    }
    @RequestMapping("/delete")
    public String delete (@RequestParam("id") String id){
        studentService.deleteStudent(id);
        return "redirect:/";
    }
    @RequestMapping("/formAdd")
    public String FormAdd(Model model){
        model.addAttribute("student", new Student());
        return "FormAdd";
    }
    @RequestMapping("/add")
    public String Add(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model){
        Student a = studentService.getStudent(student.getId());
        if(result.hasErrors()){
            if(a != null)
            model.addAttribute("error","ID bị trùng");
            return "FormAdd";
        }

        if(a != null){
            model.addAttribute("error","ID bị trùng");
            model.addAttribute("student", new Student());
            return "FormAdd";
        }
        Student b = studentService.insertStudent(student);
        return "redirect:/";
    }
    @RequestMapping("/formUpdate")
    public String FormAdd(@RequestParam("id") String id, Model model){
        model.addAttribute("student",studentService.getStudent(id));
        return "FormUpdate";
    }
    @RequestMapping("/update")
    public String Update(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model){
        if(result.hasErrors()){
            return "FormUpdate";
        }
        Student b = studentService.insertStudent(student);
        return "redirect:/";
    }
}
