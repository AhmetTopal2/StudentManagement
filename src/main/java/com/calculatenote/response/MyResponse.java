package com.calculatenote.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class  MyResponse <T>  {

    private String status;

    private Date responseDate;

    private String URL;

    private T data;


   //getter setter status
    public String getStatus(){
       return status;
    }

    public void setStatus(String status){
       this.status=status;
    }

    //getter setter responseDate
    public Date getResponseDate(){
       return responseDate;
    }

    public void setResponseDate(Date responseDate) {
        this.responseDate = responseDate;
    }

    //getter setter URL

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    //getter setter Data

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
