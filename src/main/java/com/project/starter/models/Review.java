package com.project.starter.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private final User owner;

    @ManyToOne
    private final User writer;

    private boolean status;

    private String text;

    public Review(User owner, User writer) {
        this.owner = owner;
        this.writer = writer;
        this.status = false;
    }

    public Long getId() {
        return this.id;
    }

    public User getOwner() {
        return this.owner;
    }

    public User getWriter() {
        return this.writer;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
