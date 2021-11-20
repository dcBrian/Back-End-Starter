package com.project.starter.services;

import java.util.List;
import java.util.stream.Collectors;

import com.project.starter.models.Review;
import com.project.starter.models.User;
import com.project.starter.models.dto.AssignReviewDTO;
import com.project.starter.models.dto.SubmitReviewDTO;
import com.project.starter.models.errors.ResourceNotFoundException;
import com.project.starter.repositories.ReviewRepository;
import com.project.starter.utils.Utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserService userService;

    @Autowired
    public ReviewService(UserService userService, ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
        this.userService = userService;
    }

    public Review getOneEntity(Long reviewId) {
        return reviewRepository.findById(reviewId).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Review with id %s could not be found.", reviewId)));
    }

    public List<Review> getAllEntities() {
        return reviewRepository.findAll();
    }

    // Retrieve By Owner
    public List<Review> getAllByOwner(Long ownerId) {
        User owner = userService.getOneEntity(ownerId);
        return reviewRepository.findByOwner(owner);
    }

    public List<Review> getAllByOwnerAndStatus(Long userId, boolean status) {
        User user = userService.getOneEntity(userId);
        return reviewRepository.findByOwnerAndStatus(user, status);
    }

    // Retrieve By Writer
    public List<Review> getAllByWriter(Long userId) {
        User writer = userService.getOneEntity(userId);
        return reviewRepository.findByWriter(writer);
    }

    public List<Review> getAllByWriterAndStatus(Long userId, boolean status) {
        User user = userService.getOneEntity(userId);
        return reviewRepository.findByWriterAndStatus(user, status);
    }

    // Assign Review to Multiple Writers
    public void assignReview(AssignReviewDTO input) {
        List<User> writers = userService.getEntitiesByIds(input.getWriters());

        if (writers.size() != input.getWriters().size()) {
            List<Long> retrieved = writers.stream().map(e -> e.getId()).collect(Collectors.toList());
            List<Long> diff = Utilities.findDifferentElements(input.getWriters(), retrieved);
            throw new ResourceNotFoundException(String.format("Users with ids { %s }could not be found.", diff));
        }

        User owner = userService.getOneEntity(input.getOwner());
        List<Review> reviews = writers.stream().map(w -> new Review(owner, w)).collect(Collectors.toList());
        reviewRepository.saveAll(reviews);

    }

    // Submit Review
    public void submitReview(SubmitReviewDTO update) {
        Review review = this.getOneEntity(update.getReviewId());
        review.setText(update.getText());
        review.setStatus(true);
        reviewRepository.save(review);
    }
}
