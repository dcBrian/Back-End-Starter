package com.project.starter.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "review_owner")
    private final User owner;

    @ManyToOne
    @JoinColumn(name = "review_writer")
    private final User writer;

    @Column(name = "review_status")
    private boolean status;

    @Column(name = "review_text")
    private String text;

    public Review(User owner, User writer) {
        if (owner.getId().equals(writer.getId())) {
            throw new RuntimeException("Can't self review!");
        }
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
