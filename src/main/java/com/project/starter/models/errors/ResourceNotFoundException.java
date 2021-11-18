package com.project.starter.models.errors;

public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException(String msg) {
    super(msg);
  }
}