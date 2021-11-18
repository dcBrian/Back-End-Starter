package com.project.starter.models.dto;

public class SubmitReviewDTO {
    Long reviewId;
    String text;

    public SubmitReviewDTO(Long reviewId, String text) {
        this.reviewId = reviewId;
        this.text = text;
    }

    public Long getReviewId() {
        return this.reviewId;
    }

    public String getText() {
        return this.text;
    }
}
