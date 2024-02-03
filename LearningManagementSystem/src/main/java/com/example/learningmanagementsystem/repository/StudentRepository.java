package com.example.learningmanagementsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.learningmanagementsystem.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

}