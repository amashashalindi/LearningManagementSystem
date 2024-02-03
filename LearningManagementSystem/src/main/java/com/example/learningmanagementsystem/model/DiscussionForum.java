package com.example.learningmanagementsystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Getter
@Setter
@ToString
@Document(collection = "Discussion_Forum")
public class DiscussionForum {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    private long id;
    private String title;

    private List<String> comment;

    public DiscussionForum(String title, List<String> comment) {
        this.title = title;
        this.comment = comment;
    }

    public DiscussionForum() {

    }

    public void addNewComment(List<String> newComment){
        this.comment.addAll(newComment);
    }

}