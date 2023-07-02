package com.nickolas.TextBlog.Posting;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    private int id;
    @Column(name = "nickname")
    private String nickname;

}
