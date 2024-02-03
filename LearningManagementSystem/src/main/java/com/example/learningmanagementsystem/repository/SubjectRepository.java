package com.example.learningmanagementsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.learningmanagementsystem.model.Subject;

public interface SubjectRepository extends MongoRepository<Subject, String> {

}
