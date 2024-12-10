package com.calculatenote.exception.handler;

import com.calculatenote.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

//butun exceptionlari yakalayan sinifimiz
@ControllerAdvice
public class GlobalExceptionHandler {

    //Base Exceptiontan firlatilan siniflari burada yakaladim
    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ApiError<String>> handleBaseException(BaseException ex , WebRequest request){
        return ResponseEntity.badRequest().body(createApiError(request , ex.getMessage()));
    }


    private String getHostName(){
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            System.out.println("hata");
        }
        return null;
    }


    public <T> ApiError<T> createApiError(WebRequest request , T message){
        ApiError<T> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());

        Exception<T> exception = new Exception<>();
        exception.setDateTime(new Date());
        exception.setHostName(getHostName());
        exception.setPath(request.getDescription(false).substring(4));
        exception.setMessage(message);

        apiError.setException(exception);

        return apiError;
    }

 }
