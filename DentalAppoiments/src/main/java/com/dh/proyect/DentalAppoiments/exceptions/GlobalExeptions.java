package com.dh.proyect.DentalAppoiments.exceptions;

import com.dh.proyect.DentalAppoiments.controller.AppointmentController;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExeptions {
    private static final Logger LOGGER = LogManager.getLogger(AppointmentController.class);

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> throwErrorResourceNotFound(ResourceNotFoundException e) {
        LOGGER.error("Values or resources not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> throwErrorBadRequest (BadRequestException b) {
        LOGGER.error("Something went wrong with the request");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(b.getMessage());
    }
}
