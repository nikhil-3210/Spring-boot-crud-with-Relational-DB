package com.nikhiljadav.spring_boot_crud.exception;

public class UserNotFoundException extends Exception{

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
