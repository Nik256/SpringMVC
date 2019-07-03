package com.epam.mvc.exception;

public class AchievedMaxNumberOfRequestsException extends RuntimeException {
    public AchievedMaxNumberOfRequestsException(String message) {
        super(message);
    }
}
