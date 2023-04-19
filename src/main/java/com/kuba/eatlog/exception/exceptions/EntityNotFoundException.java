package com.kuba.eatlog.exception.exceptions;

import com.kuba.eatlog.exception.messages.ExceptionMessages;

public class EntityNotFoundException extends RuntimeException{

    public <T> EntityNotFoundException(Class<T> clazz, Long id) {
        super(String.format(ExceptionMessages.ENTITY_NOT_FOUND.getMessage(), clazz.getName(), id));
    }
}
