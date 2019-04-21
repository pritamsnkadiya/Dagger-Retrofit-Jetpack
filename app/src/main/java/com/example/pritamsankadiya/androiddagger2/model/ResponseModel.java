package com.example.pritamsankadiya.androiddagger2.model;

public class ResponseModel {

    public String status;
    public ResponseResult result;

    @Override
    public String toString() {
        return "ResponseModel{" +
                "status='" + status + '\'' +
                ", result=" + result +
                '}';
    }
}
