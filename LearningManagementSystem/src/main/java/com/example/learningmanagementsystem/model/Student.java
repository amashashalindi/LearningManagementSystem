package com.example.learningmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@ToString
@Document(collection="Student")
public class Student {
    @JsonProperty("id")
    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String address;

    public Student(String firstName, String lastName, String dateOfBirth, String address) {
        this.id = new ObjectId().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public Student() {
        this.id = new ObjectId().toString();
    }
}
