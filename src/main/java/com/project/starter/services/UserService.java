package com.project.starter.services;

import java.util.List;

import com.project.starter.models.User;
import com.project.starter.models.errors.ResourceNotFoundException;
import com.project.starter.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getOneEntity(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException(String.format("User with id %s could not be found.", userId)));
    }

    public List<User> getAllEntities() {
        return userRepository.findAll();
    }

    public List<User> getEntitiesByIds(List<Long> ids) {
        return userRepository.findAllById(ids);
    }

}
