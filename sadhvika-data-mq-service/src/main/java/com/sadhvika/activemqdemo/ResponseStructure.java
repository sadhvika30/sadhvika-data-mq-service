package com.sadhvika.activemqdemo.Dto;

public class ResponseStructure<T> {

    private int code;
    private String statusMessage;
    private T result;

    // Constructors
    public ResponseStructure() {}

    public ResponseStructure(int code, String statusMessage, T result) {
        this.code = code;
        this.statusMessage = statusMessage;
        this.result = result;
    }

    // Getters
    public int getCode() {
        return code;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public T getResult() {
        return result;
    }

    // Setters
    public void setCode(int code) {
        this.code = code;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
