package com.nickolas.TextBlog.Posting;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "post")
public class Post {

    @Id
    private int id;
    @Column(name = "content")
    private String content;
    @Column(name = "post_time")
    private Timestamp postTime;
    @JoinColumn(referencedColumnName = "user.id")
    private int userId;

}
