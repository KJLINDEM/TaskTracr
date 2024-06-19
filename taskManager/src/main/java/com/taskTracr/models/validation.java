package com.taskTracr.models;

/*
 * README: Every web page has the ability for something to be incorrect. 
 * This validation object is used to determine if it is valid and create an associated message.
 */
public class validation {
    private boolean valid; 
    private String message;
    private String redirect;

    public boolean getValid() {
        return valid;
    }
    public void setValid(boolean valid) {
        this.valid = valid;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getRedirect() {
        return redirect;
    }
    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }
}
