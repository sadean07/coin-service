package com.justtrade.backendtwo.controller.advice;

import com.justtrade.backendtwo.controller.CoinController;
import com.justtrade.backendtwo.dto.ErrorResponseDto;
import com.justtrade.backendtwo.dto.error.ErrorConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.metadata.ConstraintDescriptor;
import java.lang.annotation.Annotation;
import java.net.BindException;
import java.util.Optional;
import java.util.Set;

@RestControllerAdvice(assignableTypes = {CoinController.class})
public class CoinCotrollerAdvice {

    @Autowired
    @Qualifier("constraintError")
    private ErrorConstraint errorConstraint;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ErrorResponseDto> handleException(ConstraintViolationException exception){

        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        Optional<ConstraintViolation<?>> violation = violations.stream().findFirst();
        String message = "";

        if (violation.isPresent()) {
            ConstraintDescriptor<?> constraintDescriptor = violation.get().getConstraintDescriptor();
            Annotation annotation = constraintDescriptor.getAnnotation();

            ErrorResponseDto responseDto = errorConstraint.get(annotation.annotationType().getSimpleName());
            message = responseDto.getErrorMessage();
        }

        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .errorMessage(message)
                .build();

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
