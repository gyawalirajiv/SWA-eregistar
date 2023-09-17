package com.gyawalirajiv.eregistrar.controllers;

import com.gyawalirajiv.eregistrar.models.Student;
import com.gyawalirajiv.eregistrar.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    public String getAll(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "index";
    }


    @GetMapping("/create")
    public String createGet(Model model){
        model.addAttribute("student", new Student());
        return "create";

    }

    @PostMapping("/create")
    public String createPost(Model model, @ModelAttribute Student student){
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateGet(Model model, @PathVariable Long id){
        model.addAttribute("student", studentService.findOne(id));
        return "/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        studentService.delete(id);
        return "redirect:/";
    }

}
