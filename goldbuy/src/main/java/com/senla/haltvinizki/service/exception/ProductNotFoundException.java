package com.senla.haltvinizki.service.exception;

import lombok.Getter;

public class ProductNotFoundException extends RuntimeException {
    @Getter
    private final Long id;

    public ProductNotFoundException(Long id) {
        this.id = id;
    }
}
