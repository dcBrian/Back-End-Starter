package com.project.starter.controllers;

import java.util.List;

import com.project.starter.models.Review;
import com.project.starter.models.dto.AssignReviewDTO;
import com.project.starter.models.dto.SubmitReviewDTO;
import com.project.starter.services.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public Review one(@PathVariable Long id) {
        return reviewService.getOneEntity(id);
    }

    @GetMapping
    public List<Review> all() {
        return reviewService.getAllEntities();
    }

    @PostMapping("/submit")
    public void submitReview(@RequestBody SubmitReviewDTO input) {
        reviewService.submitReview(input);
    }

    @PostMapping("/assign")
    public void assignReviews(@RequestBody AssignReviewDTO input) {
        reviewService.assignReview(input);
    }
}
