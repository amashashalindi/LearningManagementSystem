package com.example.learningmanagementsystem.controller;


import com.example.learningmanagementsystem.model.Subject;
import com.example.learningmanagementsystem.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class SubjectController {
    @Autowired
    private SubjectRepository subjectRepository;

    @RequestMapping(value = "/saveSubject", method = RequestMethod.POST)
    public String saveSubject(@ModelAttribute("subject") Subject sub){
        subjectRepository.save(sub);
        return "redirect:/allSubjects";
    }

    @RequestMapping(value="/editSubject/{id}")
    public ModelAndView showEditSubjectPage(@PathVariable(name = "id") String id) {
        ModelAndView mav = new ModelAndView("editsubject");
        Optional<Subject> sub = subjectRepository.findById(id);
        mav.addObject("subject", sub);
        return mav;

    }
    @GetMapping("/allSubjects")
    public String getSubjects(Model model){
        List<Subject> listsubject = subjectRepository.findAll();
        model.addAttribute("listsubject",listsubject);
        return "allsubjects";
    }

    @GetMapping("/newSubject")
    public String newSubjectPage(Model model){
        //Subject sub = new Subject();...sub
        model.addAttribute("subject",new Subject());
        return "newsubject";
    }
    @RequestMapping("/remove/{id}")
    public String deleteSubject(@PathVariable String id){
        subjectRepository.deleteById(id);
        return "redirect:/allSubjects";
    }
}