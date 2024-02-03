package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.model.DiscussionForum;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiscussionForumRepository extends MongoRepository<DiscussionForum, Integer> {

}

