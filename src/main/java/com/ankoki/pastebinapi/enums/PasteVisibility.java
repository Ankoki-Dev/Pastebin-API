package com.ankoki.pastebinapi.enums;

public enum PasteVisibility {
    PUBLIC("0"),
    UNLISTED("1"),
    PRIVATE("2");
    private final String api;
    PasteVisibility(String api) {
        this.api = api;
    }
    public String getApi() {
        return api;
    }
}
