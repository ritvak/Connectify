package com.connectify.Connectify_BackEnd.Response;

public class AuthResponse {

    private String toke;

    private String message;

    public AuthResponse()
    {

    }

    public AuthResponse(String toke, String message) {
        super();
        this.toke = toke;
        this.message = message;
    }

    public String getToke() {
        return toke;
    }

    public void setToke(String toke) {
        this.toke = toke;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
