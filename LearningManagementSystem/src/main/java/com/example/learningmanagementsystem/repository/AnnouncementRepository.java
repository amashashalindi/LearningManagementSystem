package com.example.learningmanagementsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
        import com.example.learningmanagementsystem.model.Announcement;

public interface AnnouncementRepository extends MongoRepository<Announcement, String> {

}