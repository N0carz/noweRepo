package com.sda.exercises.exceptions;

public class NoFoodException extends Exception {
    private String message;


    public NoFoodException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "NoFoodException: " + message;
    }
}
