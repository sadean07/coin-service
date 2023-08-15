package com.justtrade.backendtwo.controller.advice;

import com.justtrade.backendtwo.controller.CoinController;
import com.justtrade.backendtwo.dto.ErrorResponseDto;
import com.justtrade.backendtwo.dto.error.DefaultErrorResponse;
import com.justtrade.backendtwo.dto.error.DetailError;
import com.justtrade.backendtwo.dto.error.ErrorConstraint;
import org.apache.tomcat.util.buf.StringUtils;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.metadata.ConstraintDescriptor;
import java.lang.annotation.Annotation;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice(assignableTypes = {CoinController.class})
public class CoinCotrollerAdvice {

    @Autowired
    @Qualifier("constraintError")
    private ErrorConstraint errorConstraint;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler({ConstraintViolationException.class, BindException.class})
    public DefaultErrorResponse handleException(BindException exception, HttpServletRequest request){

        BindingResult result = exception.getBindingResult();
        List<ObjectError> objectErrorList = result.getAllErrors();

        List<String> propertyPaths = new ArrayList<>();
        List<DetailError> detailErrorList = objectErrorList.stream().map(error -> {
                    ConstraintViolationImpl<?> constraintViolation = error.unwrap(ConstraintViolationImpl.class);
                    String propertyPath = constraintViolation.getPropertyPath().toString();

                    String errorCode = constraintViolation.getConstraintDescriptor().getAttributes()
                            .getOrDefault("code", error.getCode()).toString();

                    ErrorResponseDto responseDto = errorConstraint.get(errorCode);
                    propertyPaths.add(propertyPath);
                    return DetailError.builder()
                            .field(propertyPath)
                            .rejectedValue(constraintViolation.getInvalidValue())
                            .objectName(error.getObjectName())
                            .code(errorCode)
                            .defaultMessage(responseDto.getErrorMessage())
                            .build();
                })
                .collect(Collectors.toList());

        return DefaultErrorResponse.builder()
                .timestamp(LocalDateTime.now().toString())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message("Validation failed for " + exception.getObjectName() + "(" + StringUtils.join(propertyPaths, ',') + ")" + ".")
                .status(HttpStatus.BAD_REQUEST.value())
                .path(request.getRequestURI())
                .details(detailErrorList)
                .build();
    }
}
