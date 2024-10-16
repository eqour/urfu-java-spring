package ru.eqour.spring.secondservice.service;

import org.springframework.validation.BindingResult;
import ru.eqour.spring.secondservice.exception.UnsupportedCodeException;
import ru.eqour.spring.secondservice.exception.ValidationFailedException;

public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException;
}
