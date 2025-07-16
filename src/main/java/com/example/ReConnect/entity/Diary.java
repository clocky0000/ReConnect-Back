package com.example.ReConnect.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "diaries")
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String userId;
    private String title;
    private LocalDate date;

    @Column(columnDefinition = "TEXT")
    private String content;

    private boolean submitted = false;

    public Diary() {}

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }
}
