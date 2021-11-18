package com.project.starter.models.dto;

import java.util.List;

public class AssignReviewDTO {
    Long owner;
    List<Long> writers;

    public AssignReviewDTO(List<Long> writers, Long owner) {
        this.writers = writers;
        this.owner = owner;
    }

    public Long getOwner() {
        return this.owner;
    }

    public List<Long> getWriters() {
        return this.writers;
    }

}
