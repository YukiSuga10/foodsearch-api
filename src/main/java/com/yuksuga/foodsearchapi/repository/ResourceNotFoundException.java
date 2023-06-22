package com.yuksuga.foodsearchapi.repository;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable error){
        super(message, error);
    }
}
