package com.nickolas.TextBlog.Posting;

import com.nickolas.TextBlog.Services.UserService;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    @Transient
    static UserService userService;
    @Transient
    public static User getUserById(int id) {
        return userService.getById(id);
    }

}
