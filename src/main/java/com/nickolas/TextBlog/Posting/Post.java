package com.nickolas.TextBlog.Posting;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class Post {

    @Id
    private int id;
    @Column(name = "content")
    private String content;
    @Column(name = "post_time")
    private Date postTime;
    @JoinColumn(referencedColumnName = "user.id")
    private int userId;

}
