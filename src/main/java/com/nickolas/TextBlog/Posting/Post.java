package com.nickolas.TextBlog.Posting;

import com.nickolas.TextBlog.Services.UserService;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
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

    @Transient
    private String nickname;
}
