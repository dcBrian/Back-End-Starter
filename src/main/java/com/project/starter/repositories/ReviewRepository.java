package com.project.starter.repositories;

import java.util.List;

import com.project.starter.models.Review;
import com.project.starter.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByOwner(User user);

    List<Review> findByOwnerAndStatus(User owner, boolean status);

    List<Review> findByWriter(User writer);

    List<Review> findByWriterAndStatus(User writer, boolean status);

}
