package com.project.starter.repositories;

import java.util.List;

import com.project.starter.models.Review;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByOwner(Long user);

    List<Review> findByWriterAndStatusIsFalse(Long writerId);

    List<Review> findByWriter(Long writerId);
}
