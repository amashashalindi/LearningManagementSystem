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
@Document(collection="Announcement")
public class Announcement {
    @JsonProperty("id")
    private String id;
    private String announcementName;
    private String postedDate;
    private String postedBy;
    private String description;




    public Announcement( String announcementName, String postedDate, String postedBy, String description) {
        this.id = new ObjectId().toString();
        this.announcementName = announcementName;
        this.postedDate = postedDate;
        this.postedBy = postedBy;
        this.description = description;

    }

    public Announcement() {
        this.id = new ObjectId().toString();
    }
}
