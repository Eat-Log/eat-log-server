package com.kuba.eatlog.exception.messages;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessages {

    ENTITY_NOT_FOUND("Entity %s for provided id: %s not found");

    private final String message;
}
