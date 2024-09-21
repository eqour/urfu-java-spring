package ru.eqour.spring.lab2.service;

import org.springframework.validation.BindingResult;
import ru.eqour.spring.lab2.exception.UnsupportedCodeException;
import ru.eqour.spring.lab2.exception.ValidationFailedException;

public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException;
}
