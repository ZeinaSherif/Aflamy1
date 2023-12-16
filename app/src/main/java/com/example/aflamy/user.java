package com.example.aflamy;

public class user {
    private String fn;
    private String ln;
    private String username;
    private String email;
    private String pass;


    public user(String fn, String ln, String username, String email, String pass) {
        this.fn = fn;
        this.ln = ln;
        this.username = username;
        this.email = email;
        this.pass = pass;
    }

    public String getFn() {
        return fn;
    }

    public String getLn() {
        return ln;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }
}
