package Backend.Weather.exception;

import Backend.Weather.payload.ErrorMessageDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(WeatherException.class)
    public ResponseEntity<ErrorMessageDto> weatherExceptionHandler(WeatherException exception, WebRequest request) {

        return new ResponseEntity<>(new ErrorMessageDto(exception.getMessage(), new Date(), request.getDescription(false)), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(InvalidDateRangeException.class)
    public ResponseEntity<ErrorMessageDto> weatherExceptionHandler(InvalidDateRangeException exception, WebRequest request) {


        return new ResponseEntity<>(new ErrorMessageDto(exception.getMessage(), new Date(), request.getDescription(false)), HttpStatus.BAD_REQUEST);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        Map<String, String> validationError = new HashMap<>();

        ex.getAllErrors().forEach(error -> {

            String fieldName = ((FieldError) error).getField();
            String msg = error.getDefaultMessage();
            validationError.put(fieldName, msg);
        });


        return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessageDto> globalExceptionHandling(
            Exception exception,
            WebRequest webRequest
    ) {

        return new ResponseEntity<>(

                new ErrorMessageDto(exception.getMessage(), new Date(),
                        webRequest.getDescription(false))
                ,
                HttpStatus.INTERNAL_SERVER_ERROR
        );

    }


}
