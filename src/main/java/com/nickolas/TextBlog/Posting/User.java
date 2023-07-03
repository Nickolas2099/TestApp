package com.nickolas.TextBlog.Posting;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    private int id;
    @Column(name = "nickname")
    private String nickname;

}
