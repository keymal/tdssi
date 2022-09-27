package com.example.tdssi.execption;

public class EntityAlreadyExistsException  extends RuntimeException{
    public EntityAlreadyExistsException() {
    }

    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
