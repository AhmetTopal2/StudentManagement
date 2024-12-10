package com.calculatenote.response;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CreateResponse {

    public <T> MyResponse<T> ok(T data, HttpServletRequest request) {
        MyResponse<T> response = new MyResponse<>();
        response.setURL(request.getRequestURI());
        response.setResponseDate(new Date());
        response.setStatus("200 OK");
        response.setData(data);
        return response;
    }

    public <T> MyResponse<T> notFound(String message, HttpServletRequest request) {
        MyResponse<T> response = new MyResponse<>();
        response.setURL(request.getRequestURI());
        response.setResponseDate(new Date());
        response.setStatus("404 NOT FOUND");
        response.setData((T) message);
        return response;
    }
}
