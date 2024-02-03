package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeacherRepository extends MongoRepository<Teacher, String> {

}