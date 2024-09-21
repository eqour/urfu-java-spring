package ru.eqour.spring.lab2.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import ru.eqour.spring.lab2.exception.UnsupportedCodeException;
import ru.eqour.spring.lab2.exception.ValidationFailedException;

import java.util.Objects;

@Service
public class RequestValidationService implements ValidationService {

    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException {
        if (bindingResult.hasErrors()) {
           FieldError fieldError = bindingResult.getFieldError("uid");
           if (fieldError != null && Objects.equals(fieldError.getRejectedValue(), "123")) {
               throw new UnsupportedCodeException();
           }

            throw new ValidationFailedException(Objects.requireNonNull(bindingResult.getFieldError()).toString());
        }
    }
}
