package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.model.Announcement;
import com.example.learningmanagementsystem.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class AnnouncementController {
    @Autowired
    private AnnouncementRepository announcementRepository;

    @RequestMapping(value = "/saveAnnouncement", method = RequestMethod.POST)
    public String saveAnnouncement(@ModelAttribute("announcement") Announcement ancmnt){
        announcementRepository.save(ancmnt);
        return "redirect:/allAnnouncements";
    }

    @RequestMapping(value="/editAnnouncement/{id}")
    public ModelAndView showEditAnnouncementPage(@PathVariable(name = "id") String id) {
        ModelAndView mav = new ModelAndView("editannouncement");
        Optional<Announcement> ancmnt= announcementRepository.findById(id);
        mav.addObject("announcement", ancmnt);
        return mav;

    }
    @GetMapping("/allAnnouncements")
    public String getAnnouncements(Model model){
        List<Announcement>  listannouncement = announcementRepository.findAll();
        model.addAttribute("listannouncement",listannouncement);
        return "allannouncements";
    }

    @GetMapping("/newAnnouncement")
    public String newAnnouncementPage(Model model){
        model.addAttribute("announcement",new Announcement());
        return "newannouncement";
    }
    @RequestMapping("/deleteAnnouncement/{id}")
    public String deleteAnnouncement(@PathVariable String id){
        announcementRepository.deleteById(id);
        return "redirect:/allAnnouncements";
    }

}
