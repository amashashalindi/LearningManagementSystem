package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.model.DiscussionForum;
import com.example.learningmanagementsystem.repository.DiscussionForumRepository;
import com.example.learningmanagementsystem.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class DiscussionForumController {

    @Autowired
    private DiscussionForumRepository discussionForumRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    // Functionality of save comment button
    @RequestMapping (value="/saveComment", method=RequestMethod.POST)
    public String saveComment(@ModelAttribute("listComment") DiscussionForum df){
        Optional<DiscussionForum> dfNew = discussionForumRepository.findById((int)df.getId());
        if(dfNew.get().getComment() == null){
            dfNew.get().setComment(df.getComment());
        }else{
            dfNew.get().addNewComment(df.getComment());
        }
        DiscussionForum dfFinal = new DiscussionForum();
        dfFinal.setId(df.getId());
        dfFinal.setTitle(dfNew.get().getTitle());
        dfFinal.setComment(dfNew.get().getComment());
        discussionForumRepository.save(dfFinal);
        return "redirect:/allTopics";
    }

    // Functionality of save title button
    @RequestMapping (value="/saveTitle", method=RequestMethod.POST)
    public String saveTitle(@ModelAttribute("topic") DiscussionForum df){
        df.setId(sequenceGeneratorService.generateSequence(DiscussionForum.SEQUENCE_NAME));
        discussionForumRepository.save(df);
        return "redirect:/allTopics";
    }

    // Save updated content
    @RequestMapping(value = "/saveExistingTopic", method = RequestMethod.POST)
    public String saveExistingTopic(@ModelAttribute("df") DiscussionForum df){
        Optional<DiscussionForum> dfNew = discussionForumRepository.findById((int)df.getId());
        //df.setTitle(dfNew.get().getTitle());
        dfNew.get().setTitle(df.getTitle());
        df.setTitle(dfNew.get().getTitle());
        df.setComment(dfNew.get().getComment());
        System.out.println("Working");
        discussionForumRepository.save(df);
        return "editTopic";
    }

    // Add comment route
    @RequestMapping(value = "/addComment/{id}")
    public ModelAndView addComment(@PathVariable long id, Model model){
        ModelAndView mav = new ModelAndView("addComment");
        DiscussionForum df = new DiscussionForum();
        df.setId(id);
        mav.addObject("listComment", df);
        System.out.println(mav);
        return mav;
    }

     //Add topic route
    @GetMapping("/addTopic")
    public String addTopic(Model model){
        model.addAttribute("topic",new DiscussionForum());
        return "createTopic";
    }

    // Get all comments
    @GetMapping("/allComments/{id}")
    public String getComments(@PathVariable long id, Model model){
        Optional<DiscussionForum> listForum = discussionForumRepository.findById((int)id);
        System.out.println("listForum=" + listForum);
        DiscussionForum dfn = new DiscussionForum();
        dfn.setComment(listForum.get().getComment());
        model.addAttribute("listForum",dfn.getComment());
        System.out.println("dfn=" + dfn);
        return "discussionForum";
    }

    // Get all topics
    @GetMapping("/allTopics")
    public String getTitles(Model model){
        List<DiscussionForum> listTopics = discussionForumRepository.findAll();
        model.addAttribute("listTopics",listTopics);
        return "allTitles";
    }

    // Delete comment
    @RequestMapping("/deleteTopic/{id}")
    public String deleteTopic(@PathVariable long id){
        discussionForumRepository.deleteById((int)id);
        return "redirect:/allTopics";
    }

    //Edit comment
    @RequestMapping(value="/editTopic/{id}")
    public ModelAndView showEditTopicPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("editTopic");
        Optional<DiscussionForum> df = discussionForumRepository.findById((int)id);
        mav.addObject("df", df);
        return mav;
    }
}
