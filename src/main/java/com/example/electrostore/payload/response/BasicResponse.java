package com.example.electrostore.payload.response;

import lombok.Data;

@Data
public class BasicResponse {
    private int statusCode=200;
    private String message="";
    private Object data;
}
