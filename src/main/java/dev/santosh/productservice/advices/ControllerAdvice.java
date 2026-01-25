package dev.santosh.productservice.advices;

import dev.santosh.productservice.dtos.ErrorDTO;
import dev.santosh.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

public class ControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException(
            ProductNotFoundException ex) {

        ErrorDTO errorDTO = new ErrorDTO(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }
}
