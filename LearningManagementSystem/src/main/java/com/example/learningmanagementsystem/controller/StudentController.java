package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.model.Student;
import com.example.learningmanagementsystem.repository.StudentRepository;
import com.example.learningmanagementsystem.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student std){
        studentRepository.save(std);
        return "redirect:/allStudents";
    }

    @RequestMapping(value="/editStudent/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") String id) {
        ModelAndView mav = new ModelAndView("editsStudent");
        Optional<Student> std = studentRepository.findById(id);
        mav.addObject("student", std);
        return mav;

    }
    @GetMapping("/allStudents")
    public String getStudents(Model model){
        List<Student>  liststudent = studentRepository.findAll();
        model.addAttribute("liststudent",liststudent);
        return "allstudents";
    }

    @GetMapping("/newStudent")
    public String newStudentPage(Model model){
        model.addAttribute("student",new Student());
        return "newstudent";
    }
    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id){
        studentRepository.deleteById(id);
        return "redirect:/allStudents";
    }

}

