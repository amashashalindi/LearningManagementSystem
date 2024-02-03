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
@Document(collection="Teacher")
public class Teacher {
    @JsonProperty("id")
    private String id;
    private String firstName;
    private String lastName;
    private String nic;
    private String address;
    private String mobileNumber;

    public Teacher(String firstName, String lastName, String nic, String address, String mobileNumber) {
        this.id = new ObjectId().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.nic = nic;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }

    public Teacher() {
        this.id = new ObjectId().toString();
    }
}