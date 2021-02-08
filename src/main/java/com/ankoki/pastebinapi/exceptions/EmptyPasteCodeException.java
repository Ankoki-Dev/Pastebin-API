package com.ankoki.pastebinapi.exceptions;

public class EmptyPasteCodeException extends Exception {

    public EmptyPasteCodeException() {
        super("The raw text in this paste was empty!");
    }
}
