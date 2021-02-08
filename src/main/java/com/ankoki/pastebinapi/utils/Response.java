package com.ankoki.pastebinapi.utils;

public interface Response<T> {
    T get();
    boolean hasError();
    String getError();
}
