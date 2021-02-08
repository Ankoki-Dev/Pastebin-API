package com.ankoki.pastebinapi.exceptions;

public class NoDeveloperKeyException extends Exception{

    public NoDeveloperKeyException(String message) {
        //"A paste was attempted to be posted without a developer key!"
        //"A paste was attempted to be read without a developer key!"
        super(message);
    }
}
