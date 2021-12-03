package com.senla.haltvinizki.controller.handler;

import com.senla.haltvinizki.controller.handler.dto.ErrorMessageDto;
import com.senla.haltvinizki.service.exception.*;
import com.senla.haltvinizki.service.exception.category.CategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CategoryNotFoundException.class)
    public ErrorMessageDto errorMessageDto(CategoryNotFoundException categoryNotFoundException) {
        return ErrorMessageDto.builder()
                .name("Категория с id=" + categoryNotFoundException.getId() + " не найден").build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HistoryNotFoundException.class)
    public ErrorMessageDto errorMessageDto(HistoryNotFoundException historyNotFoundException) {
        return ErrorMessageDto.builder()
                .name("История с id=" + historyNotFoundException.getId() + " не найден").build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductConfigurationNotFoundException.class)
    public ErrorMessageDto errorMessageDto(ProductConfigurationNotFoundException productConfigurationNotFoundException) {
        return ErrorMessageDto.builder()
                .name("Конфигурация продукта с id=" + productConfigurationNotFoundException.getId() + " не найден").build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorMessageDto errorMessageDto(ProductNotFoundException productNotFoundException) {
        return ErrorMessageDto.builder()
                .name("Продукт с id=" + productNotFoundException.getId() + " не найден").build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RoleNotFoundException.class)
    public ErrorMessageDto errorMessageDto(RoleNotFoundException roleNotFoundException) {
        return ErrorMessageDto.builder()
                .name("Роль с id=" + roleNotFoundException.getId() + " не найден").build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorMessageDto errorMessageDto(UserNotFoundException userNotFoundException) {
        return ErrorMessageDto.builder()
                .name("Пользователь " + userNotFoundException.getMessage() + " не найден").build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ErrorMessageDto catchRuntimeException(Exception e){
        return ErrorMessageDto.builder()
                .name("cломалось").build();
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ErrorMessageDto catchAccessDeniedException(Exception e){
        return ErrorMessageDto.builder()
                    .name("нет прав").build();
    }
    @ResponseStatus(HttpStatus.PROXY_AUTHENTICATION_REQUIRED)
    @ExceptionHandler(AuthenticationException.class)
    public ErrorMessageDto catchAuthenticationException(Exception e){
        return ErrorMessageDto.builder()
                .name("ошибка аутенцификации").build();
    }




}
