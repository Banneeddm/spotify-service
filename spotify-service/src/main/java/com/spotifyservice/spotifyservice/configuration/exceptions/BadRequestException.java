package com.spotifyservice.spotifyservice.configuration.exceptions;

public class BadRequestException extends Exception{
    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
}
