package com.spotifyservice.spotifyservice.configuration.exeptions;

public class CustomException extends RuntimeException{

    public CustomException() {
    }
    public CustomException(String message) {
        super(message);
    }
}
