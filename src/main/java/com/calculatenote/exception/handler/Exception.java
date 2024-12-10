package com.calculatenote.exception.handler;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


public class Exception<T> {

    private String hostName;

    private String path;

    private Date dateTime;

    private T message;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}
