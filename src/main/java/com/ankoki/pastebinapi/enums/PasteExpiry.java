package com.ankoki.pastebinapi.enums;

public enum PasteExpiry {
    NEVER("N"),
    ONE_YEAR("1Y"),
    SIX_MONTHS("6M"),
    ONE_MONTH("1M"),
    TWO_WEEKS("2W"),
    ONE_WEEK("1W"),
    ONE_DAY("1D"),
    ONE_HOUR("1H"),
    TEN_MINUTES("10M");
    private final String api;
    PasteExpiry(String api) {
        this.api = api;
    }
    public String getApi() {
        return api;
    }
}